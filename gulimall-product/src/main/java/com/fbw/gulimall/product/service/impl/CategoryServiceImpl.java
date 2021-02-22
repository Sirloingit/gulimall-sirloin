package com.fbw.gulimall.product.service.impl;

import com.fbw.gulimall.product.dao.CategoryBrandRelationDao;
import com.fbw.gulimall.product.service.CategoryBrandRelationService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fbw.common.utils.PageUtils;
import com.fbw.common.utils.Query;

import com.fbw.gulimall.product.dao.CategoryDao;
import com.fbw.gulimall.product.entity.CategoryEntity;
import com.fbw.gulimall.product.service.CategoryService;
import org.springframework.transaction.annotation.Transactional;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Autowired
    CategoryBrandRelationService categoryBrandRelationService;


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        //1\查出所有分类
        List<CategoryEntity> entities = baseMapper.selectList(null);

        //组装成父子树形结构
        //找到所有一级分类（parentid == 0）
        List<CategoryEntity> level1Menus = entities.stream().filter((categoryEntity) -> {
            return categoryEntity.getParentCid() == 0;
        }).map(menu -> {
            menu.setChildren(getChildren(menu, entities));
            return menu;
        }).sorted(Comparator.comparingInt(CategoryEntity::getSort)).collect(Collectors.toList());

        return level1Menus;
    }

    @Override
    public void removeMenuByIds(List<Long> asList) {
        //TODO 检查当前删除的菜单是否被别的地方引用

        //逻辑删除
        baseMapper.deleteBatchIds(asList);
    }

    @Override
    public Long[] findCatelogPath(Long catelogId) {
        List<Long> paths = new ArrayList<>();

        findParentPaths(catelogId, paths);

        return paths.toArray(new Long[paths.size()]);
    }

    /**
     * 更新所有关联的数据
     * @param category
     */
    @Transactional
    @Override
    public void updateDetail(CategoryEntity category) {
        this.updateById(category);
        //其他关联的表
        if(!StringUtils.isEmpty(category.getName())){
            categoryBrandRelationService.updataCategory(category.getCatId(), category.getName());
        }
    }

    private void findParentPaths(Long catelogId, List<Long> paths){

        CategoryEntity byId = this.getById(catelogId);
        if(byId.getParentCid() != 0){
            findParentPaths(byId.getParentCid(), paths);
        }
        paths.add(catelogId);

    }

    private List<CategoryEntity> getChildren(CategoryEntity root, List<CategoryEntity> all){
        List<CategoryEntity> children = all.stream().filter(categoryEntity -> {
            return categoryEntity.getParentCid() == root.getCatId();
        }).map(entity -> {
            //再次找到子菜单
            entity.setChildren(getChildren(entity, all));
            return entity;
        }).sorted(Comparator.comparingInt(m -> (m.getSort() == null ? 0 : m.getSort()))).collect(Collectors.toList());

        return children;

    }

}
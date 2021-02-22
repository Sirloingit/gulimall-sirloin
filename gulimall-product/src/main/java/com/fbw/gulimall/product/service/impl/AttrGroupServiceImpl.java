package com.fbw.gulimall.product.service.impl;

import com.fbw.gulimall.product.entity.AttrEntity;
import com.fbw.gulimall.product.service.AttrService;
import com.fbw.gulimall.product.vo.AttrGroupRelationVo;
import com.fbw.gulimall.product.vo.AttrGroupWithAttrVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fbw.common.utils.PageUtils;
import com.fbw.common.utils.Query;

import com.fbw.gulimall.product.dao.AttrGroupDao;
import com.fbw.gulimall.product.entity.AttrGroupEntity;
import com.fbw.gulimall.product.service.AttrGroupService;


@Service("attrGroupService")
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupDao, AttrGroupEntity> implements AttrGroupService {
    @Autowired
    private AttrService attrService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AttrGroupEntity> page = this.page(
                new Query<AttrGroupEntity>().getPage(params),
                new QueryWrapper<AttrGroupEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Long catelogId) {

        String key = (String) params.get("key");

        //SELECT ? FROM pms_attr_group WHERE (catelog_id = ? AND ( (attr_group_id = ? OR attr_group_name LIKE ?) ))
        QueryWrapper<AttrGroupEntity> wrapper = new QueryWrapper<AttrGroupEntity>();

        if(!StringUtils.isEmpty(key)){
            wrapper.and((obj) -> {
                obj.eq("attr_group_id", key).or().like("attr_group_name", key);
            });
        }

        if(catelogId == 0){
            IPage<AttrGroupEntity> page = this.page(new Query<AttrGroupEntity>().getPage(params),
                    wrapper);
            return new PageUtils(page);
        }else{
            wrapper.eq("catelog_id", catelogId);
            IPage<AttrGroupEntity> page = this.page(new Query<AttrGroupEntity>().getPage(params), wrapper);
            return new PageUtils(page);
        }

    }

    /**
     * 根据分类id 查出所有的属性分组及这些组里的属性
     * @param catelogId
     * @return
     */
    @Override
    public List<AttrGroupWithAttrVo> getAttrGroupWithAttrsByCatelogId(Long catelogId) {
        //查询分组信息
        List<AttrGroupEntity> attrGroupEntities = this.list(new QueryWrapper<AttrGroupEntity>().eq("catelog_id", catelogId));
        //查询所有属性
        List<AttrGroupWithAttrVo> collect = attrGroupEntities.stream().map(group -> {
            AttrGroupWithAttrVo attrGroupRelationVo = new AttrGroupWithAttrVo();
            BeanUtils.copyProperties(group, attrGroupRelationVo);
            List<AttrEntity> relationAttr = attrService.getRelationAttr(group.getAttrGroupId());
            attrGroupRelationVo.setAttrs(relationAttr);
            return attrGroupRelationVo;
        }).collect(Collectors.toList());

        return collect;
    }

}
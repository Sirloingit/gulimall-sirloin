package com.fbw.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fbw.common.utils.PageUtils;
import com.fbw.gulimall.product.entity.CategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author sirloin
 * @email sunlightcs@gmail.com
 * @date 2021-02-03 21:53:40
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<CategoryEntity> listWithTree();

    void removeMenuByIds(List<Long> asList);

    //找到catelogId的完整路径
    Long[] findCatelogPath(Long catelogId);

    void updateDetail(CategoryEntity category);
}


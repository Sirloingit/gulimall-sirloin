package com.fbw.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fbw.common.utils.PageUtils;
import com.fbw.gulimall.product.entity.CategoryEntity;

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
}

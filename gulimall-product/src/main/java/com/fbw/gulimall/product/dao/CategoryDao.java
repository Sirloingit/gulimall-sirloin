package com.fbw.gulimall.product.dao;

import com.fbw.gulimall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author sirloin
 * @email sunlightcs@gmail.com
 * @date 2021-02-03 21:53:40
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}

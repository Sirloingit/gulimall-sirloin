package com.fbw.gulimall.coupon.dao;

import com.fbw.gulimall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author sirloin
 * @email sunlightcs@gmail.com
 * @date 2021-02-04 11:02:42
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}

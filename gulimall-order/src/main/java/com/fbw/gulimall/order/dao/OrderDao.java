package com.fbw.gulimall.order.dao;

import com.fbw.gulimall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author sirloin
 * @email sunlightcs@gmail.com
 * @date 2021-02-04 11:36:52
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}

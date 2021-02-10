package com.fbw.gulimall.order.dao;

import com.fbw.gulimall.order.entity.RefundInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 退款信息
 * 
 * @author sirloin
 * @email sunlightcs@gmail.com
 * @date 2021-02-04 11:36:51
 */
@Mapper
public interface RefundInfoDao extends BaseMapper<RefundInfoEntity> {
	
}

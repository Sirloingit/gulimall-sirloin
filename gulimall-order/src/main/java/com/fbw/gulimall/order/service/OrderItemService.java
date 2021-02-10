package com.fbw.gulimall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fbw.common.utils.PageUtils;
import com.fbw.gulimall.order.entity.OrderItemEntity;

import java.util.Map;

/**
 * 订单项信息
 *
 * @author sirloin
 * @email sunlightcs@gmail.com
 * @date 2021-02-04 11:36:52
 */
public interface OrderItemService extends IService<OrderItemEntity> {

    PageUtils queryPage(Map<String, Object> params);
}


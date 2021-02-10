package com.fbw.gulimall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fbw.common.utils.PageUtils;
import com.fbw.gulimall.ware.entity.WareOrderTaskEntity;

import java.util.Map;

/**
 * 库存工作单
 *
 * @author sirloin
 * @email sunlightcs@gmail.com
 * @date 2021-02-04 11:38:52
 */
public interface WareOrderTaskService extends IService<WareOrderTaskEntity> {

    PageUtils queryPage(Map<String, Object> params);
}


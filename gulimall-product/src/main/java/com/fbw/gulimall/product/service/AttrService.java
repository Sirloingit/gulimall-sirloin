package com.fbw.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fbw.common.utils.PageUtils;
import com.fbw.gulimall.product.entity.AttrEntity;
import com.fbw.gulimall.product.vo.AttrGroupRelationVo;
import com.fbw.gulimall.product.vo.AttrRespVo;
import com.fbw.gulimall.product.vo.AttrVo;

import java.util.List;
import java.util.Map;

/**
 * 商品属性
 *
 * @author sirloin
 * @email sunlightcs@gmail.com
 * @date 2021-02-03 21:53:41
 */
public interface AttrService extends IService<AttrEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveAttrVO(AttrVo attr);

    PageUtils queryBastAttrPage(Map<String, Object> params, Long catelogId, String type);

    AttrRespVo getAttrInfo(Long attrId);

    void updateAttr(AttrVo attr);

    List<AttrEntity> getRelationAttr(Long attrgroupId);

    void deleteRelation(AttrGroupRelationVo[] vos);

    PageUtils getNoRelationAttr(Map<String, Object> params, Long attrgroupId);
}


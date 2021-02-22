package com.fbw.gulimall.product.vo;


import com.fbw.gulimall.product.entity.AttrEntity;
import lombok.Data;

import java.util.List;

/**
 * @author Sirloin
 * @Date 2021-02-2021/2/22-12:26
 */
@Data
public class AttrGroupWithAttrVo {

    /**
     * 分组id
     */

    private Long attrGroupId;
    /**
     * 组名
     */
    private String attrGroupName;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 描述
     */
    private String descript;
    /**
     * 组图标
     */
    private String icon;
    /**
     * 所属分类id
     */
    private Long catelogId;

    private List<AttrEntity> attrs;


}

package com.fbw.gulimall.member.dao;

import com.fbw.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author sirloin
 * @email sunlightcs@gmail.com
 * @date 2021-02-04 11:20:33
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}

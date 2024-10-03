package com.study.hello.distributed.mybatis.apiserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.hello.distributed.mybatis.apiserver.entity.MemberPo;
import org.apache.ibatis.annotations.Mapper;

/**
* @author fangxiangqian
* @description 针对表【t_member(会员表)】的数据库操作Mapper
* @createDate 2024-10-01 20:50:04
* @Entity com.study.hello.distributed.mybatis.apiserver.entity.MemberPo
*/
@Mapper
public interface MemberMapper extends BaseMapper<MemberPo> {

}





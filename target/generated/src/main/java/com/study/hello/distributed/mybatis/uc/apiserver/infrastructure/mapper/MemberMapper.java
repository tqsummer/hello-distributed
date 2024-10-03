package com.study.hello.distributed.mybatis.uc.apiserver.infrastructure.mapper;

import com.study.hello.distributed.mybatis.uc.apiserver.infrastructure.entity.Member;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 会员表 Mapper 接口
 * </p>
 *
 * @author fangxiagnqian
 * @since 2024-10-02
 */
@Mapper
public interface MemberMapper extends BaseMapper<Member> {

}

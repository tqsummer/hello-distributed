package com.study.hello.distributed.mybatis.uc.apiserver.infrastructure.mapper;

import com.study.hello.distributed.mybatis.uc.apiserver.infrastructure.entity.MemberKyc;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 会员实名认证表 Mapper 接口
 * </p>
 *
 * @author fangxiagnqian
 * @since 2024-10-02
 */
@Mapper
public interface MemberKycMapper extends BaseMapper<MemberKyc> {

}

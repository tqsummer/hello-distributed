package com.study.hello.distributed.mybatis.apiserver.infrastructure.mapper;

import com.study.hello.distributed.mybatis.apiserver.infrastructure.po.MemberPo;
import com.study.hello.distributed.mybatis.framework.core.ddd.infrastructure.persistence.mapper.AbstractMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 会员表 Mapper 接口
 * </p>
 *
 * @author fangxiagnqian
 * @since 2024-10-09
 */
@Mapper
public interface MemberPoMapper extends AbstractMapper<MemberPo> {

}

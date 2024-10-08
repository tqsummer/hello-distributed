package com.study.hello.distributed.mybatis.apiserver.infrastructure.mapper;

import com.study.hello.distributed.mybatis.apiserver.infrastructure.po.MemberPo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 会员表 Mapper 接口
 * </p>
 *
 * @author fangxiagnqian
 * @since 2024-10-08
 */
@Mapper
public interface MemberPoMapper extends BaseMapper<MemberPo> {

}

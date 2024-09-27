package com.study.hello.distributed.mybatis.infrastructure.mapper;

import com.study.hello.distributed.mybatis.domain.entity.Oauth2User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author fangxiagnqian
 * @since 2024-09-23
 */
@Mapper
public interface Oauth2UserMapper extends BaseMapper<Oauth2User> {

}

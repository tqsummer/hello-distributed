package com.study.hello.distributed.mybatis.domain.service.impl;

import com.study.hello.distributed.mybatis.domain.entity.Oauth2User;
import com.study.hello.distributed.mybatis.infrastructure.mapper.Oauth2UserMapper;
import com.study.hello.distributed.mybatis.domain.service.IOauth2UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author fangxiagnqian
 * @since 2024-09-23
 */
@Service
public class Oauth2UserServiceImpl extends ServiceImpl<Oauth2UserMapper, Oauth2User> implements IOauth2UserService {

}

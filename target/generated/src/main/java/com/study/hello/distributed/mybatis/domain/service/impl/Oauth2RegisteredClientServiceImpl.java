package com.study.hello.distributed.mybatis.domain.service.impl;

import com.study.hello.distributed.mybatis.domain.entity.Oauth2RegisteredClient;
import com.study.hello.distributed.mybatis.infrastructure.mapper.Oauth2RegisteredClientMapper;
import com.study.hello.distributed.mybatis.domain.service.IOauth2RegisteredClientService;
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
public class Oauth2RegisteredClientServiceImpl extends ServiceImpl<Oauth2RegisteredClientMapper, Oauth2RegisteredClient> implements IOauth2RegisteredClientService {

}

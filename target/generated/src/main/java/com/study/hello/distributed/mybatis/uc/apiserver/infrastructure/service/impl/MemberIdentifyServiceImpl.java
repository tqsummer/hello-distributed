package com.study.hello.distributed.mybatis.uc.apiserver.infrastructure.service.impl;

import com.study.hello.distributed.mybatis.uc.apiserver.infrastructure.entity.MemberIdentify;
import com.study.hello.distributed.mybatis.uc.apiserver.infrastructure.mapper.MemberIdentifyMapper;
import com.study.hello.distributed.mybatis.uc.apiserver.infrastructure.service.IMemberIdentifyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 会员标识表 服务实现类
 * </p>
 *
 * @author fangxiagnqian
 * @since 2024-10-02
 */
@Service
public class MemberIdentifyServiceImpl extends ServiceImpl<MemberIdentifyMapper, MemberIdentify> implements IMemberIdentifyService {

}

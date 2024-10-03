package com.study.hello.distributed.mybatis.uc.apiserver.infrastructure.service.impl;

import com.study.hello.distributed.mybatis.uc.apiserver.infrastructure.entity.MemberKyc;
import com.study.hello.distributed.mybatis.uc.apiserver.infrastructure.mapper.MemberKycMapper;
import com.study.hello.distributed.mybatis.uc.apiserver.infrastructure.service.IMemberKycService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 会员实名认证表 服务实现类
 * </p>
 *
 * @author fangxiagnqian
 * @since 2024-10-02
 */
@Service
public class MemberKycServiceImpl extends ServiceImpl<MemberKycMapper, MemberKyc> implements IMemberKycService {

}

package com.study.hello.distributed.mybatis.uc.apiserver.infrastructure.service.impl;

import com.study.hello.distributed.mybatis.uc.apiserver.infrastructure.entity.MemberFamily;
import com.study.hello.distributed.mybatis.uc.apiserver.infrastructure.mapper.MemberFamilyMapper;
import com.study.hello.distributed.mybatis.uc.apiserver.infrastructure.service.IMemberFamilyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 家属表 服务实现类
 * </p>
 *
 * @author fangxiagnqian
 * @since 2024-10-02
 */
@Service
public class MemberFamilyServiceImpl extends ServiceImpl<MemberFamilyMapper, MemberFamily> implements IMemberFamilyService {

}

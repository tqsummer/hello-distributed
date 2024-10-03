package com.study.hello.distributed.mybatis.uc.apiserver.infrastructure.service.impl;

import com.study.hello.distributed.mybatis.uc.apiserver.infrastructure.entity.Member;
import com.study.hello.distributed.mybatis.uc.apiserver.infrastructure.mapper.MemberMapper;
import com.study.hello.distributed.mybatis.uc.apiserver.infrastructure.service.IMemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 会员表 服务实现类
 * </p>
 *
 * @author fangxiagnqian
 * @since 2024-10-02
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements IMemberService {

}

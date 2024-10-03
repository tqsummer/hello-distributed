package com.study.hello.distributed.mybatis.apiserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.hello.distributed.mybatis.apiserver.entity.MemberPo;
import com.study.hello.distributed.mybatis.apiserver.service.MemberService;
import com.study.hello.distributed.mybatis.apiserver.mapper.MemberMapper;
import org.springframework.stereotype.Service;

/**
* @author fangxiangqian
* @description 针对表【t_member(会员表)】的数据库操作Service实现
* @createDate 2024-10-01 20:50:04
*/
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, MemberPo>
    implements MemberService{

}





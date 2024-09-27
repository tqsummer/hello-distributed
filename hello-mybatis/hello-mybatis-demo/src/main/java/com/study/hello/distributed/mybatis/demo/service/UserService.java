package com.study.hello.distributed.mybatis.demo.service;

import com.study.hello.distributed.mybatis.demo.entity.User;
import com.study.hello.distributed.mybatis.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User getUser(Long id) {
        return userMapper.selectById(id);
    }
}

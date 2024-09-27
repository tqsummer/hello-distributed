package com.study.hello.distributed.mybatis.demo.test;

import com.study.hello.distributed.mybatis.demo.HelloMybatisDemoApplication;
import com.study.hello.distributed.mybatis.demo.entity.User;
import com.study.hello.distributed.mybatis.demo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;


// 测试类
@SpringBootTest(classes = HelloMybatisDemoApplication.class)
@ActiveProfiles("test")
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert() {
        User user = new User();
        user.setUsername("test");
        user.setPassword("123456");
        user.setRoles("admins");
        userMapper.insert(user);
    }
}


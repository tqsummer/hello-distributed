package com.study.hello.distributed.mybatis.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.hello.distributed.mybatis.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}

package com.study.hello.distributed.mybatis.demo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.study.hello.distributed.mybatis.demo.mapper")
public class MybatisPlusConfig {
    // 其他配置（如果需要）
}
package com.study.hello.distributed.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fangxiangqian
 */
@Controller
@RequestMapping("/redis/cluster")
public class HelloRedisClusterController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        stringRedisTemplate.opsForValue().set("k1-StringRedisTemplate", "v1-StringRedisTemplate");

        return stringRedisTemplate.opsForValue().get("k1-StringRedisTemplate");
    }
}

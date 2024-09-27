package com.study.hello.distributed.mybatis.client.api;

import com.study.hello.distributed.mybatis.domain.entity.Oauth2User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "oauth2User-service")
public interface Oauth2UserApi {

    @GetMapping("/oauth2User/{id}")
    Oauth2User getById(@PathVariable("id") Long id);

    @GetMapping("/oauth2User")
    List<Oauth2User> list();

    @PostMapping("/oauth2User")
    boolean save(@RequestBody Oauth2User oauth2User);

    @PutMapping("/oauth2User")
    boolean update(@RequestBody Oauth2User oauth2User);

    @DeleteMapping("/oauth2User/{id}")
    boolean removeById(@PathVariable("id") Long id);
}
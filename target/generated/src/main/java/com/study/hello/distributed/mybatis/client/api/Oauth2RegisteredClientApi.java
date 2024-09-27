package com.study.hello.distributed.mybatis.client.api;

import com.study.hello.distributed.mybatis.domain.entity.Oauth2RegisteredClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "oauth2RegisteredClient-service")
public interface Oauth2RegisteredClientApi {

    @GetMapping("/oauth2RegisteredClient/{id}")
    Oauth2RegisteredClient getById(@PathVariable("id") Long id);

    @GetMapping("/oauth2RegisteredClient")
    List<Oauth2RegisteredClient> list();

    @PostMapping("/oauth2RegisteredClient")
    boolean save(@RequestBody Oauth2RegisteredClient oauth2RegisteredClient);

    @PutMapping("/oauth2RegisteredClient")
    boolean update(@RequestBody Oauth2RegisteredClient oauth2RegisteredClient);

    @DeleteMapping("/oauth2RegisteredClient/{id}")
    boolean removeById(@PathVariable("id") Long id);
}
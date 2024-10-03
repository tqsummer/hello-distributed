package com.study.hello.distributed.mybatis.uc.apiserver.client.api;

import com.study.hello.distributed.mybatis.uc.apiserver.infrastructure.entity.MemberIdentify;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "member-identify-service")
public interface MemberIdentifyApi {

    @GetMapping("/member-identify/{id}")
    MemberIdentify getById(@PathVariable("id") Long id);

    @GetMapping("/member-identify")
    List<MemberIdentify> list();

    @PostMapping("/member-identify")
    boolean save(@RequestBody MemberIdentify memberIdentify);

    @PutMapping("/member-identify")
    boolean update(@RequestBody MemberIdentify memberIdentify);

    @DeleteMapping("/member-identify/{id}")
    boolean removeById(@PathVariable("id") Long id);
}
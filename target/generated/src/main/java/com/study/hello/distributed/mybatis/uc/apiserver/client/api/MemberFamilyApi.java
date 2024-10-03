package com.study.hello.distributed.mybatis.uc.apiserver.client.api;

import com.study.hello.distributed.mybatis.uc.apiserver.infrastructure.entity.MemberFamily;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "member-family-service")
public interface MemberFamilyApi {

    @GetMapping("/member-family/{id}")
    MemberFamily getById(@PathVariable("id") Long id);

    @GetMapping("/member-family")
    List<MemberFamily> list();

    @PostMapping("/member-family")
    boolean save(@RequestBody MemberFamily memberFamily);

    @PutMapping("/member-family")
    boolean update(@RequestBody MemberFamily memberFamily);

    @DeleteMapping("/member-family/{id}")
    boolean removeById(@PathVariable("id") Long id);
}
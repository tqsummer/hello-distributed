package com.study.hello.distributed.mybatis.uc.apiserver.client.api;

import com.study.hello.distributed.mybatis.uc.apiserver.infrastructure.entity.Member;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "member-service")
public interface MemberApi {

    @GetMapping("/member/{id}")
    Member getById(@PathVariable("id") Long id);

    @GetMapping("/member")
    List<Member> list();

    @PostMapping("/member")
    boolean save(@RequestBody Member member);

    @PutMapping("/member")
    boolean update(@RequestBody Member member);

    @DeleteMapping("/member/{id}")
    boolean removeById(@PathVariable("id") Long id);
}
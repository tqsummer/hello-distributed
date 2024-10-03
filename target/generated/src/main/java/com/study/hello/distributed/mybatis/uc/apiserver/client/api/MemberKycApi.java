package com.study.hello.distributed.mybatis.uc.apiserver.client.api;

import com.study.hello.distributed.mybatis.uc.apiserver.infrastructure.entity.MemberKyc;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "member-kyc-service")
public interface MemberKycApi {

    @GetMapping("/member-kyc/{id}")
    MemberKyc getById(@PathVariable("id") Long id);

    @GetMapping("/member-kyc")
    List<MemberKyc> list();

    @PostMapping("/member-kyc")
    boolean save(@RequestBody MemberKyc memberKyc);

    @PutMapping("/member-kyc")
    boolean update(@RequestBody MemberKyc memberKyc);

    @DeleteMapping("/member-kyc/{id}")
    boolean removeById(@PathVariable("id") Long id);
}
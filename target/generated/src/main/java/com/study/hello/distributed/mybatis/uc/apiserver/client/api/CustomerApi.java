package com.study.hello.distributed.mybatis.uc.apiserver.client.api;

import com.study.hello.distributed.mybatis.uc.apiserver.infrastructure.entity.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "customer-service")
public interface CustomerApi {

    @GetMapping("/customer/{id}")
    Customer getById(@PathVariable("id") Long id);

    @GetMapping("/customer")
    List<Customer> list();

    @PostMapping("/customer")
    boolean save(@RequestBody Customer customer);

    @PutMapping("/customer")
    boolean update(@RequestBody Customer customer);

    @DeleteMapping("/customer/{id}")
    boolean removeById(@PathVariable("id") Long id);
}
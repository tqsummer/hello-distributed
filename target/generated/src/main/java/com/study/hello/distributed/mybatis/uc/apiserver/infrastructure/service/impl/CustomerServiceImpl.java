package com.study.hello.distributed.mybatis.uc.apiserver.infrastructure.service.impl;

import com.study.hello.distributed.mybatis.uc.apiserver.infrastructure.entity.Customer;
import com.study.hello.distributed.mybatis.uc.apiserver.infrastructure.mapper.CustomerMapper;
import com.study.hello.distributed.mybatis.uc.apiserver.infrastructure.service.ICustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 客户表 服务实现类
 * </p>
 *
 * @author fangxiagnqian
 * @since 2024-10-02
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements ICustomerService {

}

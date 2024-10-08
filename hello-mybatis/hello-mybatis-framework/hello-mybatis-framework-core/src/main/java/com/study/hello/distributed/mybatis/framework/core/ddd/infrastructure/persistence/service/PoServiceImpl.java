package com.study.hello.distributed.mybatis.framework.core.ddd.infrastructure.persistence.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.hello.distributed.mybatis.framework.core.ddd.infrastructure.persistence.mapper.AbstractMapper;

public class PoServiceImpl<M extends AbstractMapper<T>, T> extends ServiceImpl<M, T> implements IPoService<T> {
}

package com.study.hello.distributed.mybatis.framework.commons.api;

import com.study.hello.distributed.mybatis.framework.commons.util.JsonUtils;

import java.io.Serializable;

public class ApiObject implements Serializable {
    private static final long serialVersionUID = 1L;

    public ApiObject() {
    }

    public String toString() {
        return JsonUtils.toJsonString(this);
    }
}

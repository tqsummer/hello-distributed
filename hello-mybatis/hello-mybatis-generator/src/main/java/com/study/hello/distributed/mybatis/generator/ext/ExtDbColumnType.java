package com.study.hello.distributed.mybatis.generator.ext;

import com.baomidou.mybatisplus.generator.config.rules.IColumnType;

public enum ExtDbColumnType implements IColumnType {
    // 扩展类型
    Gender("Gender", "test.enums.Gender");

    /**
     * 类型
     */
    private final String type;

    /**
     * 包路径
     */
    private final String pkg;

    ExtDbColumnType(final String type, final String pkg) {
        this.type = type;
        this.pkg = pkg;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getPkg() {
        return pkg;
    }
}


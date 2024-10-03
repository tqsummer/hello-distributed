package com.study.hello.distributed.mybatis.framework.core.mybatis.handlers;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import org.apache.ibatis.reflection.MetaObject;

import java.time.LocalDateTime;

public class BizMetaObjectHandler implements MetaObjectHandler {
    private final static Long defaultOperatorId = -1L;
    private final static String defaultOperatorName = "系统";

    @Override
    public void insertFill(MetaObject metaObject) {
        Object id = getFieldValByName("id", metaObject);
        if (id == null) {
            setFieldValByName("id", IdWorker.getId(), metaObject);
        }
        Object createTime = getFieldValByName("createTime", metaObject);
        if (createTime == null) {
            setFieldValByName("createTime", LocalDateTime.now(), metaObject);
        }
        Object createUserId = getFieldValByName("createUserId", metaObject);
        if (createUserId == null) {
            setFieldValByName("createUserId", defaultOperatorId, metaObject);
        }
        Object createUserName = getFieldValByName("createUserName", metaObject);
        if (createUserName == null) {
            setFieldValByName("createUserName", defaultOperatorName, metaObject);
        }
        Object modifyTime = getFieldValByName("modifyTime", metaObject);
        if (modifyTime == null) {
            setFieldValByName("modifyTime", LocalDateTime.now(), metaObject);
        }
        Object modifyUserId = getFieldValByName("modifyUserId", metaObject);
        if (modifyUserId == null) {
            setFieldValByName("modifyUserId", defaultOperatorId, metaObject);
        }
        Object modifyUserName = getFieldValByName("modifyUserName", metaObject);
        if (modifyUserName == null) {
            setFieldValByName("modifyUserName", defaultOperatorName, metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        setFieldValByName("modifyTime", LocalDateTime.now(), metaObject);

        // 检查 modifyUserId 是否被更新
        if (!metaObject.hasSetter("modifyUserId") || getFieldValByName("modifyUserId", metaObject) == null) {
            setFieldValByName("modifyUserId", defaultOperatorId, metaObject);
        }

        // 检查 modifyUserName 是否被更新
        if (!metaObject.hasSetter("modifyUserName") || getFieldValByName("modifyUserName", metaObject) == null) {
            setFieldValByName("modifyUserName", defaultOperatorName, metaObject);
        }
    }
}

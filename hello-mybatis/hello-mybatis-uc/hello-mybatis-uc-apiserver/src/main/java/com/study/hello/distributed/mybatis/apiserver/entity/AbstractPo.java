//package com.study.hello.distributed.mybatis.apiserver.entity;
//
//import com.baomidou.mybatisplus.annotation.*;
//import lombok.Getter;
//import lombok.Setter;
//
//import java.io.Serializable;
//import java.time.LocalDateTime;
//
//@Getter
//@Setter
//public abstract class AbstractPo implements Serializable {
//
//    public static final String ID = "id";
//    public static final String CREATE_USER_ID = "create_user_id";
//    public static final String CREATE_USER_NAME = "create_user_name";
//    public static final String CREATE_TIME = "create_time";
//    public static final String MODIFY_USER_ID = "modify_user_id";
//    public static final String MODIFY_USER_NAME = "modify_user_name";
//    public static final String MODIFY_TIME = "modify_time";
//    public static final String VERSION = "version";
//    public static final String DELETED = "deleted";
//
//    @TableId(value = "id", type = IdType.INPUT)
//    protected Long id;
//
//    @TableField(fill = FieldFill.INSERT)
//    protected Long createUserId;
//
//    @TableField(fill = FieldFill.INSERT)
//    protected String createUserName;
//
//    @TableField(fill = FieldFill.INSERT, insertStrategy = FieldStrategy.NOT_NULL)
//    protected LocalDateTime createTime;
//
//    @TableField(fill = FieldFill.INSERT_UPDATE)
//    protected Long modifyUserId;
//
//    @TableField(fill = FieldFill.INSERT_UPDATE)
//    protected String modifyUserName;
//
//    @TableField(fill = FieldFill.INSERT_UPDATE, insertStrategy = FieldStrategy.NOT_NULL)
//    protected LocalDateTime modifyTime;
//
//    @Version
//    protected Integer version;
//
//    @TableLogic
//    protected Boolean deleted;
//}

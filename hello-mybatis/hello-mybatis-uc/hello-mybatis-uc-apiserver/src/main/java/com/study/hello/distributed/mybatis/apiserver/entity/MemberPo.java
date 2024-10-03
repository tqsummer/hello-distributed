package com.study.hello.distributed.mybatis.apiserver.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.study.hello.distributed.mybatis.framework.core.ddd.infrastructure.persistence.po.AbstractPo;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * 会员表
 *
 * @TableName t_member
 */
@TableName(value = "t_member")
@Data
public class MemberPo extends AbstractPo implements Serializable {
    /**
     * 昵称
     */
    @TableField(value = "nick_name")
    private String nickName;

    /**
     * 头像URL
     */
    private String avatarUrl;

    /**
     * 性别
     */
    private String gender;

    /**
     * 生日
     */
    private LocalDate birthday;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 会员等级
     */
    private Integer level;

    /**
     * 会员状态
     */
    private String status;


}
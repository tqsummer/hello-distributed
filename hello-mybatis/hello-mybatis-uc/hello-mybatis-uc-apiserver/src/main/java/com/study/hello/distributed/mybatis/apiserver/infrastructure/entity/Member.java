package com.study.hello.distributed.mybatis.apiserver.infrastructure.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.study.hello.distributed.mybatis.framework.core.ddd.infrastructure.persistence.po.AbstractPo;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 会员表
 * </p>
 *
 * @author fangxiagnqian
 * @since 2024-10-09
 */
@Getter
@Setter
@TableName("t_member")
public class Member extends AbstractPo {

    private static final long serialVersionUID = 1L;

    /**
     * 昵称
     */
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
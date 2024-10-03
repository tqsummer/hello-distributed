package com.study.hello.distributed.mybatis.uc.apiserver.client.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * <p>
 * 会员表
 * </p>
 *
 * @author fangxiagnqian
 * @since 2024-10-02
 */
@Data
public class MemberDTO implements Serializable {

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
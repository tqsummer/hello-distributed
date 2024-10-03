package com.study.hello.distributed.mybatis.uc.apiserver.client.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 会员实名认证表
 * </p>
 *
 * @author fangxiagnqian
 * @since 2024-10-02
 */
@Data
public class MemberKycDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 会员ID
     */
    private Long memberId;

    /**
     * 姓名
     */
    private String name;

    /**
     * 姓名hash
     */
    private String nameHash;

    /**
     * 证件类型
     */
    private String certType;

    /**
     * 证件号
     */
    private String certNo;

    /**
     * 身份证hash
     */
    private String certNoHash;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 手机号hash
     */
    private String phoneHash;

    /**
     * 认证状态
     */
    private String status;

}
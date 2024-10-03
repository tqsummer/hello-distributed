package com.study.hello.distributed.mybatis.uc.apiserver.client.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 家属表
 * </p>
 *
 * @author fangxiagnqian
 * @since 2024-10-02
 */
@Data
public class MemberFamilyDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 会员ID
     */
    private Long memberId;

    /**
     * 客户ID
     */
    private Long customerId;

    /**
     * 亲属关系
     */
    private String kinshipType;

    /**
     * 亲属姓名
     */
    private String name;

    /**
     * 身份证
     */
    private String idCard;

    /**
     * 手机号
     */
    private String phone;

}
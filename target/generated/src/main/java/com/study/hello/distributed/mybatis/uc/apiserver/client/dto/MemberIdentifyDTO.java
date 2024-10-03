package com.study.hello.distributed.mybatis.uc.apiserver.client.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 会员标识表
 * </p>
 *
 * @author fangxiagnqian
 * @since 2024-10-02
 */
@Data
public class MemberIdentifyDTO implements Serializable {

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
     * 标识类型
     */
    private String type;

    /**
     * 来源信息
     */
    private String source;

}
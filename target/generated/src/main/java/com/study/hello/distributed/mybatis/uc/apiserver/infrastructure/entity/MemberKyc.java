package com.study.hello.distributed.mybatis.uc.apiserver.infrastructure.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.study.hello.distributed.mybatis.framework.ddd.infrastructure.persistence.po.AbstractPo;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 会员实名认证表
 * </p>
 *
 * @author fangxiagnqian
 * @since 2024-10-02
 */
@Getter
@Setter
@TableName("t_member_kyc")
public class MemberKyc extends AbstractPo {

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
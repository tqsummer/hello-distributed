package com.study.hello.distributed.mybatis.uc.apiserver.infrastructure.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.study.hello.distributed.mybatis.framework.ddd.infrastructure.persistence.po.AbstractPo;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 家属表
 * </p>
 *
 * @author fangxiagnqian
 * @since 2024-10-02
 */
@Getter
@Setter
@TableName("t_member_family")
public class MemberFamily extends AbstractPo {

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
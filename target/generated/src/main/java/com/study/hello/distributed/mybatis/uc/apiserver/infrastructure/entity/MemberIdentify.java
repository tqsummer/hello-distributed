package com.study.hello.distributed.mybatis.uc.apiserver.infrastructure.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.study.hello.distributed.mybatis.framework.ddd.infrastructure.persistence.po.AbstractPo;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 会员标识表
 * </p>
 *
 * @author fangxiagnqian
 * @since 2024-10-02
 */
@Getter
@Setter
@TableName("t_member_identify")
public class MemberIdentify extends AbstractPo {

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
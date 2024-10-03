package com.study.hello.distributed.mybatis.uc.apiserver.infrastructure.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.study.hello.distributed.mybatis.framework.ddd.infrastructure.persistence.po.AbstractPo;
import java.io.Serializable;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 客户表
 * </p>
 *
 * @author fangxiagnqian
 * @since 2024-10-02
 */
@Getter
@Setter
@TableName("t_customer")
public class Customer extends AbstractPo {

    private static final long serialVersionUID = 1L;

    /**
     * 姓名
     */
    private String name;

    /**
     * 姓名hash
     */
    private String nameHash;

    /**
     * 性别
     */
    private String gender;

    /**
     * 头像URL
     */
    private String avatarUrl;

    /**
     * 生日
     */
    private LocalDate birthday;

    /**
     * 身份证
     */
    private String idCard;

    /**
     * 身份证hash
     */
    private String idCardHash;

    /**
     * 婚姻状况
     */
    private String maritalStatus;

    /**
     * 联系方式
     */
    private String contactDetails;

    /**
     * 居住状况
     */
    private String livingSituation;

    /**
     * 家庭住址
     */
    private String homeAddress;

    /**
     * 所属服务社区
     */
    private String serviceCommunity;

    /**
     * 服务状态
     */
    private String serviceStatus;

    /**
     * 服务类型
     */
    private String serviceType;

    /**
     * 客户来源
     */
    private String source;

    /**
     * 来源ID
     */
    private Long sourceId;
}
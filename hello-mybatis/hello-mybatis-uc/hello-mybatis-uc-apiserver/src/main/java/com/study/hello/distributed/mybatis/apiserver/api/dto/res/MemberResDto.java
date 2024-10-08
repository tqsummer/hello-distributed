package com.study.hello.distributed.mybatis.apiserver.api.dto.res;

import lombok.Data;
import com.study.hello.distributed.mybatis.framework.commons.api.dto.AbstractResDto;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
* <p>
    * 会员表
    * </p>
*
* @author fangxiagnqian
* @since 2024-10-09
*/
@Data
public class MemberResDto extends AbstractResDto {
private static final long serialVersionUID = 1L;

        /**
        * 会员ID
        */
    private Long id;

        /**
        * 创建时间
        */
    private LocalDateTime createTime;

        /**
        * 创建者ID
        */
    private Long createUserId;

        /**
        * 创建者用户名
        */
    private String createUserName;

        /**
        * 修改时间
        */
    private LocalDateTime modifyTime;

        /**
        * 修改者ID
        */
    private Long modifyUserId;

        /**
        * 修改者用户名
        */
    private String modifyUserName;

        /**
        * 是否删除
        */
    private Boolean deleted;

        /**
        * 版本号
        */
    private Integer version;

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
package com.study.hello.distributed.mybatis.client.dto;

import lombok.Data;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author fangxiagnqian
 * @since 2024-09-23
 */
@Data
public class Oauth2UserDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String password;

    private String roles;

    private String username;

}
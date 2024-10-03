package com.study.hello.distributed.mybatis.framework.commons.api;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import com.study.hello.distributed.mybatis.framework.commons.api.constants.SysConstants;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "请求响应对象")
@JsonPropertyOrder({"code", "msg", "data"})
public class ApiResult<T> extends ApiObject {

    private static final long serialVersionUID = 1L;

    @JsonProperty(index = 10)
    @ApiModelProperty(value = "业务返回码，200表示成功（接收2xx系列）", example = "200", position = 10, required = true)
    private int code;

    @JsonProperty(index = 20)
    @ApiModelProperty(value = "业务消息提示", example = "ok", position = 20, required = true)
    private String msg;

    @JsonProperty(index = 30)
    @ApiModelProperty(value = "业务数据对象", position = 10, required = false)
    private T data;

    @JsonIgnore
    public boolean isOk() {
        return code >= 200 && code <= 208;
    }

    public static <T> ApiResult<T> ok(T data) {
        return new ApiResult<>(200, "ok", data);
    }

    public static <T> ApiResult<T> created(T data) {
        return new ApiResult<>(201, "created", data);
    }

    public static <T> ApiResult<T> accepted(T data) {
        return new ApiResult<>(202, "accepted", data);
    }

    public static <T> ApiResult<T> fail(int code, String msg) {
        return new ApiResult<>(code, msg, null);
    }

    public static <T> ApiResult<T> fail(int code, String msg, T data) {
        return new ApiResult<>(code, msg, data);
    }

    public T getData() {
        if (!isOk()) {
            if (SysConstants.SKIP_ERR_DATA) {
                return null; // hide sensitive data
            }
        }
        return data;
    }

}


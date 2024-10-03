package com.study.hello.distributed.mybatis.framework.commons.api.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiOrderItem implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 需要进行排序的字段
     */
    private String column;
    /**
     * 是否正序排列，默认 true
     */
    private boolean asc = true;

    public static ApiOrderItem asc(String column) {
        return build(column, true);
    }

    public static ApiOrderItem desc(String column) {
        return build(column, false);
    }

    public static List<ApiOrderItem> ascs(String... columns) {
        return Arrays.stream(columns).map(ApiOrderItem::asc).collect(Collectors.toList());
    }

    public static List<ApiOrderItem> descs(String... columns) {
        return Arrays.stream(columns).map(ApiOrderItem::desc).collect(Collectors.toList());
    }

    private static ApiOrderItem build(String column, boolean asc) {
        return new ApiOrderItem(column, asc);
    }
}

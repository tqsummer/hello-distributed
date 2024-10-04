package com.study.hello.distributed.mybatis.framework.core.mybatis.util;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.stream.Collectors;

public class WrapperUtils {

    public static <T> Page<T> toPage(Pageable pageable) {
        Page<T> page = new Page<>(pageable.getPageNumber(), pageable.getPageSize());

        Sort sort = pageable.getSort();
        if (sort.isSorted()) {
            List<OrderItem> orderItems = sort.stream()
                    .map(order -> {
                        String property = camelToUnderscore(order.getProperty());
                        return order.isAscending() ? OrderItem.asc(property) : OrderItem.desc(property);
                    })
                    .collect(Collectors.toList());
            page.addOrder(orderItems);
        }

        return page;
    }

    private static String camelToUnderscore(String input) {
        return input.replaceAll("([a-z])([A-Z])", "$1_$2").toLowerCase();
    }
}

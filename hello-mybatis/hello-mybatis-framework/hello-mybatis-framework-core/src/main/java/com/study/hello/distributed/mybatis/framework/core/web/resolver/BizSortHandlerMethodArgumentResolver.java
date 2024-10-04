package com.study.hello.distributed.mybatis.framework.core.web.resolver;

import org.springframework.core.MethodParameter;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortHandlerMethodArgumentResolver;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.ArrayList;
import java.util.List;

public class BizSortHandlerMethodArgumentResolver extends SortHandlerMethodArgumentResolver {

    @Override
    public Sort resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
        String[] directionParameter = webRequest.getParameterValues(getSortParameter(parameter));
        
        if (directionParameter == null || directionParameter.length == 0) {
            List<String> directionParameters = getEnhancedDirectionParameter(webRequest, getSortParameter(parameter));
            if (!directionParameters.isEmpty()) {
                directionParameter = directionParameters.toArray(new String[0]);
            }
        }

        if (directionParameter == null) {
            return getDefaultFromAnnotationOrFallback(parameter);
        }

        if (directionParameter.length == 1 && !StringUtils.hasText(directionParameter[0])) {
            return getDefaultFromAnnotationOrFallback(parameter);
        }

        return parseParameterIntoSort(directionParameter);
    }

    private Sort parseParameterIntoSort(String[] directionParameter) {
        List<Sort.Order> orders = new ArrayList<>();
        for (String part : directionParameter) {
            if (part.contains(",")) {
                String[] elements = part.split(",");
                orders.add(createOrder(elements[0], (elements.length == 2 ? elements[1] : null)));
            } else {
                orders.add(createOrder(part, null));
            }
        }
        return Sort.by(orders);
    }

    private Sort.Order createOrder(String property, String direction) {
        return new Sort.Order(
            direction == null ? Sort.Direction.ASC : Sort.Direction.fromString(direction),
            property
        );
    }

    private List<String> getEnhancedDirectionParameter(NativeWebRequest webRequest, String sortParam) {
        List<String> directionParameters = new ArrayList<>();
        for (int i = 1; i <= 9; ++i) {
            String theSortParam = sortParam + i;
            String[] theDirectionParameter = webRequest.getParameterValues(theSortParam);
            if (theDirectionParameter != null && theDirectionParameter.length > 0) {
                directionParameters.addAll(List.of(theDirectionParameter));
            } else {
                break;
            }
        }
        return directionParameters;
    }
}

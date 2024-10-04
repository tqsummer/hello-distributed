package com.study.hello.distributed.mybatis.apiserver.config;

import com.study.hello.distributed.mybatis.framework.core.web.resolver.BizSortHandlerMethodArgumentResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.data.web.SortHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class PageableConfig implements WebMvcConfigurer {

    @Bean
    public PageableHandlerMethodArgumentResolver customPageableResolver() {
        PageableHandlerMethodArgumentResolver resolver = new PageableHandlerMethodArgumentResolver(sortResolver());
        resolver.setPageParameterName("page");
        resolver.setSizeParameterName("size");
        resolver.setOneIndexedParameters(true);
        resolver.setMaxPageSize(100);
        return resolver;
    }

    @Bean
    public SortHandlerMethodArgumentResolver sortResolver() {
        SortHandlerMethodArgumentResolver resolver = new BizSortHandlerMethodArgumentResolver();
        resolver.setSortParameter("sort");
        return resolver;
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(customPageableResolver());
    }
}

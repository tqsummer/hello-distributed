package com.study.hello.distributed.mybatis.apiserver.test;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.study.hello.distributed.mybatis.apiserver.infrastructure.mapper.MemberPoMapper;
import com.study.hello.distributed.mybatis.apiserver.infrastructure.po.MemberPo;
import com.study.hello.distributed.mybatis.framework.commons.api.ApiPage;
import com.study.hello.distributed.mybatis.framework.commons.util.JsonUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


// 测试类
@SpringBootTest
@ActiveProfiles("test")
public class MemberMapperTest {
    @Autowired
    private MemberPoMapper memberMapper;

    @Test
    public void testInsert() {
        MemberPo memberPo = new MemberPo();
        memberPo.setNickName("test1");
        memberPo.setBirthday(LocalDate.now());
        memberPo.setGender("MAN");
        memberPo.setStatus("active");
        memberMapper.insert(memberPo);
    }

    @Test
    public void testQuery() {
        List<MemberPo> memberPos = memberMapper.selectList(null);
        System.out.println(memberPos);
    }

    @Test
    public void testUpdate() {
        MemberPo memberPo = memberMapper.selectById(1841131233602347010L);
        memberPo.setNickName("test3");
        memberPo.setCreateUserName("系统13");
        memberPo.setModifyUserName("系统3");
        memberMapper.updateById(memberPo);
    }

    @Test
    public void testQueryWrapper() {
        LambdaQueryWrapper<MemberPo> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(MemberPo::getNickName, "test1");
        List<MemberPo> memberPos = memberMapper.selectList(queryWrapper);
        System.out.println(memberPos);
    }

    @Test
    public void testQueryPage() {
        PageRequest pageRequest = PageRequest.of(1, 10);
        pageRequest.withSort(Sort.by(Sort.Order.asc("id")));
        Page<MemberPo> page = new Page<>(pageRequest.getPageNumber(), pageRequest.getPageSize());

        IPage<MemberPo> iPage = memberMapper.selectPage(page, null);
        System.out.println(JsonUtils.toJsonString(iPage));
    }

    @Test
    public void testQueryPage1() {
        PageRequest pageRequest = PageRequest.of(1, 3, Sort.by(Sort.Order.asc("nickName")));
        Page<MemberPo> page = convertToMybatisPlusPage(pageRequest);

        IPage<MemberPo> iPage = memberMapper.selectPage(page, null);
        System.out.println(JsonUtils.toJsonString(iPage));
        ApiPage<MemberPo> apiPage = ApiPage.to(iPage);
        System.out.println(JsonUtils.toJsonString(apiPage));
    }

    private Page<MemberPo> convertToMybatisPlusPage(PageRequest pageRequest) {
        Page<MemberPo> page = new Page<>(pageRequest.getPageNumber(), pageRequest.getPageSize());

        Sort sort = pageRequest.getSort();
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

    private String camelToUnderscore(String input) {
        return input.replaceAll("([a-z])([A-Z])", "$1_$2").toLowerCase();
    }


}


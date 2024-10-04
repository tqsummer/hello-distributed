package com.study.hello.distributed.mybatis.apiserver.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.study.hello.distributed.mybatis.apiserver.entity.MemberPo;
import com.study.hello.distributed.mybatis.apiserver.mapper.MemberMapper;
import com.study.hello.distributed.mybatis.framework.commons.api.ApiPage;
import com.study.hello.distributed.mybatis.framework.commons.api.ApiResult;
import com.study.hello.distributed.mybatis.framework.core.mybatis.util.WrapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 会员表 前端控制器
 * </p>
 *
 * @author fangxiagnqian
 * @since 2024-10-02
 */
@RestController
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private MemberMapper memberMapper;

    @GetMapping(value = "/v1/member", produces = MediaType.APPLICATION_JSON_VALUE)
    ApiResult<ApiPage<MemberPo>> getMember(@RequestParam MultiValueMap<String, String> query, Pageable pageable) {
        Page<MemberPo> page = WrapperUtils.toPage(pageable);
        IPage<MemberPo> iPage = memberMapper.selectPage(page, null);
        ApiPage<MemberPo> apiPage = ApiPage.to(iPage);
        return ApiResult.ok(apiPage);
    }

}

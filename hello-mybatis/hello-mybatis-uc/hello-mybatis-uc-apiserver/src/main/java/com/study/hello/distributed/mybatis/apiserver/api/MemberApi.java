package com.study.hello.distributed.mybatis.apiserver.api;

import org.springframework.web.bind.annotation.*;
import com.study.hello.distributed.mybatis.framework.commons.api.ApiPage;
import com.study.hello.distributed.mybatis.framework.commons.api.ApiResult;
import org.springframework.util.MultiValueMap;
import org.springframework.data.domain.Pageable;
import com.study.hello.distributed.mybatis.apiserver.api.dto.req.MemberReqDto;
import com.study.hello.distributed.mybatis.apiserver.api.dto.res.MemberResDto;

public interface MemberApi {

    ApiResult<MemberResDto> getMemberById(@PathVariable("id") Long id);

    ApiResult<ApiPage<MemberResDto>> getPageMember(@RequestParam MultiValueMap<String, String> query, Pageable pageable);

    ApiResult<MemberResDto> saveMember(@RequestBody MemberReqDto reqDto);

    ApiResult<MemberResDto> putMember(@RequestBody MemberReqDto reqDto);

    ApiResult<MemberResDto> deleteMemberById(@PathVariable("id") Long id);
}
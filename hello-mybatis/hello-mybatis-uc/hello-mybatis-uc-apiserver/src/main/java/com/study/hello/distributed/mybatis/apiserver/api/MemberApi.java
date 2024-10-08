package com.study.hello.distributed.mybatis.apiserver.api;

import org.springframework.web.bind.annotation.*;
import com.study.hello.distributed.mybatis.framework.commons.api.ApiPage;
import com.study.hello.distributed.mybatis.framework.commons.api.ApiResult;
import org.springframework.util.MultiValueMap;
import org.springframework.data.domain.Pageable;
import com.study.hello.distributed.mybatis.apiserver.api.dto.req.MemberReqDto;
import com.study.hello.distributed.mybatis.apiserver.api.dto.res.MemberResDto;

public interface MemberApi {

    /**
    * 根据id获取实体信息
    * @param id
    * @return
    */
    ApiResult<MemberResDto> getMemberById(@PathVariable("id") Long id);

    /**
    * 分页查询
    * @param query
    * @param pageable
    * @return
    */
    ApiResult<ApiPage<MemberResDto>> getPageMember(@RequestParam MultiValueMap<String, String> query, Pageable pageable);

    /**
    * 保存实体
    * @param reqDto
    * @return
    */
    ApiResult<MemberResDto> saveMember(@RequestBody MemberReqDto reqDto);

    /**
    * 更新实体
    * @param reqDto
    * @return
    */
    ApiResult<MemberResDto> putMember(@RequestBody MemberReqDto reqDto);

    /**
    * 删除实体
    * @param id
    * @return
    */
    ApiResult<MemberResDto> deleteMemberById(@PathVariable("id") Long id);
}
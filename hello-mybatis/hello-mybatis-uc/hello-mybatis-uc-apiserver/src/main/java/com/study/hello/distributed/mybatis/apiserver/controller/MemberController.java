package com.study.hello.distributed.mybatis.apiserver.controller;


import com.study.hello.distributed.mybatis.apiserver.api.MemberApi;
import com.study.hello.distributed.mybatis.apiserver.api.dto.req.MemberReqDto;
import com.study.hello.distributed.mybatis.apiserver.api.dto.res.MemberResDto;
import com.study.hello.distributed.mybatis.apiserver.infrastructure.service.IMemberPoService;
import com.study.hello.distributed.mybatis.framework.commons.api.ApiPage;
import com.study.hello.distributed.mybatis.framework.commons.api.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;


/**
 * <p>
 * 会员表 前端控制器
 * </p>
 *
 * @author fangxiagnqian
 * @since 2024-10-08
 */
@RestController
public class MemberController implements MemberApi {

    @Autowired
    private IMemberPoService memberPoService;

    /**
     * 根据id获取实体信息
     * @param id
     * @return
     */
    @GetMapping("/v1/member/{id}")
    public ApiResult<MemberResDto> getMemberById(@PathVariable("id") Long id) {
        return ApiResult.ok(memberPoService.get(id));
    }

    /**
     * 分页查询
     * @param query
     * @param pageable
     * @return
     */
    @GetMapping("/v1/member")
    public ApiResult<ApiPage<MemberResDto>> getPageMember(@RequestParam MultiValueMap<String, String> query, Pageable pageable) {
        return ApiResult.ok(memberPoService.getPage(query, pageable));
    }

    /**
     * 保存实体
     * @param reqDto
     * @return
     */
    @PostMapping("/v1/member")
    public ApiResult<MemberResDto> saveMember(@RequestBody MemberReqDto reqDto) {
        return ApiResult.ok(memberPoService.save(reqDto));
    }

    /**
     * 更新实体
     * @param reqDto
     * @return
     */
    @PutMapping("/v1/member")
    public ApiResult<MemberResDto> putMember(@RequestBody MemberReqDto reqDto) {
        return ApiResult.ok(memberPoService.updateAllProps(reqDto));
    }

    /**
     * 删除实体
     * @param id
     * @return
     */
    @DeleteMapping("/v1/member/{id}")
    public ApiResult<MemberResDto> deleteMemberById(@PathVariable("id") Long id) {
        return ApiResult.ok(memberPoService.delete(id));
    }
}

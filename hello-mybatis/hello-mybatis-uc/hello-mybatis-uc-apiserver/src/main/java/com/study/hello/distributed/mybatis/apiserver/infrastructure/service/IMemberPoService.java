package com.study.hello.distributed.mybatis.apiserver.infrastructure.service;

import com.study.hello.distributed.mybatis.apiserver.api.dto.req.MemberReqDto;
import com.study.hello.distributed.mybatis.apiserver.api.dto.res.MemberResDto;
import com.study.hello.distributed.mybatis.apiserver.infrastructure.po.MemberPo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.study.hello.distributed.mybatis.framework.commons.api.ApiPage;
import org.springframework.data.domain.Pageable;
import org.springframework.util.MultiValueMap;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author fangxiagnqian
 * @since 2024-10-08
 */
public interface IMemberPoService extends IService<MemberPo> {

    MemberResDto get(Long id);

    MemberResDto save(MemberReqDto reqDto);

    ApiPage<MemberResDto> getPage(MultiValueMap<String, String> query, Pageable pageable);

    MemberResDto updateAllProps(MemberReqDto reqDto);

    MemberResDto delete(Long id);
    
}

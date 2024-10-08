package com.study.hello.distributed.mybatis.apiserver.infrastructure.service;

import com.study.hello.distributed.mybatis.apiserver.infrastructure.po.MemberPo;
import com.study.hello.distributed.mybatis.framework.core.ddd.infrastructure.persistence.service.IPoService;
import com.study.hello.distributed.mybatis.framework.commons.api.ApiPage;
import com.study.hello.distributed.mybatis.apiserver.api.dto.req.MemberReqDto;
import com.study.hello.distributed.mybatis.apiserver.api.dto.res.MemberResDto;
import org.springframework.data.domain.Pageable;
import org.springframework.util.MultiValueMap;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author fangxiagnqian
 * @since 2024-10-09
 */
public interface IMemberPoService extends IPoService<MemberPo> {
    /**
    * 根据id获取实体ResDto
    * @param id
    * @return
    */
    MemberResDto get(Long id);

    /**
    * 保存实体
    * @param reqDto
    * @return
    */
    MemberResDto save(MemberReqDto reqDto);

    /**
    * 分页查询
    * @param query
    * @param pageable
    * @return
    */
    ApiPage<MemberResDto> getPage(MultiValueMap<String, String> query, Pageable pageable);

    /**
    * 更新实体
    * @param reqDto
    * @return
    */
    MemberResDto updateAllProps(MemberReqDto reqDto);

    /**
    * 删除实体
    * @param id
    * @return
    */
    MemberResDto delete(Long id);
}

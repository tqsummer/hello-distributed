package com.study.hello.distributed.mybatis.apiserver.infrastructure.service.impl;

import org.springframework.stereotype.Service;
import com.study.hello.distributed.mybatis.apiserver.infrastructure.po.MemberPo;
import com.study.hello.distributed.mybatis.apiserver.infrastructure.mapper.MemberPoMapper;
import com.study.hello.distributed.mybatis.apiserver.infrastructure.service.IMemberPoService;
import com.study.hello.distributed.mybatis.framework.core.ddd.infrastructure.persistence.service.PoServiceImpl;
import com.study.hello.distributed.mybatis.apiserver.api.dto.req.MemberReqDto;
import com.study.hello.distributed.mybatis.apiserver.api.dto.res.MemberResDto;
import com.study.hello.distributed.mybatis.framework.commons.util.ApiUtils;
import com.study.hello.distributed.mybatis.framework.commons.api.ApiPage;
import com.study.hello.distributed.mybatis.framework.core.mybatis.util.WrapperUtils;
import com.study.hello.distributed.mybatis.framework.commons.util.JsonUtils;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Pageable;
import org.springframework.util.MultiValueMap;

import java.util.function.Function;

/**
 * <p>
 * 会员表 服务实现类
 * </p>
 *
 * @author fangxiagnqian
 * @since 2024-10-09
 */
@Service
public class MemberPoServiceImpl extends PoServiceImpl<MemberPoMapper, MemberPo> implements IMemberPoService {
    @Autowired
    private MemberPoMapper memberPoMapper;

    @Override
    public MemberResDto get(Long id) {
        MemberPo updatePo = getById(id);
        return JsonUtils.convertValue(updatePo, MemberResDto.class);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public MemberResDto save(MemberReqDto reqDto) {
        MemberPo po = JsonUtils.convertValue(reqDto, MemberPo.class);
        save(po);
        MemberPo updatePo = getById(po.getId());
        return JsonUtils.convertValue(updatePo, MemberResDto.class);
    }

    @Override
    public ApiPage<MemberResDto> getPage(MultiValueMap<String, String> query, Pageable pageable) {
        Page<MemberPo> page = WrapperUtils.toPage(pageable);
        IPage<MemberPo> iPage = memberPoMapper.selectPage(page, null);
        Function<MemberPo, MemberResDto> function = po -> JsonUtils.convertValue(po, MemberResDto.class);
        return ApiPage.to(iPage, function);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public MemberResDto updateAllProps(MemberReqDto reqDto) {
        ApiUtils.notNull(reqDto.getId());
        MemberPo updatePo = JsonUtils.convertValue(reqDto, MemberPo.class);
        memberPoMapper.updateById(updatePo);
        return JsonUtils.convertValue(updatePo, MemberResDto.class);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public MemberResDto delete(Long id) {
        ApiUtils.notNull(id);
        MemberPo po = getById(id);
        memberPoMapper.deleteById(po);
        return JsonUtils.convertValue(po, MemberResDto.class);
    }
}

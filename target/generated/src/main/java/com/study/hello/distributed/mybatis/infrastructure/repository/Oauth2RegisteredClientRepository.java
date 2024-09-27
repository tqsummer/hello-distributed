package com.study.hello.distributed.mybatis.infrastructure.repository;

import com.study.hello.distributed.mybatis.domain.entity.Oauth2RegisteredClient;
import com.study.hello.distributed.mybatis.infrastructure.mapper.Oauth2RegisteredClientMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  Repository
 * </p>
 *
 * @author fangxiagnqian
 * @since 2024-09-23
 */
@Repository
public class Oauth2RegisteredClientRepository {

    @Resource
    private Oauth2RegisteredClientMapper oauth2RegisteredClientMapper;

    public Oauth2RegisteredClient getById(Long id) {
        return oauth2RegisteredClientMapper.selectById(id);
    }

    public List<Oauth2RegisteredClient> list() {
        return oauth2RegisteredClientMapper.selectList(null);
    }

    public boolean save(Oauth2RegisteredClient oauth2RegisteredClient) {
        return oauth2RegisteredClientMapper.insert(oauth2RegisteredClient) > 0;
    }

    public boolean update(Oauth2RegisteredClient oauth2RegisteredClient) {
        return oauth2RegisteredClientMapper.updateById(oauth2RegisteredClient) > 0;
    }

    public boolean removeById(Long id) {
        return oauth2RegisteredClientMapper.deleteById(id) > 0;
    }
}
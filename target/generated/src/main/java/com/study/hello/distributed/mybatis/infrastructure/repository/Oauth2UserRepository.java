package com.study.hello.distributed.mybatis.infrastructure.repository;

import com.study.hello.distributed.mybatis.domain.entity.Oauth2User;
import com.study.hello.distributed.mybatis.infrastructure.mapper.Oauth2UserMapper;
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
public class Oauth2UserRepository {

    @Resource
    private Oauth2UserMapper oauth2UserMapper;

    public Oauth2User getById(Long id) {
        return oauth2UserMapper.selectById(id);
    }

    public List<Oauth2User> list() {
        return oauth2UserMapper.selectList(null);
    }

    public boolean save(Oauth2User oauth2User) {
        return oauth2UserMapper.insert(oauth2User) > 0;
    }

    public boolean update(Oauth2User oauth2User) {
        return oauth2UserMapper.updateById(oauth2User) > 0;
    }

    public boolean removeById(Long id) {
        return oauth2UserMapper.deleteById(id) > 0;
    }
}
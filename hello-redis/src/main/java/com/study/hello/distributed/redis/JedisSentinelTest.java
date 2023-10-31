package com.study.hello.distributed.redis;

import redis.clients.jedis.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author fangxiangqian
 */
public class JedisSentinelTest {

    public static void main(String[] args) {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        // 最大连接数
        jedisPoolConfig.setMaxTotal(10);
        jedisPoolConfig.setMaxIdle(5);
        jedisPoolConfig.setMinIdle(2);
        String masterName = "mymaster";
        Set<String> sentinels = new HashSet<>();
        sentinels.add(new HostAndPort("192.168.31.121", 26379).toString());
        sentinels.add(new HostAndPort("192.168.31.121", 26380).toString());
        sentinels.add(new HostAndPort("192.168.31.121", 26381).toString());
        JedisSentinelPool jedisPool = new JedisSentinelPool(masterName, sentinels, jedisPoolConfig, 3000, null);
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.set("k1-1", "v1-1");
            System.out.println(jedis.get("k1-1"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedisPool.close();
        }
    }
}

package com.study.hello.distributed.redis;

import redis.clients.jedis.*;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author fangxiangqian
 */
public class JedisClusterTest {

    public static void main(String[] args) {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        // 最大连接数
        jedisPoolConfig.setMaxTotal(10);
        jedisPoolConfig.setMaxIdle(5);
        jedisPoolConfig.setMinIdle(2);

        Set<HostAndPort> jedisClusterNodes = new HashSet<>();
        jedisClusterNodes.add(new HostAndPort("192.168.31.131", 6401));
        jedisClusterNodes.add(new HostAndPort("192.168.31.132", 6402));
        jedisClusterNodes.add(new HostAndPort("192.168.31.133", 6403));
        jedisClusterNodes.add(new HostAndPort("192.168.31.131", 6404));
        jedisClusterNodes.add(new HostAndPort("192.168.31.132", 6405));
        jedisClusterNodes.add(new HostAndPort("192.168.31.133", 6406));

        String password = "foobar-pass";
        JedisCluster jedisCluster = null;
        try {
            jedisCluster = new JedisCluster(jedisClusterNodes, 3000, 3000, 3, password, jedisPoolConfig);
            jedisCluster.set("k1-cluster", "v1-cluster");
            System.out.println(jedisCluster.get("k1-cluster"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedisCluster != null) {
                try {
                    jedisCluster.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

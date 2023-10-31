package com.study.hello.distributed.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Pipeline;

import java.util.Arrays;
import java.util.List;

/**
 * @author fangxiangqian
 */
public class JedisSingleTest {

    public static void main(String[] args) {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        // 最大连接数
        jedisPoolConfig.setMaxTotal(10);
        jedisPoolConfig.setMaxIdle(5);
        jedisPoolConfig.setMinIdle(2);
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, "192.168.31.121", 6381, 3000, null);
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.set("k1", "v1");
            System.out.println(jedis.get("k1"));

            /**
             * 管道
             */
            Pipeline pipeline = jedis.pipelined();
            for (int i = 0; i < 10; i++) {
                pipeline.incr("pipelineKey");
                pipeline.set("p" + i, "v" + i);
            }
            /**
             * 模拟管道报错
             */
            pipeline.setbit("pipelineBitKey", -1, true);
            List<Object> objects = pipeline.syncAndReturnAll();
            for (Object object : objects) {
                System.out.println(object);
            }
            /**
             *
             */
            //jedis.set("product_count_1111", "15");
            String script = "local count = redis.call('get',KEYS[1]) " +
                    "local a = tonumber(count) " +
                    "local b = tonumber(ARGV[1]) " +
                    "if a>=b then " +
                    "redis.call('set',KEYS[1],a-b) " +
                    "return 1 " +
                    "end " +
                    "return 0 ";
            Object obj = jedis.eval(script, Arrays.asList("product_count_1111"), Arrays.asList("10"));
            System.out.println(obj);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedisPool.close();
        }
    }
}

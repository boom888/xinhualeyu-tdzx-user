package com.tdzx.user.utils;

import org.apache.commons.lang3.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class JedisUtils {


    private static JedisPool pool= (JedisPool) SpringContextUtil.getBean("pool");

    /*static {
        pool = (JedisPool) SpringContextUtil.getBean("pool");
    }*/


    public static String set(String key, String value) {
        Jedis jedis = pool.getResource();
        String result = jedis.set(key, value);
        jedis.close();
        return result;
    }

    public static String get(String key) {
        Jedis jedis = pool.getResource();
        String result = jedis.get(key);
        jedis.close();
        return result;
    }

    public static Jedis getJedis() {
        Jedis jedis = pool.getResource();
        return jedis;
    }

    public static Boolean exists(String key) {
        Jedis jedis = pool.getResource();
        Boolean result = jedis.exists(key);
        jedis.close();
        return result;
    }

    public static Long expire(String key, int seconds) {
        Jedis jedis = pool.getResource();
        Long result = jedis.expire(key, seconds);
        jedis.close();
        return result;
    }

    public static Long ttl(String key) {
        Jedis jedis = pool.getResource();
        Long result = jedis.ttl(key);
        jedis.close();
        return result;
    }

    public static Long incr(String key) {
        Jedis jedis = pool.getResource();
        Long result = jedis.incr(key);
        jedis.close();
        return result;
    }

    public static Long hset(String key, String field, String value) {
        Jedis jedis = pool.getResource();
        Long result = jedis.hset(key, field, value);
        jedis.close();
        return result;
    }

    public static String hmset(String key, Map<String, String> hash) {
        Jedis jedis = pool.getResource();
        String result = jedis.hmset(key, hash);
        jedis.close();
        return result;
    }

    public static String hget(String key, String field) {
        Jedis jedis = pool.getResource();
        String result = jedis.hget(key, field);
        jedis.close();
        if (StringUtils.isEmpty(result))
            return "";
        return result;
    }

    public static Map<String, String> hgetAll(String key) {
        Jedis jedis = pool.getResource();
        Map<String, String> result = jedis.hgetAll(key);
        jedis.close();
        if (result == null) {
            return Collections.emptyMap();
        }
        return result;
    }

    public static List<String> hvals(String key) {
        Jedis jedis = pool.getResource();
        List<String> result = jedis.hvals(key);
        jedis.close();
        if (result == null) {
            return Collections.emptyList();
        }
        return result;
    }

    public static Long hdel(String key, String... field) {
        Jedis jedis = pool.getResource();
        Long result = jedis.hdel(key, field);
        jedis.close();
        return result;
    }

    public static Long del(String key) {
        Jedis jedis = pool.getResource();
        Long result = jedis.del(key);
        jedis.close();
        return result;
    }

    public static Long getExpire(String key) {
        Jedis jedis = pool.getResource();
        Long result = jedis.ttl(key);
        jedis.close();
        return result;

    }


}

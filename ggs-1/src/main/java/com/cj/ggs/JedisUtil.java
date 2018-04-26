package com.cj.ggs;

import com.alibaba.fastjson.JSON;
import redis.clients.jedis.Jedis;

import java.util.Set;

public class JedisUtil {

    public static Jedis getJedis() {

        return new Jedis("192.168.238.129", 6379);
    }

    public static void main(String[] args) {

        Jedis jedis = getJedis();

        Set<String> set = jedis.keys("*");

        System.out.println(JSON.toJSONString(set));
    }

}

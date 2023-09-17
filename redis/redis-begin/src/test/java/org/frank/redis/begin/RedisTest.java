package org.frank.redis.begin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * StringRedisTemplate继承RedisTemplate
 * 两者的数据是不共通的（默认的序列化机制导致key不一样）
 * StringRedisTemplate默认采用的是String的序列化策略
 * RedisTemplate默认采用的是JDK的序列化策略，会将数据先序列化成字节数组然后在存入Redis数据库
 * 
 * */
@SpringBootTest
public class RedisTest {
    
    @Autowired
    private RedisTemplate redisTemplate;
    
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void setStringTest(){
        redisTemplate.opsForValue().set("name", "xdclass111");
        stringRedisTemplate.opsForValue().set("name", "bbaac");
    }
    
    @Test
    public void getStringTest(){
        String str1 = (String)redisTemplate.opsForValue().get("name");
        System.out.println(str1);

        String str2 = stringRedisTemplate.opsForValue().get("name");
        System.out.println(str2);
    }
    
}

package org.frank.redis.begin;

import org.frank.redis.begin.modules.User;
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
        stringRedisTemplate.opsForValue().set("name", "{\"bbaac\":\"aabb\"}");
    }
    
    /**
     * 当你做了如下设置, 你就不能用 redisTemplate 取一般的字符串, 你只能用来去json字符串, 什么叫json字符串, 如上所示 "{\"bbaac\":\"aabb\"}" 这个就是json字符串
     * // 设置key和value的序列化规则
     * redisTemplate.setKeySerializer(new StringRedisSerializer());
     * redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
     * 对于一般的字符串, 只能用 stringRedisTemplate 来取
     * 
     * */
    @Test
    public void getStringTest(){
        Object str1 = redisTemplate.opsForValue().get("name");
        System.out.println(str1);

        String str2 = stringRedisTemplate.opsForValue().get("name");
        System.out.println(str2);
    }

    @Test
    public void setObjectTest(){
        User user = new User();
        user.setId(1);
        user.setName("张三");
        user.setPwd("123456");

        redisTemplate.opsForValue().set("user:1",user);
    }
    
}

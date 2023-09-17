package org.frank.redis.begin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class RedisTest {
    
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void setStringTest(){
        redisTemplate.opsForValue().set("name", "xdclass111");
    }
    
    @Test
    public void getStringTest(){
        String str1 = (String)redisTemplate.opsForValue().get("name");
        System.out.println(str1);
    }
    
}

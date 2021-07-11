package org.zhouhy.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 1. 启动redis命令./src/redis-server /usr/zhouhy/redis-5.0.7/redis.conf 
 * 2. 停止redis命令 ./src/redis-cli -h 127.0.0.1 -p 6379 shutdown
 * */
@SpringBootApplication
@MapperScan("org.zhouhy.redis.mapper")
public class StringApp {
    public static void main(String[] args) {
        SpringApplication.run(StringApp.class,args);
    }
}

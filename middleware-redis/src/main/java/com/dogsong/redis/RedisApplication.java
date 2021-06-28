package com.dogsong.redis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * TODO
 *
 * @author <a href="mailto:domi.song@cloudwise.com">domisong</a>
 * @since 2021/6/16
 */
@SpringBootApplication
@MapperScan(basePackages = "com.dogsong.redis.mapper")
public class RedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisApplication.class, args);
    }
}

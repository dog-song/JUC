package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Domi on 2021/01/27.
 */
@SpringBootApplication
@Slf4j
public class NacosApplication {

    public static void main(String[] args) {
        log.info("12345");
        SpringApplication.run(NacosApplication.class, args);
    }
}

package com.domi.dameng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by Domi on 2020/11/13.
 */
//@PropertySource(value = {"file:conf/application.properties"})
@SpringBootApplication
public class DMApplication {

    public static void main(String[] args) {
        SpringApplication.run(DMApplication.class,args);
    }
}

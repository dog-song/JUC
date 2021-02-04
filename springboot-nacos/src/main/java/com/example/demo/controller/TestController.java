package com.example.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Domi on 2021/01/27.
 */
@Api(tags = "测试API111")
@Configuration
@RestController
@Slf4j
public class TestController {

    @Value("${aaa}")
    private String serverName;

    @ApiOperation("测试使用")
    @ApiImplicitParam(name = "aaa", value = "String 类型", required = false, dataType = "String",example = "aaa",paramType = "body")
    @GetMapping(value = "/test")
    @ResponseBody
    public String get() {
        log.info("aaa: {}", serverName);
        return serverName;
    }
}

package com.example.demo.controller;

import com.example.demo.model.WorkModel;
import com.example.demo.utils.DataDecoder;
import com.example.demo.utils.JacksonUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Domi on 2021/01/27.
 */
@Api(tags = "测试API111")
@Configuration
@RestController
@Slf4j
public class TestController {

    @Value("${server.name}")
    private String serverName;


    @Value("#{T(com.example.demo.utils.DataDecoder).decodeList('${queue.worker}')}")
    private List<Map<String, Object>> queueWorker;

    @ApiOperation("测试使用")
    @ApiImplicitParam(name = "aaa", value = "String 类型", required = false, dataType = "String",example = "aaa",paramType = "body")
    @GetMapping(value = "/test")
    @ResponseBody
    public String get() {
        log.info("aaa: {}", serverName);

        log.info("queue.worker: {}.", queueWorker);
        List<Map<String, Object>> listMap = queueWorker;

        System.out.println(listMap);


        WorkModel workModel = new WorkModel();
        workModel.setId(1);
        workModel.setAge(22);
        ArrayList arrayList = new ArrayList();
        arrayList.add(workModel);
        JacksonUtil.toJSon(workModel);
        JacksonUtil.toJSon(arrayList);

        return serverName;
    }
}

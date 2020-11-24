package com.domi.dameng.controller;

import com.domi.dameng.service.impl.TestDMServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Domi on 2020/11/13.
 */
@RestController
@Slf4j
public class TestDMController {

    @Autowired
    TestDMServiceImpl testDMService;

    @RequestMapping(value = "/get",method = RequestMethod.POST)
    public List<Map<String,Object>> getList(@RequestBody Map<String, Object> params){
        List<Map<String,Object>> dataList = new ArrayList<>();
        int id = Integer.parseInt(params.get("id").toString());
        try{
            dataList = testDMService.getList(id);
        }catch (Exception e){
            System.out.println(e);
            Map<String,Object> map = new HashMap<>();
            map.put("ERROR",e.getCause());
            dataList.add(map);
        }

        return  dataList;
    }
}

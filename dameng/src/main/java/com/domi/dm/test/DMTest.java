package com.domi.dm.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by Domi on 2020/11/12.
 */
@RestController
public class DMTest {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/get")
    public String test(){
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from JC.test1");
        System.out.println(list);
        System.out.println("The size is: " + list.size());
        return "over";
    }
}

package com.domi.dameng.service.impl;

import com.domi.dameng.mapper.TestDMMapperInterface;
import com.domi.dameng.service.TestDMServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Domi on 2020/11/13.
 */
@Service
public class TestDMServiceImpl implements TestDMServiceInterface {

    @Autowired(required = false)
    TestDMMapperInterface dao;

    @Override
    public List<Map<String, Object>> getList(int id) {
        List<Map<String,Object>> dataList = dao.getList(id);
        return dataList;
    }
}

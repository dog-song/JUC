package com.example.demo.service.impl;

import com.example.demo.mapper.IDevMapper;
import com.example.demo.service.IDevService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Domi on 2021/01/27.
 */
@Service
public class DevServiceImpl implements IDevService {

    @Autowired(required = false)
    IDevMapper dao;

    @Override
    public List<Map<String, Object>> getList(int id) {
        List<Map<String,Object>> dataList = dao.getList(id);

        return dataList;
    }
}

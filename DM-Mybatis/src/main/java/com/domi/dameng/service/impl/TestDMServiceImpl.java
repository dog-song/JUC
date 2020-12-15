package com.domi.dameng.service.impl;

import com.domi.dameng.mapper.TestDMMapperInterface;
import com.domi.dameng.service.TestDMServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Clob;
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
        //把text类型的字段转换成String
        for (Map<String, Object> map : dataList) {
            for(String key:map.keySet()){
                if (map.get(key) instanceof Clob){
                    Clob clob = (Clob) map.get(key);
                    try{
                        map.put(key,clob.getSubString((long)1,(int)clob.length()));
                    }catch (Exception e){
                        map.put("ERROR",e.getCause());
                    }
                }
            }
        }
        return dataList;
    }

    @Override
    public List<Map<String, Object>> listAll() {
        List<Map<String,Object>> dataList = dao.listAll();
        return dataList;
    }

    @Override
    public int insert(String name,int age) {
        return dao.insert(name, age);
    }

    @Override
    public int delete(int id) {
        return dao.delete(id);
    }

    @Override
    public int update(int id, String name, int age) {
        return dao.update(id, name, age);
    }
}

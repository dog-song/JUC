package com.domi.dameng.service;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Domi on 2020/11/13.
 */
public interface TestDMServiceInterface {

    /** 通过ID查询 */
    List<Map<String,Object>> getList(int id);

    /** 查询全部 */
    List<Map<String,Object>> listAll();

    /** 插入单挑数据 */
    int insert(String name,int age);

    /** 通过id删除 */
    int delete(int id);

    /** 更新 */
    int update(int id,String name,int age);
}

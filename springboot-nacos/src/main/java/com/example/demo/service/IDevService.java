package com.example.demo.service;

import java.util.List;
import java.util.Map;

/**
 * Created by Domi on 2021/01/27.
 */
public interface IDevService {

    /** 通过ID查询 */
    List<Map<String,Object>> getList(int id);
}

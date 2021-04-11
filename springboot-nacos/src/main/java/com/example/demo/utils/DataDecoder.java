package com.example.demo.utils;

import com.example.demo.model.WorkModel;

import java.util.List;
import java.util.Map;

/**
 * @author domisong.
 * @description: TODO
 * @date 2021/4/10.
 */
public class DataDecoder {

    public static List<Map<String, Object>> decodeList (String value) {
        try {
            List<Map<String, Object>> list = JacksonUtil.readValue(value, List.class);
            return list;
        } catch (Exception e) {
            return null;
        }
    }

}

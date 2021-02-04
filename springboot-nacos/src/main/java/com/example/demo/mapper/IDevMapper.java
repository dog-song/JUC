package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * Created by Domi on 2021/01/27.
 */
@Mapper
public interface IDevMapper {

    /** 通过ID查询 */
    @Select("select * from test where id=#{id}")
    List<Map<String,Object>> getList(@Param("id") int id);
}

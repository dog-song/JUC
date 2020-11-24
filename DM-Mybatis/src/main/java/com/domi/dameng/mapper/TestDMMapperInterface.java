package com.domi.dameng.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * Created by Domi on 2020/11/13.
 */
@Mapper
public interface TestDMMapperInterface {

    @Select("select * from test1 where id=#{id}")
    List<Map<String,Object>> getList(@Param("id")int id);
}

package com.domi.dameng.mapper;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Domi on 2020/11/13.
 */
@Mapper
public interface TestDMMapperInterface {

    /** 通过ID查询 */
    @Select("select * from test where id=#{id}")
    List<Map<String,Object>> getList(@Param("id")int id);

    /** 查询全部 */
    @Select("select * from test ")
    List<Map<String,Object>> listAll();

    /** 插入单挑数据 */
    @Insert("insert into test (name,age) values (#{name},#{age})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(@Param("name")String name,@Param("age")int age);

    /** 通过id删除 */
    @Delete("delete from test where id=#{id}")
    int delete(@Param("id")int id);

    /** 更新 */
    @Update("update test set name=#{name},age=#{age} where id=#{id}")
    int update(@Param("id")int id,@Param("name")String name,@Param("age")int age);
}

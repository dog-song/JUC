package com.dogsong.redis.mapper;

import com.dogsong.redis.entity.Item;
import org.apache.ibatis.annotations.Param;

/**
 * TODO
 *
 * @author <a href="mailto:domi.song@cloudwise.com">domisong</a>
 * @since 2021/6/16
 */
public interface ItemMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Item record);

    int insertSelective(Item record);

    Item selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Item record);

    int updateByPrimaryKey(Item record);

    Item selectByCode(@Param("code") String code);

}

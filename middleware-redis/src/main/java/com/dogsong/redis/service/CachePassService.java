package com.dogsong.redis.service;

import com.dogsong.redis.entity.Item;
import com.dogsong.redis.mapper.ItemMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * TODO
 *
 * @author <a href="mailto:domi.song@cloudwise.com">domisong</a>
 * @since 2021/6/16
 */
@Service
public class CachePassService {

    private static final Logger log = LoggerFactory.getLogger(CachePassService.class);


    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    private static final String keyPrefix="item:";


    public Item getItemInfo(String itemCode) throws Exception {
        Item item = null;

        final String key = keyPrefix + itemCode;
        ValueOperations valueOperations = redisTemplate.opsForValue();
        if (redisTemplate.hasKey(key)) {
            log.info("---获取商品详情-缓存中存在该商品---商品编号为：{} ", itemCode);

            //从缓存中查询该商品详情
            Object res = valueOperations.get(key);
            // TODO: 2021/6/16 json 序列化为什么要加 "".equals()
            // 参考：https://blog.csdn.net/Lovincc/article/details/73742365

            if (res != null && !Strings.isNotEmpty(res.toString()) && !"".equals(res.toString())) {
                item = objectMapper.readValue(res.toString(), Item.class);
            }
        } else {
            log.info("---获取商品详情-缓存中不存在该商品-从数据库中查询---商品编号为：{} ", itemCode);

            //从数据库中获取该商品详情
            item = itemMapper.selectByCode(itemCode);
            if (item != null) {
                valueOperations.set(key, objectMapper.writeValueAsString(item));
            } else {
                //过期失效时间TTL设置为30分钟-当然实际情况要根据实际业务决定
                valueOperations.set(key, "", 30L, TimeUnit.MINUTES);

                valueOperations.set("domi宋", "domi宋");
            }
        }
        return item;
    }
}

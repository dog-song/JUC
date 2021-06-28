package com.dogsong.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * TODO
 *
 * @author <a href="mailto:domi.song@cloudwise.com">domisong</a>
 * @since 2021/6/16
 */
@Configuration
public class RedisConfig {


    /**
     * 设置 redisTemplate 的序列化设置
     * <p>备注：在把RedisTemplate注入Spring容器的时候,
     * 如果不设置RedisTemplate的序列化,在Redis存数据的时候,key前边追加了一些编码数据,加上这个设置会把这些编码数据给去掉</p>
     *
     * @param redisConnectionFactory redisConnectionFactory
     * @return org.springframework.data.redis.core.RedisTemplate<java.lang.Object,java.lang.Object>
     * @since 2021/6/16
     * @author <a href="mailto:domi.song@cloudwise.com">domi</a>
     */
    @Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        // 1.创建 redisTemplate 模版
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        // 2.关联 redisConnectionFactory
        template.setConnectionFactory(redisConnectionFactory);
        // 3.创建 序列化类
        GenericToStringSerializer genericToStringSerializer = new GenericToStringSerializer(Object.class);
        // 6.序列化类，对象映射设置
        // 7.设置 value 的转化格式和 key 的转化格式
        template.setValueSerializer(genericToStringSerializer);
        template.setKeySerializer(new StringRedisSerializer());
        template.afterPropertiesSet();
        return template;
    }


    /*

参考：https://www.cnblogs.com/winter-shadow/p/14337125.html

    @Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        RedisTemplate<Object, Object> template = new RedisTemplate<Object, Object>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<Object> serializer = new Jackson2JsonRedisSerializer<>(Object.class);
        template.setDefaultSerializer(serializer);
        return template;
    }

     */
}

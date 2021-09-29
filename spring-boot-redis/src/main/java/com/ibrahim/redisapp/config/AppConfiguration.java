package com.ibrahim.redisapp.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

//burayi config icin kullanacagiz
@Configuration
@EnableCaching //spring annotation dir. Redis aktif oldu
public class AppConfiguration {

    //conneciton tutar, bir tane uretir ve ioc icine koyar
    @Bean
    public JedisConnectionFactory jedisConnectionFactory(){
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration("localhost",6379);
        return new JedisConnectionFactory(redisStandaloneConfiguration);
    }

    //bu template uzerinden islemler yapabilecegiz
    @Bean
    public RedisTemplate redisTemplate(){
        RedisTemplate template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        return template;
    }
}

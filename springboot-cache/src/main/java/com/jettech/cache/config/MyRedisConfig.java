package com.jettech.cache.config;

import java.net.UnknownHostException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import com.jettech.cache.bean.Department;
import com.jettech.cache.bean.Employee;

@Configuration
public class MyRedisConfig  {

	/*
	 * 自动以redis的序列化规则
	 */
	@Bean
	public RedisTemplate<Object, Employee> empRedisTemplate(
			RedisConnectionFactory redisConnectionFactory)throws UnknownHostException{
		
		RedisTemplate<Object,Employee> redisTemplate = new RedisTemplate<Object, Employee>();
		redisTemplate.setConnectionFactory(redisConnectionFactory);
		//设置序列化方式
		Jackson2JsonRedisSerializer<Employee> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Employee>(Employee.class);
		redisTemplate.setDefaultSerializer(jackson2JsonRedisSerializer);
		return redisTemplate;
	}
	
	//如果其他实体类也要自定义序列化格式
    @Bean
    public RedisTemplate<Object, Department> deptRedisTemplate(
            RedisConnectionFactory redisConnectionFactory)
            throws UnknownHostException {
        RedisTemplate<Object, Department> template = new RedisTemplate<Object, Department>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<Department> ser = new Jackson2JsonRedisSerializer<Department>(Department.class);
        template.setDefaultSerializer(ser);
        return template;
    }
    
    
    /*
     * 自定义缓存管理器
     */
    //CacheManagerCustomizers可以来定制缓存的一些规则
    @Primary //将某个缓存管理器作为默认的
    @Bean
    public RedisCacheManager employeeCacheManager(RedisTemplate<Object, Employee> empRedisTemplate){
        RedisCacheManager cacheManager = new RedisCacheManager(empRedisTemplate);
        //key多了一个前缀

        //使用前缀，默认会将CacheName作为key的前缀
        cacheManager.setUsePrefix(true);

        return cacheManager;
    }
    
    //序列化部门的缓存管理器
    @Bean
    public RedisCacheManager deptCacheManager(RedisTemplate<Object, Department> deptRedisTemplate){
        RedisCacheManager cacheManager = new RedisCacheManager(deptRedisTemplate);
        //key多了一个前缀

        //使用前缀，默认会将CacheName作为key的前缀
        cacheManager.setUsePrefix(true);

        return cacheManager;
    }
	
}

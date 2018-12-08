package com.jettech.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.jettech.cache.bean.Employee;
import com.jettech.cache.mapper.EmployeeMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootCacheApplicationTests {

	@Autowired
	EmployeeMapper employeeMapper;
	
	//引入spring-boot-starter-data-redis.jar后就可以直接使用redis缓存了
	
	@Autowired
	StringRedisTemplate stringRedisTemplate;		//主要操作字符串的
	
	@Autowired
	RedisTemplate redisTemplate;		//主要操作对象的RedisTemplate<K, V>
	
	/**
	 * Redis常见的五大数据类型
	 *  String（字符串）、List（列表）、Set（集合）、Hash（散列）、ZSet（有序集合）
	 *  stringRedisTemplate.opsForValue()[String（字符串）]
	 *  stringRedisTemplate.opsForList()[List（列表）]
	 *  stringRedisTemplate.opsForSet()[Set（集合）]
	 *  stringRedisTemplate.opsForHash()[Hash（散列）]
	 *  stringRedisTemplate.opsForZSet()[ZSet（有序集合）]
	 */
	
	//引入重写了序列化规则的RedisTemplate
	@Autowired
	RedisTemplate<Object, Employee> empRedisTemplate;
	
	@Test
	public void contextLoads() {
		Employee employee = employeeMapper.getEmployee(1);
		System.out.println(employee);
		
	}
	
	
	/*
	 * 给redis中保存数据
	 */
	@Test
	public void test01() {
		stringRedisTemplate.opsForValue().append("msg", "Hello World!");
		String msg = stringRedisTemplate.opsForValue().get("msg");
		System.out.println(msg);
	}
	
	/*
	 * 测试redis中保存对象
	 */
	@Test
	public void test02() {
		Employee employee = employeeMapper.getEmployee(2);
		//默认如果保存对象，使用JDK的序列化机制，序列化后的数据保存到redis中
		//redisTemplate.opsForValue().set("emp-01", employee);
		
		//将数据以json格式保存
			//1)说动将数据转为json格式
			//2)redis有默认的序列化规则，改变默认的序列化规则
		
		empRedisTemplate.opsForValue().set("emp-03", employee);
	}

}

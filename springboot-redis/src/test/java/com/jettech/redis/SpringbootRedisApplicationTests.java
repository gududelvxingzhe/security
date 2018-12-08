package com.jettech.redis;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.jettech.redis.service.IRedisRepository;
import com.jettech.redis.service.RedisRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRedisApplicationTests {

	
	@Autowired
	private IRedisRepository redisRepository;
	
	@Autowired
	private StringRedisTemplate  stringRedisTemplate;
	@Test
	public void contextLoads() {
		
			//主要操作字符串的
		    //stringRedisTemplate.opsForValue().set("good", "morning");
	    	//Assert.assertEquals("morning", stringRedisTemplate.opsForValue().get("good"));
			System.out.println(stringRedisTemplate.opsForValue().get("good"));

			//主要操作对象
			//redisRepository.set("zhangxing","heool");
			System.out.println( redisRepository.get("zhangxing"));
	}

}

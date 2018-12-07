package com.jettech.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jettech.redis.service.IRedisRepository;
import com.jettech.redis.service.RedisRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRedisApplicationTests {

	
	@Autowired
	private IRedisRepository redisRepository;
	@Test
	public void contextLoads() {
		
		   /* stringRedisTemplate.opsForValue().set("good", "morning");
	    		Assert.assertEquals("morning", stringRedisTemplate.opsForValue().get("good"));*/

		redisRepository.set("zhangxing","heool");
		System.out.println( redisRepository.get("zhangxing"));
	}

}

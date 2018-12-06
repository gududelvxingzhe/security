package com.jettech.cache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/*
 * 一、环境搭建
 * 1，导入数据库文件
 * 2，创建bean文件
 * 3，整合mybatis操作数据库
 * 		1.配置数据源信息
 * 		2.使用注解版的mybatis
 * 				1）@MapperScan指定需要扫描mapper接口所在的包
 * 二、体验缓存
 * 	1、开启基于注解的缓存 @EnableCaching
 * 	2、标注缓存注解即可 @Cacheable @CacheEvict @CachePut
 */



@MapperScan("com.jettech.cache.mapper")
@SpringBootApplication
@EnableCaching
public class SpringbootCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootCacheApplication.class, args);
	}
}

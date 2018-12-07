package com.jettech.ehcache.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.jettech.ehcache.bean.Person;
import com.jettech.ehcache.dao.PersonDao;

@Service
public class PersonService {

	@Autowired
	private PersonDao personDao;
	

	
	@CachePut(value="people", key="#result.id")
	public Person save(Person person) {
		System.out.println("添加到数据库！");
		Person p = personDao.save(person);
		return p;
	}
	
	@Cacheable(value="people")
	public Person getById(Long id) {
		System.out.println("查询数据库！");
		Person person = personDao.getOne(id);
		return person;
	}
	
    /**
     * @CacheEvict：缓存清除
     *  key：指定要清除的数据
     *  allEntries = true：指定清除这个缓存中所有的数据
     *  beforeInvocation = false：缓存的清除是否在方法之前执行
     *      默认代表缓存清除操作是在方法执行之后执行;如果出现异常缓存就不会清除
     *
     *  beforeInvocation = true：
     *      代表清除缓存操作是在方法运行之前执行，无论方法是否出现异常，缓存都清除
     */
	
	@CacheEvict(value="people", key="#id")
	public void remove(Long id) {
		personDao.delete(id);
	}
	
}

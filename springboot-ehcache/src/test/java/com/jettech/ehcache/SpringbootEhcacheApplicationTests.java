package com.jettech.ehcache;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jettech.ehcache.SpringbootEhcacheApplication;
import com.jettech.ehcache.bean.Person;
import com.jettech.ehcache.dao.PersonDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootEhcacheApplicationTests {

	@Autowired
	private PersonDao personDao;
	@Test
	public void contextLoads() {
		
		List<Person> list = personDao.findAll();
		for (Person person : list) {
			System.out.println(person);
		}
	}

	

}

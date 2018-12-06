package com.jettech.ehcache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jettech.ehcache.bean.Person;
import com.jettech.ehcache.service.PersonService;

import net.sf.ehcache.CacheManager;

@RestController
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@Autowired
	private CacheManager cacheManager;		//缓存管理器
	
	@GetMapping("/addPerson")
	public Person addPerson(Person person) {
		Person p = personService.save(person);
		return p;
	}
	
	@GetMapping("/findOne/{id}")
	public String findOne(@PathVariable("id")Long id) {
		Person person = personService.getById(id);
		System.out.println(cacheManager.toString());
		return person.getName();
	}
	
	@GetMapping("/delPerson/{id}")
	public String delPerson(@PathVariable("id")Long id) {
		personService.remove(id);
		return "SUCCESS";
	}
	
}

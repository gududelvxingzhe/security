package com.jettech.cache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jettech.cache.bean.Department;
import com.jettech.cache.service.DeptService;

@RestController
public class DeptController {

	
	@Autowired
	private DeptService deptService;
	
	
	@GetMapping("/dept/{id}")
	public Department getDept(@PathVariable("id")Integer id) {
		 Department department = deptService.getById(id);
		return department;
	}
}

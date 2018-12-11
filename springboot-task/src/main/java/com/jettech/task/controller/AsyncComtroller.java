package com.jettech.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jettech.task.service.AsyncService;

@RestController
public class AsyncComtroller {

	@Autowired
	private AsyncService asyncService;
	
	@GetMapping("/test")
	public String test() {
		asyncService.test();
		return "SUCCESS";
	}
}

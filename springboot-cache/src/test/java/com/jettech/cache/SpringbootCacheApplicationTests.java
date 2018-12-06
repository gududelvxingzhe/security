package com.jettech.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jettech.cache.bean.Employee;
import com.jettech.cache.mapper.EmployeeMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootCacheApplicationTests {

	@Autowired
	EmployeeMapper employeeMapper;
	@Test
	public void contextLoads() {
		Employee employee = employeeMapper.getEmployee(1);
		System.out.println(employee);
		
	}

}

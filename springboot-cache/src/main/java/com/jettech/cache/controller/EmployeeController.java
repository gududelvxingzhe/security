package com.jettech.cache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jettech.cache.bean.Employee;
import com.jettech.cache.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/emp/{id}")
	public Employee getEmp(@PathVariable("id")Integer id) {
		Employee emp = employeeService.getEmp(id);
		return emp;

	}
	
	@GetMapping("/emp")
	public Employee updateEmp(Employee employee) {
		
		Employee emp = employeeService.updateEmp(employee);
		return emp;
	}
	
	@GetMapping("/delEmp")
	public String deleteEmp(Integer id) {
		employeeService.deleteEmp(id);
		return "success";
	}
	
	@GetMapping("/emp/lastName/{lastName}")
	public Employee getByLastName(@PathVariable("lastName")String lastName) {
		Employee emp = employeeService.getEmpByLastName(lastName);
		return emp;
	}
}

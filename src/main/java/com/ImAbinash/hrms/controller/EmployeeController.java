package com.ImAbinash.hrms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ImAbinash.hrms.model.Employee;
import com.ImAbinash.hrms.services.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@GetMapping("/employee")
	public List<Employee> getAllEmployeeDetails() {
		List<Employee> empList = empService.getAllEmployee();
		return empList;
	}
	
	@GetMapping("/employee/{id}")
	public Employee getEmployeeById(@PathVariable int id) {
		return empService.getEmployeeDetailsById(id);
	}
	
	@PostMapping("/employee")
	public Employee saveAnEmployee(@RequestBody Employee empModel) {
		return empService.saveEmployeeDetails(empModel);
	}
	
	@PutMapping("/employee/{id}")
	public Employee saveAnEmployee(@PathVariable int id, @RequestBody Employee empModel) {
		return empService.updateEmployeeDetails(id, empModel);
	}
	
	
}

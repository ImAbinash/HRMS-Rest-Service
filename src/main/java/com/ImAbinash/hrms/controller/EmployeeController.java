package com.ImAbinash.hrms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	
	@GetMapping("/employee")
	public String getAllEmployeeDetails() {
		return "All Employees";
	}
}

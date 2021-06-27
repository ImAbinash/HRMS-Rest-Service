package com.ImAbinash.hrms.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;import org.springframework.data.annotation.CreatedDate;
import org.springframework.stereotype.Service;

import com.ImAbinash.hrms.model.Employee;
import com.ImAbinash.hrms.repository.EmployeeRepository;
import com.ImAbinash.hrms.utility.AppUtility;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository empRepo;
	
	@Autowired
	private AppUtility appUtility;
	
	
	public List<Employee> getAllEmployee(){
		return empRepo.findAllEmployee();
	}
	
	
	
	public Employee getEmployeeDetailsById(int id) {
		Employee empDetails = empRepo.findEmployeeById(id);
		return empDetails;
	}
	

	public Employee saveEmployeeDetails(Employee emp) {
		if(emp.getId() == 0)
			emp.setCreatedDate(appUtility.getTodaysDateInUTCFormat());
		emp.setUpdatedDate(appUtility.getTodaysDateInUTCFormat());
		System.out.println("Employee: "+ emp);
		return empRepo.saveAnEmployee(emp);
	}
//	public Employee updateEmployeeDetails(Employee emp) {
//		if(emp.getId() == 0)
//			emp.setCreatedDate(appUtility.getTodaysDateInUTCFormat());
//		emp.setUpdatedDate(appUtility.getTodaysDateInUTCFormat());
//		System.out.println("Employee: "+ emp);
//		return empRepo.updateEmployee(emp);
//	}
	
	
	
}

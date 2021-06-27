package com.ImAbinash.hrms.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.ImAbinash.hrms.model.Employee;

@Repository
@Transactional
public class EmployeeRepository {

	@PersistenceContext
	private EntityManager em;
	
	
	public List<Employee> findAllEmployee(){
		TypedQuery<Employee> findAllEmployeeNamedQuery = em.createNamedQuery("find_all_employee",Employee.class);
		return findAllEmployeeNamedQuery.getResultList();
	}
	
	public Employee findEmployeeById(int id) {
		return em.find(Employee.class, id);
	}

	public Employee saveAnEmployee(Employee empModel) {
		try {
			Employee emp = em.merge(empModel);
			return emp;
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return null;
	}

//	public Employee updateEmployee(Employee empModel) {
//		try {
//			TypedQuery<Employee> empUpdateNamedQuery = em.createNamedQuery("update-employee-details-query", Employee.class);
//			List<Employee> resultList = empUpdateNamedQuery.getResultList();
//			return resultList.get(0);
//		} catch (Exception ex) {
//			System.out.println(ex);
//		}
//		return null;
//	}

	
}

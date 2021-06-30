package com.ImAbinash.hrms.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.ImAbinash.hrms.model.Employee;

@Repository
@Transactional
public class EmployeeRepository {

	@PersistenceContext
	private EntityManager em;

	public List<Employee> findAllEmployee() {
		TypedQuery<Employee> findAllEmployeeNamedQuery = em.createNamedQuery("find_all_employee", Employee.class);
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

	public int updateEmployee(int id, Employee empModel) {
		try {

			Query employeeUpdateNamedQuery = em.createNamedQuery("update_employee");
			
			
			employeeUpdateNamedQuery.setParameter("fname", empModel.getFirstName());
			employeeUpdateNamedQuery.setParameter("lname",empModel.getLastName());
			employeeUpdateNamedQuery.setParameter("email", empModel.getEmailAddress());
			employeeUpdateNamedQuery.setParameter("ph_num",empModel.getPhoneNumber());
			employeeUpdateNamedQuery.setParameter("alt_Ph", empModel.getAltPhoneNumber());
			employeeUpdateNamedQuery.setParameter("em_Ph",empModel.getEmergencyPhoneNumber());
			employeeUpdateNamedQuery.setParameter("u_date",empModel.getUpdatedDate());
			employeeUpdateNamedQuery.setParameter("id",id);
			
			
			int executeUpdate = employeeUpdateNamedQuery.executeUpdate();
			
			return executeUpdate;
			
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return 0;
	}

}

package com.employee.emplpoyee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.emplpoyee.jpa.JpaRepo;
import com.employee.emplpoyee.pojo.Employee;

@Service
public class EmployeeService {
	@Autowired
	JpaRepo repository;

	public Employee create(Employee emp) {
		List<Employee> list = repository.findAll();
		if(list.isEmpty()) {
			return repository.save(emp);

		}
		
		for (Employee temp : list) {

		 if(temp.getEmployeID() == emp.getEmployeID())
			{
				return null;
			}
		}

		return repository.save(emp);
	}

	public Employee update(int empId, Employee employee) {
		List<Employee> list =  repository.findAll();
		for (Employee emp : list) {

			if (emp.getEmployeID() == empId) {
				return repository.save(employee);
			}
		}

		return null;
	}

	public String delete(int empID) {
		List<Employee> list = repository.findAll();
		for (Employee emp : list) {

			if (emp.getEmployeID() == empID) {
				repository.deleteById(empID);
				return "deleted";
			}
		}
		
		
		return "employee with given id not found";

	}

	public Optional<Employee> ViewById(int id) {
		return repository.findById(id);
	}

	public List<Employee> viewAll() {
		return (List<Employee>) repository.findAll();
	}

}

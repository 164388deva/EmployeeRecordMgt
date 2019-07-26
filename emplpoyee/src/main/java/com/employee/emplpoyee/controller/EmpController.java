package com.employee.emplpoyee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.emplpoyee.pojo.Employee;
import com.employee.emplpoyee.service.EmployeeService;

@RequestMapping("/employee")
@RestController
public class EmpController {
	@Autowired
	EmployeeService empService;

	@PostMapping(value = "/insert")
	public Employee insert(@RequestBody Employee emp) {
		return empService.create(emp);

	}

	@PutMapping(value = "/update/{id}")
	public Employee update(@RequestBody Employee emp, @PathVariable int id) {
		return empService.update(id, emp);

	}

	@GetMapping(value = "/viewBy/{id}")
	public Optional<Employee> EmployeeViewByID(@PathVariable int id) {

		return empService.VewById(id);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public String deleteByID(@PathVariable int id) {

		return empService.delete(id);
	}
	
	
	@GetMapping(value = "/viewAll")
	public List<Employee> ViewAll() {

		return empService.viewAll();
	}
}

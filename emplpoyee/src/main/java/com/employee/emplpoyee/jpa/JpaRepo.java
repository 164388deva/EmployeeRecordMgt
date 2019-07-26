package com.employee.emplpoyee.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import com.employee.emplpoyee.pojo.Employee;

public interface JpaRepo extends JpaRepository<Employee,Integer> {

}
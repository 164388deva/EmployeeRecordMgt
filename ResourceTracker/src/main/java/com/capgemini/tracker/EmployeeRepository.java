package com.capgemini.tracker;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface EmployeeRepository extends MongoRepository<EmployeePojo, Integer> 

{
	   public EmployeePojo findByemployeeId(int employeeId);

	   
	   
	 public  void delete(EmployeePojo deleted);


}

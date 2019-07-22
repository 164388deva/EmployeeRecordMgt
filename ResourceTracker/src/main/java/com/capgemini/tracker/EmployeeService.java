package com.capgemini.tracker;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeService {
	
@Autowired
private EmployeeRepository repo;

public EmployeePojo create(EmployeePojo employee)
{


	List<EmployeePojo> list= findAllEmployee();
    for(EmployeePojo emp:list) {
    	if(emp.getEmployeeId()==employee.getEmployeeId())
    	{
    		return null;
    	}
    }
	
return repo.save(employee);

}




public EmployeePojo update(EmployeePojo employee) {
	
	return repo.save(employee);

}

public List<EmployeePojo> findAllEmployee()
	{
      return repo.findAll();
    }

	public EmployeePojo findByemployeeId(int employeeId)
	{
     return repo.findByemployeeId(employeeId);
   }
	
	 public  void delete(EmployeePojo emp)
	   {
		   repo.delete(emp);
	   }
	public   void deleteAll()
	   {
		   repo.deleteAll();
	   }

}

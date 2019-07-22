package com.capgemini.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
@RequestMapping("/employee")
public class EmployeeController 
{
	@Autowired
	private EmployeeService empService;	
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	   public void insert(Model model,@RequestBody EmployeePojo employee,BindingResult result,Map<String,Object> model1) throws Exception				   
	   {

		
		 if (result.hasErrors()) { throw new ValidationException(); 
		 }
		 
     	empService.create(employee);
 		
    }
	
	
	
	
	
    @RequestMapping(method=RequestMethod.PUT, value="/update/{id}")
    public EmployeePojo update(@PathVariable int id, @RequestBody EmployeePojo employee1) 
    {
    	EmployeePojo employee = empService.findByemployeeId(id);
    	System.out.println(employee);
    	if(employee1.getCurrentAccount()!=null)
    		employee.setCurrentAccount(employee1.getCurrentAccount());
    	
    	if(employee1.getGrade()!=null)
    		employee.setGrade(employee1.getGrade());
    	
    	if(employee1.getLocalGrade()!=null)
    		employee.setLocalGrade(employee1.getLocalGrade());
    	
    	if(employee1.getLocation()!=null)
    		employee.setLocation(employee1.getLocation());
    	
    	if(employee1.getOfficeLocation()!=null)
    		employee.setOfficeLocation(employee1.getOfficeLocation());
    	
    	if(employee1.getgP()!=null)
    		employee.setgP(employee.getgP());
    	
    	if(employee1.getLevel3EngagementRole()!=null)
    		employee.setLevel3EngagementRole(employee1.getLevel3EngagementRole());
    	
    	if(employee1.getPrimarySkill()!=null)
    		employee.setPrimarySkill(employee1.getPrimarySkill());
    	
    	
    	if(employee1.getProjectCode()!=null)
    		employee.setProjectCode(employee1.getProjectCode());
    	
    	if(employee1.getProjectEndDate()!=null)
    		employee.setProjectEndDate(employee1.getProjectEndDate());
    	
    	if(employee1.getProjectName()!=null)
    		employee.setProjectName(employee1.getProjectName());
    	
    	if(employee1.getProjectStartDate()!=null)
    		employee.setProjectStartDate(employee1.getProjectStartDate());
    	
    	if(employee1.getSeat()!=null)
    		employee.setSeat(employee1.getSeat());
    	System.out.println("");	System.out.println(employee);
    	empService.update(employee);		   
    	return employee;
    	
    	}
	
    @RequestMapping(method=RequestMethod.DELETE, value="/delete/{employeeId}")
    public String delete(@PathVariable int employeeId)
    {
    	EmployeePojo employee1 = empService.findByemployeeId(employeeId);
    	empService.delete(employee1);
		return null;
    	
    }
    	
    @RequestMapping(method=RequestMethod.DELETE, value="/deleteall")
    public void deleteAll()
    {
    	
    	empService.deleteAll();
		
    	
    }
    

	@RequestMapping(method=RequestMethod.GET,value="/findbyGp/{location}")
	public List<EmployeePojo> findbyLocation(@PathVariable String location){
		List<EmployeePojo> list=new ArrayList<EmployeePojo>();
	List<EmployeePojo> main=empService.findAllEmployee();
	for(EmployeePojo index:main){	
		if(index.getLocation().equals(location)){
			list.add(index);
		}
	}
        return list;
		
	
	}
	@RequestMapping(method=RequestMethod.GET,value="/findbylocation/{gp}")
	public List<EmployeePojo> findbyGp(@PathVariable String gp){
		List<EmployeePojo> list=new ArrayList<EmployeePojo>();
	List<EmployeePojo> main=empService.findAllEmployee();
	for(EmployeePojo index:main){	
		if(index.getgP().equals(gp)){
			list.add(index);
		}
	}
        return list;
		
	
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/findbyname/{name}")
	public List<EmployeePojo> findbyname(@PathVariable String name){
		List<EmployeePojo> list=new ArrayList<EmployeePojo>();
		List<EmployeePojo> main=empService.findAllEmployee();
		for(EmployeePojo index:main){	
			if(index.getEmployeeName().toLowerCase().contains(name.toLowerCase())){
				list.add(index);
			}
		}
	        return list;
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/findbyPrimarySkill/{primarySkill}")
	public List<EmployeePojo> findbyPrimarySkill(@PathVariable String primarySkill){
		List<EmployeePojo> list=new ArrayList<EmployeePojo>();
	List<EmployeePojo> main=empService.findAllEmployee();
	for(EmployeePojo index:main){	
		if(index.getPrimarySkill().equals(primarySkill)){
			list.add(index);
		}
	}
        return list;
		
	}   
	@RequestMapping(method=RequestMethod.GET,value="/findbyProjectcode/{pcode}")
	public List<EmployeePojo> findbyProjectCode(@PathVariable String pcode){
		List<EmployeePojo> list=new ArrayList<EmployeePojo>();
	List<EmployeePojo> main=empService.findAllEmployee();
	for(EmployeePojo index:main){	
		if(index.getProjectCode().equals(pcode)){
			list.add(index);
		}
	}
        return list;
		
	}   
	
	
	
}

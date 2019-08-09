package  com.restTemplate.RestTemplateExample.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.restTemplate.RestTemplateExample.pojo.Employee;
@RestController
public class RestTemplateController{
	 
		@Autowired
	  private RestTemplate restTemplate;	
	
	 @GetMapping(value = "/employee/{id}")
	   public Employee getEmployeeById(@PathVariable int id) {
		/*
		 * ResponseEntity<Employee> response = restTemplate.exchange(
		 * "http://localhost:8000/employee/viewby/"+id, HttpMethod.GET, null,
		 * Employee.class); return response.getBody();
		 */
		 
		   
		      
		      return restTemplate.exchange("http://localhost:8000/employee/viewBy/"+id, HttpMethod.GET, null, Employee.class).getBody();
		   }
	 @GetMapping(value = "/employees")
	 public List<Employee> getEmployees() {
		return restTemplate.exchange("http://localhost:8000/employee/viewAll",
			    HttpMethod.GET, null, new ParameterizedTypeReference < List < Employee >> () {}).getBody();
		 
		 
	 }
	 
	 
	 @PostMapping(value = "/employee")
	   public Employee createProducts(@RequestBody Employee emp) {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<Employee> entity = new HttpEntity<Employee>(emp,headers);
	      
	      return restTemplate.exchange(
	         "http://localhost:8000/employee/insert", HttpMethod.POST, entity, Employee.class).getBody();
	   }
	 
	 @PutMapping(value = "/employee/update/{id}")
	   public Employee updateProduct(@PathVariable String id, @RequestBody Employee emp) {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<Employee> entity = new HttpEntity<Employee>(emp,headers);
	      
	      return restTemplate.exchange("http://localhost:8000/employee/update/"+id, HttpMethod.PUT, entity, Employee.class).getBody();
	   }
	 
	 @DeleteMapping(value = "/delete/{id}")
	   public String deleteProduct(@PathVariable String id) {
	     
	      return restTemplate.exchange(
	         "http://localhost:8000/employee/delete/"+id, HttpMethod.DELETE, null, String.class).getBody();
	   }
	 
	 
	 
	 }
	 
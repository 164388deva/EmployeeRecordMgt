package com.employee.emplpoyee;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.employee.emplpoyee.pojo.Employee;
import com.employee.emplpoyee.service.EmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EmplpoyeeApplicationTests {
	@Autowired
    private MockMvc mockMvc;
	@Mock
	EmployeeService empService;
	
	String exampleJson= "{\"employeID\": 123,\"name\": \"deva\",\"location\": \"mumbai\",\"email\": \"deva@gmail.com\"}";
	
	String updateJson= "{\"employeID\": 123,\"name\": \"deva reddy\",\"location\": \"banglore\",\"email\": \"deva@gmail.com\"}";
	
Employee emp= new Employee(123, "deva reddy", "deva@gmail.com","banglore");
List<Employee> list = new ArrayList<>();

	
	@Test
    public void insertTestCase() throws Exception {
      this.mockMvc.perform(post("/employee/insert").accept(MediaType.APPLICATION_JSON).content(exampleJson).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(MockMvcResultMatchers.content().json("{\"employeID\": 123,\"name\": \"deva\",\"location\": \"mumbai\",\"email\": \"deva@gmail.com\"}"));
    }
	@Test
	public void updateByIdTest( ) throws Exception {
		Mockito.when(empService.update(Mockito.anyInt(), Mockito.any())).thenReturn(emp) ; 
		this.mockMvc.perform(put("/employee/update/123").accept(MediaType.APPLICATION_JSON).content(updateJson).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(MockMvcResultMatchers.content().json("{\"employeID\": 123,\"name\": \"deva reddy\",\"location\": \"banglore\",\"email\": \"deva@gmail.com\"}"));
	}
	@Test
	public void deleteByIdTest( ) throws Exception {
		Mockito.when(empService.delete(Mockito.anyInt())).thenReturn(emp.toString()) ; 
		MvcResult result=this.mockMvc.perform(delete("/employee/delete/123")).andExpect(status().isOk()).andReturn();
	assertThat(result.toString().equals("employee with given id not found"));
	
	}
	@Test
	public void getByIdTest( ) throws Exception {
		Mockito.when(empService.VewById(Mockito.anyInt())).thenReturn(Optional.of(emp));
		MvcResult result=this.mockMvc.perform(get("/employee/viewBy/123").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
		assertThat(result.toString().equals(emp.toString()));

	
	}
	
	@Test
	public void viewAllTest() throws Exception{
		
		list.add(emp);
		Mockito.when(empService.viewAll()).thenReturn(list);
		this.mockMvc.perform(get("/employee/viewAll").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(MockMvcResultMatchers.content().json("[{\"employeID\": 123,\"name\": \"deva reddy\",\"location\": \"banglore\",\"email\": \"deva@gmail.com\"}]"));
	}
}

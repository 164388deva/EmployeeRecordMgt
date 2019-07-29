package com.employee.emplpoyee;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.employee.emplpoyee.controller.EmpController;
import com.employee.emplpoyee.pojo.Employee;
import com.employee.emplpoyee.service.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(EmpController.class)
public class EmplpoyeeApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	EmployeeService mockservice;

	Employee emp = new Employee(123, "dev", "dev@gmail.com", "blore");
	Employee emp2 = new Employee(123, "deva", "devareddy@gmail.com", "mumbai");
	Employee emp3 = new Employee(1234, "deva", null, "mumbai");

	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}

	// test ("/employee/insert")
	@Test
	public void testCreateEmployee() throws Exception {

		String inputInJson = this.mapToJson(emp);
		Mockito.when(mockservice.create(Mockito.any(Employee.class))).thenReturn(emp);
		
		// Test case for status code 200 and for correct output

		MvcResult result = mockMvc.perform(post("/employee/insert").accept(MediaType.APPLICATION_JSON)
				.content(inputInJson).contentType(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse response = result.getResponse();
		String outputInJson = response.getContentAsString();

		assertThat(outputInJson).isEqualTo(inputInJson);
		assertEquals(HttpStatus.OK.value(), response.getStatus());

		// test case when data is not given

		Mockito.when(mockservice.create(Mockito.any(Employee.class))).thenReturn(null);

		MvcResult result1 = mockMvc.perform(post("/employee/insert").accept(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse response1 = result1.getResponse();
		String outputInJson1 = response1.getContentAsString();
		System.out.println(outputInJson1);
		assertEquals(HttpStatus.BAD_REQUEST.value(), response1.getStatus());

		// test case when wrong or null data is given

		String exampleJson = this.mapToJson(emp3);

		MvcResult result2 = mockMvc.perform(post("/employee/insert").accept(MediaType.APPLICATION_JSON)
				.content(exampleJson).contentType(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse response2 = result2.getResponse();

		assertEquals(HttpStatus.BAD_REQUEST.value(), response2.getStatus());

	}

	// test ("/employee/viewBy/{id}")

	@Test
	public void testViewById() throws Exception {
		String inputInJson = this.mapToJson(emp);
		
		// Test case for status code 200 and for correct output

		Mockito.when(mockservice.ViewById(Mockito.anyInt())).thenReturn(Optional.of(emp));

		MvcResult result = mockMvc
				.perform(get("/employee/viewBy/{id}", new Integer(123)).accept(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse response = result.getResponse();
		String outputInJson = response.getContentAsString();

		assertThat(outputInJson).isEqualTo(inputInJson);
		assertEquals(HttpStatus.OK.value(), response.getStatus());

		
		// test case for status code 400 i.e when wrong data is given
		
		
		MvcResult result1 = mockMvc
				.perform(get("/employee/viewBy/{id}", new String("deva")).accept(MediaType.APPLICATION_JSON))
				.andReturn();
		MockHttpServletResponse response1 = result1.getResponse();

		assertEquals(HttpStatus.BAD_REQUEST.value(), response1.getStatus());

		// test case for 404 i.e when data is not given

		MvcResult result2 = this.mockMvc.perform(delete("/employee/viewBy/")).andReturn();
		MockHttpServletResponse response2 = result2.getResponse();

		assertEquals(HttpStatus.NOT_FOUND.value(), response2.getStatus());
		

	}

	// test ("/employee/delete/{id}")

	@Test
	public void deleteByIdTest() throws Exception {
		Mockito.when(mockservice.delete(Mockito.anyInt())).thenReturn("employee with given id not found");
		// Test case for status code 200 and for correct output

		MvcResult result = this.mockMvc.perform(delete("/employee/delete/{id}", new Integer(123))).andReturn();
		MockHttpServletResponse response = result.getResponse();
		String outputStr = response.getContentAsString();

		assertThat(outputStr).isEqualTo("employee with given id not found");
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		// test case for status code 400 i.e when correct data type is not given

		MvcResult result1 = this.mockMvc.perform(delete("/employee/delete/{id}", new String("deva"))).andReturn();
		MockHttpServletResponse response1 = result1.getResponse();

		assertEquals(HttpStatus.BAD_REQUEST.value(), response1.getStatus());

		// test case for 404 i.e when data is not given

		MvcResult result2 = this.mockMvc.perform(delete("/employee/delete/")).andReturn();
		MockHttpServletResponse response2 = result2.getResponse();

		assertEquals(HttpStatus.NOT_FOUND.value(), response2.getStatus());
	}

	// test ("/employee/update/{id}")

	@Test
	public void updateByIdTest() throws Exception {
		String inputInJson = this.mapToJson(emp);
		// Test case for status code 200 and for correct output

		Mockito.when(mockservice.update(Mockito.anyInt(), Mockito.any(Employee.class))).thenReturn(emp);
		MvcResult result = this.mockMvc.perform(put("/employee/update/{id}", new Integer(123))
				.accept(MediaType.APPLICATION_JSON).content(inputInJson).contentType(MediaType.APPLICATION_JSON))
				.andReturn();
		MockHttpServletResponse response = result.getResponse();
		String outputInJson = response.getContentAsString();

		assertThat(outputInJson).isEqualTo(inputInJson);
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		// test case for status code 400

		MvcResult result1 = this.mockMvc.perform(put("/employee/update/{id}", new String("deva"))
				.accept(MediaType.APPLICATION_JSON).content(inputInJson).contentType(MediaType.APPLICATION_JSON))
				.andReturn();
		MockHttpServletResponse response1 = result1.getResponse();

		assertEquals(HttpStatus.BAD_REQUEST.value(), response1.getStatus());

		// when data is not given
		MvcResult result2 = mockMvc
				.perform(put("/employee/update/{id}", new Integer(123)).accept(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse response2 = result2.getResponse();
		assertEquals(HttpStatus.BAD_REQUEST.value(), response2.getStatus());

		// when id is not specified

		MvcResult result3 = this.mockMvc.perform(put("/employee/update/").accept(MediaType.APPLICATION_JSON)
				.content(inputInJson).contentType(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse response3 = result3.getResponse();
		assertEquals(HttpStatus.NOT_FOUND.value(), response3.getStatus());

		// when null data is given

		String exampleJson = this.mapToJson(emp3);
		MvcResult result4 = mockMvc.perform(put("/employee/update/{id}", new Integer(123))
				.accept(MediaType.APPLICATION_JSON).content(exampleJson).contentType(MediaType.APPLICATION_JSON))
				.andReturn();
		MockHttpServletResponse response4 = result4.getResponse();

		assertEquals(HttpStatus.BAD_REQUEST.value(), response4.getStatus());

	}

	// test ("/employee/viewAll")

	@Test
	public void viewAllTest() throws Exception {
		List<Employee> list = new ArrayList<Employee>();
		list.add(emp);
		list.add(emp2);
		String listJson = this.mapToJson(list);

		Mockito.when(mockservice.viewAll()).thenReturn(list);
		// Test case for status code 200 and for correct output

		MvcResult result = this.mockMvc.perform(get("/employee/viewAll")).andReturn();
		MockHttpServletResponse response = result.getResponse();
		String outputInJson = response.getContentAsString();
		assertThat(outputInJson).isNotEqualTo(null);
		assertThat(outputInJson).isEqualTo(listJson);
		assertEquals(HttpStatus.OK.value(), response.getStatus());

	}

}

package com.chensoul.junit5.controller;

import com.chensoul.junit5.model.Employee;
import com.chensoul.junit5.service.EmployeeService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

	@MockBean
	EmployeeService employeeService;

	@Autowired
	MockMvc mockMvc;

	@Test
	public void testfindAll() throws Exception {
		Employee employee = new Employee("Lokesh", "Gupta");
		List<Employee> employees = Arrays.asList(employee);

		Mockito.when(employeeService.findAll()).thenReturn(employees);

		mockMvc.perform(get("/employee"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$", Matchers.hasSize(1)))
			.andExpect(jsonPath("$[0].firstName", Matchers.is("Lokesh")));
	}

}
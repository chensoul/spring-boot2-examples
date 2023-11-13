package com.chensoul.junit5.service;

import com.chensoul.junit5.model.Employee;
import com.chensoul.junit5.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

	@InjectMocks
	EmployeeService employeeService;

	@Mock
	EmployeeRepository employeeRepository;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testFindAllEmployees() {
		List<Employee> list = new ArrayList<Employee>();
		Employee empOne = new Employee("John", "John");
		Employee empTwo = new Employee("Alex", "kolenchiski");
		Employee empThree = new Employee("Steve", "Waugh");

		list.add(empOne);
		list.add(empTwo);
		list.add(empThree);

		when(employeeRepository.findAll()).thenReturn(list);

		//test
		List<Employee> empList = employeeService.findAll();

		assertEquals(3, empList.size());
		verify(employeeRepository, times(1)).findAll();
	}

	@Test
	void testCreateOrSaveEmployee() {
		Employee employee = new Employee("Lokesh", "Gupta");

		employeeService.save(employee);

		verify(employeeRepository, times(1)).save(employee);
	}
}

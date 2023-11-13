package com.chensoul.junit5;

import com.chensoul.junit5.controller.EmployeeController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SpringBoot2Junit5ApplicationTest {

	@Autowired
	EmployeeController employeeController;

	@Test
	public void contextLoads() {
		Assertions.assertThat(employeeController).isNotNull();
	}
}

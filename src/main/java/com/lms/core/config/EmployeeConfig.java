package com.lms.core.config;

import java.util.Arrays;
import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lms.core.bean.Employee;
import com.lms.core.repository.EmployeeRepository;

@Configuration
public class EmployeeConfig {
	
	@Bean
	CommandLineRunner commandLineRunner( EmployeeRepository repository) {
		return args ->{
			Employee Emp1 = new Employee("Priya Kokas","pryakks@gmail.com","Sr. Consultant","Admin","pass*123",new Date(), 1);
			Employee Emp2 = new Employee("Abhishek Sharma","abhi@gmail.com","Sr. Consultant","Manager","pass564",new Date(), 1);
			
			repository.saveAll(Arrays.asList(Emp1,Emp2));
		};
	}
}

package com.lms.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lms.core.bean.Employee;
import com.lms.core.service.EmployeeService;

@RestController
@RequestMapping(path = "lms/employee")
public class EmployeeController {
	
	//use to write API
	
	private final EmployeeService employeeService;
	//we are not creating object of employeeService using new EmployeeService(), we will use dependency injection hence @Autowired
	@Autowired
	private EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();//N-tier design pattern
	}
	
	@PostMapping
	public void addNewEmployee(@RequestBody Employee employee) {
		employeeService.addNewEmployee(employee);
	}
	
	@DeleteMapping(path = "{EmployeeId}")
	public void deleteEmployee(@PathVariable("EmployeeId") int employeeId) {
		employeeService.deleteEmloyee(employeeId);
	}
	
	@PutMapping(path = "{EmployeeId}")
	public void updateEmployee(
			@PathVariable("EmployeeId") int employeeId, 
			@RequestParam(required = false) String name,
			@RequestParam(required = false) String password, 
			@RequestParam(required = false) Integer ManagerId ) {
		employeeService.updateEmployee(employeeId, name, password );
	}
}

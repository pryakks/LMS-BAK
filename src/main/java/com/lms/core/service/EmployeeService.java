package com.lms.core.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.lms.core.bean.Employee;
import com.lms.core.repository.EmployeeRepository;

//@controller and @service is same but its for more readability
@Service
public class EmployeeService {
	
	//does all the modification work
	
	private final EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
//		return Arrays.asList(new Employee(1,"Priya Kokas","pryakks@gmail.com","Sr. Consultant","Admin","pass*123",new Date(), 1));
	}

	public void addNewEmployee(Employee employee) {
		Optional<Employee> employeeOptional = employeeRepository.findEmployeeByEmail(employee.getEmailId());
		if(employeeOptional.isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Email already exist");
//			throw new IllegalStateException("Email already exist");
		}
		employeeRepository.save(employee);		
	}

	public void deleteEmloyee(int employeeId) {
		if(!employeeRepository.existsById(employeeId)) {
			throw new IllegalStateException("Employee with Id : "+employeeId+" does not exist");
		}
		employeeRepository.deleteById(employeeId);
	}
	
	@Transactional 
	public void updateEmployee(int employeeId, String empName,String password) {
		Employee employee= employeeRepository.findById(employeeId).orElseThrow(()-> new IllegalStateException("Employee with Id : "+employeeId+" does not exist"));
	
		if(empName !=null && empName.length()>0 && !Objects.equals(employee.getEmpName(), empName)) {
			employee.setEmpName(empName);
		}
		
//		if(managerId > 0 && !Objects.equals(employee.getManagerId(), managerId)) {
//			employee.setManagerId(managerId);
//		}
		
		if(password !=null && password.length()>0 && !Objects.equals(employee.getPassword(), password)) {
			employee.setPassword(password);
		}
	
	}
}

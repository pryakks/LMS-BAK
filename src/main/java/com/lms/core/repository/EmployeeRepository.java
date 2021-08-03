package com.lms.core.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lms.core.bean.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	@Query("SELECT emp FROM Employee emp where emp.emailId =?1")// this is JPQL
	Optional<Employee> findEmployeeByEmail(String email);
}

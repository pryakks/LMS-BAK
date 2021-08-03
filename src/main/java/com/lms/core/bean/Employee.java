package com.lms.core.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {
	@Id
	@SequenceGenerator(
			name= "employee_sequence",
			sequenceName ="employee_sequence",
			allocationSize=1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "employee_sequence"
	)
	@Column(name = "EMP_ID")
	public int empId;
	@Column(name = "EMP_NAME")
	public String empName;
	@Column(name = "EMAIL_ID")
	public String emailId;
	@Column(name = "DESIGNATION")
	public String designation;
	@Column(name = "ROLE")
	public String role;
	@Column(name = "PASSWORD")
	public String password;
	@Column
	public Date DOJ;
	@Column(name = "MANAGER_ID")
	public int managerId;
	
	public Employee() {
	}

	public Employee(int empId, String empName, String emailId, String designation, String role, String password,
			Date dOJ, int managerId) {
		this.empId = empId;
		this.empName = empName;
		this.emailId = emailId;
		this.designation = designation;
		this.role = role;
		this.password = password;
		this.DOJ = dOJ;
		this.managerId = managerId;
	}
	public Employee(String empName, String emailId, String designation, String role, String password,
			Date dOJ, int managerId) {
		this.empName = empName;
		this.emailId = emailId;
		this.designation = designation;
		this.role = role;
		this.password = password;
		this.DOJ = dOJ;
		this.managerId = managerId;
	}

	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDOJ() {
		return DOJ;
	}
	public void setDOJ(Date dOJ) {
		DOJ = dOJ;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", emailId=" + emailId + ", designation="
				+ designation + ", role=" + role + ", password=" + password + ", DOJ=" + DOJ + ", managerId=" + managerId
				+ "]";
	}
}

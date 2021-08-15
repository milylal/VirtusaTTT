package com.dypiemr.employee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class EmployeeModel {

	// define fields
	
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="employeeId")
	private long id;
	@Column(name="employeeName")
	private String employeeName;

	@Column(name="employeeEmail")
	private String employeeEmail;
	
	@Column(name="dept")
	private String dept;
	
	// define constructors
	
	public EmployeeModel() {
		
	}

	public EmployeeModel(String employeeName, String employeeEmail, String dept) {
		this.employeeName = employeeName;
		this.employeeEmail = employeeEmail;
		this.dept = dept;
	}


	// define getter/setter

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "EmployeeModel [employeeId=" + id + ", employeeName=" + employeeName + ", employeeEmail=" + employeeEmail
				+ ", dept=" + dept + "]";
	}
	
		
}


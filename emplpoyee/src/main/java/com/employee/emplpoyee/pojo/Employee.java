package com.employee.emplpoyee.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {

	@Id
	@Column(name = "employeID")
	private int employeID;
	@Column(name = "eName")
	private String eName;

	@Column(name = "eEmail")
	private String eEmail;

	@Column(name = "eLocation")
	private String eLocation;

	public Employee(int employeID, String name, String email, String location) {
		super();
		this.employeID = employeID;
		this.eName = name;
		this.eEmail = email;
		this.eLocation = location;
	}

	public Employee() {
	}

	public int getEmployeID() {
		return employeID;
	}

	public void setEmployeID(int employeID) {
		this.employeID = employeID;
	}

	public String getName() {
		return eName;
	}

	public void setName(String name) {
		this.eName = name;
	}

	public String getEmail() {
		return eEmail;
	}

	public void setEmail(String email) {
		this.eEmail = email;
	}

	public String getLocation() {
		return eLocation;
	}

	public void setLocation(String location) {
		this.eLocation = location;
	}

}

package com.restTemplate.RestTemplateExample.pojo;



public class Employee {

	private int EMPLOYEID;

	private String ENAME;

	private String EEMAIL;
		private String ELOCATION;

	public Employee(int employeID, String name, String email, String location) {
		super();
		this.EMPLOYEID = employeID;
		this.ENAME = name;
		this.EEMAIL = email;
		this.ELOCATION = location;
	}

	@Override
	public String toString() {
		return "Employee [EMPLOYEID=" + EMPLOYEID + ", ENAME=" + ENAME + ", EEMAIL=" + EEMAIL + ", ELOCATION="
				+ ELOCATION + "]";
	}

	public Employee() {
	}

	public int getEmployeID() {
		return EMPLOYEID;
	}

	public void setEmployeID(int employeID) {
		this.EMPLOYEID = employeID;
	}

	public String getName() {
		return ENAME;
	}

	public void setName(String name) {
		this.ENAME = name;
	}

	public String getEmail() {
		return EEMAIL;
	}

	public void setEmail(String email) {
		this.EEMAIL = email;
	}

	public String getLocation() {
		return ELOCATION;
	}

	public void setLocation(String location) {
		this.ELOCATION = location;
	}

}

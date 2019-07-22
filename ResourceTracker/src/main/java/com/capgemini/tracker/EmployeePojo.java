package com.capgemini.tracker;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="EmployeeDetails")

public class EmployeePojo 
{
	@Id
	private int employeeId;
	private String employeeName; 
	
	private String localGrade;
	private String grade;
	private String mode;
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	private String cloudJoiningDate;
	private String joiningDate;
	private String officeLocation;
	private String location;
	private String seat;
	private String email;
	private String benchStartDate;
	private String level3EngagementRole;
	private String gP;
	private String currentAccount;
	private String projectCode;
	private String projectName;
	private String projectStartDate;
	private String projectEndDate;
	private String primarySkill;
	public EmployeePojo(int employeeId, String employeeName, String localGrade, String grade, String mode,
			String cloudJoiningDate, String joiningDate, String officeLocation, String location, String seat,
			String email, String benchStartDate, String level3EngagementRole, String gP, String currentAccount,
			String projectCode, String projectName, String projectStartDate, String projectEndDate,
			String primarySkill) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.localGrade = localGrade;
		this.grade = grade;
		this.mode = mode;
		this.cloudJoiningDate = cloudJoiningDate;
		this.joiningDate = joiningDate;
		this.officeLocation = officeLocation;
		this.location = location;
		this.seat = seat;
		this.email = email;
		this.benchStartDate = benchStartDate;
		this.level3EngagementRole = level3EngagementRole;
		this.gP=gP;
		this.currentAccount = currentAccount;
		this.projectCode = projectCode;
		this.projectName = projectName;
		this.projectStartDate = projectStartDate;
		this.projectEndDate = projectEndDate;
		this.primarySkill = primarySkill;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	
	
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getCloudJoiningDate() {
		return cloudJoiningDate;
	}
	public void setCloudJoiningDate(String cloudJoiningDate) {
		this.cloudJoiningDate = cloudJoiningDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBenchStartDate() {
		return benchStartDate;
	}
	public void setBenchStartDate(String benchStartDate) {
		this.benchStartDate = benchStartDate;
	}
	public String getLocalGrade() {
		return localGrade;
	}
	public void setLocalGrade(String localGrade) {
		this.localGrade = localGrade;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getOfficeLocation() {
		return officeLocation;
	}
	public void setOfficeLocation(String officeLocation) {
		this.officeLocation = officeLocation;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}
	public String getLevel3EngagementRole() {
		return level3EngagementRole;
	}
	public void setLevel3EngagementRole(String level3EngagementRole) {
		this.level3EngagementRole = level3EngagementRole;
	}
	public String getgP() {
		return gP;
	}
	public void setgP(String gP) {
		this.gP = gP;
	}
	public String getCurrentAccount() {
		return currentAccount;
	}
	public void setCurrentAccount(String currentAccount) {
		this.currentAccount = currentAccount;
	}
	public String getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectStartDate() {
		return projectStartDate;
	}
	public void setProjectStartDate(String projectStartDate) {
		this.projectStartDate = projectStartDate;
	}
	public String getProjectEndDate() {
		return projectEndDate;
	}
	public void setProjectEndDate(String projectEndDate) {
		this.projectEndDate = projectEndDate;
	}
	public String getPrimarySkill() {
		return primarySkill;
	}
	public void setPrimarySkill(String primarySkill) {
		this.primarySkill = primarySkill;
	}
	@Override
	public String toString() {
		return "TrackerPojo [employeeId=" + employeeId + ", employeeName=" + employeeName + ", localGrade=" + localGrade
				+ ", grade=" + grade + ", mode=" + mode + ", cloudJoiningDate=" + cloudJoiningDate + ", joiningDate="
				+ joiningDate + ", officeLocation=" + officeLocation + ", location=" + location + ", seat=" + seat
				+ ", email=" + email + ", benchStartDate=" + benchStartDate + ", level3EngagementRole="
				+ level3EngagementRole + ", gP=" + gP + ", currentAccount=" + currentAccount + ", projectCode="
				+ projectCode + ", projectName=" + projectName + ", projectStartDate=" + projectStartDate
				+ ", projectEndDate=" + projectEndDate + ", primarySkill=" + primarySkill + "]";
	}
	

}

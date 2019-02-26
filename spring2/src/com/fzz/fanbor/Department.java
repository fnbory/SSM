package com.fzz.fanbor;

public class Department {
	 private int id;
	 private String departmentName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public Department(int id, String departmentName) {
		this.id = id;
		this.departmentName = departmentName;
	}
	public Department() {
		
	}
	 
}

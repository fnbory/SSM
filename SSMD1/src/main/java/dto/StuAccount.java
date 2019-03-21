package dto;

import entity.Student;

public class StuAccount {
	private String password;
	private String userId;
	private Student student;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public StuAccount(String password, String userId, Student student) {
		super();
		this.password = password;
		this.userId = userId;
		this.student = student;
	}
	public StuAccount() {
		super();
	}
	@Override
	public String toString() {
		return "StuAccount [password=" + password + ", userId=" + userId + ", student=" + student + "]";
	}
	
}

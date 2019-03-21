package dto;

import entity.Teacher;

public class TecAccount {
	private int id;
	private String userId;
	private String password;
	private String person;
	private Teacher teacher;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public TecAccount(int id, String userId, String password, String person, Teacher teacher) {
		super();
		this.id = id;
		this.userId = userId;
		this.password = password;
		this.person = person;
		this.teacher = teacher;
	}
	public TecAccount() {
		super();
	}
	@Override
	public String toString() {
		return "TecAccount [id=" + id + ", userId=" + userId + ", password=" + password + ", person=" + person
				+ ", teacher=" + teacher + "]";
	}
	
}

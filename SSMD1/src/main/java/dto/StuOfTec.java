package dto;

import java.util.List;

import entity.Student;

public class StuOfTec {
	private int id;
	private String userId;
	private String name;
	private int cls;
	private List<ScoreOfStu> students;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCls() {
		return cls;
	}
	public void setCls(int cls) {
		this.cls = cls;
	}
	public List<ScoreOfStu> getStudents() {
		return students;
	}
	public void setStudents(List<ScoreOfStu> students) {
		this.students = students;
	}
	public StuOfTec(int id, String userId, String name, int cls, List<ScoreOfStu> students) {
		super();
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.cls = cls;
		this.students = students;
	}
	public StuOfTec() {
		super();
	}
	@Override
	public String toString() {
		return "StuOfTec [id=" + id + ", userId=" + userId + ", name=" + name + ", cls=" + cls + ", students="
				+ students + "]";
	}
	
}

package entity;

public class Teacher {
	private int id;
	private String userId;
	private String name;
	private int cls;
	private String sex;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Teacher(int id, String userId, String name, int cls, String sex) {
		super();
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.cls = cls;
		this.sex = sex;
	}
	
	public Teacher(String userId, String name, int cls) {
		super();
		this.userId = userId;
		this.name = name;
		this.cls = cls;
	}
	public Teacher() {
		super();
	}
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", userId=" + userId + ", name=" + name + ", cls=" + cls + ", sex=" + sex + "]";
	}
	
}

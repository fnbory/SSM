package entity;

public class Student {
	private int id;
	private String userId;
	private String name;
	private String sex;
	private String age;
	private String phone;
	private int cls;
	public int getCls() {
		return cls;
	}
	public void setCls(int cls) {
		this.cls = cls;
	}
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Student(int id, String userId, String name, String sex, String age, String phone, int cls) {
		super();
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.phone = phone;
		this.cls = cls;
	}
	public Student() {
		super();
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", userId=" + userId + ", name=" + name + ", sex=" + sex + ", age=" + age
				+ ", phone=" + phone + ", cls=" + cls + "]";
	}
	
	
}

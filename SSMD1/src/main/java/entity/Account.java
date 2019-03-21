package entity;

import org.springframework.stereotype.Controller;


public class Account {
	private int id;
	private String userId;
	private String password;
	private String person;
	private int ismanager;
	public void setIsmanager(int ismanager) {
		this.ismanager = ismanager;
	}
	public int getIsmanager() {
		return ismanager;
	}
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Account(int id, String userId, String password, String person, int ismanager) {
		super();
		this.id = id;
		this.userId = userId;
		this.password = password;
		this.person = person;
		this.ismanager = ismanager;
	}
	public Account(int id, String userId, String password, String person) {
		super();
		this.id = id;
		this.userId = userId;
		this.password = password;
		this.person = person;
	}
	public Account() {
		super();
	}
	public Account( String userId, String password) {
		super();
		
		this.userId = userId;
		this.password = password;
		
	}
	public Account( String userId, String password,String person) {
		super();
		this.person=person;
		this.userId = userId;
		this.password = password;
		
	}
	
	
	public Account(String userId, String password, String person, int ismanager) {
		super();
		this.userId = userId;
		this.password = password;
		this.person = person;
		this.ismanager = ismanager;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", userId=" + userId + ", password=" + password + ", person=" + person + "]";
	}
	
	
	
}

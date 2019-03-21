package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.Student;

public interface StudentDao {
	public List<Student> getStusbycls(int cls);
	public List<Student> getstus();
	public Student getstuByid(String userid);
	public void addstu(Student student);
	public void delstu(String name);
	public void updatestu(@Param("student")Student student);
	
}

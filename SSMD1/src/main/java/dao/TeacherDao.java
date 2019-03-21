package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.Student;
import entity.Teacher;

public interface TeacherDao {
	public Teacher getTeacher(String userid);
	public List<Teacher> gettecs();
	public void updatetec(@Param("tec")Teacher teacher);
	public void inserttec(@Param("teacher")Teacher teacher);
	public void updatetecact(@Param("tecac")Teacher teacher);
}

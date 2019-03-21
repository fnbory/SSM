package dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import entity.Teacher;

public class TeacherDaoTest  extends BaseTest{
	@Autowired
	private TeacherDao teacherao;
	@Test
	public void test1() {
		Teacher teacher=new Teacher(2, "0002", "zhan", 1, "female");
		teacherao.updatetec(teacher);
		teacherao.getTeacher("0002");
	}
	@Test
	public void test2() {
		List<Teacher> teachers=teacherao.gettecs();
		System.out.println(teachers);
	}
	@Test
	public void test3() {
		Teacher teacher=new Teacher("0009","bob",1);
		teacherao.inserttec(teacher);
		
	}

}

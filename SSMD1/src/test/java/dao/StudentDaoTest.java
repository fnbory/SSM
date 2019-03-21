package dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import entity.Student;

public class StudentDaoTest extends BaseTest {
	@Autowired
	private StudentDao studentdao;
	@Test
	public void test() {
		List<Student> ss=studentdao.getstus();
		System.out.println(ss);
	}
//	@Test
//	public void testgetall() {
//		List<Student> students=studentdao.getStus();
//		System.out.println(students);
//	}
}

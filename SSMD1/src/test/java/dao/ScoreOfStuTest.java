package dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import dto.ScoreOfStu;
import dto.ScoreOfStuDao;

public class ScoreOfStuTest extends BaseTest {

	@Autowired
	private ScoreOfStuDao scoreofstudao;
	
	@Test
	public void test() {
		List<ScoreOfStu> scoreOfStu=scoreofstudao.getstuscore(1);
		System.out.println(scoreOfStu);
	}

}

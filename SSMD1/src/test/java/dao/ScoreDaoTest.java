package dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import entity.Score;

public class ScoreDaoTest extends BaseTest{

	@Autowired
	private ScoreDao scoredao;
	
	@Test
	public void test() {
		Score score=scoredao.getScore("0001");
		System.out.println(score);
	}

}

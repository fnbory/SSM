package dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import dto.StuOfTec;

public class StuOfTecDaoTest extends BaseTest {
	@Autowired
	private StuOfTecDao stuoftecdao;
	@Test
	public void test() {
		StuOfTec stuOfTec=stuoftecdao.getStusOfTec("0002");
		System.out.println(stuOfTec);
	}

}

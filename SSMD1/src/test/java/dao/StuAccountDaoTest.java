package dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import dto.StuAccount;

public class StuAccountDaoTest extends BaseTest {
	@Autowired
	private StuAccountDao stuaccountdao;
	@Test
	public void test() {
		List<StuAccount> stuAccounts=stuaccountdao.getStuAccount("student");
		System.out.println(stuAccounts);
	}

}

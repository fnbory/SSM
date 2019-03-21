package dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import dto.TecAccount;

public class TecAccountDaoTest extends BaseTest {
	@Autowired
	private TecAccountDao tecaccountdao;
	@Test
	public void test() {
		List<TecAccount> tecAccounts=tecaccountdao.gettecaccounts("teacher");
		System.out.println(tecAccounts);
	}
	@Test
	public void test2() {
		TecAccount tecAccount=tecaccountdao.gettecaccount("0002");
		System.out.println(tecAccount);
	}

}

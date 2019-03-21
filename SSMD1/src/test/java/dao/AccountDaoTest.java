package dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import entity.Account;

public class AccountDaoTest extends BaseTest{
@Autowired
private AccountDao accountdao;
	@Test
	public void test() {
		accountdao.deleteAccount("0010");
	}

}

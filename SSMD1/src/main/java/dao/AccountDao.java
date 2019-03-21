package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.Account;

public interface AccountDao {
	public Account getActByUid(String userid);
	public Account getAccount(Account account);
	public List<Account> getAccounts();
	public void deleteAccount(String userid);
	public void addAccount(@Param("account")Account account);
	public void updateacct(@Param("acct")Account account);
	public List<Account> getaccbypsn(String person);
}

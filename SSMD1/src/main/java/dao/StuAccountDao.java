package dao;

import java.util.List;

import dto.StuAccount;

public interface StuAccountDao {
	public List<StuAccount> getStuAccount(String person);
	
}

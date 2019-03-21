package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import dto.TecAccount;

public interface TecAccountDao {
	public List<TecAccount> gettecaccounts(String person);
	public TecAccount gettecaccount(String userid);
	public void updatetecacct(@Param("account")TecAccount tecAccount);
	
}

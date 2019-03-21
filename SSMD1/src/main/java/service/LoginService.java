package service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.AccountDao;
import entity.Account;


public interface LoginService {
	public boolean isExist(Account account,String person);
	
}

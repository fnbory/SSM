package serviceimpl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.AccountDao;
import entity.Account;
import service.LoginService;
@Service
public class LoginServiceimpl implements LoginService {
	@Autowired
	private AccountDao accountDao;
	private Logger log=Logger.getLogger(LoginService.class);
	//
	@Override
	public boolean isExist(Account account,String person) {
		log.info("调用是否存在的service");
		Account account2=accountDao.getAccount(account);
		if(account2!=null&& person.equals(account2.getPerson())) {
			return true;
			}
		return false;
	}
}

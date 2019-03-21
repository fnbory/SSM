package web;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.AccountDao;
import entity.Account;
import service.LoginService;
import serviceimpl.LoginServiceimpl;
@Controller
public class AccountController {
	@Autowired
	private LoginServiceimpl loginserviceimpl;
	@Autowired
	private AccountDao accontdao;
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(Account account,Map<String,String> map,HttpSession session,HttpServletRequest request) {
		System.out.println(account);
		String userid=account.getUserId();
		String password=account.getPassword();
		Account account2=new Account(userid, password);
		Cookie[] cookies=request.getCookies();
		String person=null;
		for (Cookie cookie : cookies) {
			if("student".equals(cookie.getValue())) {
				person="student";
			}
			if("teacher".equals(cookie.getValue())) {
				person="teacher";
			}
		}
		if(userid!=null&&password!=null&&loginserviceimpl.isExist(account2,person)){
			Account account3=accontdao.getAccount(account2);
			session.setAttribute("account", account3);
			
			return "index";
		}
		map.put("msg", "账号密码或者身份错误，请重新输入");
		return "login";
	}
	@RequestMapping(value="index")
	public String index() {
		return "index";
	}
	@RequestMapping(value="login")
	public String login() {
		return "login";
	}
}

package web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dao.AccountDao;
import dao.StuAccountDao;
import dao.StudentDao;
import dao.TeacherDao;
import dao.TecAccountDao;
import dto.StuAccount;
import dto.TecAccount;
import entity.Account;
import entity.Student;
import entity.Teacher;

@Controller
public class ManagerController {
	@Autowired
	private StuAccountDao stuactdao;
	@Autowired
	private StudentDao studentdao;
	@Autowired
	private TecAccountDao tecaccountdao;
	@Autowired
	private AccountDao accountdao;
	@Autowired
	private TeacherDao teacheerdao;
	@ModelAttribute("acct")
	public void getTecaccount(@RequestParam(value="userId",required=false,defaultValue="0") String userId,Map<String ,Object> map) {
		if(userId!="0") {
			Account account=accountdao.getActByUid(userId);
			map.put("acct",account);
		}
	}
	@ModelAttribute("atec")
	public void  getTeacher(@RequestParam(value="userId",required=false,defaultValue="0") String userId,Map<String ,Object> map) {
		if(userId!="0") {
			Teacher teacher=teacheerdao.getTeacher(userId);
			map.put("atec", teacher);
		}
	}
	@ModelAttribute("astu")
	public void getStudent(@RequestParam(value="userId",required=false,defaultValue="0") String userId,Map<String ,Object> map) {
		if(userId!="0") {
			Student student=studentdao.getstuByid(userId);
			map.put("astu", student);
		}
	}
	
	@RequestMapping("listtecs")
	public String listtecs(Map<String,Object> map) {
		List<TecAccount> teachers=tecaccountdao.gettecaccounts("teacher");
		map.put("tecs", teachers);
		return "teachers";
	}
	@RequestMapping("liststus")
	public String liststus(Map<String,Object> map) {
		List<StuAccount> students=stuactdao.getStuAccount("student");
		map.put("students", students);
		return "students";
	}
	
	@RequestMapping(value="inserttec")
	public String inserttec(@RequestParam("userid")String userid,@RequestParam("name")String name,@RequestParam("password")String password,
			@RequestParam("cls")int cls) {
			Account account=new Account(userid, password, "teacher", 0);
			accountdao.addAccount(account);
			Teacher teacher=new Teacher(userid, name, cls);
			teacheerdao.inserttec(teacher);
			return "redirect:/listtecs";
	}
	@RequestMapping(value="insertstu")
	public String insertstu(@RequestParam("userId")String userid,@RequestParam("password")String password,@RequestParam("name")String name,
			@RequestParam("cls")int cls,@RequestParam("age")String age,@RequestParam("phone")String phone,Student student) {
			
		Account account=new Account(userid, password,"student", 0);
			accountdao.addAccount(account);
			studentdao.addstu(student);
			
			return "redirect:liststus";
	}
	
	@RequestMapping(value="update_tec_act",method=RequestMethod.PUT)
	public String  updatetec(@RequestParam("cls") int cls,@ModelAttribute("acct")Account account,@ModelAttribute("atec")Teacher teacher) {
		accountdao.updateacct(account);   //先在modelattribute得到目标bean，此处已经转为了我们需要的值
		teacheerdao.updatetecact(teacher);
		return "redirect:listtecs";
	}
	@RequestMapping(value="update_stu_act",method=RequestMethod.PUT)
	public String  updatestu(@RequestParam("cls") int cls,@ModelAttribute("acct")Account account,@ModelAttribute("astu")Student student) {
		accountdao.updateacct(account);       //先在modelattribute得到目标bean，此处已经转为了我们需要的值
		studentdao.updatestu(student);
		return "redirect:/liststus";
	}
	@RequestMapping(value="delete_tec_act",method=RequestMethod.POST)
	public void deletetec(@RequestParam("userid")String userid) {
		accountdao.deleteAccount(userid);
	}
	@RequestMapping(value="delete_stu_act",method=RequestMethod.POST)
	public void delete(@RequestParam("userid")String userid) {
		accountdao.deleteAccount(userid);
	}
	
}

package web;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.ScoreDao;
import dao.StudentDao;
import dao.TeacherDao;
import entity.Account;
import entity.Student;
import entity.Teacher;
@Controller
public class StudentController {
	@Autowired
	private TeacherDao teacherDao;
	@Autowired
	private ScoreDao scoredao;
	@Autowired
	private StudentDao studentdao;
	
	public String getuserid(HttpServletRequest request) {
		HttpSession session=request.getSession();
		Account account=(Account) session.getAttribute("account");
		return account.getUserId();
	}
	
	public String getperson(HttpServletRequest request) {
		HttpSession session=request.getSession();
		Account account=(Account) session.getAttribute("account");
		System.out.println("account:::"+account+"wefwfew"+account.getPerson());
		return account.getPerson();
	}
	
	
	@ModelAttribute
	public void getStu(@RequestParam(value="userId",required=false,defaultValue="")String userid,Map<String ,Object> map,HttpServletRequest request) {
		if("student".equals(getperson(request))) {
			if(userid!="") {
				System.out.println("wefwefwe"+userid);
				System.out.println(studentdao.getstuByid(userid));
				map.put("student", studentdao.getstuByid(userid));
			}
		}
		else {
			System.out.println(getperson(request));
			System.out.println(userid+"wefewfwfwff");
			if(userid!="") {
				System.out.println("wefwefwe"+userid);
				map.put("teacher", teacherDao.getTeacher(userid));
				}
			}
		}
	@RequestMapping(value="listallscore")
	public String listscore(HttpServletRequest request,Map<String, Object> map) {
		String userid=getuserid(request);
		map.put("score",scoredao.getScore(userid));
		return "myscore";
	}
	
	@RequestMapping(value="stuinfo")
	public String stuinfo(HttpServletRequest request,Map<String, Object> map) {
		String userid=getuserid(request);
		map.put("student",studentdao.getstuByid(userid));
		return "infoofst";
	}
	@RequestMapping("tecinfo")
	public String tecinfo(Map<String,Object> map,HttpServletRequest request) {
		String userid=getuserid(request);
		map.put("teacher", teacherDao.getTeacher(userid));
		return "infoofst";
	}
	@RequestMapping(value="UpdateInfo/{userId}")   //此处如果直接在input中form就会在UpdateStuInfo/的基础上转发，自然是找不到的。可能会造成说405错误，即只允许post/get/head
	public String UpdateStuInfo(@PathVariable("userId") String userId, Map<String, Object> map,HttpServletRequest request) {
		System.out.println("ssss"+userId);
		if("student".equals(getperson(request))) {
			map.put("studt", studentdao.getstuByid(userId));
			}
		if("teacher".equals(getperson(request))) {
			map.put("teach", teacherDao.getTeacher(userId));
		}
		return "input";
	}
	
	@RequestMapping(value="operate",method=RequestMethod.PUT)
	public String operate(Teacher teacher,Student student,HttpServletRequest request) {
		if("student".equals(getperson(request))) {
			studentdao.updatestu( student);
			return "redirect:/stuinfo";
		}
		else {
			teacherDao.updatetec(teacher);
			return "redirect:/tecinfo";
		}
	}
}

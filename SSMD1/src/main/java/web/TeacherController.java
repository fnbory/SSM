package web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dao.ScoreDao;
import dao.StuOfTecDao;
import dao.StudentDao;
import dao.TeacherDao;
import dto.StuOfTec;
import entity.Account;
import entity.Score;
import entity.Student;
import entity.Teacher;

@Controller
public class TeacherController {
	@Autowired
	private StuOfTecDao stuOfTecDao;
	@Autowired
	private TeacherDao teacherDao;
	@Autowired
	private ScoreDao scoreDao;
	@Autowired
	private StudentDao studentDao;
	@ModelAttribute("scor")
	public void getScore(@RequestParam(value="tec_stu_userid",required=false,defaultValue="0")String userid,Map<String,Object> map) {
		System.out.println("wefwfwefwefwefwf"+userid+"wefwf");
		if(userid!="0") {
			Score score=scoreDao.getScore(userid);
			System.out.println(score);
			map.put("scor", score);
		}
	}
	private String getuserid(HttpServletRequest request) {
		HttpSession session=request.getSession();
		Account account=(Account) session.getAttribute("account");
		return account.getUserId();
	}
	@RequestMapping("listallclass")
	public String getstuoftec(HttpServletRequest  request,Map<String,Object> map) {
		String userid=getuserid(request);
		StuOfTec stuOfTec=stuOfTecDao.getStusOfTec(userid);
		map.put("stuoftec", stuOfTec);
		return "stuoftec";
	}
	@RequestMapping(value="updateScore/{useid}",method=RequestMethod.PUT)
	public String  updateScore(@ModelAttribute("scor") Score score) {
		scoreDao.updateScore(score);
		return "redirect:/listallclass";
	}
}

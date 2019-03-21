package web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import entity.Account;
import serviceimpl.LoginServiceimpl;

public class LoginInterceptor implements HandlerInterceptor{
	Logger log=Logger.getLogger(LoginInterceptor.class);
	@Autowired
	private LoginServiceimpl loginserviceimpl;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
				log.info("����������");
				String uri = request.getRequestURI();
		         //UTL:����login.jsp�ǿ��Թ������ʵģ�������URL���������ؿ���
				log.info(uri);
		        if (uri.indexOf("/login") >= 0) {
		             return true;
		         }
		         //��ȡsession
		         HttpSession session = request.getSession();
		         Account account = (Account) session.getAttribute("account");
		         if(account!=null) {
		        	 return true;
		         }
		         request.setAttribute("msg", "����û�е�¼�����ȵ�¼��");
		         request.getRequestDispatcher(request.getContextPath()+"/login.jsp").forward(request, response);
		         return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
	private static Map<String,Cookie> getCookie(HttpServletRequest request){
		Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
		Cookie[] cookies=request.getCookies();
		for (Cookie cookie : cookies) {
			cookieMap.put(cookie.getName(), cookie);
		}
		return cookieMap;
	}
	public static Cookie getCookieByName(HttpServletRequest request, String name) {
        Map<String, Cookie> cookieMap =getCookie(request);
        if (cookieMap.containsKey(name)) {
            Cookie cookie = (Cookie) cookieMap.get(name);
            return cookie;
        } else {
            return null;
        }
    }

}

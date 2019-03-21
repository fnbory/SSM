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
				log.info("进入拦截器");
				String uri = request.getRequestURI();
		         //UTL:除了login.jsp是可以公开访问的，其他的URL都进行拦截控制
				log.info(uri);
		        if (uri.indexOf("/login") >= 0) {
		             return true;
		         }
		         //获取session
		         HttpSession session = request.getSession();
		         Account account = (Account) session.getAttribute("account");
		         if(account!=null) {
		        	 return true;
		         }
		         request.setAttribute("msg", "您还没有登录，请先登录！");
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

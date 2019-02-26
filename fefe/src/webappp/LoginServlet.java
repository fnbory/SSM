package webappp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class LoginServlet implements Servlet{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(request);
		String user=request.getParameter("user");
		String password=request.getParameter("password");
		System.out.println(user+","+password);
		Map<String, String[]> map=request.getParameterMap();
		for(Map.Entry<String,String[]> entry:map.entrySet()) {
			System.out.println(entry.getKey()+Arrays.asList(entry.getValue()));}
		HttpServletRequest httpServletRequest=(HttpServletRequest)request;
		String requesturi=httpServletRequest.getRequestURI();
		PrintWriter out=response.getWriter();
		out.println("helloworld....");
		
			
			
		
		
		
	}

}

package webappp;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.sun.xml.internal.ws.client.sei.ValueSetter;

public class HelloServlet implements Servlet{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy");
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		System.out.println("getServletConfig");
		return null;
		
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		System.out.println("getServletInfo");
		return null;
	}

	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init");
		String user=servletConfig.getInitParameter("user");
		
		
		Enumeration<String> names=servletConfig.getInitParameterNames();
		while (names.hasMoreElements()) {
			String name = names.nextElement();
			String value=servletConfig.getInitParameter(name);
			System.out.println(name+":"+name);
		}
		ServletContext servletContext=servletConfig.getServletContext();
		String driver=servletContext.getInitParameter("driver");
		System.out.println("driver:"+driver);
		Enumeration<String> names2=servletContext.getInitParameterNames();
		while (names2.hasMoreElements()) {
			String name2 = (String) names2.nextElement();
			System.out.println("------>"+name2);
			}
		String realpath=servletContext.getRealPath("/ef.txt");
		System.out.println(realpath);
		
	
		
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("service");
		
	}
	public HelloServlet() {
		System.out.println("HelloServlet's constractor");
	}
	
}

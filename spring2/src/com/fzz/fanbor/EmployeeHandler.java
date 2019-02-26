package com.fzz.fanbor;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class EmployeeHandler {
	@Autowired
	private EmployeeDao employeedao;
	
	public String list(Map<String, Object> map) {
		map.put("employees", employeedao.getall());
		return "list";
	}
}

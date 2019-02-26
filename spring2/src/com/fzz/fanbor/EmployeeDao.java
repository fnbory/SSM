package com.fzz.fanbor;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {
	@Autowired
	private DepartmentDao departmentDao;
	private static  Map<Integer, Employee> employees=null;
	static {
		employees=new HashMap<Integer, Employee>();
		employees.put(1001, new Employee(1001, "E-AA", "aa@163.com", 1, new Department(101, "D-AA")));
		employees.put(1002, new Employee(1002, "E-BB", "bb@163.com", 2, new Department(102, "D-BB")));
		employees.put(1003, new Employee(1003, "E-CC", "cc@163.com", 3, new Department(103, "D-CC")));
		employees.put(1004, new Employee(1004, "E-DD", "dd@163.com", 4, new Department(104, "D-DD")));
		employees.put(1005, new Employee(1005, "E-EE", "ee@163.com", 5, new Department(105, "D-EE")));
	}
	private static Integer initId=1006;
	public void save(Employee employee) {
		if(employee.getId() == null) {
			employee.setId(initId++);
		}
		employee.setDepartment(departmentDao.getdepartment(employee.getId()));
		employees.put(employee.getId(), employee);
	}
	public Collection<Employee> getall(){
		return employees.values();
	}
	public Employee get(Integer id) {
		return employees.get(id);
	}
	public void delete(Integer id) {
		employees.remove(id);
	}
		
}

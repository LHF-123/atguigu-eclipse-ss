package com.atguigu.ss.service.impl;

import org.springframework.stereotype.Service;

import com.atguigu.ss.entities.Employee;
import com.atguigu.ss.service.EmployeeService;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
	
	public EmployeeServiceImpl() {
		System.out.println("EmployeeServiceImpl对象被创建了");
	}

	//正常来说Service应该调用Dao来实现Service中的方法
//	@Autowired
//	private EmployeeDao employeeDao;
	
	@Override
	public Employee getEmployee() {
		return new Employee(1, "张翠山", "zcs@yss.com", null);
	}

}

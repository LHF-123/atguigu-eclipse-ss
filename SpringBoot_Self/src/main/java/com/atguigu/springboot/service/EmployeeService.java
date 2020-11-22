package com.atguigu.springboot.service;

import com.atguigu.springboot.entities.Employee;

public interface EmployeeService {
	
	//根据员工ID查询该员工的信息
	Employee getEmployee();
	
}

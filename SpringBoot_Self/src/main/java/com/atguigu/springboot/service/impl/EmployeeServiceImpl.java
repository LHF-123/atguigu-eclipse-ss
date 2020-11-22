package com.atguigu.springboot.service.impl;

import org.springframework.stereotype.Service;

import com.atguigu.springboot.entities.Department;
import com.atguigu.springboot.entities.Employee;
import com.atguigu.springboot.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public Employee getEmployee() {
		return new Employee(2, "武大郎", "wdl@lvlvlv.com", new Department(1002, "餐饮部"));
	}

}

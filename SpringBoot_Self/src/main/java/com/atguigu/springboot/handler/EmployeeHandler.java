package com.atguigu.springboot.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.springboot.entities.Department;
import com.atguigu.springboot.entities.Employee;
import com.atguigu.springboot.service.EmployeeService;

/*
 * @RestController = @Controller + @ResponseBody
 */
@RestController
//@Controller
public class EmployeeHandler {
	
	@Autowired
	private EmployeeService employeeService;
	
//	@ResponseBody
	@RequestMapping("/getEmp")
	public Object getEmployee() {
		//创建一个Map
		Map<String, Object> map = new HashMap<String, Object>();
		//向map中放一个Empolyee对象
		map.put("emp", new Employee(1, "潘金莲", "pjl@xmq.com", new Department(1001, "外交部")));
		return map;
	}
	
	@RequestMapping("getEmp2")
	public Object getEmployee2() {
		//创建一个Map
		Map<String, Object> map = new HashMap<String, Object>();
		//调用EmployeeService获取员工信息
		Employee employee = employeeService.getEmployee();
		//将employee放到map中
		map.put("emp", employee);
		return map;
	}
	
}

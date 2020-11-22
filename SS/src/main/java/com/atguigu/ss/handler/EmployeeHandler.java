package com.atguigu.ss.handler;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atguigu.ss.entities.Employee;
import com.atguigu.ss.service.EmployeeService;

@Controller
public class EmployeeHandler {

	public EmployeeHandler() {
		System.out.println("EmployeeHandler对象被创建了");
	}
	
	@Autowired
	private EmployeeService employeeService;
	
	/*
	 * Spring和SpringMVC需不需要整合？
	 * 1.不整合
	 * 		1）将所有的配置都配置到SpringMVC的配置文件中
	 * 		2）将其他配置文件通过import标签导入到SpringMVC的配置文件中
	 * 
	 * 2.整合
	 * 		Spring的IOC容器负责配置Dao、Service、数据源、事务以及其他框架的整合
	 * 		SpringMVC负责配置Handler、视图解析器等
	 * 	  问题一：IOC容器如何初始化
	 * 		Java工程：new ClassPathXmlApplicationContext("beans.xml")
	 * 		Web工程：在web.xml中配置ContextLoaderListener监听器
	 * 	  问题二：Handler和Service对象被创建了两次
	 * 		Spring不扫描Handler
	 * 		SpringMVC只扫描Handler
	 */
	
	@RequestMapping("/getEmp")
	public String getEmployee(Map<String, Object> map) {
		//调用EmployeeService中获取一个Employee的方法
		Employee employee = employeeService.getEmployee();
		//将employee对象发到map中
		map.put("emp", employee);
		return "input";
	}
}

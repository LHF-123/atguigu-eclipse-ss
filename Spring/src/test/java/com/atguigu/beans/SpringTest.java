package com.atguigu.beans;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class SpringTest {
	
	//创建IOC容器对象
	ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");

	@Test
	void testEmployee() {
		Employee employee = (Employee) ioc.getBean("employee");
		System.out.println(employee);
	}
	
	@Test
	void testDepartment() {
		Department dept = ioc.getBean(Department.class);
		System.out.println(dept);
	}
	
	@Test
	void testConnection() throws SQLException {
		DataSource dataSource = ioc.getBean(DataSource.class);
		Connection connection = dataSource.getConnection();
		System.out.println(connection);
	}

}

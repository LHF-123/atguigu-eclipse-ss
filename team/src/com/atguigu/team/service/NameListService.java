package com.atguigu.team.service;

import java.util.Arrays;

import com.atguigu.team.bean.Architect;
import com.atguigu.team.bean.Designer;
import com.atguigu.team.bean.Employee;
import com.atguigu.team.bean.Equipment;
import com.atguigu.team.bean.NoteBook;
import com.atguigu.team.bean.PC;
import com.atguigu.team.bean.Printer;
import com.atguigu.team.bean.Programmer;

//静态导入
import static com.atguigu.team.service.Data.*;

/*
 * 	全公司的员工管理类
 * 	（1）存储和初始化全公司的员工对象
 * 	（2）可以获取全公司的员工对象
 * 	（3）根据员工的编号来获取一个员工对象
 */
public class NameListService {
	
	//employees用来保存所有公司员工对象
	private Employee[] employees;
	
	
	/*
	 * 	根据项目提供的Data类构建相应大小的employees数组
	 * 	再根据Data类中的数据构建不同的对象，
	 * 	包括Employee、Programmer、Designer和Architect对象，以及相关联的Eqipment子类的对象
	 *	将对象存于数组中
	 *	Data类位于com.atguigu.team.service包中
	 */
	public NameListService() {
		//从Data.java把数据初始化到employees数组中
		init();
	}
	
	
	//（1）存储和初始化全公司的员工对象
	public void init() {
		//1、先创建employees数组对象
		//employees数组的长度是Data类的EMPLOYEES二维数组的行数
		employees = new Employee[EMPLOYEES.length];
		
		//2、为employees数组的元素赋值
		//Data类的EMPLOYEES二维数组的一行就是一个员工的对象
		for (int i = 0; i < employees.length; i++) {
			//(1)先读取Data类的EMPLOYEES二维数组的每一行的第[0]列，来决定new什么类型的员工对象
			int empType = Integer.parseInt(EMPLOYEES[i][0]);
			
			//(2)统一读取每一种员工的通用数据：编号、姓名、年龄、薪资
			//每一行的第[1]列是员工的编号
			int id = Integer.parseInt(EMPLOYEES[i][1]);
			
			//每一行的第[2]列是员工的姓名
			String name = EMPLOYEES[i][2];
			
			//每一行的第[3]列是员工的年龄
			int age = Integer.parseInt(EMPLOYEES[i][3]);
			
			//每一行的第[4]列是员工的薪资
			double salary = Double.parseDouble(EMPLOYEES[i][4]);
			
			switch (empType) {
			case EMPLOYEE:
				//创建Employee的对象，放到employees数组[i]
				employees[i] = new Employee(id, name, age, salary);
				break;
			case PROGRAMMER:
				//创建Programmer的对象，放到employees数组[i]
				Equipment equipment = getListNumber(i);
				employees[i] = new Programmer(id, name, age, salary, equipment);
				break;
			case DESIGNER:
				//创建Designer的对象，放到employees数组[i]
				//设计师对象的第[5]列是奖金
				double bonus = Double.parseDouble(EMPLOYEES[i][5]);
				equipment = getListNumber(i);
				employees[i] = new Designer(id, name, age, salary, equipment, bonus);
				break;
			case ARCHITECT:
				//创建Architect的对象，放到employees数组[i]
				//架构师对象的第[5]列是奖金
				bonus = Double.parseDouble(EMPLOYEES[i][5]);
				equipment = getListNumber(i);
				//架构师对应的第[6]行是股票
				int stock = Integer.parseInt(EMPLOYEES[i][6]);
				employees[i] = new Architect(id, name, age, salary, equipment, bonus, stock);
				break;
			}
			
		}
		
	}
	
	/*
	 * 	员工与设备的对应关系：
	 * 	（1）普通的Employee是没有设备的，程序员、架构师、设计师都是有设备的
	 * 	（2）Data类的EMPLOYEES二维数组与Data类EQUIPMENTS二维数组是行行对应的
	 */
	private Equipment getListNumber(int i) {
		//根据Data类EQUIPMENT二维数组的每一行的第[0]列来决定创建什么设备对象
		int equipType = Integer.parseInt(EQIPMENTS[i][0]);
		
		switch (equipType) {
		case PC:
			//pc行的第[1]列是model，第[2]列是display
			return new PC(EQIPMENTS[i][1], EQIPMENTS[i][2]);
		case NOTEBOOK:
			//notebook行的第[1]列是model，第[2]列是price
			double price = Double.parseDouble(EQIPMENTS[i][2]);
			return new NoteBook(EQIPMENTS[i][1], price);
		case PRINTER:
			//printer行的第[1]列是type，第[2]列是name
			return new Printer(EQIPMENTS[i][1], EQIPMENTS[i][2]);
		default:
			return null;
		}
		
	}
	
	//（2）可以获取全公司的员工对象
	public Employee[] getAll() {
//		return employees;
		return Arrays.copyOf(employees, employees.length);
	}
	
	//（3）根据员工的编号来获取一个员工对象
	public Employee getById(int id) throws TeamException {
		for (int i = 0; i < employees.length; i++) {
			if (employees[i].getId() == id) {
				return employees[i];
			}
		}
		
		throw new TeamException("编号为" + id + "的员工 "); 
		
	}
	
}

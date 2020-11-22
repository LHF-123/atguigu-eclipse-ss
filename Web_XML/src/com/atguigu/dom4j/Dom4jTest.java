package com.atguigu.dom4j;

import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.atguigu.bean.Student;

public class Dom4jTest {

	public static void main(String[] args) throws DocumentException {
		//1、创建解析器对象
		SAXReader saxReader = new SAXReader();
		//2、解析xml文档得到Document对象
		Document document = saxReader.read("students.xml");
		//3、获取根标签
		Element rootElement = document.getRootElement();
		//4、获取所有的student标签
		List<Element> stus = rootElement.elements("student");
		//5、遍历得到的每一个student标签
		for (Element stu : stus) {
			//获取id
			String id = stu.attributeValue("id");
			System.out.println(id);
			//获取name标签
//			Element nameEle = stu.element("name");
			//获取name标签中的文本值
//			String name = nameEle.getText();
			
			String name = stu.elementText("name");
			
			System.out.println(name);
			
			//获取gender
			String gender = stu.elementText("gender");
			//获取age
			String age = stu.elementText("age");
			//获取address
			String address = stu.elementText("address");
			
			//封装Student对象
			Student student = new Student(id, name, gender, age, address);
			System.out.println(student);
			
		}
	}

}

package com.llq.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.llq.student.entity.Student;
import com.llq.student.service.StudentService;

@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action = request.getParameter("action");
		if(action == null) {//根据表单提交时传递的名字叫action参数判断执行哪一项功能
			queryAllStudent(request, response);
		}else if(action.equals("addStudent")) {//添加后查询所有，跳转到index.jsp
			addStudent(request, response);
			queryAllStudent(request, response);
		}else if(action.equals("deleteStudent")) {//删除后查询所有，跳转到index.jsp
			deleteStudent(request, response);
			queryAllStudent(request, response);
		}else if(action.equals("updateStudent")) {//更改后查询所有，跳转到index.jsp
			updateStudent(request, response);
			queryAllStudent(request, response);
		}else if(action.equals("queryStudentBySno")) {//查询单个
			queryStudentBySno(request, response);
		}else if(action.equals("queryAllStudent")) {//查询所有后跳转到index.jsp
			queryAllStudent(request, response);
		}
	}

	private void queryAllStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentService studentService = new StudentService();
		List<Student> students = studentService.queryAllStudents();
		
		request.setAttribute("students", students);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	private void queryStudentBySno(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("sno");
		StudentService studentService = new StudentService();
		Student student = studentService.queryStudentBySno(no);
		
		request.setAttribute("student", student);
		request.getRequestDispatcher("studentInfo.jsp").forward(request, response);
	}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String no = request.getParameter("sno");
		String name = request.getParameter("sname");
		int age = Integer.parseInt(request.getParameter("sage"));
		String address = request.getParameter("saddress");
		Student student = new Student(name, age, address);
		StudentService studentService = new StudentService();
		boolean result = studentService.updateStudentBySno(no, student);
		PrintWriter out = response.getWriter(); 
		if(result == true) {
			out.print("修改成功！");
		}else {
			out.print("修改失败！");
		}
	}

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String no = request.getParameter("sno");
		StudentService studentService = new StudentService();
		boolean result = studentService.deleteStudentBySno(no);
		PrintWriter out = response.getWriter(); 
		if(result == true) {
			out.print("删除成功！");
		}else {
			out.print("删除失败！");
		}
	}

	private void addStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String no = request.getParameter("sno");
		String name = request.getParameter("sname");
		int age = Integer.parseInt(request.getParameter("sage"));
		String address = request.getParameter("saddress");
		Student student = new Student(no,name, age, address);
		StudentService studentService = new StudentService();
		boolean result = studentService.addStudent(student);
		PrintWriter out = response.getWriter(); 
		if(result == true) {
			out.print("添加成功！");
		}else {
			out.print("添加失败！");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

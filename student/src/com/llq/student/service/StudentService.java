package com.llq.student.service;

import java.util.List;

import com.llq.student.dao.StudentDao;
import com.llq.student.entity.Student;

public class StudentService {
	
	StudentDao studentDao = new StudentDao();
	//增
	public boolean addStudent(Student student){
		if(!studentDao.isExist(student.getSno())) {//首先要根据学号查找一下该学号是否存在，不存在才能添加
			studentDao.addStudent(student);
			return true;
		}else {
			System.out.println("该学号已存在！");
			return false;
		}
	}
	//删
	public boolean deleteStudentBySno(String sno) {
		if(studentDao.isExist(sno)) {
			return studentDao.deleteStudentBySno(sno);
		}
		return false;
	}
	//改
	public boolean updateStudentBySno(String sno,Student student) {
		if(studentDao.isExist(sno)) {
			return studentDao.updateStudentBySno(sno, student);
		}
		return false;
	}
	//查
	public Student queryStudentBySno(String sno) {
		return studentDao.queryStudentBySno(sno);
	}
	//查询所有学生
	public List<Student> queryAllStudents(){
		return studentDao.queryAllStudent();
	}
}

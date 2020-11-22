package com.llq.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.llq.student.entity.Student;
import com.llq.student.util.DBUtil;


public class StudentDao {
	private static Connection conn = null;
	private static ResultSet rs = null;
	private static PreparedStatement pStatement;
	
	public boolean isExist(String sno) {//根据学号判断学生是否存在。如果要进行添加、删除是都要进行判断
		return queryStudentBySno(sno) == null ? false :true;
	}
	/**
	 * 
	 * @param sno
	 * @return
	 * 根据学号查询学生
	 */
	public Student queryStudentBySno(String sno) {
		Student student = null;//假设没有查到
		try {
			conn = DBUtil.getConnection();//通过DBUtil访问数据库
			String sql = "SELECT * FROM student WHERE sno= ?";
			pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, sno);//1代表带一个问号，把sno赋给第一个?
			rs = pStatement.executeQuery();
			if(rs.next()) {//如果查询到学生，要将查询到的数据取出并进行封装，然后返回
				String no = rs.getString("sno");
				String name = rs.getString("sname");//sname是在数据库中定义的字段名
				int age = rs.getInt("sage");
				String address = rs.getString("saddress");
				student = new Student(no, name, age, address);
			}
			return student;
			}
			catch (SQLException e) {
				e.printStackTrace();
			}finally {//肯定会执行的代码
				DBUtil.closeConnection(conn, pStatement, rs);
			}
		return student;
	}
	/**
	 * 查询所有学生
	 * @return
	 */
	public List<Student> queryAllStudent() {
		List<Student> students = new ArrayList<Student>();
		Student student = null;//假设没有查到
		try {
			conn = DBUtil.getConnection();//通过DBUtil访问数据库
			String sql = "SELECT * FROM student";
			pStatement = conn.prepareStatement(sql);
			rs = pStatement.executeQuery();
			while(rs.next()) {//如果查询到学生，要将查询到的数据取出并进行封装，然后返回
				String no = rs.getString("sno");
				String name = rs.getString("sname");//sname是在数据库中定义的字段名
				int age = rs.getInt("sage");
				String address = rs.getString("saddress");
				student = new Student(no, name, age, address);
				students.add(student);//将查询到的每一个学生添加到list中
			}
			return students;
			}
			catch (SQLException e) {
				e.printStackTrace();
			}finally {//肯定会执行的代码
				DBUtil.closeConnection(conn, pStatement, rs);
			}
		return null;
	}
	/**
	 * 添加学生
	 */
	public boolean addStudent(Student student) {
		try {
			conn = DBUtil.getConnection();//通过DBUtil访问数据库
			String sql = "INSERT INTO student VALUES(?,?,?,?)";
			pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, student.getSno());
			pStatement.setString(2, student.getSname());
			pStatement.setInt(3, student.getSage());
			pStatement.setString(4, student.getSaddress());
			int count = pStatement.executeUpdate();
			if(count > 0) {//count保存的是插入数据时影响的行数
				return true;
			}
			return false;
			}
			catch (SQLException e) {
				e.printStackTrace();
			}finally {//肯定会执行的代码
				DBUtil.closeConnection(conn, pStatement, rs);
			}
		return false;
	}
	/**
	 * 根据学号删除学生
	 */
	public boolean deleteStudentBySno(String sno) {
		try {
			conn = DBUtil.getConnection();//通过DBUtil访问数据库
			String sql = "DELETE FROM student WHERE sno = ?";
			pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, sno);
			int count = pStatement.executeUpdate();
			if(count > 0) {//count保存的是删除数据时影响的行数
				return true;
			}
			return false;
			}
			catch (SQLException e) {
				e.printStackTrace();
			}finally {//肯定会执行的代码
				DBUtil.closeConnection(conn, pStatement, rs);
			}
		return false;
	}
	/**
	 * 根据学号修改学生信息
	 */
	public boolean updateStudentBySno(String sno, Student student) {
		try {
			conn = DBUtil.getConnection();//通过DBUtil访问数据库
			String sql = "UPDATE student SET sname = ?, sage = ?, saddress = ? WHERE sno = ?";
			pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, student.getSname());
			pStatement.setInt(2, student.getSage());
			pStatement.setString(3, student.getSaddress());
			pStatement.setString(4, sno);
			int count = pStatement.executeUpdate();
			if(count > 0) {//count保存的是修改数据时影响的行数
				return true;
			}
			return false;
			}
			catch (SQLException e) {
				e.printStackTrace();
			}finally {//肯定会执行的代码
				DBUtil.closeConnection(conn, pStatement, rs);
			}
		return false;
	}
}

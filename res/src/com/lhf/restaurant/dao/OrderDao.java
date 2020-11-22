package com.lhf.restaurant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lhf.restaurant.entity.Order;
import com.lhf.restaurant.util.DBUtil;

public class OrderDao {
	private static Connection conn = null;
	private static ResultSet rs = null;
	private static PreparedStatement pStatement;
	
	/**
	 * 根据订单号查询订单详情
	 */
	public Order queryOrder(String user, int orderId) {
		Order order = null;
		try {
			conn = DBUtil.getConnection();//通过DBUtil访问数据库
			String sql = "CALL queryOrder(?, ?);";
			pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, user);
			pStatement.setInt(2, orderId);//1代表带一个问号，把orderId赋给第一个?
			rs = pStatement.executeQuery();
			if(rs.next()) {//如果查询到学生，要将查询到的数据取出并进行封装，然后返回
				int oId = rs.getInt("orderId");
				String menu = rs.getString("menu");
				int count = rs.getInt("count");
				String address = rs.getString("address");
				order = new Order(oId, menu, count,address);
			}
			return order;
			}
			catch (SQLException e) {
				e.printStackTrace();
			}finally {//肯定会执行的代码
				DBUtil.closeConnection(conn, pStatement, rs);
			}
		return order;
		
	}
	
	/**
	 * 查询所有订单
	 */
	public List<Order> queryAllOrder(String user){
		List<Order> orders = new ArrayList<Order>();
		Order order = null;//假设没有查询到订单
		try {
			conn = DBUtil.getConnection();//通过DBUtil访问数据库
			String sql = "CALL find(?)";
			pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, user);
			rs = pStatement.executeQuery();
			while(rs.next()) {//如果查询到订单，要将查询到的数据取出并进行封装，然后返回
				int oId = rs.getInt("orderId");
				String menu = rs.getString("menu");
				int count = rs.getInt("count");
				String address = rs.getString("address");
				order = new Order(oId, menu, count, address);
				orders.add(order);//将查询到的每一个订单添加到list中
			}
			return orders;
			}
			catch (SQLException e) {
				e.printStackTrace();
			}finally {//肯定会执行的代码
				DBUtil.closeConnection(conn, pStatement, rs);
			}
		return null;
	}
	
	/**
	 * 增加订单
	 */
	public boolean addOrder(String user, Order order) {
		try {
			conn = DBUtil.getConnection();//通过DBUtil访问数据库
			String sql = "CALL addOrder(?, ?, ?, ?);";
			pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, user);
			pStatement.setString(2, order.getMenu());
			pStatement.setInt(3, order.getCount());
			pStatement.setString(4, order.getAddress());
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
	 * 根据订单号删除订单
	 */
	public boolean delOrder(String user, int oId) {
		try {
			conn = DBUtil.getConnection();//通过DBUtil访问数据库
			String sql = "CALL delOrder(? ,?);";
			pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, user);
			pStatement.setInt(2, oId);
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
	 * 根据订单号修改数量和地址
	 */
	public boolean updateOrder(String user, int oId, Order order) {
		try {
			conn = DBUtil.getConnection();//通过DBUtil访问数据库
			String sql = "CALL updateOrder(?, ?, ?, ?);";
			pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, user);
			pStatement.setInt(2, order.getCount());
			pStatement.setString(3, order.getAddress());
			pStatement.setInt(4, oId);
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

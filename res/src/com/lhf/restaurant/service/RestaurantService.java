package com.lhf.restaurant.service;

import java.util.List;

import com.lhf.restaurant.dao.OrderDao;
import com.lhf.restaurant.entity.Order;

public class RestaurantService {
	
	OrderDao orderDao = new OrderDao();
	//增
	public boolean addOrder(String user, Order order) {
		orderDao.addOrder(user,order);
		return true;
	}
	//删
	public boolean delOrder(String user, int oId) {
		orderDao.delOrder(user, oId);
		return true;
	}
	//改
	public boolean updateOrder(String user, int oId, Order order) {
		orderDao.updateOrder(user, oId, order);
		return true;
	}
	//查
	public Order queryOrder(String user, int oId) {
		return orderDao.queryOrder(user, oId);
	}
	//查询所有订单
	public List<Order> queryAllOrders(String user) {
		return orderDao.queryAllOrder(user);
	}
	
}

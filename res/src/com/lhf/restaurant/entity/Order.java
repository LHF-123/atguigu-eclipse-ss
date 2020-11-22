package com.lhf.restaurant.entity;

public class Order {
	private int orderId;//订单号
	private String menu;//菜品名
	private int count;//数量
	private String address;//配送地址
	
	public Order() {
		
	}
	public Order(int count, String address) {
		this.count = count;
		this.address = address;
	}
	public Order(String menu, int count, String address) {
		this.menu = menu;
		this.count = count;
		this.address = address;
	}
	public Order(int orderId, String menu, int count, String addrss) {
		this.orderId = orderId;
		this.menu = menu;
		this.count = count;
		this.address = addrss;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getAddress() {
		return address;
	}
	public void setAdress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "订单号：" + orderId + "，菜品名：" + menu + "，数量：" + count + "地址：" + address;
	}
}

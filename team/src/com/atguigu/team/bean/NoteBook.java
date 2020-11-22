package com.atguigu.team.bean;

public class NoteBook implements Equipment {
	
	private String model;
	private double price;
	
	public NoteBook() {
		super();
	}

	public NoteBook(String model, double price) {
		super();
		this.model = model;
		this.price = price;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String getDescription() {
		//联想T4(6000.0)
		return model + "(" + price + ")";
	}

}

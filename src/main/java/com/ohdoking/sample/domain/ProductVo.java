package com.ohdoking.sample.domain;

public class ProductVo {

	private String name;
	private double price;
	
	public ProductVo(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ProductVo [name=" + name + ",price=" + price + "]";
	}
	
	
	
	
}

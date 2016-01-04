package com.hanains.westernfood.bean;

public class Pizza extends Food {

	private String topping[];
	
	public Pizza() {
	}

	public String[] getTopping() {
		return topping;
	}

	public void setTopping(String[] topping) {
		this.topping = topping;
	}
	
}

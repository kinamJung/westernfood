package com.java.westernfood.bean;

public abstract class Food {

	protected String name;
	protected Long price;
	protected Long weight;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Long getWeight() {
		return weight;
	}
	public void setWeight(Long weight) {
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "제품이름=" + name + ", 가격=" + price + ", 칼로리=" + weight;
	}
	
}

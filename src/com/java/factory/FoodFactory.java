package com.java.factory;

import com.java.westernfood.bean.Food;

public abstract class FoodFactory {
	
	public abstract Food createFood(String name);
}

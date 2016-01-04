package com.hanains.factory;

import com.hanains.westernfood.bean.Food;

public abstract class FoodFactory {
	
	abstract Food createFood(String name);
}

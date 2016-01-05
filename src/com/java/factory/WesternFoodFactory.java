package com.java.factory;

import com.java.westernfood.bean.Food;
import com.java.westernfood.bean.Hamburger;
import com.java.westernfood.bean.Pizza;

public class WesternFoodFactory extends FoodFactory {
	
	
	@Override
	public Food createFood(String name) {
	
		Food food = null;
		if( name.equals("hamburger") ){
			food = new Hamburger();
		}else if( name.equals("pizza") ){
			food = new Pizza();
		}
	
		
		return food;
	}

	
	
}

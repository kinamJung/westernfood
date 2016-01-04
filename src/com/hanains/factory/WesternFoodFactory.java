package com.hanains.factory;

import com.hanains.westernfood.bean.Food;
import com.hanains.westernfood.bean.Hamburger;
import com.hanains.westernfood.bean.Pizza;

public class WesternFoodFactory extends FoodFactory {

	@Override
	Food createFood(String name) {
	
		Food food = null;
		if( name.equals("hamburger") ){
			food = new Hamburger();
		}else if( name.equals("pizza") ){
			food = new Pizza();
		}
	
		
		return food;
	}

	
	
}

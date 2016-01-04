package com.hanains.westernfood.entity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

import com.hanains.westernfood.bean.Food;

public class FoodList {

	private HashMap<String, ArrayList<Food> > foodMap;

	public FoodList() {
		foodMap = new HashMap<>();
	}

	public void insertFood(String kind, Food food){
		
		if( foodMap.get(kind) == null ){
			
		}
		
		
		
	}
	
	
	
	
}

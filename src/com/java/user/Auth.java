package com.java.user;

import com.java.westernfood.entity.FoodListImpl;

public interface Auth {
	
	int ALL_DISPLAY = 1;
	int KIND_DISPLAY = 2;
	int BRAND_DISPLAY = 3;
	
	public void register(FoodListImpl foodlist);
	public void edit(FoodListImpl foodlist);
	public void delete(FoodListImpl foodlist);
	public void check(FoodListImpl foodlist);
}

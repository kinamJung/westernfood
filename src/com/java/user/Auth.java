package com.java.user;

import com.java.westernfood.entity.FoodListImpl;

public interface Auth {
	public void register(FoodListImpl foodlist);
	public void edit(FoodListImpl foodlist);
	public void delete(FoodListImpl foodlist);
	public void check(FoodListImpl foodlist);
}

package com.java.user;

import java.util.List;

import com.java.westernfood.bean.Food;
import com.java.westernfood.entity.FoodListImpl;

public class CasherManager implements Auth {

	@Override
	public void register(FoodListImpl foodlist) {
		System.out.println("입고 관련 권한이 없습니다. Manager에게 문의하십시오.");
	}

	@Override
	public void edit(FoodListImpl foodlist) {
		System.out.println("수정 관련 권한이 없습니다. Manager에게 문의하십시오.");
	}

	@Override
	public void delete(FoodListImpl foodlist) {
		System.out.println("삭제 관련 권한이 없습니다. Manager에게 문의하십시오.");
	}

	@Override
	public void check(FoodListImpl foodlist) {
		List<Food> foods = foodlist.getAllFoodList();
	      
	      for( Food food : foods ){
	         System.out.println(food);
	      }
	}

}

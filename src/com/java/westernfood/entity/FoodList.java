package com.java.westernfood.entity;

import java.util.List;

import com.java.westernfood.bean.Food;

public interface FoodList {
   
   public void insertFood(String kind, String brandName, Food food);
   public void updateFood(Food food);
   public void delete(Food food);
   public List<String> getKindList();
   public List<String> getBrandList(String kind);
   public List<Food> getAllFoodList();
   public List<Food> getFoodsByKind(String kind);
   public List<Food> getFoodsByKindAndBrandName(String kind, String brand);
   public Food getFood(String name);
   
}
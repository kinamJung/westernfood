package com.java.westernfood.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.java.westernfood.bean.Food;

public class FoodListImpl implements FoodList {

   private Map<String, HashMap<String, ArrayList<Food>>> foodMap;

   public FoodListImpl(  Map<String, HashMap<String, ArrayList<Food>>> foodMap ) {
      this.foodMap = foodMap;
   }

   public void insertFood(String kind, String brandName, Food food) {

      HashMap<String, ArrayList<Food>> brandFoodmap;

      brandFoodmap = foodMap.get(kind);
      if (foodMap.get(kind) == null) {

         ArrayList<Food> foodList = new ArrayList<>();
         brandFoodmap = new HashMap<>();

         foodList.add(food);
         brandFoodmap.put(brandName, foodList);

         foodMap.put(kind, brandFoodmap);
      } else {

         ArrayList<Food> foodList = brandFoodmap.get(brandName);

         // brandName에 따른 상품이 있을때
         if (foodList == null) {
            foodList = new ArrayList<>();
         }

         foodList.add(food);
         brandFoodmap.put(brandName, foodList);
         foodMap.put(kind, brandFoodmap);
      }
   }

   private void update(String kind, String brandName, Food food){
      
      HashMap<String, ArrayList<Food>> brandFoodmap;
      brandFoodmap = foodMap.get(kind);
      
      if( brandFoodmap != null){
         
         ArrayList<Food> foodList = brandFoodmap.get(brandName);
         if( foodList.size() != 0 ){
            
            int index = getFoodIndex(food.getName(), foodList);
            if( index != -1 ){
               foodList.set(index, food);
            }
         }
      }
   }
   
   public void updateFood(Food food){
      
      String[] kindAndBrand = this.getKindAndBrandByFoodName(food.getName());
      
      if( kindAndBrand == null ){
         return;
      }
      
      String kind = kindAndBrand[0];
      String brand = kindAndBrand[1];
      
      this.update(kind, brand, food);
      
   }
   
   // success -> index 0 : kind, index 1 : brand
   // fail -> null;
   private String[] getKindAndBrandByFoodName(String name){
      
      ArrayList<String> kindSet = new ArrayList<String>(foodMap.keySet());
      
      for( String kind : kindSet ){
         
         HashMap<String, ArrayList<Food>> foods = foodMap.get(kind);
         ArrayList<String> brandNameSet = new ArrayList<String>( foods.keySet() );
         
         for(String brand : brandNameSet){
         
            ArrayList<Food> brandFoods = foods.get(brand);
            for( Food food : brandFoods ){
               if( food.getName().equals(name) ){
                  
                  String[] kindAndBrand = new String[2];
                  kindAndBrand[0] = kind;
                  kindAndBrand[1] = brand;
                  
                  return kindAndBrand;
               }
            }
         }
      }
      return null;
   }
   
   public void delete(Food food){
	      
	      ArrayList<String> kindSet = new ArrayList<String>(foodMap.keySet());
	      
	      for( String kind : kindSet ){
	         
	         HashMap<String, ArrayList<Food>> foods = foodMap.get(kind);
	         ArrayList<String> brandNameSet = new ArrayList<String>( foods.keySet() );
	         
	         for(String brand : brandNameSet){
	         
	            ArrayList<Food> brandFoods = foods.get(brand);
	            int index = this.getIndexFoodArray(food.getName(), brandFoods);
	            if(index == -1){
	               return;
	            }
	            brandFoods.remove(index);
	         }
	      }
	   }

	   private int getIndexFoodArray(String name, ArrayList<Food> foods){
	      
	      for(int i = 0 ; i < foods.size(); i++){
	         
	         Food food = foods.get(i);
	         if( food.getName().equals(name) ){
	            return i;
	         }
	      }
	      return -1;
	   }
   public int getFoodIndex(String name, List<Food> foodList ){
      
      for(int i = 0 ; i < foodList.size(); i++){
         if( foodList.get(i).equals(name) ){
            return i;
         }
      }
      return -1;
      
   }
   
   // get kind 종류
   public List<String> getKindList(){
      ArrayList<String> kindSet = new ArrayList<String>(foodMap.keySet());      
      return kindSet;
   }
   
   //get brand list
   public List<String> getBrandList(String kind){
      
      HashMap<String, ArrayList<Food>> foods = foodMap.get(kind);
      ArrayList<String> brandNameSet = new ArrayList<>( foods.keySet() );
      return brandNameSet;
   }
   
   //get All Food List
   public List<Food> getAllFoodList(){
      
      ArrayList<Food> foodlist = new ArrayList<>();
      
      ArrayList<String> kindSet = new ArrayList<String>(foodMap.keySet());
      
      for( String kind : kindSet ){
         
         HashMap<String, ArrayList<Food>> foods = foodMap.get(kind);
         ArrayList<String> brandNameSet = new ArrayList<String>( foods.keySet() );
         
         for(String brand : brandNameSet){
         
            ArrayList<Food> brandFoods = foods.get(brand);
            foodlist.addAll(brandFoods);
            
         }
      }
      return foodlist;      
   }
   
   //get foods by kind
   public List<Food> getFoodsByKind(String kind){
      
      ArrayList<Food> foods = new ArrayList<>();
      
      List<String> brandNameList = this.getBrandList(kind);
      
      HashMap<String, ArrayList<Food>> allBrandNameFoods = foodMap.get(kind);
      
      for( String brand : brandNameList ){         
         foods.addAll( allBrandNameFoods.get(brand) );
      }
      return foods;
   }
   
   
   //get foods by kind and brand
   public List<Food> getFoodsByKindAndBrandName(String kind, String brand){
      
      HashMap<String, ArrayList<Food>> foodsByKind = foodMap.get(kind);
      ArrayList<Food> foods = foodsByKind.get(brand);
      
      return foods;
      
   }
   
   //get Food by name -> if success object else null
   public Food getFood(String name){
      
      List<Food> foodlist = this.getAllFoodList();
      
      for( Food food : foodlist ){         
         if( food.getName().equals(name) ){
            return food;
         }
      }
      return null;
   }
   
   

   
   
}
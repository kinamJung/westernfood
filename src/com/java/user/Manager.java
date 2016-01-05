package com.java.user;

import java.util.List;
import java.util.Scanner;

import com.java.factory.WesternFoodFactory;
import com.java.westernfood.bean.Food;
import com.java.westernfood.bean.Hamburger;
import com.java.westernfood.bean.Pizza;
import com.java.westernfood.entity.FoodListImpl;

public class Manager implements Auth {
	private Scanner scan;
	
	String kind;
	String brandName;
	String fName;
	Long fPrice;
	Long fWeight;
	String hSource;
	String pTopping;
	String editName; //수정 하고싶은 제품 이름
	String editPrice;
	String editWeight;
	String delName;
	
	Food food;
	@Override
	public void register(FoodListImpl foodlist) {
		System.out.println("1.햄버거");
		System.out.println("2.피자");
		System.out.println("선택하시오 : ");
		scan = new Scanner(System.in);
		int nameNumber = scan.nextInt();
		
		WesternFoodFactory factory = new WesternFoodFactory();
		Food food = null;
		switch(nameNumber){
		case 1: 
			food = factory.createFood("hamburger");
			kind = "햄버거";
			break;
		case 2: 
			food = factory.createFood("pizza");
			kind = "피자";
		break;
		default:
			break;
		}
		
		System.out.println("등록하실 음식의 브랜드를 입력하세요 : ");
		brandName = scan.next();
		
		System.out.println(kind+"의 이름을 입력하세요 : ");
		fName = scan.next();
		
		System.out.println(kind+"의 가격을 입력하세요 : ");
		fPrice = scan.nextLong();
		
		System.out.println(kind+"의 칼로리를 입력하세요 : ");
		fWeight = scan.nextLong();
		
		if(kind.equals("햄버거")){
			System.out.println(kind+"의 소스를 입력하세요 : ");
			hSource = scan.next();
		}else if(kind.equals("피자")){
			System.out.println(kind+"의 토핑을 입력하세요 : ");
			pTopping = scan.next();
		}
		
		Hamburger hamberger = null;
		Pizza pizza = null;
		
		if( food instanceof Hamburger ){
			hamberger = (Hamburger)food;
			hamberger.setName(fName);
			hamberger.setPrice(fPrice);
			hamberger.setWeight(fWeight);
			hamberger.setSource(hSource);
		}else if( food instanceof Pizza){
			pizza = (Pizza) food;
			pizza.setName(fName);
			pizza.setPrice(fPrice);
			pizza.setWeight(fWeight);
			pizza.setTopping(pTopping);
		}
		foodlist.insertFood(kind, brandName, food);		
	}

	@Override
	public void edit(FoodListImpl foodlist) {
		System.out.println("수정하고 싶은 제품명을 입력하세요 : ");
		editName = scan.next();
		Food food = foodlist.getFood(editName);
		
		System.out.println("가격 ["+food.getPrice()+"] : ");
		editPrice = scan.next();
		
		System.out.println("칼로리 ["+food.getWeight()+"] : ");
		editWeight = scan.next();
		
		food.setPrice(Long.parseLong(editPrice));
		food.setWeight(Long.parseLong(editWeight));
		
		foodlist.updateFood(food);
	}

	@Override
	public void delete(FoodListImpl foodlist) {
		System.out.println("삭제하고 싶은 제품명을 입력하세요 : ");
		delName = scan.next();
		Food food = foodlist.getFood(delName);
	}

	@Override
	public void check(FoodListImpl foodlist) {
		System.out.println("1.전체출력");
		System.out.println("2.종류별출력");
		System.out.println("3.브랜드별출력");
		System.out.println("선택하시오 : ");
		int checkNumber = scan.nextInt();

		switch(checkNumber){
		case 1:
			List<Food> foods = foodlist.getAllFoodList();
		      
		      for( Food food : foods ){
		         System.out.println(food);
		      }
		break;
		case 2: 
			List<String> kinds = foodlist.getKindList();
		      
		      for( String kind : kinds ){
		    	 List<Food> food = foodlist.getFoodsByKind(kind);
		         System.out.println(food);
		      }
		break;
		case 3:
			List<String> ks = foodlist.getKindList();
		      
		      for( String kind : ks ){
		    	 List<String> brands = foodlist.getBrandList(kind);
		         for(String brand:brands){
		        	 List<Food> food = foodlist.getFoodsByKindAndBrandName(kind, brand);
			         System.out.println(food);
		         }
		      }
		break;
		default:System.out.println("프로그램 종료하겠습니다");
			System.exit(0);
			break;
		}
		
		
	}
}

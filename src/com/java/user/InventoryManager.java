package com.java.user;

import java.util.List;
import java.util.Scanner;

import com.java.factory.WesternFoodFactory;
import com.java.westernfood.bean.Food;
import com.java.westernfood.bean.Hamburger;
import com.java.westernfood.bean.Pizza;
import com.java.westernfood.entity.FoodListImpl;

public class InventoryManager implements Auth {

	Scanner scan;
	
	String kind;
	String brandName;
	String fName;
	Long fPrice;
	Long fWeight;
	String hSource;
	String pTopping;
	
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
		scan = new Scanner(System.in);
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

package com.java.user;

import java.util.List;
import java.util.Scanner;

import com.java.westernfood.bean.Food;
import com.java.westernfood.bean.Hamburger;
import com.java.westernfood.bean.Pizza;
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

	private int getPrintMenu() {
		Scanner scan = new Scanner(System.in);
		System.out.println("\r\n1.전체출력");
		System.out.println("2.종류별출력");
		System.out.println("3.브랜드별출력");
		System.out.print("선택하시오 : ");
		return scan.nextInt();
	}

	private void printFood(List<Food> foodList) {
		System.out.println("");
		for (Food food : foodList) {

			System.out.print("이름:" + food.getName() + " 가격:" + food.getPrice() + " 칼로리: " + food.getWeight());

			if (food instanceof Hamburger) {
				Hamburger hamburger = (Hamburger) food;
				System.out.println(" 소스: " + hamburger.getSource());
			} else if (food instanceof Pizza) {
				Pizza pizza = (Pizza) food;
				System.out.println(" 토핑: " + pizza.getTopping());
			}
		}
	}

	@Override
	public void check(FoodListImpl foodlist) {

		int checkNumber = getPrintMenu();

		List<Food> foods = null;
		List<String> kinds = null;
		
		switch (checkNumber) {
		case ALL_DISPLAY:
			foods = foodlist.getAllFoodList();
			if(foods != null){
				printFood(foods);
				foods = null;
			}
			break;
		case KIND_DISPLAY:
			kinds = foodlist.getKindList();
			
			for (String kind : kinds) {
				foods = foodlist.getFoodsByKind(kind);
				if(foods != null){
					System.out.println("----" + kind + "----");
					printFood(foods);
					foods = null;
				}
			}
			break;
		case BRAND_DISPLAY:
			kinds = foodlist.getKindList();

			for (String kind : kinds) {
				List<String> brands = foodlist.getBrandList(kind);
				for (String brand : brands) {
					foods = foodlist.getFoodsByKindAndBrandName(kind, brand);
					System.out.println("----" + brand + "----");
					if(foods != null){
						printFood(foods);
						foods = null;
					}
				}
			}
			break;
		default:
			System.out.println("프로그램 종료하겠습니다");
			System.exit(0);
			break;
		}

	}

}

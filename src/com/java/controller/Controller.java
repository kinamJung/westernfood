package com.java.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.java.user.Auth;
import com.java.user.CasherManager;
import com.java.user.InventoryManager;
import com.java.user.Manager;
import com.java.westernfood.bean.Food;
import com.java.westernfood.entity.FoodListImpl;

public class Controller {
	public void startprogram(){
		HashMap<String, HashMap<String, ArrayList<Food>>> foodMap = new HashMap<>();
		FoodListImpl foodlist = new FoodListImpl(foodMap);

		//권한설정
		Auth auth = null;

		System.out.println("----------------");
		System.out.println("당신의 직책을 선택하세요");
		System.out.println("1.매니저");
		System.out.println("2.입고관리자");
		System.out.println("3.판매관리자");
		System.out.println("선택하시오 : ");
		Scanner scan1 = new Scanner(System.in);
		int authNumber = scan1.nextInt();

		// 권한별 객체 생성
		if(authNumber == 1){
			auth = new Manager();
		}else if(authNumber == 2){
			auth = new InventoryManager();
		}else if(authNumber == 3){
			auth = new CasherManager();
		}
		while(true){
			System.out.println("1.물품 등록");
			System.out.println("2.물품 수정");
			System.out.println("3.물품 삭제");
			System.out.println("4.물품 확인");
			System.out.println("선택하시오 : ");
			Scanner scan2 = new Scanner(System.in);
			int fuctionNumber = scan2.nextInt();

			switch(fuctionNumber){
			case 1: auth.register(foodlist);
			break;
			case 2: auth.edit(foodlist);
			break;
			case 3: auth.delete(foodlist);
			break;
			case 4: auth.check(foodlist);
			break;
			default:System.out.println("프로그램 종료하겠습니다");
				System.exit(0);
				break;
			}
		}
	}
}

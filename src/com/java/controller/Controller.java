package com.java.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.java.factory.MakeUserFactory;
import com.java.factory.UserFactory;
import com.java.user.Auth;
import com.java.user.CasherManager;
import com.java.user.InventoryManager;
import com.java.user.Manager;
import com.java.westernfood.bean.Food;
import com.java.westernfood.entity.FoodListImpl;

public class Controller {
	
	private HashMap<String, HashMap<String, ArrayList<Food>>> foodMap = null;
	private  FoodListImpl foodlist = null;
	private UserFactory userFactory = null;
	private Auth auth = null;
	
	
	private void init(){
		foodMap = new HashMap<>();
		foodlist = new FoodListImpl(foodMap);
		userFactory = new MakeUserFactory();
	}
	
	private int positionMemu(){
		
		Scanner scan = new Scanner(System.in);
		System.out.println("----------------");
		System.out.println("당신의 직책을 선택하세요");
		System.out.println("1.매니저");
		System.out.println("2.입고관리자");
		System.out.println("3.판매관리자");
		System.out.println("선택하시오 : ");
		
		return scan.nextInt();
	}
	
	private int functionMenu(){
		
		Scanner scan = new Scanner(System.in);
		System.out.println("\r\n1.물품 등록");
		System.out.println("2.물품 수정");
		System.out.println("3.물품 삭제");
		System.out.println("4.물품 확인");
		System.out.print("선택하시오 : ");
		return scan.nextInt();
	}
	
	public void startprogram(){
		//init
		init();
				
		int positionSelect = positionMemu();
		auth = userFactory.getUser(positionSelect);
		System.out.println();
		System.out.println("");
		System.out.println();
		System.out.println("master");
		
		while(true){
			
			int fuctionNumber = functionMenu();

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

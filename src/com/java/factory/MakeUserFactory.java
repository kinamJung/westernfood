package com.java.factory;

import com.java.user.Auth;
import com.java.user.CasherManager;
import com.java.user.InventoryManager;
import com.java.user.Manager;

public class MakeUserFactory implements UserFactory {

	private static final int MANAGER = 1;
	private static final int INVENTORY_MANAGER = 2;
	private static final int CASHER_MANAGER = 3;
	
	@Override
	public Auth getUser(int div) {
		// TODO Auto-generated method stub
		Auth auth = null;
		
		// 권한별 객체 생성
		if (div == MANAGER) {
			auth = new Manager();
		} else if (div == INVENTORY_MANAGER) {
			auth = new InventoryManager();
		} else if (div == CASHER_MANAGER) {
			auth = new CasherManager();
		}
		return auth;
	}

}

package com.clogic.utilities;

import com.clogic.SeleniumFramework.*;

public class NewAccountCreationByAdmin {

	public static void main(String[] args){
		ClassTest test = new ClassTest();
		BasicSetUp setUp = new BasicSetUp();
		try {
			setUp.setUp();
			test.newAccountCreationByAdminTest();
			setUp.tearDown();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

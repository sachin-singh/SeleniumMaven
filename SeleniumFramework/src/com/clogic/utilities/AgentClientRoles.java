package com.clogic.utilities;

import com.clogic.SeleniumFramework.BasicSetUp;
import com.clogic.SeleniumFramework.ClassTest;

public class AgentClientRoles {
	public static void main(String[] args){
		ClassTest test = new ClassTest();
		BasicSetUp setUp = new BasicSetUp();
		
		
		try {
			 
				setUp.setUp();
			 
			test.agentClientRolesTest();
			setUp.tearDown();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

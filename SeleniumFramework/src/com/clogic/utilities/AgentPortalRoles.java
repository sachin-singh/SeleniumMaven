package com.clogic.utilities;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.clogic.SeleniumFramework.BasicSetUp;
import com.clogic.SeleniumFramework.ClassTest;

public class AgentPortalRoles {
	public static void main(String[] args){
		ClassTest test = new ClassTest();
		BasicSetUp setUp = new BasicSetUp();
		
		
		try {
			 
				setUp.setUp();
			 
			test.agentPortalRolesTest();
			setUp.tearDown();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

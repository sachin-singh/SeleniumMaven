package com.clogic.utilities;

import com.clogic.SeleniumFramework.BasicSetUp;
import com.clogic.SeleniumFramework.ClassTest;

public class BasicSanity2 {

	public static void main(String[] args){
		ClassTest test = new ClassTest();
		BasicSetUp setUp = new BasicSetUp();
		try {
			setUp.setUp();
			test.newAccountCreationByAdminTest();
			test.createCallCenterTest();
			test.updateCallCenterProfileTest();
			test.createProjectTest();
			test.createAgentTest();
			test.assignAgentTest();
			test.buyPackageTest();
			test.assignPackageTest();
			test.importLeadsTest();
			test.assignLeadsTest();
			test.searchLeadTest();
			test.bulkUpdateTest();
			test.addNewLeadTest();
			test.addLeadListTest();
			test.addCRMFieldTest();
			test.callerIdTest();
			test.uploadTonesTest();
			test.removeTonesTest();
			test.agentPortalRolesTest();
			setUp.tearDown();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

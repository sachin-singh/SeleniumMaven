package com.clogic.SeleniumFramework;

import java.util.ArrayList;
import java.util.concurrent.Callable;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.*;
import org.testng.annotations.Test;



/**
 * The Class Test1.
 *
 * 
 */
public class ClassTest extends BasicSetUp{
	
	LogInPage loginPage;
	CCHomePage callCenter ;
	AgentPage agentPage;
	RegisterPage registerPage;
	AdminHomePage adminHomePage;
	ProjectPage projectPage;
	CRMPage crmPage;
	AdvancedPage advancePage;
	
	String adminEmail = "admin@3clogic.com";
	String adminPassword="webastra";
	String callCenterEmail = "abcd@3clogic.com";
	String callCenterPassword="12345678";
	
	protected final String baseUrl = "http://sandbox.3clogic.com";
	
	
	@Test(description="Log in as Admin")
	public void loginAdmin() throws  Exception{
		loginPage = new LogInPage(driver, baseUrl);
		sleep(5);
		adminHomePage= loginPage.loginAsAdmin(adminEmail, adminPassword);
		sleep(5);
	}
	
	@Test(description="Log in")
	public void login() throws Exception{
		loginPage = new LogInPage(driver, baseUrl);
		sleep(5);
		callCenter= loginPage.loginAs(callCenterEmail, callCenterPassword);
		sleep(5);
	}
	
	
	@Test(description="Test Ride")
	public void newTest() throws Exception{
		loginAdmin();
		callCenter = adminHomePage.enterCallCenter("paul@3clogic.com");
		crmPage = callCenter.gotoCRMPage();
		for(int i=15;i<=21;i++){
			crmPage.assignAllLeads("CodeProject"+i);
		}
		
	}
	
	

	
	 
	
	
	@Test(description="New Account Creation")
	public void newAccountCreationTest() throws Exception{
		
		String email ="paul@3clogic.com";
		String fullName ="Promethus";
		String password="12345678";
		String title="Analyst";
		String organization="darth vader";
		String address="Washington DC";
		String city="New York";
		String state="NY";
		String postalCode="12345";
		String country="India";
		String phone="12345";
		String recommendation ="Search Engine"; 
		
		loginPage = new LogInPage(driver ,baseUrl );
		 
		registerPage  = loginPage.gotoRegistrationPage();
		registerPage.createAccount(email, fullName, password, title, organization, address, city, state, postalCode, country, phone, recommendation);
		Assert.assertTrue(driver.getCurrentUrl().equals(baseUrl+"ls/static/registration_sucessful.html"));
		
		 
		adminHomePage = loginPage.loginAsAdmin("admin@3clogic.com", "webastra");
		adminHomePage.activateAccount(email,password,7);
		adminHomePage.signOut();
		
		 	
		
		 
		callCenter = loginPage.loginAs(email, password);
		callCenter.createCallCenter("callCenterName", "Asia/Calcutta", "English", "US Dollars");
		Assert.assertTrue(driver.getCurrentUrl().equals(baseUrl+"/ms/static/setup.html"));
		
	}
	
	@Test(description= "Complete Portal Check")
	public void portalTest() throws Exception{
		
	}
	
	@Test(description="New Account Creation by Admin")
	public void newAccountCreationByAdminTest() throws Exception{
		String email ="paul@3clogic.com";
		String fullName ="Promethus";
		String password="12345678";
		String role= "role_owner";
		int setStatus= 7;
		String title="Analyst";
		String organization="Org";
		String address="Washington DC";
		String city="New York";
		String state="NY";
		String postalCode="12345";
		String country="India";
		String phone="99999";
		String recommendation ="Search Engine"; 
		
		loginPage = new LogInPage(driver, baseUrl);
		adminHomePage = loginPage.loginAsAdmin("admin@3clogic.com", "webastra");
		adminHomePage.createAccountByAdmin(email, fullName, password, role, setStatus, title, organization, address, city, state, postalCode, country, phone, recommendation);
		adminHomePage.signOut();
		
		
		callCenter = loginPage.loginAs(email, password);
		callCenter.createCallCenter("Dr Suess", "Asia/Calcutta", "English", "US Dollars");
		verifyTrue((driver.getCurrentUrl().equals(baseUrl+"/ms/static/setup.html")), "Error: CallCenter during creation"); 
		callCenter.signOut();
	}
	
	
	@Test(description="Update Call Center Profile")
	public void updateCallCenterProfileTest() throws Exception{
		String oldPassword="12345678";
		String newPassword="12345678";
		String confirmedNewPassword="12345678";
		String emailAddress="xyz@3clogic.com";
		String fullName="Promethus";
		String address="Washington DC";
		String city="Chicago";
		String state="CA";
		String country="India";
		String zipCode="54321";
		String phone="54321";
		String timeZone="Asia/Calcutta";
		String language="English";
		String currency="US Dollars";
		
		login();	
		callCenter.gotoProfile();
		callCenter.updateProfile(oldPassword, newPassword, confirmedNewPassword, emailAddress, fullName, address, city, state, country, zipCode, phone, timeZone, language, currency);
		verifyTrue(selenium.isTextPresent("Your Email address has been successfully updated."), "Error: While updating profile");
		callCenter.signOut();
	}
	
	
	@Test(description="New Project Creation")
	public void createProjectTest() throws Exception{
		login();
		projectPage = callCenter.gotoProjectPage();
		sleep(5); 
		projectPage.createOutboundProject("Code 909");
		sleep(2); 
		projectPage.signOut();
	}
	
	
	@Test(description="Delete Existing Project")
	public void deleteProjectTest() throws Exception{
		
		callCenter= adminHomePage.enterCallCenter("vsharma@3clogic.com");
		sleep(5);
		projectPage = callCenter.gotoProjectPage();
		sleep(5);
		for(int i=0;i<50;i++){
			projectPage.deleteProject("Testing Project"+i);
			sleep(2); 
			} 	 
	}
	
	
	@Test(description="Create Agent")
	public void createAgentTest() throws Exception{  
		login();
		agentPage = callCenter.gotoAgentPage(); 
		agentPage.addAgent("Agent L", "Agent L", "webastra", "test@3clogic.com", true); 
		agentPage.signOut();
	}
	
	@Test(description="assign Agent")
	public void assignAgentTest() throws Exception{
		login();
		projectPage= callCenter.gotoProjectPage();
		projectPage.gotoProject("Code 909");
		projectPage.assignAllAvailableAgent(); 
		projectPage.signOut();
	}
	
	
	public void assignPackageTest() throws Exception{
		loginAdmin();
		adminHomePage.enterCallCenter(callCenterEmail);
		callCenter = adminHomePage.gotoCCHomePage();
		callCenter.gotoBuyPackages();
		callCenter.addPackages(By.id("quantity_package_4"), 30);
		callCenter.signOut();
//		login();
//		agentPage = callCenter.gotoAgentPage();
//		agentPage.gotoAgent("Agent L");
//		agentPage.gotoAgentAssignPackages();
//		agentPage.signOut();
	}
	
	@Test(description="Import leads")
	public void importLeadsTest() throws Exception{
		String path = "G:\\3cLogic\\My\\Myleads220leads.csv";
		login();
		crmPage= callCenter.gotoCRMPage();
		sleep(5);
		crmPage.gotoImportLeads();
		sleep(5);
		
		crmPage.importLeads(path);
		crmPage.signOut();
	}
	
	@Test(description= "assign leadds")
	public void assignLeadsTest() throws Exception{
		login();
		crmPage= callCenter.gotoCRMPage();
		crmPage.assignAllLeads("code 909");
		crmPage.signOut();
	}
	
	@Test(description="AssignAllAgent")
	public void assignAllAgentTest() throws Exception{
		
		callCenter = adminHomePage.enterCallCenter("vsharma@3clogic.com");
		sleep(5);
		projectPage = callCenter.gotoProjectPage();
		
		
		for(int i=2; i<=250;i++){
			projectPage.gotoProject("Dashboard"+i);
			while(isElementPresent(By.xpath("//input[@value='Bulk Assign']"))){
				projectPage.assignAllAvailableAgent();
				sleep(2);
				}		
			try {
				Assert.assertTrue(isElementPresent(By.cssSelector("td.blueBox")));
				writeText("All available agents assigned in "+"Dashboard"+i+" .... @"+getDate());
				System.out.println("All available agents assigned in "+"Dashboard"+i+" .... @"+getDate());
			} catch (Error e) {
				verificationErrors.append(e.toString());
				writeText("Error: While assigning agents in "+"Dashboard"+i+" .... @"+getDate());
				System.out.println("Error: While assigning agents in "+"Dashboard"+i+" .... @"+getDate());
			}
		
		
		}
		
	}
	
	
	@Test(description="AssignAllAvailableLeads")
	public void assignLeads() throws Exception{
		callCenter = adminHomePage.enterCallCenter("vsharma@3clogic.com");
		sleep(2);
		crmPage = callCenter.gotoCRMPage();
		sleep(2);
		
		for(int i=1; i<=250;i++){
		crmPage.assignAllLeads("Dashboard"+i);
			}
	}
	
	
	public void addpackage() throws Exception{
		callCenter = adminHomePage.enterCallCenter("vsharma@3clogic.com");
		sleep(2);
		agentPage= callCenter.gotoAgentPage();
		agentPage.gotoAgent("DashboardAgent1");	
		
	}
	
	@Test(description="Change Dial Plan")
	public void testDialPlan() throws Exception {
		callCenter = adminHomePage.enterCallCenter("vsharma@3clogic.com");
		sleep(2);
		projectPage = callCenter.gotoProjectPage();
		sleep(1);
		for(int i=1; i<=250; i++){
			projectPage.gotoProject("Dashboard"+i);
			projectPage.changeDialPlan();
		}
		
	}
	
	 
	
	
	@Test(description="Basic Sanity Test")
	public void verifyRoles() throws Exception{
		callCenter = adminHomePage.enterCallCenter("vsharma@3clogic.com");
		advancePage=callCenter.gotoAdvancePage();
		advancePage.gotoRoles();
//		advancePage.verifyAgentPortalRoles("roles.txt");
//		advancePage.showSelectedRoles();
		Thread.sleep(5000);
//		isTextPresent("project");
		
		
	}
}

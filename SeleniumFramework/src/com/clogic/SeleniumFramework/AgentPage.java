package com.clogic.SeleniumFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;





/**
 * AgentPage class, extends BasicSetUp class
 * and provides all the services on Agent Page
 */
public class AgentPage extends BasicSetUp{
	
	
	protected final WebDriver driver;
	
	/**
	 * Instantiates new Agent Page
	 *
	 * @param driver the driver
	 * @throws Exception the exception
	 */
	public AgentPage(WebDriver driver) throws Exception{
		this.driver=driver;		
	}
	
	
	
	
	
	
	
	/**
	 * Add agent to Call Center
	 *
	 * @param agentname     Agent Name as String
	 * @param username 		Agent User name as String, Leave blank if want to generate userid automatically
	 * @param password 		Password as String
	 * @param email 		Email as String, Leave blank if not required.
	 * @param check 		True if want to generate user name automatically. False otherwise.
	 * @throws Exception 
	 */
	public void addAgent(String agentname, String username, String password, String email, boolean check) throws Exception{
		
		
		
		driver.findElement(By.id("menu_members")).click();
		try{
			driver.findElement(By.id("add_member")).click();
			driver.findElement(By.id("newmember_name")).clear();
			driver.findElement(By.id("newmember_name")).sendKeys(agentname);
			if(!check){
				driver.findElement(By.id("newuser_name")).clear();
				driver.findElement(By.id("newuser_name")).sendKeys(username);
				driver.findElement(By.id("newmember_password")).clear();
				driver.findElement(By.id("newmember_password")).sendKeys(password);
				driver.findElement(By.id("newmember_cpassword")).clear();
				driver.findElement(By.id("newmember_cpassword")).sendKeys(password);
				driver.findElement(By.id("newmember_email")).clear();
				driver.findElement(By.id("newmember_email")).sendKeys(email);
				driver.findElement(By.id("newmember_add")).click();
				waitBetween(10);
				driver.findElement(By.cssSelector("div.bottom-message > div.message-box.displayreport > span.message-text")).getText();
				System.out.println(driver.findElement(By.cssSelector("div.bottom-message > div.message-box.displayreport > span.message-text")).getText());
				System.out.println("Agent: "+ username+ " is added succesfully @"+ getDate());
				writeText("Agent "+ username + " added succesfully @"+ getDate());
			}
			else{
				driver.findElement(By.id("auto_generated")).click();
				driver.findElement(By.id("newmember_password")).clear();
				driver.findElement(By.id("newmember_password")).sendKeys(password);
				driver.findElement(By.id("newmember_cpassword")).clear();
				driver.findElement(By.id("newmember_cpassword")).sendKeys(password);
				driver.findElement(By.id("newmember_email")).clear();
				driver.findElement(By.id("newmember_email")).sendKeys(email);
				driver.findElement(By.id("newmember_add")).click();
				waitBetween(10);
				driver.findElement(By.cssSelector("div.bottom-message > div.message-box.displayreport > span.message-text"));
				writeText(driver.findElement(By.cssSelector("div.bottom-message > div.message-box.displayreport > span.message-text")).getText() +" @ "+ getDate());
				System.out.println(driver.findElement(By.cssSelector("div.bottom-message > div.message-box.displayreport > span.message-text")).getText() +" @ "+ getDate());
				System.out.println("Agent: "+ agentname+ " is added succesfully @"+ getDate());
				writeText("Agent "+ agentname + " added succesfully @"+ getDate());
			}
			
			
			
			
		}
		catch(Exception e){
			captureScreen(agentname+"_add_error");
			System.out.println("Error: Agent: "+ agentname+ " didn't add @ "+ getDate());
			writeText("Error: Agent: "+ agentname+ " : ) didn't add @ "+ getDate());
		}
		
	} 			
	
	

	/**
	 * Deletes all agent present in Call Center.
	 *
	 * @throws Exception 
	 */
	public void deleteAllAgent() throws Exception{
		
				
				try {
					
					
					boolean check =isElementPresent(By.cssSelector("td.blueBox"));
					while(!check){
					
					driver.findElement(By.id("select_all")).click();
					driver.findElement(By.id("delete_member")).click();
					driver.findElement(By.id("member_action")).click();
					check = isElementPresent(By.cssSelector("td.blueBox"));
					
					}
					
					writeText("All agents are deleted successfully @"+ getDate());
					System.out.println("All agents are deleted successfully @"+ getDate());
					
				}
				
				catch(Exception e){
				
				captureScreen("deleteAllAgent_error");
				writeText("Error: Agents aer not deleted @"+ getDate());
				System.out.println(e);
					
				}
		
		
		
	} 				
	
	public void assignProject(String agentName) throws Exception{
		
		driver.findElement(By.id("menu_members")).click(); 
		
	}
	
	public void assignPackage() throws Exception{
		try{
			writeText("Assigning Package to Agent.... @"+ getDate());
			System.out.println("Assigning Package to Agent.... @"+ getDate());
			
			
			driver.findElement(By.xpath("//input[@value='Assign Package']")).click();
		}
		catch(Exception e){
			captureScreen("assignPackage_error"+randoms);
			writeText("Error: While Assigning Package to Agent.... @"+ getDate());
			System.out.println("Error: While Assigning Package to Agent.... @"+ getDate());
		}
	}
	
	public void gotoAgent(String userName) throws Exception{
		
		try{
			
			writeText("Moving inside "+userName+".... @"+getDate());
			System.out.println("Moving inside "+userName+".... @"+getDate());
			
			driver.findElement(By.id("menu_members")).click();
			driver.findElement(By.id("filter")).click();
			driver.findElement(By.id("generated_filter_700")).clear();
			driver.findElement(By.id("generated_filter_700")).sendKeys(userName);
			driver.findElement(By.linkText("Apply")).click();
			driver.findElement(By.cssSelector("input.edit-button")).click();
			String agentName = driver.findElement(By.cssSelector("h2.blue-title4")).getText().toString();
			
			writeText("Inside "+agentName+".... @"+getDate());
			System.out.println("Inside "+agentName+".... @"+getDate());
		}
		
		catch(Exception e){
			captureScreen("gotoAgent_error"+randoms);
			writeText("Error: While Moving inside "+userName+".... @"+getDate());
			System.out.println("Error: While Moving inside "+userName+".... @"+getDate());
		}
		
	}
	
	
	public void gotoAgentDetails() throws Exception{
		try{
			
			writeText("Navigating to Agent Details Page...."+getDate());
			System.out.println("Navigating to Agent Details Page...."+getDate());
			
			new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Details")));
			driver.findElement(By.linkText("Details")).click();
		}
		catch(Exception e){
			captureScreen("gotoAgentDetails_error_"+randoms);
			writeText("Error: while Navigating to Agent Details Page...."+getDate());
			System.out.println("Error: while Navigating to Agent Details Page...."+getDate());
		}
	}
	
	public void gotoAgentProjects() throws Exception{
		try{
			
			writeText("Navigating to Agent Projects Page...."+getDate());
			System.out.println("Navigating to Agent Projects Page...."+getDate());
			
			new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#PROJECTS_SUBMENU > a")));
			driver.findElement(By.cssSelector("#PROJECTS_SUBMENU > a")).click();
		}
		catch(Exception e){
			captureScreen("gotoAgentProjects_error_"+randoms);
			writeText("Error: while Navigating to Agent Projects Page...."+getDate());
			System.out.println("Error: while Navigating to Agent Projects Page...."+getDate());
		}
	}
	
	public void gotoAgentAssignPackages() throws Exception{
		try{
			
			writeText("Navigating to Agent Assign Package Page...."+getDate());
			System.out.println("Navigating to Agent Assign Package Page...."+getDate());
			
			new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Assign Packages")));
			driver.findElement(By.linkText("Assign Packages")).click();
		}
		catch(Exception e){
			captureScreen("gotoAgentAssignPackages_error_"+randoms);
			writeText("Error: while Navigating to Agent Assign Package Page...."+getDate());
			System.out.println("Error: while Navigating to Agent Assign Package Page...."+getDate());
		}
	}
	
	public void gotoAgentNotify() throws Exception{
		try{
			
			writeText("Navigating to Agent Notify Page...."+getDate());
			System.out.println("Navigating to Agent Notify Page...."+getDate());
			
			new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Notify")));
			driver.findElement(By.linkText("Notify")).click();
		}
		catch(Exception e){
			captureScreen("gotoAgentNotify_error_"+randoms);
			writeText("Error: while Navigating to Agent Notify Page...."+getDate());
			System.out.println("Error: while Navigating to Agent Notify Page...."+getDate());
		}
	}
	
	public void gotoAgentAgentVariables() throws Exception{
		try{
			
			writeText("Navigating to Agent Variables Page...."+getDate());
			System.out.println("Navigating to Agent Variables  Page...."+getDate());
			
			new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Agent Variables")));
			driver.findElement(By.linkText("Agent Variables")).click();
		}
		catch(Exception e){
			captureScreen("gotoAgentAgentVariables_error_"+randoms);
			writeText("Error: while Navigating to Agent Variables Page...."+getDate());
			System.out.println("Error: while Navigating to Agent Variables Page...."+getDate());
		}
	}
	
	
	
	
	
	
	
		

	
	
	
}

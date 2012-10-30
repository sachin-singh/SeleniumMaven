package com.clogic.SeleniumFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * CCHomePage class, extends BasicSetUp class
 * and have all the services provided on 
 * CCHomePage.
 */
public class CCHomePage extends BasicSetUp{
	
	
	protected final WebDriver driver;
	
	/**
	 * Instantiates a new CCHomePage
	 *
	 * @param driver     driver object
	 * @throws Exception 
	 */
	public CCHomePage(WebDriver driver) throws Exception{
		this.driver=driver;
		
	}
	
	
	
	/**
	 * Create call center
	 *
	 * @param String    Call Center Name
	 * 			
	 * @throws Exception 
	 */
	
	
     public void createCallCenter(String callCenterName, String timeZone, String language, String currency) throws Exception{
    	 try{
    		 
 			writeText("Creating CallCenter.... @" + getDate());
 			System.out.println("Creating CallCenter.... @" + getDate());
    		 
    		 	waitBetween(20);
    		 	driver.findElement(By.id("callcentername")).clear();
    			driver.findElement(By.id("callcentername")).sendKeys(callCenterName);
    			new Select(driver.findElement(By.id("cctz"))).selectByVisibleText(timeZone);
    			new Select(driver.findElement(By.id("cclang"))).selectByVisibleText(language);
    			new Select(driver.findElement(By.id("cccurrency"))).selectByVisibleText(currency);
    			
    			driver.findElement(By.id("step2next")).click();
    			 
    			new WebDriverWait(driver, 600).until(ExpectedConditions.visibilityOfElementLocated(By.id("ccwizard.label.congrats")));
    			
    			
    			 
    			driver.findElement(By.id("step3done")).click();
    			
    			waitBetween(50);
    			

    			
    	 }
    	 
    	 catch(Exception e){
    		 captureScreen("create_callcenter_error");
    		 writeText("Error: While Creating CallCenter.... @" + getDate());
  			System.out.println("Error: While Creating CallCenter.... @" + getDate());
    		 
    	 }
     }
     
     
     
     public void updateProfile(String oldPassword, String newPassword, String confirmedNewPassword,String emailAddress, String fullName, String address, String city, String state, String country, String zipCode, String phone, String timeZone, String language, String currency) throws Exception{
    	 try{
    		 writeText("Updating Call Center Profile.... @" + getDate());
  			System.out.println("Updating Call Center Profile.... @" + getDate());
  			
  			 
  			driver.findElement(By.id("oldpassword")).clear();
  			driver.findElement(By.id("oldpassword")).sendKeys(oldPassword);
  			driver.findElement(By.id("password")).clear();
  			driver.findElement(By.id("password")).sendKeys(newPassword);
  			driver.findElement(By.id("password0")).clear();
  			driver.findElement(By.id("password0")).sendKeys(confirmedNewPassword);
  			driver.findElement(By.id("email")).clear();
  			driver.findElement(By.id("email")).sendKeys(emailAddress);
  			driver.findElement(By.id("fullname")).clear();
  			driver.findElement(By.id("fullname")).sendKeys(fullName);
  			driver.findElement(By.id("contact_address")).clear();
  			driver.findElement(By.id("contact_address")).sendKeys(address);
  			driver.findElement(By.id("contact_city")).clear();
  			driver.findElement(By.id("contact_city")).sendKeys(city);
  			driver.findElement(By.id("contact_state")).clear();
  			driver.findElement(By.id("contact_state")).sendKeys(state);
  			new Select(driver.findElement(By.id("contact_country"))).selectByVisibleText(country); 
  			driver.findElement(By.id("contact_pin")).clear();
  			driver.findElement(By.id("contact_pin")).sendKeys(zipCode);
  			driver.findElement(By.id("contact_phone")).clear();
  			driver.findElement(By.id("contact_phone")).sendKeys(phone);
  			new Select(driver.findElement(By.id("cctz"))).selectByVisibleText(timeZone);
  			driver.findElement(By.id("updateprofile")).click();
  			
    	 }
    	 
    	 catch(Exception e){
    		captureScreen("updateProfile_error"+randoms);
    		writeText("Error: While Updating Call Center Profile.... @" + getDate());
   			System.out.println("Error: While Updating Call Center Profile.... @" + getDate());
    	 }
    	 
     }

	
     public void gotoStatus() throws Exception{
 		
 		try{
 			
 			writeText("Navigating to Status Page...."+getDate());
 			System.out.println("Navigating to Status Page...."+getDate());
 			
 			new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Status")));
 			driver.findElement(By.linkText("Status")).click();
 		}
 		catch(Exception e){
 			captureScreen("gotoStatus_error_"+randoms);
 			writeText("Error: while Navigating to Status Page...."+getDate());
 			System.out.println("Error: while Navigating to Status Page...."+getDate());
 		}
 		
 	}
     
     public void addPackages(By by, int quantity) throws Exception{
    	 try{
    		 writeText("Adding Package...."+getDate());
  			System.out.println("Adding Package...."+getDate());
    		 new WebDriverWait(driver, 100).until(ExpectedConditions.presenceOfElementLocated(by));
    		 driver.findElement(by).clear();
    		 driver.findElement(by).sendKeys(new Integer(quantity).toString());
    		 driver.findElement(By.id("proceedToPayment")).click();
    	 }
    	 catch(Exception e){
    		 captureScreen("addPackages_error"+randoms);
    		 writeText("Error: While Adding Package...."+getDate());
   			System.out.println("Error: While Adding Package...."+getDate());
    	 }
     }
     
     
     public void gotoBuyPackages() throws Exception{
  		
  		try{
  			
  			writeText("Navigating to Buy Packages Page...."+getDate());
  			System.out.println("Navigating to Buy Packages Page...."+getDate());
  			
  			new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Buy Packages")));
  			driver.findElement(By.linkText("Buy Packages")).click();
  		}
  		catch(Exception e){
  			captureScreen("gotoStatus_error_"+randoms);
  			writeText("Error: while Navigating to Buy Packages Page...."+getDate());
  			System.out.println("Error: while Navigating to Buy Packages Page...."+getDate());
  		}
  		
  	}
	 
     
     public void gotoProfile() throws Exception{
   		
   		try{
   			
   			writeText("Navigating to Profile Page...."+getDate());
   			System.out.println("Navigating to Profile Page...."+getDate());
   			
   			new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Profile")));
   			driver.findElement(By.linkText("Profile")).click();
   		}
   		catch(Exception e){
   			captureScreen("gotoProfile_error_"+randoms);
   			writeText("Error: while Navigating to Profile Page...."+getDate());
   			System.out.println("Error: while Navigating to Profile Page...."+getDate());
   		}
   		
   	}
     
 
	 

}

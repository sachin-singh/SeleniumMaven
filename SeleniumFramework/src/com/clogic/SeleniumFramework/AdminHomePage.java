package com.clogic.SeleniumFramework;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminHomePage extends BasicSetUp{
	
	protected final WebDriver driver;
	protected final String baseUrl;
	
	public AdminHomePage(WebDriver driver, String baseUrl) throws Exception{
		this.driver=driver;
		this.baseUrl= baseUrl;
	}
	
	public void activateAccount(String email, String password, int setStatus, String server) throws Exception{
		
		try{
				String status="";
				switch(setStatus){
				case  -1:
					status = "-- Select Status --";
				case  2:
					status = "Trial";
				case  3:
					status="Enabled (Excludes Click-4-Agent)";
				case  4:
					status = "Disabled";
				case  5:
					status = "Enabled (Includes Click-4-Agent)";
				case  6:
					status ="Enabled (Inbound Only)";
				case  7:
					status ="Enabled (Inbound + Outbound)";			
					
				}
				new WebDriverWait(driver, 100).until(ExpectedConditions.visibilityOfElementLocated(By.id("query")));
				driver.findElement(By.id("query")).clear();
				driver.findElement(By.id("query")).sendKeys(email);
				driver.findElement(By.id("filter")).click();
				driver.findElement(By.linkText("Update account status")).click();		
				driver.findElement(By.cssSelector("input.flatbtn.lang")).click();
				Thread.sleep(5000);
				
				
				new Select(driver.findElement(By.id("access_groups_options"))).selectByVisibleText(status);
				
				driver.findElement(By.id(server)).click();
				driver.findElement(By.id("update")).click();
				
				waitBetween(20);
				
				
				 
		  }
		
		catch(Exception e){
			e.printStackTrace();
			captureScreen("activation_error");
			writeText("Error: During Account Activation @ "+ getDate());
			System.out.println("Error: During Account Activation @ "+ getDate() );
		}
	}
	
	
	
	public void createAccountByAdmin(String email, String fullName, String password,String role, int setStatus, String title, String organization, String address, String city, String state, String postalCode, String country, String phone, String recommendation) throws IOException{
		
		
		String status="";
		switch(setStatus){
		case  -1:
			status = "-- Select Status --";
		case  2:
			status = "Trial";
		case  3:
			status="Enabled (Excludes Click-4-Agent)";
		case  4:
			status = "Disabled";
		case  5:
			status = "Enabled (Includes Click-4-Agent)";
		case  6:
			status ="Enabled (Inbound Only)";
		case  7:
			status ="Enabled (Inbound + Outbound)";			
			
		}
		 
		
		
		
		try{
		
			writeText("Creating New Account by Admin.... @ "+ getDate());
			System.out.println("Creating New Account by Admin.... @ "+ getDate());	
			
		driver.findElement(By.linkText("Create Account")).click(); 
		
		WebElement enterEmail= new WebDriverWait(driver, 60).until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
		
		enterEmail.clear();
		enterEmail.sendKeys(email);
		
		driver.findElement(By.id("fullname")).clear();
		driver.findElement(By.id("fullname")).sendKeys(fullName);
		
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(password);
		
		driver.findElement(By.id("password0")).clear();
		driver.findElement(By.id("password0")).sendKeys(password);
		
		driver.findElement(By.id(role)).click();
		
		new Select(driver.findElement(By.id("access_groups_options"))).selectByVisibleText(status);
		
		driver.findElement(By.id("organization")).clear();
		driver.findElement(By.id("organization")).sendKeys(organization);
		
		driver.findElement(By.id("contact_address")).clear();
		driver.findElement(By.id("contact_address")).sendKeys(address);
		
		driver.findElement(By.id("contact_city")).clear();
		driver.findElement(By.id("contact_city")).sendKeys(city);
		
		driver.findElement(By.id("contact_state")).clear();
		driver.findElement(By.id("contact_state")).sendKeys(state);
		
		driver.findElement(By.id("contact_pin")).clear();
		driver.findElement(By.id("contact_pin")).sendKeys(postalCode);
		
		new Select(driver.findElement(By.id("contact_country"))).selectByVisibleText(country);
		
		driver.findElement(By.id("contact_phone")).clear();
		driver.findElement(By.id("contact_phone")).sendKeys(phone);
		
		driver.findElement(By.id("update")).click();	
		
		}
		
		catch(Exception e){
			captureScreen("account_creation");
			writeText("Error: During Creating New Account by Admin.... @ "+ getDate());
			System.out.println("Error: During Creating New Account by Admin.... @ "+ getDate());	
			}
			
		}
	
	
	public CCHomePage enterCallCenter(String email) throws Exception{
		try{
			writeText("Entering in "+email+"'s Call Center.... @ "+ getDate());
			System.out.println("Entering in "+email+"'s Call Center.... @ "+ getDate());
			
			driver.get(baseUrl + "/ls/static/changecenter.html");
			driver.findElement(By.id("query")).clear();
			driver.findElement(By.id("query")).sendKeys(email);
			driver.findElement(By.id("filter")).click();
			driver.findElement(By.cssSelector("input.edit-button")).click();
			return new CCHomePage(driver);
		}
		
		catch(Exception e){
			captureScreen("error");
			writeText("Error: While Entering in "+email+"'s Call Center.... @ "+ getDate());
			System.out.println("Error: While Entering in "+email+"'s Call Center.... @ "+ getDate());
			return new CCHomePage(driver);
		}
	}
	
	
	
}

package com.clogic.SeleniumFramework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage extends BasicSetUp{
	
	
	protected final WebDriver driver;
	
	/**
	 * Instantiates new Register Page
	 *
	 * @param driver the driver
	 * @throws Exception the exception
	 */
	public RegisterPage(WebDriver driver) throws Exception{
		this.driver=driver;
	}
	
	public void createAccount(String email, String fullName, String password, String title, String organization, String address, String city, String state, String postalCode, String country, String phone, String recommendation) throws IOException{
		try{
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(email);
		
		driver.findElement(By.id("fullname")).clear();
		driver.findElement(By.id("fullname")).sendKeys(fullName);
		
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(password);
		
		driver.findElement(By.id("password0")).clear();
		driver.findElement(By.id("password0")).sendKeys(password);
		
		
		
		new Select(driver.findElement(By.id("title"))).selectByVisibleText(title);
		
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
		
		new Select(driver.findElement(By.name("comments"))).selectByVisibleText(recommendation);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String captcha = reader.readLine();
		
		driver.findElement(By.id("recaptcha_response_field")).sendKeys(captcha);
		
		driver.findElement(By.id("update")).click();
		waitBetween(10);
		if(isElementPresent(By.id("registration_sucessful.label.successfully"))){
			System.out.println(driver.findElement(By.id("registration_sucessful.label.successfully")).getText().toString());
		}
		
		
		 
	}
		
		catch(Exception e){
			
			e.printStackTrace();
			captureScreen("create_account_error"); 
			writeText("Error: Attempting account creation @ "+ getDate());
			System.out.println("Error:  Attempting account creation @ "+ getDate() );
			
		}
		
		
	}

	
	
}

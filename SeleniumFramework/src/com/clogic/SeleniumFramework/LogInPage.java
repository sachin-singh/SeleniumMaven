package com.clogic.SeleniumFramework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



/**
 * Class to perform log in operation
 */
public class LogInPage extends BasicSetUp{
	
	
	public final WebDriver driver;
	
	/** Initial Web Address*/
	public String baseUrl; 
	 
	
	/**
	 * Instantiates a new log in page.
	 *
	 * @param driver Browser driver
	 * @param baseUrl Initial web address
	 */
	public LogInPage(WebDriver driver, String baseurl ) throws FileNotFoundException, IOException{
		 
		this.baseUrl=baseurl;
		this.driver=driver;	
		driver.get(baseUrl +"/ls");
	}
	
	/**
	 * Attempts log in using user name and password provided.
	 *
	 * @param username    User Name as String
	 * @param password    Password as String 
	 * @return MyCallCenter  Object of MyCallCenter class 
	 * @throws Exception 
	 */
	public CCHomePage login(String username, String password) throws Exception{
		try{
			
			writeText("Logging in.... @ "+ getDate());
			System.out.println("Logging in.... @ "+ getDate());
			
		driver.get(baseUrl +"/ls"); 
		waitBetween(10);
		new WebDriverWait(driver, 300).until(ExpectedConditions.visibilityOfElementLocated(By.id("j_username")));
		driver.findElement(By.id("j_username")).clear();		
		driver.findElement(By.id("j_username")).sendKeys(username);		
		driver.findElement(By.id("j_password")).clear();		
		driver.findElement(By.id("j_password")).sendKeys(password);		
		driver.findElement(By.id("signin")).click();
		
		
		return new CCHomePage(driver);
		}
		catch(Exception e){
			captureScreen("login_error");
			writeText("Error: login not successful @ "+ getDate());
			System.out.println("Error: login not successful @ "+ getDate() );
			return new CCHomePage(driver);
		}
	}
	
	
	public RegisterPage gotoRegistrationPage()throws Exception{
		
		try{
			driver.findElement(By.id("label.new.registration")).click();
			writeText("Registeration Page Loaded @ "+ getDate());
			System.out.println("Registeration Page Loaded @ "+ getDate() );
			return new RegisterPage(driver);
		}
		catch(Exception e){
			captureScreen("create_account_error");
			writeText("Error: While Logging in.... @ "+ getDate());
			System.out.println("Error: While Logging in.... @ "+ getDate() );
			return new RegisterPage(driver);			
		}
	}
	
	
	public AdminHomePage loginAsAdmin(String username, String password) throws Exception{
		
		try{
			writeText("Logging in as Admin.... @ "+ getDate());
			System.out.println("Logging in as Admin.... @ "+ getDate() );
			driver.get(baseUrl +"/ls");
			 
			waitBetween(10);
			new WebDriverWait(driver, 300).until(ExpectedConditions.visibilityOfElementLocated(By.id("j_username")));
			driver.findElement(By.id("j_username")).clear();		
			driver.findElement(By.id("j_username")).sendKeys(username);		
			driver.findElement(By.id("j_password")).clear();		
			driver.findElement(By.id("j_password")).sendKeys(password);		
			driver.findElement(By.id("signin")).click();
			
			
			return new AdminHomePage(driver, baseUrl);
			}
			catch(Exception e){
				captureScreen("login_error");
				writeText("Error: While Logging in as Admin.... @ "+ getDate());
				System.out.println("Error: While Logging in as Admin.... @ "+ getDate() );
				return new AdminHomePage(driver, baseUrl);
			}
		}
	


		public void verifyAccountActivation(String email, String password) throws Exception{
			
			try{
				
				writeText("Verifying Account Activation.... @ "+ getDate());
				System.out.println("Verifying Account Activation.... @ "+ getDate());
				
				driver.get(baseUrl +"/ls");
				waitBetween(10);
				new WebDriverWait(driver, 300).until(ExpectedConditions.visibilityOfElementLocated(By.id("j_username")));
				driver.findElement(By.id("j_username")).clear();		
				driver.findElement(By.id("j_username")).sendKeys(email);		
				driver.findElement(By.id("j_password")).clear();		
				driver.findElement(By.id("j_password")).sendKeys(password);		
				driver.findElement(By.id("signin")).click();
				waitBetween(10); 
				 
				}
				catch(Exception e){
					captureScreen("login_error");
					writeText("Error: While Verifying Account Activation.... @ "+ getDate());
					System.out.println("Error: While Verifying Account Activation.... @ "+ getDate() );
					 
				}
				
			}
}
	



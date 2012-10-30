package com.clogic.SeleniumFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdvancedPage extends BasicSetUp{

	protected final WebDriver driver;
	WebElement element;
	
	public AdvancedPage(WebDriver driver) throws Exception{		
		this.driver=driver;
	}
	
	
	public void verifyAgentPortalRoles(String fileName) throws Exception{
		
		driver.findElement(By.cssSelector("input.edit-button")).click();
		Thread.sleep(5000);
				String[] rolesList = readText(fileName);
				for(int i=0; i<rolesList.length;i++){ 
					isTextPresent(rolesList[i]);
				}
	} 
	
//	public void showSelectedRoles() throws Exception{
//		driver.findElement(By.cssSelector("input.edit-button")).click();
//		webElement = driver.findElement(By.id("1pe"));
//		boolean result = webElement.isSelected();
//		System.out.println("check box selected? " + result);
//		System.out.println(webElement.getAttribute(arg0));
//	}
	
	 
	
	public void gotoRoles() throws Exception{
		try{
		writeText("Navigating to Roles Page.... @ "+ getDate());
		System.out.println("Navigating to Roles Page.... @ "+ getDate());
		 
		new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Roles")));
		driver.findElement(By.linkText("Roles")).click(); 
		}
		catch(Exception e){
			captureScreen("gotoRoles_error"+randoms);
			System.out.println("Error: During navigating to Roles Page@ "+ getDate());
			writeText("Error: During navigating to Roles Page@ "+ getDate()); 
		}
	}
	
	public void gotoProjectDialingRatio() throws Exception{
		try{
			writeText("Navigating to Project Dialing Ratio Page.... @ "+ getDate());
			System.out.println("Navigating to Project Dialing Ratio Page.... @ "+ getDate());
			 
			new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Project Dialing Ratio")));
			driver.findElement(By.linkText("Project Dialing Ratio")).click(); 
			}
			catch(Exception e){
				captureScreen("gotoProjectDialingRatio_error"+randoms);
				System.out.println("Error: During navigating to Project Dialing Ratio Page@ "+ getDate());
				writeText("Error: During navigating to Project Dialing Ratio Page@ "+ getDate()); 
			}
	}
	
	public void gotoCallField() throws Exception{
		try{
			writeText("Navigating to Call Field Page.... @ "+ getDate());
			System.out.println("Navigating to Call Field Page.... @ "+ getDate());
			 
			new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Call Fields")));
			driver.findElement(By.linkText("Call Fields")).click(); 
			}
		catch(Exception e){
				captureScreen("gotoCallField_error"+randoms);
				System.out.println("Error: During navigating to Call Field Page@ "+ getDate());
				writeText("Error: During navigating to Call Field Page@ "+ getDate()); 
			}
	}
	
	public void gotoCallWidget() throws Exception{
		try{
			writeText("Navigating to Call Widget Page.... @ "+ getDate());
			System.out.println("Navigating to Call Widget Page.... @ "+ getDate());
			 
			new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Call Widget")));
			driver.findElement(By.linkText("Call Widget")).click(); 
			}
		catch(Exception e){
				captureScreen("gotoCallWidget_error"+randoms);
				System.out.println("Error: During navigating to Call Widget Page@ "+ getDate());
				writeText("Error: During navigating to Call Widget Page@ "+ getDate()); 
			}
	}
	
	public void gotoCRMAPI() throws Exception{
		try{
			writeText("Navigating to CRM APIs Page.... @ "+ getDate());
			System.out.println("Navigating to CRM APIs Page.... @ "+ getDate());
			 
			new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.linkText("CRM APIs")	 ));
			driver.findElement(By.linkText("CRM APIs")).click();
			}
		catch(Exception e){
				captureScreen("gotoCRMAPI_error"+randoms);
				System.out.println("Error: During navigating to CRM APIs Page@ "+ getDate());
				writeText("Error: During navigating to CRM APIs Page@ "+ getDate()); 
			}
	}
	
	public void gotoEmailSetting() throws Exception{
		try{
			writeText("Navigating to Email Settings Page.... @ "+ getDate());
			System.out.println("Navigating to Email Settings Page.... @ "+ getDate());
			 
			new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Email Settings")));
			driver.findElement(By.linkText("Email Settings")).click();
			}
		catch(Exception e){
				captureScreen("gotoEmailSetting_error"+randoms);
				System.out.println("Error: During navigating to Email Settings Page@ "+ getDate());
				writeText("Error: During navigating to Email Settings Page@ "+ getDate()); 
			}
	}
	
	
	public void gotoPackages() throws Exception{
		try{
			writeText("Navigating to Packages Page.... @ "+ getDate());
			System.out.println("Navigating to Packages Page.... @ "+ getDate());
			 
			new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Packages")	));
			driver.findElement(By.linkText("Packages")).click();
			}
		catch(Exception e){
				captureScreen("gotoPackages_error"+randoms);
				System.out.println("Error: During navigating to Packages Page@ "+ getDate());
				writeText("Error: During navigating to Packages Page@ "+ getDate()); 
			}
	}
	
	public void gotoPresence() throws Exception{
		try{
			writeText("Navigating to Presence Page.... @ "+ getDate());
			System.out.println("Navigating to Presence Page.... @ "+ getDate());
			 
			new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Presence")));
			driver.findElement(By.linkText("Presence")).click();
			}
		catch(Exception e){
				captureScreen("gotoPresence_error"+randoms);
				System.out.println("Error: During navigating to Presence Page@ "+ getDate());
				writeText("Error: During navigating to Presence Page@ "+ getDate()); 
			}
	}
	
	
	public void gotoVariableTempelates() throws Exception{
		try{
			writeText("Navigating to Variable Tempelates Page.... @ "+ getDate());
			System.out.println("Navigating to Variable Tempelates Page.... @ "+ getDate());
			 
			new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Variable Templates")));
			driver.findElement(By.linkText("Variable Templates")).click();
			}
		catch(Exception e){
				captureScreen("gotoVariableTempelates_error"+randoms);
				System.out.println("Error: During navigating to Variable Tempelates Page@ "+ getDate());
				writeText("Error: During navigating to Variable Tempelates Page@ "+ getDate()); 
			}
	}
	
	
}

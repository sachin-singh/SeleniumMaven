package com.clogic.SeleniumFramework;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProjectPage extends BasicSetUp{

	protected final WebDriver driver;
	
	public ProjectPage(WebDriver driver ) throws Exception{
		this.driver=driver;
	}
	
	
	public void createOutboundProject(String projName) throws IOException{
		
		try{
			
			driver.findElement(By.id("menu_projects")).click();
			
			writeText("Creating Project "+projName+".... @"+getDate());
			System.out.println("Creating Project "+projName+".... @"+getDate());
			waitBetween(20);
		driver.findElement(By.id("addProj")).click();
		driver.findElement(By.id("newgroup_name")).clear();
		driver.findElement(By.id("newgroup_name")).sendKeys(projName);
		driver.findElement(By.id("projecttype_outbound")).click(); 
		driver.findElement(By.id("newgroup_add")).click();
		sleep(5);
		String message = driver.findElement(By.cssSelector("span.message-text")).getText();
		
		writeText(message);
		System.out.println(message);
		}
		catch(Exception e){
			captureScreen("project_create_error");
			writeText("Error: While Creating Project.... @"+getDate());
			System.out.println("Error: While Creating Project.... @"+getDate());
		}
		
		
	}
	
	
	public void deleteProject(String projName) throws Exception{
		try{
			writeText("Deleting Project "+projName+".... @"+getDate());
			System.out.println("Deleting Project "+projName+".... @"+getDate());
			
			driver.findElement(By.id("filter")).click();
			driver.findElement(By.id("generated_filter_800")).clear();
			driver.findElement(By.id("generated_filter_800")).sendKeys(projName);
			driver.findElement(By.linkText("Apply")).click();
			driver.findElement(By.id("cbox0")).click();
			driver.findElement(By.id("delProj")).click();
			driver.findElement(By.id("deletegroup_delete")).click();
			String message = driver.findElement(By.cssSelector("div.bottom-message > div.message-box.displayreport > span.message-text")).getText().toString();
			
			writeText(message+getDate());
			System.out.println(message+getDate());	 
		}
		
		catch(Exception e){
			captureScreen(projName+"_delete_error");
			writeText("Error: While Deleting Project "+projName+".... @"+getDate());
			System.out.println("Error:While Deleting Project "+projName+".... @"+getDate());
		}
	}
	
	
	public void gotoProject(String projectName) throws Exception{
		
		try{
			writeText("Moving to "+projectName+".... @"+getDate());
			System.out.println("Moving to "+projectName+".... @"+getDate());
			
			driver.findElement(By.id("menu_projects")).click();
			
			driver.findElement(By.id("filter")).click();
			driver.findElement(By.id("generated_filter_800")).clear();
			driver.findElement(By.id("generated_filter_800")).sendKeys(projectName);
			driver.findElement(By.linkText("Apply")).click();
			sleep(5);
			
			driver.findElement(By.cssSelector("input.edit-button")).click();
			new WebDriverWait(driver, 200).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h2.blue-title4")));
			String currentProject = driver.findElement(By.cssSelector("h2.blue-title4")).getText().toString();
			writeText("Inside "+currentProject+".... @"+getDate());
			System.out.println("Inside "+currentProject+".... @"+getDate());
		}
		
		catch(Exception e){
			captureScreen("gotoProject_error");
			writeText("Error: While Moving to "+projectName+".... @"+getDate());
			System.out.println("Error: While Moving to "+projectName+".... @"+getDate());
		}
	}
	
	public void assignAllAvailableAgent() throws Exception{
		
		writeText("Assignign Agents .... @"+getDate());
		System.out.println("Assignign Agents .... @"+getDate());
		
		try{
			new WebDriverWait(driver, 100).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='Bulk Assign']")));
			while(isElementPresent(By.xpath("//input[@value='Bulk Assign']"))){
				new WebDriverWait(driver, 100).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='Bulk Assign']")));
				driver.findElement(By.id("unassigned_select_all")).click();
				driver.findElement(By.xpath("//input[@value='Bulk Assign']")).click();
			}
		}
		
		catch(Exception e){
			captureScreen("assignAllAvailableAgent_error");
			writeText("Error: While Assignign Agents .... @"+getDate());
			System.out.println("Error: While Assignign Agents .... @"+getDate());
		}
		
	}
	
	public void changeDialPlan() throws Exception {
		
		try{
			writeText("Changing Dial Plan .... @"+getDate());
			System.out.println("Changing Dial Plan .... @"+getDate());
			
			driver.findElement(By.linkText("Dial Plan")).click();
			driver.findElement(By.linkText("View")).click();
			driver.findElement(By.xpath("//a[contains(text(),'Edit')]")).click();
				if( driver.findElement(By.cssSelector("input[type=\"checkbox\"]")).isSelected()){
					driver.findElement(By.cssSelector("input[type=\"checkbox\"]")).click();
					driver.findElement(By.id("dialplan.label.schedule.rules")).click();
					driver.findElement(By.xpath("//input[@id='dialplan.label.save']")).click(); 
					
				}
				else{
					writeText("Dial Plan already updated.... @"+getDate());
					System.out.println("Dial Plan already updated .... @"+getDate());
				}
	}
		
		catch(Exception e){
			captureScreen("changeDialPlan_error"+randoms);
			writeText("Changing Dial Plan .... @"+getDate());
			System.out.println("Changing Dial Plan .... @"+getDate());
		}
	
	}
	
	

}

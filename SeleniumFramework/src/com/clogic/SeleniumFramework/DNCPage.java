package com.clogic.SeleniumFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DNCPage extends BasicSetUp{
	
	protected final WebDriver driver;
	
	public DNCPage (WebDriver driver) throws Exception{		
		this.driver=driver;
	}
	
	public void gotoDNCLists() throws Exception{
				try{
					
					writeText("Navigating to DNC Lists Page...."+getDate());
					System.out.println("Navigating to DNC Lists Page...."+getDate());
					
					new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.linkText("DNC Lists")));
					driver.findElement(By.linkText("DNC Lists")).click();
				}
				catch(Exception e){
					captureScreen("gotoDNCLists_error_"+randoms);
					writeText("Error: while Navigating to DNC Lists Page...."+getDate());
					System.out.println("Error: while Navigating to DNC Lists Page...."+getDate());
				}
	}
	
	public void gotoImportDNC() throws Exception{
		try{
			
			writeText("Navigating to Import DNC Page...."+getDate());
			System.out.println("Navigating to Import DNC Page...."+getDate());
			
			new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Import DNC")));
			driver.findElement(By.linkText("Import DNC")).click();
		}
		catch(Exception e){
			captureScreen("gotoImportDNC_error_"+randoms);
			writeText("Error: while Navigating to Import DNC Page...."+getDate());
			System.out.println("Error: while Navigating to Import DNC Page...."+getDate());
		}
	}
	
	public void gotoView() throws Exception{
		try{
			
			writeText("Navigating to DNC View Page...."+getDate());
			System.out.println("Navigating to DNC View Page...."+getDate());
			
			new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.linkText("View")));
			driver.findElement(By.linkText("View")).click();
		}
		catch(Exception e){
			captureScreen("gotoView_error_"+randoms);
			writeText("Error: while Navigating to DNC View Page...."+getDate());
			System.out.println("Error: while Navigating to DNC View Page...."+getDate());
		}
	}
	
	public void addNewDNCList(String listname) throws Exception{
		try{
			writeText("Adding new DNC List...."+getDate());
			System.out.println("Adding new DNC List...."+getDate());
			driver.findElement(By.cssSelector("input.but-gray")).click();
			driver.findElement(By.id("list_name")).sendKeys(listname);
			driver.findElement(By.xpath("//input[@value='Add List']")).click();
		}
		catch(Exception e){
			captureScreen("addNewDNCList_error_"+randoms);
			writeText("Error: While Adding new DNC List...."+getDate());
			System.out.println("Error: While Adding new DNC List...."+getDate());
		}
	}
	
	public void addNewDNCList(String listname, String crmField ) throws Exception{
		try{
			writeText("Adding new DNC List...."+getDate());
			System.out.println("Adding new DNC List...."+getDate());
			driver.findElement(By.cssSelector("input.but-gray")).click();
			driver.findElement(By.id("list_name")).sendKeys(listname);
			driver.findElement(By.id("dncType_field")).click();
			new Select(driver.findElement(By.id("phone_fields"))).selectByVisibleText(crmField);
			driver.findElement(By.xpath("//input[@value='Add List']")).click();
		}
		catch(Exception e){
			captureScreen("addNewDNCList_error_"+randoms);
			writeText("Error: While Adding new DNC List...."+getDate());
			System.out.println("Error: While Adding new DNC List...."+getDate());
		}
	}
	
	public void addNewDNCList(String listname, String crmField, int projectId) throws Exception{
		try{
			writeText("Adding new DNC List...."+getDate());
			System.out.println("Adding new DNC List...."+getDate());
			driver.findElement(By.cssSelector("input.but-gray")).click();
			driver.findElement(By.id("list_name")).sendKeys(listname);
			driver.findElement(By.id("dncType_field")).click();
			new Select(driver.findElement(By.id("phone_fields"))).selectByVisibleText(crmField);
			driver.findElement(By.id("applyOnProjects")).click();
			driver.findElement(By.xpath("//div[@id='available_"+projectId+"']/img")).click();
			driver.findElement(By.xpath("//input[@value='Add List']")).click();
		}
		catch(Exception e){
			captureScreen("addNewDNCList_error_"+randoms);
			writeText("Error: While Adding new DNC List...."+getDate());
			System.out.println("Error: While Adding new DNC List...."+getDate());
		}
	}
	
	public void addNewDNCList(String listname, int projectId) throws Exception{
		try{
			writeText("Adding new DNC List...."+getDate());
			System.out.println("Adding new DNC List...."+getDate());
			driver.findElement(By.cssSelector("input.but-gray")).click();
			driver.findElement(By.id("list_name")).sendKeys(listname);
			driver.findElement(By.id("applyOnProjects")).click();
			driver.findElement(By.xpath("//div[@id='available_"+projectId+"']/img")).click();
			driver.findElement(By.xpath("//input[@value='Add List']")).click();
		}
		catch(Exception e){	
			captureScreen("addNewDNCList_error_"+randoms);
			writeText("Error: While Adding new DNC List...."+getDate());
			System.out.println("Error: While Adding new DNC List...."+getDate());
		}
	}
	
	public void importDNC(String listName, String path) throws Exception {
		try{
			writeText("Importing DNC List...."+getDate());
			System.out.println("Importing DNC List...."+getDate());
			new Select(driver.findElement(By.id("dnc_lists"))).selectByVisibleText(listName);
			driver.findElement(By.id("file")).clear();
			driver.findElement(By.id("file")).sendKeys(path);
			driver.findElement(By.id("buttonUpload")).click();
		}
		catch(Exception e){	
			captureScreen("importDNC_error_"+randoms);
			writeText("Error: While Importing DNC List...."+getDate());
			System.out.println("Error: While Importing DNC List...."+getDate());
		}
	}
	
	public void importDNC(String listName, int number) throws Exception {
		try{
			writeText("Importing DNC List...."+getDate());
			System.out.println("Importing DNC List...."+getDate());
			new Select(driver.findElement(By.id("dnc_lists"))).selectByVisibleText(listName);
			driver.findElement(By.id("source_numbers")).click();
			driver.findElement(By.id("numbers")).clear();
			driver.findElement(By.id("numbers")).sendKeys(new Integer(number).toString());
			driver.findElement(By.id("buttonUpload")).click();
		}
		catch(Exception e){	
			captureScreen("importDNC_error_"+randoms);
			writeText("Error: While Importing DNC List...."+getDate());
			System.out.println("Error: While Importing DNC List...."+getDate());
		}
	}
	
	public void deleteDNCList() throws Exception{
		try{
			writeText("Deleting DNC List...."+getDate());
			System.out.println("Deleting DNC List...."+getDate());
			driver.findElement(By.xpath("//input[@value='Delete']")).click();
			driver.findElement(By.id("alert_yes")).click(); 
			}
			catch(Exception e){
				captureScreen("deleteDNCList_error_"+randoms);
				writeText("Error: While Deleting DNC List...."+getDate());
				System.out.println("Error: While Deleting DNC List...."+getDate());
			}
			
	}
	
	
		

}

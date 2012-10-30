package com.clogic.SeleniumFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

}

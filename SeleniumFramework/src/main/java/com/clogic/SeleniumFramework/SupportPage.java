package com.clogic.SeleniumFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SupportPage extends BasicSetUp{
	
	protected final WebDriver driver;
	
	public SupportPage (WebDriver driver) throws Exception{		
		this.driver=driver;
	}
	
	public void gotoDownloadClient() throws Exception{
		
		try{
			
			writeText("Navigating to Download Client Page...."+getDate());
			System.out.println("Navigating to Download Client Page...."+getDate());
			
			new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Download Client")));
			driver.findElement(By.linkText("Download Client")).click();
		}
		catch(Exception e){
			captureScreen("gotoDownloadClient_error_"+randoms);
			writeText("Error: while Navigating to Download Client Page...."+getDate());
			System.out.println("Error: while Navigating to Download Client Page...."+getDate());
		}
		
	}
	
	public void gotoReportTroubleTicket() throws Exception{
		try{
			
			writeText("Navigating to Report Trouble Ticket Page...."+getDate());
			System.out.println("Navigating to Report Trouble Ticket Page...."+getDate());
			
			new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Report Trouble Ticket")));
			driver.findElement(By.linkText("Report Trouble Ticket")).click();
		}
		catch(Exception e){
			captureScreen("gotoTroubleTicket_error_"+randoms);
			writeText("Error: While Navigating to Report Trouble Ticket Page...."+getDate());
			System.out.println("Error: While Navigating to Report Trouble Ticket Page...."+getDate());
		}
	}
	
	public void gotoFaqPage() throws Exception {
		try{
			
			writeText("Navigating to FAQ Page...."+getDate());
			System.out.println("Navigating to FAQ Page...."+getDate());
			
			new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.linkText("FAQ")));
			driver.findElement(By.linkText("FAQ")).click();
		}
		catch(Exception e){
			captureScreen("gotoFaqPage_error_"+randoms);
			writeText("Error: While Navigating to FAQ Page...."+getDate());
			System.out.println("Error: While Navigating to FAQ Page...."+getDate());
		}
	}
	
	public void gotoBlogPage() throws Exception{
		try{
			
			writeText("Navigating to Blog Page...."+getDate());
			System.out.println("Navigating to Blog Page...."+getDate());
			
			new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Blog")));
			driver.findElement(By.linkText("Blog")).click();
		}
		catch(Exception e){
			captureScreen("gotoBlogPage_error_"+randoms);
			writeText("Error: While Navigating to Blog Page...."+getDate());
			System.out.println("Error: While Navigating to Blog Page...."+getDate());
		}
	}
	
	
	public void gotoForumPage() throws Exception{
		try{
			
			writeText("Navigating to Forum Page...."+getDate());
			System.out.println("Navigating to Forum Page...."+getDate());
			
			new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Forum")));
			driver.findElement(By.linkText("Forum")).click();
		}
		
		catch(Exception e){
			captureScreen("gotoForumPage_error_"+randoms);
			writeText("Error: While Navigating to Forum Page...."+getDate());
			System.out.println("Error: While Navigating to Forum Page...."+getDate());
		}
	}
	

}

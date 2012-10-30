package com.clogic.SeleniumFramework;


import org.testng.annotations.*;
import org.testng.Assert;
import java.text.*;
import java.io.*;

import java.util.*;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;


import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.BrowserVersion;

/**
 * Basic SetUp Class includes function required to
 * initiate a test.
 */



public class BasicSetUp {
	
	public WebElement webElement;
	//The driver.
	public static WebDriver driver;	
	public static WebDriverBackedSelenium selenium;
	
	public WebDriverWait wait; 
	
	// A String which stores a random number in string format.
	protected static String randoms = random();
	
	/** Object which contains Strings of Error.
	 * */
	protected StringBuffer verificationErrors = new StringBuffer();
	
	
	
	/** Function which sets up browser and defines base url on starting of each test.
	 * @throws Exception 
	 */
	
	@BeforeSuite (alwaysRun = true)
	public void setUp() throws Exception { 
		
		driver= new FirefoxDriver();			
		selenium =new WebDriverBackedSelenium(driver, "");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		startTest();
	}
	
	
	
	/**
	 * WriteText is a function to write logs.
	 * 
	 *
	 * @param String
	 */
	public static void writeText(String s){
		FileWriter fWriter = null;
		BufferedWriter writer = null;		
			try {
					fWriter = new FileWriter("TestLogs-"+randoms+".txt", true);
					writer = new BufferedWriter(fWriter);
					writer.append(s);
					writer.newLine();
					writer.close();
					
			} catch (Exception e) {
			}
		}
	
	/**
	 * Generates implicit wait to poll the DOM for a certain amount
	 * of time when driver when trying to find an element or elements if they 
	 * are not immediately available.
	 *
	 * @param Time in seconds.
	 */
	public static void waitBetween(int time){
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	/**
	 
	 * @return Current date and time
	 */
	public static String getDate(){
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		   //get current date time with Date()
		   Date date = new Date();
		    return dateFormat.format(date);
	}
	
	/**
	 
	 * @return String of random integer.
	 */
	public static String random(){
		Integer d = Integer.valueOf((int) (Math.random() *10000));
		return Integer.toString( d);
	}
	
	
	/**
	 * Capture screen while error has occurred.
	 *
	 * @param  File name of Image
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void captureScreen(String err) throws IOException {
		WebDriver augmentedDriver = new Augmenter().augment(driver);
      File scrFile = ((TakesScreenshot)augmentedDriver).
                          getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(scrFile, new File("c:\\tmp\\"+err+".png"));
	}
	
	/**
	 * Initial of logs in starting of each test.
	 */
	public static void startTest(){
		writeText("==========================================");
		writeText("Test Started @ " + getDate());
		
		System.out.println("==========================================");
		System.out.println("Test Started @ " + getDate());
		
	}
	
	
	public void signOut() throws Exception{
		try{
			writeText("Signing out... @"+getDate());
			System.out.println("Signing out... @"+getDate());
			driver.findElement(By.linkText("Signout")).click();
			waitBetween(10);
			
		}
		
		catch(Exception e){
			captureScreen("signout_error");
			writeText("Error: While attempting Signout @" + getDate());
			System.out.println("Error: While attempting Signout @" + getDate());
		}
	}
	
	

	/**
	 * Checks if is element present.
	 *
	 * @param By object containing identifier for a element.
	 * @return true, if element is present
	 * 			false, if element is not present
	 */
	public static boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} 
		catch (Exception e) {
			return false;
		}
	}
	
	
	public void captureSuccessMessage() throws Exception{
		try{
			sleep(3);
			writeText(driver.findElement(By.cssSelector("div.bottom-message > div.message-box.displayreport > span.message-text")).getText().toString());
			System.out.println(driver.findElement(By.cssSelector("div.bottom-message > div.message-box.displayreport > span.message-text")).getText().toString());
		}
		catch(NoSuchElementException e){
			writeText("Success Message Not Found! ");
			System.out.println("Success Message Not Found! ");
		}
	}
	
	/**
	 * Tear down at the end.
	 *
	 * @throws Exception 
	 */
	@AfterSuite (alwaysRun = true)
	public void tearDown() throws Exception {
		System.out.println("Test completed @ "+getDate());
		System.out.println("==========================================");
		writeText("Test completed @ "+getDate());
		writeText("==========================================");
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			Assert.fail(verificationErrorString);
		}
	}
	
	
	
	public void sleep(long time) throws InterruptedException{
		Thread.sleep(time*1000);
	}
	
	
	public void verifyElementPresent(By by, String id){
		if(isElementPresent(by)){
			 
		}
		else{			
			writeText(id + " NOT FOUND!");
			System.out.println(id + " NOT FOUND!");
		}
	}
	
	public void verifyTextpresent(By by, String s){
		if(isElementPresent(by)){
			
			if(driver.findElement(by).getText().toString().equals(s)){
				writeText(s + " FOUND!");
				System.out.println(s + " FOUND!");
			}
			else{
				writeText(s + " Not FOUND!");
				System.out.println(s + " Not FOUND!");
			}
		}
		else{
			writeText(s + " Not FOUND!");
			System.out.println(s + " Not FOUND!");
		}
	}
	
	public void verifyTrue(boolean condition, String errorMessage) throws Exception{
		boolean result = condition;
		if(!result){
			captureScreen("verification_error"+randoms);
			writeText(errorMessage+"....@ "+ getDate());
			System.out.println(errorMessage+"....@ "+ getDate());
		}
	}
	
	
	public void isTextPresent(String text ){  
		 boolean result = selenium.isTextPresent(text);  
		if(result == true){ 
			writeText(text + " FOUND!");
			System.out.println(text + " FOUND!");
			
		}
		else{
			writeText(text + " NOT FOUND!");
			System.out.println(text + " NOT FOUND!");
		}
	}
	
	public  String[] readText(String fileName) { 
		 ArrayList<String> list = new ArrayList<String>();
		 String[] rolesList = null;
		 try{ 
			 FileInputStream fstream = new FileInputStream(fileName);
			 DataInputStream in = new DataInputStream(fstream);
			 BufferedReader br = new BufferedReader(new InputStreamReader(in));
			 String strLine; 
			while ((strLine = br.readLine()) != null)   {  
				list.add(strLine);
				}  
			rolesList= list.get(0).split(",");
			
			in.close();
			writeText(fileName+ " read successfully.... @" + getDate());
			System.out.println(fileName+ " read successfully.... @" + getDate());
			return rolesList;
			}
		 catch (Exception e){ 
				writeText("Error while reading "+fileName+".... @"+ getDate());
				System.out.println("Error while reading "+fileName+".... @"+ getDate());	
				System.err.println("Error: " + e.getMessage());
				return rolesList;
			} 	 
	 }
	
		/**
		 * Go to Agent Page
		 *
		 * @return  
		 * @throws Exception 
		 */	
	
		public AgentPage gotoAgentPage() throws Exception{
			
			try{
			
				writeText("Moving to Agent Page.... @"+getDate());
				System.out.println("Moving to Agent Page.... @"+getDate());
				
				driver.findElement(By.id("menu_members"));
				driver.findElement(By.id("menu_members")).click();
				waitBetween(20);
				return new AgentPage(driver);
			}
			catch(Exception e){
				captureScreen("agentpage_error");
				System.out.println("Error: While Moving to Agent Page.... @ "+ getDate());
				writeText("Error: While Moving to Agent Page.... @ "+ getDate());
				return new AgentPage(driver);
			}
		}

		/**
		 * Go to CCHomePage
		 *
		 * @return  
		 * @throws Exception 
		 */
		public CCHomePage gotoCCHomePage() throws Exception{
			try{
				writeText("Navigating to CCHomePage.... @ "+ getDate());
				System.out.println("Navigating to CCHomePage.... @ "+ getDate());
				
				driver.findElement(By.id("menu_home")).click();
				return new CCHomePage(driver);
			}
			catch(Exception e){
				captureScreen("cchomepage_error");
				System.out.println("Error: During navigating to MyCallCenter Page @ "+ getDate());
				writeText("Error: During navigating to MyCallCenter Page @ "+ getDate());
				return new CCHomePage(driver);
			}
			
		}

		public ProjectPage gotoProjectPage() throws Exception{
			try{
				writeText("Navigating to Project Page.... @ "+ getDate());
			System.out.println("Navigating to Project Page.... @ "+ getDate());
			 
			new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.id("menu_projects")));
			driver.findElement(By.id("menu_projects")).click();
			
			return new ProjectPage(driver);
		}
		catch(Exception e){
			captureScreen("project_page_navigation_error");
			System.out.println("Error: During navigating to Project Page @ "+ getDate());
			writeText("Error: During navigating to Project Page @ "+ getDate());
			return new ProjectPage(driver);
		}
		}
	
	public CRMPage gotoCRMPage() throws Exception{
		
				try{
					writeText("Navigating to CRM Page.... @ "+ getDate());
				System.out.println("Navigating to CRM Page.... @ "+ getDate());
				 
				new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.id("menu_leads")));
				driver.findElement(By.id("menu_leads")).click();
				
				return new CRMPage(driver);
			}
			catch(Exception e){
				captureScreen("gotoCRMPage_error"+randoms);
				System.out.println("Error: During navigating to CRM Page @ "+ getDate());
				writeText("Error: During navigating to CRM Page @ "+ getDate());
				return new CRMPage(driver);
			}
	}
	
	
	public AdvancedPage gotoAdvancePage() throws Exception{
		
			try{
				writeText("Navigating to Advanced Page.... @ "+ getDate());
			System.out.println("Navigating to Advanced Page.... @ "+ getDate());
			 
			new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.id("menu_advanced")));
			driver.findElement(By.id("menu_advanced")).click();
			
			return new AdvancedPage(driver);
		}
		catch(Exception e){
			captureScreen("gotoAdvancePage_error"+randoms);
			System.out.println("Error: During navigating to Advanced Page @ "+ getDate());
			writeText("Error: During navigating to Advanced Page @ "+ getDate());
			return new AdvancedPage(driver);
		}
	}
	
	
	public DashboardPage gotoDashboardPage() throws Exception{ 
			try{
				writeText("Navigating to Dashboard Page.... @ "+ getDate());
				System.out.println("Navigating to Dashboard Page.... @ "+ getDate());
				 
				new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.id("menu_advanced")));
				driver.findElement(By.id("menu_dashboard")).click();
				
				return new DashboardPage(driver);
			}
		catch(Exception e){
				captureScreen("gotoDashboardPage_error"+randoms);
				System.out.println("Error: During navigating to Dashboard  Page @ "+ getDate());
				writeText("Error: During navigating to Dashboard  Page @ "+ getDate());
				return new DashboardPage(driver);
			}
	}
	
	public DNCPage gotoDNCPage() throws Exception{
		try{
			writeText("Navigating to DNC Page.... @ "+ getDate());
			System.out.println("Navigating to DNC Page.... @ "+ getDate());
			 
			new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.id("menu_advanced")));
			driver.findElement(By.id("menu_dnc")).click();
			
			return new DNCPage(driver);
		}
		catch(Exception e){
			captureScreen("gotoDashboardPage_error"+randoms);
			System.out.println("Error: During navigating to DNC  Page @ "+ getDate());
			writeText("Error: During navigating to DNC  Page @ "+ getDate());
			return new DNCPage(driver);
		}
	}
	
	
	public SupportPage gotoSupportPage() throws Exception{
		try{
			writeText("Navigating to Support Page.... @ "+ getDate());
			System.out.println("Navigating to Support Page.... @ "+ getDate());
			 
			new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.id("menu_advanced")));
			driver.findElement(By.id("menu_download")).click();
			
			return new SupportPage(driver);
		}
		catch(Exception e){
			captureScreen("gotoSupportPage_error"+randoms);
			System.out.println("Error: During navigating to Support  Page @ "+ getDate());
			writeText("Error: During navigating to Support  Page @ "+ getDate());
			return new SupportPage(driver);
		}
		
	}
		
	 
	public ServiceNodesPage gotoServiceNodesPage() throws Exception{
		try{
			writeText("Navigating to Service Nodes Page.... @ "+ getDate());
			System.out.println("Navigating to Service Nodes Page.... @ "+ getDate());
			 
			new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.id("menu_advanced")));
			driver.findElement(By.id("menu_servicenodes")).click();
			
			return new ServiceNodesPage(driver);
		}
		catch(Exception e){
			captureScreen("gotoServiceNodesPage_error"+randoms);
			System.out.println("Error: During navigating to Service Nodes Page @ "+ getDate());
			writeText("Error: During navigating to Service Nodes  Page @ "+ getDate());
			return new ServiceNodesPage(driver);
		}
	}


}

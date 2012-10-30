package com.clogic.SeleniumFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
 

public class CRMPage extends BasicSetUp{
	
	
protected final WebDriver driver;
	
	public CRMPage(WebDriver driver ) throws Exception{
		this.driver=driver;
	}
	
	
	public void assignAllLeads(String projName) throws Exception{
		 
		try{
			writeText("Step 1 while Assinging all available leads in "+projName+".... @"+getDate());
			System.out.println("Step 1 while Assinging all available leads in "+projName+".... @"+getDate());
			
				driver.findElement(By.linkText("Assign Leads")).click();
				new Select(driver.findElement(By.id("campaigns"))).selectByVisibleText(projName);
				
				driver.findElement(By.id("assignavailableleads.input.next")).click(); 
				
				try{		
					
					writeText("Step 2 while Assinging all available leads in "+projName+".... @"+getDate());
					System.out.println("Step 2 while Assinging all available leads in "+projName+".... @"+getDate());
					
				
		//			driver.findElement(By.id("cboxAll")).click();
					driver.findElement(By.id("selectall_label")).click();
					driver.findElement(By.id("assignavailableleads.input.next2")).click();
					
					writeText("Step 3 while Assinging all available leads in "+projName+".... @"+getDate());
					System.out.println("Step 3 while Assinging all available leads in "+projName+".... @"+getDate());
					driver.findElement(By.id("assignavailableleads.input.next4")).click();
					
					writeText("Step 4 while Assinging all available leads in "+projName+".... @"+getDate());
					System.out.println("Step 4 while Assinging all available leads in "+projName+".... @"+getDate());
					
					driver.findElement(By.id("scrubleads.input.next")).click();
					
					new WebDriverWait(driver, 1000).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.bottom-message > div.message-box.displayreport > span.message-text")));	
					if(isElementPresent(By.cssSelector("div.bottom-message > div.message-box.displayreport > span.message-text"))){
					writeText(driver.findElement(By.cssSelector("div.bottom-message > div.message-box.displayreport > span.message-text")).getText().toString() +".... @"+getDate());
					System.out.println(driver.findElement(By.cssSelector("div.bottom-message > div.message-box.displayreport > span.message-text")).getText().toString() +".... @"+getDate());
					}
			}
				
				catch(Exception e){
					driver.findElement(By.cssSelector("#leadData > tr > td"));
					writeText("No lead available to assign in "+projName+".... @"+getDate());
					System.out.println("No lead available to asssign in "+projName+".... @"+getDate());
				}
		}
		
		catch(Exception e){
			
			captureScreen("assignAllLeads"+randoms);
			writeText("Error: While Assinging all available leads in "+projName+".... @"+getDate());
			System.out.println("Error: While Assinging all available leads in "+projName+".... @"+getDate());
		}
		
	}
	
	
	public void importLeads(String path) throws Exception{
		try{
			writeText("Importing Leads.... @"+getDate());
			System.out.println("Importing Leads.... @"+getDate());
			driver.findElement(By.cssSelector(("#file")));
			webElement = driver.findElement(By.cssSelector(("#file"))); 
			webElement.sendKeys(path); 
			driver.findElement(By.id("buttonUpload")).click();
			new WebDriverWait(driver, 1000).until(ExpectedConditions.presenceOfElementLocated(By.id("auto_map")));
			driver.findElement(By.id("auto_map")).click();
			driver.findElement(By.id("importleads.input.next")).click();
			driver.findElement(By.id("alert_yes")).click();
			driver.findElement(By.id("multiCountR")).click();
			driver.findElement(By.xpath("(//input[@id='importleads.input.next'])[3]")).click();
			driver.findElement(By.xpath("(//input[@id='importleads.input.next'])[2]")).click();
			driver.findElement(By.id("scrubleads.input.next")).click();
			driver.findElement(By.xpath("(//input[@id='importleads.input.next'])[5]")).click();
			driver.findElement(By.id("importleads.input.done")).click();
			
		}
		catch(Exception e){
			captureScreen("importLeads_error"+randoms);
			writeText("Error: While Importing Leads.... @"+getDate());
			System.out.println("Error: While Importing Leads.... @"+getDate());
		}
	}
	
	
	public void searchLeadByName(String firstName) throws Exception{
		try{
			
			writeText("Searching "+firstName+"...."+getDate());
			System.out.println("Searching "+firstName+"...."+getDate());
			new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("filter-toggle")));
			if(isElementPresent(By.id("generated_filter_0"))){
				driver.findElement(By.id("generated_filter_0")).clear();
				driver.findElement(By.id("generated_filter_0")).sendKeys(firstName);
				driver.findElement(By.id("manageccleads.input.filter")).click();
			}
			else{
				driver.findElement(By.id("filter-toggle")).click();
				driver.findElement(By.xpath("(//a[contains(text(),'Add')])[2]")).click();
				driver.findElement(By.cssSelector("span.ui-icon.ui-icon-closethick")).click();
				driver.findElement(By.id("generated_filter_0")).clear();
				driver.findElement(By.id("generated_filter_0")).sendKeys(firstName);
				driver.findElement(By.id("manageccleads.input.filter")).click();
			}
		}
		catch(Exception e){
			captureScreen("searchLeadByName_error_"+randoms);
			writeText("Error: While Searching "+firstName+"...."+getDate());
			System.out.println("Error: While Searching "+firstName+"...."+getDate());
		}
	}
	
	
	public void bulkupdate(String path) throws Exception{
		try{
			
			writeText("Bulk Updating...."+getDate());
			System.out.println("Bulk Updating...."+getDate());
			new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("file")));
			
			driver.findElement(By.id("file")).sendKeys(path);
			driver.findElement(By.id("buttonUpload")).click();
			driver.findElement(By.id("auto_map")).click();
			driver.findElement(By.name("input_key")).click();
			driver.findElement(By.id("importmodifiedleads.input.next")).click();
			driver.findElement(By.id("valueCheckBox1")).click();
			driver.findElement(By.xpath("(//input[@id='importmodifiedleads.input.next'])[2]")).click();
			driver.findElement(By.id("alert_yes")).click();
			driver.findElement(By.id("importmodifiedleads.input.done")).click();
			
		}
		catch(Exception e){
			captureScreen("bulkupdate_error_"+randoms);
			writeText("Error: While Bulk Updating...."+getDate());
			System.out.println("Error: While Bulk Updating...."+getDate());
		}
	}
	
	public void addLead(String firstName, String secondName, String prefix, int mobilePhone, int homePhone, int workPhone, String email, String street, String street1, String street2, String city, String state, String postal, String country, String website, String company, int employees, String revenue, String industry,String requirement, String timeZone, String language, String list ) throws Exception{
		try{
			
			writeText("Adding Lead...."+getDate());
			System.out.println("Adding Lead...."+getDate());
			new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("leaddetail_field1")));
			driver.findElement(By.id("leaddetail_field1")).clear();
			driver.findElement(By.id("leaddetail_field1")).sendKeys(firstName);
			driver.findElement(By.id("leaddetail_field2")).clear();
			driver.findElement(By.id("leaddetail_field2")).sendKeys(secondName);
			driver.findElement(By.id("leaddetail_field9")).clear();
			driver.findElement(By.id("leaddetail_field9")).sendKeys(prefix);
			
			driver.findElement(By.id("leaddetail_field4")).clear();
			driver.findElement(By.id("leaddetail_field4")).sendKeys(new Integer(mobilePhone).toString());
			driver.findElement(By.id("leaddetail_field6")).clear();
			driver.findElement(By.id("leaddetail_field6")).sendKeys(new Integer(homePhone).toString());
			driver.findElement(By.id("leaddetail_field8")).clear();
			driver.findElement(By.id("leaddetail_field8")).sendKeys(new Integer(workPhone).toString());
			driver.findElement(By.id("leaddetail_field10")).clear();
			driver.findElement(By.id("leaddetail_field10")).sendKeys(email);
			driver.findElement(By.id("leaddetail_field12")).clear();
			driver.findElement(By.id("leaddetail_field12")).sendKeys(street);
			driver.findElement(By.id("leaddetail_field13")).clear();
			driver.findElement(By.id("leaddetail_field13")).sendKeys(street1);
			driver.findElement(By.id("leaddetail_field14")).clear();
			driver.findElement(By.id("leaddetail_field14")).sendKeys(street2);
			driver.findElement(By.id("leaddetail_field15")).clear();
			driver.findElement(By.id("leaddetail_field15")).sendKeys(city);
			driver.findElement(By.id("leaddetail_field16")).clear();
			driver.findElement(By.id("leaddetail_field16")).sendKeys(state);
			driver.findElement(By.id("leaddetail_field17")).clear();
			driver.findElement(By.id("leaddetail_field17")).sendKeys(postal);
			new Select(driver.findElement(By.id("leaddetail_field18"))).selectByVisibleText(country);
			driver.findElement(By.id("leaddetail_field19")).clear();
			driver.findElement(By.id("leaddetail_field19")).sendKeys(website);
			driver.findElement(By.id("leaddetail_field20")).clear();
			driver.findElement(By.id("leaddetail_field20")).sendKeys(company);
			driver.findElement(By.id("leaddetail_field21")).clear();
			driver.findElement(By.id("leaddetail_field21")).sendKeys(new Integer(employees).toString());
			driver.findElement(By.id("leaddetail_field22")).clear();
			driver.findElement(By.id("leaddetail_field22")).sendKeys(revenue);
			driver.findElement(By.id("leaddetail_field23")).clear();
			driver.findElement(By.id("leaddetail_field23")).sendKeys(industry);
			driver.findElement(By.id("leaddetail_field24")).clear();
			driver.findElement(By.id("leaddetail_field24")).sendKeys(requirement);
			new Select(driver.findElement(By.id("leaddetail_olsentimezone"))).selectByVisibleText(timeZone);
			new Select(driver.findElement(By.id("leaddetail_field11"))).selectByVisibleText(language);
//			new Select(driver.findElement(By.id("applyTag_newlead"))).selectByVisibleText(list);
			driver.findElement(By.id("addprofile")).click();
			
		}
		catch(Exception e){
			captureScreen("addLead_error_"+randoms);
			writeText("Error: While Adding Lead...."+getDate());
			System.out.println("Error: While Adding Lead...."+getDate());
		}
		
	}
	
	
	public void scrubLeads(String projectName) throws Exception{
		try{
			
			writeText("Scrubbing Leads...."+getDate());
			System.out.println("Scrubbing Leads...."+getDate());
			
			new WebDriverWait(driver, 60).until(ExpectedConditions.presenceOfElementLocated(By.id("projects")));
			new Select(driver.findElement(By.id("projects"))).selectByVisibleText(projectName);
			driver.findElement(By.id("scrubleads.input.next")).click();
			driver.findElement(By.id("chk_field1")).click();
			driver.findElement(By.xpath("(//input[@id='scrubleads.input.next'])[2]")).click();
			driver.findElement(By.xpath("(//input[@id='scrubleads.input.next'])[3]")).click();
		}
		catch(Exception e){
			captureScreen("scrubLeads_error_"+randoms);
			writeText("Error: while Scrubbing Leads...."+getDate());
			System.out.println("Error: while Scrubbing Leads...."+getDate());
		}
	}
	
	public void addLeadList(String listName) throws Exception{
		try{
			
			writeText("Adding new lead list...."+getDate());
			System.out.println("Adding new lead list...."+getDate());
			
			new WebDriverWait(driver, 60).until(ExpectedConditions.presenceOfElementLocated(By.id("new_btn")));
			driver.findElement(By.id("new_btn")).click();
			driver.findElement(By.id("newTagName")).clear();
			driver.findElement(By.id("newTagName")).sendKeys(listName);
			driver.findElement(By.id("leadtags.input.ok2")).click();
		}
		catch(Exception e){
			captureScreen("addLeadList_error_"+randoms);
			writeText("Error: while Adding new lead list...."+getDate());
			System.out.println("Error: while Adding new lead list...."+getDate());
		}
	}
	
	public void addCrmField(String fieldName, String type) throws Exception{
		try{
			
			writeText("Adding new CRM Field...."+getDate());
			System.out.println("Adding new CRM Field...."+getDate());
			
			new WebDriverWait(driver, 60).until(ExpectedConditions.presenceOfElementLocated(By.id("custom_fields_input_add_new_fields")));
			driver.findElement(By.id("custom_fields_input_add_new_fields")).click();
			driver.findElement(By.id("name")).clear();
			driver.findElement(By.id("name")).sendKeys(fieldName);
			new Select(driver.findElement(By.id("custom_type"))).selectByVisibleText(type);
			driver.findElement(By.id("issearchable")).click();
			driver.findElement(By.id("custom_fields.input.add_custom_fields2")).click();
		}
		catch(Exception e){
			captureScreen("addCrmField_error_"+randoms);
			writeText("Error: while Adding new CRM Field...."+getDate());
			System.out.println("Error: while Adding new CRM Field...."+getDate());
		}
	}
	
	public void gotoView() throws Exception{
		try{
			
			writeText("Navigating to View Page...."+getDate());
			System.out.println("Navigating to View Page...."+getDate());
			
			new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.linkText("View")));
			driver.findElement(By.linkText("View")).click();
		}
		catch(Exception e){
			captureScreen("gotoDownloadClient_error_"+randoms);
			writeText("Error: while Navigating to View Page...."+getDate());
			System.out.println("Error: while Navigating to View Page...."+getDate());
		}
	}
	
	public void gotoImportLeads() throws Exception{
		try{
			
			writeText("Navigating to Import Leads Page...."+getDate());
			System.out.println("Navigating to Import Leads Page...."+getDate());
			
			new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Import Leads")));
			driver.findElement(By.linkText("Import Leads")).click();
		}
		catch(Exception e){
			captureScreen("gotoImportLeads_error_"+randoms);
			writeText("Error: while Navigating to Import Leads Page...."+getDate());
			System.out.println("Error: while Navigating to Import Leads Page...."+getDate());
		}
	}
	
	public void gotoBulkUpdate() throws Exception{
		try{
			
			writeText("Navigating to Bulk Update Page...."+getDate());
			System.out.println("Navigating to Bulk Update Page...."+getDate());
			
			new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Bulk Update")));
			driver.findElement(By.linkText("Bulk Update")).click();
		}
		catch(Exception e){
			captureScreen("gotoBulkUpdate_error_"+randoms);
			writeText("Error: while Navigating to Bulk Update Page...."+getDate());
			System.out.println("Error: while Navigating to Bulk Update Page...."+getDate());
		} 
	}
	
	public void gotoAddLead() throws Exception{
		try{
			
			writeText("Navigating to Add Lead Page...."+getDate());
			System.out.println("Navigating to Add Lead Page...."+getDate());
			
			new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Add Lead")));
			driver.findElement(By.linkText("Add Lead")).click();
		}
		catch(Exception e){
			captureScreen("gotoAddLead_error_"+randoms);
			writeText("Error: while Navigating to Add Lead Page...."+getDate());
			System.out.println("Error: while Navigating to Add Lead Page...."+getDate());
		} 
	}
	
	public void gotoScrubLeads() throws Exception{
		try{
			
			writeText("Navigating to Scrub Leads Page...."+getDate());
			System.out.println("Navigating to Scrub Leads Page...."+getDate());
			
			new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Scrub Leads")));
			driver.findElement(By.linkText("Scrub Leads")).click();
		}
		catch(Exception e){
			captureScreen("gotoScrubLeads_error_"+randoms);
			writeText("Error: while Navigating to Scrub Leads Page...."+getDate());
			System.out.println("Error: while Navigating to Scrub Leads Page...."+getDate());
		} 
	}
	
	public void gotoAssignLeads() throws Exception{
		try{
			
			writeText("Navigating to Assign Leads Page...."+getDate());
			System.out.println("Navigating to Assign Leads Page...."+getDate());
			
			new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Assign Leads")));
			driver.findElement(By.linkText("Assign Leads")).click();
		}
		catch(Exception e){
			captureScreen("gotoAssignLeads_error_"+randoms);
			writeText("Error: while Navigating to Assign Leads Page...."+getDate());
			System.out.println("Error: while Navigating to Assign Leads Page...."+getDate());
		} 
	}
	
	public void gotoLeadLists() throws Exception{
		try{
			
			writeText("Navigating to Lead Lists Page...."+getDate());
			System.out.println("Navigating to Lead Lists Page...."+getDate());
			
			new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Lead Lists")));
			driver.findElement(By.linkText("Lead Lists")).click();
		}
		catch(Exception e){
			captureScreen("gotoLeadLists_error_"+randoms);
			writeText("Error: while Navigating to Lead Lists Page...."+getDate());
			System.out.println("Error: while Navigating to Lead Lists Page...."+getDate());
		} 
	}
	
	public void gotoCRMFields() throws Exception{
		try{
			
			writeText("Navigating to CRM Fields Page...."+getDate());
			System.out.println("Navigating to CRM Fields Page...."+getDate());
			
			new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.linkText("CRM Fields")));
			driver.findElement(By.linkText("CRM Fields")).click();
		}
		catch(Exception e){
			captureScreen("gotoCRMFields_error_"+randoms);
			writeText("Error: while Navigating to CRM Fields Page...."+getDate());
			System.out.println("Error: while Navigating to CRM Fields Page...."+getDate());
		} 
	}
	
	public void gotoCRMFieldGroups() throws Exception{
		try{
			
			writeText("Navigating to CRM Fields Groups Page...."+getDate());
			System.out.println("Navigating to CRM Fields Groups Page...."+getDate());
			
			new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.linkText("CRM Field Groups")));
			driver.findElement(By.linkText("CRM Field Groups")).click();
		}
		catch(Exception e){
			captureScreen("gotoCRMFieldGroups_error_"+randoms);
			writeText("Error: while Navigating to CRM Fields Groups Page...."+getDate());
			System.out.println("Error: while Navigating to CRM Fields Groups Page...."+getDate());
		} 
	}
	
	public void gotoImports() throws Exception{
		try{
			
			writeText("Navigating to Imports Page...."+getDate());
			System.out.println("Navigating to Imports  Page...."+getDate());
			
			new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Imports")));
			driver.findElement(By.linkText("Imports")).click();
		}
		catch(Exception e){
			captureScreen("gotoImports_error_"+randoms);
			writeText("Error: while Navigating to Imports Page...."+getDate());
			System.out.println("Error: while Navigating to Imports Page...."+getDate());
		} 
	}
	
	public void gotoExports() throws Exception{
		try{
			
			writeText("Navigating to Exports Page...."+getDate());
			System.out.println("Navigating to Exports  Page...."+getDate());
			
			new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Exports")));
			driver.findElement(By.linkText("Exports")).click();
		}
		catch(Exception e){
			captureScreen("gotoExports_error_"+randoms);
			writeText("Error: while Navigating to Exports Page...."+getDate());
			System.out.println("Error: while Navigating to Exports Page...."+getDate());
		} 
	}
	
	public void gotoDuplicateLeadSetting() throws Exception{
		try{
			
			writeText("Navigating to Duplicate Lead Setting Page...."+getDate());
			System.out.println("Navigating to Duplicate Lead Setting  Page...."+getDate());
			
			new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Duplicate Lead Settings")));
			driver.findElement(By.linkText("Duplicate Lead Settings")).click();
		}
		catch(Exception e){
			captureScreen("gotoDuplicateLeadSetting_error_"+randoms);
			writeText("Error: while Navigating to Duplicate Lead Setting Page...."+getDate());
			System.out.println("Error: while Navigating to Duplicate Lead Setting Page...."+getDate());
		} 
	}
	
	public void gotoCRMConfiguration() throws Exception{
		try{
			
			writeText("Navigating to CRM Configuration Page...."+getDate());
			System.out.println("Navigating to CRM Configuration Page...."+getDate());
			
			new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.linkText("CRM Configuration")));
			driver.findElement(By.linkText("CRM Configuration")).click();
		}
		catch(Exception e){
			captureScreen("gotoCRMConfiguration_error_"+randoms);
			writeText("Error: while Navigating to CRM Configuration Page...."+getDate());
			System.out.println("Error: while Navigating to CRM Configuration Page...."+getDate());
		} 
	}
	

}

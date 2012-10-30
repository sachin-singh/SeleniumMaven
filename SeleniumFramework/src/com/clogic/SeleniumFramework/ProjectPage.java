package com.clogic.SeleniumFramework;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProjectPage extends BasicSetUp{

	protected final WebDriver driver;
	
	public ProjectPage(WebDriver driver) throws Exception{
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
	
	public void uploadProjectTones(String path, String music) throws Exception{
		try{
			writeText("Uploading Project Tone.... @"+getDate());
			System.out.println("Uploading Project Tone.... @"+getDate());
			
			 if(music.equals("RingerMusic")){ 
					driver.findElement(By.id("RingerMusic")).sendKeys(path);
					driver.findElement(By.id("RingerUpload")).click();
			 }
			 
			 if(music.equals("ConnectMusic")){ 
				 driver.findElement(By.id("ConnectMusic")).sendKeys(path);
				 driver.findElement(By.id("ConnectUpload")).click();
			 }
			 if(music.equals("PreviewMusic")){ 
				 driver.findElement(By.id("PreviewMusic")).sendKeys(path);
				 driver.findElement(By.id("PreviewUpload")).click();
			 }
			 if(music.equals("FailedMusic")){ 
				driver.findElement(By.id("FailedMusic")).sendKeys(path);
				driver.findElement(By.id("FailedUpload")).click();
			 }
			 if(music.equals("BusyMusic")){
				 driver.findElement(By.id("BusyMusic")).sendKeys(path);
				 driver.findElement(By.id("BusyUpload")).click();
			 }
			 if(music.equals("ConnectChatMusic")){
				 driver.findElement(By.id("ConnectChatMusic")).sendKeys(path);
				 driver.findElement(By.id("ConnectChatUpload")).click();
			 }
			 if(music.equals("CallInQueueMusic")){
				 driver.findElement(By.id("CallInQueueMusic")).sendKeys(path);
				 driver.findElement(By.id("CallInQueueUpload")).click();
			 }
			 
			 driver.findElement(By.cssSelector("input.but-gray")).click();
		}
		
		catch(Exception e){
			captureScreen("uploadProjectTones_error");
			writeText("Error: While Uploading Project Tone.... @"+getDate());
			System.out.println("Error: While Uploading Project Tone.... @"+getDate());
		}
	}
	
	public void removeProjectTones(String music) throws Exception{
		try{
			writeText("Uploading Project Tone.... @"+getDate());
			System.out.println("Uploading Project Tone.... @"+getDate());
			
			 if(music.equals("RingerMusic")){ 
				 driver.findElement(By.id("RingerRemove")).click();
				 
			 }
			 
			 if(music.equals("ConnectMusic")){ 
				 driver.findElement(By.id("ConnectRemove")).click();
				 
			 }
			 if(music.equals("PreviewMusic")){ 
				 driver.findElement(By.id("PreviewRemove")).click();
				
			 }
			 if(music.equals("FailedMusic")){ 
				 driver.findElement(By.id("FailedRemove")).click();
				
			 }
			 if(music.equals("BusyMusic")){
				 driver.findElement(By.id("BusyRemove")).click();
				
			 }
			 if(music.equals("ConnectChatMusic")){
				 driver.findElement(By.id("ConnectChatRemove")).click();
				
			 }
			 if(music.equals("CallInQueueMusic")){
				 driver.findElement(By.id("CallInQueueRemove")).click();
				
			 }
			 
			 driver.findElement(By.cssSelector("input.but-gray")).click();
		}
		
		catch(Exception e){
			captureScreen("uploadProjectTones_error");
			writeText("Error: While Uploading Project Tone.... @"+getDate());
			System.out.println("Error: While Uploading Project Tone.... @"+getDate());
		}
	}
	
	public void gotoProject(String projectName) throws Exception{
		
		try{
			writeText("Moving inside "+projectName+".... @"+getDate());
			System.out.println("Moving inside "+projectName+".... @"+getDate());
			
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
			writeText("Error: While Moving inside "+projectName+".... @"+getDate());
			System.out.println("Error: While Moving inside "+projectName+".... @"+getDate());
		}
	}
	
	
	public void addCallerId(String callerId, String description) throws Exception{
		try{
			writeText("Adding CallerID.... @"+getDate());
			System.out.println("Adding CallerID.... @"+getDate()); 
			
			new WebDriverWait(driver, 60).until(ExpectedConditions.presenceOfElementLocated(By.id("add")));
			driver.findElement(By.id("add")).click();
			driver.findElement(By.id("callerid-input")).clear();
			driver.findElement(By.id("callerid-input")).sendKeys(callerId);
			driver.findElement(By.id("callerid_expression")).clear();
			driver.findElement(By.id("callerid_expression")).sendKeys(description);
			driver.findElement(By.id("save.callerid.info")).click();
		}
		
		catch(Exception e){
			captureScreen("addCalledId_error");
			writeText("Error: While Adding CallerID.... @"+getDate());
			System.out.println("Error: While Adding CallerID.... @"+getDate());
		}
	}
	
	public void assignAllAvailableAgent() throws Exception{
		
		writeText("Assigning Agents .... @"+getDate());
		System.out.println("Assigning Agents .... @"+getDate());
		
		try{
			 
			if(isElementPresent(By.xpath("//input[@value='Bulk Assign']"))){
				boolean temp = isElementPresent(By.xpath("//input[@value='Bulk Assign']")); 
				while(temp){
					driver.findElement(By.id("unassigned_select_all")).click();
					driver.findElement(By.xpath("//input[@value='Bulk Assign']")).click();
					temp= isElementPresent(By.xpath("//input[@value='Bulk Assign']"));
					
				}
			}
			else{
				if(selenium.isTextPresent("No agents exist")){
					writeText("No agent available to Assign.... @"+getDate());
					System.out.println("No agent available to Assign.... @"+getDate());
				}
			}
		}
		
		catch(Exception e){
			captureScreen("assignAllAvailableAgent_error");
			writeText("Error: While Assigning Agents .... @"+getDate());
			System.out.println("Error: While Assigning Agents .... @"+getDate());
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
	
	public void gotoProjectAgentAssignment() throws Exception{
		try{
			
			writeText("Navigating to Agent Assignment Page...."+getDate());
			System.out.println("Navigating to Agent Assignment  Page...."+getDate());
			
			new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Agent Assignment")));
			driver.findElement(By.linkText("Agent Assignment")).click();
		}
		catch(Exception e){
			captureScreen("gotoProjectAgentAssignment_error_"+randoms);
			writeText("Error: while Navigating to Agent Assignment Page...."+getDate());
			System.out.println("Error: while Navigating to Agent Assignment Page...."+getDate());
		}
	}
	
	public void gotoProjectLeads() throws Exception{
		try{
			
			writeText("Navigating to Leads Page...."+getDate());
			System.out.println("Navigating to Leads Page...."+getDate());
			
			new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Leads")));
			driver.findElement(By.linkText("Leads")).click();
		}
		catch(Exception e){
			captureScreen("gotoProjectLeads_error_"+randoms);
			writeText("Error: while Navigating to Leads Page...."+getDate());
			System.out.println("Error: while Navigating to Leads Page...."+getDate());
		}
	}
	
	public void gotoProjectCallHistory() throws Exception{
		try{
			
			writeText("Navigating to Call History Page...."+getDate());
			System.out.println("Navigating to Call History Page...."+getDate());
			
			new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Call History")));
			driver.findElement(By.linkText("Call History")).click();
		}
		catch(Exception e){
			captureScreen("gotoProjectCallHistory_error_"+randoms);
			writeText("Error: while Navigating to Call History Page...."+getDate());
			System.out.println("Error: while Navigating to Call History Page...."+getDate());
		}
	}
	
	public void gotoProjectDialPlan() throws Exception{
		try{
			
			writeText("Navigating to Dial Plan Page...."+getDate());
			System.out.println("Navigating to Dial Plan Page...."+getDate());
			
			new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Dial Plan")));
			driver.findElement(By.linkText("Dial Plan")).click();
		}
		catch(Exception e){
			captureScreen("gotoProjectDialPlan_error_"+randoms);
			writeText("Error: while Navigating to Dial Plan Page...."+getDate());
			System.out.println("Error: while Navigating to Dial Plan Page...."+getDate());
		}
	}
	
	public void gotoProjectResultCodes() throws Exception{
		try{
			
			writeText("Navigating to Result Codes Page...."+getDate());
			System.out.println("Navigating to Result Codes Page...."+getDate());
			
			new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Result Codes")));
			driver.findElement(By.linkText("Result Codes")).click();
		}
		catch(Exception e){
			captureScreen("gotoProjectResultCodes_error_"+randoms);
			writeText("Error: while Navigating to Result Codes Page...."+getDate());
			System.out.println("Error: while Navigating to Result Codes Page...."+getDate());
		}
	}
	
	public void gotoProjectLeadFlowRules() throws Exception{
		try{
			
			writeText("Navigating to Lead Flow Rules Page...."+getDate());
			System.out.println("Navigating to Lead Flow Rules Page...."+getDate());
			
			new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Lead Flow Rules")));
			driver.findElement(By.linkText("Lead Flow Rules")).click();
		}
		catch(Exception e){
			captureScreen("gotoProjectLeadFlowRules_error_"+randoms);
			writeText("Error: while Navigating to Lead Flow Rules Page...."+getDate());
			System.out.println("Error: while Navigating to Lead Flow Rules Page...."+getDate());
		}
	}
	
	public void gotoProjectScripts() throws Exception{
		try{
			
			writeText("Navigating to Scripts Page...."+getDate());
			System.out.println("Navigating to Scripts Page...."+getDate());
			
			new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Scripts")));
			driver.findElement(By.linkText("Scripts")).click();
		}
		catch(Exception e){
			captureScreen("gotoProjectScripts_error_"+randoms);
			writeText("Error: while Navigating to Scripts Page...."+getDate());
			System.out.println("Error: while Navigating to Scripts Page...."+getDate());
		}
	}
	
	public void gotoProjectCallFlow() throws Exception{
		try{
			
			writeText("Navigating to Project Call Flow Page...."+getDate());
			System.out.println("Navigating to Project Call Flow Page...."+getDate());
			
			new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Project Call Flow")));
			driver.findElement(By.linkText("Project Call Flow")).click();
		}
		catch(Exception e){
			captureScreen("gotoProjectCallFlow_error_"+randoms);
			writeText("Error: while Navigating to Project Call Flow Page...."+getDate());
			System.out.println("Error: while Navigating to Project Call Flow Page...."+getDate());
		}
	}
	
	public void gotoProjectCallPolicy() throws Exception{
		try{
			
			writeText("Navigating to Call Policy Page...."+getDate());
			System.out.println("Navigating to Call Policy Page...."+getDate());
			
			new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Call Policy")));
			driver.findElement(By.linkText("Call Policy")).click();
		}
		catch(Exception e){
			captureScreen("gotoProjectCallPolicy_error_"+randoms);
			writeText("Error: while Navigating to Call Policy Page...."+getDate());
			System.out.println("Error: while Navigating to Call Policy Page...."+getDate());
		}
	}
	
	public void gotoProjectDNC() throws Exception{
		try{
			
			writeText("Navigating to Project DNC Page...."+getDate());
			System.out.println("Navigating to Project DNC Page...."+getDate());
			
			new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Project DNC")));
			driver.findElement(By.linkText("Project DNC")).click();
		}
		catch(Exception e){
			captureScreen("gotoProjectDNC_error_"+randoms);
			writeText("Error: while Navigating to Project DNC Page...."+getDate());
			System.out.println("Error: while Navigating to Project DNC Page...."+getDate());
		}
	}
	
	public void gotoProjectAMDProfile() throws Exception{
		try{
			
			writeText("Navigating to AMD Profile Page...."+getDate());
			System.out.println("Navigating to AMD Profile Page...."+getDate());
			
			new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.linkText("AMD Profile")));
			driver.findElement(By.linkText("AMD Profile")).click();
		}
		catch(Exception e){
			captureScreen("gotoProjectAMDProfile_error_"+randoms);
			writeText("Error: while Navigating to AMD Profile Page...."+getDate());
			System.out.println("Error: while Navigating to AMD Profile Page...."+getDate());
		}
	}
	
	public void gotoProjectGeneralPolicy() throws Exception{
		try{
			
			writeText("Navigating to General Policy Page...."+getDate());
			System.out.println("Navigating to General Policy Page...."+getDate());
			
			new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.linkText("General Policy")));
			driver.findElement(By.linkText("General Policy")).click();
		}
		catch(Exception e){
			captureScreen("gotoProjectGeneralPolicy_error_"+randoms);
			writeText("Error: while Navigating to General Policy Page...."+getDate());
			System.out.println("Error: while Navigating to General Policy Page...."+getDate());
		}
	}
	
	public void gotoProjectEmailTempelates() throws Exception{
		try{
			
			writeText("Navigating to General Policy Page...."+getDate());
			System.out.println("Navigating to General Policy Page...."+getDate());
			
			new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.linkText("General Policy")));
			driver.findElement(By.linkText("General Policy")).click();
		}
		catch(Exception e){
			captureScreen("gotoProjectEmailTempelates_error_"+randoms);
			writeText("Error: while Navigating to General Policy Page...."+getDate());
			System.out.println("Error: while Navigating to General Policy Page...."+getDate());
		}
	}
	
	public void gotoProjectCallFields() throws Exception{
		try{
			
			writeText("Navigating to Call Fields Page...."+getDate());
			System.out.println("Navigating to Call Fields Page...."+getDate());
			
			new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Call Fields")));
			driver.findElement(By.linkText("Call Fields")).click();
		}
		catch(Exception e){
			captureScreen("gotoProjectCallFields_error_"+randoms);
			writeText("Error: while Navigating to Call Fields Page...."+getDate());
			System.out.println("Error: while Navigating to Call Fields Page...."+getDate());
		}
	}
	
	public void gotoProjectAssignPackages() throws Exception{
		try{
			
			writeText("Navigating to Project Assign Packages Page...."+getDate());
			System.out.println("Navigating to Project Assign Packages Page...."+getDate());
			
			new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Assign Packages")));
			driver.findElement(By.linkText("Assign Packages")).click();
		}
		catch(Exception e){
			captureScreen("gotoProjectAssignPackages_error_"+randoms);
			writeText("Error: while Navigating to Project Assign Packages Page...."+getDate());
			System.out.println("Error: while Navigating to Project Assign Packages Page...."+getDate());
		}
	}
	
	public void gotoProjectContacts() throws Exception{
		try{
			
			writeText("Navigating to Project Contacts Page...."+getDate());
			System.out.println("Navigating to Project Contacts Page...."+getDate());
			
			new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Contacts")));
			driver.findElement(By.linkText("Contacts")).click();
		}
		catch(Exception e){
			captureScreen("gotoProjectContacts_error_"+randoms);
			writeText("Error: while Navigating to Project Contacts Page...."+getDate());
			System.out.println("Error: while Navigating to Project Contacts Page...."+getDate());
		}
	}
	
	public void gotoProjectPriority() throws Exception{
		try{
			
			writeText("Navigating to Project Priority Page...."+getDate());
			System.out.println("Navigating to Project Priority Page...."+getDate());
			
			new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Contacts")));
			driver.findElement(By.linkText("Contacts")).click();
		}
		catch(Exception e){
			captureScreen("gotoProjectPriority_error_"+randoms);
			writeText("Error: while Navigating to Project Priority Page...."+getDate());
			System.out.println("Error: while Navigating to Project Priority Page...."+getDate());
		}
	}
	
	public void gotoProjectNotify() throws Exception{
		try{
			
			writeText("Navigating to Notify Page...."+getDate());
			System.out.println("Navigating to Notify Page...."+getDate());
			
			new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Notify")));
			driver.findElement(By.linkText("Notify")).click();
		}
		catch(Exception e){
			captureScreen("gotoProjectNotify_error_"+randoms);
			writeText("Error: while Navigating to Notify Page...."+getDate());
			System.out.println("Error: while Navigating to Notify Page...."+getDate());
		}
	}
	
	public void gotoProjectConfiguration() throws Exception{
		try{
			
			writeText("Navigating to Configuration Page...."+getDate());
			System.out.println("Navigating to Configuration Page...."+getDate());
			
			new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Configuration")));
			driver.findElement(By.linkText("Configuration")).click();
		}
		catch(Exception e){
			captureScreen("gotoProjectConfiguration_error_"+randoms);
			writeText("Error: while Navigating to Configuration Page...."+getDate());
			System.out.println("Error: while Navigating to Configuration Page...."+getDate());
		}
	}
	
	public void gotoProjectIVRDesigner() throws Exception{
		try{
			
			writeText("Navigating to IVR Designer Page...."+getDate());
			System.out.println("Navigating to IVR Designer Page...."+getDate());
			
			new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.linkText("IVR Designer")));
			driver.findElement(By.linkText("IVR Designer")).click();
		}
		catch(Exception e){
			captureScreen("gotoProjectIVRDesigner_error_"+randoms);
			writeText("Error: while Navigating to IVR Designer Page...."+getDate());
			System.out.println("Error: while Navigating to IVR Designer Page...."+getDate());
		}
	}
	
	public void gotoProjectSkillGroup() throws Exception{
		try{
			
			writeText("Navigating to Skill Group Page...."+getDate());
			System.out.println("Navigating to Skill Group Page...."+getDate());
			
			new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Skill Group")));
			driver.findElement(By.linkText("Skill Group")).click();
		}
		catch(Exception e){
			captureScreen("gotoProjectSkillGroup_error_"+randoms);
			writeText("Error: while Navigating to Skill Group Page...."+getDate());
			System.out.println("Error: while Navigating to Skill Group Page...."+getDate());
		}
	}
	
	public void gotoProjectCRMFieldGroups() throws Exception{
		try{
			
			writeText("Navigating to CRM Field Groups Page...."+getDate());
			System.out.println("Navigating to CRM Field Groups Page...."+getDate());
			
			new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.linkText("CRM Field Groups")));
			driver.findElement(By.linkText("CRM Field Groups")).click();
		}
		catch(Exception e){
			captureScreen("gotoProjectCRMFieldGroups_error_"+randoms);
			writeText("Error: while Navigating to CRM Field Groups Page...."+getDate());
			System.out.println("Error: while Navigating to CRM Field Groups Page...."+getDate());
		}
	}
	
	public void gotoProjectLeadAssignmentSettings() throws Exception{
		try{
			
			writeText("Navigating to Lead Assignment Settings Page...."+getDate());
			System.out.println("Navigating to Lead Assignment Settings Page...."+getDate());
			
			new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Lead Assignment Settings")));
			driver.findElement(By.linkText("Lead Assignment Settings")).click();
		}
		catch(Exception e){
			captureScreen("gotoProjectLeadAssignmentSettings_error_"+randoms);
			writeText("Error: while Navigating to Lead Assignment Settings Page...."+getDate());
			System.out.println("Error: while Navigating to Lead Assignment Settings Page...."+getDate());
		}
	}
	
	public void gotoProjectCRMConiguration() throws Exception{
		try{
			
			writeText("Navigating to CRM Configuration Page...."+getDate());
			System.out.println("Navigating to CRM Configuration Page...."+getDate());
			
			new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.linkText("CRM Configuration")));
			driver.findElement(By.linkText("CRM Configuration")).click();
		}
		catch(Exception e){
			captureScreen("gotoProjectCRMConiguration_error_"+randoms);
			writeText("Error: while Navigating to CRM Configuration Page...."+getDate());
			System.out.println("Error: while Navigating to CRM Configuration Page...."+getDate());
		}
	}
	
	public void gotoProjectProjectVariables() throws Exception{
		try{
			
			writeText("Navigating to Project Variables Page...."+getDate());
			System.out.println("Navigating to Project Variables Page...."+getDate());
			
			new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Project Variables")));
			driver.findElement(By.linkText("Project Variables")).click();
		}
		catch(Exception e){
			captureScreen("gotoProjectProjectVariables_error_"+randoms);
			writeText("Error: while Navigating to Project Variables Page...."+getDate());
			System.out.println("Error: while Navigating to Project Variables Page...."+getDate());
		}
	}
	
	public void gotoProjectProjectTones() throws Exception{
		try{
			
			writeText("Navigating to Project Tones Page...."+getDate());
			System.out.println("Navigating to Project Tones Page...."+getDate());
			
			new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Project Tones")));
			driver.findElement(By.linkText("Project Tones")).click();
		}
		catch(Exception e){
			captureScreen("gotoProjectProjectTones_error_"+randoms);
			writeText("Error: while Navigating to Project Tones Page...."+getDate());
			System.out.println("Error: while Navigating to Project Tones Page...."+getDate());
		}
	}
	
	public void gotoProjectCallerID() throws Exception{
		try{
			
			
			
			new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Caller ID")));
			driver.findElement(By.linkText("Caller ID")).click();
			
			writeText("Navigating to Caller ID Page...."+getDate());
			System.out.println("Navigating to Caller ID Page...."+getDate());
		}
		catch(Exception e){
			captureScreen("gotoProjectCallerID_error_"+randoms);
			writeText("Error: while Navigating to Caller ID Page...."+getDate());
			System.out.println("Error: while Navigating to Caller ID Page...."+getDate());
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}

package com.clogic.SeleniumFramework;

import java.io.File;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdvancedPage extends BasicSetUp{
	
	public String roleName="";
	WritableWorkbook workbook ;
	WritableSheet sheet ;
	Label label;
	int row=1;
	int id=1;
	String attribute="";

	protected final WebDriver driver;
	WebElement element;
	
	public AdvancedPage(WebDriver driver) throws Exception{		
		this.driver=driver;
	}
	
	public void addCallField(String callFieldName, String type) throws Exception{
		try{
			writeText("Adding CallField.... @ "+ getDate());
			System.out.println("Adding CallField.... @ "+ getDate());
			 
			new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.linkText("custom_fields.input.add_new_fields")));
			driver.findElement(By.id("custom_fields.input.add_new_fields")).click();
			driver.findElement(By.id("name")).clear();
			driver.findElement(By.id("name")).sendKeys(callFieldName);
			new Select(driver.findElement(By.id("custom_type"))).selectByVisibleText(type);
			driver.findElement(By.id("custom_fields.input.add_custom_fields2")).click();
			}
			catch(Exception e){
				captureScreen("addCallField"+randoms);
				System.out.println("Error: While Adding CallField@ "+ getDate());
				writeText("Error: While Adding CallField@ "+ getDate()); 
			}
	}
	
	
	public void addVariable(String name, String type, String defaultValue, Boolean autoAssign) throws Exception{
		try{
			writeText("Adding Variable.... @ "+ getDate());
			System.out.println("Adding Variable.... @ "+ getDate());
			driver.findElement(By.id("variable_templates.add.variable")).click();
			driver.findElement(By.id("variable_name")).clear();
			driver.findElement(By.id("variable_name")).sendKeys(name);
			new Select(driver.findElement(By.id("variable_type"))).selectByVisibleText(type);
			driver.findElement(By.id("defaultvalue")).clear();
			driver.findElement(By.id("defaultvalue")).sendKeys(defaultValue);
			if(autoAssign){
				driver.findElement(By.id("auto_assign")).click();
			}
			driver.findElement(By.id("add_variable")).click(); 
			
			}
			catch(Exception e){
				captureScreen("addVariable_"+randoms);
				System.out.println("Error: While Adding CallField@ "+ getDate());
				writeText("Error: While Adding CallField@ "+ getDate()); 
			}
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
	
	 
	
	
	public void logRoleDetails() throws Exception{
		workbook = Workbook.createWorkbook(new File("AgentPortalRoles.xls"));
		sheet = workbook.createSheet("First Sheet", 0);
		label = new Label(0, 0, "Role Name"); 
		sheet.addCell(label);
		label = new Label(1,0,"Status");
		sheet.addCell(label);
	
	
		
		
	for(int l=0;;l++){	
		
		try{
		
						
							roleName = driver.findElement(By.xpath("//tbody[@id='"+l+"p_roleBody']/tr/td")).getText();
							label = new Label(0, row, roleName);
							sheet.addCell(label);
							System.out.println(roleName);
							if(selenium.isChecked("id="+row+"pe")){
								label = new Label(1, row, "Enable");
								sheet.addCell(label);
							}
							else{
								label = new Label(1, row, "Disable");
								sheet.addCell(label);
							} 
							row++; 
								for(int i=2; ;i++){
									try{
										roleName = driver.findElement(By.xpath("//tbody[@id='"+l+"p_roleBody']/tr/td["+i+"]")).getText();
										label = new Label(0, row, roleName);
										sheet.addCell(label);
										System.out.println(roleName);
										if(selenium.isChecked("id="+row+"pe")){
											label = new Label(1, row, "Enable");
											sheet.addCell(label);
										}
										else{
											label = new Label(1, row, "Disable");
											sheet.addCell(label);
										}
										row++; 
									}
									catch(Exception e){
										break;
									}
								}	
							for(int j=2;;j++){
										try{
											roleName = driver.findElement(By.xpath("//tbody[@id='"+l+"p_roleBody']/tr["+j+"]/td")).getText();
											label = new Label(0, row, roleName);
											sheet.addCell(label);
											System.out.println(roleName);
											if(selenium.isChecked("id="+row+"pe")){
												label = new Label(1, row, "Enable");
												sheet.addCell(label);
											}
											else{
												label = new Label(1, row, "Disable");
												sheet.addCell(label);
											} 
											row++; 
												for(int i=2; ;i++){
													try{
														driver.findElement(By.xpath("//tbody[@id='"+l+"p_roleBody']/tr["+j+"]/td["+i+"]"));
														roleName = driver.findElement(By.xpath("//tbody[@id='"+l+"p_roleBody']/tr["+j+"]/td["+i+"]")).getText();
														if(roleName == null){
															break;
														}
														label = new Label(0, row, roleName);
														sheet.addCell(label);
														System.out.println(roleName);
														if(selenium.isChecked("id="+row+"pe")){
															label = new Label(1, row, "Enable");
															sheet.addCell(label);
														}
														else{
															label = new Label(1, row, "Disable");
															sheet.addCell(label);
														}
														row++; 
													}
													catch(Exception e){
														break;
													}
												}
										}
										catch(Exception k){
											break;
										}
						}
		}
		catch(Exception m){
			break;
		}
	}
		
		workbook.write(); 
		workbook.close();
		System.out.println("==== Done !=====");
	}
	
	public void logClientRoleDetails() throws Exception{
		workbook = Workbook.createWorkbook(new File("AgentClientRoles.xls"));
		sheet = workbook.createSheet("First Sheet", 0);
		label = new Label(0, 0, "Role Name"); 
		sheet.addCell(label);
		label = new Label(1,0,"Status");
		sheet.addCell(label);
	
	
		
		
	for(int l=0;;l++){	
		
		try{
		
						
							roleName = driver.findElement(By.xpath("//tbody[@id='"+l+"c_roleBody']/tr/td")).getText();
							label = new Label(0, row, roleName);
							sheet.addCell(label);
							System.out.println(roleName);
							 
							if(selenium.isChecked("id="+row+"ce")){
								label = new Label(1, row, "Enable");
								sheet.addCell(label);
							}
							else{
								label = new Label(1, row, "Disable");
								sheet.addCell(label);
							} 
							row++; 
								for(int i=2; ;i++){
									try{
										roleName = driver.findElement(By.xpath("//tbody[@id='"+l+"c_roleBody']/tr/td["+i+"]")).getText();
										label = new Label(0, row, roleName);
										sheet.addCell(label);
										System.out.println(roleName);
										 
										if(selenium.isChecked("id="+row+"ce")){
											label = new Label(1, row, "Enable");
											sheet.addCell(label);
										}
										else{
											label = new Label(1, row, "Disable");
											sheet.addCell(label);
										}
										row++; 
									}
									catch(Exception e){
										break;
									}
								}	
							for(int j=2;;j++){
										try{
											roleName = driver.findElement(By.xpath("//tbody[@id='"+l+"c_roleBody']/tr["+j+"]/td")).getText();
											label = new Label(0, row, roleName);
											sheet.addCell(label);
											System.out.println(roleName);
											
											 
											if(selenium.isChecked("id="+row+"ce")){
												label = new Label(1, row, "Enable");
												sheet.addCell(label);
											}
											else{
												label = new Label(1, row, "Disable");
												sheet.addCell(label);
											} 
											row++; 
												for(int i=2; ;i++){
													try{
														
														roleName = driver.findElement(By.xpath("//tbody[@id='"+l+"c_roleBody']/tr["+j+"]/td["+i+"]")).getText();
														if(roleName.equals(" ")){
															break;
														}
														label = new Label(0, row, roleName);
														sheet.addCell(label);
														System.out.println(roleName);
														 
														
														if(selenium.isChecked("id="+row+"ce")){
															label = new Label(1, row, "Enable");
															sheet.addCell(label);
														}
														else{
															label = new Label(1, row, "Disable");
															sheet.addCell(label);
														}
														row++; 
													}
													catch(Exception e){
														break;
													}
												}
										}
										catch(Exception k){
											break;
										}
						}
		}
		catch(Exception m){
			break;
		}
	}
		
		workbook.write(); 
		workbook.close();
		System.out.println("==== Done !=====");
	}
	
	
	public void getAgentPortalRoles() throws Exception{
		try{
				writeText("Getting Agent Portal Roles.... @ "+ getDate());
				System.out.println("Getting Agent Portal Roles.... @ "+ getDate());
				new WebDriverWait(driver, 60).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input.edit-button")));
				driver.findElement(By.cssSelector("input.edit-button")).click();
				new WebDriverWait(driver, 60).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody[@id='0p_roleBody']/tr/td")));
				logRoleDetails();
				
			}
			catch(Exception e){
				captureScreen("getAgentPortalRoles_"+randoms);
				System.out.println("Error: While Getting Agent Portal Roles@ "+ getDate());
				writeText("Error: While Getting Agent Portal Roles@ "+ getDate()); 
			}
	}
	
	public void getAgentClientRoles() throws Exception{
		try{
			writeText("Getting Agent Client Roles.... @ "+ getDate());
			System.out.println("Getting Agent Client Roles.... @ "+ getDate());
			new WebDriverWait(driver, 60).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input.edit-button")));
			driver.findElement(By.cssSelector("input.edit-button")).click();
			driver.findElement(By.id("roles.label.client2")).click();
			new WebDriverWait(driver, 60).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody[@id='0p_roleBody']/tr/td")));
			logClientRoleDetails();
			
		}
		catch(Exception e){
			captureScreen("getAgentClientRoles_"+randoms);
			System.out.println("Error: While Getting Agent Client Roles@ "+ getDate());
			writeText("Error: While Getting Agent Client Roles@ "+ getDate()); 
		}
	}
	
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

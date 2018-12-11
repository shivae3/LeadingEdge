package com.PageFactory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {
	
	
	
	public LoginPage(WebDriver d) {
		
		//this.driver=Idriver;
	PageFactory.initElements(d, this);
	
	}

	//**********Login Page locators************
	
	@FindBy(id="vUsername") public WebElement txtUname;
	@FindBy(id="vPassword") public WebElement txtPassword;
	@FindBy(id="btn_sign_in") public WebElement btnSignin;
	@FindBy(id="msg") public WebElement txtErrMsg;
	
	//***********Home Page locators ****************
	
	
	@FindBy(xpath="//span[@class='logo']") public WebElement txtLogout;
	@FindBy(xpath="//h1[contains(text(),'Merced County Mosquito Abatement District')]") public WebElement txtWelcome;
	@FindBy(xpath="//strong[contains(text(),'SR Assigned Alert')]") public WebElement txtSR_assigned_alert;
	@FindBy(xpath="//strong[contains(text(),'Announcement')]") public WebElement txtAnnouncement;
	@FindBy(xpath="//strong[contains(text(),'Positive Mosquito Pool')]") public WebElement txt_Positive_Mosquito_Pool;
	@FindBy(xpath="//label[contains(text(),'Service Requests')]") public WebElement txt_Service_Requests;
	@FindBy(xpath="//label[contains(text(),'Activity Card')]") public WebElement txt_Activity_Card;
	@FindBy(xpath="//label[contains(text(),'Lab / Surveillance')]") public WebElement txt_Lab_Surveillance;
	
	//******Main Menu*************
	
	@FindBy(xpath="//span[contains(text(),'Home / Dashboard')]") public  WebElement txt_MainMenu;
	
	
	//***********User Module locators***********
	
	@FindBy(xpath="//a[@title='User']") public WebElement linkUsers;	
	@FindBy(linkText="View Users") public WebElement linkViewUsers;
	@FindBy(linkText="Access Groups") public WebElement linkAccessGroups;
	@FindBy(linkText="User Preference") public WebElement linkUserPreference;
	
	
	//*************View User**********************
	
	
	@FindBy(xpath="//h1[@class='moduleTitle']") public WebElement txtUserList;
	@FindBy(xpath="//input[@title='Add']") public WebElement btnAdd;
	@FindBy(xpath="//input[@title='Active']") public WebElement btnActive;
	@FindBy(xpath="//input[@title='Inactive']") public WebElement btnInActive;
	@FindBy(xpath="//input[@title='PDF Download']") public WebElement btnPDF_Download;
	@FindBy(xpath="//input[@title='CSV Download']") public WebElement btnCSV_Download;
	@FindBy(linkText="anchor_adv_search") public WebElement linkAnchor_Adv_Search;
	
	
	// ******Function to login in to the Application*******
	
	public void login_mapvision(String Userid ,String Password)
	{
		txtUname.clear();
		txtUname.sendKeys(Userid);
		txtPassword.clear();
		txtPassword.sendKeys(Password);
		btnSignin.click();
	}
	
	public void mainmenu(WebDriver d)
	{
			
		Actions actions = new Actions(d);
		actions.moveToElement(txt_MainMenu).perform();
	}
	
	public void logout()
	{
		txtLogout.click();
		
	}
	
	public void usermenu()
	{
		linkUsers.click();	
		
	}
	
	public void viewuser()
	{
		linkViewUsers.click();	
		
	}
	
	//***********Function to highlight the element************** 
	
	public void highLightElement(WebDriver d, WebElement element)
	{
	JavascriptExecutor js=(JavascriptExecutor)d; 

	js.executeScript("arguments[0].setAttribute('style', 'background: red; border: 2px solid green;');", element);

	try 
	{
	Thread.sleep(500);
	} 
	catch (InterruptedException e) {

	System.out.println(e.getMessage());
	} 

	js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element); 

	}
	
	
	//*************Function for dropdown*****************
	public void selectOption(WebElement locator,String optionname)
	{
		Select dd=new Select(locator);
		dd.selectByVisibleText(optionname);
	}
}

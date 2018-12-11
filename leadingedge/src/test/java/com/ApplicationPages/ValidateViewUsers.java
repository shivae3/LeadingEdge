package com.ApplicationPages;

import org.testng.annotations.Test;

import com.Helper.BrowserFactory;
import com.Helper.ExcelUtils;
import com.PageFactory.*;

public class ValidateViewUsers extends BrowserFactory{

	@Test
	public void checkViewUser() throws Exception
	{
		LoginPage ORPage1=new LoginPage(d);
		ORPage1.mainmenu(d);
		ORPage1.usermenu();
		ORPage1.viewuser();
		//ORPage1.selectOption(locator, optionname);
		
	}
}

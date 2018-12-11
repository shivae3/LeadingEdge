package com.ApplicationPages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.Helper.BrowserFactory;
import com.Helper.ExcelUtils;
import com.PageFactory.*;




public class ValidateLoginpage extends BrowserFactory {
	
	String path ="./TestData\\Login.xlsx";
	@Test
	public void checkValiduser() throws Exception
	{
		LoginPage page=new LoginPage(d);
		ExcelUtils excel=new ExcelUtils(path,"Sheet1");
		for(int i=1;i<(excel.count)+1;i++)
		{
			String uid=excel.getCellData(i,0);
			String pwd=excel.getCellData(i,1);
		//page.fillLogin(d,excel.getCellData(i,0), excel.getCellData(i,1));
		 page.login_mapvision(uid, pwd);
		 Thread.sleep(2000);
		 //page.btnSignin.click();
		 if((uid.equals("") && pwd.equals("")))
			{
				System.out.println("Blank user name & Blank password");
				assertTrue(page.txtErrMsg.getText().contains("Please enter username"));
			}
			// Blank user name and valid/invalid password
			else if(uid.equals("") && !(pwd.equals("")))
			{
				System.out.println("Blank user name and valid/invalid password");
				assertTrue(page.txtErrMsg.getText().contains("Please enter username"));
			}
			// Blank password and valid/invalid user name
			else if(!(uid.equals("")) && pwd.equals(""))
			{
				System.out.println("Blank password and valid/invalid user name");
				assertTrue(page.txtErrMsg.getText().contains("Please enter password"));
			}
			// Valid user name & valid password
			else if(uid.equals("demouser") && pwd.equals("Abc@12345"))
			{
				System.out.println("valid user name and pwd");
				page.mainmenu(d);
				page.logout();
			}
		 
		 Thread.sleep(2000);
		}
		
		
	}

}

package com.ApplicationPages;


import static org.testng.Assert.*;

import org.testng.annotations.Test;

import com.Helper.BrowserFactory;
import com.Helper.ExcelUtils;
import com.Helper.ExtentReportProj;
import com.PageFactory.*;



public class ValidateHomePage extends BrowserFactory {
	
	String path ="D:\\Sivakiran T\\Test Data\\Login.xlsx";
		
	@Test
	public void checkHomePage() throws Exception
	{
		LoginPage ORPage=new LoginPage(d);
		ExtentReportProj repo = new ExtentReportProj();
		ExcelUtils excel=new ExcelUtils(path,"Sheet1");
		ORPage.login_mapvision(excel.getCellData(5,0), excel.getCellData(5,1));
		//ORPage.highLightElement(d, ORPage.txtWelcome);
		repo.Report("checkHomePage", "Home Page verified");
		assertTrue(ORPage.txtWelcome.getText().contains("Welcome"));
		ORPage.highLightElement(d, ORPage.txtSR_assigned_alert);
		repo.Report("checkHomePage", "SR Assigned verified");
		assertTrue(ORPage.txtSR_assigned_alert.getText().contains("SR Assigned Alert"));
		ORPage.highLightElement(d, ORPage.txtAnnouncement);
		assertTrue(ORPage.txtAnnouncement.getText().contains("Announcement"));
		ORPage.highLightElement(d, ORPage.txt_Positive_Mosquito_Pool);
		assertTrue(ORPage.txt_Positive_Mosquito_Pool.getText().contains("Positive Mosquito Pool"));
		ORPage.highLightElement(d, ORPage.txt_Service_Requests);
		assertTrue(ORPage.txt_Service_Requests.getText().contains("Service Requests"));
		ORPage.highLightElement(d, ORPage.txt_Activity_Card);
		assertTrue(ORPage.txt_Activity_Card.getText().contains("Activity Card"));
		ORPage.highLightElement(d, ORPage.txt_Lab_Surveillance);
		assertTrue(ORPage.txt_Lab_Surveillance.getText().contains("Lab / Surveillance"));
		

	}
}

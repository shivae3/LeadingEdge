package com.Helper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportProj {
	
	 ExtentHtmlReporter htmlReporter;
	    
	    ExtentReports extent;
	    //helps to generate the logs in test report.
	    ExtentTest logger;
	    
	   public void Report(String testName, String description) {

		DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		Date dt = new Date();
		htmlReporter = new ExtentHtmlReporter("./Reports/" + testName + df.format(dt) + ".html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		logger = extent.createTest(testName);
		logger.log(Status.PASS,description);
		//Assert.assertTrue(true);
		
		
	     
		 
				
	}
	
	 
}

package com.Helper;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class BrowserFactory extends ExtentReportProj{
	
	public WebDriver d;
	String url= "https://merced.dev.leateamapps.com/";
	ExtentHtmlReporter htmlReporter;
    
    ExtentReports extent;
    //helps to generate the logs in test report.
    //ExtentTest logger;
	
    @Parameters("browser")
	@BeforeClass
	public void setUp(String browser)
	{
		// Launch browser
		if(browser.equals("FF"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\Scripts\\MAPDEMO\\lib\\geckodriver.exe");
			d=new FirefoxDriver();
		}
		else if(browser.equals("GC"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Browser drivers\\chromedriver.exe");
			d=new ChromeDriver();
		}
		else if(browser.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", "C:\\Selenium\\Scripts\\MAPDEMO\\lib\\IEDriverServer.exe");
			d=new InternetExplorerDriver();
		}
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		d.manage().timeouts().pageLoadTimeout(1,TimeUnit.MINUTES);
		d.manage().deleteAllCookies();
		d.get(url);
	}
	
    @AfterClass
    public void tearDown()
    {
    	
    	 d.quit();
    }
    
    @AfterMethod
    
    public void getResult(ITestResult result) {
    if(result.getStatus() == ITestResult.FAILURE) {
		 logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
		 logger.fail(result.getThrowable());
    }
    else if(result.getStatus() == ITestResult.SUCCESS) {
   	 logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
    }
    else {
   	 logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
   	 logger.skip(result.getThrowable());
    }
    
    
    
    }
    
    @AfterSuite
    public void closeDown()
    {
    	extent.flush();
    	
    }
	
	
        
    
    
}

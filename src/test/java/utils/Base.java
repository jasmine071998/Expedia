package utils;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import utils.PropertyReader;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

@Listeners({ utils.TestReport.class })
public class Base {
	
	public static WebDriver driver;
	public Properties prop;
	protected static ExtentTest testLog;
	protected static ExtentReports extentReporter;

	@BeforeTest
	public void beforeTest() throws Exception, IOException {
		prop = PropertyReader.getInstance();
		extentReporter = new ExtentReports();
		extentReporter.attachReporter(new ExtentHtmlReporter("Expedia_Multicity.html"));

		driver = HelperFunctions.startBrowser(prop.getProperty("browser"));
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("implicit.wait")),TimeUnit.SECONDS);

	}

	@AfterTest
	public void afterTest() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}

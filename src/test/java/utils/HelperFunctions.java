package utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.io.FileHandler;

public class HelperFunctions {

	private static WebDriver driver;
	public static WebDriver startBrowser(String browserName) 
	{
		
		if(browserName.toLowerCase().contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
			ChromeOptions op=new ChromeOptions();
			op.addArguments("--disable-notifications");
			
			if(browserName.toLowerCase().contains("headless")) {
				op.addArguments("--headless");
			}
			
			driver=new ChromeDriver(op);
		}else if(browserName.toLowerCase().contains("firefox")) {
			System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
			FirefoxOptions op=new FirefoxOptions();
			//disabling notifications in firefox
			op.addPreference("dom.webnotifications.enabled", false);
			
			if(browserName.toLowerCase().contains("headless")) {
				
				op.addArguments("--headless");
			}
			
			driver=new FirefoxDriver(op);
		}
		return driver;
	}
	
	public static String getSnap(String fileNameWithLocation) {
		TakesScreenshot tc = (TakesScreenshot) driver;
		// It will take ScreenShot & store in Java Buffer memory
		File scFile = tc.getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(scFile, new File(fileNameWithLocation));
			return fileNameWithLocation;
		} catch (IOException e) {
			System.out.println("Error with ScreenShot");
			return null;
		}
	}
}

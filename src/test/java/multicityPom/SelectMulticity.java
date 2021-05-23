package multicityPom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import utils.BasePage;

public class SelectMulticity extends BasePage{
	//WebDriver driver;
	
	public SelectMulticity(WebDriver driver) {

		//this.driver = driver;
		super(driver);
	}

	By m_flight1=By.xpath("//button[@class='btn-secondary btn-action t-select-btn']");
	By m_flight2=By.xpath("//button[@class='btn-secondary btn-action t-select-btn']");
	
	public void selectflights(ExtentTest log) {
		
		log.info("Selecting Flight 1");
		driver.findElement(m_flight1).click();
		
		log.info("Selecting Flight 2");
		driver.findElement(m_flight2).click();
		
	}
			
}

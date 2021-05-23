package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class KeyWords {
	
	WebDriver driver;
	
	public KeyWords(WebDriver driver) {
		this.driver=driver;
	}
	
	public void getUrl(String url) {
		driver.get(url);
	}
	
	public void click(String locatorXpath) {
		driver.findElement(By.xpath(locatorXpath)).click();
	}
	
	public void type(String locatorXpath, String data) {
		driver.findElement(By.xpath(locatorXpath)).sendKeys(data);
	}
	
	public void selectfromDropDown(String locatorXpath,String data) {
		Select sc=new Select(driver.findElement(By.xpath(locatorXpath)));
		sc.selectByVisibleText(data);
	}

}

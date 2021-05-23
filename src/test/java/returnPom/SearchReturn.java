
package returnPom;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import utils.Base;
import utils.BasePage;

public class SearchReturn extends BasePage {

	List<WebElement> ls;
	List<WebElement> ls1;
	
	public SearchReturn(WebDriver driver) {
		super(driver);
		//this.driver=driver;
	}

	By flight= By.xpath("//span[contains(text(),'Flights')]");
	By returnflight=By.xpath("//span[contains(text(),'Return')]");
	
	By fromflight=By.xpath("//input[@id='location-field-leg1-origin']");
//	By fromclick=By.xpath("//div[@class='is-subText truncate']");
//	By fromclick=By.xpath("//*[@id=\"location-field-leg1-origin-menu\"]/div[2]/ul/li/button/div/div[1]/span/strong");
	
	
	By toflight=By.xpath("//input[@id='location-field-leg1-destination']");
//	By toclick=By.xpath("//div[@class='truncate']/span/strong[contains(text(),'Kolkata (CCU - Netaji Subhash Chandra Bose Intl.)')]");
	
	By fromdate=By.xpath("//button[@id='d1-btn']");
//	By selectdate1=By.xpath("//button[@aria-label='2 Jan 2021']");
	By clickdate1=By.xpath("//button[@data-stid='apply-date-picker']");
	
	By todate=By.xpath("//button[@id='d2-btn']");
//	By selectdate2=By.xpath("//button[@aria-label='2 Feb 2021']");
	By clickdate2=By.xpath("//button[@data-stid='apply-date-picker']");
	
	By menuclass=By.xpath("//a[@id='preferred-class-input-trigger']");
	By selectclass=By.xpath("//*[@id=\"preferred-class-input\"]/div/div/a[1]");
	
	By menutravellers=By.xpath("//div[@id='adaptive-menu']");
	By selecttravellers=By.xpath("//button[@class='uitk-button uitk-button-small uitk-flex-item uitk-step-input-button']");
	
	By submit=By.xpath("//button[@type='submit']");
	
	public void clickReturn() {
		driver.manage().window().maximize();
		
		driver.findElement(flight).click(); 
		driver.findElement(returnflight).click();	
	}
	
	public List<WebElement> searchsd(){
		return driver.findElements(By.xpath("//button[@class='uitk-faux-input']")); //2 inputs- from,to
	}

	public void selectdate1(String d1) throws Exception {

		driver.findElement(fromdate).click();		//from date
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@aria-label='" +d1+ "']")).click();
		Thread.sleep(2000);
		driver.findElement(clickdate1).click();
	}
	
	public void selectdate2(String d2) throws Exception {
		driver.findElement(todate).click(); 
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@aria-label='" +d2+ "']")).click();
		Thread.sleep(2000);
		driver.findElement(clickdate2).click();
	}

	public void clicksubmit() {
		driver.findElement(submit).click();
	}
	
	public void menutraveller() {
		driver.findElement(menutravellers).click();
	}
	
	public List<WebElement> clicktravellers() {
		return driver.findElements(selecttravellers);
	}
	
	
	public void selectclass() {
		driver.findElement(menuclass).click();
		driver.findElement(selectclass).click();
	}
	
	public void doSearch(String src, String dest, String d1, String d2, ExtentTest log) throws Exception { 
		
		clickReturn();
		ls=searchsd();
		ls.get(0).click();
		
		log.info("typing from");
		driver.findElement(fromflight).sendKeys(src);
		
		log.info("Waiting for Options & Selecting");
		driver.findElement(By.xpath("//div[@class='truncate']/span/strong[contains(text(),'" + src + "')]")).click();
		
		ls.get(1).click();
		
		log.info("typing to");
		driver.findElement(toflight).sendKeys(dest);
		
		log.info("Waiting for Options & Selecting");
		driver.findElement(By.xpath("//div[@class='truncate']/span/strong[contains(text(),'" + dest + "')]")).click();
		
		log.info("selecting date");
		selectdate1(d1);
		selectdate2(d2);
		
		log.info("selecting traveller");
		menutraveller();
	//	ls1=clicktravellers();
	//	ls1.get(3).click();
		
		log.info("selecting class");
		selectclass();
		
		log.info("Clicking on Search");
		clicksubmit();		
	
	}

public void samesrcdest(String src, String dest, String d1, String d2, ExtentTest log) throws Exception { 
		
		clickReturn();
		ls=searchsd();
		ls.get(0).click();	
		log.info("typing from");
		driver.findElement(fromflight).sendKeys(src);
		log.info("Waiting for Options & Selecting");
		driver.findElement(By.xpath("//div[@class='truncate']/span/strong[contains(text(),'" + src + "')]")).click();
		ls.get(1).click();
		log.info("typing to");
		driver.findElement(toflight).sendKeys(dest);
		log.info("Waiting for Options & Selecting");
		
		driver.findElement(By.xpath("//*[@id=\"location-field-leg1-destination-menu\"]/div[2]/ul/li[1]/button/div/div[1]/span/strong")).click();	
		log.info("selecting date");
		selectdate1(d1);
		selectdate2(d2);
		log.info("selecting traveller");
		menutraveller();
	//	ls1=clicktravellers();
	//	ls1.get(3).click();
		log.info("selecting class");
		selectclass();
		log.info("Clicking on Search");
		clicksubmit();		
	
	}

public void invalidDest(String src, String dest, String d1, String d2, ExtentTest log) throws Exception { 
	
	clickReturn();
	ls=searchsd();
	ls.get(0).click();
	log.info("typing from");
	driver.findElement(fromflight).sendKeys(src);
	log.info("Waiting for Options & Selecting");
	driver.findElement(By.xpath("//div[@class='truncate']/span/strong[contains(text(),'" + src + "')]")).click();
	ls.get(1).click();
	log.info("typing to");
	driver.findElement(toflight).sendKeys(dest);
	log.info("Waiting for Options & Selecting");
	driver.findElement(By.xpath("//span[contains(text(),'Search for “123”')]")).click();
	log.info("selecting date");
	selectdate1(d1);
	selectdate2(d2);
	log.info("selecting traveller");
	menutraveller();
//	ls1=clicktravellers();
//	ls1.get(3).click();
	log.info("selecting class");
	selectclass();
	log.info("Clicking on Search");
	clicksubmit();		
	

}


}



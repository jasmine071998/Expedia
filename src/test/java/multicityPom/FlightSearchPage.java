package multicityPom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;
import utils.BasePage;

public class FlightSearchPage extends BasePage {

	public FlightSearchPage(WebDriver driver) {
		super(driver);
	}

	public void doSearch(String from,  ExtentTest log) {
		driver.findElement(By.xpath("//span[contains(text(),'Flights')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Multi-city')]")).click();

		log.info("typing from");
		List<WebElement> ls = driver.findElements(By.xpath("//button[@class='uitk-faux-input']"));// from,to 4 elements
		ls.get(0).click();
		List<WebElement> lss=driver.findElements(By.xpath("//input[@id='location-field-leg1-origin']"));
		lss.get(0).sendKeys(from);
		log.info("Waiting for Options & Selecting");

		driver.findElement(By.xpath("//div[@class='is-subText truncate']")).click();
		
		log.info("Clicking on Search");

		
		}
}

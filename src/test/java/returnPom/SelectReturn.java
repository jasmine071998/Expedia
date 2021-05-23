package returnPom;
//package returnPom;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import utils.Base;

public class SelectReturn extends Base {

	public SelectReturn(WebDriver driver) {
		this.driver=driver;
	}

	By selectf1=By.xpath("//button[@class='btn-secondary btn-action t-select-btn']");
	By selectf2=By.xpath("//button[@class='btn-secondary btn-action t-select-btn']");
	
	public void doSelectFlights(ExtentTest log) throws Exception {
		
		log.info("select flight 1");
		driver.findElement(selectf1).click(); //select flight
		log.info("select flight 2");
		driver.findElement(selectf2).click();

		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[@id='forcedChoiceNoThanks']")).click();
		
	}
}

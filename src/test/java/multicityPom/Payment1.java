package multicityPom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import utils.Base;

public class Payment1 extends Base {
	
	public Payment1(WebDriver driver) {
		this.driver=driver;
	}
	
	By titleclick=By.xpath("//select[@name='tripPreferencesRequest.airTripPreferencesRequest.travelerPreferences[0].titleIdAndName']");
	By titleselect=By.xpath("//option[@value='2_Ms.']");
	By surname=By.id("lastname[0]");
	By firstname=By.id("firstname[0]");
	By phoneno=By.id("phone-number[0]");
	By checkbox1=By.id("confirmation-sms-provider-checkbox");
	By gender = By.id("gender_female[0]");
	By day=By.xpath("//select[@id='date_of_birth_day[0]']/option[10]");
	By month=By.xpath("//select[@id='date_of_birth_month0']/option[11]");
	By year=By.xpath("//select[@id='date_of_birth_year[0]']/option[24]");
	By cardholdername=By.xpath("//input[@name='cardholder_name']");
	By cardno=By.id("creditCardInput");
	By expmonth=By.xpath("//select[@class='cko-field cc-expiry-month gb-whitelist']/option[5]");
	By expyear=By.xpath("//select[@class='cko-field cc-expiry-month gb-whitelist']/option[5]");
	By seccode=By.id("new_cc_security_code");
	By country=By.xpath("//select[@class='cko-field billing-country elv-field gb-whitelist']/option[100]");
	By address1=By.xpath("//input[@name='street']");
	By address2=By.xpath("//input[@name='street2']");
	By zipcode=By.xpath("//input[@name='zipcode']");
	By city=By.xpath("//input[@name='city']");
	By emailid=By.xpath("//input[@data-tealeaf-name='email']");

	By password1=By.xpath("//div[@id='account-creation']/fieldset/label/input[@name='password']");
	By password2=By.xpath("//div[@id='account-creation']/fieldset/label/input[@name='repeat_password']");
	By checkbox2=By.id("rewards_enrollment_checkbox");
	By completebook=By.id("complete-booking");
	
	
	public void doPayment() throws Exception {
		driver.findElement(titleclick).click();
		driver.findElement(titleselect).click();
		driver.findElement(surname).sendKeys("Serrao");
		driver.findElement(firstname).sendKeys("Avril");
		driver.findElement(phoneno).sendKeys("9809987654");
		driver.findElement(checkbox1).click();
		driver.findElement(gender).click();
		driver.findElement(day).click();
		driver.findElement(month).click();
		driver.findElement(year).click();
//		driver.findElement(cardholdername).sendKeys("Avril Serrao");
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		Thread.sleep(4000);
		
		driver.findElement(cardno).sendKeys("3243879854321");
		driver.findElement(expmonth).click();
		driver.findElement(expyear).click();
		driver.findElement(seccode).sendKeys("432");
		driver.findElement(country).click();
		driver.findElement(address1).sendKeys("A-103, Silver Jade");
		driver.findElement(address2).sendKeys("Chakala, Andheri East");
		driver.findElement(zipcode).sendKeys("400099");
		driver.findElement(city).sendKeys("Mumbai");
		driver.findElement(emailid).sendKeys("xyz@gmail.com");
		
		driver.findElement(password1).sendKeys("12345600");
		driver.findElement(password1).sendKeys("12345600");
		driver.findElement(checkbox2).click();
		driver.findElement(completebook).click();
		
		Thread.sleep(5000);
		
	}
	
}

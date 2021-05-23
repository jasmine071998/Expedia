package returnPom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import utils.Base;

public class Payment extends Base {
	
	public Payment(WebDriver driver) {
		this.driver=driver;
	}
	
	By titleclick=By.xpath("//select[@name='tripPreferencesRequest.airTripPreferencesRequest.travelerPreferences[0].titleIdAndName']");
	By titleselect=By.xpath("//option[@value='2_Ms.']");
	By ssurname=By.id("lastname[0]");
	By firstname=By.id("firstname[0]");
	By phoneno=By.id("phone-number[0]");
	By checkbox1=By.id("confirmation-sms-provider-checkbox");
	By gender = By.id("gender_female[0]");
	By day=By.xpath("//select[@id='date_of_birth_day[0]']/option[10]");
	By month=By.xpath("//select[@id='date_of_birth_month0']/option[11]");
	By year=By.xpath("//select[@id='date_of_birth_year[0]']/option[24]");
	By cardholdername=By.xpath("//input[@name='cardholder_name']");
	By cardno=By.id("creditCardInput");
	By expmonth=By.xpath("//select[@name='expiration_month']/option[5]");
	By expyear=By.xpath("//select[@name='expiration_year']/option[5]");
	By sseccode=By.id("new_cc_security_code");
	By country=By.xpath("//select[@class='cko-field billing-country elv-field gb-whitelist']/option[100]");
	By address1=By.xpath("//input[@name='street']");
	By address2=By.xpath("//input[@name='street2']");
	By zipcode=By.xpath("//input[@name='zipcode']");
	By ccity=By.xpath("//input[@name='city']");
	By emailid=By.xpath("//input[@data-tealeaf-name='email']");

	By password1=By.xpath("//div[@id='account-creation']/fieldset/label/input[@name='password']");
	By password2=By.xpath("//div[@id='account-creation']/fieldset/label[2]/input[@name='repeat_password']");
	By checkbox2=By.id("rewards_enrollment_checkbox");
	By completebook=By.id("complete-booking");
	
	
	public void doPayment(String surname,String name, String number, String cardnumber, String seccode, String address,String city, String postcode, String email, String pass, String cpass,ExtentTest log) throws Exception {
		
		driver.findElement(titleclick).click();
		log.info("select title");
		driver.findElement(titleselect).click();
		log.info("enter surname");
		driver.findElement(ssurname).sendKeys(surname);
		log.info("enter name");
		driver.findElement(firstname).sendKeys(name);
		log.info("enter phone no");
		driver.findElement(phoneno).sendKeys(number);
		log.info("uncheck checkbox");
		driver.findElement(checkbox1).click();
		log.info("select gender");
//		Thread.sleep(2000);
		driver.findElement(gender).click();
		log.info("select DOB");
		driver.findElement(day).click();
		driver.findElement(month).click();
		driver.findElement(year).click();
//		driver.findElement(cardholdername).sendKeys("Avril Serrao");
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		js.executeScript("window.scrollBy(0,980)");
		Thread.sleep(4000);
		
		log.info("enter cardno");
		driver.findElement(cardno).sendKeys(cardnumber);
		log.info("select expiry details");
		driver.findElement(expmonth).click();
		driver.findElement(expyear).click();
		log.info("enter security code");
		driver.findElement(sseccode).sendKeys(seccode);
		log.info("enter address details");
		driver.findElement(country).click();
		driver.findElement(address1).sendKeys(address);
		driver.findElement(address2).sendKeys("Chakala, Andheri East");
		driver.findElement(ccity).sendKeys(city);
		driver.findElement(zipcode).sendKeys(postcode);
		log.info("enter email id");
		driver.findElement(emailid).sendKeys(email);
		log.info("enter password");
		driver.findElement(password1).sendKeys(pass);
		log.info("confirm password");
		driver.findElement(password2).sendKeys(cpass);
		log.info("check checkbox");
		driver.findElement(checkbox2).click();
		Thread.sleep(2000);
		log.info("click on complete booking");
		driver.findElement(completebook).click();
		
		Thread.sleep(5000);
		
	}
	
}

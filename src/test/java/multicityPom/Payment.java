package multicityPom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import utils.BasePage;

public class Payment extends BasePage{

	//WebDriver driver;

	public Payment(WebDriver driver) {

		//this.driver = driver;
		super(driver);
	}

	By m_title = By.xpath("//*[@id=\"title[0]\"]");
	By m_seltitle = By.xpath("//select[@class='cko-field title-id-name gb-whitelist']/option[3]");
	By m_lname = By.id("lastname[0]");
	By m_fname = By.id("firstname[0]");
	By m_pno = By.id("phone-number[0]");
	By m_cb = By.id("confirmation-sms-provider-checkbox");
	By m_gender = By.id("gender_female[0]");
	By m_day=By.xpath("//select[@data-tealeaf-name='date_of_birth_day[0]']");
	By m_clickday=By.xpath("//option[@value=19]");
	By m_month=By.xpath("//select[@data-tealeaf-name='date_of_birth_month[0]']");
	By m_clickmonth=By.xpath("//option[contains(text(),'07-Jul')]");
	By year=By.xpath("//select[@id='date_of_birth_year[0]']/option[24]");
	 By cardholdername=By.xpath("//input[@data-tealeaf-name='cardHolderName_1']");
	 By cardno=By.id("creditCardInput");
		By expmonth=By.xpath("//select[@class='cko-field cc-expiry-month gb-whitelist']/option[5]");
		By expyear=By.xpath("//select[@class='cko-field cc-expiry-year gb-whitelist']/option[5]");
		By seccode=By.id("new_cc_security_code");
		By country=By.xpath("//select[@class='cko-field billing-country elv-field gb-whitelist']/option[100]");
		By address1=By.xpath("//input[@name='street']");
		By address2=By.xpath("//input[@name='street2']");
		By zipcode=By.xpath("//input[@name='zipcode']");
		By city=By.xpath("//input[@name='city']");
		By emailid=By.xpath("//input[@data-tealeaf-name='email']");

		By password1=By.xpath("//div[@id='account-creation']/fieldset/label/input[@name='password']");
		By password2=By.xpath("//input[@name='repeat_password']");
		By checkbox2=By.id("rewards_enrollment_checkbox");
		By completebook=By.id("complete-booking");
	
	public void doPayment(String surname,String name, String number, String cardnumber, String seccode1, String address,String city1, String postcode, String email, String pass, String cpass,ExtentTest log) throws Exception {
		
		log.info("Selecting Title");
		driver.findElement(m_title).click();
		driver.findElement(m_seltitle).click();
		log.info("Entering surname");
		driver.findElement(m_lname).sendKeys(surname);
		log.info("Entering name");
		driver.findElement(m_fname).sendKeys(name);
		log.info("Entering phone number");
		driver.findElement(m_pno).sendKeys(number);
		driver.findElement(m_cb).click();
		log.info("Selecting gender");
		//driver.findElement(m_gender).click();
		log.info("Entering DOB");
		//driver.findElement(m_day).click();
		//driver.findElement(m_clickday).click();
		//driver.findElement(m_month).click();
		//driver.findElement(m_clickmonth).click();
		 //driver.findElement(year).click();
		 
		//  driver.findElement(By.xpath("//select[@id='baggage_prepay_dropdown_traveler_0_leg_0']/option[1]")).click();
		 // driver.findElement(By.xpath("//select[@id='baggage_prepay_dropdown_traveler_0_leg_1']/option[3]")).click();

		  //driver.findElement(cardholdername).sendKeys("Jasmine");
		  JavascriptExecutor js=(JavascriptExecutor)driver;
			//js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		  js.executeScript("window.scrollBy(0,980)");
			
			Thread.sleep(4000);
			log.info("Entering Card details");
			driver.findElement(cardno).sendKeys(cardnumber);
			driver.findElement(expmonth).click();
			driver.findElement(expyear).click();
			driver.findElement(seccode).sendKeys(seccode1);
			driver.findElement(country).click();
			Thread.sleep(2000);
			log.info("Entering address");
			driver.findElement(address1).sendKeys(address);
			driver.findElement(address2).sendKeys("I.C.Colony, Borivali West");
			driver.findElement(zipcode).sendKeys(postcode);
			driver.findElement(city).sendKeys(city1);
			log.info("Entering email");
			driver.findElement(emailid).sendKeys(email);
			log.info("Entering password");
			driver.findElement(password1).sendKeys(pass);
			log.info("Re-typing password");
			driver.findElement(password2).sendKeys(cpass);
			driver.findElement(checkbox2).click();
			driver.findElement(completebook).click();
			
			Thread.sleep(5000);
			
			
			
		  
	}
}

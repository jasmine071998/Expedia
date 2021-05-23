
package onewayPom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import utils.BasePage;

public class SearchOneway extends BasePage {
	//WebDriver driver;
	
	public SearchOneway(WebDriver driver) {
//		this.driver = driver;
				super(driver);
	}
	

	By e_flights=By.xpath("//span[contains(text(),'Flights')]");
	By e_oneway=By.xpath("//span[contains(text(),'One-way')]");

	By e_srcbox=By.xpath("//button[@class='uitk-faux-input']");
	By e_src=By.xpath("//*[@id=\"location-field-leg1-origin\"]");
	By e_srcdrop=By.xpath("//div[@class='is-subText truncate']");

	//	 Delhi 
	By e_desbox=By.xpath("//*[@id=\"location-field-leg1-destination-menu\"]/div[1]/button");
	By e_des=By.xpath("//input[@id='location-field-leg1-destination']");
	By e_desdrop=By.xpath("//strong[contains(text(),'Delhi (DEL - Indira Gandhi Intl.)')]");

	
	
//	Same Source and 2digit Numerical Destination = Mumbai,12
	By e_desbox1=By.xpath("//*[@id=\"location-field-leg1-destination-menu\"]/div[1]/button");
	By e_des1=By.xpath("//input[@id='location-field-leg1-destination']");
	By e_desdrop1=By.xpath("//span[contains(text(),'Search for “12”')]");
			
//Same Source and 3digit Numerical Destination = Mumbai,123
	By e_desbox3=By.xpath("//*[@id=\"location-field-leg1-destination-menu\"]/div[1]/button");
	By e_des3=By.xpath("//input[@id='location-field-leg1-destination']");
	By e_desdrop3=By.xpath("//span[contains(text(),'Search for “123”')]");
			

//Same Source and Destination = Mumbai,Mumbai
	By e_desbox2=By.xpath("//*[@id='location-field-leg1-destination-menu']/div[1]/button");
	By e_des2=By.xpath("//input[@id='location-field-leg1-destination']");
	By e_desdrop2=By.xpath("//*[@id=\"location-field-leg1-destination-menu\"]/div[2]/ul/li[1]/button/div/div[1]/span/strong[contains(text(),'Mumbai')]");
	

	


	By e_ecobox=By.xpath("//a[@id='preferred-class-input-trigger']");
	By e_ecodrop=By.xpath("//a[contains(text(),'Premium economy')]");
	
	By e_searchflightbutton=By.xpath("//button[contains(text(),'Search')]");
	//button[@id='d1-btn']
	
	By fromdate=By.xpath("//button[@id='d1-btn']");
	By selectdate1=By.xpath("//button[@aria-label='28 Jan 2021']");
	By clickdate1=By.xpath("//button[@data-stid='apply-date-picker']");
	

	
	By menutravellers=By.xpath("//div[@id='adaptive-menu']");
	By submittrv=By.xpath("//*[@id=\"adaptive-menu\"]/div/div/div[2]/button");
	
		
	public void selectclass() throws Exception {
		Thread.sleep(4000);
		driver.findElement(menutravellers).click();
		Thread.sleep(4000);
		driver.findElement(submittrv).click();
	
	}
	public void selectdate(String d1) throws Exception {
		driver.findElement(fromdate).click();
		Thread.sleep(7000);
		driver.findElement(By.xpath("//button[@aria-label='" +d1+ "']")).click();
		Thread.sleep(2000);
		driver.findElement(clickdate1).click();
	}	
		
	
	public void clickflights() {
		driver.manage().window().maximize();
		driver.findElement(e_flights).click();
		}
	public void clickoneway() {
		driver.findElement(e_oneway).click();
		}
	public void clicksrcbox() {
		driver.findElement(e_srcbox).click();
	
		}
	public void setSrc(String src) {
		driver.findElement(e_src).sendKeys(src);		
	}
	public void clicksrcdrop() {
		driver.findElement(e_srcdrop).click();
		}
	public void clickdesbox() {
		driver.findElement(e_desbox).click();
		}
	public void setdes(String des) {
		driver.findElement(e_des).sendKeys(des);		
	}
	public void clickdesdrop() {
		driver.findElement(e_desdrop).click();
		}
		
	
	public void clickdesbox1() {
		driver.findElement(e_desbox1).click();
		}
	public void setdes1(String des1) {
		driver.findElement(e_des1).sendKeys(des1);		
	}
	public void clickdesdrop1() {
		driver.findElement(e_desdrop1).click();
		}
		
	public void clickdesbox2() {
		driver.findElement(e_desbox2).click();
		}
	public void setdes2(String des2) {
		driver.findElement(e_des2).sendKeys(des2);		
	}
	public void clickdesdrop2() {
		driver.findElement(e_desdrop2).click();
		}
	public void clickdesbox3() {
		driver.findElement(e_desbox3).click();
		}
	public void setdes3(String des3) {
		driver.findElement(e_des3).sendKeys(des3);		
	}
	public void clickdesdrop3() {
		driver.findElement(e_desdrop3).click();
		}
	public void clickecobox() throws Exception {
		Thread.sleep(2000);
		driver.findElement(e_ecobox).click();
		}
	public void clickecodrop() throws Exception  {
		Thread.sleep(2000);
		driver.findElement(e_ecodrop).click();
		}
		
	public void clicksearchflightbutton() {
		driver.findElement(e_searchflightbutton).click();
		}
	
	public void doSearchSrc(String src,ExtentTest log) {
		log.info("Clicking on flights");
		clickflights();
		log.info("Clicking on one way");
		clickoneway(); 
		log.info("Clicking on search box");
		clicksrcbox();
		log.info("typing source");
	//	Thread.sleep(7000);
		setSrc(src);
		log.info("selecting source from dropdown");
	//	Thread.sleep(3000);
		clicksrcdrop();		
	}
	public void doSearchDes(String des,ExtentTest log) {
		log.info("Clicking on destination box");
		clickdesbox();
		//Thread.sleep(7000);
		log.info("typing destination ");
		setdes(des);
	//	Thread.sleep(7000);
		log.info("selection of destination from dropdown");
		clickdesdrop();		
	}
	
	public void doSearchDes1(String des1,ExtentTest log) {
		log.info("Clicking on destination box");
		clickdesbox1();
		//Thread.sleep(7000);
		log.info("typing destination ");
		setdes1(des1);
	//	Thread.sleep(7000);
		log.info("selection of destination from dropdown");
		clickdesdrop1();		
	}
	
	public void doSearchDes2(String des2,ExtentTest log) {
		log.info("Clicking on destination box");
		clickdesbox2();
		//Thread.sleep(7000);
		log.info("typing destination ");
		setdes2(des2);
	//	Thread.sleep(7000);
		log.info("selection of destination from dropdown");
		clickdesdrop2();		
	}
	public void doSearchDes3(String des3,ExtentTest log) {
		log.info("Clicking on destination box");
		clickdesbox3();
		//Thread.sleep(7000);
		log.info("typing destination ");
		setdes3(des3);
	//	Thread.sleep(7000);
		log.info("selection of destination from dropdown");
		clickdesdrop3();		
	}
	public void doSearchEco() throws Exception{
		clickecobox();
		Thread.sleep(2000);
		
		clickecodrop();
	}	
	public void doflightSearch() throws Exception {
		Thread.sleep(7000);
		
		clicksearchflightbutton();
	}
	
	public void doFlightDate(String d1) throws Exception{
		Thread.sleep(7000);
		selectdate(d1);
		
	}
	
	public void doMenu()  throws Exception  {
			
			selectclass();
	}
}

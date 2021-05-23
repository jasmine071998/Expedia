package multicityPom;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;
import utils.BasePage;

import utils.Base;

public class SearchMulticity extends BasePage{

	//WebDriver driver;
	List<WebElement> ls;
	List<WebElement> lsi;
	List<WebElement> lsd;
	List<WebElement> lst;
	List<WebElement> lss;
	
	public SearchMulticity(WebDriver driver) {

		//this.driver = driver;
		super(driver);
	}

	By m_flights= By.xpath("//span[contains(text(),'Flights')]");
	By m_multicity=By.xpath("//span[contains(text(),'Multi-city')]");
	By m_xpathsd=By.xpath("//button[@class='uitk-faux-input']");
	By m_typesrc1=By.xpath("//*[@id=\"location-field-leg1-origin\"]");
	By m_clicksrc1=By.xpath("//div[@class='is-subText truncate']");
	
	By m_date=By.xpath("//button[@id='d1-btn']");
	
	By m_clickdate=By.xpath("//button[@data-stid='apply-date-picker']");
	
	By m_clickdate2=By.xpath("//button[@data-stid='apply-date-picker']");
	By m_menutravellers=By.xpath("//a[@id='preferred-class-input-trigger']");
	By m_selecttravellers=By.xpath("//*[@id=\"preferred-class-input\"]/div/div/a[1]");
	By m_menuclass=By.xpath("//div[@id='adaptive-menu']");
	By m_selectclass=By.xpath("//button[@class='uitk-button uitk-button-small uitk-flex-item uitk-step-input-button']");
	By m_click=By.xpath("//button[@data-testid='guests-done-button']");
	By m_submit=By.xpath("//button[@type='submit']");
	//By m_src2=By.xpath("//div[@class='truncate']/span/strong[contains(text(),'Pune')]");
	
	public void clickMulticity() {
		driver.findElement(m_flights).click();
		driver.findElement(m_multicity).click();
	}
	
	public List<WebElement> searchsd(){
		return driver.findElements(By.xpath("//button[@class='uitk-faux-input']"));// from,to 4 elements
	}
	
	public List<WebElement> searchdestination(){
		return driver.findElements(By.xpath("//input[@id='location-field-leg1-destination']"));
	}
	
	public List<WebElement> searchsource(){
		return driver.findElements(m_typesrc1);
	}
	
	public void setsrc1(String src1,List<WebElement> lss) {
		//driver.findElement(m_typesrc1).sendKeys(src1);
		lss.get(0).sendKeys(src1);
	}
	
	public void setsrc2(String src2, List<WebElement> lss) {
		lss.get(1).sendKeys(src2);
	}
	public void clicksrc1() {
		driver.findElement(m_clicksrc1).click();
	}
	
	public void clicksrc2(String src2) {
		//driver.findElement(m_src2).click();
		driver.findElement(By.xpath("//div[@class='truncate']/span/strong[contains(text(),'" + src2 + "')]")).click();
	}
	
	public void setdest1(String dest1, List<WebElement> lsi) {
		lsi.get(0).sendKeys(dest1);
	}
	public void setdest2(String dest2, List<WebElement> lsi) {
		lsi.get(1).sendKeys(dest2);
	}
	
	public void clickdest1(String dest1) {
		//driver.findElement(m_clickdest1).click();
		driver.findElement(By.xpath("//div[@class='truncate']/span/strong[contains(text(),'" + dest1 + "')]")).click();
		//driver.findElement(By.xpath("//ul[@id='ui-id-1']/li/a[contains(text(),'" + from + "')]")).click();
		
	}
	
	public void clickdest2(String dest2) {
		//driver.findElement(m_clickdest2).click();
		driver.findElement(By.xpath("//div[@class='truncate']/span/strong[contains(text(),'" + dest2 + "')]")).click();
	}
	
	public List<WebElement>  searchDate() {
		return driver.findElements(m_date);
	}
	
	public void clickDate(String d1) throws Exception {
		//driver.findElement(m_selectdate).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@aria-label='" +d1+ "']")).click();
		Thread.sleep(2000);
		driver.findElement(m_clickdate).click();
		
	}
	
	public void clickDate2(String d2) throws Exception {
		//driver.findElement(m_selectdate2).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@aria-label='" +d2+ "']")).click();
		Thread.sleep(2000);
		driver.findElement(m_clickdate).click();	
	}
	public List<WebElement>  clicktravellers() {
		return driver.findElements(m_selectclass);
	}
	
	public void selecttravellers() {
		
		driver.findElement(m_menutravellers).click();
		driver.findElement(m_selecttravellers).click();
		
	}
	
	public void clickmenu() {
		driver.findElement(m_menuclass).click();
	}
	
	public void clicksubmit() throws Exception {
		
		Thread.sleep(2000);
		driver.findElement(m_click).click();
		Thread.sleep(2000);
		driver.findElement(m_submit).click();
		
	}
	public void doSearch(String src1, String dest1, String d1, ExtentTest log) throws Exception {
		
		clickMulticity();
		ls= searchsd();
		ls.get(0).click();
		lss=searchsource();
		log.info("typing source 1");
		setsrc1(src1,lss);
		log.info("Waiting for Options & Selecting");
		clicksrc1();
		ls.get(1).click();
		lsi=searchdestination();
		log.info("typing dest1");
		setdest1(dest1, lsi);
		log.info("Waiting for Options & Selecting");
		clickdest1(dest1);
		lsd=searchDate();
		lsd.get(0).click();
		log.info("Selecting date");
		clickDate(d1);
	}
	
	public void doSearch2(String src2,String dest2, String d2,ExtentTest log) throws Exception {
		
		ls.get(2).click();
		
		//lss.get(1).sendKeys("Pune");
		log.info("typing source 2");
		
		setsrc2(src2, lss);
		log.info("Waiting for Options & Selecting");
		clicksrc2(src2);
		
		ls.get(3).click();
		log.info("typing dest2");
		setdest2(dest2, lsi);
		log.info("Waiting for Options & Selecting");
		clickdest2(dest2);
		lsd.get(1).click();
		log.info("Selecting date");
		clickDate2(d2);
		//log.info("Selecting travellers");
		selecttravellers();
		clickmenu();
		Thread.sleep(2000);
		//lst=clicktravellers();
		//lst.get(3).click();

		log.info("Clicking on Search");
		clicksubmit();
	}
	
	public void invalidDates(String src2,String dest2, String d2,ExtentTest log) throws Exception {
		
ls.get(2).click();
		
		//lss.get(1).sendKeys("Pune");
		log.info("typing source 2");
		
		setsrc2(src2, lss);
		log.info("Waiting for Options & Selecting");
		clicksrc2(src2);
		
		ls.get(3).click();
		log.info("typing dest2");
		setdest2(dest2, lsi);
		log.info("Waiting for Options & Selecting");
		clickdest2(dest2);
		lsd.get(1).click();
		log.info("Selecting date");
		clickDate2(d2);
		log.info("Selecting travellers");
		selecttravellers();
		clickmenu();

		lst=clicktravellers();
		lst.get(3).click();

		log.info("Clicking on Search");
		clicksubmit();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,420)");
		  Thread.sleep(4000);
		  
	}
	
	public void samesrcdest(String src1,String dest1,String d1,ExtentTest log) throws Exception {
		
		clickMulticity();
		ls= searchsd();
		ls.get(0).click();
		lss=searchsource();
		log.info("typing source 1");
		setsrc1(src1,lss);
		log.info("Waiting for Options & Selecting");
		clicksrc1();
		ls.get(1).click();
		lsi=searchdestination();
		log.info("typing dest1");
		setdest1(dest1, lsi);
		
		log.info("Waiting for Options & Selecting");
		//clickdest1(dest1);
		driver.findElement(By.xpath("//*[@id=\"location-field-leg1-destination-menu\"]/div[2]/ul/li[1]/button/div/div[1]/span/strong[contains(text(),'Mumbai')]")).click();
		lsd=searchDate();
		lsd.get(0).click();
		log.info("Selecting date");
		clickDate(d1);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

}

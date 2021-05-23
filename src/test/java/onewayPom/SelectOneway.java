package onewayPom;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SelectOneway  {
	WebDriver driver;
	
	public SelectOneway(WebDriver driver) {
		this.driver = driver;
	}
	
	
	
	By e_selectflight=By.xpath("//button[@data-test-id='select-button']");
	
	By e_nothankspopup=By.xpath("//a[@id='forcedChoiceNoThanks']");
	
	By e_continuebooking=By.xpath("//button[@id='bookButton']");
	
	
	
		
	
	public void clickselectflight() {
		driver.findElement(e_selectflight).click();
		}	
	
	public void clicknothankspopup() {
		driver.findElement(e_nothankspopup).click();
		}
	public void clickcontinuebooking(){
		String PID = driver.getWindowHandle();
		  Set<String> all_Id = driver.getWindowHandles(); // getting ID of all windows
		  List<String> all_Id2 = new ArrayList<String>(all_Id);
		  for (int i = 0; i < all_Id2.size(); i++) {
		   if (!all_Id2.get(i).equals(PID)) {
		    driver.switchTo().window(all_Id2.get(i));
		    driver.findElement(e_continuebooking).click();
		    }}}
	
	
	
	
	
	public void doflightSelect() throws Exception {
			Thread.sleep(4000);
			clickselectflight();
	}
	public void donothankspopup() throws Exception {
		Thread.sleep(4000);
		clicknothankspopup();	
	}
	public void docontinuebooking()throws Exception {
		Thread.sleep(4000);
		clickcontinuebooking();
	}
	
	
	
}

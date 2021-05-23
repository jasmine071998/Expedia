package returnPom;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import utils.Base;

public class ContinueBooking extends Base{
	
	WebDriver driver;

	public ContinueBooking(WebDriver driver) {
		this.driver=driver;
	}

	public void doContinue(ExtentTest log) {
		
	Set<String> all_Id=driver.getWindowHandles(); //Getting id of all windows/tab
	List<String> all_Id2=new ArrayList<>(all_Id);
	
	log.info("switching tab");
	driver.switchTo().window(all_Id2.get(1));
	log.info("review & confirm booking");
	driver.findElement(By.xpath("//button[@id='bookButton']")).click();

}
}
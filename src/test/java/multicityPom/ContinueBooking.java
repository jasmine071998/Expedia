package multicityPom;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import utils.BasePage;

public class ContinueBooking extends BasePage{
	
//WebDriver driver;
	
	public ContinueBooking(WebDriver driver) {

		//this.driver = driver;
		super(driver);
	}
	
	By m_cb=By.id("bookButton");
	
	public void continuebooking(ExtentTest log) throws Exception {
		
		log.info("Click on continue booking");
		String PID = driver.getWindowHandle();
		  Set<String> all_Id = driver.getWindowHandles(); // getting ID of all windows
		  List<String> all_Id2 = new ArrayList<String>(all_Id);
		  for (int i = 0; i < all_Id2.size(); i++) {
		   if (!all_Id2.get(i).equals(PID)) {
			   Thread.sleep(4000);
		    driver.switchTo().window(all_Id2.get(i));
		   // driver.findElement(By.xpath("//button[@id='bookButton']")).click();//this works fine -method 1
		    Thread.sleep(4000);
		    driver.findElement(m_cb).click(); //this works but sometimes on first page it wasn't selecting date-method 2
		    //2 didnt work 4 worked
		    //page 4
		   }}
	}

}

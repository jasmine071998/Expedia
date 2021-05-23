package multicityTestRunner;

import org.testng.annotations.Test;

import multicityPom.ContinueBooking;
import multicityPom.Payment;
import multicityPom.Payment1;
import multicityPom.SearchMulticity;
import multicityPom.SelectMulticity;
import utils.Base;

public class MulticitySearchTest extends Base{
  @Test(priority=1)
  public void searchFlights() {
	  
	  driver.get(prop.getProperty("url"));
	  SearchMulticity sm=new SearchMulticity(driver);
	//  sm.doSearch("Mumbai", "Mangalore");
	 // sm.doSearch2("Pune","Banglore");
  }
  
  @Test(priority=2)
  public void selectFlights() {
	
	  //driver.get(prop.getProperty("url"));
	  SelectMulticity scity=new SelectMulticity(driver);
	  //scity.selectflights();
	  //ContinueBooking cb=new ContinueBooking(driver);
	 // cb.continuebooking();
  }
  
  @Test(priority=3)
  public void payment() throws Exception {
	  
	  //Payment p=new Payment(driver);
	  //p.doPayment();
	Payment1 p=new Payment1(driver);
	 p.doPayment();
  
  }
}

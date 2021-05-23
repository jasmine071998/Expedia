package multicityTestRunner;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import multicityPom.ContinueBooking;
import multicityPom.Payment;
import multicityPom.SearchMulticity;
import multicityPom.SelectMulticity;
import utils.Base;
import utils.ExcelReader;

@Listeners()
public class MultiTry extends Base{
  @Test(priority=1,dataProvider = "dp")
  public void searchFlights(String src1,String dest1,String d1,String src2,String dest2,String d2) throws Exception {
	  
	 driver.get(prop.getProperty("url"));
	 driver.manage().window().maximize();
	  //driver.get("https://www.expedia.co.in/Flights");
	  SearchMulticity sm=new SearchMulticity(driver);
	  sm.doSearch(src1,dest1,d1,testLog);
	  sm.doSearch2(src2,dest2,d2,testLog);
	  Assert.assertEquals(driver.getTitle(),"Trip from BOM | Expedia" );
  }
  
  @Test(priority=2)
  public void selectFlights() throws Exception {
	
	  //driver.get(prop.getProperty("url"));
	  SelectMulticity scity=new SelectMulticity(driver);
	  scity.selectflights(testLog);
	  //Assert.assertEquals(driver.getTitle(),"Trip Detail | Expedia" );
	  ContinueBooking cb=new ContinueBooking(driver);
	  cb.continuebooking(testLog);
	  Assert.assertEquals(driver.getTitle(),"Expedia: Payment" );
  }
  
  @Test(priority=3,dataProvider = "dp3")
  public void payment(String surname,String name, String number, String cardnumber, String seccode, String address,String city, String postcode, String email, String pass, String cpass) throws Exception {
	  
	  Payment p=new Payment(driver);
	  p.doPayment(surname,name,number,cardnumber,seccode,address,city,postcode,email,pass,cpass,testLog);
	  Assert.assertEquals(driver.getTitle(),"Expedia: Payment" );
  }
  
  @Test(priority=4,dataProvider = "dp4")
  public void paymentinvalid(String surname,String name, String number, String cardnumber, String seccode, String address,String city, String postcode, String email, String pass, String cpass) throws Exception {
	  //driver.get("https://www.expedia.co.in/Checkout/V1/FlightCheckout?tripid=5ec40d9c-bf98-5f1f-a76d-72d8d0671b89&c=cf2b496c-2875-4f77-95f7-13935f6189af");
		//driver.get("https://www.expedia.co.in/Checkout/V1/FlightCheckout?tripid=4fa6e147-7827-51e5-8d52-351de25f9ece&c=6b397d95-b3f4-4add-b198-890e18d261df"); 
	  driver.get("https://www.expedia.co.in/Checkout/V1/FlightCheckout?tripid=a1faf5a7-fdb6-506a-879f-f4ca757b274a&c=339465c8-c7f6-4b4a-9039-6a6e319b5d47");
	  Payment p=new Payment(driver);
	  p.doPayment(surname,name,number,cardnumber,seccode,address,city,postcode,email,pass,cpass,testLog);
	  Assert.assertEquals(driver.getTitle(),"Expedia: Payment" );
  }
  
  @Test(priority=5,dataProvider = "dp1")
  public void searchFlightsinvalid(String src1, String dest1,String d1,String src2,String dest2, String d2) throws Exception {
	  
	 driver.get(prop.getProperty("url"));
	 driver.manage().window().maximize();
	  //driver.get("https://www.expedia.co.in/Flights");
	  SearchMulticity sm=new SearchMulticity(driver);
	  sm.doSearch(src1,dest1,d1,testLog);
	  sm.invalidDates(src2, dest2, d2, testLog);
	  Assert.assertEquals(driver.getTitle(),"Please help us with a little more information" );
	  
  }
  
  @Test(priority=6,dataProvider = "dp2")
  public void searchSameSrcDest(String src1, String dest1,String d1,String src2,String dest2, String d2) throws Exception {
	  
	 driver.get(prop.getProperty("url"));
	 driver.manage().window().maximize();
	  //driver.get("https://www.expedia.co.in/Flights");
	  SearchMulticity sm=new SearchMulticity(driver);
	  sm.samesrcdest(src1, dest1, d1, testLog);
	 // sm.doSearch2(src2, dest2, d2, testLog);
	  Assert.assertEquals(driver.getTitle(),"Expedia Travel: Vacations, Cheap Flights, Airline Tickets & Airfares");
  }
  
  
  @DataProvider
	public Object[][] dp() throws Exception, IOException {
		ExcelReader ex=new ExcelReader("C:\\\\Users\\\\Jasmine\\\\Desktop\\\\data.xls");
		int rows=ex.getRowNum("Sheet2");
		int cols=ex.getColNum("Sheet2");
		
		Object data[][]=new Object[rows-1][cols];
		for(int i=1;i<rows;i++) {
			
			data[i-1][0]=ex.getCellData("Sheet2", i, 0);
			data[i-1][1]=ex.getCellData("Sheet2", i, 1);
			data[i-1][2]=ex.getCellData("Sheet2", i, 2);
			data[i-1][3]=ex.getCellData("Sheet2", i, 3);
			data[i-1][4]=ex.getCellData("Sheet2", i, 4);
			data[i-1][5]=ex.getCellData("Sheet2", i, 5);
			
		}
		
  return data;
	}
  
  @DataProvider
	public Object[][] dp1() throws Exception, IOException {
		ExcelReader ex=new ExcelReader("C:\\\\Users\\\\Jasmine\\\\Desktop\\\\data.xls");
		int rows=ex.getRowNum("Sheet3");
		int cols=ex.getColNum("Sheet3");
		
		Object data[][]=new Object[rows-1][cols];
		for(int i=1;i<rows;i++) {
			
			data[i-1][0]=ex.getCellData("Sheet3", i, 0);
			data[i-1][1]=ex.getCellData("Sheet3", i, 1);
			data[i-1][2]=ex.getCellData("Sheet3", i, 2);
			data[i-1][3]=ex.getCellData("Sheet3", i, 3);
			data[i-1][4]=ex.getCellData("Sheet3", i, 4);
			data[i-1][5]=ex.getCellData("Sheet3", i, 5);
			
		}
		
return data;
	}
  @DataProvider
	public Object[][] dp2() throws Exception, IOException {
		ExcelReader ex=new ExcelReader("C:\\\\Users\\\\Jasmine\\\\Desktop\\\\data.xls");
		int rows=ex.getRowNum("Sheet4");
		int cols=ex.getColNum("Sheet4");
		
		Object data[][]=new Object[rows-1][cols];
		for(int i=1;i<rows;i++) {
			
			data[i-1][0]=ex.getCellData("Sheet4", i, 0);
			data[i-1][1]=ex.getCellData("Sheet4", i, 1);
			data[i-1][2]=ex.getCellData("Sheet4", i, 2);
			data[i-1][3]=ex.getCellData("Sheet4", i, 3);
			data[i-1][4]=ex.getCellData("Sheet4", i, 4);
			data[i-1][5]=ex.getCellData("Sheet4", i, 5);
			
		}
		
return data;
	}
  
  @DataProvider
	public Object[][] dp3() throws Exception, IOException {
		ExcelReader ex=new ExcelReader("C:\\\\Users\\\\Jasmine\\\\Desktop\\\\data.xls");
		int rows=ex.getRowNum("Sheet5");
		int cols=ex.getColNum("Sheet5");
		
		Object data[][]=new Object[rows-1][cols];
		for(int i=1;i<rows;i++) {
			
			data[i-1][0]=ex.getCellData("Sheet5", i, 0);
			data[i-1][1]=ex.getCellData("Sheet5", i, 1);
			data[i-1][2]=ex.getCellData("Sheet5", i, 2);
			data[i-1][3]=ex.getCellData("Sheet5", i, 3);
			data[i-1][4]=ex.getCellData("Sheet5", i, 4);
			data[i-1][5]=ex.getCellData("Sheet5", i, 5);
			data[i-1][6]=ex.getCellData("Sheet5", i, 6);
			data[i-1][7]=ex.getCellData("Sheet5", i, 7);
			data[i-1][8]=ex.getCellData("Sheet5", i, 8);
			data[i-1][9]=ex.getCellData("Sheet5", i, 9);
			data[i-1][10]=ex.getCellData("Sheet5", i, 10);
			
		}
		
return data;
	}

  @DataProvider
	public Object[][] dp4() throws Exception, IOException {
		ExcelReader ex=new ExcelReader("C:\\\\Users\\\\Jasmine\\\\Desktop\\\\data.xls");
		int rows=ex.getRowNum("Sheet6");
		int cols=ex.getColNum("Sheet6");
		
		Object data[][]=new Object[rows-1][cols];
		for(int i=1;i<rows;i++) {
			
			data[i-1][0]=ex.getCellData("Sheet6", i, 0);
			data[i-1][1]=ex.getCellData("Sheet6", i, 1);
			data[i-1][2]=ex.getCellData("Sheet6", i, 2);
			data[i-1][3]=ex.getCellData("Sheet6", i, 3);
			data[i-1][4]=ex.getCellData("Sheet6", i, 4);
			data[i-1][5]=ex.getCellData("Sheet6", i, 5);
			data[i-1][6]=ex.getCellData("Sheet6", i, 6);
			data[i-1][7]=ex.getCellData("Sheet6", i, 7);
			data[i-1][8]=ex.getCellData("Sheet6", i, 8);
			data[i-1][9]=ex.getCellData("Sheet6", i, 9);
			data[i-1][10]=ex.getCellData("Sheet6", i, 10);
			
		}
		
return data;
	}


}

package returnTestRunner;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import returnPom.ContinueBooking;
import returnPom.Payment;
import returnPom.SearchReturn;
import returnPom.SelectReturn;
import utils.Base;
import utils.ExcelReader;


public class SearchReturnTest extends Base{
	

  @Test(priority=1,dataProvider = "dp")
  public void searchReturnForm(String src, String dest,String d1, String d2) throws Exception { 
	  	driver.get(prop.getProperty("url"));
	  	SearchReturn ex = new SearchReturn(driver);
	  	ex.doSearch(src, dest,d1,d2, testLog);	
	  	Assert.assertEquals(driver.getTitle(),"BOM to CCU Flights | Expedia" );
  }
  
  
  @Test(priority=2)
  public void selectFlights() throws Exception {
	  SelectReturn ex1=new SelectReturn(driver);
	  ex1.doSelectFlights(testLog);
	  ContinueBooking ex2= new ContinueBooking(driver);
	  ex2.doContinue(testLog);
	  Assert.assertEquals(driver.getTitle(),"Expedia: Payment" );
  }
  
  @Test(priority=3,dataProvider="dp1")
  public void paymentValid(String surname,String name, String number, String cardnumber, String seccode, String address,String city, String postcode, String email, String pass, String cpass) throws Exception {
	  Payment p=new Payment(driver);
	  p.doPayment(surname, name, number, cardnumber, seccode, address, city, postcode, email, pass, cpass,testLog);
	  Assert.assertEquals(driver.getTitle(),"Expedia: Payment" );
  }
 
 
  @Test(priority=4,dataProvider="dp2")
  public void paymentInvalid(String surname,String name, String number, String cardnumber, String seccode, String address,String city, String postcode, String email, String pass, String cpass) throws Exception {
	  driver.get("https://www.expedia.co.in/Checkout/V1/FlightCheckout?tripid=b3bfdd22-bb9b-517c-92f6-a4879e53f022&c=30860264-5104-4ec0-bc88-3ef00c9b8291");
	  Payment p=new Payment(driver);
	  p.doPayment(surname, name, number, cardnumber, seccode, address, city, postcode, email, pass, cpass,testLog);
	  Assert.assertEquals(driver.getTitle(),"Expedia: Payment" );
  }

  @Test(priority=5,dataProvider = "dp3")
  public void searchsamesrcdest(String src, String dest, String d1,String d2) throws Exception { 
	  	driver.get(prop.getProperty("url"));
	  	SearchReturn ex = new SearchReturn(driver);
	  	ex.samesrcdest(src, dest, d1, d2, testLog);
  	Assert.assertEquals(driver.getTitle(),"Expedia Travel: Vacations, Cheap Flights, Airline Tickets & Airfares");
	  	
  }

  @Test(priority=6,dataProvider = "dp4")
  public void searchInvalidDest(String src, String dest,String d1,String d2) throws Exception {  
	  	driver.get(prop.getProperty("url"));
		SearchReturn ex = new SearchReturn(driver);
		ex.invalidDest(src, dest, d1, d2, testLog);
	Assert.assertEquals(driver.getTitle(),"Please help us with a little more information" );
	}

  
  @DataProvider
 	public Object[][] dp() throws Exception, IOException {
 		ExcelReader ex=new ExcelReader("C:\\\\\\\\Users\\\\\\\\Jasmine\\\\\\\\Desktop\\\\\\\\dataPro.xlsx");
 		int rows=ex.getRowNum("Sheet1");
 		int cols=ex.getColNum("Sheet1");
 		
 		Object data[][]=new Object[rows-1][cols];
 		for(int i=1;i<rows;i++) {
 			
 			data[i-1][0]=ex.getCellData("Sheet1", i, 0);
 			data[i-1][1]=ex.getCellData("Sheet1", i, 1);	
 			data[i-1][2]=ex.getCellData("Sheet1", i, 2);	
 			data[i-1][3]=ex.getCellData("Sheet1", i, 3);	
 		}		
   return data;
 	}

  @DataProvider
	public Object[][] dp1() throws Exception, IOException {
		ExcelReader ex=new ExcelReader("C:\\\\\\\\Users\\\\\\\\Jasmine\\\\\\\\Desktop\\\\\\\\dataPro.xlsx");
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
			data[i-1][6]=ex.getCellData("Sheet4", i, 6);
			data[i-1][7]=ex.getCellData("Sheet4", i, 7);
			data[i-1][8]=ex.getCellData("Sheet4", i, 8);
			data[i-1][9]=ex.getCellData("Sheet4", i, 9);
			data[i-1][10]=ex.getCellData("Sheet4", i, 10);
			
		}
		
return data;
	}


  @DataProvider
	public Object[][] dp2() throws Exception, IOException {
		ExcelReader ex=new ExcelReader("C:\\\\\\\\Users\\\\\\\\Jasmine\\\\\\\\Desktop\\\\\\\\dataPro.xlsx");
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
 	public Object[][] dp3() throws Exception, IOException {
 		ExcelReader ex=new ExcelReader("C:\\\\\\\\Users\\\\\\\\Jasmine\\\\\\\\Desktop\\\\\\\\dataPro.xlsx");
 		int rows=ex.getRowNum("Sheet2");
 		int cols=ex.getColNum("Sheet2");
 		
 		Object data[][]=new Object[rows-1][cols];
 		for(int i=1;i<rows;i++) {
 			
 			data[i-1][0]=ex.getCellData("Sheet2", i, 0);
 			data[i-1][1]=ex.getCellData("Sheet2", i, 1);
 			data[i-1][2]=ex.getCellData("Sheet2", i, 2);	
 			data[i-1][3]=ex.getCellData("Sheet2", i, 3);
 		}
   return data;
 	}
  
  
  @DataProvider
	public Object[][] dp4() throws Exception, IOException {
		ExcelReader ex=new ExcelReader("C:\\\\Users\\\\Jasmine\\\\Desktop\\\\dataPro.xlsx");
		int rows=ex.getRowNum("Sheet3");
		int cols=ex.getColNum("Sheet3");
		
		Object data[][]=new Object[rows-1][cols];
		for(int i=1;i<rows;i++) {
			
			data[i-1][0]=ex.getCellData("Sheet3", i, 0);
			data[i-1][1]=ex.getCellData("Sheet3", i, 1);
			data[i-1][2]=ex.getCellData("Sheet3", i, 2);
			data[i-1][3]=ex.getCellData("Sheet3", i, 3);
			
		}
		
return data;
	}
  
  
}

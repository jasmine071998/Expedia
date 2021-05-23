package onewayTestRunner;
import java.io.IOException;
import multicityPom.ContinueBooking;
import multicityPom.Payment;

import org.testng.Assert;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import onewayPom.SearchOneway;
import onewayPom.SelectOneway;
import utils.Base;
import utils.ExcelReader;
public class ExcelCombine extends Base{
  @Test(priority=1,dataProvider = "dp")
  public void Searchflights(String src , String des,String d1) throws Exception {
	//Mumbai Delhi
	  driver.get(prop.getProperty("url"));
	  SearchOneway sf=new SearchOneway(driver);
	  sf.doSearchSrc(src,testLog);
	  sf.doSearchDes(des,testLog);  
	  sf.doMenu(); 
	  sf.doSearchEco();
	  sf.doFlightDate(d1); 
	  sf.doflightSearch();	
	  Assert.assertEquals(driver.getTitle(),"BOM to DEL Flights | Expedia" );
  }
  
  
  @Test(priority=2)
  public void Selectflights() throws Exception {
	
	  SelectOneway sp=new SelectOneway(driver);
	  sp.doflightSelect();
	  sp.donothankspopup() ;
	  ContinueBooking cb=new ContinueBooking(driver);
	  cb.continuebooking(testLog);
	  Assert.assertEquals(driver.getTitle(),"Expedia: Payment" );
  }
 
 


  
  @Test(priority=6,dataProvider = "dp1")
  public void Searchflights1(String src , String des1) throws Exception {
	//Mumbai,12
	  driver.get(prop.getProperty("url"));
	  SearchOneway sf=new SearchOneway(driver);
	 
	  sf.doSearchSrc(src,testLog);
	  sf.doSearchDes1(des1,testLog);
	  sf.doflightSearch();	
	  Assert.assertEquals(driver.getTitle(),"Please help us with a little more information" );
	
  }
  @Test(priority=7,dataProvider = "dp2")
  public void Searchflights2(String src , String des2) throws Exception {
	//Mumbai,Mumbai
	  driver.get(prop.getProperty("url"));
	  SearchOneway sf=new SearchOneway(driver);
	 
	  sf.doSearchSrc(src,testLog);
	  sf.doSearchDes2(des2,testLog);
	  sf.doflightSearch();	
	  Assert.assertEquals(driver.getTitle(),"Expedia Travel: Vacations, Cheap Flights, Airline Tickets & Airfares" );
	
  }
  
  @Test(priority=8,dataProvider = "dp3")
  public void Searchflights3(String src , String des3) throws Exception {
	////Mumbai,123
	  driver.get(prop.getProperty("url"));
	  SearchOneway sf=new SearchOneway(driver);
	 
	  sf.doSearchSrc(src,testLog);
	  sf.doSearchDes3(des3,testLog);
	  sf.doflightSearch();	
	  Assert.assertEquals(driver.getTitle(),"Please help us with a little more information" );
  }  
  

  @Test(priority=3,dataProvider="dp11")
  public void paymentValid(String surname,String name, String number, String cardnumber, String seccode, String address,String city, String postcode, String email, String pass, String cpass) throws Exception {
	  Payment p=new Payment(driver);
	  p.doPayment(surname, name, number, cardnumber, seccode, address, city, postcode, email, pass, cpass,testLog);
	//  Assert.assertEquals(driver.getTitle(),"Expedia: Payment" );
  }
  
  @Test(priority=4,dataProvider="dp22")
  public void paymentInvalid(String surname,String name, String number, String cardnumber, String seccode, String address,String city, String postcode, String email, String pass, String cpass) throws Exception {
	  driver.get("https://www.expedia.co.in/Checkout/V1/FlightCheckout?tripid=b3bfdd22-bb9b-517c-92f6-a4879e53f022&c=30860264-5104-4ec0-bc88-3ef00c9b8291");
	  Payment p=new Payment(driver);
	  p.doPayment(surname, name, number, cardnumber, seccode, address, city, postcode, email, pass, cpass,testLog);
	 // Assert.assertEquals(driver.getTitle(),"Expedia: Payment" );
  }



	
  

  @DataProvider
	public Object[][] dp11() throws Exception, IOException {
		ExcelReader ex=new ExcelReader("C:\\\\Users\\\\Jasmine\\\\Desktop\\\\dataArv (1).xlsx");
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
	public Object[][] dp22() throws Exception, IOException {
		ExcelReader ex=new ExcelReader("C:\\\\Users\\\\Jasmine\\\\Desktop\\\\dataArv (1).xlsx");
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
  public Object[][] dp() throws Exception, IOException {
		ExcelReader ex=new ExcelReader("//C:\\Users\\Jasmine\\Desktop\\BookEx.xlsx");
		int rows=ex.getRowNum("Sheet1");
		int cols=ex.getColNum("Sheet1");
		
		Object data[][]=new Object[rows-1][cols];
		for(int i=1;i<rows;i++) {
			
			data[i-1][0]=ex.getCellData("Sheet1", i, 0);
			data[i-1][1]=ex.getCellData("Sheet1", i, 1);
			data[i-1][2]=ex.getCellData("Sheet1", i, 2);
			//data[i-1][3]=ex.getCellData("Sheet1", i, 3);
			
		}
		
return data;
	}

  @DataProvider
  public Object[][] dp1() throws Exception, IOException {
		ExcelReader ex=new ExcelReader("//C:\\Users\\Jasmine\\Desktop\\BookEx.xlsx");
		int rows=ex.getRowNum("Sheet2");
		int cols=ex.getColNum("Sheet2");
		
		Object data[][]=new Object[rows-1][cols];
		for(int i=1;i<rows;i++) {
			
			data[i-1][0]=ex.getCellData("Sheet2", i, 0);
			data[i-1][1]=ex.getCellData("Sheet2", i, 1);
		
			
		}
		
return data;
	}


@DataProvider
public Object[][] dp2() throws Exception, IOException {
		ExcelReader ex=new ExcelReader("//C:\\Users\\Jasmine\\Desktop\\BookEx.xlsx");
		int rows=ex.getRowNum("Sheet3");
		int cols=ex.getColNum("Sheet3");
		
		Object data[][]=new Object[rows-1][cols];
		for(int i=1;i<rows;i++) {
			
			data[i-1][0]=ex.getCellData("Sheet3", i, 0);
			data[i-1][1]=ex.getCellData("Sheet3", i, 1);
		
			
		}
		
return data;
	}
@DataProvider
public Object[][] dp3() throws Exception, IOException {
		ExcelReader ex=new ExcelReader("//C:\\Users\\Jasmine\\Desktop\\BookEx.xlsx");
		int rows=ex.getRowNum("Sheet4");
		int cols=ex.getColNum("Sheet4");
		
		Object data[][]=new Object[rows-1][cols];
		for(int i=1;i<rows;i++) {
			
			data[i-1][0]=ex.getCellData("Sheet4", i, 0);
			data[i-1][1]=ex.getCellData("Sheet4", i, 1);
		}
		
return data;
	}
}





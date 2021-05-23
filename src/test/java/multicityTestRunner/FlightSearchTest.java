package multicityTestRunner;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import multicityPom.FlightSearchPage;
import utils.Base;
import utils.ExcelReader;
@Listeners()
public class FlightSearchTest extends Base {
	@Test(priority=1,dataProvider = "dp")
	public void flightSearchForm(String src1, String dest1,String src2,String dest2) {

		driver.get(prop.getProperty("url"));
		FlightSearchPage fp = new FlightSearchPage(driver);
		fp.doSearch(src1, testLog);
		
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
				
			}
			
	  return data;
		}

	
	
}
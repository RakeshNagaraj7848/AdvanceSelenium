package practise.testng.dataprovider;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GeTProductInfoTest {
	
	@DataProvider
	public Object[][] getData()
	{
		
		Object[][] objArr = new Object[3][3];		
		objArr[0][0]="ramesh";
		objArr[0][1]="hr";
		objArr[0][2]=8976654545l;
		
		objArr[1][0]="monesh";
		objArr[1][1]="manager";	
		objArr[1][2]=8976654552l;
		
		
		objArr[2][0]="monesh1";
		objArr[2][1]="manager";	
		objArr[2][2]=8976654552l;
		return objArr;	
	}
	
	@Test(dataProvider="getData")
	public void getProductInfoTest()
	{
		WebDriver driver = new ChromeDriver();
	
		
	}
	
	
	
	

}

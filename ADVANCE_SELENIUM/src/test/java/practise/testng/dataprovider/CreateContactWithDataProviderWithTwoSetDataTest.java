package practise.testng.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContactWithDataProviderWithTwoSetDataTest {
	
	@DataProvider
	public Object[][] getData()
	{
		
		Object[][] objArr = new Object[2][2];		
		objArr[0][0]="ramesh";
		objArr[0][1]="hr";
		
		objArr[1][0]="monesh";
		objArr[1][1]="manager";	
		
		return objArr;	
	}
	
	@Test(dataProvider="getData")
	public void craerteContact(String firstName,String designation)
	{
		System.out.println(" first name "+" : "+firstName+" "+"designation"+" : "+designation);
	}
	
	
	
	

}

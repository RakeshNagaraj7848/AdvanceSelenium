package practise.testng;

import org.testng.annotations.Test;

public class PriorityOrgTest {
	
	
	@Test
	public void crateAccountTest()
	{  
		System.out.println("crateAccountTest executed ");
//		String s = null;
//		System.out.println(s.length());
	}
	
	
	// @Ignore 
	@Test(dependsOnMethods="crateAccountTest")
	public void modifyAccountTest()
	{
		System.out.println("modifyAccountTest executed ");
	}
	
	@Test(dependsOnMethods="modifyAccountTest")
	public void deleteAccountTest()
	{
		System.out.println("deleteAccountTest executed ");
	}

}

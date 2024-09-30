package practise.testng;

import org.testng.annotations.Test;

public class InvocationCountOrgTest {
	
	
	@Test(invocationCount=10)
	public void crateAccountTest()
	{  
		System.out.println("crateAccountTest executed ");
	}
	
	
	
	@Test(enabled=false)
	public void modifyAccountTest()
	{
		System.out.println("modifyAccountTest executed ");
	}
	
	@Test(enabled=true)
	public void deleteAccountTest()
	{
		System.out.println("deleteAccountTest executed ");
	}

}

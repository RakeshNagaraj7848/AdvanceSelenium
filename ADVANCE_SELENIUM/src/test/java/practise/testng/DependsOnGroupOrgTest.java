package practise.testng;

import org.testng.annotations.Test;

public class DependsOnGroupOrgTest {
	
	
	@Test(priority=1)
	public void crateAccountTest()
	{
		System.out.println("crateAccountTest executed ");
	}
	@Test(priority=2)
	public void modifyAccountTest()
	{
		System.out.println("modifyAccountTest executed ");
	}
	@Test(priority=3)
	public void deleteAccountTest()
	{
		System.out.println("deleteAccountTest executed ");
	}

}

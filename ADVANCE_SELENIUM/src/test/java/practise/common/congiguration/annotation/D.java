package practise.common.congiguration.annotation;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class D {
	
	@BeforeSuite
	public void bsConfig1()
	{
		System.out.println(" BeforeSuite1 of class2");
	}
	@BeforeSuite
	public void bsConfig2()
	{
		System.out.println(" BeforeSuite2  of class2");
	}
	
	
	
	
	@AfterSuite
	public void asConfig1()
	{
		System.out.println(" AfterSuite1  of class2");
	}
	@AfterSuite
	public void asConfig2()
	{
		System.out.println(" AfterSuite2  of class2");
	}
	
	
	
	
	@BeforeClass
	public void bcConfig1()
	{
		System.out.println(" BeforeClass1  of class2");
	}
	
	
	
	@BeforeClass
	public void bcConfig2()
	{
		System.out.println(" BeforeClass2  of class2");
	}
	                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
	@AfterClass                   
	public void acConfig1()
	{
		System.out.println(" AfterClass1  of class2");
	}
	
	@AfterClass
	public void acConfig2()
	{
		System.out.println(" AfterClass2  of class2");
	}
	
	
	@BeforeMethod
	public void bmConfig1()
	{
		System.out.println(" BeforeMethod1  of class2");
	}
	
	
	@BeforeMethod
	public void bmConfig2()
	{
		System.out.println(" BeforeMethod2  of class2");
	}
	
	@AfterMethod
	public void amConfig1()
	{
		System.out.println(" AfterMethod1  of class2");
	}
	@AfterMethod
	public void amConfig2()
	{
		System.out.println(" AfterMethod2  of class2");
	}
	
	@Test
	public void createOrg()
	{
		System.out.println(" createOrg   of class2");
	}
	
	@Test
	public void modifyOrg()
	{
		System.out.println(" modifyOrg  of class2");
	}
	@Test
	public void deleteOrg()
	{
		System.out.println("deleteOrg  of class2");
	}

}

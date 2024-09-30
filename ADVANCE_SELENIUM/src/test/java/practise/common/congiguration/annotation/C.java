package practise.common.congiguration.annotation;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class C {
	
	@BeforeSuite
	public void bsConfig1()
	{
		System.out.println(" BeforeSuite1  of class1 ");
	}
	@BeforeSuite
	public void bsConfig2()
	{
		System.out.println(" BeforeSuite2 of class1");
	}
	
	
	
	
	@AfterSuite
	public void asConfig1()
	{
		System.out.println(" AfterSuite1 of class1");
	}
	@AfterSuite
	public void asConfig2()
	{
		System.out.println(" AfterSuite2 of class1");
	}
	
	
	
	
	@BeforeClass
	public void bcConfig1()
	{
		System.out.println(" BeforeClass1 of class1");
	}
	
	
	
	@BeforeClass
	public void bcConfig2()
	{
		System.out.println(" BeforeClass2 of class1");
	}
	
	
	@AfterClass
	public void acConfig1()
	{
		System.out.println(" AfterClass1of class1 ");
	}
	
	@AfterClass
	public void acConfig2()
	{
		System.out.println(" AfterClass2 of class1");
	}
	
	
	@BeforeMethod
	public void bmConfig1()
	{
		System.out.println(" BeforeMethod1 of class1");
	}
	
	
	@BeforeMethod
	public void bmConfig2()
	{
		System.out.println(" BeforeMethod2 of class1");
	}
	
	@AfterMethod
	public void amConfig1()
	{
		System.out.println(" AfterMethod1 of class1");
	}
	@AfterMethod
	public void amConfig2()
	{
		System.out.println(" AfterMethod2 of class1");
	}
	
	@Test
	public void createContact()
	{
		System.out.println(" createContact of class1");
	}
	
	@Test
	public void modifyContact()
	{
		System.out.println(" modifyContact of class1");
	}
	@Test
	public void deleteContact()
	{
		System.out.println("deleteContact of class1");
	}

}

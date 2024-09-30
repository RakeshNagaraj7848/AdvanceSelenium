package practise.common.congiguration.annotation;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class A {
	@Test
	public void m1()
	{
		System.out.println("class A  m1  test method");
		
	}
	@BeforeClass
	public void bc1()
	{
		System.out.println("@BeforeClass  bc1 in class A");
	}
	
	@Test
	public void multiply()
	{
		System.out.println("multiply() test method  in  class");
	}
	@AfterMethod
	public void am1()
	{
		System.out.println("@AfterMethod  am1 in class A");
	}
	@BeforeClass
	public void bc2()
	{
		System.out.println("@BeforeClass  bc2 in class A");
	}
	
	
	@Test
	public void delete()
	{
		System.out.println("delete() test method  in  class");
	}
	
	@AfterSuite
	public void as1()
	{
		System.out.println("@AfterSuite  as1 in class A");
	}
	@BeforeMethod
	public void bm1()
	{
		System.out.println("@BeforeMethod  bm1 in class A");
	}
	@BeforeSuite	
	public void bs1()
	{
		System.out.println("@BeforeSuite  bs1 in class A");
	}
	@Test
	public void add()
	{
		System.out.println(" add() test method  in  class");
	}
	@Test
	public void sub()
	{
		System.out.println("sub() test method  in  class");
	}
	

}

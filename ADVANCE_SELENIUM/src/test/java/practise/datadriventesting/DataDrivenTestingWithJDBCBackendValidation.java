package practise.datadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class DataDrivenTestingWithJDBCBackendValidation {
	@Test
	public void backEndDataValidation() throws SQLException, InterruptedException
	{
		
		// creating application in GUI
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://106.51.90.215:8084/");
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		driver.findElement(By.linkText("Projects")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		
		WebElement projectName=driver.findElement(By.name("projectName"));
		projectName.sendKeys("evartadmin");
		String expectedProjectName=projectName.getAttribute("value");
		
		

		
		driver.findElement(By.name("createdBy")).sendKeys("Rakesh");
		WebElement projectStatusDropDown=driver.findElement(By.name("status"));
		Select s = new Select(projectStatusDropDown);
		s.selectByVisibleText("Created");
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		Thread.sleep(2000);
		driver.close();
		
		
		// validating created project in backend
		Connection con=null;
		
		boolean flag=false;
		try
		{
		Driver driver1 = new Driver();
		DriverManager.registerDriver(driver1);
		con=DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects","root@%","root");
		Statement stat=con.createStatement();
		String sqlQuery= "select * from project;";
		ResultSet resultset=stat.executeQuery(sqlQuery);
		while(resultset.next())
		{
			String actualProjectName=resultset.getString(4);
			if(actualProjectName.equals(expectedProjectName))
			{
				flag=true;
				System.out.println(expectedProjectName+" is found in database-----test pass");
			}
		}
		if(flag==false)
		{
			System.out.println(expectedProjectName+" is not  found in databas-----test faile");
		}
		}
		catch(Exception e )
		{
			System.out.println(" expecton handled successsfully");
		}
		finally
		{
			con.close();		
		}
		
		
	}

}

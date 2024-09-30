package practise.genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateContactWithOrganisationSwitchingContact {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		// craete organisation
		
		FileInputStream fis = new FileInputStream("C:\\Users\\Admin\\OneDrive\\Desktop\\commondata.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		String USERNAME =pObj.getProperty("username");
		String PASSWORD =pObj.getProperty("password");
		String URL =pObj.getProperty("url");
		String BROWSER = pObj.getProperty("browser");
		
		
		
		Random random = new Random();
		int randomInt= random.nextInt(10000);
		FileInputStream fis1 = new FileInputStream("C:\\Users\\Admin\\OneDrive\\Desktop\\testscriptdata.xlsx");
		Workbook wb=WorkbookFactory.create(fis1);
		Sheet sh=wb.getSheet("org");
		Row row =sh.getRow(5);
		Cell cell=row.getCell(2);
		String orgName=cell.toString()+randomInt;
		Sheet sh1=wb.getSheet("contact");
		Row row1 =sh1.getRow(1);
		Cell cell1=row1.getCell(2);
		String lastName=cell1.toString()+randomInt;
		wb.close();
		
		
		
		
		WebDriver driver=null;
		if(BROWSER.equals("chrome"))
		{
			Thread.sleep(2000);
			driver= new ChromeDriver();
		}
		else
		{ 	Thread.sleep(2000);
			driver= new FirefoxDriver();
		}
		driver.get(URL);
		Thread.sleep(2000);
		Thread.sleep(2000);
		
		// step1 : login
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		Thread.sleep(2000);
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(2000);
		
		
		// step2 navigate to organisation module
		driver.findElement(By.linkText("Organizations")).click();
		Thread.sleep(2000);
		
		
		// step 3 clcik on create  organisation module
		driver.findElement(By.xpath(" //img[@alt=\"Create Organization...\"]")).click();
		

		
		// 4.enter all details and create new organisation
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.xpath("(//input[@title=\"Save [Alt+S]\"])[1]")).click();
		
		
		w.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@class='dvHeaderText']"))));
		
		
	  //   step 5  verify organisation header name
		String actualOrgHeaderName=driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
		if(actualOrgHeaderName.contains(orgName))
		{
			System.out.println(orgName+ "is craered sucessfull  test =pass");
		}
		else
	
			{
				System.out.println(orgName+ "is  not craered sucessfull  test =fail");
			}
		
		
		// step65  verify organisation name
		
		
		String  actualOrgName=driver.findElement(By.id("mouseArea_Organization Name")).getText();
		
		
		if(actualOrgName.contains(orgName))
		{
			System.out.println(orgName+ "is craered sucessfull  test =pass");
		}
		else
	
			{
				System.out.println(orgName+ "is  not craered sucessfull  test =fail");
			}
		
		driver.findElement(By.linkText("Contacts")).click();
		Thread.sleep(2000);
		
		
		// step 3 click on create  Contact  module
		driver.findElement(By.xpath(" //img[@alt=\"Create Contact...\"]")).click();
		

		
		// 4.enter all details and create new contact
		driver.findElement(By.name("lastname")).sendKeys(lastName);
	//  enter organisation name 
		
			driver.findElement(By.xpath("//input[@name=\"account_name\"]/following-sibling::img")).click();
			
		// switch to windows
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it =set.iterator();
		while(it.hasNext())
		{
			String windowId=it.next();
			driver.switchTo().window(windowId);
			String actualURL=driver.getCurrentUrl();
			if(actualURL.contains("module=Accounts&action"))
			{
				break;
			}
		}
		
		
		driver.findElement(By.name("search_text")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		
		
		
		// switch to parent window
		Set<String> set1 = driver.getWindowHandles();
		Iterator<String> it1 =set1.iterator();
		while(it1.hasNext())
		{
			String windowId=it1.next();
			driver.switchTo().window(windowId);
			String actualURL=driver.getCurrentUrl();
			if(actualURL.contains("module=Contacts&action"))
			{
				break;
			}
		}
		
		
		
		
		
		
		
		
		driver.findElement(By.xpath("(//input[@title=\"Save [Alt+S]\"])[1]")).click();
		
		
		w.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@class='dvHeaderText']"))));
		
		
	  //   step 5  verify contact  header name
		String actualContactHeaderName=driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
		if(actualContactHeaderName.contains(lastName))
		{
			System.out.println(lastName+ "is craered sucessfull  test =pass");
		}
		else
	
			{
				System.out.println(lastName+ "is  not craered sucessfull  test =fail");
			}
		
		
		// step65  verify lastname 
		
		
		String  actualLastName=driver.findElement(By.id("dtlview_Last Name")).getText();
		
		
		if(actualLastName.contains(lastName))
		{
			System.out.println(lastName+ "is craered sucessfull  test =pass");
		}
		else
	
			{
				System.out.println(lastName+ "is  not craered sucessfull  test =fail");
			}
		
		
		// step7 logout
		
		
		Actions a1 = new Actions(driver);
		a1.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.xpath("//a[@href='index.php?module=Users&action=Logout']")).click();
		
		
		
		
		driver.quit();
		
		
		
		
		
		
		
		
		
		
		
		

	}
}

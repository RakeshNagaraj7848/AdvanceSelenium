package practise.genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateOrganisationWithIndustryAndType {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
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
		String industry=row.getCell(3).toString();
		String type=row.getCell(4).toString();
		
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
		
		
		
		
		
		// select indusry drop down
		
		WebElement industryDropDown = driver.findElement(By.name("industry"));
		Select s = new Select(industryDropDown);
		s.selectByVisibleText(industry);
		
		
		// select typedrop down
		
				WebElement typeDropDown = driver.findElement(By.name("accounttype"));
				Select s1 = new Select(typeDropDown);
				s1.selectByVisibleText(type);
		
		// click on save button
		
		driver.findElement(By.xpath("(//input[@title=\"Save [Alt+S]\"])[1]")).click();
		
		
		w.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@class='dvHeaderText']"))));
		
		
	  //   step 5  verify industry  name
		String actualIndustryName=driver.findElement(By.id("mouseArea_Industry")).getText();
		if(actualIndustryName.contains(industry))
		{
			System.out.println(industry+ "is craered sucessfull  test =pass");
		}
		else
	
			{
				System.out.println(industry+ "is  not craered sucessfull  test =fail");
			}
		
		
		// step65  verify type  name
		
		
		String  actualTypeName=driver.findElement(By.id("mouseArea_Type")).getText();
		
		
		if(actualTypeName.equals(type))
		{
			System.out.println(type+ "is craered sucessfull  test =pass");
		}
		else
	
			{
				System.out.println(type+ "is  not craered sucessfull  test =fail");
			}
		
		
		// step7 logout
		
		
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.xpath("//a[@href='index.php?module=Users&action=Logout']")).click();
		
		
		
		
		driver.quit();
		
		
		
		
		
		
		
		
		
		
		
		

	}
}

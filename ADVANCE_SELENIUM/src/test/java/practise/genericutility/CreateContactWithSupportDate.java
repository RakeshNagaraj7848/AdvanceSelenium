package practise.genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

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

public class CreateContactWithSupportDate {

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
		Sheet sh=wb.getSheet("contact");
		Row row =sh.getRow(1);
		Cell cell=row.getCell(2);
		String lastName=cell.toString()+randomInt;
		wb.close();
		
		
		// today date capture in yyyy-mm-dd format
				Date dateObj = new Date();
				SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
				String actualDate=sim.format(dateObj);
				
				
				
				// capture date after 30 days from today
				
				Calendar cal=sim.getCalendar();
				cal.add(Calendar.DAY_OF_MONTH, 30);
				String dateRequired=sim.format(cal.getTime());
		
		
		
		
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
		
		
		// step2 navigate to Contacts module
		driver.findElement(By.linkText("Contacts")).click();
		Thread.sleep(2000);
		
		
		// step 3 click on create  Contact  module
		driver.findElement(By.xpath(" //img[@alt=\"Create Contact...\"]")).click();
		

		
		// 4.enter all details and create new contact
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		
		
		
		//  support  start date enter 
		
		
		driver.findElement(By.name("support_start_date")).clear();
		driver.findElement(By.name("support_start_date")).sendKeys(actualDate);
		 
		
	//  support  end date enter 
		
		
			driver.findElement(By.name("support_end_date")).clear();
			driver.findElement(By.name("support_end_date")).sendKeys(dateRequired);
			 
		
		
		
		
		
		driver.findElement(By.xpath("(//input[@title=\"Save [Alt+S]\"])[1]")).click();
		
		
		w.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@class='dvHeaderText']"))));
		
		
	  //   step 5  verify actual date 
		String actualDateFound=driver.findElement(By.id("dtlview_Support Start Date")).getText();
		if(actualDateFound.equals(actualDate))
		{
			System.out.println(" contact created with his a support date"+actualDate+ " sucessfully  test =pass");
		}
		else
	
			{
				System.out.println(" contact not created with this "+actualDate+ "  sucessfully  test =fail");
			}
		
		

		  //   step 5  verify actual date  after 30 days
			String actualDateAfter30Days=driver.findElement(By.id("dtlview_Support End Date")).getText();
			if(actualDateAfter30Days.equals(dateRequired))
			{
				System.out.println(" contact created with his a end support date"+dateRequired+ " sucessfully  test =pass");
			}
			else
		
				{
				System.out.println(" contact not created with this "+dateRequired+ "  end support date  sucessfully  test =fail");
				}
		
		
		// step7 logout
		
		
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.xpath("//a[@href='index.php?module=Users&action=Logout']")).click();
		
		
		
		
		driver.quit();
	}
}

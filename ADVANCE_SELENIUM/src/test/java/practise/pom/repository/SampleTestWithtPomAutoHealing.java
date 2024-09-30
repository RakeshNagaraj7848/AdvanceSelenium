package practise.pom.repository;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class SampleTestWithtPomAutoHealing {
	
	
	
	@FindBy(name="user_name")
	WebElement ele1;
	@FindBy(name="user_password")
	WebElement ele2;
//	@FindAll({@FindBy(id="submitButton1"),@FindBy(xpath="//div[@class='button']/input[@value='Login']")})
//	WebElement ele3;
	
	
	@FindBys({@FindBy(id="submitButton"),@FindBy(xpath="//div[@class='button']/input[@value='Login']")})
	WebElement ele3;
	
    @Test
	public void Test() {
		// TODO Auto-generated method stub
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888/");
		SampleTestWithtPomAutoHealing s =PageFactory.initElements(driver, SampleTestWithtPomAutoHealing.class);
		s.ele1.sendKeys("admin");
		s.ele2.sendKeys("admin");
		s.ele3.click();

	}

}

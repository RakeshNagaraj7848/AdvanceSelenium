package practise.pom.repository;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SampleTestWithoutPom {
     
	@Test
	public void Test() {
		// TODO Auto-generated method stub
		

		System.out.println(" merge conflict 1");

		System.out.println("merge conflict 13");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://localhost:8888/");
		WebElement ele1=driver.findElement(By.name("user_name"));
		WebElement ele2=driver.findElement(By.name("user_password"));
		WebElement ele3=driver.findElement(By.id("submitButton"));
		ele1.sendKeys("admin");
		ele2.sendKeys("admin");
		driver.navigate().refresh();
		ele1.sendKeys("admin");
		ele2.sendKeys("admin");
		ele3.click();

	}

}

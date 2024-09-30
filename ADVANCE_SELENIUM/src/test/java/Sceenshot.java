import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sceenshot {
	
	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		
		 	File source=driver.getScreenshotAs(OutputType.FILE);
		 	
	}

}

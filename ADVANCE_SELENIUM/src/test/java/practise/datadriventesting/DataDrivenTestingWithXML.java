package practise.datadriventesting;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class DataDrivenTestingWithXML {
	@Test
	public void readingDataFromXML(XmlTest test)
	{
		String URL=test.getParameter("url");
		String BROWSER=test.getParameter("browser");
		String USERNAME=test.getParameter("username");
		String PASSWORD=test.getParameter("password");
		System.out.println(" url is " +URL);
		System.out.println(" browser is " +BROWSER);
		System.out.println(" username is " +USERNAME);
		System.out.println(" password is " +PASSWORD);
		
		
		
		
	}

}

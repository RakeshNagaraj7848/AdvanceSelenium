package practise.datadriventesting;

import org.testng.annotations.Test;

public class ReadRunTimeMavenParameterTest {
	@Test
	public void runTimeParameterTest()
	{
		String BROWSER=System.getProperty("browser");
		String URL=System.getProperty("url");
		String USERNAME=System.getProperty("username");
		String PASSWORD=System.getProperty("password");
		
		System.out.println(" testing test");
		System.out.println(" browser  is " +BROWSER);
		System.out.println(" url is " +URL);
		System.out.println(" username is " +USERNAME);
		System.out.println(" password is " +PASSWORD);

		
		
	}
	

	
}

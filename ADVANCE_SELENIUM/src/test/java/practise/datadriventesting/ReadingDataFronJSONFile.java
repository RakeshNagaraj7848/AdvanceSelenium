package practise.datadriventesting;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

public class ReadingDataFronJSONFile {
	@Test
	public void readDataFromJson() throws FileNotFoundException, IOException, ParseException
	{
		JSONParser parser = new JSONParser();
		Object obj=parser.parse(new FileReader("C:\\Users\\Admin\\OneDrive\\Desktop\\appCommonData.json"));
		JSONObject map=(JSONObject)obj;
		String BROWSER=map.get("browser").toString();
		String URL=map.get("url").toString();
		String USERNAME=map.get("username").toString();
		String PASSWORD=map.get("password").toString();
		System.out.println(" browser is "+BROWSER);
		System.out.println(" url is "+URL);
		System.out.println(" username is "+USERNAME);
		System.out.println(" password is "+PASSWORD);
		
		
	}

}

package practise.datadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class DataDrivenTestingWithDatabaseDtaaValidationExample {
	@Test
	public void selectQueryExecution() throws SQLException
	{
		Connection con=null;
		String expectedProjectId="TC-001";
		boolean flag=false;
		try
		{
			Driver driverRef= new Driver();
			DriverManager.registerDriver(driverRef);
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
			Statement stat=con.createStatement();
			String selectSqlQuery="select * from PROJECT;";
			ResultSet resultset=stat.executeQuery(selectSqlQuery);
			System.out.println(" result set is "+resultset);
			while(resultset.next())
			{
				String actualProjectId=resultset.getString(1);
				if(expectedProjectId.equals(actualProjectId))
				{
					flag=true;
					System.out.println(expectedProjectId+" is found in database ");
				}
				
			}
			if(flag==false)
			{
				System.out.println(expectedProjectId+" is not  found in database ");
				Assert.fail();
			}
				
			
		}
		catch(Exception e )
		{
			System.out.println(" exception handled");
		}
		finally
		{
			con.close();
		}
		
		
		
		
		
	}

}

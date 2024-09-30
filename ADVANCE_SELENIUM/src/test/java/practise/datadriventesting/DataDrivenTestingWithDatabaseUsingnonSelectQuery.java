package practise.datadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class DataDrivenTestingWithDatabaseUsingnonSelectQuery {
	@Test
	public void selectQueryExecution() throws SQLException
	{
		Connection con=null;
		
		try
		{
			Driver driverRef= new Driver();
			DriverManager.registerDriver(driverRef);
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
			Statement stat=con.createStatement();
			String selectSqlQuery=" INSERT INTO PROJECT VALUE('TC-003','RAKESHNAGARAJ','03/09/2024','EVART223','IN-PROGRESS',150);";
			int resultset=stat.executeUpdate(selectSqlQuery);
			System.out.println(" result set is passed  "+resultset);
			
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

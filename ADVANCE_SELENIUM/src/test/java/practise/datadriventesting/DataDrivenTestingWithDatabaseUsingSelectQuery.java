package practise.datadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class DataDrivenTestingWithDatabaseUsingSelectQuery {
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
			String selectSqlQuery="select * from PROJECT;";
			ResultSet resultset=stat.executeQuery(selectSqlQuery);
			System.out.println(" result set is "+resultset);
			while(resultset.next())
			{
				System.out.println(resultset.getString(1)+"\t"+resultset.getString(2)+"\t"+resultset.getString(3)+"\t"+resultset.getString(4)+"\t"+resultset.getString(5)+"\t"+resultset.getInt(6));
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

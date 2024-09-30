 package practise.datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadingDataFromExcelBasedOnCondition {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		
		
		String expectedTestCaseId="tc_003";
		String data1="";
		String data2="";
		String data3="";
		String data4="";
		
		boolean flag=false;
		FileInputStream fis = new FileInputStream("C:\\Users\\Admin\\OneDrive\\Desktop\\testscriptdata.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("org");
		
		for(int i=0;i<=sh.getLastRowNum();i++)
		{   String data="";
		  try
		  {
			data=sh.getRow(i).getCell(0).toString();
			if(data.equals(expectedTestCaseId))
			{
				flag=true;
				data1=sh.getRow(i).getCell(0).toString();
				data2=sh.getRow(i).getCell(1).toString();
				data3=sh.getRow(i).getCell(2).toString();
				data4=sh.getRow(i).getCell(3).toString();
				
			}
		  }
		
		  catch(Exception e )
		  {
		  }
	   }
		if(flag==true)
		{
			System.out.println(data1+"\t"+data2+"\t"+data3+"\t"+data4);
		}
		else
		{
			System.out.println(" data is not available fot this test case id "+ "\t"+expectedTestCaseId);
		}
		wb.close();
		
		

	}

}

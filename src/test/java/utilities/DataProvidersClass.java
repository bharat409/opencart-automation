package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProvidersClass {
  
	
	@DataProvider(name="registerdata")
	Object[][]  registerData() {
		
		Object data[][]= {
				
				{"ltcolonel", "raghav", "shivajimaharaj11630@gmail.com", "8119220", "Bharath@2000", "Bharath@2008"},
				{"madhu", "mehta", "sambhajimaharaj1680@gmail.com", "7013349", "Bharath@2000", "Bharath@2000"},
				{"roshan", "singh", "bajiraopeshwa123@gmail.com", "6332110", "Bharath@2000", "Bharath@2000"},
				
		};
				
				return data;
				
		}
	
	@DataProvider(name="RegisterExcelData")
	public String [][] getRegisterData() throws IOException
	{
		String path="C:\\Users\\USER\\Documents\\eclipse selenium with java\\opencartapplicationautomation\\testData\\Excel Test Data.xlsx";
		String sheetName = "Registerdetails";
		
		ExcelUtility xlutil=new ExcelUtility(path, sheetName);
		
		int totalrows=xlutil.getRowCount("Registerdetails");	
		int totalcols=xlutil.getCellCount("Registerdetails",1);
				
		String logindata[][]=new String[totalrows][totalcols];
		
		for(int i=1;i<=totalrows;i++) 
		{		
			for(int j=0;j<totalcols;j++)  
			{
				logindata[i-1][j]= xlutil.getCellData("Registerdetails",i, j);  
			}
		}
	return logindata;
				
	}
	
	@DataProvider(name="negativeregisterdata")
	Object[][]  negativeRegisterData() {
		
		Object data[][]= {
				
				{"ltcolonel", "raghav", "shivajimaharaj90010@gmail.com", "8119220", "Bharath@2000", "Bharath@2008"},

		};
	  return data;
	}	
	}

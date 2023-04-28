package Generic_utility;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_utility 
{
     public String getExcelDataFormater(String sheetName, int rowNum, int cellNum) throws Throwable
     {
    	 FileInputStream fes1=new FileInputStream("./src/test/resources/pro.xlsx");
 	     Workbook book = WorkbookFactory.create(fes1);
 	     DataFormatter format=new DataFormatter();
 	     String excel = format.formatCellValue(book.getSheet(sheetName).getRow(rowNum).getCell(cellNum));
		 return excel;
    	 
     }
     
     public String getExcelDataFormater2(String sheetName1, int rowNum1, int cellNum1) throws Throwable
     {
    	 FileInputStream fes2=new FileInputStream("./src/test/resources/org.xlsx");
 	     Workbook book = WorkbookFactory.create(fes2);
 	     DataFormatter format=new DataFormatter();
 	     String excel1 = format.formatCellValue(book.getSheet(sheetName1).getRow(rowNum1).getCell(cellNum1));
		 return excel1;
    	 
     }
     
     public String getExcelDataFormater3(String sheetName, int rowNum, int cellNum) throws Throwable
     {
    	 FileInputStream fes1=new FileInputStream("./src/test/resources/camp.xlsx");
 	     Workbook book = WorkbookFactory.create(fes1);
 	     DataFormatter format=new DataFormatter();
 	     String excel = format.formatCellValue(book.getSheet(sheetName).getRow(rowNum).getCell(cellNum));
		 return excel;
    	 
     }
     
     public String getExcelDataFormater4(String sheetName, int rowNum, int cellNum) throws Throwable
     {
    	 FileInputStream fes1=new FileInputStream("./src/test/resources/contact.xlsx");
 	     Workbook book = WorkbookFactory.create(fes1);
 	     DataFormatter format=new DataFormatter();
 	     String excel = format.formatCellValue(book.getSheet(sheetName).getRow(rowNum).getCell(cellNum));
		 return excel;
    	 
     }
     
}

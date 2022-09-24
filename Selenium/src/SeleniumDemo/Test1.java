package SeleniumDemo;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Test1 {

	public static void main(String[] args) throws  IOException
	{
		String data;
		File path=new File("C:\\Users\\Samir\\Desktop\\Credential.xlsx");
		FileInputStream file=new FileInputStream(path);
		Workbook wb= WorkbookFactory.create(file);
		Sheet sheetName=wb.getSheet("Login data");
		Row rowNum=sheetName.getRow(2);
		Cell cellNum=rowNum.getCell(0);
		CellType type=cellNum.getCellType();
		// System.out.println(cellNum.getCellType());
	//	data=cellNum.getStringCellValue();
		
	    
	  
	
		
	}

}

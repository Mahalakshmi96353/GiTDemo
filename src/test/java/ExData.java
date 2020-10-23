import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



// after grabbing row, pull data from the MobileAuto row and feed it into test

public class ExData {
	
	
	
	public ArrayList<String> getData(String testcaseName) throws IOException
	{

		ArrayList<String> a = new ArrayList<String>();
		
		FileInputStream fis = new FileInputStream("C:\\Users\\Administrator\\Documents\\MavenData.xlsx");
		XSSFWorkbook  workbook = new XSSFWorkbook(fis);
		int sheetcount= workbook.getNumberOfSheets();
		
		for(int i=0;i<sheetcount;i++)
		{
			if(workbook.getSheetName(i).equalsIgnoreCase("Testcase"));
			{
				XSSFSheet sheet=workbook.getSheetAt(i);  // to get access to the sheet
				
				// first identify Testtitle column by scanning entire 1st row
				
				Iterator<Row> rows= sheet.iterator();		
				Row firstRow= rows.next();
				Iterator<Cell> ce =firstRow.cellIterator();
				
				int k=0;
				int column=0;
				while(ce.hasNext())
				{
					Cell value=ce.next();
					if(value.getStringCellValue().equalsIgnoreCase("Testtitle"))
					{
						column = k;
					}
					k++;
				}
				System.out.println(column);
				

	// once column is identified then scan entire Testtitle coulumn to get MobileAuto testtitle row			
				while(rows.hasNext())
			{

			Row r=rows.next();

			if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testcaseName))
			{

			////after you grab purchase testcase row = pull all the data of that row and feed into test

			Iterator<Cell>  cv=r.cellIterator();
			while(cv.hasNext())
			{
				Cell c= cv.next();
				if(c.getCellTypeEnum()==CellType.STRING) 
	// getCellTypeEnum() will get us  the return type so that we can match the results with required return type
			
			
			{

			a.add(cv.next().getStringCellValue());
			}
				else{

					a.add(NumberToTextConverter.toText(c.getNumericCellValue()));

//c.getNumericCellValue() will give numeric value output. But, we have defined array as a string. 
//So, we are converting the numeric value into string
					}
				
				
				}

			
			}

	}

}
		
		}
		return a;
		
		
}


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		}
	}

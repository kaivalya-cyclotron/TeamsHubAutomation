package com.org.MavenGroup.MavenArtifactID.Tests;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.TestNG;
import org.testng.annotations.Test;

public class TestRunner {
	
	static TestNG testNg;
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub		 
		
		/*	List<String> list=new ArrayList<String>();
		
			try {
		        FileInputStream file = new FileInputStream(new File("BrowserDrivers/input.xlsx"));

		        //Create Workbook instance holding reference to .xlsx file
		        XSSFWorkbook workbook = new XSSFWorkbook(file);

		        //Get first/desired sheet from the workbook
		        XSSFSheet sheet = workbook.getSheetAt(0);

		        //Iterate through each rows one by one
		        Iterator<Row> rowIterator = sheet.iterator();
		        while (rowIterator.hasNext())
		        {
		            Row row = rowIterator.next();
		            //For each row, iterate through all the columns
		            Iterator<Cell> cellIterator = row.cellIterator();

		            while (cellIterator.hasNext()) 
		            {
		                Cell cell = cellIterator.next();
		                //Check the cell type and format accordingly
		                switch (cell.getCellType()) 
		                {
		                    case NUMERIC:
		                        //System.out.print(cell.getNumericCellValue() + "\t");
		                        break;
		                    case STRING:
		                       // System.out.print(cell.getStringCellValue() + "\t");
		                        list.add(cell.getStringCellValue());
		                        break;
		                }
		            }
		           		          
		        }
		            
		        file.close();
		   } catch (Exception e) {
		        e.printStackTrace();
		    }
			
	SmokeTests inputs = new SmokeTests();
		inputs.testData(list);   */
		
		//	SmokeTests instance = new SmokeTests();  // just local variable that is lost after method execution ends.
		// instance.settingVariables(list);

		
		testNg = new TestNG();		
		testNg.setTestClasses(new Class[] {SmokeTests.class});		
		testNg.run();
		
	}

}

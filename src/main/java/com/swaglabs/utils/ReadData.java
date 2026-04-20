package com.swaglabs.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadData {
    
	  private XSSFSheet sheet;
	public ReadData(String filename)
	{
		String path = System.getProperty("user.dir")+"/src/test/resources/testdata/"+filename+".xlsx";
		//String path="./src/test/resources/testdata/"+filename+".xlsx";
	    try {
			FileInputStream instream = new FileInputStream(path);
			XSSFWorkbook workbook = new XSSFWorkbook(instream);
			sheet=workbook.getSheet("Sheet1");
			System.out.println("File found");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	
	public String getData(int rownum,int cellnum)
	{
		return sheet.getRow(rownum).getCell(cellnum).getStringCellValue();
	}
	
	public List<String> getData(int rownum)
	{
		int cellscount=sheet.getRow(rownum).getLastCellNum();
		System.out.println("CellsCount : "+cellscount);
		List<String> rowdata= new ArrayList<String>();
		for(int i=0;i<cellscount;i++)
		{
			String data=sheet.getRow(rownum).getCell(i).getStringCellValue();
			rowdata.add(data);
		}
		
		return rowdata;
	}
	
	public String[][] getData()
	{
		int rowindex=sheet.getLastRowNum();
		int cellscount=sheet.getRow(0).getLastCellNum();
		System.out.println("LAst row : "+rowindex);
		System.out.println("CellsCount : "+cellscount);
		
		String testdata[][]= new String[rowindex][cellscount];
		int k=0,l;
		for(int i=1;i<=rowindex;i++)
		{
			l=0;
			for(int j=0;j<cellscount;j++)
			{
				String data=sheet.getRow(i).getCell(j).getStringCellValue();
				testdata[k][l] = data;
				l++;

			}
			k++;
		}
		
		
		return testdata;
	}
	
	
	
	
	
	public static void main(String[] args) {
		ReadData read = new ReadData("loginpage");
		String onecelldata=read.getData(4, 1);
		System.out.println(onecelldata);
		System.out.println(read.getData(4));
		
		System.out.println("Complete data:");
		String[][] data=read.getData();
		for(int i=0;i<data.length;i++)
		{
			for(int j=0;j<data[i].length;j++)
			{
				System.out.print(data[i][j]+" ");
			}
			System.out.println();
		}
	}
	
}

/*
workbook -> XSSFWorkbook
Sheet  -> XSSFSheet
rows --> getLastRowNum() --> getRow()
cells-> getLastCellNum() 
data --> getCellType()
*/
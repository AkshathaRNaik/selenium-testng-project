package com.project.tests;

import com.project.utils.DataProviderTest;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.FileInputStream;

public class DataDrivenTesting {
    //	FIS : Read excel data from input file in byte code
    //	XSSFWorkbook : Interact with workbook
    @Test(enabled = false)
    public void dataDrivenTesting() throws IOException {
        FileInputStream file = new FileInputStream("D:\\Selenium WebDriver\\ExcelData\\InputFile.xlsx");
        XSSFWorkbook xw = new XSSFWorkbook(file);
        XSSFSheet xs = xw.getSheetAt(0);

        int rowSize = xs.getLastRowNum();

        for (int row = 0; row <= rowSize; row++) {
            int colSize = xs.getRow(row).getLastCellNum();
            for (int col = 0; col < colSize; col++) {
                try {
                    String value = xs.getRow(row).getCell(col).toString();
                    System.out.print(value + " ");
                } catch (NullPointerException e) {
                    System.out.print("      ");
                }

            }
            System.out.println();
        }
    }

    @Test(dataProvider = "InterviewTest",  dataProviderClass = DataProviderTest.class)
    public void dataProviderTesting(String username , String password){
        System.out.print(username + "  " + password);
        Assert.fail();
        System.out.println();

    }



}

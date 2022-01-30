package com.cybertek.tests.reviews.week7;

import com.cybertek.utilities.ExcelUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExelTestExamples {

    List<Map<String,String>> users = new ArrayList<>();
    @Test
    public void createExcelFile() throws IOException {
        ExcelUtil readFile = new ExcelUtil("src/test/resources/Vytracktestdata.xlsx","QA3-short");

        int rowCount = readFile.rowCount(); // This one gives how many rows I have
        for (int i = 1; i < rowCount ; i++) {
             Map<String,String> userDataofEachRow = new HashMap<>();
             String userName = readFile.getCellData(i,0);  // This one returns cell information
             String passWord = readFile.getCellData(i,1);
             String firstName = readFile.getCellData(i,2);
             String lastName = readFile.getCellData(i,3);
             userDataofEachRow.put(readFile.getColumnsNames().get(0),userName); // This one will return Column names in a List format, so I have to give index
             userDataofEachRow.put(readFile.getColumnsNames().get(1),passWord);
             userDataofEachRow.put(readFile.getColumnsNames().get(2),firstName);
             userDataofEachRow.put(readFile.getColumnsNames().get(3),lastName);
             users.add(userDataofEachRow);
        }

        System.out.println("users = " + users);

        System.out.println("users.get(5).get(\"password\") = " + users.get(5).get("firstname")); // points to line 7, gives the 6th person

        // Creating and writing to an excel file
        Workbook workbook = new XSSFWorkbook();

        Sheet sheet = workbook.createSheet("MyUsers");

        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < readFile.columnCount() ; i++) {
             Cell cell = headerRow.createCell(i);                   // create a cell
             cell.setCellValue(readFile.getColumnsNames().get(i));  // put data in the cell
        }

        for (int i = 1; i < readFile.rowCount()-1; i++) {
             Row eachRow = sheet.createRow(i);
             eachRow.createCell(0).setCellValue(users.get(i-1).get("username"));
             eachRow.createCell(1).setCellValue(users.get(i-1).get("password"));
             eachRow.createCell(2).setCellValue(users.get(i-1).get("firstname"));
             eachRow.createCell(3).setCellValue(users.get(i-1).get("lastname"));
    }

        FileOutputStream fileOutputStream = new FileOutputStream("src/test/resources/MyUsers.xlsx");

        workbook.write(fileOutputStream);
        fileOutputStream.close();
        workbook.close();
        /*
        3 more weeks for UI Automation
        2 weeks for DataBase (easiest topic)
        3 weeks for API (Mobile Testing as optional videos)
         */

    }

}

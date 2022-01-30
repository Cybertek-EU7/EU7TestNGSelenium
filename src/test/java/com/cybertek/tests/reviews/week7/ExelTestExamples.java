package com.cybertek.tests.reviews.week7;

import com.cybertek.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExelTestExamples {

    List<Map<String,String>> users = new ArrayList<>();
    @Test
    public void createExcelFile(){
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
    }

}

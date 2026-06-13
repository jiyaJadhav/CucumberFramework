package com.vtiger.stepdefinations;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.vtiger.utilities.commonMethods;

public class basesteps extends commonMethods {

    public void readExcelData() throws FilloException {

        String path = System.getProperty("user.dir")
                + "/src/test/resources/TestData/data.xlsx";

        Fillo fillo = new Fillo();

        Connection connection = fillo.getConnection(path);

        String query = "Select * from Sheet1";

        Recordset recordset = connection.executeQuery(query);

        while (recordset.next()) {

            System.out.println(recordset.getField("username"));
            System.out.println(recordset.getField("password"));
        }

        recordset.close();
        connection.close();
    }
}
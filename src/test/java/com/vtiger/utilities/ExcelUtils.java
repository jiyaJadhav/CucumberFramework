package com.vtiger.utilities;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class ExcelUtils {

    public static Recordset getData() throws Exception {

        String path = System.getProperty("user.dir")
                + "/src/test/resources/TestData/data.xlsx";

        Fillo fillo = new Fillo();

        Connection connection = fillo.getConnection(path);

        String query = "Select * from Sheet1";

        return connection.executeQuery(query);
    }
}
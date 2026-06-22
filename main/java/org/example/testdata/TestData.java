package org.example.testdata;

import org.example.utils.ExcelUtils;
import org.testng.annotations.DataProvider;
import java.io.IOException;

public class TestData {

    //Valid credentials
    public static final String valid_UserName = "standard_user";
    public static final String valid_Password = "secret_sauce";

    //Invalid credentials
    public static final String inValid_UserName = "demo_ser";
    public static final String inValid_Password = "user_user";

    //BaseURL
    public static final String base_Url = "https://www.saucedemo.com";

    public static final String excel_path = System.getProperty("user.dir") + "//testData.xlsx";
    @DataProvider(name = "login_data")
    public Object [][] getLoginData() throws IOException{
        ExcelUtils excel = new ExcelUtils(excel_path, "testData");
        int totalRows = excel.getRowCount();
        int totalCols = excel.getColumnCount();

        System.out.println("Total rows: " + totalRows);
        System.out.println("Total cols: " + totalCols);

        Object [][] data = new Object[totalRows][totalCols];

        for (int i = 1; i <= totalRows; i++){
            for(int j = 0; j < totalCols; j++){
                data [i-1] [j] = excel.getCellData(i, j);
            }
        }
        excel.closeWorkbook();
        return data;
    }
    //Product
    public static final String product = "Sauce Labs Backpack";

    //Check out details
    public static final String first_Name = "Tarun";
    public static final String last_Name = "Bisht";
    public static final String zipCode = "201301";
}

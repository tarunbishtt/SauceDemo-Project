package org.example.utils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;

//Constructor - open Excel file
public class ExcelUtils {
    private Workbook workbook;
    private Sheet sheet;
    public ExcelUtils(String filePath, String sheetName)
        throws  IOException{
            FileInputStream fis = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet(sheetName);
            System.out.println("Exel sheet open!");
        }
//get total number of rows
    public int getRowCount(){
        return sheet.getLastRowNum();
    }

//get total number of columns
    public int getColumnCount(){
        return sheet.getRow(0).getLastCellNum();
    }
//Get cell data by row & column
    public String getCellData(int rowNum, int colNum){
        Row row = sheet.getRow(rowNum);
        Cell cell = row.getCell(colNum);

        if(cell == null){
            return "";
        }
//handle different cell type
        switch (cell.getCellType()){
            case STRING :
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf((int) cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            default:
                return "";
        }
    }
//close Excel file
    public void closeWorkbook() throws  IOException {
        workbook.close();
        System.out.println("Excel file closed! ✅");
    }
}

package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {

    private static Workbook workbook;
    private static Sheet sheet;

    // Load Excel file
    public static void setExcelFile(String filePath, String sheetName) {
        try {
            FileInputStream fis = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet(sheetName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Get data from a specific cell
    public static String getCellData(int rowNum, int colNum) {
        Cell cell = sheet.getRow(rowNum).getCell(colNum);
        DataFormatter formatter = new DataFormatter();
        return formatter.formatCellValue(cell);
    }

    // Get row count
    public static int getRowCount() {
        return sheet.getPhysicalNumberOfRows();
    }

    // Get column count
    public static int getColumnCount() {
        return sheet.getRow(0).getPhysicalNumberOfCells();
    }

    // Return all data as 2D Object array (for DataProvider)
    public static Object[][] getSheetData(String filePath, String sheetName) {
        setExcelFile(filePath, sheetName);

        int rowCount = getRowCount();
        int colCount = getColumnCount();

        Object[][] data = new Object[rowCount - 1][colCount];

        for (int i = 1; i < rowCount; i++) { // Skip header row
            for (int j = 0; j < colCount; j++) {
                data[i - 1][j] = getCellData(i, j);
            }
        }
        return data;
    }
}

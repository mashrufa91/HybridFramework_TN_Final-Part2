package com.qa.tn.testData;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class Data_driven_excel {

	@DataProvider(name = "TN")

	public Object[][] getTNexcel() throws Exception {
		Object[][] data = Data_driven_excel.readFromExcelSheetTN("TNRegister");
		return data;

	}

	public static Object[][] readFromExcelSheetTN(String sheetname) throws Exception {

		FileInputStream ip = new FileInputStream(System.getProperty("user.dir")
				+ "\\src\\test\\java\\com\\qa\\tn\\testData\\DATA_DRIVEN_TESTING_DATA.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(ip);

		XSSFSheet sheet = workbook.getSheet(sheetname); // each sheet
		System.out.println(System.getProperty("lastname"));
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();

		Object[][] data = new Object[rows][cols];

		for (int i = 0; i < rows; i++) {
			XSSFRow row = sheet.getRow(i + 1);

			for (int j = 0; j < cols; j++) {

				XSSFCell cell = row.getCell(j);

				CellType celltype = cell.getCellType(); // takes care of datatype int//

				switch (celltype) {
				case STRING:
					data[i][j] = cell.getStringCellValue();
					break;
				case NUMERIC:
					data[i][j] = Integer.toString((int) cell.getNumericCellValue());
					break;
				case BOOLEAN:
					data[i][j] = cell.getBooleanCellValue();
					break;
				}

			}
		}
		return data;
	}

	@DataProvider(name = "LN")
	public Object[][] getLNexcel() throws Exception {
		Object[][] data = Data_driven_excel.readFromExcelSheetLN("TNLogin");
		return data;
	}

	public static Object[][] readFromExcelSheetLN(String sheetname) throws IOException {

		FileInputStream ip = new FileInputStream(System.getProperty("user.dir")
				+ "\\src\\test\\java\\com\\qa\\tn\\testData\\DATA_DRIVEN_TESTING_DATA.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(ip);

		XSSFSheet sheet = workbook.getSheet(sheetname); // use the workbook reference to call each sheet

		int rows = sheet.getLastRowNum();// takes care of whatever changes u made in rows n column
		int cols = sheet.getRow(0).getLastCellNum();

		Object[][] data = new Object[rows][cols];

		for (int i = 0; i < rows; i++) {
			XSSFRow row = sheet.getRow(i + 1);

			for (int j = 0; j < cols; j++) {

				XSSFCell cell = row.getCell(j);

				CellType celltype = cell.getCellType(); // takes care of datatype int//

				switch (celltype) {
				case STRING:
					data[i][j] = cell.getStringCellValue();
					break;
				case NUMERIC:
					data[i][j] = Integer.toString((int) cell.getNumericCellValue()); // convert int to string using int
																						// wrapper class
					break;
				case BOOLEAN:
					data[i][j] = cell.getBooleanCellValue();
					break;
				}

			}
		}
		return data;
	}

}

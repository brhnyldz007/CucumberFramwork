package com.neotech.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	private static Workbook book;
	private static Sheet sheet;

	private static void openExcel(String filePath) {
		FileInputStream fileIS;
		try {
			fileIS = new FileInputStream(filePath);
			book = new XSSFWorkbook(fileIS);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void loadSheet(String sheetName) {
		sheet = book.getSheet(sheetName);
	}

	private static int rowCount() {
		return sheet.getPhysicalNumberOfRows();
	}

	private static int colCount(int rowIndex) {
		return sheet.getRow(rowIndex).getLastCellNum();
	}

	private static String cellData(int rowIndex, int colIndex) {
		return sheet.getRow(rowIndex).getCell(colIndex).toString();
	}

	// return a 2D Object
	public static Object[][] excelIntoArray(String filePath, String sheetName) {

		openExcel(filePath);
		loadSheet(sheetName);

		int rows = rowCount();
		int cols = colCount(0);

		Object[][] data = new Object[rows - 1][cols];

		// iterate in each cell

		for (int row = 1; row < rows; row++) {
			for (int col = 0; col < cols; col++) {

				data[row - 1][col] = cellData(row, col);
			}
		}

		return data;
	}

	public static List<Map<String, String>> excelIntoListOfMaps(String filePath, String sheetName) {

		openExcel(filePath);
		loadSheet(sheetName);

		List<Map<String, String>> list = new ArrayList<>();

		for (int row = 1; row < rowCount(); row++) {
			// for every data row create a map
			Map<String, String> rowMap = new LinkedHashMap<>();

			// fill the map
			for (int col = 0; col < colCount(row); col++) {
				rowMap.put(cellData(0, col), cellData(row, col));
			}

			// add the map to the list
			list.add(rowMap);
		}

		return list;

	}

}

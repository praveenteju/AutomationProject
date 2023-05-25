package com.qt.framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Testdata {

	static Map<Integer, String> keys = new HashMap<Integer, String>();
	static Map<Integer, String> values = new HashMap<Integer, String>();
	static Map<String, String> dataComb = new HashMap<String, String>();
	static FileInputStream file;

	public static void readTestdata(String testCaseID) {
		try {
			file = new FileInputStream(new File(System.getProperty("user.dir") + "//TestData//ExcelData.xlsx"));
			Workbook wb = WorkbookFactory.create(file);
			for (Sheet sh : wb) {
				Sheet sheet = wb.getSheet(sh.getSheetName());
				for (Row row : sheet) {
					Cell firstCell = row.getCell(0);
					String label = firstCell.getStringCellValue();
					if (label.equalsIgnoreCase("TestCaseId")) {
						for (Cell cell : row) {
							keys.put(cell.getColumnIndex(), cell.getStringCellValue());
						}
					} else if (label.equalsIgnoreCase(testCaseID)) {
						for (Cell cell : row) {
							values.put(cell.getColumnIndex(), cell.getStringCellValue());
						}
					}
					for (int j : values.keySet()) {
						dataComb.put(keys.get(j), values.get(j));
					}
				}
			}
			System.out.println(dataComb);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static String getData(String key) {
		return dataComb.get(key);
	}
}

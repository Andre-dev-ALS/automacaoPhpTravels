package br.com.phptravels.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.InvalidArgumentException;

import br.com.phptravels.managers.FileReaderManager;

public class ExcelActions {

	private static XSSFWorkbook workFolder;
	private static XSSFSheet sheet;
	private static XSSFCell cell;
	private String worksheetName = "";

	private void setExcelFile(String worksheetName) {
		try {
			File file = new File(FileReaderManager.getInstance().getConfigReader().getExcelPath());
			workFolder = new XSSFWorkbook(file);
		} catch (IOException | InvalidFormatException e) {
			System.out.println("workbook not found");
			e.printStackTrace();
		}
		sheet = workFolder.getSheet(worksheetName);
		try {
			workFolder.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("error when trying to close excel");
		}
	}

	private int findColumn(String columnName) {
		setExcelFile(worksheetName);
		int cellcount = sheet.getRow(0).getLastCellNum();
		for (int indexColumn = 0; indexColumn < cellcount; indexColumn++) {
			String attribute = getFileCellValue(0, indexColumn);
			if (attribute.equalsIgnoreCase(columnName)) {
				return indexColumn;
			}
		}
		throw new InvalidArgumentException("O argumento" + columnName + "não existe ");
	}

	private String getFileCellValue(int lineNumber, int icellNumber) {
		setExcelFile(worksheetName);
		if (sheet.getRow(lineNumber).getCell(icellNumber) != null) {
			cell = sheet.getRow(lineNumber).getCell(icellNumber);
			return cell.getStringCellValue();
		}
		throw new NullPointerException("returned an empty cell");
	}

	public String getValueInTheWorksheet(String worksheetName, String id, String columnName) {
		this.worksheetName = worksheetName;
		setExcelFile(this.worksheetName);
		int col = findColumn(columnName);
		String dadoProcurado = id;
		String dadoEncontrado = "";
		int indiceId = 0;
		for (; indiceId <= getTotalRows(); indiceId++) {
			dadoEncontrado = getFileCellValue(indiceId, 0);
			if (dadoEncontrado.equalsIgnoreCase(dadoProcurado)) {
				dadoEncontrado = getFileCellValue(indiceId, col);
			}

		}
		return dadoEncontrado;
	}

	public int getTotalRows() {
		setExcelFile(worksheetName);
		int totalRows = sheet.getLastRowNum() - sheet.getFirstRowNum();
		return totalRows;
	}
}
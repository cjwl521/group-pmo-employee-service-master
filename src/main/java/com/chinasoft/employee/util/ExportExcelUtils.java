package com.chinasoft.employee.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ResourceUtils;

import com.chinasoft.employee.service.EmployeeQueryService;
import com.chinasoft.employee.service.model.ExcelModel;
import com.chinasoft.employee.util.Constant.ExcelTitleCode;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExportExcelUtils {

	public static void exportExcel(HttpServletResponse response, String fileName, ExcelModel data, String path) throws Exception {
		// 告诉浏览器用什么软件可以打开此文件
		response.setHeader("content-Type", "application/vnd.ms-excel");
		// 下载文件的默认名称
		response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "utf-8"));
		exportExcel(data, response.getOutputStream(), path);
	}

	/**
	 * 导出excel
	 * @param data
	 * @param out
	 * @param pATH2 
	 * @throws Exception
	 */
	public static void exportExcel(ExcelModel data, OutputStream out, String path) throws Exception {
		log.info("excel path：【{}】", path);
		File file = new File(path + "PMO导入模板.xlsx");
		FileInputStream io = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(io);
		try {
			XSSFSheet sheet = wb.getSheetAt(0);
			writeExcel(wb, sheet, data);

			wb.write(out);
		} finally {
			wb.close();
		}
	}

	/**
	 * 写入excel
	 * @param wb
	 * @param sheet
	 * @param data
	 */
	private static void writeExcel(XSSFWorkbook wb, Sheet sheet, ExcelModel data) {

		int rowIndex = 1;
		writeRowsToExcel(wb, sheet, data.getRows(), rowIndex);
	}

	/**
	 * 写入内容到excel
	 * @param wb
	 * @param sheet
	 * @param rows
	 * @param rowIndex
	 * @return
	 */
	private static int writeRowsToExcel(XSSFWorkbook wb, Sheet sheet, List<?> rows, int rowIndex) {
		int colIndex = 0;

		for (Object rowData : rows) {
			Row dataRow = sheet.createRow(rowIndex);
			colIndex = 0;

			Cell cell0 = dataRow.createCell(colIndex);
			cell0.setCellValue(rowIndex);
			colIndex++;
			try {
				Map<String, Object> objectToMap = DataTypeConversionUtil.objectToMap(rowData);
				for (ExcelTitleCode code : Constant.ExcelTitleCode.values()) {
					if(objectToMap.containsKey(code.name())) {
						Cell cell = dataRow.createCell(colIndex);
						cell.setCellValue(null==objectToMap.get(code.name())?"":objectToMap.get(code.name()).toString());
						colIndex++;
					}else {
						Cell cell = dataRow.createCell(colIndex);
						cell.setCellValue("");
						colIndex++;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			rowIndex++;
		}
		return rowIndex;
	}

}

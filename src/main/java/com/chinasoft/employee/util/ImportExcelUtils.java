package com.chinasoft.employee.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.ResourceUtils;

import com.alibaba.druid.util.StringUtils;
import com.chinasoft.employee.exception.BusinessException;
import com.chinasoft.employee.exception.EmBusinessError;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ImportExcelUtils {


	/**
	 * 获取excel Sheet对象
	 * @param filePath
	 * @param index
	 * @return
	 */
	public static Sheet getExcelSheet(String filePath, int index) {
		Sheet result = null;
		getPath();
		try {
			Workbook rwb = Workbook.getWorkbook(new File(getPath() + filePath));
			result = rwb.getSheet(index);
		} catch (BiffException e) {
			log.error("读取Excel发生异常：{[]}", e.getMessage());
		} catch (IOException e) {
			log.error("读取Excel发生异常：{[]}", e.getMessage());
		}
		return result;
	}
	
	/**
	 * 导出excel
	 * @param data
	 * @param rowIndex2 
	 * @param sheet2 
	 * @param colIndex 
	 * @param out
	 * @throws BusinessException 
	 * @throws Exception
	 */
	public static void writeExcel(String data, int colIndex, int rowIndex, Row dataRow) throws BusinessException {
		try {
			Cell cell = dataRow.createCell(colIndex);
			cell.setCellValue(data);
		} catch (Exception e) {
			log.error("读取Excel发生异常：{[]}", e.getMessage());
			throw new BusinessException(EmBusinessError.EXPORT_ERROR, e.getMessage());
		}
	}
	/**
	 * 获取相对路径
	 * @return
	 */
	public static String getPath() {
		String path = "";
		try {
			path = ResourceUtils.getURL("classpath:").getPath();
			if(!StringUtils.isEmpty(path)) {
				path = path.substring(0,path.indexOf("target"))+"src/main/resources/";
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return path;
	}
}
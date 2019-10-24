package com.chinasoft.employee.service.model;

import java.util.List;

import lombok.Data;

@Data
public class ExcelModel {

	// 表头
	private List<String> titles;

	// 数据
	private List<?> rows;

	// 页签名称
	private String sheetName;



}

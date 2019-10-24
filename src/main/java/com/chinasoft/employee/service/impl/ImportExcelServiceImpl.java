package com.chinasoft.employee.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chinasoft.employee.dao.entity.DictionaryDO;
import com.chinasoft.employee.dao.entity.UserTypeDO;
import com.chinasoft.employee.dao.entity.UserTypeDOExample;
import com.chinasoft.employee.dao.mapper.UserTypeDOMapper;
import com.chinasoft.employee.exception.BusinessException;
import com.chinasoft.employee.exception.EmBusinessError;
import com.chinasoft.employee.service.CSDeptService;
import com.chinasoft.employee.service.DictionarySevice;
import com.chinasoft.employee.service.EmployeeQueryService;
import com.chinasoft.employee.service.ImportExcelService;
import com.chinasoft.employee.service.model.DictionaryModel;
import com.chinasoft.employee.service.model.RmInfoModel;
import com.chinasoft.employee.util.Constant;
import com.chinasoft.employee.util.Constant.ExcelTitleMappingCode;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ImportExcelServiceImpl implements ImportExcelService {

	@Autowired
	private DictionarySevice dictionarySevice;

	@Autowired
	private CSDeptService cSDeptService;

	@Autowired
	private UserTypeDOMapper userTypeDOMapper;

	@Autowired
	private EmployeeQueryService employeeQueryService;
	@Value("${employee.excel.address}")
	private String PATH;

	@Override
	@SuppressWarnings("unchecked")
	@Transactional
	public boolean updateExcelRules() throws BusinessException {
		Map<String, Map<Integer, DictionaryModel>> dictionaryMap = null;
		boolean result = false;
		// 查询数据字典总集合
		try {
			dictionaryMap = dictionarySevice.getDictionaryMapMap();
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		// 通过枚举获取excel的title信息
		ExcelTitleMappingCode[] values = Constant.ExcelTitleMappingCode.values();
		String path = PATH + "PMO导入模板.xlsx";
		log.info("excel path：【{}】", path);
		File file = new File(path);
		FileInputStream io;
		XSSFWorkbook wb = null;
		FileOutputStream fileOut = null;
		try {
			io = new FileInputStream(file);
			wb = new XSSFWorkbook(io);
			//查询position信息
			UserTypeDOExample userTypeDOExample = new UserTypeDOExample();
			List<UserTypeDO> positions = userTypeDOMapper.selectByExample(userTypeDOExample);
			//查询RM信息
			List<RmInfoModel> rms = employeeQueryService.findRMAllInfo();
			//查询HSBC部门信息
			Map<String, Object> hsbcDeptDiff = cSDeptService.getHsbcDeptDiff();
			ArrayList<DictionaryDO> csHSBCDept = (ArrayList<DictionaryDO>)hsbcDeptDiff.get("csHSBCDept");
			ArrayList<DictionaryDO> businessHSBCUnit = (ArrayList<DictionaryDO>)hsbcDeptDiff.get("businessHSBCUnit");
			ArrayList<DictionaryDO> businessHSBCLine = (ArrayList<DictionaryDO>)hsbcDeptDiff.get("businessHSBCLine");
			//获取sheet对象
			XSSFSheet sheet = wb.getSheetAt(1);
			for (int rowIndex = 1; rowIndex < 300; rowIndex++) {
				Row dataRow = sheet.createRow(rowIndex);
				int colIndex = 0;
				for(ExcelTitleMappingCode key : values) {
					if (dictionaryMap.containsKey(key.name())) {
						Map<Integer, DictionaryModel> map = dictionaryMap.get(key.name());
						List<DictionaryModel> models = map.values().stream().collect(Collectors.toList());
						if (rowIndex <= models.size()) {
							Cell cell = dataRow.createCell(colIndex);
							cell.setCellValue(models.get(rowIndex-1).getParamName());
						}
					}else {
						//GBGF
						if (rowIndex <= businessHSBCLine.size()&&"gbgf".equals(key.name())) {
							Cell cell = dataRow.createCell(colIndex);
							cell.setCellValue(businessHSBCLine.get(rowIndex-1).getParamName());
						}
						//HSBC 2 Dept
						if (rowIndex <= businessHSBCUnit.size()&&"hsbcDepts".equals(key.name())) {
							Cell cell = dataRow.createCell(colIndex);
							cell.setCellValue(businessHSBCUnit.get(rowIndex-1).getParamName());
						}
						//HSBC 3 Dept
						if (rowIndex <= csHSBCDept.size()&&"hsbcSubDepts".equals(key.name())) {
							Cell cell = dataRow.createCell(colIndex);
							cell.setCellValue(csHSBCDept.get(rowIndex-1).getParamName());
						}
						//Position
						if (rowIndex <= positions.size()&&"position".equals(key.name())) {
							Cell cell = dataRow.createCell(colIndex);
							cell.setCellValue(positions.get(rowIndex-1).getUserTypeName());
						}
						//RM queryRMList
						if (rowIndex <= rms.size()&&"rm".equals(key.name())) {
							Cell cell = dataRow.createCell(colIndex);
							cell.setCellValue(rms.get(rowIndex-1).getStaffName());
						}
					}
					colIndex ++;
				}
			}
			fileOut = new FileOutputStream(path);
			wb.write(fileOut);
			result = true;
		} catch (Exception e) {
			log.error("读取Excel发生异常：{[]}", e.getMessage());
			throw new BusinessException(EmBusinessError.EXPORT_ERROR, e.getMessage());
		} finally {
			try {
				wb.close();
				fileOut.flush();
				fileOut.close();
			} catch (IOException e) {
				log.error("读取Excel发生关闭IO流异常：{[]}", e.getMessage());
				throw new BusinessException(EmBusinessError.EXPORT_ERROR, e.getMessage());
			}
		}
		return result;
	}
}

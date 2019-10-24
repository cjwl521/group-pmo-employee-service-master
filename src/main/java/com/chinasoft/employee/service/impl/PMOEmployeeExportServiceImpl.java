package com.chinasoft.employee.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.chinasoft.employee.controller.vo.response.EmployeeAndHsbcDetailResponseVO;
import com.chinasoft.employee.dao.entity.CSDeptDO;
import com.chinasoft.employee.dao.entity.EmployeeAndHsbcDO;
import com.chinasoft.employee.dao.entity.EmployeeDO;
import com.chinasoft.employee.dao.entity.EmployeeDOExample;
import com.chinasoft.employee.dao.entity.UserRoleDO;
import com.chinasoft.employee.dao.entity.UserRoleDOExample;
import com.chinasoft.employee.dao.mapper.EmployeeDOExpansionMapper;
import com.chinasoft.employee.dao.mapper.EmployeeDOMapper;
import com.chinasoft.employee.dao.mapper.UserRoleDOMapper;
import com.chinasoft.employee.exception.BusinessException;
import com.chinasoft.employee.exception.EmBusinessError;
import com.chinasoft.employee.service.CSDeptService;
import com.chinasoft.employee.service.EmployeeQueryService;
import com.chinasoft.employee.service.PMOEmployeeExportService;
import com.chinasoft.employee.service.model.ExcelModel;
import com.chinasoft.employee.service.model.PMOAndEmployeeExportModel;
import com.chinasoft.employee.util.DateSyncUtil;
import com.chinasoft.employee.util.ExportExcelUtils;
import com.chinasoft.employee.util.StringToListUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PMOEmployeeExportServiceImpl implements PMOEmployeeExportService{
	
	@Autowired
	private EmployeeDOExpansionMapper employeeDOExpansionMapper;
	
	@Autowired
	private EmployeeQueryService employeeQueryService;
	
	@Autowired
	private EmployeeDOMapper employeeDOMapper;
	
	@Autowired
	private UserRoleDOMapper userRoleDOMapper;
	
	private static final String PMO_EXCEL_TITLE = "员工信息-";
	
	@Value("${employee.excel.address}")
	private String PATH;

	@Autowired
	CSDeptService csDeptService;
	
	@Override
	public void pmoEmployeeDataExport(HttpServletResponse response, String staffNameOrEhr, Integer filterCsdeptId,
			List<Integer> resourceStatus, String rmUserId,Integer engagementType,String csdeptId,String userType,String eHr) throws BusinessException {

		//初始化Excel文件及sheet名称
		String excelTitles = PMO_EXCEL_TITLE;
		List<EmployeeAndHsbcDO> employeeAndHsbcDOLst = null;
		List<CSDeptDO> csDeptDOList = new ArrayList<CSDeptDO>();
		CSDeptDO csDeptDO = new CSDeptDO();
		List<Integer> deptList = StringToListUtil.conversion(csdeptId);
		
		if (null == filterCsdeptId) {
			for(Integer dep:deptList) {
				List<CSDeptDO> csDeptDOs = csDeptService.getAllCSDeptById(dep);
				csDeptDOList.addAll(csDeptDOs);
			}
		} else {
			csDeptDOList = csDeptService.getAllCSDeptById(filterCsdeptId);
		}
		csDeptDOList.add(csDeptDO);

		if (userType.equals("5")) {// 5 RM.当前登录者是RM，且csdeptId不为空,则员工的RM_USER_ID为当前登录RM的userId
			EmployeeDOExample employeeExp1 = new EmployeeDOExample();
			com.chinasoft.employee.dao.entity.EmployeeDOExample.Criteria createCriteriaE = employeeExp1
					.createCriteria();
			createCriteriaE.andEHrEqualTo(eHr);// 由于登录使用benchpool表，其user_id和b_employee表的user_id目前无法匹配，所以使用E_HR进行查询匹配
			List<EmployeeDO> employeeDOList = employeeDOMapper.selectByExample(employeeExp1);

			UserRoleDOExample userDOExample = new UserRoleDOExample();
			if (employeeDOList.size() > 0) {
				com.chinasoft.employee.dao.entity.UserRoleDOExample.Criteria createCriteriaD = userDOExample
						.createCriteria();
				createCriteriaD.andEmployeeIdEqualTo(employeeDOList.get(0).getPkId());
				createCriteriaD.andCsdeptIdIn(deptList);
			}
			List<UserRoleDO> userIdList = userRoleDOMapper.selectByExample(userDOExample);
			if (userIdList.size() > 0) {
				rmUserId = userIdList.get(0).getPkId();
			} else {
				throw new BusinessException(EmBusinessError.USER_NOT_EXIT);
			}
		}
		employeeAndHsbcDOLst = employeeDOExpansionMapper.vagueQueryByStaffNameOrIdOrEhrOrLOBAndCSDeptDOListAndRmUserId(
				staffNameOrEhr, resourceStatus, csDeptDOList, rmUserId, rmUserId,engagementType);
		
		List<EmployeeAndHsbcDetailResponseVO> listResponse = employeeQueryService
				.employeeDBCodeToNameResponseVO(employeeAndHsbcDOLst, false);
		 List<PMOAndEmployeeExportModel> listResponseVO = employeeQueryService.employeeDBDateConversion(listResponse);
		 String fileName = setFileName(excelTitles);
		 ExcelModel data = new ExcelModel();
		 // 设置列表内容
		 data.setRows(listResponseVO);
		 try {
			// 调用导出功能实现Excel导出
			ExportExcelUtils.exportExcel(response, fileName + ".xlsx", data, PATH);
		 } catch (Exception e) {
			log.info("文件导出异常:[{}]", e.getMessage());
			throw new BusinessException(EmBusinessError.EXPORT_ERROR, e.getMessage());
		}
	}

	/**
	 * @param setFileName
	 * @return
	 */
	private String setFileName(String excelTitles) {
		StringBuffer sbf = new StringBuffer();
		sbf.append(excelTitles).append(DateSyncUtil.format(new Date(), DateSyncUtil.DATETIMEZONE));
		return sbf.toString();
	}

}

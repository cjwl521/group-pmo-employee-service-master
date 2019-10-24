package com.chinasoft.employee.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.chinasoft.employee.exception.BusinessException;

public interface PMOEmployeeExportService {
	
	void pmoEmployeeDataExport(HttpServletResponse response, String staffNameOrEhr, Integer filterCsdeptId,
			List<Integer> resourceStatus, String rmUserId, Integer engagementType, String csdeptId, String userType,
			String eHr) throws BusinessException;

}

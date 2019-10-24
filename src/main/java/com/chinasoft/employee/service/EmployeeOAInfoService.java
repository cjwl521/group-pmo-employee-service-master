package com.chinasoft.employee.service;

import java.util.List;

import com.chinasoft.employee.exception.BusinessException;
import com.chinasoft.employee.service.model.EmployeeInfoModel;

public interface EmployeeOAInfoService {

	public List<EmployeeInfoModel> readEmployeeInfo();
	
	public void upadateEmployeeInfo(List<EmployeeInfoModel> list) throws BusinessException;
}

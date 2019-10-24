package com.chinasoft.employee.dao.mapper;

import java.util.List;

import com.chinasoft.employee.controller.vo.request.AllEmployeeRequestVO;

public interface MsEmployeeCustomerDOMapper {
	
	int batchInsert(List<AllEmployeeRequestVO> records);
	
	int batchUpdate(List<AllEmployeeRequestVO> records);
}

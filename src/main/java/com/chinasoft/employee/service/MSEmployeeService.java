package com.chinasoft.employee.service;

import com.chinasoft.employee.controller.vo.request.AllEmployeeRequestVO;
import com.chinasoft.employee.exception.BusinessException;

public interface MSEmployeeService {

	/**
	 * 新增微软事业部员工特殊信息
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	public int insertMSEmp(AllEmployeeRequestVO vo) throws BusinessException;

	/**
	 * 编辑员工信息时根据情况update或insert ms emp信息
	 * @param vo
	 * @return
	 */
	int saveOrupdateMSEmp(AllEmployeeRequestVO vo);

}

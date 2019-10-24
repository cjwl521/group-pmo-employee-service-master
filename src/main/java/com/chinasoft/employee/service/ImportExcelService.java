package com.chinasoft.employee.service;

import com.chinasoft.employee.exception.BusinessException;

public interface ImportExcelService {

	/**
	 * 通过数据字典更新excel模板信息
	 * @return
	 * @throws BusinessException 
	 */
	public boolean updateExcelRules() throws BusinessException;
}

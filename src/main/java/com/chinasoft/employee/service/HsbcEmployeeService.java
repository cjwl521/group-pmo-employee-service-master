package com.chinasoft.employee.service;

import java.util.List;

import com.chinasoft.employee.controller.vo.request.AllEmployeeRequestVO;
import com.chinasoft.employee.exception.BusinessException;

public interface HsbcEmployeeService {
	/**
	 * 新增HSBC场内信息
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	public int insertEmpHSBC(AllEmployeeRequestVO vo) throws BusinessException;
    
	/**
	 * 更新HSBC场内信息
	 * @param vo
	 * @return
	 */
	int saveOrupdateEmpHSBC(AllEmployeeRequestVO vo);
    /**
     * 批量新增HSBC场内信息
     * @param hsbcEmployees
     * @return
     */
	public int batchInsertHsbcEmployees(List<AllEmployeeRequestVO> hsbcEmployees);
	/**
	 * 批量删除HSBC场内信息
	 * @param vos
	 */
	public int batchDeleteHsbcEmployees(List<AllEmployeeRequestVO> vos) throws BusinessException;
	
	/**
     * 批量修改HSBC场内信息
     * @param hsbcEmployees
     * @return
     */
	int batchUpdateHsbcEmployees(List<AllEmployeeRequestVO> hsbcEmployees);
}

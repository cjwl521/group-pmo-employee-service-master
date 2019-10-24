package com.chinasoft.employee.service;

import java.util.List;

import com.chinasoft.employee.controller.vo.request.AllEmployeeRequestVO;
import com.chinasoft.employee.controller.vo.response.EmployeeAndHsbcDetailResponseVO;
import com.chinasoft.employee.controller.vo.response.EmployeeAndHsbcResponseVO;
import com.chinasoft.employee.dao.entity.RMAllEmployeeDBResponse;
import com.chinasoft.employee.exception.BusinessException;
import com.chinasoft.employee.util.PrdPageInfo;
import com.github.pagehelper.PageInfo;

public interface EmployeeService {
	/**
	 * 员工录入基础信息
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	public int insertEmployee(AllEmployeeRequestVO vo) throws BusinessException;

	/**
	 * 更新员工基础信息
	 * @param vo
	 * @return
	 * @throws BusinessException 
	 */
	int updateByEmployeeId(AllEmployeeRequestVO vo) throws BusinessException;

	/**
	 * 获取所有员工详细信息
	 * @param userId
	 * @param userType
	 * @param csdeptId
	 * @param page
	 * @param pageSize
	 * @return
	 * @throws BusinessException
	 */
	public PrdPageInfo<EmployeeAndHsbcDetailResponseVO> getEmployeeDetails(String userId, Integer userType, Integer csdeptId,
			Integer page, Integer pageSize)throws BusinessException;

	/**
	 * 批量员工录入
	 * @param vos
	 */
	public int batchInsertEmployees(List<AllEmployeeRequestVO> vos) throws BusinessException;
	
	
	/**
	 * 批量员工修改
	 * @param vos
	 */
	public int batchUpdateEmployees(List<AllEmployeeRequestVO> vos) throws BusinessException;
	
	
}

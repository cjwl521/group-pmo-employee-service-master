package com.chinasoft.employee.service;

import java.util.List;

import com.chinasoft.employee.controller.vo.request.AllEmployeeRequestVO;
import com.chinasoft.employee.controller.vo.request.UserDeptAndTypeRequestVO;
import com.chinasoft.employee.exception.BusinessException;

public interface UserRoleService {
	/**
	 * 新增用户关联员工信息
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
     public int insertUserAndEmp(AllEmployeeRequestVO vo) throws BusinessException;
     /**
      * 修改用户关联员工信息
      * @param vo
      * @return
      * @throws BusinessException
      */
     int updateUserAndEmp(AllEmployeeRequestVO vo) throws BusinessException;
     /**
      * 批量添加用户关联员工信息
      * @param vos
      * @return
      */
	public int batchInsertUsersAndEmployees(List<AllEmployeeRequestVO> vos);
	/**
     * 批量修改用户关联员工信息
     * @param vos
     * @return
     */
	public int batchUpdateUsersAndEmployees(List<AllEmployeeRequestVO> vos) throws BusinessException;
	/**
	 * 一个员工拥有多个角色或部门
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	public int insertUser(UserDeptAndTypeRequestVO vo) throws BusinessException;
}

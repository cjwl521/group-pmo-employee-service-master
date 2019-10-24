package com.chinasoft.employee.service;

import java.util.List;
import java.util.Set;

import com.chinasoft.employee.controller.vo.request.AllEmployeeRequestVO;
import com.chinasoft.employee.controller.vo.request.UserRequestVO;
import com.chinasoft.employee.exception.BusinessException;
import com.chinasoft.employee.service.model.UserModel;

public interface UserService {
    /**
     * 新增登录用户信息
     * @param vo
     * @return
     * @throws BusinessException
     */
	public int insertUser(AllEmployeeRequestVO vo) throws BusinessException;
    /**
     * 修改登录用户信息
     * @param vo
     * @return
     * @throws BusinessException
     */
	public int updateUser(AllEmployeeRequestVO vo) throws BusinessException;
	/**
	 * 修改口令
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	public int updatePwd(UserRequestVO vo) throws BusinessException;
	/**
	 * 批量插入用户登录信息
	 * @param vos
	 * @return
	 */
	public int batchInsertUsers(List<AllEmployeeRequestVO> vos) throws BusinessException;
	/**
	 * 
	 * @param userName
	 * @param passWord
	 * @return
	 * @throws BusinessException
	 */
	public Set<UserModel> userLogin(String userName, String passWord) throws BusinessException;
	/**
	 * 批量修改用户登录信息
	 * @param vos
	 * @return
	 */
	int batchUpdateUser(List<AllEmployeeRequestVO> vos) throws BusinessException;
	
}

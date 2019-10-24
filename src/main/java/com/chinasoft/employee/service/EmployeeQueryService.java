package com.chinasoft.employee.service;

import java.util.List;

import com.chinasoft.employee.controller.vo.request.RMDisplayUserRequestVO;
import com.chinasoft.employee.controller.vo.request.UserRoleRequestVO;
import com.chinasoft.employee.controller.vo.response.EmployeeAndHsbcDetailResponseVO;
import com.chinasoft.employee.controller.vo.response.EmployeeAndHsbcResponseVO;
import com.chinasoft.employee.dao.entity.EmployeeAndHsbcDO;
import com.chinasoft.employee.exception.BusinessException;
import com.chinasoft.employee.service.model.PMOAndEmployeeExportModel;
import com.chinasoft.employee.service.model.RmInfoModel;
import com.chinasoft.employee.util.PrdPageInfo;

public interface EmployeeQueryService {
	
	/**
	 * 模糊查询员工信息列表，支持分页，支持条件，支持模糊查询
	 * @param staffNameOrEhr
	 * @param subdeptName
	 * @param resourceStatus
	 * @param pageNum
	 * @param pageSize
	 * @param csdeptId2 
	 * @param userType 
	 * @param userId 
	 * @return
	 * @throws BusinessException
	 */
	public PrdPageInfo<EmployeeAndHsbcDetailResponseVO> queryByStaffNameOrEhr(String staffNameOrEhr,
			Integer resourceStatus,Integer filterCsdeptId,Integer pageNum,Integer pageSize, String userId, Integer userType, Integer csdeptId) throws BusinessException;
	
	/**
     * 查询条件下的员工信息集合
     * @param displayUserRequestVO
     * @return
     */
    public PrdPageInfo<EmployeeAndHsbcDetailResponseVO> getOrFilterAllEmployeeByRM(RMDisplayUserRequestVO displayUserRequestVO) throws BusinessException;
     
     /**
      * 通过员工pkId查询员工详细信息
      * @param pkId
     * @param flag 
      * @return
      * @throws BusinessException
      */
     public EmployeeAndHsbcResponseVO queryEmployeeDetailByPkId(String pkId, String userId) throws BusinessException;
     /**
      * 查询员工详情
      * @param pkId
      * @param userType
      * @return
      * @throws BusinessException
      */
     public EmployeeAndHsbcDetailResponseVO queryEmployeeDetailByPkIdToName(String pkId, String userId)
			throws BusinessException;
     /**
      * 查询所有rm信息
      * @return
      * @throws BusinessException
      */
     public List<RmInfoModel> findRMAllInfo() throws BusinessException;

	/**
	 * 根据登录用户类型及部门查询所属rm信息
	 * @return
	 * @throws BusinessException
	 */
	public List<RmInfoModel> findRMAllInfoByLoginUser(UserRoleRequestVO userRoleRequestVO) throws BusinessException;
     
    /**
     * 数据库查询信息传化为前端显示名称
     * @param employeeDOList
     * @param flag
     * @return
     * @throws BusinessException
     */
     public List<EmployeeAndHsbcDetailResponseVO> employeeDBCodeToNameResponseVO(List<EmployeeAndHsbcDO> employeeDOList,
    		 Boolean flag) throws BusinessException;

     public List<PMOAndEmployeeExportModel>  employeeDBDateConversion(List<EmployeeAndHsbcDetailResponseVO> employeeResponseVO) throws BusinessException;




}

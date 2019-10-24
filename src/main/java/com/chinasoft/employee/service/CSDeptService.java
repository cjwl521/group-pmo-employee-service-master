package com.chinasoft.employee.service;

import java.util.List;
import java.util.Map;

import com.chinasoft.employee.controller.vo.request.UserRoleRequestVO;
import com.chinasoft.employee.controller.vo.response.CSDeptResponseVO;
import com.chinasoft.employee.controller.vo.response.HsbcCSDeptResponseVO;
import com.chinasoft.employee.dao.entity.CSDeptDO;
import com.chinasoft.employee.exception.BusinessException;

public interface CSDeptService {
	
    public List<CSDeptResponseVO> getAllCSDept(UserRoleRequestVO userRoleRequestVO) throws BusinessException;
    public List<CSDeptDO> getAllCSDeptByCSbuId(Integer csbuId) throws BusinessException;
    public List<CSDeptDO> getAllCSDeptByCSblId(Integer csblId) throws BusinessException;
    public Integer getCSbuIdByCSDeptId(Integer csDeptId) throws BusinessException;
    public Integer getCSblIdByCSDeptId(Integer csDeptId) throws BusinessException;
    public List<CSDeptResponseVO> getAllDeptByLoginUser(UserRoleRequestVO userRoleRequestVO) throws BusinessException;
    public List<HsbcCSDeptResponseVO> getHsbcDept() throws BusinessException;
    public List<CSDeptDO> getAllCSDeptByCSBGId(Integer csdeptId) throws BusinessException;
    public List<CSDeptDO> getAllCSDeptById(Integer csbgId) throws BusinessException;
    public List<CSDeptDO> getAllCSDeptById(Integer csbgId, Integer csLgId) throws BusinessException;
    public Map<String, Object> getHsbcDeptDiff() throws BusinessException;
}

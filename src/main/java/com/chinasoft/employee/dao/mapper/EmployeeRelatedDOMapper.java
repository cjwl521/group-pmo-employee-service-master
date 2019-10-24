package com.chinasoft.employee.dao.mapper;

import java.util.List;
import java.util.Map;

import com.chinasoft.employee.controller.vo.request.UserRoleRequestVO;
import com.chinasoft.employee.dao.entity.CSDeptDO;
import com.chinasoft.employee.service.model.RmInfoModel;
import org.apache.ibatis.annotations.Param;

public interface EmployeeRelatedDOMapper {
    
    String selectRmUserId(String rmName);
    Map<String, Object> selectBuIdAndCsdeptId(String subdeptName);
    String selectBlId(String buId);
    String selectEmpIdByUserId(String userId);
    int selectCsDeptId(String subdeptName);
    List<RmInfoModel> selectRmAllInfo(int userType);
    List<RmInfoModel> selectRmAllInfoByLoginUser(@Param("csDeptDOList") List<CSDeptDO> csDeptDOList, @Param("userType") int userType);
    String selectEmpIdByEhr(String eHr);
    List<String> selectAllEHr();

}
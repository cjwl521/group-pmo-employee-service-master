package com.chinasoft.employee.dao.mapper;

import java.util.List;

import com.chinasoft.employee.controller.vo.request.AllEmployeeRequestVO;
import com.chinasoft.employee.dao.entity.UserRoleDO;

public interface UserRoleOtherDOMapper {

	int batchInsert(List<UserRoleDO> userRoles);

	int batchUpdateUsersAndEmployees(List<AllEmployeeRequestVO> records);
}

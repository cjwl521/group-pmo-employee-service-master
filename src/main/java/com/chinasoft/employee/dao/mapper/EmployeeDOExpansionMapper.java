package com.chinasoft.employee.dao.mapper;

import java.util.List;

import com.chinasoft.employee.dao.entity.*;
import org.apache.ibatis.annotations.Param;

public interface EmployeeDOExpansionMapper {

    RMOneEmployeeDBDEtails findRMOneUserDetails(String employeeId);

    List<RMOneEmployeeDBPerformance> findRMOneUserPerformance(@Param("employeeId") String employeeId,
            @Param("lastQuarterYear") String lastQuarterYear,
            @Param("lastQuarterMonth") String lastQuarterMonth,
            @Param("lastLastQuarterYear") String lastLastQuarterYear,
            @Param("lastLastQuarterMonth") String lastLastQuarterMonth);
    
    List<EmployeeAndHsbcDO> selectByExample(EmployeeDOExample example);
    
    List<EmployeeAndHsbcDO> selectAllEmployees();
    
    RMEmployeeAndUserDetail findRMOneUser (String employeeId);

    //模糊查询
	List<EmployeeAndHsbcDO> selectByEmployeeStaffName(
			@Param("staffNameOrEhr") String staffNameOrEhr, 
			@Param("csdeptId") Integer csdeptId,
			@Param("resourceStatus") Integer resourceStatus);

	String selectNickNameByUserId(@Param("rmUserId") String rmUserId);

	List<EmployeeAndHsbcDO> queryEmployeeDetailByPkId(
			@Param("pkId") String pkId,
			@Param("roleId") String roleId
			);

	List<EmployeeAndHsbcDO> vagueQueryByStaffNameOrEhrAndCSDeptIdListAndRmUserId(
			@Param("staffNameOrEhr") String staffNameOrEhr, 
			@Param("resourceStatus") Integer resourceStatus,
			@Param("csDeptIdList") List<Integer> csDeptIdList,
			@Param("rmUserId") String rmUserId
			);
	List<EmployeeAndHsbcDO> vagueQueryByStaffNameOrIdOrEhrOrLOBAndCSDeptDOListAndRmUserId(
			@Param("staffNameOrIdOrEhrOrLOB") String staffNameOrIdOrEhrOrLOB,
			@Param("resourceStatusList") List<Integer> resourceStatusList,
			@Param("csDeptDOList") List<CSDeptDO> csDeptDOList,
			@Param("rmUserId") String rmUserId,
			@Param("filterRmUserId") String filterRmUserId,
			@Param("engagementType") Integer engagementType
	);
	List<EmployeeAndHsbcDO> vagueQueryByStaffNameOrEhrAndEmployeeIdLst(
			@Param("staffNameOrEhr") String staffNameOrEhr, 
			@Param("resourceStatus") Integer resourceStatus,
			@Param("filterCsdeptId") Integer filterCsdeptId, 
			@Param("employeeIdLst") List<String> employeeIdLst);

	List<EmployeeAndHsbcDO> vagueQueryByStaffNameOrEhrAndRmUserId(
			@Param("staffNameOrEhr") String staffNameOrEhr, 
			@Param("resourceStatus") Integer resourceStatus,
			@Param("filterCsdeptId") Integer filterCsdeptId, 
			@Param("rmUserId") String rmUserId,
			@Param("engagementType") Integer engagementType,
	        @Param("csdeptId") Integer csdeptId);

	List<EmployeeAndHsbcDO> selectPmoEmployeeData(
			@Param("staffNameOrEhr") String staffNameOrEhr, 
			@Param("csdeptId") Integer csdeptId, 
			@Param("resourceStatus") Integer resourceStatus);
	
	List<EmployeeAndUserRoleDO> queryLoginInfoBylob(@Param("lob") String lob);
	
	List<EhrAndEmpIdDO> queryEmployeeInfo();
	
	List<UserRoleIdDO> queryRoleAndEmpInfo();
}

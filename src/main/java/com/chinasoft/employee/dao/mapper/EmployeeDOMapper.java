package com.chinasoft.employee.dao.mapper;

import com.chinasoft.employee.controller.vo.request.AllEmployeeRequestVO;
import com.chinasoft.employee.dao.entity.EmployeeDO;
import com.chinasoft.employee.dao.entity.EmployeeDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmployeeDOMapper {
    long countByExample(EmployeeDOExample example);

    int deleteByExample(EmployeeDOExample example);

    int deleteByPrimaryKey(String pkId);

    int insert(EmployeeDO record);

    int insertSelective(EmployeeDO record);

    List<EmployeeDO> selectByExample(EmployeeDOExample example);

    EmployeeDO selectByPrimaryKey(String pkId);

    int updateByExampleSelective(@Param("record") EmployeeDO record, @Param("example") EmployeeDOExample example);

    int updateByExample(@Param("record") EmployeeDO record, @Param("example") EmployeeDOExample example);

    int updateByPrimaryKeySelective(EmployeeDO record);

    int updateByPrimaryKey(EmployeeDO record);

	int batchInsert(List<EmployeeDO> records);
	
	int batchUpdateEmployee(List<AllEmployeeRequestVO> records);

}
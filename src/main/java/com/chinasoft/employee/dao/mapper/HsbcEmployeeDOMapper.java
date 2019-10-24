package com.chinasoft.employee.dao.mapper;

import com.chinasoft.employee.controller.vo.request.AllEmployeeRequestVO;
import com.chinasoft.employee.dao.entity.HsbcEmployeeDO;
import com.chinasoft.employee.dao.entity.HsbcEmployeeDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HsbcEmployeeDOMapper {
    long countByExample(HsbcEmployeeDOExample example);

    int deleteByExample(HsbcEmployeeDOExample example);

    int deleteByPrimaryKey(String pkId);

    int insert(HsbcEmployeeDO record);

    int insertSelective(HsbcEmployeeDO record);

    List<HsbcEmployeeDO> selectByExample(HsbcEmployeeDOExample example);

    HsbcEmployeeDO selectByPrimaryKey(String pkId);

    int updateByExampleSelective(@Param("record") HsbcEmployeeDO record, @Param("example") HsbcEmployeeDOExample example);

    int updateByExample(@Param("record") HsbcEmployeeDO record, @Param("example") HsbcEmployeeDOExample example);

    int updateByPrimaryKeySelective(HsbcEmployeeDO record);

    int updateByPrimaryKey(HsbcEmployeeDO record);

	int batchInsert(List<HsbcEmployeeDO> records);
	
	int batchDelete(List<HsbcEmployeeDO> records);
	
	int batchUpdateHsbcEmployees(List<AllEmployeeRequestVO> records);
	
}
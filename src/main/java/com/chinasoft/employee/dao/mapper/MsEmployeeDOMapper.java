package com.chinasoft.employee.dao.mapper;

import com.chinasoft.employee.dao.entity.MsEmployeeDO;
import com.chinasoft.employee.dao.entity.MsEmployeeDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MsEmployeeDOMapper {
    long countByExample(MsEmployeeDOExample example);

    int deleteByExample(MsEmployeeDOExample example);

    int deleteByPrimaryKey(String pkId);

    int insert(MsEmployeeDO record);

    int insertSelective(MsEmployeeDO record);

    List<MsEmployeeDO> selectByExample(MsEmployeeDOExample example);

    MsEmployeeDO selectByPrimaryKey(String pkId);

    int updateByExampleSelective(@Param("record") MsEmployeeDO record, @Param("example") MsEmployeeDOExample example);

    int updateByExample(@Param("record") MsEmployeeDO record, @Param("example") MsEmployeeDOExample example);

    int updateByPrimaryKeySelective(MsEmployeeDO record);

    int updateByPrimaryKey(MsEmployeeDO record);
}
package com.chinasoft.employee.dao.mapper;

import com.chinasoft.employee.dao.entity.UserRoleDO;
import com.chinasoft.employee.dao.entity.UserRoleDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserRoleDOMapper {
    long countByExample(UserRoleDOExample example);

    int deleteByExample(UserRoleDOExample example);

    int deleteByPrimaryKey(String pkId);

    int insert(UserRoleDO record);

    int insertSelective(UserRoleDO record);

    List<UserRoleDO> selectByExample(UserRoleDOExample example);

    UserRoleDO selectByPrimaryKey(String pkId);

    int updateByExampleSelective(@Param("record") UserRoleDO record, @Param("example") UserRoleDOExample example);

    int updateByExample(@Param("record") UserRoleDO record, @Param("example") UserRoleDOExample example);
   
    int updateByPrimaryKeySelective(UserRoleDO record);

    int updateByPrimaryKey(UserRoleDO record);
}
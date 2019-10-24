package com.chinasoft.employee.dao.mapper;

import com.chinasoft.employee.dao.entity.UserTypeDO;
import com.chinasoft.employee.dao.entity.UserTypeDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserTypeDOMapper {
    long countByExample(UserTypeDOExample example);

    int deleteByExample(UserTypeDOExample example);

    int deleteByPrimaryKey(String pkId);

    int insert(UserTypeDO record);

    int insertSelective(UserTypeDO record);

    List<UserTypeDO> selectByExample(UserTypeDOExample example);

    UserTypeDO selectByPrimaryKey(String pkId);

    int updateByExampleSelective(@Param("record") UserTypeDO record, @Param("example") UserTypeDOExample example);

    int updateByExample(@Param("record") UserTypeDO record, @Param("example") UserTypeDOExample example);

    int updateByPrimaryKeySelective(UserTypeDO record);

    int updateByPrimaryKey(UserTypeDO record);
}
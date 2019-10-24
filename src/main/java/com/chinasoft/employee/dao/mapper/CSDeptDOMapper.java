package com.chinasoft.employee.dao.mapper;

import com.chinasoft.employee.dao.entity.CSDeptDO;
import com.chinasoft.employee.dao.entity.CSDeptDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CSDeptDOMapper {
    long countByExample(CSDeptDOExample example);

    int deleteByExample(CSDeptDOExample example);

    int deleteByPrimaryKey(Integer pkId);

    int insert(CSDeptDO record);

    int insertSelective(CSDeptDO record);

    List<CSDeptDO> selectByExample(CSDeptDOExample example);

    CSDeptDO selectByPrimaryKey(Integer pkId);

    int updateByExampleSelective(@Param("record") CSDeptDO record, @Param("example") CSDeptDOExample example);

    int updateByExample(@Param("record") CSDeptDO record, @Param("example") CSDeptDOExample example);

    int updateByPrimaryKeySelective(CSDeptDO record);

    int updateByPrimaryKey(CSDeptDO record);
}
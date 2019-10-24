package com.chinasoft.employee.dao.mapper;

import com.chinasoft.employee.dao.entity.DictionaryDO;
import com.chinasoft.employee.dao.entity.DictionaryDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DictionaryDOMapper {
    long countByExample(DictionaryDOExample example);

    int deleteByExample(DictionaryDOExample example);

    int deleteByPrimaryKey(String pkId);

    int insert(DictionaryDO record);

    int insertSelective(DictionaryDO record);

    List<DictionaryDO> selectByExample(DictionaryDOExample example);

    DictionaryDO selectByPrimaryKey(String pkId);

    int updateByExampleSelective(@Param("record") DictionaryDO record, @Param("example") DictionaryDOExample example);

    int updateByExample(@Param("record") DictionaryDO record, @Param("example") DictionaryDOExample example);

    int updateByPrimaryKeySelective(DictionaryDO record);

    int updateByPrimaryKey(DictionaryDO record);
}
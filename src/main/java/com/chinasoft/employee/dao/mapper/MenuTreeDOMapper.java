package com.chinasoft.employee.dao.mapper;

import com.chinasoft.employee.dao.entity.MenuTreeDO;
import com.chinasoft.employee.dao.entity.MenuTreeDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MenuTreeDOMapper {
    long countByExample(MenuTreeDOExample example);

    int deleteByExample(MenuTreeDOExample example);

    int deleteByPrimaryKey(String pkId);

    int insert(MenuTreeDO record);

    int insertSelective(MenuTreeDO record);

    List<MenuTreeDO> selectByExample(MenuTreeDOExample example);

    MenuTreeDO selectByPrimaryKey(String pkId);

    int updateByExampleSelective(@Param("record") MenuTreeDO record, @Param("example") MenuTreeDOExample example);

    int updateByExample(@Param("record") MenuTreeDO record, @Param("example") MenuTreeDOExample example);

    int updateByPrimaryKeySelective(MenuTreeDO record);

    int updateByPrimaryKey(MenuTreeDO record);
}
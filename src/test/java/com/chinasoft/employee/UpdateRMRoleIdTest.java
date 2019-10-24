package com.chinasoft.employee;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit4.SpringRunner;

import com.chinasoft.employee.dao.entity.EmployeeDO;
import com.chinasoft.employee.dao.entity.UserRoleDO;
import com.chinasoft.employee.dao.entity.UserRoleDOExample;
import com.chinasoft.employee.dao.entity.UserRoleDOExample.Criteria;
import com.chinasoft.employee.dao.entity.UserRoleIdDO;
import com.chinasoft.employee.dao.mapper.EmployeeDOExpansionMapper;
import com.chinasoft.employee.dao.mapper.EmployeeDOMapper;
import com.chinasoft.employee.dao.mapper.UserRoleDOMapper;
import com.chinasoft.employee.exception.BusinessException;
import com.chinasoft.employee.util.UUIDPrimaryKeyUtil;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UpdateRMRoleIdTest {

	@Autowired 
	private EmployeeDOExpansionMapper employeeDOMapper;
	@Autowired 
	private EmployeeDOMapper employeeMapper;
	@Autowired 
	private UserRoleDOMapper userRoleDOMapper;
	
	@Value("classpath:static/emp.json")
	private Resource resource;
	@Test
	public void updateAccountApply() throws BusinessException, JsonParseException, JsonMappingException,
			UnsupportedEncodingException, IOException {
		EmployeeDO employeeDO = new EmployeeDO();
		UserRoleDO userRoleDO = new UserRoleDO();
		String eId = UUIDPrimaryKeyUtil.generation();
		employeeDO.setPkId(eId);
		employeeDO.seteHr("admin");
		employeeDO.setStaffName("管理员");
		employeeDO.setResourceStatus(1);
		employeeDO.setLob("admin");
		employeeDO.setCreateTime(new Date());
		employeeDO.setUpdateTime(new Date());
		userRoleDO.setPkId(UUIDPrimaryKeyUtil.generation());
		userRoleDO.setEmployeeId(eId);
		userRoleDO.setCsdeptId(10001);
		userRoleDO.setMultipleRoles(false);
		userRoleDO.setUserType(0);
		userRoleDO.setDeleted(false);

		employeeMapper.insert(employeeDO);
		userRoleDOMapper.insert(userRoleDO);
	}
	
//	@Test
//	public void updateApply() throws BusinessException, JsonParseException, JsonMappingException,
//	UnsupportedEncodingException, IOException {
//		List<UserRoleIdDO> infoList = employeeDOMapper.queryRoleAndEmpInfo();
//		log.info("infoList:" + new ObjectMapper().writeValueAsString(infoList));
//		for (UserRoleIdDO doL : infoList) {
//			UserRoleDO userRoleDO = new UserRoleDO();
//			userRoleDO.setUserType(5);
//			UserRoleDOExample example = new UserRoleDOExample();
//			Criteria createCriteria = example.createCriteria();
//			createCriteria.andPkIdEqualTo(doL.getPkId());
//			userRoleDOMapper.updateByExampleSelective(userRoleDO, example);
//		}
//	}
}


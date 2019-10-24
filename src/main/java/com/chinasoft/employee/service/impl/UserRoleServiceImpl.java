package com.chinasoft.employee.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasoft.employee.controller.vo.request.AllEmployeeRequestVO;
import com.chinasoft.employee.controller.vo.request.UserDeptAndTypeRequestVO;
import com.chinasoft.employee.dao.entity.EmployeeDO;
import com.chinasoft.employee.dao.entity.EmployeeDOExample;
import com.chinasoft.employee.dao.entity.EmployeeDOExample.Criteria;
import com.chinasoft.employee.dao.entity.UserRoleDO;
import com.chinasoft.employee.dao.entity.UserRoleDOExample;
import com.chinasoft.employee.dao.mapper.EmployeeDOMapper;
import com.chinasoft.employee.dao.mapper.UserRoleDOMapper;
import com.chinasoft.employee.dao.mapper.UserRoleOtherDOMapper;
import com.chinasoft.employee.exception.BusinessException;
import com.chinasoft.employee.exception.EmBusinessError;
import com.chinasoft.employee.service.UserRoleService;
import com.chinasoft.employee.util.StringToListUtil;
import com.chinasoft.employee.util.UUIDPrimaryKeyUtil;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    
	@Autowired
	private UserRoleDOMapper userRoleDOMapper;
	@Autowired
	private UserRoleOtherDOMapper userRoleOtherDOMapper;
	
	@Autowired
	private EmployeeDOMapper employeeDOMapper;
	
	@Override
	public int insertUserAndEmp(AllEmployeeRequestVO vo) throws BusinessException {
		UserRoleDO record = new UserRoleDO();
		BeanUtils.copyProperties(vo, record);
		record.setPkId(UUIDPrimaryKeyUtil.generation());
		record.setEmployeeId(EmployeeServiceImpl.employeeId);
		if(null == record.getDeleted()) {
			record.setDeleted(false);
		}
		record.setMultipleRoles(false);
		//部门不存在，则不插入数据
		if(null == vo.getCsdeptId()) {
			throw new BusinessException(EmBusinessError.UNKNOW_ERROR, "所属部门不存在，请重新输入");
		}
		record.setCsdeptId(vo.getCsdeptId());
		int result = userRoleDOMapper.insert(record);
		return result;
	}

	@Override
	public int insertUser(UserDeptAndTypeRequestVO vo) throws BusinessException {
		List<UserRoleDO> userRoles = new ArrayList<UserRoleDO>();

		List<Integer> deptList = StringToListUtil.conversion(vo.getDeptId());
		List<Integer> userTypeList = StringToListUtil.conversion(vo.getUserType());
		EmployeeDOExample employeeDOExample = new EmployeeDOExample();
		Criteria criteria = employeeDOExample.createCriteria();
		criteria.andLobEqualTo(vo.getLob());
		List<EmployeeDO> employeeDOList = employeeDOMapper.selectByExample(employeeDOExample);
		
		for (int i = 0; i < deptList.size(); i++) {
			UserRoleDO record = new UserRoleDO();
			record.setPkId(UUIDPrimaryKeyUtil.generation());
			record.setEmployeeId(employeeDOList.get(0).getPkId());
			record.setDeleted(false);
			record.setMultipleRoles(true);
			record.setCsdeptId(deptList.get(i));
			record.setUserType(userTypeList.get(i));
			userRoles.add(record);
		}
		int result = userRoleOtherDOMapper.batchInsert(userRoles);
		return result;
	}
	
	@Override
	public int updateUserAndEmp(AllEmployeeRequestVO vo) throws BusinessException {
		UserRoleDO record = new UserRoleDO();
		BeanUtils.copyProperties(vo, record);
		//若员工职位为空，不允许修改
		if(vo.getUserType() == null){
			throw new BusinessException(EmBusinessError.UNKNOW_ERROR, "员工职位不能为空");
		}
		/* ------------查询所属部门Idstart---------*/
		//部门不存在，则不插入数据
		if(null == vo.getCsdeptId()) {
			throw new BusinessException(EmBusinessError.UNKNOW_ERROR, "所属部门不存在，请重新选择");
		}
		//不可以编辑员工部门信息
		record.setCsdeptId(null);
		/* ------------查询所属部门Idstart---------*/
		//String employeeId = employeeRelatedDOMapper.selectEmpIdByUserId(vo.getPkId());
		UserRoleDOExample example = new UserRoleDOExample();
		//用3个条件参数更改b_user_role表
		//example.createCriteria().andEmployeeIdEqualTo(employeeId).andUserTypeEqualTo(vo.getUserType()).andCsdeptIdEqualTo(vo.getCsdeptId());
//		example.createCriteria().andEmployeeIdEqualTo(vo.getPkId());
		example.createCriteria().andPkIdEqualTo(vo.getUserId());
		record.setEmployeeId(vo.getPkId());
		if(vo.getDeleted() == null) {
			record.setDeleted(false);
		}
		int result = userRoleDOMapper.updateByExampleSelective(record, example);
		return result;
	}

	@Override
	public int batchInsertUsersAndEmployees(List<AllEmployeeRequestVO> vos) {
		List<UserRoleDO> userRoles = new ArrayList<UserRoleDO>();
		for(AllEmployeeRequestVO vo : vos) {
			UserRoleDO record = new UserRoleDO();
			BeanUtils.copyProperties(vo, record);
			record.setPkId(UUIDPrimaryKeyUtil.generation());
			record.setCsdeptId(vo.getCsdeptId());
			userRoles.add(record);
		}
		return userRoleOtherDOMapper.batchInsert(userRoles);
	}
	
	@Override
	public int batchUpdateUsersAndEmployees(List<AllEmployeeRequestVO> vos) throws BusinessException {
		
		Integer usersAndEmployeesInt = userRoleOtherDOMapper.batchUpdateUsersAndEmployees(vos);
		return usersAndEmployeesInt;
	}
	

}

package com.chinasoft.employee.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasoft.employee.controller.vo.request.AllEmployeeRequestVO;
import com.chinasoft.employee.dao.entity.HsbcEmployeeDO;
import com.chinasoft.employee.dao.entity.HsbcEmployeeDOExample;
import com.chinasoft.employee.dao.mapper.EmployeeRelatedDOMapper;
import com.chinasoft.employee.dao.mapper.HsbcEmployeeDOMapper;
import com.chinasoft.employee.exception.BusinessException;
import com.chinasoft.employee.service.HsbcEmployeeService;
import com.chinasoft.employee.util.UUIDPrimaryKeyUtil;

@Service
public class HsbcEmployeeSeviceImpl implements HsbcEmployeeService {

	@Autowired
	HsbcEmployeeDOMapper hsbcEmployeeDOMapper;
	@Autowired
	EmployeeRelatedDOMapper employeeRelatedDOMapper;
	
	@Override
	public int insertEmpHSBC(AllEmployeeRequestVO vo) throws BusinessException {
		
		HsbcEmployeeDO record = new HsbcEmployeeDO();
		BeanUtils.copyProperties(vo, record);
		record.setPkId(UUIDPrimaryKeyUtil.generation());
		record.setEmployeeId(EmployeeServiceImpl.employeeId);
		int result = hsbcEmployeeDOMapper.insert(record);
		return result;
	}


	@Override
	public int saveOrupdateEmpHSBC(AllEmployeeRequestVO vo) {
	    HsbcEmployeeDO record = new HsbcEmployeeDO();
	    BeanUtils.copyProperties(vo, record);
		int result=0;
		if(vo.getEmployeeId()!=null) {
			HsbcEmployeeDOExample example = new HsbcEmployeeDOExample();
			example.createCriteria().andEmployeeIdEqualTo(vo.getEmployeeId());
			result = hsbcEmployeeDOMapper.updateByExampleSelective(record, example);
		}
		else {
            record.setEmployeeId(vo.getPkId());
			result = hsbcEmployeeDOMapper.insertSelective(record);
		}
	    return result;
	}


	@Override
	public int batchInsertHsbcEmployees(List<AllEmployeeRequestVO> hsbcEmployees) {
		List<HsbcEmployeeDO> records = new ArrayList<HsbcEmployeeDO>();
		for(AllEmployeeRequestVO hsbcEmployee : hsbcEmployees) {
			HsbcEmployeeDO record = new HsbcEmployeeDO();
			BeanUtils.copyProperties(hsbcEmployee, record);
			System.out.println(hsbcEmployee.getPkId());
			record.setEmployeeId(hsbcEmployee.getPkId());
			record.setPkId(UUIDPrimaryKeyUtil.generation());
			records.add(record);
		}
		return hsbcEmployeeDOMapper.batchInsert(records);
	}
	
	@Override
	public int batchDeleteHsbcEmployees(List<AllEmployeeRequestVO> hsbcEmployees) {
		List<HsbcEmployeeDO> records = new ArrayList<HsbcEmployeeDO>();
		for(AllEmployeeRequestVO hsbcEmployee : hsbcEmployees) {
			HsbcEmployeeDO record = new HsbcEmployeeDO();
			BeanUtils.copyProperties(hsbcEmployee, record);
			records.add(record);
		}
		return hsbcEmployeeDOMapper.batchDelete(records);
	}
	
	@Override
	public int batchUpdateHsbcEmployees(List<AllEmployeeRequestVO> vos) {
		Integer hsbcEmployeesInt = hsbcEmployeeDOMapper.batchUpdateHsbcEmployees(vos);
		return hsbcEmployeesInt;
	}
	
}

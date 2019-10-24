package com.chinasoft.employee.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasoft.employee.controller.vo.request.AllEmployeeRequestVO;
import com.chinasoft.employee.dao.entity.MsEmployeeDO;
import com.chinasoft.employee.dao.entity.MsEmployeeDOExample;
import com.chinasoft.employee.dao.mapper.MsEmployeeDOMapper;
import com.chinasoft.employee.exception.BusinessException;
import com.chinasoft.employee.service.MSEmployeeService;
import com.chinasoft.employee.util.UUIDPrimaryKeyUtil;

@Service
public class MSEmployeeServiceImpl implements MSEmployeeService {
	
	@Autowired
	private MsEmployeeDOMapper msEmployeeDOMapper;
	
	@Override
	public int insertMSEmp(AllEmployeeRequestVO vo) throws BusinessException {
		
		MsEmployeeDO record = new MsEmployeeDO();
		BeanUtils.copyProperties(vo, record);
		record.setPkId(UUIDPrimaryKeyUtil.generation());
		record.setEmployeeId(EmployeeServiceImpl.employeeId);
		int result = msEmployeeDOMapper.insert(record);
		return result;
	}
	
	@Override
	public int saveOrupdateMSEmp(AllEmployeeRequestVO vo) {
		MsEmployeeDO record = new MsEmployeeDO();
		int result = 0;
		if (vo.getEmployeeType() == 3) {
			MsEmployeeDOExample msEmployeeDOExample = new MsEmployeeDOExample();
			com.chinasoft.employee.dao.entity.MsEmployeeDOExample.Criteria createCriteria = msEmployeeDOExample
					.createCriteria();
			if (null != vo.getPkId()) {
				createCriteria.andEmployeeIdEqualTo(vo.getPkId());
				List<MsEmployeeDO> selectByExample = msEmployeeDOMapper.selectByExample(msEmployeeDOExample);
				if (null != selectByExample && selectByExample.size() > 0) {
					MsEmployeeDOExample example = new MsEmployeeDOExample();
					BeanUtils.copyProperties(vo, record);
					example.createCriteria().andEmployeeIdEqualTo(vo.getPkId());
					result = msEmployeeDOMapper.updateByExampleSelective(record, example);
				} else {
					record.setPkId(UUIDPrimaryKeyUtil.generation());
					record.setEmployeeId(vo.getPkId());
					record.setMsLevel(vo.getMsLevel());
					result = msEmployeeDOMapper.insertSelective(record);
				}
			}
		}
		return result;
	}

}

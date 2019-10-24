package com.chinasoft.employee;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.chinasoft.employee.exception.BusinessException;
import com.chinasoft.employee.service.EmployeeOAInfoService;
import com.chinasoft.employee.service.model.EmployeeInfoModel;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeOAInfoImplTest {

	@Autowired 
	private EmployeeOAInfoService EmployeeOAInfoService;
	
	@Test
	public void updateApplyStatusSchedu() throws BusinessException{
		
		List<EmployeeInfoModel> readEmployeeInfo = EmployeeOAInfoService.readEmployeeInfo();
		if (readEmployeeInfo.size() > 0) {
			EmployeeOAInfoService.upadateEmployeeInfo(readEmployeeInfo);
		}
	}
}

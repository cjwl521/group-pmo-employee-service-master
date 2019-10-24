package com.chinasoft.employee;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.chinasoft.employee.exception.BusinessException;
import com.chinasoft.employee.service.ImportExcelService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ImportExcelServiceImplTest {
	@Autowired
	private ImportExcelService importExcelService;
	
	@Test
	public void updateExcelRulesTest() {
		try {
			importExcelService.updateExcelRules();
		} catch (BusinessException e) {
			e.printStackTrace();
		}
	}
}

package com.chinasoft.employee.schedule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.chinasoft.employee.exception.BusinessException;
import com.chinasoft.employee.service.EmployeeOAInfoService;
import com.chinasoft.employee.service.model.EmployeeInfoModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableScheduling
public class ScheduConfig {
	
	@Autowired 
	private EmployeeOAInfoService EmployeeOAInfoService;
	
	@Scheduled(cron = "${applyStatus.time.cron}")
	public void updateApplyStatusSchedu() throws BusinessException{
		
		List<EmployeeInfoModel> readEmployeeInfo = EmployeeOAInfoService.readEmployeeInfo();
		if (readEmployeeInfo.size() > 0) {
			EmployeeOAInfoService.upadateEmployeeInfo(readEmployeeInfo);
		}
		long startTime = System.currentTimeMillis();
		log.info("updateApplyStatusSchedu Request spend time is: {}ms", String.valueOf(System.currentTimeMillis() - startTime));
	}
}

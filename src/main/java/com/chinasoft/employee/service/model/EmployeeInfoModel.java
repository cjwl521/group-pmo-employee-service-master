package com.chinasoft.employee.service.model;

import java.util.Date;

import lombok.Data;

@Data
public class EmployeeInfoModel {
	private String LOB_NUMBER;
	private String EMPLOYEE_NUMBER;
	private String LAST_NAME;
	private Date HIRE_DATE;
	private String GP_NAME;
	private String LOB_GROUP;
	private String LOB;
	private String BUDU;
	private String DD;
	private String ONWERSHIP_PLACE;
	private String JOB_NAME;
	private String ACTUAL_TERMINATION_DATE;
}

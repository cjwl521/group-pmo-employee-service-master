package com.chinasoft.employee.controller.vo.response;

import java.util.List;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CSDeptResponseVO {
	
	/** 部门id*/
	//private Integer pkId; 
	private Integer value;
	/** 部门名称*/
	//private String  cSDeptName;
	private String  label;
	private List<CSDeptResponseVO>  children;

}

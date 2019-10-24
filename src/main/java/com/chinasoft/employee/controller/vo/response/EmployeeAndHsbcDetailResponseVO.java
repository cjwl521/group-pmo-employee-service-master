package com.chinasoft.employee.controller.vo.response;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class EmployeeAndHsbcDetailResponseVO extends EmployeeAndHsbcBaseResponseVO {
	
	
	
	/** b_employee表*/
    private String staffRegion; //员工所属地区（西安、广州、上海、深圳、香港、印度、马来西亚等）

    private String staffLocation; //员工所属国家（中国、马来西亚、香港、印度等）
    
    private String role; //员工级别（Trainee,Junior,Intermediate,Senior）

    private String skill; //技能/技术

    private String engagementType; //合同类型

    private String billRateType; //单价类型：小时、天、月

    private String billCurrency; //币种
    
    private String employeeType; //员工类型:Chinasoft/HSBC/Microsoft

    private String resourceStatus; //员工状态（Active/Terminated/Released）

    /**选填信息*/
	private Integer assessed;
	
	/** b_hsbc_employee表*/
    private String locationType; //办公场所类型（汇丰场内或者离岸办公场所）

    private String onshoreOrOffshore; //在岸人员或者离岸人员

    private String gbGf; //汇丰所属一级部门
    
    private String hsbcSubdeptId; //汇丰所属二级部门

    private String hsbcThridDeptId; //汇丰所属三级部门

	private String tlType; //项目组长类型
	
	private String msaRole; //MSARole
	 
	/** b_user_role表*/
	private String  userType; //员工职位
	
	private String csdeptId;
	
	private String csbu;//事业部
	
	private String csbl;//业务线
	
	private String csbg;//业务线
	
	private String podtlString;
	
    private String msLevel; //msLevel
}

package com.chinasoft.employee.service.model;

import lombok.Data;

@Data
public class PMOAndEmployeeExportModel {
	/** b_employee表*/
	private String pkId; //主键
	
	private String userId; //用户Id,对应b_user表的pk_id

	private String eHr; //E-HR账号
	
	private String lob; //LOB工号

	private String staffName; //员工姓名

	private String rmUserId; //所属RM USER_ID
	
    private Double  billRate; //单价
  
    /**选填信息*/
    private String graduationDate; //毕业时间

    private String entryDate; //入职日期
    
    private String email; //邮箱

    private String csiProNumber; //中软项目编号

    private String csiProStartdate; //中软项目开始日期

    private String csiProName; //中软项目名称

    private Double itindustryWorkYear; //IT行业工作年限

    private String terminationDate; //离职日期

    private String  reasonForTermination; //离职原因
    
	private String  createTime;
	private String  updateTime;
	private String  backBone;
	
	/** b_hsbc_employee表*/
	private String  hsbcStaffId; //汇丰员工账号

    private String  ln; //员工英文名

    private String  hsbcManager; //汇丰方经理

    private String sow; //SOW编号

	private String sowExpiredDate; //SOW截至日期

	private String hsbcDoj; //入场日期

	private String hsbcPod; //员工所属的汇丰POD项目名称

	private String podtl; //员工是否在此POD中是TL

	private String hsbcProjectName; //项目名称
	 
	private String staffCategory; //员工类别
	 
	private String mentionLwd; //离场日期
	
	/** b_user表*/
	private String   userName; //登录名——暂存E-HR账号
	private String   nickname; //员工姓名
	private String   password;
	private String   salt;
	
	/** b_user_role表*/
	private String   employeeId; //员工在 employ 表中的id
	
	private Boolean  deleted; //删除状态-1 表示标记删除
	
	/** 其他字段*/
	private String   rmName; //所属rm姓名
	
	/**b_cs_dept */
	private String subdeptName; //中软所属部门
	
	private String staffRegion;
	
	private String staffLocation;
	
	private String role;
	
	private String csdeptId;
	
	private String skill;
	
	private String engagementType;
	
	private String billRateType;
	
	private String billCurrency;
	
	private String employeeType;
	
	private String resourceStatus;
	private String userType;
	private String onshoreOrOffshore;
	private String locationType;
	private String tlType;
	
	private String gbGf;
	private String hsbcSubdeptId;
	private String hsbcThridDeptId;
	
	private String csbu;
	private String csbl;
	private String csbg;
	private String msaRole;
	private String msLevel;

}

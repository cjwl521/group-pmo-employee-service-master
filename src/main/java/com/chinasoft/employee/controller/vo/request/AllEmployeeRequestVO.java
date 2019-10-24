package com.chinasoft.employee.controller.vo.request;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AllEmployeeRequestVO {
	/** 主键*/
	private String pkId;
	private String userId;
	/** E-HR账号*/
	private String eHr;
	/** LOB工号*/
	private String lob;
	/** 员工姓名*/
    private String staffName;
    /** 所属RM USER_ID*/
    private String rmUserId;
    /** 员工所属地区（西安、广州、上海、深圳、香港、印度、马来西亚等）*/
    private Integer staffRegion;
    /** 员工所属国家（中国、马来西亚、香港、印度等）*/
    private Integer staffLocation;
    /** 员工级别（Trainee,Junior,Intermediate,Senior）*/
    private Integer role;
    /** 技能/技术*/
    private Integer skill;
    /** 合同类型*/
    private Integer engagementType;
    /** 单价类型：小时、天、月*/
    private Integer billRateType;
    /** 币种*/
    private Integer billCurrency;
    /** 单价*/
    private BigDecimal  billRate;
    /** 员工类型:Chinasoft/HSBC/Microsoft*/
    private Integer employeeType;
    /** 员工状态（Active/Terminated/Released）*/
    private Integer resourceStatus;
    /** 毕业时间*/
    private Date    graduationDate;
    /** 入职日期*/
    private Date    entryDate;
    private String  email;
    /** 中软项目编号*/
    private String  csiProNumber;
    /** 中软项目开始日期*/
    private Date    csiProStartdate;
    /** 中软项目名称*/
    private String  csiProName;
    /** IT行业工作年限*/
    private BigDecimal itindustryWorkYear;
    /** 离职日期*/
    private Date    terminationDate;
    /** 离职原因*/
    private String  reasonForTermination;
	private Date    createTime;
	private Date    updateTime;
	private String  backBone;
	private Integer assessed;
	
	//b_hsbc_employee表
	
    /** 汇丰员工账号*/
    private String  hsbcStaffId; 
    /** 员工英文名*/
    private String  ln; 
    /** 办公场所类型（汇丰场内或者离岸办公场所）*/
    private Integer locationType; 
    /** 在岸人员或者离岸人员*/
    private Integer onshoreOrOffshore; 
    /** 汇丰所属一级部门*/
    private Integer gbGf; 
    /** 汇丰所属二级部门*/
    private Integer hsbcSubdeptId;
    /** 汇丰所属三级部门*/
    private Integer hsbcThridDeptId;
    /** 汇丰方经理*/
    private String  hsbcManager;
    /** SOW编号*/
	 private String sow;
	 /** SOW截至日期*/
	 private Date sowExpiredDate;
	 /** 入场日期*/
	 private Date hsbcDoj;
	 /** 员工所属的汇丰POD项目名称*/
	 private String hsbcPod;
	 /** 员工是否在此POD中是TL*/
	 private Boolean podtl;
	 /** 项目组长类型*/
	 private Integer tlType;
	 /** 项目名称*/
	 private String hsbcProjectName;
	 private String staffCategory;
	 /** 出场日期*/
	 private Date mentionLwd;
	 /** MSARole*/
	 private Integer msaRole;
	
	//b_user_employee表
	private String   employeeId;
	/** 员工职位*/
	private Integer  userType;
	private Integer   csdeptId;
	/** 删除状态-1 表示标记删除*/
	private Boolean  deleted;
	
	//其他字段
	/** 所属rm*//*
	private String   rmName;*/
	/** 中软所属部门*/
	private String   subdeptName;
	/** 0表示不变，1表示中软到汇丰，2表示汇丰到中软*/
	private Integer  hsbcFlag;
	private Integer msLevel;
}

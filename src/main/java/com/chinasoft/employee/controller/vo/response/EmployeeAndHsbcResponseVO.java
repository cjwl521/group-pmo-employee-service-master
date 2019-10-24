package com.chinasoft.employee.controller.vo.response;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class EmployeeAndHsbcResponseVO {

	/** b_employee表*/
	private String pkId; //主键
	
	private String userId; //用户Id,对应b_user表的pk_id

	private String eHr; //E-HR账号
	
	private String lob; //LOB工号

	private String staffName; //员工姓名

	private String rmUserId; //所属RM USER_ID
	
    private Integer staffRegion; //员工所属地区（西安、广州、上海、深圳、香港、印度、马来西亚等）

    private Integer staffLocation; //员工所属国家（中国、马来西亚、香港、印度等）
    
    private Integer role; //员工级别（Trainee,Junior,Intermediate,Senior）

    private Integer skill; //技能/技术

    private Integer engagementType; //合同类型

    private Integer billRateType; //单价类型：小时、天、月

    private Integer billCurrency; //币种
    
    private Double  billRate; //单价
  
    private Integer employeeType; //员工类型:Chinasoft/HSBC/Microsoft

    private Integer resourceStatus; //员工状态（Active/Terminated/Released）

    /**选填信息*/
    private Date graduationDate; //毕业时间

    private Date entryDate; //入职日期
    
    private String email; //邮箱

    private String csiProNumber; //中软项目编号

    private Date csiProStartdate; //中软项目开始日期

    private String csiProName; //中软项目名称

    private Double itindustryWorkYear; //IT行业工作年限

    private Date terminationDate; //离职日期

    private String  reasonForTermination; //离职原因
    
	private Date    createTime;
	private Date    updateTime;
	private String  backBone;
	private Integer assessed;
	
	/** b_hsbc_employee表*/
	private String  hsbcStaffId; //汇丰员工账号

    private String  ln; //员工英文名

    private Integer locationType; //办公场所类型（汇丰场内或者离岸办公场所）

    private Integer onshoreOrOffshore; //在岸人员或者离岸人员

    private Integer gbGf; //汇丰所属一级部门
    
    private Integer hsbcSubdeptId; //汇丰所属二级部门

    private Integer hsbcThridDeptId; //汇丰所属三级部门

    private String  hsbcManager; //汇丰方经理

    private String sow; //SOW编号

	 private Date sowExpiredDate; //SOW截至日期

	 private Date hsbcDoj; //入场日期

	 private String hsbcPod; //员工所属的汇丰POD项目名称

	 private Boolean isPodtl; //员工是否在此POD中是TL

	 private Integer tlType; //项目组长类型
	 
	 private String hsbcProjectName; //项目名称
	 
	 private String staffCategory; //员工类别
	 
	 private Date mentionLwd; //离场日期
	 
	 private Integer msaRole; //MSAROLE
	 private Integer msLevel; //msLevel
	
	 /** b_user表*/
	private String   userName; //登录名——暂存E-HR账号
	private String   nickname; //员工姓名
	private String   password;
	private String   salt;
	
	/** b_user_role表*/
	private String   employeeId; //员工在 employ 表中的id
	private Integer  userType; //员工职位
	private Integer   csdeptId; //中软所属部门Id
	//private String   buId;
	//private String   blId;
	private Boolean  deleted; //删除状态-1 表示标记删除
	
	/** 其他字段*/
	private String   rmName; //所属rm姓名
	
	/**b_cs_dept */
	private String subdeptName; //中软所属部门
	private String csdeptAllId; //中软所属部门
	
}

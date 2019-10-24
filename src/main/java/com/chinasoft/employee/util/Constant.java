package com.chinasoft.employee.util;
/**
 * 常量
 * @author wangchi
 *
 */
public class Constant {

	public static final int SUPER_ADMIN = 1;
	
	/**
	 * 数据字典
	 */
	public enum DataDictionary {
		/** 员工所属地区（西安、广州、上海、深圳、香港、印度、马来西亚等）*/
		STAFF_REGION(1),
        /** 资源属性 */
		RESOURCE_PROPS_TYEP_CODE(2),
        /** 技能  */
        SKILL_TYPE_CODE(3),
		/** 交付部    */
    	SUBDEPT_TYPE_CODE(4),
		/** 锁定状态 */
		LOCKED_STATUS_TYEP_CODE(5),
		/** 审核结果 */
		APPROVE_RESULT_TYEP_CODE(6),
		/** 申请状态 */
		APPLY_STATUS_TYEP_CODE(7),
		/** 等级 */
		ROLE_CODE(8),//role
		/** 释放原因 */
		RELEASE_REASON_CODE(9),
		/** 员工所属国家（中国、马来西亚、香港、印度等） */
		STAFF_LOCATION(10),
		/** 合同类型  */
		ENGAGEMENT_TYPE(11),
		/** 单价类型：小时、天、月  */
		BILL_RATE_TYPE(12),
		/** 币种  */
		BILL_CURRENCY(13),
		/** 员工类型:Chinasoft/HSBC/Microsoft  */
		EMPLOYEE_TYPE(14),
		/** 员工状态 */
		RESOURCE_STATUS_TYEP_CODE(15),
		/**HSBC一级, 二级部门*/
		HSBC_DEPT(16),
		/** 员工职位  */
		USER_TYPE(17),
		/** 在岸人员或者离岸人员  */
		ONSHORE_OR_OFFSHORE(18),
		/**HSBC项目组领导*/
		HSBC_TEAM_LEADER(19),
		/** 办公场所类型（汇丰场内或者离岸办公场所） */
		LOCATION_TYPE(20),
		/** 客户定级 */
		MSA_ROLE_CODE(21),//MSARole
		/** 事业部 */
    	BUSINESS_UNIT_TYPE_CODE(22),
    	/** 业务线*/
		BUSINESS_LINE_TYPE_CODE(23),
		/** 业务群*/
		BUSINESS_GROUP_TYPE_CODE(25),
		
		MS_LEVEL(26);

		private int value;

        DataDictionary(int value) {
            this.value = value;
        }
        public int getValue() {
            return value;
        }
    }
	/**
	 * 审核状态
	 */
	public enum ApplyStatusCode{
        /** 待审批*/
		APPROVING(1),
    	/** 待审批*/
    	APPROVED(2),
        /** 待核对  */
    	CHECKING(3),
        /** 核对完成 */
    	CHECKED(4);
        
        private int value;

        ApplyStatusCode(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
	/**
	 * 审批结果
	 */
	public enum ApproveResultCode{
        /** 审批通过*/
    	YES(1),
		NO(2);

        private int value;

        ApproveResultCode(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
	/**
	 * 锁定状态
	 */
	public enum LockedStatusCode{
		 /** 已审核  */
    	AVAILABLE(1),
         /** 待入池 */
    	WAIT_IN_POOL(2);
       
        private int value;

        LockedStatusCode(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
	/**
	 * 锁定状态
	 */
	public enum ResourceStatus{
		 /** 在职 */
		Active(1),
         /** 释放资源 */
		Released(2),
		 /** 离职资源 */
		Terminated(3);
       
        private int value;

        ResourceStatus(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
	public enum ExcelTitleCode {
		EHr(2),
		lob(3),
		staffName(4),
		email(5),
		userType(6),
		role(7),
		skill(8),
		staffLocation(9),
		staffRegion(10),
		rmName(11),
        csbg(12),
        csbl(13),
		csbu(14),
		csdeptId(15),
		engagementType(16),
		graduationDate(17),
		entryDate(18),
		billRateType(19),
		billCurrency(20),
		billRate(21),
		csiProNumber(22),
		csiProStartdate(23),
		csiProName(24),
		itindustryWorkYear(25),
		employeeType(26),
		resourceStatus(27),
		terminationDate(28),
        reasonForTermination(29),
		hsbcStaffId(30),
		ln(31),
		locationType(32),
		onshoreOrOffshore(33),
		gbGf(34),
		hsbcSubdeptId(35),
		hsbcThridDeptId(36),
		hsbcManager(37),
		hsbcProjectName(38),
		sow(39),
		sowExpiredDate(40),
		hsbcDoj(41),
		hsbcPod(42),
		podtl(43),
		tlType(44),
		msaRole(45),
		msLevel(46);

		private int value;

		ExcelTitleCode(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}
	}

	public enum ExcelTitleName {
		No("No."),
	    EHR("E-HR"),
		LOB("LOB"),
		StaffName("Staff Name"),
		EMail("E-Mail"),
		Position("Position"),
		Level("Level"),
		Skills("Skills/Technology"),
		StaffLocation("Staff Location (country)"),
		StaffRegion("Staff Region"),
		RM("RM"),
		业务群("业务群"),
		业务线("业务线"),
		事业部("事业部"),
		CSDept("CS Dept"),
		EngagementType("Engagement Type (T&M/FixedCost)"),
		GraduationDate("Graduation Date"),
		EntryDate("Entry Date"),
		BillRateType("BillRateType"),
		BillingCurrency("Billing Currency"),
		BillRate("Bill Rate"),
		CSIProNumber("CSI Pro Number"),
		CSIProStartDate("CSI Pro StartDate"),
		CSIProName("CSI Pro Name"),
		Itworkyear("Itworkyear"),
		EmployeeType("EmployeeType"),
		ResourceStatus("Resource Status (Active/Terminated)"),
		IfterminatedmentionLWD("If terminated mention LWD"),
		ReasonforTermination("Reason for Termination"),
		HSBCStaffID("HSBCStaffID"),
		LN("LN"),
		LocationType("Location Type (HSBCOffice/ODC)"),
		OnshoreorOffshore("Onshore or Offshore"),
		GBGF("GB/GF"),
		HSBCDept("HSBC Dept  (BF Level 4 Name)"),
		HSBCSubDept("HSBC Sub Dept  (BF Level 5 Name)"),
		HSBCManager("HSBC Manager"),
		ProjectName("Project Name"),
		SOW("SOW#"),
		SOWExpiredDate("SOW# Expired Date"),
		HSBCDOJ("HSBC DOJ"),
		HSBCPOD("HSBC POD"),
		PODTeamLeader("POD Team Leader"),
		TeamLeaderType("Team Leader Type"),
		msaRole("客户定级(HSBC)"),
		msLevel("客户定级(Microsoft)");
		
		public String enumField;
        // 构造方法
        private ExcelTitleName(String name) {
            this.enumField = name;
        }
	}
	
	public enum ExcelTitleMappingCode {
	
		staffRegion("Staff Region"),
		staffLocation("Staff Location (country)"),
		engagementType("Engagement Type"),
		billRateType("BillRateType"),
		billingCurrency("Billing Currency"),
		employeeType("EmployeeType"),
		resourceStatus("Resource Status (Active/Terminated)"),
		gbgf("GB/GF"),
		hsbcDepts("HSBC Dept  (BF Level 4 Name)"),
		hsbcSubDepts("HSBC Sub Dept  (BF Level 5 Name)"),
		position("Position"),
		onshoreOrOffshore("Onshore or Offshore"),
		hsbcTeamLeaderType("Team Leader Type"),
		locationType("Location Type (HSBCOffice/ODC)"),
		MSARole("客户定级（HSBC)"),
		skill("Skills/Technology"),
		role("Level"),
		businessGroup("业务群"),
		businessLine("业务线"),
		businessUnit("事业部"),
		subdeptName("交付部"),
		yesOrNo("POD Team Leader"),
		msLevel("客户定级（Microsoft）"),
        rm("RM");
		public String enumField;
        // 构造方法
        private ExcelTitleMappingCode(String name) {
            this.enumField = name;
        }
	}
}

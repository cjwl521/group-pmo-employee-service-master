DROP PROCEDURE IF EXISTS `import_userInfo`;

CREATE PROCEDURE `import_userInfo`()
BEGIN

declare var_EMPLOYEE_TYPE varchar(100);
declare var_HSBC_STAFF_ID varchar(100);
declare var_STAFF_NAME varchar(100);
declare var_LN varchar(100);
declare var_STAFF_REGION varchar(100);
declare var_STAFF_LOCATION varchar(100);
declare var_LOCATION_TYPE varchar(100);
declare var_ONSHORE_OR_OFFSHORE varchar(100);
declare var_SOW varchar(100);
declare var_SOW_EXPIRED_DATE varchar(100);
declare var_STAFF_CATEGORY varchar(100);
declare var_ENGAGEMENT_TYPE varchar(100);
declare var_HSBC_DOJ varchar(100);
declare var_GRADUATION_DATE varchar(100);
declare var_BILL_CURRENCY varchar(100);
declare var_BILL_RATE_TYPE varchar(100);
declare var_BILL_RATE varchar(100);
declare var_RESOURCE_STATUS varchar(100);
declare var_MENTION_LWD varchar(100);
declare var_REASON_FOR_TERMINATION varchar(100);
declare var_E_HR varchar(100);
declare var_HSBC_SUBDEPT_ID varchar(100);
declare var_SKILL varchar(100);
declare var_ROLE varchar(100);
declare var_CS_SUBDEPT_ID varchar(100);
declare var_LOB varchar(100);
declare var_INTERVIERW_STATUS varchar(100);
declare var_HSBC_MANAGER varchar(100);
declare var_HSBC_PROJECT_NAME varchar(100);
declare var_RM_USER_ID varchar(100);
declare var_Email varchar(100);
declare var_GB_GF varchar(100);
declare var_ENTRY_DATE varchar(100);
declare var_CREATE_TIME varchar(100);
declare var_UPDATE_TIME varchar(100);
declare var_ITINDUSTRY_WORK_YEAR varchar(100);
declare var_CSI_PRO_NUMBER varchar(100);
declare var_CSI_PRO_STARTDATE varchar(100);
declare var_CSI_PRO_NAME varchar(100);
declare var_HSBC_POD varchar(100);
declare var_PODTL varchar(100);
declare var_TL_TYPE varchar(100);
declare var_BACKBONE varchar(100);
declare var_ASSESSED varchar(100);
--    遍历数据结束标志
  declare done int default false;
	
--    声明游标
  declare cursor_employee cursor for 	select  
	case when EMPLOYEE_TYPE = 'HSBC' then 2 else 1 end	EMPLOYEE_TYPE,
	HSBC_STAFF_ID,
	STAFF_NAME,`LN`,
	(select RELATED_CODE from b_data_dictionary where TYPE_NAME='staffRegion' and RELATED_NAME=STAFF_REGION) STAFF_REGION,
	(select RELATED_CODE from b_data_dictionary where TYPE_NAME='staffLocation' and RELATED_NAME=STAFF_LOCATION) STAFF_LOCATION,
 (select RELATED_CODE from b_data_dictionary where TYPE_NAME='locationType' and RELATED_NAME=LOCATION_TYPE) LOCATION_TYPE,
 (select RELATED_CODE from b_data_dictionary where TYPE_NAME='onshoreOrOffshore' and RELATED_NAME=ONSHORE_OR_OFFSHORE) ONSHORE_OR_OFFSHORE,
	SOW,
	SOW_EXPIRED_DATE,
	STAFF_CATEGORY,
	(select RELATED_CODE from b_data_dictionary where TYPE_NAME='engagementType' and RELATED_NAME=ENGAGEMENT_TYPE) ENGAGEMENT_TYPE,
	HSBC_DOJ,
	GRADUATION_DATE,
	(select RELATED_CODE from b_data_dictionary where TYPE_NAME='billingCurrency' and RELATED_NAME=BILL_CURRENCY) BILL_CURRENCY,
	(select RELATED_CODE from b_data_dictionary where TYPE_NAME='billRateType' and RELATED_NAME=BILL_RATE_TYPE) BILL_RATE_TYPE,
	TRIM(BILL_RATE) BILL_RATE,
	(select RELATED_CODE from b_data_dictionary where TYPE_NAME='resourceStatus' and RELATED_NAME=RESOURCE_STATUS) RESOURCE_STATUS,
	date(MENTION_LWD) MENTION_LWD,
	REASON_FOR_TERMINATION,
	E_HR,
	HSBC_SUBDEPT_ID,
	(select RELATED_CODE from b_data_dictionary where TYPE_NAME='skill' and RELATED_NAME=SKILL) SKILL,
	 case when ROLE = 'Trainee' then 1
	 when ROLE = 'Junior Developer' then 2
	 when ROLE = 'Junior Tester' then 2
	 when ROLE = 'Tester' then 3
	 when ROLE = 'Developer' then 3
	 when ROLE = 'Intermediate Tester' then 3
	 when ROLE = 'Senior Developer' then 4
	 when ROLE = 'SeniorTester' then 4
	 when ROLE = 'Senior Developer Oracle' then 4
	 when ROLE = 'Architect' then 5
	 when ROLE = 'Solution Architect' then 5
	 when ROLE = 'Technical Specialist' then 5
	 when ROLE = 'Technical Lead' then 6
	 when ROLE = 'Project Manager' then 7
	 when ROLE = 'Projectmanager' then 7
	 when ROLE = 'PMO' then 7
	 when ROLE = 'Test Manager' then 7
	 when ROLE = 'Scrum Master' then 7
	 when ROLE = 'Senior Project Manager' then 7
	else  null
	end as ROLE,
	CS_SUBDEPT_ID,
	LOB,
	INTERVIERW_STATUS,
	HSBC_MANAGER,
	HSBC_PROJECT_NAME,
	RM_USER_ID,
	Email,
	GB_GF,
	ENTRY_DATE,
	CREATE_TIME,
	UPDATE_TIME,
	ITINDUSTRY_WORK_YEAR,
	CHSOFTI_PRO_NUMBER,
	CHSOFTI_PRO_STARTDATE,
	CHSOFTI_PRO_NAME,
	HSBC_POD,
	PODTL,
	TL_TYPE,
	BACKBONE,
	ASSESSED	

from t_employee
where E_HR not in (
SELECT E_HR from b_employee
)
;
--   将结束标志
  declare continue handler for not found set done = true;	
--   打开游标 
  open cursor_employee;
--     提取游标里的数据；
   fetch cursor_employee into 
		var_EMPLOYEE_TYPE,
		var_HSBC_STAFF_ID,
		var_STAFF_NAME,
		var_LN,
		var_STAFF_REGION,
		var_STAFF_LOCATION,
		var_LOCATION_TYPE,
		var_ONSHORE_OR_OFFSHORE,
		var_SOW,
		var_SOW_EXPIRED_DATE,
		var_STAFF_CATEGORY,
		var_ENGAGEMENT_TYPE,
		var_HSBC_DOJ,
		var_GRADUATION_DATE,
		var_BILL_CURRENCY,
		var_BILL_RATE_TYPE,
		var_BILL_RATE,
		var_RESOURCE_STATUS,
		var_MENTION_LWD,
		var_REASON_FOR_TERMINATION,
		var_E_HR,
		var_HSBC_SUBDEPT_ID,
		var_SKILL,
		var_ROLE,
		var_CS_SUBDEPT_ID,
		var_LOB,
		var_INTERVIERW_STATUS,
		var_HSBC_MANAGER,
		var_HSBC_PROJECT_NAME,
		var_RM_USER_ID,
		var_Email,
		var_GB_GF,
		var_ENTRY_DATE,
		var_CREATE_TIME,
		var_UPDATE_TIME,
		var_ITINDUSTRY_WORK_YEAR,
		var_CSI_PRO_NUMBER,
		var_CSI_PRO_STARTDATE,
		var_CSI_PRO_NAME,
		var_HSBC_POD,
		var_PODTL,
		var_TL_TYPE,
		var_BACKBONE,
		var_ASSESSED	
	 ;
--   开始循环
	 WHILE !done DO 
--     这里做你想做的循环的事件
		SELECT @NICKNAME:=NICKNAME,@PASSWORD:=`PASSWORD`,@USER_TYPE:=USER_TYPE,@CSDEPT_ID:=CSDEPT_ID,@BU:=BU
		from t_user
		where user_name=var_E_HR;
		
		select @newCS_SUBDEPT_ID:=b_d.PK_ID
		from b_cs_dept b_d 
		inner join t_cs_dept t_d 
		on b_d.CS_DEPT_NAME=t_d.CS_SUBDEPT_NAME
		where t_d.CS_SUBDEPT_ID = var_CS_SUBDEPT_ID;
		
		if @newCS_SUBDEPT_ID is null 
		then
		select  @newCS_SUBDEPT_ID:=b_d.PK_ID
		from b_cs_dept b_d where CS_DEPT_NAME=@BU ;
		end if;
		set @var_userId:=REPLACE(UUID(),'-',''); 
		
		if var_BILL_RATE = ''
		then
			set var_BILL_RATE:=null;
		end if;
		
		if !(var_BILL_RATE REGEXP '^[0-9.]*$') 
		then
			set var_BILL_RATE:=null;
		end if;

		if var_ITINDUSTRY_WORK_YEAR = '' 
		then
			set var_ITINDUSTRY_WORK_YEAR:=null;
		end if;
		
		if !(var_ITINDUSTRY_WORK_YEAR REGEXP '^[0-9.]*$') 
		then
			set var_ITINDUSTRY_WORK_YEAR:=null;
		end if;
		select var_PODTL;
		if var_PODTL=2
		then
			set var_PODTL:=b'1';
			else 
			set var_PODTL:=b'0';
		end if;
		
		if !(var_TL_TYPE REGEXP '^[0-9]$') 
		then
			set var_TL_TYPE:=0;
		end if;	
		
		
-- 		insert b_user
		INSERT INTO `b_user` VALUES (@var_userId, var_E_HR, @NICKNAME, @PASSWORD, NULL, var_CREATE_TIME, var_UPDATE_TIME);
		set @var_employeeId:=REPLACE(UUID(),'-',''); 
		
-- 		insert b_employee
		INSERT INTO `b_employee` VALUES (@var_employeeId, @var_userId, var_E_HR, var_LOB, var_STAFF_NAME, var_RM_USER_ID, var_STAFF_REGION, var_STAFF_LOCATION, var_ROLE, var_SKILL, var_ENGAGEMENT_TYPE, var_BILL_RATE_TYPE, var_BILL_CURRENCY, var_BILL_RATE, var_EMPLOYEE_TYPE, var_RESOURCE_STATUS, var_GRADUATION_DATE, var_ENTRY_DATE, var_Email, var_CSI_PRO_NUMBER, var_CSI_PRO_STARTDATE, var_CSI_PRO_NAME, var_ITINDUSTRY_WORK_YEAR, var_MENTION_LWD, var_REASON_FOR_TERMINATION, var_CREATE_TIME, var_UPDATE_TIME, var_BACKBONE, var_ASSESSED);
		
-- 		insert b_user_role
		INSERT INTO `b_user_role` VALUES (REPLACE(UUID(),'-',''), @var_employeeId, @USER_TYPE, @newCS_SUBDEPT_ID, b'0');	
		if var_EMPLOYEE_TYPE = 2
		then
		select @HSBC_SUBDEPT_ID:=substring(var_HSBC_SUBDEPT_ID,1,instr(var_HSBC_SUBDEPT_ID,',')-1),@HSBC_THRID_DEPT_ID:=substring(var_HSBC_SUBDEPT_ID,instr(var_HSBC_SUBDEPT_ID,',')+1);
		select @var_GB_GF:=RELATED_CODE from b_data_dictionary where TYPE_NAME='hsbcDept' and RELATED_NAME=var_GB_GF;
		select @var_HSBC_SUBDEPT_ID:=RELATED_CODE from b_data_dictionary where TYPE_NAME='hsbcDept' and RELATED_NAME=@HSBC_SUBDEPT_ID;
		select @var_HSBC_THRID_DEPT_ID:=RELATED_CODE from b_data_dictionary where TYPE_NAME='hsbcDept' and RELATED_NAME=@HSBC_THRID_DEPT_ID;
-- 		insert B-b_hsbc_employee
		INSERT INTO `b_hsbc_employee` VALUES (REPLACE(UUID(),'-',''), @var_employeeId, var_HSBC_STAFF_ID, var_LN, var_LOCATION_TYPE, var_ONSHORE_OR_OFFSHORE, @var_GB_GF, @var_HSBC_SUBDEPT_ID, @var_HSBC_THRID_DEPT_ID, var_HSBC_MANAGER,var_SOW, var_SOW_EXPIRED_DATE, var_HSBC_DOJ, var_HSBC_POD, var_PODTL, var_TL_TYPE, var_HSBC_PROJECT_NAME,var_STAFF_CATEGORY, var_MENTION_LWD);
		end if;
		
		fetch cursor_employee into 
		var_EMPLOYEE_TYPE,
		var_HSBC_STAFF_ID,
		var_STAFF_NAME,
		var_LN,
		var_STAFF_REGION,
		var_STAFF_LOCATION,
		var_LOCATION_TYPE,
		var_ONSHORE_OR_OFFSHORE,
		var_SOW,
		var_SOW_EXPIRED_DATE,
		var_STAFF_CATEGORY,
		var_ENGAGEMENT_TYPE,
		var_HSBC_DOJ,
		var_GRADUATION_DATE,
		var_BILL_CURRENCY,
		var_BILL_RATE_TYPE,
		var_BILL_RATE,
		var_RESOURCE_STATUS,
		var_MENTION_LWD,
		var_REASON_FOR_TERMINATION,
		var_E_HR,
		var_HSBC_SUBDEPT_ID,
		var_SKILL,
		var_ROLE,
		var_CS_SUBDEPT_ID,
		var_LOB,
		var_INTERVIERW_STATUS,
		var_HSBC_MANAGER,
		var_HSBC_PROJECT_NAME,
		var_RM_USER_ID,
		var_Email,
		var_GB_GF,
		var_ENTRY_DATE,
		var_CREATE_TIME,
		var_UPDATE_TIME,
		var_ITINDUSTRY_WORK_YEAR,
		var_CSI_PRO_NUMBER,
		var_CSI_PRO_STARTDATE,
		var_CSI_PRO_NAME,
		var_HSBC_POD,
		var_PODTL,
		var_TL_TYPE,
		var_BACKBONE,
		var_ASSESSED	
		;
	 END WHILE;
--   关闭游标
  close cursor_employee;
END;

call `import_userInfo`();

DROP PROCEDURE IF EXISTS `import_userInfo`;

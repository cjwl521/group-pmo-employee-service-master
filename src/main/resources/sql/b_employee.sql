
-- ----------------------------
-- Table structure for b_employee
-- ----------------------------
DROP TABLE IF EXISTS `b_employee`;
CREATE TABLE `b_employee`  (
   -- ----------------------必填字段 Start------------------------------
  `PK_ID` varchar(32) NOT NULL COMMENT '主键', 
  `USER_ID` varchar(32)  NOT NULL,  
  `E_HR` varchar(32) NULL DEFAULT NULL COMMENT 'E-HR账号',
  `LOB` varchar(32) NULL DEFAULT NULL COMMENT 'LOB工号',
  `STAFF_NAME` varchar(100) NULL DEFAULT NULL COMMENT '员工姓名',  
   -- Position 员工职位 有下拉选框 对应 b_user_employee.USER_TYPE
  `RM_USER_ID` varchar(32) NULL DEFAULT NULL  COMMENT '所属RM USER_ID',  
  `STAFF_REGION` int(4) NULL DEFAULT NULL COMMENT '员工所属地区（西安、广州、上海、深圳、香港、印度、马来西亚等）',
  `STAFF_LOCATION` int(4) NULL DEFAULT NULL COMMENT '员工所属国家（中国、马来西亚、香港、印度等）',
  `ROLE` int(4) NULL DEFAULT NULL COMMENT '员工级别（Trainee,Junior,Intermediate,Senior）',  
  `SKILL` int(4) NULL DEFAULT NULL COMMENT '技能/技术',
  `ENGAGEMENT_TYPE` int(4) NULL DEFAULT NULL COMMENT '合同类型',
  `BILL_RATE_TYPE` int(4) NULL DEFAULT NULL COMMENT '单价类型：小时、天、月',
  `BILL_CURRENCY` int(4) NULL DEFAULT NULL COMMENT '币种',
  `BILL_RATE` decimal(18, 2) NULL DEFAULT NULL COMMENT '单价',
  `EMPLOYEE_TYPE` int(4) NULL DEFAULT NULL  COMMENT '员工类型:Chinasoft/HSBC/Microsoft', 
  `RESOURCE_STATUS` int(4) NULL DEFAULT NULL COMMENT '员工状态（Active/Terminated/Released）',
  -- ----------------------必填字段 End--------------------------------
  
  -- ----------------------选填字段 Start------------------------------
  `GRADUATION_DATE` date NULL DEFAULT NULL COMMENT '毕业时间',
  `ENTRY_DATE` date NULL DEFAULT NULL COMMENT '入职日期',
  `Email` varchar(100) NULL DEFAULT NULL,
  `CSI_PRO_NUMBER` varchar(500) NULL DEFAULT NULL COMMENT '中软项目编号',
  `CSI_PRO_STARTDATE` date NULL DEFAULT NULL COMMENT '中软项目开始日期',
  `CSI_PRO_NAME` varchar(500) NULL DEFAULT NULL COMMENT '中软项目名称',
  `ITINDUSTRY_WORK_YEAR` decimal(9,2) NULL DEFAULT NULL COMMENT 'IT行业工作年限',
  `TERMINATION_DATE` date NULL DEFAULT NULL COMMENT '离职日期',
  `REASON_FOR_TERMINATION` varchar(255) NULL DEFAULT NULL COMMENT '离职原因',  
  -- ----------------------选填字段 End--------------------------------
   
  `CREATE_TIME` datetime(0) NULL DEFAULT NULL,
  `UPDATE_TIME` datetime(0) NULL DEFAULT NULL,
  `BACKBONE` varchar(255) NULL DEFAULT NULL,
  `ASSESSED` int(10) NULL DEFAULT NULL,
  PRIMARY KEY (`PK_ID`),
  INDEX `userId`(`USER_ID`),
  INDEX `RmUserId`(`RM_USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for b_hsbc_employee
-- ----------------------------
DROP TABLE IF EXISTS `b_hsbc_employee`;
CREATE TABLE `b_hsbc_employee`  (
  `PK_ID` varchar(32) NOT NULL COMMENT '主键',
  `EMPLOYEE_ID` varchar(32) NOT NULL, 
  `HSBC_STAFF_ID` varchar(32) NULL DEFAULT NULL COMMENT '汇丰员工账号',
  `LN` varchar(32) NULL DEFAULT NULL COMMENT '员工英文名',
  `LOCATION_TYPE` int(4) NULL DEFAULT NULL COMMENT '办公场所类型（汇丰场内或者离岸办公场所）',
  `ONSHORE_OR_OFFSHORE` int(4) NULL DEFAULT NULL COMMENT '在岸人员或者离岸人员',  
  `GB_GF` int(4) NULL DEFAULT NULL COMMENT '汇丰所属一级部门',-- b_data_dictionary
  `HSBC_SUBDEPT_ID` int(4) NULL DEFAULT NULL COMMENT '汇丰所属二级部门', -- b_data_dictionary
  `HSBC_THRID_DEPT_ID` int(4) NULL DEFAULT NULL COMMENT '汇丰所属三级部门',-- b_data_dictionary
  `HSBC_MANAGER` varchar(100) NULL DEFAULT NULL COMMENT '汇丰方经理',
  `SOW` varchar(100) NULL DEFAULT NULL COMMENT 'SOW编号',
  `SOW_EXPIRED_DATE` date NULL DEFAULT NULL COMMENT 'SOW截至日期',
  `HSBC_DOJ` date NULL DEFAULT NULL COMMENT '入场日期',
  `HSBC_POD` varchar(800) NULL DEFAULT NULL COMMENT '员工所属的汇丰POD项目名称',
  `PODTL` bit(1) NULL DEFAULT NULL COMMENT '员工是否在此POD中是TL',
  `TL_TYPE` int(4) NULL DEFAULT NULL COMMENT '项目组长类型',
  `HSBC_PROJECT_NAME` varchar(100) NULL DEFAULT NULL COMMENT '项目名称', 
  
  `STAFF_CATEGORY` varchar(32) NULL DEFAULT NULL,
  `MENTION_LWD` date NULL DEFAULT NULL  COMMENT '出场日期', 
  -- `INTERVIERW_STATUS` varchar(32) NULL DEFAULT NULL,
  `MSA_ROLE` int(4) NULL DEFAULT NULL,
  PRIMARY KEY (`PK_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE `b_hsbc_employee` ADD INDEX index_name ( `EMPLOYEE_ID` ) ; 
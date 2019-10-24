

-- ----------------------------
-- Table structure for b_user
-- ----------------------------
DROP TABLE IF EXISTS `b_user`;
CREATE TABLE `b_user`  (
  `PK_ID` varchar(32)  NOT NULL COMMENT '主键',  
  `USER_NAME` varchar(50)  NULL DEFAULT NULL COMMENT '登录名——暂存E-HR账号', 
  `NICKNAME` varchar(100)  NULL DEFAULT NULL, 
  `PASSWORD` varchar(32)  NULL DEFAULT NULL, 
  `SALT` varchar(32)  NULL DEFAULT NULL, 
  -- `LOGIN_STATUS` varchar(32)  NULL DEFAULT NULL, 
  `CREATE_TIME` datetime(0) NULL DEFAULT NULL,
  `UPDATE_TIME` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`PK_ID`),
  INDEX `UserIdName`(`USER_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for b_user_role
-- ----------------------------
DROP TABLE IF EXISTS `b_user_role`;
CREATE TABLE `b_user_role`  (
  `PK_ID` varchar(32)  NOT NULL,  
  `EMPLOYEE_ID` varchar(32) NOT NULL, 
  `USER_TYPE` int(4)  NULL DEFAULT NULL COMMENT '员工职位', 
  `CSDEPT_ID` int(4)  NULL DEFAULT NULL, 
  `DELETED` bit(1) NOT NULL DEFAULT 0 COMMENT '删除状态-1 表示标记删除', 
  PRIMARY KEY (`PK_ID`),
  INDEX `EmployeeId`(`EMPLOYEE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE `b_user_role` ADD INDEX index_name ( `EMPLOYEE_ID` ) ;  

-- ALTER TABLE `b_user_role` ADD CONSTRAINT `fk_b_user_employee_userId` FOREIGN KEY (`USER_ID`) REFERENCES `b_user` (`PK_ID`);
-- ALTER TABLE `b_user_role` ADD CONSTRAINT `fk_b_user_employee_employeeId` FOREIGN KEY (`EMPLOYEE_ID`) REFERENCES `b_employee` (`EMPLOYEE_ID`);
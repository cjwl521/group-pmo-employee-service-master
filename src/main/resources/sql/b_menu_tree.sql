-- ----------------------------
-- Table structure for b_menu_tree
-- ----------------------------
DROP TABLE IF EXISTS `b_menu_tree`;
CREATE TABLE `b_menu_tree` (
  `PK_ID` varchar(50) NOT NULL,
  `PARENT_ID` varchar(50) DEFAULT NULL,
  `ROLE` int(10) DEFAULT NULL,
  `TITLE` varchar(30) DEFAULT NULL,
  `KEY_CODE` varchar(30) DEFAULT NULL,
  `ICON_NAME` varchar(20) DEFAULT NULL,
  `PARAM_CODE` int(10) DEFAULT NULL,
  PRIMARY KEY (`PK_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of b_menu_tree
-- ----------------------------
INSERT INTO `b_menu_tree` VALUES ('006a494ccd224c7d9d1a4eef94413s31', null, '0', '员工管理', '/Employee', 'contacts', '1');
INSERT INTO `b_menu_tree` VALUES ('006a494ccd224c7d9d1a4eef94413s32', null, '1', '员工管理', '/Employee', 'contacts', '1');
INSERT INTO `b_menu_tree` VALUES ('006a494ccd224c7d9d1a4eef94413s33', null, '2', '员工管理', '/Employee', 'contacts', '1');
INSERT INTO `b_menu_tree` VALUES ('006a494ccd224c7d9d1a4eef94413s34', null, '3', '员工管理', '/Employee', 'contacts', '1');
INSERT INTO `b_menu_tree` VALUES ('006a494ccd224c7d9d1a4eef94413s35', null, '4', '员工管理', '/Employee', 'contacts', '1');
INSERT INTO `b_menu_tree` VALUES ('006a494ccd224c7d9d1a4eef94413s36', null, '5', '员工管理', '/Employee', 'contacts', '1');
INSERT INTO `b_menu_tree` VALUES ('006a494ccd224c7d9d1a4eef94413s37', null, '6', '员工管理', '/Employee', 'contacts', '1');
INSERT INTO `b_menu_tree` VALUES ('006a494ccd224c7d9d1a4eef94413s38', null, '7', '员工管理', '/Employee', 'contacts', '1');
INSERT INTO `b_menu_tree` VALUES ('006a494ccd224c7d9d1a4eef94413s39', null, '8', '员工管理', '/Employee', 'contacts', '1');
INSERT INTO `b_menu_tree` VALUES ('006a494ccd224c7d9d1a4eef94413s41', null, '9', '员工管理', '/Employee', 'contacts', '1');
INSERT INTO `b_menu_tree` VALUES ('006a494ccd224c7d9d1a4eef94413s42', null, '10', '员工管理', '/Employee', 'contacts', '1');
INSERT INTO `b_menu_tree` VALUES ('006a494ccd224c7d9d1a4eef94413s43', null, '11', '员工管理', '/Employee', 'contacts', '1');
INSERT INTO `b_menu_tree` VALUES ('006a494ccd224c7d9d1a4eef94413s44', null, '12', '员工管理', '/Employee', 'contacts', '1');
INSERT INTO `b_menu_tree` VALUES ('006a494ccd224c7d9d1a4eef94413s45', null, '13', '员工管理', '/Employee', 'contacts', '1');
INSERT INTO `b_menu_tree` VALUES ('006a494ccd224c7d9d1a4eef94413s46', null, '14', '员工管理', '/Employee', 'contacts', '1');
INSERT INTO `b_menu_tree` VALUES ('006a494ccd224c7d9d1a4eef94413s51', null, '15', '员工管理', '/Employee', 'contacts', '1');
INSERT INTO `b_menu_tree` VALUES ('006a494ccd224c7d9d1a4eef94413s52', null, '17', '员工管理', '/Employee', 'contacts', '1');
INSERT INTO `b_menu_tree` VALUES ('006a494ccd224c7d9d1a4eef94413s53', null, '18', '员工管理', '/Employee', 'contacts', '1');
INSERT INTO `b_menu_tree` VALUES ('deb53cc567c911e989306c0b84a71dd1', '006a494ccd224c7d9d1a4eef94413s31', '0', '员工录入', '/add-employee', 'user', '1');
INSERT INTO `b_menu_tree` VALUES ('debc21d167c911e989306c0b84a71dd2', '006a494ccd224c7d9d1a4eef94413s31', '0', '员工管理', '/manage-employee', 'edit', '2');
INSERT INTO `b_menu_tree` VALUES ('dec131d867c911e989306c0b84a71dd3', '006a494ccd224c7d9d1a4eef94413s31', '0', '批量录入', '/import-employee', 'import', '3');
INSERT INTO `b_menu_tree` VALUES ('dec6c56d67c911e989306c0b84a71dd4', '006a494ccd224c7d9d1a4eef94413s32', '1', '员工录入', '/add-employee', 'user', '1');
INSERT INTO `b_menu_tree` VALUES ('deccb86667c911e989306c0b84a71dd5', '006a494ccd224c7d9d1a4eef94413s32', '1', '员工管理', '/manage-employee', 'edit', '2');
INSERT INTO `b_menu_tree` VALUES ('ded2f8d267c911e989306c0b84a71dd6', '006a494ccd224c7d9d1a4eef94413s32', '1', '批量录入', '/import-employee', 'import', '3');
INSERT INTO `b_menu_tree` VALUES ('dedd25d567c911e989306c0b84a71dd7', '006a494ccd224c7d9d1a4eef94413s33', '2', '员工录入', '/add-employee', 'user', '1');
INSERT INTO `b_menu_tree` VALUES ('dee7628567c911e989306c0b84a71dd8', '006a494ccd224c7d9d1a4eef94413s33', '2', '员工管理', '/manage-employee', 'edit', '2');
INSERT INTO `b_menu_tree` VALUES ('deec8f3467c911e989306c0b84a71dd9', '006a494ccd224c7d9d1a4eef94413s33', '2', '批量录入', '/import-employee', 'import', '3');
INSERT INTO `b_menu_tree` VALUES ('def18b7f67c911e989306c0b84a71d11', '006a494ccd224c7d9d1a4eef94413s34', '3', '员工录入', '/add-employee', 'team', '1');
INSERT INTO `b_menu_tree` VALUES ('def6a57667c911e989306c0b84a71d12', '006a494ccd224c7d9d1a4eef94413s34', '3', '员工管理', '/manage-employee', 'edit', '2');
INSERT INTO `b_menu_tree` VALUES ('defbb89667c911e989306c0b84a71d13', '006a494ccd224c7d9d1a4eef94413s34', '3', '批量录入', '/import-employee', 'import', '3');
INSERT INTO `b_menu_tree` VALUES ('df00ca2167c911e989306c0b84a71d14', '006a494ccd224c7d9d1a4eef94413s35', '4', '员工录入', '/add-employee', 'user', '1');
INSERT INTO `b_menu_tree` VALUES ('df05e5de67c911e989306c0b84a71d14', '006a494ccd224c7d9d1a4eef94413s35', '4', '员工管理', '/manage-employee', 'edit', '2');
INSERT INTO `b_menu_tree` VALUES ('df0af83667c911e989306c0b84a71d15', '006a494ccd224c7d9d1a4eef94413s35', '4', '批量录入', '/import-employee', 'import', '3');
INSERT INTO `b_menu_tree` VALUES ('df10163c67c911e989306c0b84a71d16', '006a494ccd224c7d9d1a4eef94413s36', '5', '员工录入', '/add-employee', 'user', '1');
INSERT INTO `b_menu_tree` VALUES ('df151a2367c911e989306c0b84a71d17', '006a494ccd224c7d9d1a4eef94413s36', '5', '员工管理', '/manage-employee', 'edit', '2');
INSERT INTO `b_menu_tree` VALUES ('df1a3f9467c911e989306c0b84a71d18', '006a494ccd224c7d9d1a4eef94413s36', '5', '批量录入', '/import-employee', 'import', '3');

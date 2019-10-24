
-- add PARENT_ID;
DROP PROCEDURE IF EXISTS AddColumnUnlessExists;
CREATE PROCEDURE `AddColumnUnlessExists`()
BEGIN
	 declare cnt int;
	 SELECT count(*) into cnt FROM information_schema.COLUMNS
        WHERE column_name='PARENT_ID'
        and table_name='b_data_dictionary';
   if cnt=0 then
      ALTER TABLE b_data_dictionary ADD PARENT_ID VARCHAR(50);
    end if;	 
END;
call AddColumnUnlessExists();
DROP PROCEDURE IF EXISTS AddColumnUnlessExists;
	
-- delete staffLocation
delete from b_data_dictionary where TYPE_NAME='staffLocation';	
-- insert staffLocation
-- select REPLACE(UUID(),'-','') ;	
INSERT INTO `b_data_dictionary` VALUES ('0b941e2d666e11e989306c0b84a71dde', 10, 'staffLocation', 2, 'HK', 2, 'HK', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('17d4c405666f11e989306c0b84a71dde', 10, 'staffLocation', 5, 'Singapore', 5, 'Singapore', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('203c4ae7666e11e989306c0b84a71dde', 10, 'staffLocation', 3, 'Malaysia', 3, 'Malaysia', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('2ab18477666e11e989306c0b84a71dde', 10, 'staffLocation', 4, 'India', 4, 'India', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('2adc6a7a672711e989306c0b84a71dde', 10, 'staffLocation', 0, 'All', 0, 'All', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('8a124d32666d11e989306c0b84a71dde', 10, 'staffLocation', 1, 'China', 1, 'China', 0, NULL);

-- delete staffRegion
delete from b_data_dictionary where TYPE_NAME='staffRegion';
-- insert staffRegion
INSERT INTO `b_data_dictionary` VALUES ('006a494ccd224c7d9d1a4eef94470261', 1, 'staffRegion', 1, 'Beijing', 1, 'Beijing', 0, '8a124d32666d11e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('0081837a89a6403c8ff432c4f366eab4', 1, 'staffRegion', 2, 'Guangzhou', 2, 'Guangzhou', 0, '8a124d32666d11e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34545419bd630er334541a22', 1, 'staffRegion', 5, 'Xian', 5, 'Xian', 0, '8a124d32666d11e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34545419bd630er344441a33', 1, 'staffRegion', 7, 'Malaysia', 7, 'Malaysia', 0, '203c4ae7666e11e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34545419bd630er355541a34', 1, 'staffRegion', 3, 'ShangHai', 3, 'ShangHai', 0, '8a124d32666d11e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34545419bd630er366641a35', 1, 'staffRegion', 4, 'ShenZhen', 4, 'ShenZhen', 0, '8a124d32666d11e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34545419bd630er377741a36', 1, 'staffRegion', 10, 'Singapore', 10, 'Singapore', 0, '17d4c405666f11e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe35663419bd63045333341a32', 1, 'staffRegion', 8, 'Kuala Lumpur', 8, 'Kuala Lumpur', 0, '203c4ae7666e11e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe3d2d4219bd63060311141a37', 1, 'staffRegion', 6, 'HongKong', 6, 'HongKong', 0, '0b941e2d666e11e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe44543319bd63060322241a31', 1, 'staffRegion', 9, 'India', 9, 'India', 0, '2ab18477666e11e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe44543319bc63060312241b35', 1, 'staffRegion', 11, '美国', 9, 'America', 0, '8a124d32524d11e989306c0b84a71dce');
INSERT INTO `b_data_dictionary` VALUES ('8a124d32524d11e989306c0b84a71dce', 10, 'staffLocation', 11, '美国', 9, 'America', 0, NULL);
-- delete engagementType
delete from b_data_dictionary where TYPE_NAME='engagementType';
-- insert engagementType 小时、天、月
INSERT INTO `b_data_dictionary` VALUES ('5089f9ad672711e989306c0b84a71dde', 11, 'engagementType', 0, 'All', 0, 'All', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('50942614672711e989306c0b84a71dde', 11, 'engagementType', 1, 'Time&Material', 1, 'Time&Material', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('50993806672711e989306c0b84a71dde', 11, 'engagementType', 2, 'Team Delivery', 2, 'Team Delivery', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('509e4573672711e989306c0b84a71dde', 11, 'engagementType', 3, 'Fixed Price', 3, 'Fixed Price', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('50a36aa8672711e989306c0b84a71dde', 11, 'engagementType', 4, 'Support', 4, 'Support', 0, NULL);

-- delete billRateType
delete from b_data_dictionary where TYPE_NAME='billRateType';
-- insert billRateType
INSERT INTO `b_data_dictionary` VALUES ('50ad93f6672711e989306c0b84a71dde', 12, 'billRateType', 0, 'All', 0, 'All', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('50b31007672711e989306c0b84a71dde', 12, 'billRateType', 1, 'Hour', 1, 'Hour', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('50b90547672711e989306c0b84a71dde', 12, 'billRateType', 2, 'Day', 2, 'Day', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('50be18c5672711e989306c0b84a71dde', 12, 'billRateType', 3, 'Month', 3, 'Month', 0, NULL);

-- delete billingCurrency
delete from b_data_dictionary where TYPE_NAME='billingCurrency';
-- insert billingCurrency		
INSERT INTO `b_data_dictionary` VALUES ('50c849b0672711e989306c0b84a71dde', 13, 'billingCurrency', 0, 'All', 0, 'All', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('50cd5cdc672711e989306c0b84a71dde', 13, 'billingCurrency', 1, 'CNY', 1, 'CNY', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('50d27c20672711e989306c0b84a71dde', 13, 'billingCurrency', 2, 'HKD', 2, 'HKD', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('50d78b8e672711e989306c0b84a71dde', 13, 'billingCurrency', 3, 'MYR', 3, 'MYR', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('50dca4bd672711e989306c0b84a71dde', 13, 'billingCurrency', 4, 'USD', 4, 'USD', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('50e1c517672711e989306c0b84a71dde', 13, 'billingCurrency', 5, 'SGD', 5, 'SGD', 0, NULL);

-- delete employeeType
delete from b_data_dictionary where TYPE_NAME='employeeType';
-- insert employeeType Chinasoft/HSBC/Microsoft
INSERT INTO `b_data_dictionary` VALUES ('50ed3ec5672711e989306c0b84a71dde', 14, 'employeeType', 0, 'All', 0, 'All', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('50f24947672711e989306c0b84a71dde', 14, 'employeeType', 1, 'Chinasoft', 1, 'Chinasoft', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('50f75baf672711e989306c0b84a71dde', 14, 'employeeType', 2, 'HSBC', 2, 'HSBC', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('50fc78f1672711e989306c0b84a71dde', 14, 'employeeType', 3, 'Microsoft', 3, 'Microsoft', 0, NULL);

-- delete resourceStatus
delete from b_data_dictionary where TYPE_NAME='resourceStatus';
-- insert resourceStatus
INSERT INTO `b_data_dictionary` VALUES ('5107ee17672711e989306c0b84a71dde', 15, 'resourceStatus', 0, 'All', 0, 'All', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('510d0331672711e989306c0b84a71dde', 15, 'resourceStatus', 1, 'Active', 1, 'Active', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('51122d96672711e989306c0b84a71dde', 15, 'resourceStatus', 2, 'Released', 2, 'Released', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('51187953672711e989306c0b84a71dde', 15, 'resourceStatus', 3, 'Terminated', 3, 'Terminated', 0, NULL);

-- hsbs_dept 16

-- delete locationType
delete from b_data_dictionary where TYPE_NAME='locationType';
-- insert locationType
INSERT INTO `b_data_dictionary` VALUES ('febcee5c75f711e989306c0b84a71dde', 20, 'locationType', 0, 'All', 0, 'All', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('fec2167675f711e989306c0b84a71dde', 20, 'locationType', 1, 'HSBC Office', 1, 'HSBC Office', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('fec722cd75f711e989306c0b84a71dde', 20, 'locationType', 2, 'ODC', 2, 'ODC', 0, NULL);

-- delete onshoreOrOffshore
delete from b_data_dictionary where TYPE_NAME='onshoreOrOffshore';
-- insert onshoreOrOffshore
INSERT INTO `b_data_dictionary` VALUES ('14b76eb467fe11e989306c0b84a71dde', 18, 'onshoreOrOffshore', 0, 'All', 0, 'All', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('14bee8a167fe11e989306c0b84a71dde', 18, 'onshoreOrOffshore', 1, 'Onshore', 1, 'Onshore', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('14c6902567fe11e989306c0b84a71dde', 18, 'onshoreOrOffshore', 2, 'Offshore', 2, 'Offshore', 0, NULL);


-- delete hsbcTeamLeaderType
delete from b_data_dictionary where TYPE_NAME='hsbcTeamLeaderType';
-- insert hsbcTeamLeaderType
INSERT INTO `b_data_dictionary` VALUES ('33f7eb14698d11e989306c0b84a71dde', 19, 'hsbcTeamLeaderType', 0, 'All', 0, 'All', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('33fcfe59698d11e989306c0b84a71dde', 19, 'hsbcTeamLeaderType', 1, 'Qualified and is Team Leader', 1, 'Qualified and is Team Leader', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('34021be6698d11e989306c0b84a71dde', 19, 'hsbcTeamLeaderType', 2, 'Qualified but not Team Leader', 2, 'Qualified but not Team Leader', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('34072ccf698d11e989306c0b84a71dde', 19, 'hsbcTeamLeaderType', 3, 'He/She is a culture', 3, 'He/She is a culture', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('340c39b7698d11e989306c0b84a71dde', 19, 'hsbcTeamLeaderType', 4, 'Not a culture', 4, 'Not a culture', 0, NULL);


-- delete applyResult
delete from b_data_dictionary where TYPE_NAME='applyResult';
-- insert applyResult
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34124119bd630er3aa777423', 6, 'applyResult', 0, '全部', 0, 'ALL', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34124339bd630er3aa888422', 6, 'applyResult', 1, '审批通过', 1, 'Approve', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34124449bd630er3aa999421', 6, 'applyResult', 2, '审批未通过', 2, 'Reject', 0, NULL);

-- delete applyStatus
delete from b_data_dictionary where TYPE_NAME='applyStatus';
-- insert applyStatus
INSERT INTO `b_data_dictionary` VALUES ('00cfebdf34124339bd6301r3aa643433', 7, 'applyStatus', 4, '已核对', 3, 'checked', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfesde34124339bd6302r3aa232411', 7, 'applyStatus', 3, '待核对', 2, 'checking', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfesde34124339bd630er3aa232422', 7, 'applyStatus', 1, '待审批', 1, 'Approving', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfesde34124339bd630er3aa232432', 7, 'applyStatus', 2, '已审批', 2, 'Approved', 0, NULL);

-- delete hsbcDept
delete from b_data_dictionary where TYPE_NAME='hsbcDept';
-- insert hsbcDept
INSERT INTO `b_data_dictionary` VALUES ('be59a480672411e989306c0b84a71dde', 16, 'hsbcDept', 0, 'All', 0, 'All', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('be6ff5e8672411e989306c0b84a71dde', 16, 'hsbcDept', 1, 'AP and Operational', 1, 'AP and Operational', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('be7514f8672411e989306c0b84a71dde', 16, 'hsbcDept', 28, 'Request to Pay AP', 28, 'Request to Pay AP', 0, 'be6ff5e8672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('be7a32b0672411e989306c0b84a71dde', 16, 'hsbcDept', 120, 'Request to Pay AP', 120, 'Request to Pay AP', 0, 'be7514f8672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('be7f533b672411e989306c0b84a71dde', 16, 'hsbcDept', 10, 'Global Reward', 10, 'Global Reward', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('be845b2a672411e989306c0b84a71dde', 16, 'hsbcDept', 72, 'Reward GB', 72, 'Reward GB', 0, 'be7f533b672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('be89720c672411e989306c0b84a71dde', 16, 'hsbcDept', 194, 'Reward GB (Retained)', 194, 'Reward GB (Retained)', 0, 'be845b2a672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('be8e9188672411e989306c0b84a71dde', 16, 'hsbcDept', 11, 'Global Standards & Compliance IT', 11, 'Global Standards & Compliance IT', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('be939f07672411e989306c0b84a71dde', 16, 'hsbcDept', 73, 'Anti Money Laundering', 73, 'Anti Money Laundering', 0, 'be8e9188672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('be98bec5672411e989306c0b84a71dde', 16, 'hsbcDept', 195, 'AML APAC', 195, 'AML APAC', 0, 'be939f07672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('be9dd314672411e989306c0b84a71dde', 16, 'hsbcDept', 74, 'Customer Due Diligence CMB/RBWM', 74, 'Customer Due Diligence CMB/RBWM', 0, 'be8e9188672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('bea2e08a672411e989306c0b84a71dde', 16, 'hsbcDept', 196, 'CDD APAC', 196, 'CDD APAC', 0, 'be9dd314672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('bea7ff7f672411e989306c0b84a71dde', 16, 'hsbcDept', 75, 'FCTM Utilities IT', 75, 'FCTM Utilities IT', 0, 'be8e9188672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('bead1c31672411e989306c0b84a71dde', 16, 'hsbcDept', 197, 'Utilities APAC', 197, 'Utilities APAC', 0, 'bea7ff7f672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('beb242c0672411e989306c0b84a71dde', 16, 'hsbcDept', 76, 'GS&C RtB Transformation', 76, 'GS&C RtB Transformation', 0, 'be8e9188672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('beb74574672411e989306c0b84a71dde', 16, 'hsbcDept', 198, 'RtB Transformation EMEA', 198, 'RtB Transformation EMEA', 0, 'beb242c0672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('bebc6ec4672411e989306c0b84a71dde', 16, 'hsbcDept', 12, 'HR BP HOST', 12, 'HR BP HOST', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('bec1742e672411e989306c0b84a71dde', 16, 'hsbcDept', 77, 'HR BP - HOST', 77, 'HR BP - HOST', 0, 'bebc6ec4672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('bec68320672411e989306c0b84a71dde', 16, 'hsbcDept', 199, 'HR  BPClient (HOST - Retained)', 199, 'HR  BPClient (HOST - Retained)', 0, 'bec1742e672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('becbaf62672411e989306c0b84a71dde', 16, 'hsbcDept', 13, 'HR COO', 13, 'HR COO', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('bed0b088672411e989306c0b84a71dde', 16, 'hsbcDept', 78, 'HR Transformation', 78, 'HR Transformation', 0, 'becbaf62672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('bed5c79b672411e989306c0b84a71dde', 16, 'hsbcDept', 200, 'HR Transformation (Stewardship)', 200, 'HR Transformation (Stewardship)', 0, 'bed0b088672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('bedae709672411e989306c0b84a71dde', 16, 'hsbcDept', 14, 'HR Learning & Talent Management', 14, 'HR Learning & Talent Management', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('bedff4c7672411e989306c0b84a71dde', 16, 'hsbcDept', 79, 'Learning GB', 79, 'Learning GB', 0, 'bedae709672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('bee50a5b672411e989306c0b84a71dde', 16, 'hsbcDept', 201, 'Learn GB (Retained)', 201, 'Learn GB (Retained)', 0, 'bedff4c7672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('beea2b84672411e989306c0b84a71dde', 16, 'hsbcDept', 15, 'IT Architecture', 15, 'IT Architecture', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('beef41bc672411e989306c0b84a71dde', 16, 'hsbcDept', 80, 'IT Architecture Governance', 80, 'IT Architecture Governance', 0, 'beea2b84672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('bef44ff6672411e989306c0b84a71dde', 16, 'hsbcDept', 202, 'IT Architecture Governance', 202, 'IT Architecture Governance', 0, 'beef41bc672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('bef98650672411e989306c0b84a71dde', 16, 'hsbcDept', 16, 'IT COO', 16, 'IT COO', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('befea256672411e989306c0b84a71dde', 16, 'hsbcDept', 81, 'Business Management', 81, 'Business Management', 0, 'bef98650672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('bf03b1f6672411e989306c0b84a71dde', 16, 'hsbcDept', 203, 'Management Services Operations', 203, 'Management Services Operations', 0, 'befea256672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('bf08ca18672411e989306c0b84a71dde', 16, 'hsbcDept', 204, 'Enterprise Solutions', 204, 'Enterprise Solutions', 0, 'befea256672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('bf0dce88672411e989306c0b84a71dde', 16, 'hsbcDept', 82, 'IT Centres China', 82, 'IT Centres China', 0, 'bef98650672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('bf12d8a7672411e989306c0b84a71dde', 16, 'hsbcDept', 205, 'IT Centres China', 205, 'IT Centres China', 0, 'bf0dce88672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('bf182c9c672411e989306c0b84a71dde', 16, 'hsbcDept', 83, 'IT COO - CMB', 83, 'IT COO - CMB', 0, 'bef98650672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('bf1d22bf672411e989306c0b84a71dde', 16, 'hsbcDept', 206, 'IT COO GB - CMB', 206, 'IT COO GB - CMB', 0, 'bf182c9c672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('bf222a37672411e989306c0b84a71dde', 16, 'hsbcDept', 84, 'IT COO Regions - Canada', 84, 'IT COO Regions - Canada', 0, 'bef98650672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('bf275889672411e989306c0b84a71dde', 16, 'hsbcDept', 207, 'PPM - Canada', 207, 'PPM - Canada', 0, 'bf222a37672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('bf2c8535672411e989306c0b84a71dde', 16, 'hsbcDept', 17, 'IT Infrastructure Delivery', 17, 'IT Infrastructure Delivery', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('bf316e3a672411e989306c0b84a71dde', 16, 'hsbcDept', 85, 'Client Services', 85, 'Client Services', 0, 'bf2c8535672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('bf36791e672411e989306c0b84a71dde', 16, 'hsbcDept', 208, 'Workplace Technologies', 208, 'Workplace Technologies', 0, 'bf316e3a672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('bf3baaa6672411e989306c0b84a71dde', 16, 'hsbcDept', 209, 'Client Platforms', 209, 'Client Platforms', 0, 'bf316e3a672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('bf40a871672411e989306c0b84a71dde', 16, 'hsbcDept', 210, 'Client Support and Delivery', 210, 'Client Support and Delivery', 0, 'bf316e3a672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('bf45c5b4672411e989306c0b84a71dde', 16, 'hsbcDept', 86, 'Data Centres and Operations', 86, 'Data Centres and Operations', 0, 'bf2c8535672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('bf4adbd5672411e989306c0b84a71dde', 16, 'hsbcDept', 211, 'DC Infrastructure Operation', 211, 'DC Infrastructure Operation', 0, 'bf45c5b4672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('bf4fec07672411e989306c0b84a71dde', 16, 'hsbcDept', 212, 'Data Centre & Service Resilience', 212, 'Data Centre & Service Resilience', 0, 'bf45c5b4672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('bf55145e672411e989306c0b84a71dde', 16, 'hsbcDept', 87, 'Enterprise Services', 87, 'Enterprise Services', 0, 'bf2c8535672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('bf5a1e76672411e989306c0b84a71dde', 16, 'hsbcDept', 213, 'Data Platforms', 213, 'Data Platforms', 0, 'bf55145e672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('bf5f3080672411e989306c0b84a71dde', 16, 'hsbcDept', 214, 'Middleware and Developer Services', 214, 'Middleware and Developer Services', 0, 'bf55145e672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('bf645013672411e989306c0b84a71dde', 16, 'hsbcDept', 215, 'Distributed Compute (Unix, Linux, Windows)', 215, 'Distributed Compute (Unix, Linux, Windows)', 0, 'bf55145e672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('bf695efd672411e989306c0b84a71dde', 16, 'hsbcDept', 216, 'Storage and Virtualisation', 216, 'Storage and Virtualisation', 0, 'bf55145e672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('bf6e71b8672411e989306c0b84a71dde', 16, 'hsbcDept', 217, 'zSeries', 217, 'zSeries', 0, 'bf55145e672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('bf73860e672411e989306c0b84a71dde', 16, 'hsbcDept', 88, 'Identity and Access Management', 88, 'Identity and Access Management', 0, 'bf2c8535672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('bf7896b9672411e989306c0b84a71dde', 16, 'hsbcDept', 218, 'Identity and Access Management', 218, 'Identity and Access Management', 0, 'bf73860e672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('bf7dbbe2672411e989306c0b84a71dde', 16, 'hsbcDept', 89, 'ITID General', 89, 'ITID General', 0, 'bf2c8535672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('bf82ccf1672411e989306c0b84a71dde', 16, 'hsbcDept', 219, 'ITID General', 219, 'ITID General', 0, 'bf7dbbe2672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('bf87e64b672411e989306c0b84a71dde', 16, 'hsbcDept', 90, 'Service Management', 90, 'Service Management', 0, 'bf2c8535672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('bf8cf158672411e989306c0b84a71dde', 16, 'hsbcDept', 220, 'Global Help Desk', 220, 'Global Help Desk', 0, 'bf87e64b672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('bf920a96672411e989306c0b84a71dde', 16, 'hsbcDept', 221, 'Engineering', 221, 'Engineering', 0, 'bf87e64b672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('bf972e27672411e989306c0b84a71dde', 16, 'hsbcDept', 91, 'Telecommunications', 91, 'Telecommunications', 0, 'bf2c8535672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('bf9c4796672411e989306c0b84a71dde', 16, 'hsbcDept', 222, 'Contact Centre Infrastructure', 222, 'Contact Centre Infrastructure', 0, 'bf972e27672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('bfa1623f672411e989306c0b84a71dde', 16, 'hsbcDept', 223, 'Telephony and Video Conferencing Infrastructure', 223, 'Telephony and Video Conferencing Infrastructure', 0, 'bf972e27672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('bfa6758b672411e989306c0b84a71dde', 16, 'hsbcDept', 18, 'IT Innovation', 18, 'IT Innovation', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('bfab8295672411e989306c0b84a71dde', 16, 'hsbcDept', 92, 'IT Strategic Innovation', 92, 'IT Strategic Innovation', 0, 'bfa6758b672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('bfb09f55672411e989306c0b84a71dde', 16, 'hsbcDept', 224, 'IT Strategic Innovation', 224, 'IT Strategic Innovation', 0, 'bfab8295672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('bfb5ef25672411e989306c0b84a71dde', 16, 'hsbcDept', 19, 'Network & Travel', 19, 'Network & Travel', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('bfbaefb0672411e989306c0b84a71dde', 16, 'hsbcDept', 93, 'Source to Contract NT', 93, 'Source to Contract NT', 0, 'bfb5ef25672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('bfbffc96672411e989306c0b84a71dde', 16, 'hsbcDept', 225, 'Source to Contract NT', 225, 'Source to Contract NT', 0, 'bfbaefb0672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('bfc51ba4672411e989306c0b84a71dde', 16, 'hsbcDept', 94, 'Travel Services NT', 94, 'Travel Services NT', 0, 'bfb5ef25672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('bfca1329672411e989306c0b84a71dde', 16, 'hsbcDept', 226, 'Travel Services NT', 226, 'Travel Services NT', 0, 'bfc51ba4672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('bfcf2bf8672411e989306c0b84a71dde', 16, 'hsbcDept', 2, 'Commercial Banking IT', 2, 'Commercial Banking IT', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('bfd435f1672411e989306c0b84a71dde', 16, 'hsbcDept', 29, 'Client Management IT', 29, 'Client Management IT', 0, 'bfcf2bf8672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('bfd95081672411e989306c0b84a71dde', 16, 'hsbcDept', 121, 'Client Management Engineering', 121, 'Client Management Engineering', 0, 'bfd435f1672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('bfde6b98672411e989306c0b84a71dde', 16, 'hsbcDept', 122, 'Client Management Application Services', 122, 'Client Management Application Services', 0, 'bfd435f1672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('bfe392e6672411e989306c0b84a71dde', 16, 'hsbcDept', 30, 'CMB Data Analytics Delivery IT', 30, 'CMB Data Analytics Delivery IT', 0, 'bfcf2bf8672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('bfe8b95e672411e989306c0b84a71dde', 16, 'hsbcDept', 123, 'CMB Data Analytics Delivery IT', 123, 'CMB Data Analytics Delivery IT', 0, 'bfe392e6672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('bfedd765672411e989306c0b84a71dde', 16, 'hsbcDept', 31, 'CMB Digital IT', 31, 'CMB Digital IT', 0, 'bfcf2bf8672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('bff2cb49672411e989306c0b84a71dde', 16, 'hsbcDept', 124, 'CMB Digital Common Platform', 124, 'CMB Digital Common Platform', 0, 'bfedd765672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('bff7dc0f672411e989306c0b84a71dde', 16, 'hsbcDept', 125, 'CMB Digital GBBP', 125, 'CMB Digital GBBP', 0, 'bfedd765672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('bffcf9b1672411e989306c0b84a71dde', 16, 'hsbcDept', 126, 'CMB Digital Connect', 126, 'CMB Digital Connect', 0, 'bfedd765672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c0020ca8672411e989306c0b84a71dde', 16, 'hsbcDept', 32, 'CMB Global Standards Deployment', 32, 'CMB Global Standards Deployment', 0, 'bfcf2bf8672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c00728b6672411e989306c0b84a71dde', 16, 'hsbcDept', 127, 'CMB Global Standards Deployment', 127, 'CMB Global Standards Deployment', 0, 'c0020ca8672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c00c7158672411e989306c0b84a71dde', 16, 'hsbcDept', 33, 'Credit & Lending IT', 33, 'Credit & Lending IT', 0, 'bfcf2bf8672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c0116776672411e989306c0b84a71dde', 16, 'hsbcDept', 128, 'Credit & Lending Engineering', 128, 'Credit & Lending Engineering', 0, 'c00c7158672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c0168761672411e989306c0b84a71dde', 16, 'hsbcDept', 34, 'Global Trade & Receivables Finance IT', 34, 'Global Trade & Receivables Finance IT', 0, 'bfcf2bf8672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c01b8078672411e989306c0b84a71dde', 16, 'hsbcDept', 129, 'GTRF Engineering', 129, 'GTRF Engineering', 0, 'c0168761672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c0208c8f672411e989306c0b84a71dde', 16, 'hsbcDept', 130, 'GTRF Application Services', 130, 'GTRF Application Services', 0, 'c0168761672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c025b9f8672411e989306c0b84a71dde', 16, 'hsbcDept', 35, 'Regional Commercial Banking IT', 35, 'Regional Commercial Banking IT', 0, 'bfcf2bf8672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c02ac4c1672411e989306c0b84a71dde', 16, 'hsbcDept', 131, 'Regional Commercial Banking IT', 131, 'Regional Commercial Banking IT', 0, 'c025b9f8672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c02ff6cf672411e989306c0b84a71dde', 16, 'hsbcDept', 20, 'Payments and PCM', 20, 'Payments and PCM', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('c034ea51672411e989306c0b84a71dde', 16, 'hsbcDept', 95, 'Payments Messaging', 95, 'Payments Messaging', 0, 'c02ff6cf672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c039ffbd672411e989306c0b84a71dde', 16, 'hsbcDept', 227, 'Payments Messaging ASP', 227, 'Payments Messaging ASP', 0, 'c034ea51672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c03f1d2e672411e989306c0b84a71dde', 16, 'hsbcDept', 96, 'Payments Processing', 96, 'Payments Processing', 0, 'c02ff6cf672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c0442dc8672411e989306c0b84a71dde', 16, 'hsbcDept', 228, 'Global Payments Processing - ASP', 228, 'Global Payments Processing - ASP', 0, 'c03f1d2e672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c0495742672411e989306c0b84a71dde', 16, 'hsbcDept', 97, 'Payments Screening', 97, 'Payments Screening', 0, 'c02ff6cf672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c04e8194672411e989306c0b84a71dde', 16, 'hsbcDept', 229, 'Payments Screening ASP', 229, 'Payments Screening ASP', 0, 'c0495742672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c0539d94672411e989306c0b84a71dde', 16, 'hsbcDept', 98, 'PCM Products', 98, 'PCM Products', 0, 'c02ff6cf672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c0589f0e672411e989306c0b84a71dde', 16, 'hsbcDept', 230, 'PCM IT - ASP', 230, 'PCM IT - ASP', 0, 'c0539d94672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c05dc6f5672411e989306c0b84a71dde', 16, 'hsbcDept', 21, 'RBWM Technology', 21, 'RBWM Technology', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('c062ba96672411e989306c0b84a71dde', 16, 'hsbcDept', 100, 'RBWM Cards Engineering', 100, 'RBWM Cards Engineering', 0, 'c05dc6f5672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c067cd4b672411e989306c0b84a71dde', 16, 'hsbcDept', 232, 'Regional Cards Systems Engineering', 232, 'Regional Cards Systems Engineering', 0, 'c062ba96672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c06ce9fd672411e989306c0b84a71dde', 16, 'hsbcDept', 101, 'RBWM Digital Engineering', 101, 'RBWM Digital Engineering', 0, 'c05dc6f5672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c071fa85672411e989306c0b84a71dde', 16, 'hsbcDept', 233, 'XFT: Originations & Utilities', 233, 'XFT: Originations & Utilities', 0, 'c06ce9fd672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c0771b7c672411e989306c0b84a71dde', 16, 'hsbcDept', 234, 'XFT: Digital Acquisition', 234, 'XFT: Digital Acquisition', 0, 'c06ce9fd672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c07c2b60672411e989306c0b84a71dde', 16, 'hsbcDept', 235, 'XFT: Public Web Services', 235, 'XFT: Public Web Services', 0, 'c06ce9fd672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c08141f3672411e989306c0b84a71dde', 16, 'hsbcDept', 236, 'XFT: Secure Access', 236, 'XFT: Secure Access', 0, 'c06ce9fd672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c0865950672411e989306c0b84a71dde', 16, 'hsbcDept', 237, 'XFT: VADM', 237, 'XFT: VADM', 0, 'c06ce9fd672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c08b952c672411e989306c0b84a71dde', 16, 'hsbcDept', 238, 'XFT: Wealth & Insurance', 238, 'XFT: Wealth & Insurance', 0, 'c06ce9fd672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c09094f6672411e989306c0b84a71dde', 16, 'hsbcDept', 239, 'COO & Enablement: COO & HDS Leadership', 239, 'COO & Enablement: COO & HDS Leadership', 0, 'c06ce9fd672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c095b189672411e989306c0b84a71dde', 16, 'hsbcDept', 102, 'RBWM Insurance IT', 102, 'RBWM Insurance IT', 0, 'c05dc6f5672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c09ab91d672411e989306c0b84a71dde', 16, 'hsbcDept', 240, 'Insurance IT - Manufacturing', 240, 'Insurance IT - Manufacturing', 0, 'c095b189672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c09fcbd0672411e989306c0b84a71dde', 16, 'hsbcDept', 103, 'RBWM IT Infrastructure', 103, 'RBWM IT Infrastructure', 0, 'c05dc6f5672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c0a4e75f672411e989306c0b84a71dde', 16, 'hsbcDept', 241, 'RBWM IT Infrastructure', 241, 'RBWM IT Infrastructure', 0, 'c09fcbd0672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c0a9fb65672411e989306c0b84a71dde', 16, 'hsbcDept', 104, 'RBWM Retail Business Banking IT', 104, 'RBWM Retail Business Banking IT', 0, 'c05dc6f5672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c0af0bf0672411e989306c0b84a71dde', 16, 'hsbcDept', 242, 'RBB - IT', 242, 'RBB - IT', 0, 'c0a9fb65672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c0b424ec672411e989306c0b84a71dde', 16, 'hsbcDept', 105, 'RBWM Sales & Distribution IT', 105, 'RBWM Sales & Distribution IT', 0, 'c05dc6f5672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c0b93aa2672411e989306c0b84a71dde', 16, 'hsbcDept', 243, 'Self-Service', 243, 'Self-Service', 0, 'c0b424ec672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c0be5413672411e989306c0b84a71dde', 16, 'hsbcDept', 244, 'S&D Production Support', 244, 'S&D Production Support', 0, 'c0b424ec672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c0c36b80672411e989306c0b84a71dde', 16, 'hsbcDept', 245, 'S&D Integration & Deployment', 245, 'S&D Integration & Deployment', 0, 'c0b424ec672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c0c88402672411e989306c0b84a71dde', 16, 'hsbcDept', 106, 'RBWM Wealth Management IT', 106, 'RBWM Wealth Management IT', 0, 'c05dc6f5672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c0cd9bdc672411e989306c0b84a71dde', 16, 'hsbcDept', 246, 'Wealth Management IT General', 246, 'Wealth Management IT General', 0, 'c0c88402672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c0d2bc86672411e989306c0b84a71dde', 16, 'hsbcDept', 261, 'RBWM Retail Products IT', 261, 'RBWM Retail Products IT', 0, 'c05dc6f5672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c0d7c59c672411e989306c0b84a71dde', 16, 'hsbcDept', 99, 'RBWM Amortisation and Capitalisation', 99, 'RBWM Amortisation and Capitalisation', 0, 'c05dc6f5672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c0dcd967672411e989306c0b84a71dde', 16, 'hsbcDept', 231, 'RBWM Amortisation and Capitalisation', 231, 'RBWM Amortisation and Capitalisation', 0, 'c0d7c59c672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c0e2020d672411e989306c0b84a71dde', 16, 'hsbcDept', 22, 'Regional IT', 22, 'Regional IT', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('c0e70fff672411e989306c0b84a71dde', 16, 'hsbcDept', 107, 'Regional CIO - ASP', 107, 'Regional CIO - ASP', 0, 'c0e2020d672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c0ec1f6f672411e989306c0b84a71dde', 16, 'hsbcDept', 247, 'Regional CIO - ASP-HS Bank', 247, 'Regional CIO - ASP-HS Bank', 0, 'c0e70fff672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c0f1399f672411e989306c0b84a71dde', 16, 'hsbcDept', 248, 'Regional CIO - ASP - General', 248, 'Regional CIO - ASP - General', 0, 'c0e70fff672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c0f666e3672411e989306c0b84a71dde', 16, 'hsbcDept', 108, 'Regional CIO - Canada', 108, 'Regional CIO - Canada', 0, 'c0e2020d672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c0fb7b00672411e989306c0b84a71dde', 16, 'hsbcDept', 249, 'Regional CIO - Canada', 249, 'Regional CIO - Canada', 0, 'c0f666e3672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c100983c672411e989306c0b84a71dde', 16, 'hsbcDept', 23, 'Resourcing and Onboarding', 23, 'Resourcing and Onboarding', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('c10446ef672411e989306c0b84a71dde', 16, 'hsbcDept', 109, 'Resourcing GB', 109, 'Resourcing GB', 0, 'c100983c672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c108123e672411e989306c0b84a71dde', 16, 'hsbcDept', 250, 'Resourcing GB (Retained)', 250, 'Resourcing GB (Retained)', 0, 'c10446ef672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c10bebf9672411e989306c0b84a71dde', 16, 'hsbcDept', 24, 'Risk IT', 24, 'Risk IT', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('c10fbde0672411e989306c0b84a71dde', 16, 'hsbcDept', 110, 'Europe and Regulatory Compliance', 110, 'Europe and Regulatory Compliance', 0, 'c10bebf9672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c1138f1b672411e989306c0b84a71dde', 16, 'hsbcDept', 251, 'Europe and Regulatory Compliance', 251, 'Europe and Regulatory Compliance', 0, 'c10fbde0672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c117669a672411e989306c0b84a71dde', 16, 'hsbcDept', 111, 'Group Risk Analytics & Risk Strategy', 111, 'Group Risk Analytics & Risk Strategy', 0, 'c10bebf9672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c11b30df672411e989306c0b84a71dde', 16, 'hsbcDept', 252, 'Group Risk Analytics & Risk Strategy', 252, 'Group Risk Analytics & Risk Strategy', 0, 'c117669a672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c11f0976672411e989306c0b84a71dde', 16, 'hsbcDept', 112, 'Retail Credit Risk', 112, 'Retail Credit Risk', 0, 'c10bebf9672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c122d415672411e989306c0b84a71dde', 16, 'hsbcDept', 253, 'Retail Credit Risk', 253, 'Retail Credit Risk', 0, 'c11f0976672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c126ab15672411e989306c0b84a71dde', 16, 'hsbcDept', 113, 'Risk IT Other', 113, 'Risk IT Other', 0, 'c10bebf9672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c12a765c672411e989306c0b84a71dde', 16, 'hsbcDept', 254, 'Risk IT Other', 254, 'Risk IT Other', 0, 'c126ab15672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c12e4f9b672411e989306c0b84a71dde', 16, 'hsbcDept', 114, 'Traded Risk', 114, 'Traded Risk', 0, 'c10bebf9672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c1321908672411e989306c0b84a71dde', 16, 'hsbcDept', 255, 'Traded Risk', 255, 'Traded Risk', 0, 'c12e4f9b672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c135f082672411e989306c0b84a71dde', 16, 'hsbcDept', 115, 'Wholesale Credit Risk', 115, 'Wholesale Credit Risk', 0, 'c10bebf9672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c139bb8c672411e989306c0b84a71dde', 16, 'hsbcDept', 256, 'Wholesale Credit Risk', 256, 'Wholesale Credit Risk', 0, 'c135f082672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c13d9775672411e989306c0b84a71dde', 16, 'hsbcDept', 25, 'Security Risk', 25, 'Security Risk', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('c1415d21672411e989306c0b84a71dde', 16, 'hsbcDept', 116, 'Contingency Risk', 116, 'Contingency Risk', 0, 'c13d9775672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c1452eed672411e989306c0b84a71dde', 16, 'hsbcDept', 257, 'Cont Risk (Retained)', 257, 'Cont Risk (Retained)', 0, 'c1415d21672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c149064f672411e989306c0b84a71dde', 16, 'hsbcDept', 117, 'Physical Security Risk', 117, 'Physical Security Risk', 0, 'c13d9775672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c14cd1a1672411e989306c0b84a71dde', 16, 'hsbcDept', 258, 'Physcal Secu Risk(Retained)', 258, 'Physcal Secu Risk(Retained)', 0, 'c149064f672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c150a916672411e989306c0b84a71dde', 16, 'hsbcDept', 26, 'Shared AD Services', 26, 'Shared AD Services', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('c1546c70672411e989306c0b84a71dde', 16, 'hsbcDept', 118, 'Dev Ops Tooling', 118, 'Dev Ops Tooling', 0, 'c150a916672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c15845b2672411e989306c0b84a71dde', 16, 'hsbcDept', 259, 'Dev Ops Tooling', 259, 'Dev Ops Tooling', 0, 'c1546c70672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c15c219c672411e989306c0b84a71dde', 16, 'hsbcDept', 27, 'Third Party Mgmt', 27, 'Third Party Mgmt', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('c15fe7d3672411e989306c0b84a71dde', 16, 'hsbcDept', 119, 'Contract Lifecycle TPM', 119, 'Contract Lifecycle TPM', 0, 'c15c219c672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c163b6e2672411e989306c0b84a71dde', 16, 'hsbcDept', 260, 'Contract Lifecycle TPM', 260, 'Contract Lifecycle TPM', 0, 'c15fe7d3672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c16793bf672411e989306c0b84a71dde', 16, 'hsbcDept', 3, 'Corporate Functions IT', 3, 'Corporate Functions IT', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('c16b5c50672411e989306c0b84a71dde', 16, 'hsbcDept', 36, 'CF Business Finance IT', 36, 'CF Business Finance IT', 0, 'c16793bf672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c16f2cb0672411e989306c0b84a71dde', 16, 'hsbcDept', 132, 'CF Business Finance IT', 132, 'CF Business Finance IT', 0, 'c16b5c50672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c17304e7672411e989306c0b84a71dde', 16, 'hsbcDept', 37, 'CF Capital IT', 37, 'CF Capital IT', 0, 'c16793bf672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c176cf99672411e989306c0b84a71dde', 16, 'hsbcDept', 133, 'CF Capital IT', 133, 'CF Capital IT', 0, 'c17304e7672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c17aa8ab672411e989306c0b84a71dde', 16, 'hsbcDept', 38, 'CF Fin Reporting & Op Acctg IT', 38, 'CF Fin Reporting & Op Acctg IT', 0, 'c16793bf672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c17e727e672411e989306c0b84a71dde', 16, 'hsbcDept', 134, 'CF Fin Reporting & Op Acctg IT', 134, 'CF Fin Reporting & Op Acctg IT', 0, 'c17aa8ab672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c1824a33672411e989306c0b84a71dde', 16, 'hsbcDept', 39, 'CF HR IT', 39, 'CF HR IT', 0, 'c16793bf672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c1861571672411e989306c0b84a71dde', 16, 'hsbcDept', 135, 'CF HR IT', 135, 'CF HR IT', 0, 'c1824a33672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c189ed1e672411e989306c0b84a71dde', 16, 'hsbcDept', 40, 'CF Marketing & Comms IT', 40, 'CF Marketing & Comms IT', 0, 'c16793bf672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c18db6a1672411e989306c0b84a71dde', 16, 'hsbcDept', 136, 'CF Marketing & Comms IT', 136, 'CF Marketing & Comms IT', 0, 'c189ed1e672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c191920f672411e989306c0b84a71dde', 16, 'hsbcDept', 4, 'Cyber Security', 4, 'Cyber Security', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('c1955a1e672411e989306c0b84a71dde', 16, 'hsbcDept', 41, 'Cybersecurity Assmt & Testing', 41, 'Cybersecurity Assmt & Testing', 0, 'c191920f672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c1992b47672411e989306c0b84a71dde', 16, 'hsbcDept', 137, 'Application Security', 137, 'Application Security', 0, 'c1955a1e672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c19cfe28672411e989306c0b84a71dde', 16, 'hsbcDept', 42, 'Cybersecurity Technology', 42, 'Cybersecurity Technology', 0, 'c191920f672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c1a0ce4a672411e989306c0b84a71dde', 16, 'hsbcDept', 138, 'Information Security General', 138, 'Information Security General', 0, 'c19cfe28672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c1a4b390672411e989306c0b84a71dde', 16, 'hsbcDept', 5, 'Data Services', 5, 'Data Services', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('c1a875af672411e989306c0b84a71dde', 16, 'hsbcDept', 43, 'Data Engineering', 43, 'Data Engineering', 0, 'c1a4b390672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c1ac4498672411e989306c0b84a71dde', 16, 'hsbcDept', 139, 'Data Svcs Eng-Data Engineering', 139, 'Data Svcs Eng-Data Engineering', 0, 'c1a875af672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c1b01419672411e989306c0b84a71dde', 16, 'hsbcDept', 140, 'Data Svcs Eng-Big Data', 140, 'Data Svcs Eng-Big Data', 0, 'c1a875af672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c1b3f491672411e989306c0b84a71dde', 16, 'hsbcDept', 141, 'Data Svcs Eng-Cust & Ref Data', 141, 'Data Svcs Eng-Cust & Ref Data', 0, 'c1a875af672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c1b7cf27672411e989306c0b84a71dde', 16, 'hsbcDept', 6, 'FINANCIAL CONTROL', 6, 'FINANCIAL CONTROL', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('c1bb8e53672411e989306c0b84a71dde', 16, 'hsbcDept', 44, 'ServCo FC', 44, 'ServCo FC', 0, 'c1b7cf27672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c1bf5d9b672411e989306c0b84a71dde', 16, 'hsbcDept', 142, 'ServCo FC(Stewardship)', 142, 'ServCo FC(Stewardship)', 0, 'c1bb8e53672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c1c339aa672411e989306c0b84a71dde', 16, 'hsbcDept', 7, 'Global Banking & Markets IT', 7, 'Global Banking & Markets IT', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('c1c6fac8672411e989306c0b84a71dde', 16, 'hsbcDept', 45, 'Asset Management IT', 45, 'Asset Management IT', 0, 'c1c339aa672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c1cacc04672411e989306c0b84a71dde', 16, 'hsbcDept', 143, 'Asset Management IT', 143, 'Asset Management IT', 0, 'c1c6fac8672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c1cea295672411e989306c0b84a71dde', 16, 'hsbcDept', 46, 'B&CF and Enterprise Data IT', 46, 'B&CF and Enterprise Data IT', 0, 'c1c339aa672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c1d26dfc672411e989306c0b84a71dde', 16, 'hsbcDept', 144, 'Global Banking IT', 144, 'Global Banking IT', 0, 'c1cea295672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c1d64506672411e989306c0b84a71dde', 16, 'hsbcDept', 47, 'BSM and Cross-Asset IT', 47, 'BSM and Cross-Asset IT', 0, 'c1c339aa672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c1da1059672411e989306c0b84a71dde', 16, 'hsbcDept', 145, 'CATS', 145, 'CATS', 0, 'c1d64506672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c1dde411672411e989306c0b84a71dde', 16, 'hsbcDept', 146, 'Trade Reporting', 146, 'Trade Reporting', 0, 'c1d64506672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c1e1b60b672411e989306c0b84a71dde', 16, 'hsbcDept', 147, 'Big Data', 147, 'Big Data', 0, 'c1d64506672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c1e58973672411e989306c0b84a71dde', 16, 'hsbcDept', 48, 'COO and IT Management', 48, 'COO and IT Management', 0, 'c1c339aa672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c1e97f3a672411e989306c0b84a71dde', 16, 'hsbcDept', 148, 'GBM IT Architecture and Strategy', 148, 'GBM IT Architecture and Strategy', 0, 'c1e58973672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c1ee9dd1672411e989306c0b84a71dde', 16, 'hsbcDept', 149, 'GBM IT COO and Management', 149, 'GBM IT COO and Management', 0, 'c1e58973672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c1f3c25e672411e989306c0b84a71dde', 16, 'hsbcDept', 49, 'Cross-Service Line Application Services', 49, 'Cross-Service Line Application Services', 0, 'c1c339aa672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c1f8c687672411e989306c0b84a71dde', 16, 'hsbcDept', 150, 'Cross Assets App Services', 150, 'Cross Assets App Services', 0, 'c1f3c25e672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c1fde4f7672411e989306c0b84a71dde', 16, 'hsbcDept', 50, 'Equities IT', 50, 'Equities IT', 0, 'c1c339aa672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c202f4b3672411e989306c0b84a71dde', 16, 'hsbcDept', 151, 'Prime Finance IT', 151, 'Prime Finance IT', 0, 'c1fde4f7672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c2080f60672411e989306c0b84a71dde', 16, 'hsbcDept', 152, 'Equity Derivatives IT', 152, 'Equity Derivatives IT', 0, 'c1fde4f7672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c20d2539672411e989306c0b84a71dde', 16, 'hsbcDept', 153, 'Cash Equities IT', 153, 'Cash Equities IT', 0, 'c1fde4f7672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c212493e672411e989306c0b84a71dde', 16, 'hsbcDept', 51, 'Finance and GDIS IT', 51, 'Finance and GDIS IT', 0, 'c1c339aa672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c2175039672411e989306c0b84a71dde', 16, 'hsbcDept', 154, 'Finance & Reg IT-FCS', 154, 'Finance & Reg IT-FCS', 0, 'c212493e672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c21c6a50672411e989306c0b84a71dde', 16, 'hsbcDept', 155, 'Finance & Reg IT-Reg', 155, 'Finance & Reg IT-Reg', 0, 'c212493e672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c2218c31672411e989306c0b84a71dde', 16, 'hsbcDept', 52, 'Fixed Income and Emerging Markets IT', 52, 'Fixed Income and Emerging Markets IT', 0, 'c1c339aa672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c2269482672411e989306c0b84a71dde', 16, 'hsbcDept', 156, 'Fixed Income IT-Cash&eTrading', 156, 'Fixed Income IT-Cash&eTrading', 0, 'c2218c31672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c22bb16b672411e989306c0b84a71dde', 16, 'hsbcDept', 53, 'GBM IT International', 53, 'GBM IT International', 0, 'c1c339aa672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c230cde1672411e989306c0b84a71dde', 16, 'hsbcDept', 157, 'GBM IT ASP', 157, 'GBM IT ASP', 0, 'c22bb16b672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c235e3bb672411e989306c0b84a71dde', 16, 'hsbcDept', 54, 'GBM ITID', 54, 'GBM ITID', 0, 'c1c339aa672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c23af07f672411e989306c0b84a71dde', 16, 'hsbcDept', 158, 'GBM ITID', 158, 'GBM ITID', 0, 'c235e3bb672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c2400525672411e989306c0b84a71dde', 16, 'hsbcDept', 55, 'GFX IT', 55, 'GFX IT', 0, 'c1c339aa672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c2451cec672411e989306c0b84a71dde', 16, 'hsbcDept', 159, 'GFIX', 159, 'GFIX', 0, 'c2400525672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c24a3736672411e989306c0b84a71dde', 16, 'hsbcDept', 160, 'GFX FX', 160, 'GFX FX', 0, 'c2400525672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c24f4dad672411e989306c0b84a71dde', 16, 'hsbcDept', 161, 'GFX FXO', 161, 'GFX FXO', 0, 'c2400525672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c25464f4672411e989306c0b84a71dde', 16, 'hsbcDept', 162, 'GFX Services', 162, 'GFX Services', 0, 'c2400525672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c2597ba0672411e989306c0b84a71dde', 16, 'hsbcDept', 163, 'GFIX and River', 163, 'GFIX and River', 0, 'c2400525672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c25e9ace672411e989306c0b84a71dde', 16, 'hsbcDept', 164, 'FXO and Commodities', 164, 'FXO and Commodities', 0, 'c2400525672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c263aca9672411e989306c0b84a71dde', 16, 'hsbcDept', 56, 'HSS IT', 56, 'HSS IT', 0, 'c1c339aa672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c268bce1672411e989306c0b84a71dde', 16, 'hsbcDept', 165, 'Shared Services', 165, 'Shared Services', 0, 'c263aca9672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c26dd162672411e989306c0b84a71dde', 16, 'hsbcDept', 166, 'Funds', 166, 'Funds', 0, 'c263aca9672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c272e327672411e989306c0b84a71dde', 16, 'hsbcDept', 167, 'Custody', 167, 'Custody', 0, 'c263aca9672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c2780320672411e989306c0b84a71dde', 16, 'hsbcDept', 168, 'Broker Outsourcing & CTLA', 168, 'Broker Outsourcing & CTLA', 0, 'c263aca9672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c27d27f0672411e989306c0b84a71dde', 16, 'hsbcDept', 57, 'Markets Operations Technology', 57, 'Markets Operations Technology', 0, 'c1c339aa672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c2822a56672411e989306c0b84a71dde', 16, 'hsbcDept', 169, 'TREATS', 169, 'TREATS', 0, 'c27d27f0672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c2874165672411e989306c0b84a71dde', 16, 'hsbcDept', 170, 'Utilities', 170, 'Utilities', 0, 'c27d27f0672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c28c5794672411e989306c0b84a71dde', 16, 'hsbcDept', 171, 'Workflow & SBS', 171, 'Workflow & SBS', 0, 'c27d27f0672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c2916e94672411e989306c0b84a71dde', 16, 'hsbcDept', 172, 'Futures', 172, 'Futures', 0, 'c27d27f0672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c296883f672411e989306c0b84a71dde', 16, 'hsbcDept', 58, 'Sales, Research and Digital', 58, 'Sales, Research and Digital', 0, 'c1c339aa672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c29ba20a672411e989306c0b84a71dde', 16, 'hsbcDept', 173, 'Sales', 173, 'Sales', 0, 'c296883f672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c2a0bfcf672411e989306c0b84a71dde', 16, 'hsbcDept', 8, 'OSS', 8, 'OSS', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('c2a5cd42672411e989306c0b84a71dde', 16, 'hsbcDept', 59, 'Automation', 59, 'Automation', 0, 'c2a0bfcf672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c2aae8f0672411e989306c0b84a71dde', 16, 'hsbcDept', 174, 'Light Automation Delivery', 174, 'Light Automation Delivery', 0, 'c2a5cd42672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c2b00156672411e989306c0b84a71dde', 16, 'hsbcDept', 60, 'Core Banking Engineering', 60, 'Core Banking Engineering', 0, 'c2a0bfcf672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c2b511f1672411e989306c0b84a71dde', 16, 'hsbcDept', 175, 'Core Banking  - OBS', 175, 'Core Banking  - OBS', 0, 'c2b00156672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c2ba345b672411e989306c0b84a71dde', 16, 'hsbcDept', 176, 'Core Banking - Quality', 176, 'Core Banking - Quality', 0, 'c2b00156672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c2bf4315672411e989306c0b84a71dde', 16, 'hsbcDept', 177, 'Core Banking-HUB Pay,Chan&Intf', 177, 'Core Banking-HUB Pay,Chan&Intf', 0, 'c2b00156672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c2c4599c672411e989306c0b84a71dde', 16, 'hsbcDept', 178, 'Core Banking - HUB Payments', 178, 'Core Banking - HUB Payments', 0, 'c2b00156672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c2c977eb672411e989306c0b84a71dde', 16, 'hsbcDept', 179, 'Core Banking - Rel & Env Mgmt', 179, 'Core Banking - Rel & Env Mgmt', 0, 'c2b00156672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c2ce82c6672411e989306c0b84a71dde', 16, 'hsbcDept', 180, 'Core Banking-HUB Lend,Risk&Fin', 180, 'Core Banking-HUB Lend,Risk&Fin', 0, 'c2b00156672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c2d39d57672411e989306c0b84a71dde', 16, 'hsbcDept', 181, 'Core Banking  - HCB', 181, 'Core Banking  - HCB', 0, 'c2b00156672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c2d8b484672411e989306c0b84a71dde', 16, 'hsbcDept', 182, 'Core Banking-HUB GS&C', 182, 'Core Banking-HUB GS&C', 0, 'c2b00156672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c2dddc40672411e989306c0b84a71dde', 16, 'hsbcDept', 61, 'Operations IT - CTB', 61, 'Operations IT - CTB', 0, 'c2a0bfcf672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c2e2e311672411e989306c0b84a71dde', 16, 'hsbcDept', 183, 'Operations IT - CTB', 183, 'Operations IT - CTB', 0, 'c2dddc40672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c2e80656672411e989306c0b84a71dde', 16, 'hsbcDept', 62, 'Utilities', 62, 'Utilities', 0, 'c2a0bfcf672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c2ed0c72672411e989306c0b84a71dde', 16, 'hsbcDept', 184, 'Utilities General', 184, 'Utilities General', 0, 'c2e80656672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c2f22ca9672411e989306c0b84a71dde', 16, 'hsbcDept', 9, 'Global Private Banking IT', 9, 'Global Private Banking IT', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('c2f740f7672411e989306c0b84a71dde', 16, 'hsbcDept', 63, 'Channels', 63, 'Channels', 0, 'c2f22ca9672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c2fc50f7672411e989306c0b84a71dde', 16, 'hsbcDept', 185, 'GPB Channels', 185, 'GPB Channels', 0, 'c2f740f7672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c3016c52672411e989306c0b84a71dde', 16, 'hsbcDept', 64, 'Cross Product Services', 64, 'Cross Product Services', 0, 'c2f22ca9672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c306855b672411e989306c0b84a71dde', 16, 'hsbcDept', 186, 'Cross Product Services', 186, 'Cross Product Services', 0, 'c3016c52672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c30b9b97672411e989306c0b84a71dde', 16, 'hsbcDept', 65, 'GPB Global Standards Deployment', 65, 'GPB Global Standards Deployment', 0, 'c2f22ca9672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c310aca0672411e989306c0b84a71dde', 16, 'hsbcDept', 187, 'GPB Global Standards Deployment', 187, 'GPB Global Standards Deployment', 0, 'c30b9b97672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c315d39c672411e989306c0b84a71dde', 16, 'hsbcDept', 66, 'GPB IT Infra Del', 66, 'GPB IT Infra Del', 0, 'c2f22ca9672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c31ada03672411e989306c0b84a71dde', 16, 'hsbcDept', 188, 'GPB IT Infra Del', 188, 'GPB IT Infra Del', 0, 'c315d39c672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c31ff6a5672411e989306c0b84a71dde', 16, 'hsbcDept', 67, 'PPM - Private Banking', 67, 'PPM - Private Banking', 0, 'c2f22ca9672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c3250ffa672411e989306c0b84a71dde', 16, 'hsbcDept', 189, 'PPM - Private Banking', 189, 'PPM - Private Banking', 0, 'c31ff6a5672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c32a243b672411e989306c0b84a71dde', 16, 'hsbcDept', 68, 'Product', 68, 'Product', 0, 'c2f22ca9672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c32f3520672411e989306c0b84a71dde', 16, 'hsbcDept', 190, 'GPB Product', 190, 'GPB Product', 0, 'c32a243b672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c33458d3672411e989306c0b84a71dde', 16, 'hsbcDept', 69, 'Regional GPB IT ASP', 69, 'Regional GPB IT ASP', 0, 'c2f22ca9672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c3395a24672411e989306c0b84a71dde', 16, 'hsbcDept', 191, 'GPB IT ASP', 191, 'GPB IT ASP', 0, 'c33458d3672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c33e8105672411e989306c0b84a71dde', 16, 'hsbcDept', 70, 'Regional GPB IT IT EMEA', 70, 'Regional GPB IT IT EMEA', 0, 'c2f22ca9672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c357e871672411e989306c0b84a71dde', 16, 'hsbcDept', 192, 'GPB IT EMEA', 192, 'GPB IT EMEA', 0, 'c33e8105672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c35d0544672411e989306c0b84a71dde', 16, 'hsbcDept', 71, 'Service Integration Layer', 71, 'Service Integration Layer', 0, 'c2f22ca9672411e989306c0b84a71dde');
INSERT INTO `b_data_dictionary` VALUES ('c3621ba3672411e989306c0b84a71dde', 16, 'hsbcDept', 193, 'Service Integration Layer', 193, 'Service Integration Layer', 0, 'c35d0544672411e989306c0b84a71dde');


-- delete lockedStatus
delete from b_data_dictionary where TYPE_NAME='lockedStatus';
-- insert lockedStatus
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe12345639bd630er3aa325421', 5, 'lockedStatus', 6, '产假期', 6, 'Maternity Leave', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe12345639bd630er3aa555424', 5, 'lockedStatus', 5, '解决方案', 5, 'Solution', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34124239bd630er3aa555425', 5, 'lockedStatus', 4, '面试锁定', 4, 'Interview Lock', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34124459bd630er3aa444424', 5, 'lockedStatus', 3, '锁定', 3, 'Lock', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34124539bd630er3aa333423', 5, 'lockedStatus', 2, '待入池', 2, 'Pending', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34124769bd630er3aa123422', 5, 'lockedStatus', 1, '闲置', 1, 'Available', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34124849bd630er3aa152342', 5, 'lockedStatus', 0, '全部', 0, 'ALL', 0, NULL);


-- delete MSARole
delete from b_data_dictionary where TYPE_NAME='MSARole';
-- insert MSARole
INSERT INTO `b_data_dictionary` VALUES ('048e952e838311e989306c0b84a71dde', 21, 'MSARole', 0, 'All', 0, 'All', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('9d707364838811e989306c0b84a71dde', 21, 'MSARole', 1, 'Trainee', 1, 'Trainee', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('9d76c3a6838811e989306c0b84a71dde', 21, 'MSARole', 2, 'Junior Developer', 2, 'Junior Developer', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('9d7e8046838811e989306c0b84a71dde', 21, 'MSARole', 3, 'Junior Tester', 3, 'Junior Tester', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('9d839252838811e989306c0b84a71dde', 21, 'MSARole', 4, 'Junior-infrastructure', 4, 'Junior-infrastructure', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('9d889ea3838811e989306c0b84a71dde', 21, 'MSARole', 5, 'Developer', 5, 'Developer', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('9d8db1bd838811e989306c0b84a71dde', 21, 'MSARole', 6, 'Intermediate-infrastructure', 6, 'Intermediate-infrastructure', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('9d92cc67838811e989306c0b84a71dde', 21, 'MSARole', 7, 'Business Analyst', 7, 'Business Analyst', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('9d97d630838811e989306c0b84a71dde', 21, 'MSARole', 8, 'Tester', 8, 'Tester', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('9d9cf1ee838811e989306c0b84a71dde', 21, 'MSARole', 9, 'Senior Developer', 9, 'Senior Developer', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('9da20f19838811e989306c0b84a71dde', 21, 'MSARole', 10, 'Senior-infrastructure', 10, 'Senior-infrastructure', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('9da72679838811e989306c0b84a71dde', 21, 'MSARole', 11, 'Senior Business Analyst', 11, 'Senior Business Analyst', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('9dac35b5838811e989306c0b84a71dde', 21, 'MSARole', 12, 'Senior Tester', 12, 'Senior Tester', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('9db1577e838811e989306c0b84a71dde', 21, 'MSARole', 13, 'Architect', 13, 'Architect', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('9db65cb3838811e989306c0b84a71dde', 21, 'MSARole', 14, 'Programme Managner', 14, 'Programme Managner', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('9dbb78d0838811e989306c0b84a71dde', 21, 'MSARole', 15, 'Project Managner', 15, 'Project Managner', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('9dc09857838811e989306c0b84a71dde', 21, 'MSARole', 16, 'Test Managner', 16, 'Test Managner', 0, NULL);

-- delete releaseReason
delete from b_data_dictionary where TYPE_NAME='releaseReason';
-- insert releaseReason
INSERT INTO `b_data_dictionary` VALUES ('00cfebdf34124339bd630er3ab643000', 9, 'releaseReason', 0, '全部', 0, 'ALL', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebdf34124339bd630er3ab643111', 9, 'releaseReason', 1, '项目结束', 1, '项目结束', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebdf34124339bd630er3cd643222', 9, 'releaseReason', 2, '释放资源', 2, '释放资源', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebdf34124339bd630er3ef643333', 9, 'releaseReason', 3, '战略投入', 3, '战略投入', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebdf34124339bd630er3gh643444', 9, 'releaseReason', 4, '绩效不好', 4, '绩效不好', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebdf34124339bd630er3ij643555', 9, 'releaseReason', 5, '项目调整', 5, '项目调整', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebdf34124339bd630er3lm643666', 9, 'releaseReason', 6, '待产人员', 6, '待产人员', 0, NULL);

-- delete resourceProps
delete from b_data_dictionary where TYPE_NAME='resourceProps';
-- insert resourceProps
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34122349bd630er333441a32', 2, 'resourceProps', 2, '释放资源', 2, 'Release Resources', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34343219bd630er353241a33', 2, 'resourceProps', 3, '战略投资资源', 3, 'Strategic Investment Resources', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34545413f4354er311141a31', 2, 'resourceProps', 0, '全部', 0, 'All', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34545419bd630er311141a31', 2, 'resourceProps', 1, '其它闲置资源', 1, 'Other Idle Resources', 0, NULL);

-- delete role
delete from b_data_dictionary where TYPE_NAME='role';
-- insert role
INSERT INTO `b_data_dictionary` VALUES ('00cfebdf34124119bd630er3aa643422', 8, 'role', 2, 'Junior', 2, 'Junior', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebdf34124229bd630er3aa643423', 8, 'role', 3, 'Intermediate', 3, 'Intermediate', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebdf34124339bd630er3aa643421', 8, 'role', 1, 'Trainee', 1, 'Trainee', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebdf34124449bd630er3aa643424', 8, 'role', 4, 'Senior', 4, 'Senior', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebdf34124559bd630er3aa643425', 8, 'role', 5, 'Architect', 5, 'Architect', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebdf34124669bd630er3aa643426', 8, 'role', 6, 'TL', 6, 'TL', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebdf34124779bd630er3aa643427', 8, 'role', 7, 'PM', 7, 'PM', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebdf34124889bd630er3aa643428', 8, 'role', 0, 'All', 0, 'All', 0, NULL);

-- delete skill
delete from b_data_dictionary where TYPE_NAME='skill';
-- insert skill
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe31433419bd630er388841a33', 3, 'skill', 44, 'Dynamic', 44, 'Dynamic', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe33536419bd630er341841a32', 3, 'skill', 49, 'ETL', 49, 'ETL', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe33536419bd630er345141a32', 3, 'skill', 45, 'Senior MuleSoft', 45, 'Senior MuleSoft', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe33536419bd630er345841a32', 3, 'skill', 41, 'PM', 41, 'PM', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34012419bd630er388841a37', 3, 'skill', 5, 'Automation Testing', 5, 'Automation Testing', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34064219bd630er388841a37', 3, 'skill', 6, 'AWS', 6, 'AWS', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34097619bd630er388841a37', 3, 'skill', 7, 'AEM', 7, 'AEM', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34124119bd630er322241a12', 3, 'skill', 0, '全部', 0, 'All', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34124119bd630er388841a37', 3, 'skill', 1, '.NET', 1, '.NET', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34134519bd630er388841a37', 3, 'skill', 3, 'Angular js', 3, 'Angular js', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34162419bd630er354641a34', 3, 'skill', 47, 'Architect', 47, 'Architect', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34324619bd630er388841a37', 3, 'skill', 8, 'BI', 8, 'BI', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34342419bd630er312341a35', 3, 'skill', 28, 'Maintenance', 28, 'Maintenance', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34344219bd630er388841a37', 3, 'skill', 2, 'Android', 2, 'Android', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34535719bd630er388841a37', 3, 'skill', 10, 'BA', 10, 'BA', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34565419bd630er300041a00', 3, 'skill', 33, 'React JS', 33, 'React JS', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34565419bd630er309751a37', 3, 'skill', 14, 'CBP', 14, 'CBP', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34565419bd630er322241a97', 3, 'skill', 34, 'Transition', 34, 'Transition', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34565419bd630er323241a34', 3, 'skill', 29, 'Management', 29, 'Management', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34565419bd630er324561a37', 3, 'skill', 13, 'C++', 13, 'C++', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34565419bd630er335641a38', 3, 'skill', 35, 'Training', 35, 'Training', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34565419bd630er335741a36', 3, 'skill', 37, 'UI', 37, 'UI', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34565419bd630er343241a33', 3, 'skill', 30, 'Oracle', 30, 'Oracle', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34565419bd630er354611a34', 3, 'skill', 43, 'Devops', 43, 'Devops', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34565419bd630er354641a11', 3, 'skill', 32, 'QA', 32, 'QA', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34565419bd630er354641a34', 3, 'skill', 39, 'Vision Plus', 39, 'Vision Plus', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34565419bd630er364531a37', 3, 'skill', 11, 'C', 11, 'C', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34565419bd630er365431a37', 3, 'skill', 12, 'C#', 12, 'C#', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34565419bd630er380001a37', 3, 'skill', 17, 'DOJO', 17, 'DOJO', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34565419bd630er380981a88', 3, 'skill', 25, 'Java', 25, 'Java', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34565419bd630er383331a37', 3, 'skill', 23, 'HTML', 23, 'HTML', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34565419bd630er384441a37', 3, 'skill', 22, 'HR', 22, 'HR', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34565419bd630er385431a37', 3, 'skill', 16, 'DBA', 16, 'DBA', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34565419bd630er385443a66', 3, 'skill', 27, 'Mainframe', 27, 'Mainframe', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34565419bd630er385541a37', 3, 'skill', 21, 'Help Desk', 21, 'Help Desk', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34565419bd630er386541a37', 3, 'skill', 36, 'Unix', 36, 'Unix', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34565419bd630er386661a37', 3, 'skill', 20, 'Function Testing', 20, 'Function Testing', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34565419bd630er387541a22', 3, 'skill', 31, 'PMO', 31, 'PMO', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34565419bd630er387651a77', 3, 'skill', 26, 'Linux', 26, 'Linux', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34565419bd630er387771a37', 3, 'skill', 19, 'Export', 19, 'Export', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34565419bd630er388641a39', 3, 'skill', 24, 'IOS', 24, 'IOS', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34565419bd630er389991a37', 3, 'skill', 18, 'Developer', 18, 'Developer', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34565419bd630er395371a37', 3, 'skill', 15, 'Data stage', 15, 'Data stage', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34565419bd630er397641a35', 3, 'skill', 38, 'vb', 38, 'vb', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34865319bd630er388841a37', 3, 'skill', 9, 'BPM', 9, 'BPM', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34987619bd630er388841a37', 3, 'skill', 4, 'AS400', 4, 'AS400', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe35431419bd630er382841a33', 3, 'skill', 48, 'Senior Consultant', 48, 'Senior Consultant', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe35433419bd630er338841a33', 3, 'skill', 40, 'WEB', 40, 'WEB', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe38154319bd630er331541a31', 3, 'skill', 46, 'IT Security', 46, 'IT Security', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe38653319bd630er334541a31', 3, 'skill', 50, 'Other', 50, 'Other', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe38654319bd630er333541a31', 3, 'skill', 42, 'BMO', 42, 'BMO', 0, NULL);


-- delete subdeptName
delete from b_data_dictionary where TYPE_NAME='subdeptName';
-- insert subdeptName
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34124119bd630er3aa240638', 4, 'subdeptName', 13, '核心内审与卡交付部', 13, '核心内审与卡交付部', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34124119bd630er3aa240889', 4, 'subdeptName', 22, '开发测试交付部', 22, '开发测试交付部', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34124119bd630er3aa241696', 4, 'subdeptName', 9, '恒生零售交付部', 9, '恒生零售交付部', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34124119bd630er3aa241860', 4, 'subdeptName', 27, '体验与设备交付部', 27, '体验与设备交付部', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34124119bd630er3aa241957', 4, 'subdeptName', 25, '外包服务交付部', 25, '外包服务交付部', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34124119bd630er3aa242038', 4, 'subdeptName', 12, '支付运营交付部', 12, '支付运营交付部', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34124119bd630er3aa242049', 4, 'subdeptName', 28, '人工智能与研究交付部', 28, '人工智能与研究交付部', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34124119bd630er3aa242172', 4, 'subdeptName', 26, '云和人工智能交付部', 26, '云和人工智能交付部', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34124119bd630er3aa242345', 4, 'subdeptName', 0, '全部', 0, 'ALL', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34124119bd630er3aa242474', 4, 'subdeptName', 16, '网银业务交付部', 16, '网银业务交付部', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34124119bd630er3aa243415', 4, 'subdeptName', 24, 'AIA交付部', 24, 'AIA交付部', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34124119bd630er3aa243446', 4, 'subdeptName', 8, '投资银行交付部', 8, '投资银行交付部', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34124119bd630er3aa243791', 4, 'subdeptName', 15, '能力中心', 15, '能力中心', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34124119bd630er3aa243807', 4, 'subdeptName', 18, '测试业务交付部', 18, '测试业务交付部', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34124119bd630er3aa243830', 4, 'subdeptName', 7, '风控业务交付部', 7, '风控业务交付部', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34124119bd630er3aa244304', 4, 'subdeptName', 1, 'HRBP部(HSBC)', 1, 'HRBP部(HSBC)', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34124119bd630er3aa244493', 4, 'subdeptName', 3, '对公网银交付部', 3, '对公网银交付部', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34124119bd630er3aa244603', 4, 'subdeptName', 6, '数据运维交付部', 6, '数据运维交付部', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34124119bd630er3aa244871', 4, 'subdeptName', 2, '贸易融资交付部', 2, '贸易融资交付部', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34124119bd630er3aa245321', 4, 'subdeptName', 20, 'HRBP部(ODC)', 20, 'HRBP部(ODC)', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34124119bd630er3aa245342', 4, 'subdeptName', 4, '对公数字交付部', 4, '对公数字交付部', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34124119bd630er3aa245675', 4, 'subdeptName', 19, '质量管理与运作部(HSBC)', 19, '质量管理与运作部(HSBC)', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34124119bd630er3aa246020', 4, 'subdeptName', 37, '泛金融交付部(香港)', 37, '泛金融交付部(香港)', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34124119bd630er3aa246053', 4, 'subdeptName', 11, '核心系统交付部', 11, '核心系统交付部', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34124119bd630er3aa246605', 4, 'subdeptName', 5, '私人银行交付部', 5, '私人银行交付部', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34124119bd630er3aa246793', 4, 'subdeptName', 31, 'HRBP部(海外)', 31, 'HRBP部(海外)', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34124119bd630er3aa247622', 4, 'subdeptName', 29, '咨询服务交付部', 29, '咨询服务交付部', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34124119bd630er3aa247956', 4, 'subdeptName', 33, '泛金融交付部', 33, '泛金融交付部', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34124119bd630er3aa248189', 4, 'subdeptName', 17, '移动业务交付部', 17, '移动业务交付部', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34124119bd630er3aa248259', 4, 'subdeptName', 35, '汇丰业务交付部(香港)', 35, '汇丰业务交付部(香港)', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34124119bd630er3aa248282', 4, 'subdeptName', 32, '微软业务交付部', 32, '微软业务交付部', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34124119bd630er3aa249020', 4, 'subdeptName', 36, '恒生业务交付部', 36, '恒生业务交付部', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34124119bd630er3aa249378', 4, 'subdeptName', 21, '解决方案交付部', 21, '解决方案交付部', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34124119bd630er3aa249449', 4, 'subdeptName', 14, '财富管理交付部', 14, '财富管理交付部', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34124119bd630er3aa249610', 4, 'subdeptName', 10, '恒生对公交付部', 10, '恒生对公交付部', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34124119bd630er3aa249788', 4, 'subdeptName', 30, '质量管理与运作部(ODC)', 30, '质量管理与运作部(ODC)', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34124119bd630er3aa249827', 4, 'subdeptName', 34, '汇丰业务交付部', 34, '汇丰业务交付部', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('00cfebbe34124119bd630er3aa249847', 4, 'subdeptName', 23, '服务业务交付部', 23, '服务业务交付部', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('C16a494ccd244c719d1a4eef94470269', 17, 'userType', 0, '管理员', 0, '管理员', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('C16a494ccd244c7d9d1a4eef9y470270', 17, 'userType', 6, '招聘部经理', 6, '招聘部经理', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('C16a52e3457645248350de42e5386b88', 17, 'userType', 1, '事业部经理', 1, '事业部经理', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('C16a52e3457645a78350ue42e5386b89', 17, 'userType', 7, '招聘专员', 7, '招聘专员', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('C16f7113e5fa328559549c4dfe74e2d7', 17, 'userType', 2, '事业部助理', 2, '事业部助理', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('C16f7113e5fa48559i69c4dfe134cd15', 17, 'userType', 16, '员工', 16, '员工', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('C16f7113e5fa48559i69c4dfe742cd10', 17, 'userType', 10, '面试官', 10, '面试官', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('C16f7113e5fa48559i69c4dfe742cd15', 17, 'userType', 15, '业务线', 15, '业务线', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('C16f7113e5fa48559i69c4dfe74e2cd8', 17, 'userType', 8, '职能人员', 8, '职能人员', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('C16f7113e5fa48559i69c4dfe74e2cd9', 17, 'userType', 9, 'HRBP', 9, 'HRBP', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('C16f7113e5fa48559i69c4dfe74ecd11', 17, 'userType', 11, '职能部经理', 11, '职能部经理', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('C16f7113e5fa48559i69c4dfe74ecd12', 17, 'userType', 12, '职能部助理', 12, '职能部助理', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('C16f7113e5fa48559i69c4dfe7e2cd13', 17, 'userType', 13, 'HRBP经理', 13, 'HRBP经理', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('C16f7113e5fa48559i69c4dfe7e2cd14', 17, 'userType', 14, 'HRBP助理', 14, 'HRBP助理', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('C16f7113e5fa48759i69c4dfe242cd12', 17, 'userType', 17, '业务群总裁', 17, '业务群总裁', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('C16f7113e5fb48759i61c4dfe242cd11', 17, 'userType', 18, '资源池管理员', 18, '资源池管理员', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('C181837a89a6403c8ffc82c4f366ewb6', 17, 'userType', 3, '交付部经理', 3, '交付部经理', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('C19b9098ac1f4bbc93952125e295dre5', 17, 'userType', 4, '交付部助理', 4, '交付部助理', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('C1be2a7aae81454b924dfa2bt7649824', 17, 'userType', 5, 'RM', 5, 'RM', 0, NULL);

-- delete businessUnit
delete from b_data_dictionary where TYPE_NAME='businessUnit';
-- insert businessUnit
INSERT INTO `b_data_dictionary` VALUES ('84c986d18b3311e989716c0b84a71dde', 22, 'businessUnit', 1, 'HRBP部(HSBC)', 1, 'HRBP部(HSBC)', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('cc67c4d08b3411e989716c0b84a71dde', 22, 'businessUnit', 2, '对公业务事业部', 2, '对公业务事业部', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('d333d14a8b3411e989716c0b84a71dde', 22, 'businessUnit', 3, '风控数据事业部', 3, '风控数据事业部', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('d92a93f78b3411e989716c0b84a71dde', 22, 'businessUnit', 4, '恒生业务事业部', 4, '恒生业务事业部', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('dedd7b1c8b3411e989716c0b84a71dde', 22, 'businessUnit', 5, '零售运营事业部', 5, '零售运营事业部', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('e75c64908b3411e989716c0b84a71dde', 22, 'businessUnit', 6, '能力中心', 6, '能力中心', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('f15e68c58b3411e989716c0b84a71dde', 22, 'businessUnit', 7, '数字移动事业部', 7, '数字移动事业部', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('f76a15c18b3411e989716c0b84a71dde', 22, 'businessUnit', 8, '质量管理与运作部(HSBC)', 8, '质量管理与运作部(HSBC)', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('fe00c5b88b3411e989716c0b84a71dde', 22, 'businessUnit', 9, 'HRBP部(ODC)', 9, 'HRBP部(ODC)', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('046991ff8b3511e989716c0b84a71dde', 22, 'businessUnit', 10, '解决方案事业部(虚拟)', 10, '解决方案事业部(虚拟)', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('0ab1d4b28b3511e989716c0b84a71dde', 22, 'businessUnit', 11, '通用电气事业部', 11, '通用电气事业部', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('11d093948b3511e989716c0b84a71dde', 22, 'businessUnit', 12, '外资客户事业部', 12, '外资客户事业部', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('191b69288b3511e989716c0b84a71dde', 22, 'businessUnit', 13, '微软中国事业部', 13, '微软中国事业部', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('1fbdee4e8b3511e989716c0b84a71dde', 22, 'businessUnit', 14, '质量管理与运作部(ODC)', 14, '质量管理与运作部(ODC)', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('28880fb58b3511e989716c0b84a71dde', 22, 'businessUnit', 15, 'HRBP部(海外)', 15, 'HRBP部(海外)', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('2fe6d2868b3511e989716c0b84a71dde', 22, 'businessUnit', 16, '北美事业部', 16, '北美事业部', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('3915de258b3511e989716c0b84a71dde', 22, 'businessUnit', 17, '东南亚事业部', 17, '东南亚事业部', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('401d25358b3511e989716c0b84a71dde', 22, 'businessUnit', 18, '香港事业部', 18, '香港事业部', 0, NULL);

-- delete businessLine
delete from b_data_dictionary where TYPE_NAME='businessLine';
-- insert businessLine
INSERT INTO `b_data_dictionary` VALUES ('d928f4bc8b4711e989716c0b84a71dde', 23, 'businessLine', 1, 'HRBP管理部', 1, 'HRBP管理部', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('deff85808b4711e989716c0b84a71dde', 23, 'businessLine', 2, 'HSBC业务线', 2, 'HSBC业务线', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('e447fe728b4711e989716c0b84a71dde', 23, 'businessLine', 3, 'ODC业务线', 3, 'ODC业务线', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('fe1b51a18b4711e989716c0b84a71dde', 23, 'businessLine', 4, '海外业务线', 4, '海外业务线', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('0649e7ad8b4811e989716c0b84a71dde', 23, 'businessLine', 5, '销售部', 5, '销售部', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('0cfd130c8b4811e989716c0b84a71dde', 23, 'businessLine', 6, '质量管理与运作部', 6, '质量管理与运作部', 0, NULL);

-- delete yesOrNo
delete from b_data_dictionary where TYPE_NAME='yesOrNo';
-- insert yesOrNo
INSERT INTO `b_data_dictionary` VALUES ('6fb29c22965f11e9b41c6c0b84a71dde', 24, 'yesOrNo', 0, '全部', 0, '全部', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('540880af965211e9b41c6c0b84a71dde', 24, 'yesOrNo', 1, '是', 1, '是', 0, NULL);
INSERT INTO `b_data_dictionary` VALUES ('66a77ed6965211e9b41c6c0b84a71dde', 24, 'yesOrNo', 2, '否', 2, '否', 0, NULL);


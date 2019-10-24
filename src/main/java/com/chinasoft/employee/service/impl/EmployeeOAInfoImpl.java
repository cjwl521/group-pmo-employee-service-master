package com.chinasoft.employee.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.chinasoft.employee.dao.entity.CSDeptDO;
import com.chinasoft.employee.dao.entity.CSDeptDOExample;
import com.chinasoft.employee.dao.entity.CSDeptDOExample.Criteria;
import com.chinasoft.employee.dao.entity.EhrAndEmpIdDO;
import com.chinasoft.employee.dao.entity.EmployeeDO;
import com.chinasoft.employee.dao.entity.UserRoleDO;
import com.chinasoft.employee.dao.entity.UserRoleDOExample;
import com.chinasoft.employee.dao.mapper.CSDeptDOMapper;
import com.chinasoft.employee.dao.mapper.EmployeeDOExpansionMapper;
import com.chinasoft.employee.dao.mapper.EmployeeDOMapper;
import com.chinasoft.employee.dao.mapper.UserRoleDOMapper;
import com.chinasoft.employee.exception.BusinessException;
import com.chinasoft.employee.service.DictionarySevice;
import com.chinasoft.employee.service.EmployeeOAInfoService;
import com.chinasoft.employee.service.model.DictionaryModel;
import com.chinasoft.employee.service.model.EmployeeInfoModel;
import com.chinasoft.employee.util.Constant;
import com.chinasoft.employee.util.DateSyncUtil;
import com.chinasoft.employee.util.UUIDPrimaryKeyUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmployeeOAInfoImpl implements EmployeeOAInfoService{

	// 数据库的用户名与密码，需要根据自己的设置
	@Value("${employee.datasource.url}")
	private String DB_URL;
	@Value("${employee.datasource.driver}")
	private String JDBC_DRIVER;
	@Value("${employee.datasource.username}")
	private String USER;
	@Value("${employee.datasource.password}")
	private String PASS;
	static final String SQL = "SELECT * FROM SYS_USERS";

	@Autowired
	private EmployeeDOExpansionMapper employeeDOExpansionMapper;
	@Autowired
	private CSDeptDOMapper cSDeptDOMapper;
	@Autowired
	private EmployeeDOMapper employeeDOMapper;
	@Autowired
	private UserRoleDOMapper userRoleDOMapper;
	@Autowired
	private DictionarySevice dictionarySevice;
	@Override
	public List<EmployeeInfoModel> readEmployeeInfo() {
		Connection conn = null;
		Statement stmt = null;
		List<EmployeeInfoModel> list = new ArrayList<>();
		try {
			// 注册 JDBC 驱动
			Class.forName(JDBC_DRIVER);

			// 打开链接
			log.info("连接数据库...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			// 执行查询
			log.info(" 实例化Statement对象...");
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
			// 展开结果集数据库
			while (rs.next()) {
				EmployeeInfoModel EployeeInfoModel = new EmployeeInfoModel();
				// 通过字段检索
				EployeeInfoModel.setLOB_NUMBER(rs.getString("LOB_NUMBER"));
				EployeeInfoModel.setEMPLOYEE_NUMBER(rs.getString("EMPLOYEE_NUMBER"));
				EployeeInfoModel.setLAST_NAME(rs.getString("LAST_NAME"));
				EployeeInfoModel.setHIRE_DATE(rs.getDate("HIRE_DATE"));
				EployeeInfoModel.setGP_NAME(rs.getString("GP_NAME"));
				EployeeInfoModel.setLOB_GROUP(rs.getString("LOB_GROUP"));
				EployeeInfoModel.setLOB(rs.getString("LOB"));
				EployeeInfoModel.setBUDU(rs.getString("BUDU"));
				EployeeInfoModel.setDD(rs.getString("DD"));
				EployeeInfoModel.setONWERSHIP_PLACE(rs.getString("ONWERSHIP_PLACE"));
				EployeeInfoModel.setJOB_NAME(rs.getString("JOB_NAME"));
				EployeeInfoModel.setACTUAL_TERMINATION_DATE(rs.getString("ACTUAL_TERMINATION_DATE"));
				list.add(EployeeInfoModel);
			}
			log.info("迁移数据量【{}】", list.size());
			// 完成后关闭
			rs.close();
		} catch (SQLException se) {
			// 处理 JDBC 错误
			se.printStackTrace();
		} catch (Exception e) {
			// 处理 Class.forName 错误
			e.printStackTrace();
		} finally {
			// 关闭资源
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
				log.error(se2.getMessage());
			} // 什么都不做
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				log.error(se.getMessage());
			}
		}
		return list;
	}

	@Override
	@Transactional
	public void upadateEmployeeInfo(List<EmployeeInfoModel> list) throws BusinessException {

		log.info("Start upadate Employee Info in schedule");
		List<EhrAndEmpIdDO> query = employeeDOExpansionMapper.queryEmployeeInfo();

		int item = 0;
		Map<String, List<DictionaryModel>> dictionaryMap = dictionarySevice.getDictionaryMap();
		for (EmployeeInfoModel employeeInfoModel : list) {
			log.info("Start EHR【{}】", employeeInfoModel.getEMPLOYEE_NUMBER());
			EmployeeDO employeeDO = new EmployeeDO();
			String empId = null;
			String deptName = null;
			Integer deptId = null;

			employeeDO.setLob(employeeInfoModel.getLOB_NUMBER());
			employeeDO.seteHr(employeeInfoModel.getEMPLOYEE_NUMBER());
			employeeDO.setStaffName(employeeInfoModel.getLAST_NAME());
			employeeDO.setEntryDate(employeeInfoModel.getHIRE_DATE());
			List<DictionaryModel> dictionary = dictionaryMap.get("staffRegion");
			for (DictionaryModel DictionaryModel : dictionary) {
				if (DictionaryModel.getParamName().equals(employeeInfoModel.getONWERSHIP_PLACE())) {
					employeeDO.setStaffRegion(DictionaryModel.getParamCode());
					break;
				}
			}
			if(!StringUtils.isEmpty(employeeInfoModel.getACTUAL_TERMINATION_DATE())) {
				employeeDO.setResourceStatus(Constant.ResourceStatus.Terminated.getValue());
			}else {
				employeeDO.setResourceStatus(Constant.ResourceStatus.Active.getValue());
			}
			if (!StringUtils.isEmpty(employeeInfoModel.getACTUAL_TERMINATION_DATE())) {
				employeeDO.setTerminationDate(
						DateSyncUtil.parse(employeeInfoModel.getACTUAL_TERMINATION_DATE(), DateSyncUtil.YYYY_MM_DD));
			}
			for (EhrAndEmpIdDO ehrAndEmpIdDO : query) {
				if (employeeInfoModel.getEMPLOYEE_NUMBER().equals(ehrAndEmpIdDO.getEHr())) {
					empId = ehrAndEmpIdDO.getPkId();
					break;
				}
			}
			if (StringUtils.isEmpty(employeeInfoModel.getDD())) {
				if (StringUtils.isEmpty(employeeInfoModel.getBUDU())) {
					if (StringUtils.isEmpty(employeeInfoModel.getLOB())) {
						deptName = employeeInfoModel.getLOB_GROUP();
					} else {
						deptName = employeeInfoModel.getLOB();
					}
				} else {
					deptName = employeeInfoModel.getBUDU();
					if (deptName.equals("质量管理与运作部") || deptName.equals("HRBP部")) {
						String lob = employeeInfoModel.getLOB();
						deptName += "(" + lob.substring(0, lob.length() - 3) + ")";
					}
				}
			} else {
				deptName = employeeInfoModel.getDD();
				if (deptName.equals("泛金融交付部") || deptName.equals("汇丰业务交付部")) {
					if (employeeInfoModel.getBUDU().equals("香港事业部")) {
						deptName = deptName + "（香港）";
					}
				}
			}
			CSDeptDOExample cSDeptDOExample = new CSDeptDOExample();
			Criteria ehr = cSDeptDOExample.createCriteria();
			ehr.andCsDeptNameEqualTo(deptName);
			cSDeptDOExample.setOrderByClause("PARENT_ID");
			List<CSDeptDO> listCs = cSDeptDOMapper.selectByExample(cSDeptDOExample);
			if (null != listCs && listCs.size() > 0) {
				deptId = listCs.get(0).getPkId();
			}
			UserRoleDO userRoleDO = new UserRoleDO();
			employeeDO.setUpdateTime(new Date());
			if (null == empId) {
				// add
				String eId = UUIDPrimaryKeyUtil.generation();
				employeeDO.setPkId(eId);
				employeeDO.setCreateTime(new Date());
				userRoleDO.setPkId(UUIDPrimaryKeyUtil.generation());
				userRoleDO.setDeleted(false);
				userRoleDO.setEmployeeId(eId);
				userRoleDO.setCsdeptId(deptId);
				userRoleDO.setMultipleRoles(false);
				employeeDOMapper.insert(employeeDO);
				userRoleDOMapper.insert(userRoleDO);
				log.info("数据库employeeDO新增：【{}】", ++item);
			} else {
				// update
				employeeDO.setPkId(empId);
				UserRoleDOExample userRoleDOExample = new UserRoleDOExample();
				com.chinasoft.employee.dao.entity.UserRoleDOExample.Criteria ehrUser = userRoleDOExample
						.createCriteria();
				ehrUser.andEmployeeIdEqualTo(empId);
				ehrUser.andMultipleRolesEqualTo(false);
				userRoleDO.setEmployeeId(empId);
				//不update已存在的RM或交付部经理
				UserRoleDOExample example = new UserRoleDOExample();
				com.chinasoft.employee.dao.entity.UserRoleDOExample.Criteria createCriteria = example.createCriteria();
				createCriteria.andEmployeeIdEqualTo(empId);
				createCriteria.andUserTypeNotIn(Arrays.asList(3,5));
				List<UserRoleDO> selectByExample = userRoleDOMapper.selectByExample(example);
				if (selectByExample != null && selectByExample.size() > 0) {
					userRoleDO.setCsdeptId(deptId);
				}
				employeeDOMapper.updateByPrimaryKeySelective(employeeDO);
				userRoleDOMapper.updateByExampleSelective(userRoleDO, userRoleDOExample);
				log.info("数据库employeeDO修改：【{}】", ++item);
			}
		}
	}
}

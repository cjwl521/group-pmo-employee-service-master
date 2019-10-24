package com.chinasoft.employee.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chinasoft.employee.controller.vo.request.AllEmployeeRequestVO;
import com.chinasoft.employee.controller.vo.response.EmployeeAndHsbcDetailResponseVO;
import com.chinasoft.employee.dao.entity.EhrAndEmpIdDO;
import com.chinasoft.employee.dao.entity.EmployeeAndHsbcDO;
import com.chinasoft.employee.dao.entity.EmployeeDO;
import com.chinasoft.employee.dao.entity.EmployeeDOExample;
import com.chinasoft.employee.dao.entity.HsbcEmployeeDO;
import com.chinasoft.employee.dao.entity.HsbcEmployeeDOExample;
import com.chinasoft.employee.dao.entity.HsbcEmployeeDOExample.Criteria;
import com.chinasoft.employee.dao.entity.MsEmployeeDO;
import com.chinasoft.employee.dao.entity.MsEmployeeDOExample;
import com.chinasoft.employee.dao.mapper.EmployeeDOExpansionMapper;
import com.chinasoft.employee.dao.mapper.EmployeeDOMapper;
import com.chinasoft.employee.dao.mapper.HsbcEmployeeDOMapper;
import com.chinasoft.employee.dao.mapper.MsEmployeeCustomerDOMapper;
import com.chinasoft.employee.dao.mapper.MsEmployeeDOMapper;
import com.chinasoft.employee.exception.BusinessException;
import com.chinasoft.employee.exception.EmBusinessError;
import com.chinasoft.employee.service.EmployeeQueryService;
import com.chinasoft.employee.service.EmployeeService;
import com.chinasoft.employee.service.HsbcEmployeeService;
import com.chinasoft.employee.service.MSEmployeeService;
import com.chinasoft.employee.service.UserRoleService;
import com.chinasoft.employee.util.PrdPageInfo;
import com.chinasoft.employee.util.UUIDPrimaryKeyUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDOMapper employeeDoMapper;

	@Autowired
	private HsbcEmployeeService hsbcEmployeeService;
	
	@Autowired
	private MSEmployeeService mSEmployeeService;
	
	@Autowired
	private MsEmployeeDOMapper msEmployeeDOMapper;

	@Autowired
	private UserRoleService userRoleService;

	@Autowired
	private EmployeeDOExpansionMapper employeeDOExpansionMapper;

	@Autowired
	private EmployeeQueryService employeeQueryService;
	
	@Autowired
	private HsbcEmployeeDOMapper hsbcEmployeeDOMapper;
	
	@Autowired
	private MsEmployeeCustomerDOMapper msEmployeeCustomerDOMapper;

	public static String employeeId = null;

	@Override
	@Transactional(rollbackFor = BusinessException.class)
	public int insertEmployee(AllEmployeeRequestVO vo) throws BusinessException {


		/* -----插入b_employee表start------ */
		EmployeeDO record = new EmployeeDO();
		// 接收前端传入数据，并生成自动填入的数据
		Date currentTime = new Date();
		BeanUtils.copyProperties(vo, record);
		employeeId = UUIDPrimaryKeyUtil.generation();
		record.setPkId(employeeId);
		/*
		 * String rmName = vo.getRmName(); String rmUserId =
		 * employeeRelatedDOMapper.selectRmUserId(rmName); if(rmUserId!=null &&
		 * !"".equals(rmUserId)) { record.setRmUserId(rmUserId); }
		 */
		String rmUserId = vo.getRmUserId();
		if (rmUserId.isEmpty()) {
			throw new BusinessException(EmBusinessError.UNKNOW_ERROR, "所属rm不能为空");
		} else {
			record.setRmUserId(rmUserId);
		}

		record.setCreateTime(currentTime);
		record.setUpdateTime(currentTime);
		int employeeResult = employeeDoMapper.insert(record);
		if (employeeResult != 1) {
			throw new BusinessException(EmBusinessError.UNKNOW_ERROR, "插入b_employee表失败");
		} else {
			log.info("成功插入b_employee表");
		}
		/* -----插入b_employee表end------ */

		/* -----插入b_user_employee表start------ */
		int userRoleResult = userRoleService.insertUserAndEmp(vo);
		if (userRoleResult != 1) {
			throw new BusinessException(EmBusinessError.UNKNOW_ERROR, "插入b_user_employee表失败");
		} else {
			log.info("成功插入b_user_employee表");
		}
		/* -----插入b_user_employee表end------ */

		// 判断员工类型为HSBC，将hsbc的信息存入b_hsbc_employee表中 ,2代表hsbc
		if (vo.getEmployeeType() == 3) {
			int resultMS= mSEmployeeService.insertMSEmp(vo);
			if (resultMS < 1) {
				throw new BusinessException(EmBusinessError.UNKNOW_ERROR, "插入b_ms_employee表失败");
			} else {
				log.info("成功插入b_ms_employee表");
			}
		}
		/* -----插入b_user_employee表end------ */

		// 判断员工类型为HSBC，将hsbc的信息存入b_hsbc_employee表中 ,2代表hsbc
		if (vo.getEmployeeType() == 2) {
			int resultHsbc = hsbcEmployeeService.insertEmpHSBC(vo);
			if (resultHsbc != 1) {
				throw new BusinessException(EmBusinessError.UNKNOW_ERROR, "插入b_hsbc_employee表失败");
			} else {
				log.info("成功插入b_hsbc_employee表");
			}
		}
		return 1;
	}

	@Override
	@Transactional(rollbackFor = BusinessException.class)
	public int updateByEmployeeId(AllEmployeeRequestVO vo) throws BusinessException {
		/*-----更新b_employee表start------*/
		EmployeeDO record = new EmployeeDO();

		Date currentTime = new Date();
		BeanUtils.copyProperties(vo, record);
		record.setUpdateTime(new Date());
		String rmUserId = vo.getRmUserId();
		if (rmUserId.isEmpty()) {
			throw new BusinessException(EmBusinessError.UNKNOW_ERROR, "所属rm不能为空");
		} else {
			record.setRmUserId(rmUserId);
		}
		record.setPkId(null);
		record.setUpdateTime(currentTime);
		EmployeeDOExample example = new EmployeeDOExample();
		example.createCriteria().andPkIdEqualTo(vo.getPkId());
		int result = employeeDoMapper.updateByExampleSelective(record, example);
		if (result != 1) {
			throw new BusinessException(EmBusinessError.UNKNOW_ERROR, "更新b_employee表失败");
		} else {
			log.info("成功更新b_employee表");
		}

		/*-----更新b_employee表end------*/

		// 修改基本信息不修改部门及角色
		/*-----更新b_user_role表start------*/

		int userRoleResult = userRoleService.updateUserAndEmp(vo);
		if (userRoleResult != 1) {
			throw new BusinessException(EmBusinessError.UNKNOW_ERROR, "更新b_user_role表失败");
		} else {
			log.info("成功更新b_user_role表");
		}

		//判断员工是否为微软事业部员工，如果是则更新微软员工特有的信息
		if (vo.getEmployeeType() == 3) {
			int resultMS = mSEmployeeService.saveOrupdateMSEmp(vo);
			if (resultMS < 1) {
				throw new BusinessException(EmBusinessError.UNKNOW_ERROR, "更新b_ms_employee表失败");
			} else {
				log.info("成功更新b_ms_employee表");
			}
		}
		
		/*-----更新b_user_role表end------*/

		// 判断员工类型为HSBC，将要更新的hsbc的信息存入b_hsbc_employee表中 ,2代表hsbc
		if (vo.getEmployeeType() == 2) {
			int resultHsbc = hsbcEmployeeService.saveOrupdateEmpHSBC(vo);
			if (resultHsbc != 1) {
				throw new BusinessException(EmBusinessError.UNKNOW_ERROR, "更新b_hsbc_employee表失败");
			} else {
				log.info("成功更新b_hsbc_employee表");
			}
		}
		return 1;

	}

	@Override
	public PrdPageInfo<EmployeeAndHsbcDetailResponseVO> getEmployeeDetails(String userId, Integer userType,
			Integer csdeptId, Integer page, Integer pageSize) throws BusinessException {

		// 加分页功能
		PageHelper.startPage(page, pageSize);
		String staffNameOrEhr = null;
		Integer resourceStatus = null;
		List<EmployeeAndHsbcDO> employeeAndHsbcDOLst = null;
		/** 根据userType判断当前登录角色进行查询, 0 管理员,3 交付部经理,5 RM */
		if (0 == userType) {// 0 管理员.当前登录者为管理员,查询出所有员工
			employeeAndHsbcDOLst = employeeDOExpansionMapper.selectByEmployeeStaffName(staffNameOrEhr, null,
					resourceStatus);
		} else if (3 == userType) {// 3 交付部经理.当前登录者为交付部经理，且csdeptId不为空，则根据csdeptId查询出该部门下所有员工的employeeIdLst
			employeeAndHsbcDOLst = employeeDOExpansionMapper.selectByEmployeeStaffName(staffNameOrEhr, csdeptId,
					resourceStatus);
		} else if (5 == userType) {// 5 RM.当前登录者是RM，且csdeptId不为空,则员工的RM_USER_ID为当前登录RM的userId
			employeeAndHsbcDOLst = employeeDOExpansionMapper.vagueQueryByStaffNameOrEhrAndRmUserId(staffNameOrEhr,
					resourceStatus, null, userId, null, null);
		}
		if (null != employeeAndHsbcDOLst) {
			log.info("getEmployeeDetails 返回数量[{}]", employeeAndHsbcDOLst.size());
		}
		PageInfo<EmployeeAndHsbcDO> pageInfo = new PageInfo<>(employeeAndHsbcDOLst);
		List<EmployeeAndHsbcDetailResponseVO> listResponse = employeeQueryService
				.employeeDBCodeToNameResponseVO(pageInfo.getList(),true);

		PrdPageInfo<EmployeeAndHsbcDetailResponseVO> pgi = new PrdPageInfo<EmployeeAndHsbcDetailResponseVO>();
		pgi.setList(listResponse);
		pgi.setPage(pageInfo.getPageNum());
		pgi.setPages(pageInfo.getPages());
		pgi.setPagesize(pageInfo.getPageSize());
		pgi.setTotal(pageInfo.getTotal());
		return pgi;
	}

	@Override
	public int batchInsertEmployees(List<AllEmployeeRequestVO> vos) throws BusinessException {
		/* -----插入b_user表start------ */
		/* userService.batchInsertUsers(vos); */
		/* -----插入b_user表end------ */

		/* -----插入b_employee表start------ */
		List<EmployeeDO> records = new ArrayList<EmployeeDO>();
		List<AllEmployeeRequestVO> hsbcEmployees = new ArrayList<>();
		for (AllEmployeeRequestVO vo : vos) {
			EmployeeDO record = new EmployeeDO();
			Date currentTime = new Date();
			BeanUtils.copyProperties(vo, record);
			String pkId = UUIDPrimaryKeyUtil.generation();
			record.setPkId(pkId);
			record.setRmUserId(vo.getRmUserId());
			record.setCreateTime(currentTime);
			record.setUpdateTime(currentTime);
			records.add(record);
			vo.setEmployeeId(pkId);
			if (vo.getEmployeeType() == 2) {
				hsbcEmployees.add(vo);
			}
		}
		employeeDoMapper.batchInsert(records);
		/* -----插入b_employee表end------ */

		/* -----插入b_user_employee表start------ */
		userRoleService.batchInsertUsersAndEmployees(vos);
		/* -----插入b_user_employee表end------ */

		// 判断员工类型为HSBC，将hsbc的信息存入b_hsbc_employee表中 ,2代表hsbc
		if (CollectionUtils.isNotEmpty(hsbcEmployees)) {
			hsbcEmployeeService.batchInsertHsbcEmployees(hsbcEmployees);
		}
		return 1;
	}

	@Override
	@Transactional(rollbackFor = BusinessException.class)
	public int batchUpdateEmployees(List<AllEmployeeRequestVO> vos) throws BusinessException {

		List<EhrAndEmpIdDO> allEhr = employeeDOExpansionMapper.queryEmployeeInfo();
		List<AllEmployeeRequestVO> hsbcEmployees = new ArrayList<>();
		List<AllEmployeeRequestVO> csToHsbcEmployees = new ArrayList<>();
		List<AllEmployeeRequestVO> csToMSEmployees = new ArrayList<>();
		List<AllEmployeeRequestVO> msEmployees = new ArrayList<>();
		int ii = 0;
		log.info("employee+++++:" + vos.size() + "条数据");
		for (AllEmployeeRequestVO vo : vos) {
			// 根据前台传过来的eHr获取employeeId
			String eHr = vo.getEHr();
			Boolean flag = false;
			for (EhrAndEmpIdDO ehrAndEmpIdDO : allEhr) {
				if (eHr.equals(ehrAndEmpIdDO.getEHr())) {
					vo.setPkId(ehrAndEmpIdDO.getPkId());
					hsbcEmployees.add(vo);
					flag = true;
					++ii;
					break;
				}
			}
			if (vo.getEmployeeType() == 2) {
				HsbcEmployeeDOExample hsbcEmployeeDOExample = new HsbcEmployeeDOExample();
				Criteria createCriteria = hsbcEmployeeDOExample.createCriteria();
				if (null != vo.getPkId()) {
					createCriteria.andEmployeeIdEqualTo(vo.getPkId());
					List<HsbcEmployeeDO> selectByExample = hsbcEmployeeDOMapper.selectByExample(hsbcEmployeeDOExample);
					if (null != selectByExample && selectByExample.size() > 0) {
						hsbcEmployees.add(vo);
					} else {
						vo.setEmployeeId(vo.getPkId());
						csToHsbcEmployees.add(vo);
					}
				}
			}
			if (vo.getEmployeeType() == 3) {
				MsEmployeeDOExample msEmployeeDOExample = new MsEmployeeDOExample();
				com.chinasoft.employee.dao.entity.MsEmployeeDOExample.Criteria createCriteria = msEmployeeDOExample
						.createCriteria();
				if (null != vo.getPkId()) {
					createCriteria.andEmployeeIdEqualTo(vo.getPkId());
					List<MsEmployeeDO> selectByExample = msEmployeeDOMapper.selectByExample(msEmployeeDOExample);
					if (null != selectByExample && selectByExample.size() > 0) {
						msEmployees.add(vo);
					} else {
						vo.setEmployeeId(vo.getPkId());
						csToMSEmployees.add(vo);
					}
				}
			}
			if (!flag) {
				log.error("该EHR不存在，请先确保在OA系统中录入该员工,EHR【{}】", eHr);
				throw new BusinessException(EmBusinessError.NO_EHR, EmBusinessError.NO_EHR.getErrMsg() + eHr);
			}
			vo.setUpdateTime(new Date());
		}
		log.info("修改employee表+++++:" + ii + "条数据");
		int employeeInt = 0;
		int hsbcEmp = 0;
		try {
			employeeInt = employeeDoMapper.batchUpdateEmployee(vos);
			log.info("修改employee表" + employeeInt + "条数据");

			// 批量更新b_user_employee表
			int userRole = userRoleService.batchUpdateUsersAndEmployees(vos);
			log.info("批量修改b_user_role表" + userRole + "条数据");

			if (CollectionUtils.isNotEmpty(hsbcEmployees)) {
				hsbcEmp = hsbcEmployeeService.batchUpdateHsbcEmployees(hsbcEmployees);
				log.info("修改hsbcEmp表" + hsbcEmp + "条数据");
			}
			
			// 员工类型由中软到汇丰  
			 if (CollectionUtils.isNotEmpty(csToHsbcEmployees)) 
			 { 
				int hsbcToCsEmp = hsbcEmployeeService.batchInsertHsbcEmployees(csToHsbcEmployees);
			     log.info("删除hsbcEmp表" + hsbcToCsEmp + "条数据");
             }
			
			 //员工进入微软事业部
			 if(CollectionUtils.isNotEmpty(csToMSEmployees)) {
				 msEmployeeCustomerDOMapper.batchInsert(csToMSEmployees);
			 }
			 //员工转出微软事业部
			 if(CollectionUtils.isNotEmpty(msEmployees)) {
				 msEmployeeCustomerDOMapper.batchUpdate(msEmployees);
			 }
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new BusinessException(EmBusinessError.EMPLOYEE_UPLOAD);
		}
		if (vos.size() != employeeInt) {
			throw new BusinessException(EmBusinessError.UNKNOW_ERROR, "批量表更新失败");
		}
		return employeeInt;
	}

}

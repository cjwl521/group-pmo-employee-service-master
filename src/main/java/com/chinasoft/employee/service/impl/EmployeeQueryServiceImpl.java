package com.chinasoft.employee.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.chinasoft.employee.controller.vo.request.RMDisplayUserRequestVO;
import com.chinasoft.employee.controller.vo.request.UserRoleRequestVO;
import com.chinasoft.employee.controller.vo.response.CSDeptResponseVO;
import com.chinasoft.employee.controller.vo.response.EmployeeAndHsbcDetailResponseVO;
import com.chinasoft.employee.controller.vo.response.EmployeeAndHsbcResponseVO;
import com.chinasoft.employee.dao.entity.CSDeptDO;
import com.chinasoft.employee.dao.entity.CSDeptDOExample;
import com.chinasoft.employee.dao.entity.CSDeptDOExample.Criteria;
import com.chinasoft.employee.dao.entity.EmployeeAndHsbcDO;
import com.chinasoft.employee.dao.entity.EmployeeDO;
import com.chinasoft.employee.dao.entity.EmployeeDOExample;
import com.chinasoft.employee.dao.entity.UserRoleDO;
import com.chinasoft.employee.dao.entity.UserRoleDOExample;
import com.chinasoft.employee.dao.mapper.CSDeptDOMapper;
import com.chinasoft.employee.dao.mapper.EmployeeDOExpansionMapper;
import com.chinasoft.employee.dao.mapper.EmployeeDOMapper;
import com.chinasoft.employee.dao.mapper.EmployeeRelatedDOMapper;
import com.chinasoft.employee.dao.mapper.UserRoleDOMapper;
import com.chinasoft.employee.exception.BusinessException;
import com.chinasoft.employee.exception.EmBusinessError;
import com.chinasoft.employee.service.CSDeptService;
import com.chinasoft.employee.service.DictionarySevice;
import com.chinasoft.employee.service.EmployeeQueryService;
import com.chinasoft.employee.service.model.DictionaryModel;
import com.chinasoft.employee.service.model.PMOAndEmployeeExportModel;
import com.chinasoft.employee.service.model.RmInfoModel;
import com.chinasoft.employee.util.Constant;
import com.chinasoft.employee.util.DateSyncUtil;
import com.chinasoft.employee.util.PrdPageInfo;
import com.chinasoft.employee.util.StringToListUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmployeeQueryServiceImpl implements EmployeeQueryService {

	@Autowired
	private DictionarySevice dictionarySevice;

	@Autowired
	private EmployeeDOMapper employeeDOMapper;

	@Autowired
	private UserRoleDOMapper userRoleDOMapper;

	@Autowired
	private EmployeeDOExpansionMapper employeeDOExpansionMapper;

	@Autowired
	private EmployeeRelatedDOMapper employeeRelatedDOMapper;

	@Autowired
	private CSDeptDOMapper csDeptDOMapper;

	@Autowired
	CSDeptService csDeptService;

	/** 用户类型为RM */
	private static int userType = 5;
	private static String YES = "是";
	private static String NO = "否";

	@Override
	public PrdPageInfo<EmployeeAndHsbcDetailResponseVO> queryByStaffNameOrEhr(String staffNameOrEhr,
			Integer resourceStatus, Integer filterCsdeptId, Integer pageNum, Integer pageSize, String userId,
			Integer userType, Integer csdeptId) throws BusinessException {
		log.info("EmployeeQueryServiceImpl.queryByStaffNameOrEhr.params[{}]", "staffNameOrEhr:" + staffNameOrEhr + "",
				"resourceStatus:" + resourceStatus + "", "filterCsdeptId:" + filterCsdeptId + "",
				"userId:" + userId + "", "userType:" + userType + "", "csdeptId:" + csdeptId + "");
		UserRoleDOExample userRoleExample = new UserRoleDOExample();
		com.chinasoft.employee.dao.entity.UserRoleDOExample.Criteria userRoleCriteria = userRoleExample
				.createCriteria();
		List<String> employeeIdLst = null;
		List<EmployeeAndHsbcDO> employeeAndHsbcDOLst = null;
		if (null != resourceStatus && resourceStatus == 0) {
			resourceStatus = null;
		}
		if (null != filterCsdeptId && filterCsdeptId == 0) {
			filterCsdeptId = null;
		}
		// 加分页功能
		PageHelper.startPage(pageNum, pageSize);
		// 根据userType判断当前登录角色进行查询, 0 管理员,3 交付部经理,5 RM
		if (0 == userType) {// 0 管理员
			// 当前登录者为管理员,csdeptId为空,则根据条件查询出所有员工
			employeeAndHsbcDOLst = employeeDOExpansionMapper.vagueQueryByStaffNameOrEhrAndRmUserId(staffNameOrEhr,
					resourceStatus, filterCsdeptId, null,null,csdeptId);
		} else if (3 == userType) {// 3 交付部经理
			// 当前登录者为交付部经理，且csdeptId不为空，则根据csdeptId查询出该部门下所有员工的employeeIdLst
			if (null != csdeptId) {
				userRoleCriteria.andCsdeptIdEqualTo(csdeptId);
				// employeeIdLst =
				// userRoleDOMapper.selectEmploueeIdLstByExample(userRoleExample);
			}
			if (null == filterCsdeptId) {
				employeeAndHsbcDOLst = employeeDOExpansionMapper.vagueQueryByStaffNameOrEhrAndEmployeeIdLst(
						staffNameOrEhr, resourceStatus, csdeptId, employeeIdLst);
			} else {
				employeeAndHsbcDOLst = employeeDOExpansionMapper.vagueQueryByStaffNameOrEhrAndEmployeeIdLst(
						staffNameOrEhr, resourceStatus, filterCsdeptId, employeeIdLst);
			}
		} else if (5 == userType) {
			// 当前登录者是RM，且csdeptId不为空
			employeeAndHsbcDOLst = employeeDOExpansionMapper.vagueQueryByStaffNameOrEhrAndRmUserId(staffNameOrEhr,
					resourceStatus, filterCsdeptId, userId,null,csdeptId);
		}
		if (null != employeeAndHsbcDOLst) {
			log.info("employeeAndHsbcDOLst 返回数量[{}]", employeeAndHsbcDOLst.size());
		}
		PageInfo<EmployeeAndHsbcDO> pageInfo = new PageInfo<>(employeeAndHsbcDOLst);
		List<EmployeeAndHsbcDetailResponseVO> listResponse = this.employeeDBCodeToNameResponseVO(pageInfo.getList(),true);
		PrdPageInfo<EmployeeAndHsbcDetailResponseVO> pgi = new PrdPageInfo<EmployeeAndHsbcDetailResponseVO>();
		pgi.setList(listResponse);
		pgi.setPage(pageInfo.getPageNum());
		pgi.setPages(pageInfo.getPages());
		pgi.setPagesize(pageInfo.getPageSize());
		pgi.setTotal(pageInfo.getTotal());
		return pgi;
	}

	@Override
	public PrdPageInfo<EmployeeAndHsbcDetailResponseVO> getOrFilterAllEmployeeByRM(
			RMDisplayUserRequestVO displayUserRequestVO) throws BusinessException {
		log.info("EmployeeQueryServiceImpl.getOrFilterAllEmployeeByRM.request[{}]", displayUserRequestVO.toString());

		Integer page = displayUserRequestVO.getPage();
		Integer pageSize = displayUserRequestVO.getPageSize();

		String userName = displayUserRequestVO.getUserName();
		String userType = displayUserRequestVO.getUserType();
		String csdeptId = displayUserRequestVO.getCsdeptId();
		
		List<Integer> csdeptIdList = StringToListUtil.conversion(csdeptId);
		List<Integer> resourceStatusList = null;

		String staffNameOrIdOrEhrOrLOB = displayUserRequestVO.getStaffNameOrIdOrEhrOrLOB();
		String resourceStatus = displayUserRequestVO.getResourceStatus();
		if (!(StringUtils.isEmpty(resourceStatus) || resourceStatus.contains("0"))) {
			String[] split = resourceStatus.split(",");
			resourceStatusList = new ArrayList<Integer>();
			for (int i = 0; i < split.length; i++) {
				String resouceS = split[i];
				if (!StringUtils.isEmpty(resouceS)) {
					resourceStatusList.add(Integer.valueOf(resouceS));
				}
			}
		}
		Integer filterCsdeptId = displayUserRequestVO.getFilterCsdeptId();
		Integer filterCsblId = displayUserRequestVO.getFilterCsblId();
		Integer filterCsbuId = displayUserRequestVO.getFilterCsbuId();
		String filterRmUserId = displayUserRequestVO.getFilterRmUserId();
		Integer engagementType = displayUserRequestVO.getEngagementType();
		List<EmployeeAndHsbcDO> employeeAndHsbcDOLst = null;
		CSDeptDO csDeptDO = new CSDeptDO();
		List<CSDeptDO> csDeptDOList = new ArrayList<CSDeptDO>();
		String rmUserId = null;
		PrdPageInfo<EmployeeAndHsbcDetailResponseVO> pgi = new PrdPageInfo<EmployeeAndHsbcDetailResponseVO>();

		if (null != filterCsdeptId && filterCsdeptId == 0) {
			filterCsdeptId = null;
		}
		log.info("EmployeeQueryServiceImpl.getOrFilterAllEmployeeByRM.params[{}]",
				"staffNameOrIdOrEhrOrLOB:" + staffNameOrIdOrEhrOrLOB + "", "resourceStatus:" + resourceStatus + "",
				"filterCsdeptId:" + filterCsdeptId + "", "filterCsbuId:" + filterCsbuId + "",
				"filterCsblId:" + filterCsblId + "", "userId:" + userName + "", "userType:" + userType + "",
				"csdeptId:" + csdeptId + "");
		/** 根据userType判断当前登录角色进行查询, 0 管理员,3 交付部经理,5 RM,1 事业部经理，15 业务线 */
		if ("5".equals(userType)) {// 5 RM.当前登录者是RM，且csdeptId不为空,则员工的RM_USER_ID为当前登录RM的userId
			EmployeeDOExample employeeDOExample = new EmployeeDOExample();
			com.chinasoft.employee.dao.entity.EmployeeDOExample.Criteria createCriteriaE = employeeDOExample.createCriteria();
			createCriteriaE.andEHrEqualTo(userName);// 由于登录使用benchpool表，其user_id和b_employee表的user_id目前无法匹配，所以使用E_HR进行查询匹配
			List<EmployeeDO> employeeDOList = employeeDOMapper.selectByExample(employeeDOExample);
			
			UserRoleDOExample userDOExample = new UserRoleDOExample();
			if (employeeDOList.size() > 0) {
				com.chinasoft.employee.dao.entity.UserRoleDOExample.Criteria createCriteria = userDOExample.createCriteria();
				createCriteria.andEmployeeIdEqualTo(employeeDOList.get(0).getPkId());
				createCriteria.andCsdeptIdIn(csdeptIdList);
			}
			List<UserRoleDO> userIdList = userRoleDOMapper.selectByExample(userDOExample);
			if (userIdList.size() > 0) {
				rmUserId = userIdList.get(0).getPkId();
			} else {
				throw new BusinessException(EmBusinessError.USER_NOT_EXIT);
			}
		} 
		
		if (null == filterCsdeptId) {
			if (null != csdeptId && csdeptIdList.size() > 0) {
				for (int i = 0; i < csdeptIdList.size(); i++) {
					Integer csInt = Integer.valueOf(csdeptIdList.get(i));
					if("9".equals(userType)||"13".equals(userType)||"14".equals(userType)) {
						CSDeptDO csdo = csDeptDOMapper.selectByPrimaryKey(csInt);
						if(null!=csdo && null!=csdo.getParentId()) {
							csInt = csdo.getParentId();
						}
					}
					if("19".equals(userType)||"11".equals(userType)||"12".equals(userType)||"8".equals(userType)) {
						 csInt = 10001;
					}
					csDeptDOList.addAll(csDeptService.getAllCSDeptById(csInt));
				}
			}
		} else {
			csDeptDOList = csDeptService.getAllCSDeptById(filterCsdeptId);
		}
		csDeptDOList.add(csDeptDO);
		
		// 加分页功能
		PageHelper.startPage(page, pageSize);
		if (!"16".equals(userType)) {
			employeeAndHsbcDOLst = employeeDOExpansionMapper.vagueQueryByStaffNameOrIdOrEhrOrLOBAndCSDeptDOListAndRmUserId(
					staffNameOrIdOrEhrOrLOB, resourceStatusList, csDeptDOList, rmUserId, filterRmUserId,engagementType);
		}else {
			employeeAndHsbcDOLst = new ArrayList<EmployeeAndHsbcDO>();
		}
		PageInfo<EmployeeAndHsbcDO> pageInfo = new PageInfo<>(employeeAndHsbcDOLst);
		List<EmployeeAndHsbcDetailResponseVO> listResponse = this.employeeDBCodeToNameResponseVO(pageInfo.getList(),true);
		pgi.setList(listResponse);
		pgi.setPage(pageInfo.getPageNum());
		pgi.setPages(pageInfo.getPages());
		pgi.setPagesize(pageInfo.getPageSize());
		pgi.setTotal(pageInfo.getTotal());
		return pgi;
	}

	
	@Override
	public EmployeeAndHsbcResponseVO queryEmployeeDetailByPkId(String pkId,String userId) throws BusinessException {

		EmployeeAndHsbcResponseVO employeeDetail = new EmployeeAndHsbcResponseVO();
		List<EmployeeAndHsbcDO> employeeAndHsbcDO = employeeDOExpansionMapper.queryEmployeeDetailByPkId(pkId, userId);
		if (null == employeeAndHsbcDO || employeeAndHsbcDO.size() < 1) {
			throw new BusinessException(EmBusinessError.USER_NOT_EXIT, "没有查找到该员工");
		}
		BeanUtils.copyProperties(employeeAndHsbcDO.get(0), employeeDetail);
		employeeDetail.setIsPodtl(employeeAndHsbcDO.get(0).getPodtl());
		StringBuilder sb = new StringBuilder();
		Integer deptId = employeeDetail.getCsdeptId();
		CSDeptDOExample csdeptDOExample = new CSDeptDOExample();
		com.chinasoft.employee.dao.entity.CSDeptDOExample.Criteria criteria = csdeptDOExample.createCriteria();
		criteria.andPkIdEqualTo(deptId);
		List<CSDeptDO> csDeptDOLst = csDeptDOMapper.selectByExample(csdeptDOExample);
		if (null != csDeptDOLst && csDeptDOLst.size() == 1) {
			CSDeptDO csDeptDO = csDeptDOLst.get(0);
			Integer perpkId = csDeptDO.getPkId();
			Integer perParentId = csDeptDO.getParentId();
			if (null == perParentId) {
				sb.append(perpkId);
				employeeDetail.setCsdeptAllId(sb.toString());
			} else {
				CSDeptDOExample csdeptDOExample2 = new CSDeptDOExample();
				com.chinasoft.employee.dao.entity.CSDeptDOExample.Criteria secondCriteria = csdeptDOExample2
						.createCriteria();
				secondCriteria.andPkIdEqualTo(perParentId);
				List<CSDeptDO> csDeptDOLst2 = csDeptDOMapper.selectByExample(csdeptDOExample2);
				if (null != csDeptDOLst2 && csDeptDOLst2.size() == 1) {
					CSDeptDO secondcsDeptDO = csDeptDOLst2.get(0);
					Integer secondParentId = secondcsDeptDO.getParentId();
					if (null == secondParentId) {
						sb.append(perParentId);
						sb.append(",");
						sb.append(perpkId);
						employeeDetail.setCsdeptAllId(sb.toString());
					} else {
						sb.append(secondParentId);
						sb.append(",");
						sb.append(perParentId);
						sb.append(",");
						sb.append(perpkId);
						employeeDetail.setCsdeptAllId(sb.toString());
					}
				}
			}
		}
		return employeeDetail;
	}

	@Override
	public EmployeeAndHsbcDetailResponseVO queryEmployeeDetailByPkIdToName(String pkId, String roleId)
			throws BusinessException {

		List<EmployeeAndHsbcDO> employeeDetailLst = employeeDOExpansionMapper.queryEmployeeDetailByPkId(pkId, roleId);

		if (null == employeeDetailLst || employeeDetailLst.size() < 1) {
			throw new BusinessException(EmBusinessError.USER_NOT_EXIT, "没有查找到该员工");
		}
		List<EmployeeAndHsbcDetailResponseVO> listResponse = this.employeeDBCodeToNameResponseVO(employeeDetailLst,
				true);

		return listResponse.get(0);
	}

	@Override
	public List<RmInfoModel> findRMAllInfo() throws BusinessException {
		List<RmInfoModel> rmList = employeeRelatedDOMapper.selectRmAllInfo(userType);
		if (rmList == null) {
			throw new BusinessException(EmBusinessError.UNKNOW_ERROR, "没有查找数据");
		}
		return rmList;
	}

	@Override
	public List<RmInfoModel> findRMAllInfoByLoginUser(UserRoleRequestVO userRoleRequestVO) throws BusinessException {
		List<RmInfoModel> rmList = null;
		List<CSDeptDO> csDeptDOList = new ArrayList<CSDeptDO>();
		String loginuserTypeS = userRoleRequestVO.getUserType();
		if(loginuserTypeS.contains("5")) {
			loginuserTypeS = loadUserType(userRoleRequestVO.getUserType());
		}
		String csdeptIdS = userRoleRequestVO.getCsdeptId();
		String[] csdeptS = csdeptIdS.split(",");
		if (loginuserTypeS.contains("15") ) {
			if (null == csDeptDOList || csdeptS.length < 1) {
				throw new BusinessException(EmBusinessError.UNKNOW_ERROR, "业务线经理的业务线部门不能为空");
			}
		} else if (loginuserTypeS.contains("1") ) {
			if (null == csDeptDOList || csdeptS.length < 1) {
				throw new BusinessException(EmBusinessError.UNKNOW_ERROR, "事业部经理的事业部部门不能为空");
			}
		} else if (loginuserTypeS.contains("3") ) {
			if (null == csDeptDOList || csdeptS.length < 1) {
				throw new BusinessException(EmBusinessError.UNKNOW_ERROR, "交付部经理的交付部部门不能为空");
			}
		} else if (loginuserTypeS.equals("5")) {
			EmployeeDOExample employeeDOExample = new EmployeeDOExample();
			EmployeeDOExample.Criteria criteria = employeeDOExample.createCriteria();
			criteria.andEHrEqualTo(userRoleRequestVO.getEmployeeId());
			List<EmployeeDO> employeeDOList = employeeDOMapper.selectByExample(employeeDOExample);
			if (employeeDOList != null && employeeDOList.size() > 0) {
				EmployeeDO employeeDO = employeeDOList.get(0);
				RmInfoModel rmInfoModel = new RmInfoModel();
				rmInfoModel.setEmployeeId(employeeDO.getPkId());
				rmInfoModel.setStaffName(employeeDO.getStaffName());
				rmInfoModel.setRmUserId(employeeDO.getRmUserId());
				rmList = new ArrayList<RmInfoModel>();
				rmList.add(rmInfoModel);
				return rmList;
			} else {
				throw new BusinessException(EmBusinessError.UNKNOW_ERROR, "没有查找数据");
			}
		}
		if (null != csdeptS && csdeptS.length > 0) {
			for (int i = 0; i < csdeptS.length; i++) {
				Integer csInt = Integer.valueOf(csdeptS[i]);
				List<CSDeptDO> ccsDeptS = csDeptService.getAllCSDeptById(csInt);
				csDeptDOList.addAll(ccsDeptS);
			}
		}
		rmList = employeeRelatedDOMapper.selectRmAllInfoByLoginUser(csDeptDOList, userType);
		if (rmList == null) {
			throw new BusinessException(EmBusinessError.UNKNOW_ERROR, "没有查找数据");
		}
		return rmList;
	}

	private String loadUserType(String userType) {
		String loginType = "";
		if (userType.contains("5") && userType.contains("3")) {
			loginType = "3";
		}else if (userType.contains("5") && userType.contains("1")) {
			loginType = "1";
		}else if (userType.contains("5") && userType.contains("15")) {
			loginType = "15";
		}
		return loginType;
	}
	@Override
	public List<EmployeeAndHsbcDetailResponseVO> employeeDBCodeToNameResponseVO(List<EmployeeAndHsbcDO> employeeDOList, Boolean flag)
			throws BusinessException {

		List<EmployeeAndHsbcDetailResponseVO> listResponse = new ArrayList<EmployeeAndHsbcDetailResponseVO>();
		// 查询数据字典总集合
		Map<Integer, Map<Integer, DictionaryModel>> dictionaryMap = dictionarySevice.getDictionaryMapMapInteger();

		// 查询部门级联关系
		List<CSDeptResponseVO> cSDeptResult = csDeptService.getAllCSDept(null);

		for (EmployeeAndHsbcDO employueeAndHsbcDO : employeeDOList) {
			EmployeeAndHsbcDetailResponseVO rmEmployeeVO = new EmployeeAndHsbcDetailResponseVO();
			BeanUtils.copyProperties(employueeAndHsbcDO, rmEmployeeVO);

			// 填写上级领导，如果没有rm 就填写交付部经理
			String rmUserId = employueeAndHsbcDO.getRmUserId();
			if (!StringUtils.isEmpty(rmUserId)) {
//				UserRoleDOExample userRoleDOExample = new UserRoleDOExample();
//				com.chinasoft.employee.dao.entity.UserRoleDOExample.Criteria criteria = userRoleDOExample
//						.createCriteria();
//				criteria.andUserTypeEqualTo(3);// employueeAndHsbcDO.getUserType());
//				if (employueeAndHsbcDO.getCsdeptId() != null) {
//					criteria.andCsdeptIdEqualTo(employueeAndHsbcDO.getCsdeptId());
//					List<UserRoleDO> userRoleDOLst = userRoleDOMapper.selectByExample(userRoleDOExample);
//					if (userRoleDOLst.size() != 0) {
//						String employeeId = userRoleDOLst.get(0).getEmployeeId();
//						EmployeeDO employeeDO = employeeDOMapper.selectByPrimaryKey(employeeId);
//						if (null != employeeDO) {
//							rmEmployeeVO.setRmName(employeeDO.getStaffName());
//						}
//					}
//				}
//
//			} else {
				UserRoleDOExample userDOExample = new UserRoleDOExample();
				com.chinasoft.employee.dao.entity.UserRoleDOExample.Criteria createCriteria = userDOExample
						.createCriteria();
				createCriteria.andPkIdEqualTo(rmUserId);
				List<UserRoleDO> selectByExample = userRoleDOMapper.selectByExample(userDOExample);
				if (null != selectByExample && selectByExample.size() > 0) {
					EmployeeDO employeeDO = employeeDOMapper.selectByPrimaryKey(selectByExample.get(0).getEmployeeId());
					rmEmployeeVO.setRmName(employeeDO.getStaffName());
				}
			}

			/** 员工所属地区（西安、广州、上海、深圳、香港、印度、马来西亚等）staffRegion */
			if (null != employueeAndHsbcDO.getStaffRegion()) {
				rmEmployeeVO.setStaffRegion(dictionaryMap.get(Constant.DataDictionary.STAFF_REGION.getValue())
						.get(employueeAndHsbcDO.getStaffRegion()).getParamName());
			}
			/** 员工所属国家（中国、马来西亚、香港、印度等）staffLocation */
			if (null != employueeAndHsbcDO.getStaffLocation()) {
				rmEmployeeVO.setStaffLocation(dictionaryMap.get(Constant.DataDictionary.STAFF_LOCATION.getValue())
						.get(employueeAndHsbcDO.getStaffLocation()).getParamName());
			}
			/** 等级role */
			if (null != employueeAndHsbcDO.getRole()) {
				rmEmployeeVO.setRole(dictionaryMap.get(Constant.DataDictionary.ROLE_CODE.getValue())
						.get(employueeAndHsbcDO.getRole()).getParamName());
			}
			/** 所属部门csdeptId */
			if (null != employueeAndHsbcDO.getCsdeptId()) {
				
				rmEmployeeVO.setCs_dept(employueeAndHsbcDO.getCsdeptId());
				DictionaryModel dictionaryModel = dictionaryMap
						.get(Constant.DataDictionary.SUBDEPT_TYPE_CODE.getValue())
						.get(employueeAndHsbcDO.getCsdeptId());
				if (null != dictionaryModel) {
					String csdeptName = dictionaryModel.getParamName();
					if (flag) {
						rmEmployeeVO.setCsdeptId(csdeptName);
					} else {
						if (dictionaryModel.getParamCode() < 100) {
							rmEmployeeVO.setCsdeptId(csdeptName);
						}
					}
				} else {
					boolean isRoot = false;
					for (CSDeptResponseVO csVO : cSDeptResult) {
						if (csVO.getValue().equals(employueeAndHsbcDO.getCsdeptId())) {
							if (flag) {
								rmEmployeeVO.setCsdeptId(csVO.getLabel());
							} else {
								if (csVO.getValue() < 100) {
									rmEmployeeVO.setCsdeptId(csVO.getLabel());
								}
							}
							isRoot = true;
							break;
						}
						if (!isRoot) {
							List<CSDeptResponseVO> csDeptResponseVOLst = csVO.getChildren();
							for (CSDeptResponseVO perVO : csDeptResponseVOLst) {
								if (employueeAndHsbcDO.getCsdeptId().equals(perVO.getValue())) {
									if (flag) {
										rmEmployeeVO.setCsdeptId(perVO.getLabel());
									} else {
										if (perVO.getValue() < 100) {
											rmEmployeeVO.setCsdeptId(perVO.getLabel());
										}
									}
									break;
								}
							}
						}
					}
				}
				Integer csdeptId = employueeAndHsbcDO.getCsdeptId();
				CSDeptDOExample csdeptDOExample = new CSDeptDOExample();
				Criteria criteria = csdeptDOExample.createCriteria();
				criteria.andPkIdEqualTo(csdeptId);
				List<CSDeptDO> csDeptDOLst = csDeptDOMapper.selectByExample(csdeptDOExample);
				
				if (csDeptDOLst.size() != 0 && csDeptDOLst != null) {
					CSDeptDO csDeptDO = csDeptDOLst.get(0);
					if (null != csdeptId) {
						if (flag) {
							rmEmployeeVO.setCsdeptId(csDeptDO.getCsDeptName());
						} else {
							if (csdeptId < 100) {
								rmEmployeeVO.setCsdeptId(csDeptDO.getCsDeptName());
							}
						}
					}
					if (null != csDeptDO.getParentId()) {
						Integer perentId = csDeptDO.getParentId();
						CSDeptDOExample csdeptDOExample1 = new CSDeptDOExample();
						Criteria criteria1 = csdeptDOExample1.createCriteria();
						if (perentId < 1000) {
							rmEmployeeVO.setCsbu(dictionaryMap
									.get(Constant.DataDictionary.BUSINESS_UNIT_TYPE_CODE.getValue())
									.get(perentId).getParamName());
							criteria1.andPkIdEqualTo(perentId);
							List<CSDeptDO> csDeptDOLst1 = csDeptDOMapper.selectByExample(csdeptDOExample1);
							if (csDeptDOLst1.size() != 0 && csDeptDOLst1 != null) {
								CSDeptDO csDeptDO1 = csDeptDOLst1.get(0);
								if (csDeptDO1.getParentId() != null) {
									Integer senParentId = csDeptDO1.getParentId();
									rmEmployeeVO.setCsbl(dictionaryMap
											.get(Constant.DataDictionary.BUSINESS_LINE_TYPE_CODE.getValue())
											.get(senParentId).getParamName());
								}
							} 
						} else if (perentId > 1000 && csdeptId < 10000) {
							if(csdeptId<1000) {
								rmEmployeeVO.setCsbu(
										dictionaryMap.get(Constant.DataDictionary.BUSINESS_UNIT_TYPE_CODE.getValue())
												.get(csdeptId).getParamName());
								rmEmployeeVO.setCsbl(
										dictionaryMap.get(Constant.DataDictionary.BUSINESS_LINE_TYPE_CODE.getValue())
												.get(perentId).getParamName());
							}else if(csdeptId>1000 && csdeptId<10000) {
								rmEmployeeVO.setCsbl(
										dictionaryMap.get(Constant.DataDictionary.BUSINESS_LINE_TYPE_CODE.getValue())
												.get(csdeptId).getParamName());
							}
						}
					} 
					rmEmployeeVO.setCsbg(dictionaryMap.get(Constant.DataDictionary.BUSINESS_GROUP_TYPE_CODE.getValue())
										.get(10001).getParamName());
					
				}
			}
			/** 技能skill */
			if (null != employueeAndHsbcDO.getSkill()) {
				rmEmployeeVO.setSkill(dictionaryMap.get(Constant.DataDictionary.SKILL_TYPE_CODE.getValue())
						.get(employueeAndHsbcDO.getSkill()).getParamName());
			}
			/** 合同类型 engagementType */
			if (null != employueeAndHsbcDO.getEngagementType()) {
				rmEmployeeVO.setEngagementType(dictionaryMap.get(Constant.DataDictionary.ENGAGEMENT_TYPE.getValue())
						.get(employueeAndHsbcDO.getEngagementType()).getParamName());
			}
			/** 单价类型：小时、天、月billRateType */
			if (null != employueeAndHsbcDO.getBillRateType()) {
				if(null != dictionaryMap.get(Constant.DataDictionary.BILL_RATE_TYPE.getValue())
						.get(employueeAndHsbcDO.getBillRateType())){
					rmEmployeeVO.setBillRateType(dictionaryMap.get(Constant.DataDictionary.BILL_RATE_TYPE.getValue())
							.get(employueeAndHsbcDO.getBillRateType()).getParamName());
				}
			}
			/** 币种 billCurrency */
			if (null != employueeAndHsbcDO.getBillCurrency()) {
				if(null != dictionaryMap.get(Constant.DataDictionary.BILL_CURRENCY.getValue())
						.get(employueeAndHsbcDO.getBillCurrency())) {
					rmEmployeeVO.setBillCurrency(dictionaryMap.get(Constant.DataDictionary.BILL_CURRENCY.getValue())
							.get(employueeAndHsbcDO.getBillCurrency()).getParamName());
				}
			}
			/** 员工类型:employeeType--Chinasoft/HSBC/Microsoft */
			if (null != employueeAndHsbcDO.getEmployeeType()) {
				if(null != dictionaryMap.get(Constant.DataDictionary.EMPLOYEE_TYPE.getValue())
						.get(employueeAndHsbcDO.getEmployeeType())) {
					rmEmployeeVO.setEmployeeType(dictionaryMap.get(Constant.DataDictionary.EMPLOYEE_TYPE.getValue())
							.get(employueeAndHsbcDO.getEmployeeType()).getParamName());
				}
			}
			/** 员工状态resourceStatus */
			if (null != employueeAndHsbcDO.getResourceStatus()) {
				if (null != dictionaryMap.get(Constant.DataDictionary.RESOURCE_STATUS_TYEP_CODE.getValue())
						.get(employueeAndHsbcDO.getResourceStatus())) {
					rmEmployeeVO.setResourceStatus(dictionaryMap.get(Constant.DataDictionary.RESOURCE_STATUS_TYEP_CODE.getValue())
									.get(employueeAndHsbcDO.getResourceStatus()).getParamName());
				}
			}
			/** 员工职位.员工/RM/技术部经理/管理员 */
			if (null != employueeAndHsbcDO.getUserType()) {
				if(null != dictionaryMap.get(Constant.DataDictionary.USER_TYPE.getValue()).get(employueeAndHsbcDO.getUserType())){
					rmEmployeeVO.setUserType(dictionaryMap.get(Constant.DataDictionary.USER_TYPE.getValue())
							.get(employueeAndHsbcDO.getUserType()).getParamName());
				}
			}
			/** 在岸人员或者离岸人员 onshoreOrOffshore */
			if (null != employueeAndHsbcDO.getOnshoreOrOffshore()) {
				if(null != dictionaryMap.get(Constant.DataDictionary.ONSHORE_OR_OFFSHORE.getValue())
								.get(employueeAndHsbcDO.getOnshoreOrOffshore())){
					rmEmployeeVO.setOnshoreOrOffshore(dictionaryMap.get(Constant.DataDictionary.ONSHORE_OR_OFFSHORE.getValue())
							.get(employueeAndHsbcDO.getOnshoreOrOffshore()).getParamName());
				}
			}
			/** 办公场所类型（汇丰场内或者离岸办公场所）locationType */
			if (null != employueeAndHsbcDO.getLocationType()) {
				rmEmployeeVO.setLocationType(dictionaryMap.get(Constant.DataDictionary.LOCATION_TYPE.getValue())
						.get(employueeAndHsbcDO.getLocationType()).getParamName());
			}
			/** HSBC项目组领导 */
			if (null != employueeAndHsbcDO.getTlType()) {
				rmEmployeeVO.setTlType(dictionaryMap.get(Constant.DataDictionary.HSBC_TEAM_LEADER.getValue())
						.get(employueeAndHsbcDO.getTlType()).getParamName());
			}
			/** HSBC一级部门 */
			if (null != employueeAndHsbcDO.getGbGf()) {
				if(dictionaryMap.get(Constant.DataDictionary.HSBC_DEPT.getValue())
						.get(employueeAndHsbcDO.getGbGf())!=null) {
					rmEmployeeVO.setGbGf(dictionaryMap.get(Constant.DataDictionary.HSBC_DEPT.getValue())
							.get(employueeAndHsbcDO.getGbGf()).getParamName());
				}
			}
			/** HSBC二级部门 */
			if (null != employueeAndHsbcDO.getHsbcSubdeptId()) {
				if(dictionaryMap.get(Constant.DataDictionary.HSBC_DEPT.getValue())
						.get(employueeAndHsbcDO.getHsbcSubdeptId())!=null) {
					rmEmployeeVO.setHsbcSubdeptId(dictionaryMap.get(Constant.DataDictionary.HSBC_DEPT.getValue())
							.get(employueeAndHsbcDO.getHsbcSubdeptId()).getParamName());
				}
			}
			/** HSBC三级部门 */
			if (null != employueeAndHsbcDO.getHsbcThridDeptId()) {
				if(dictionaryMap.get(Constant.DataDictionary.HSBC_DEPT.getValue())
						.get(employueeAndHsbcDO.getHsbcThridDeptId())!=null) {
					rmEmployeeVO.setHsbcThridDeptId(dictionaryMap.get(Constant.DataDictionary.HSBC_DEPT.getValue())
							.get(employueeAndHsbcDO.getHsbcThridDeptId()).getParamName());
				}
			}

			/** msaRole */
			if (null != employueeAndHsbcDO.getMsaRole()) {
				rmEmployeeVO.setMsaRole(dictionaryMap.get(Constant.DataDictionary.MSA_ROLE_CODE.getValue())
						.get(employueeAndHsbcDO.getMsaRole()).getParamName());
			}
			/** userId */
			if (null != employueeAndHsbcDO.getRoleId()) {
				rmEmployeeVO.setUserId(employueeAndHsbcDO.getRoleId());			
			}
			
			/** msLevel */
			if (null != employueeAndHsbcDO.getMsLevel() && 3 == employueeAndHsbcDO.getEmployeeType()) {
				rmEmployeeVO.setMsLevel(dictionaryMap.get(Constant.DataDictionary.MS_LEVEL.getValue())
						.get(employueeAndHsbcDO.getMsLevel()).getParamName());
			}
			
			listResponse.add(rmEmployeeVO);
		}
		return listResponse;
	}

	@Override
	public List<PMOAndEmployeeExportModel> employeeDBDateConversion(
			List<EmployeeAndHsbcDetailResponseVO> employeeResponseVO) throws BusinessException {
		List<PMOAndEmployeeExportModel> listResponseVO = new ArrayList<PMOAndEmployeeExportModel>();
		for (EmployeeAndHsbcDetailResponseVO employeeResponse : employeeResponseVO) {
			PMOAndEmployeeExportModel pmoEmployeeVO = new PMOAndEmployeeExportModel();
			BeanUtils.copyProperties(employeeResponse, pmoEmployeeVO);

			// 日期格式转换
			if (null != employeeResponse.getGraduationDate()) {
				pmoEmployeeVO.setGraduationDate(
						DateSyncUtil.format(employeeResponse.getGraduationDate(), DateSyncUtil.YYYY_MM_DD));
			}
			if (null != employeeResponse.getTerminationDate()) {
				pmoEmployeeVO.setTerminationDate(
						DateSyncUtil.format(employeeResponse.getTerminationDate(), DateSyncUtil.YYYY_MM_DD));
			}
			if (null != employeeResponse.getEntryDate()) {
				pmoEmployeeVO
						.setEntryDate(DateSyncUtil.format(employeeResponse.getEntryDate(), DateSyncUtil.YYYY_MM_DD));
			}
			if (null != employeeResponse.getCsiProStartdate()) {
				pmoEmployeeVO.setCsiProStartdate(
						DateSyncUtil.format(employeeResponse.getCsiProStartdate(), DateSyncUtil.YYYY_MM_DD));
			}
			if (null != employeeResponse.getSowExpiredDate()) {
				pmoEmployeeVO.setSowExpiredDate(
						DateSyncUtil.format(employeeResponse.getSowExpiredDate(), DateSyncUtil.YYYY_MM_DD));
			}
			if (null != employeeResponse.getHsbcDoj()) {
				pmoEmployeeVO.setHsbcDoj(DateSyncUtil.format(employeeResponse.getHsbcDoj(), DateSyncUtil.YYYY_MM_DD));
			}
			if (null != employeeResponse.getPodtl()) {
				if (employeeResponse.getPodtl()) {
					pmoEmployeeVO.setPodtl(YES);
				} else {
					pmoEmployeeVO.setPodtl(NO);
				}
			}
			listResponseVO.add(pmoEmployeeVO);
		}
		return listResponseVO;
	}
	
}

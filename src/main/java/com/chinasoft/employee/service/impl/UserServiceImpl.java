package com.chinasoft.employee.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.chinasoft.employee.controller.vo.request.AllEmployeeRequestVO;
import com.chinasoft.employee.controller.vo.request.UserRequestVO;
import com.chinasoft.employee.dao.entity.EmployeeAndUserRoleDO;
import com.chinasoft.employee.dao.entity.UserDO;
import com.chinasoft.employee.dao.mapper.EmployeeDOExpansionMapper;
import com.chinasoft.employee.dao.mapper.UserDOMapper;
import com.chinasoft.employee.exception.BusinessException;
import com.chinasoft.employee.exception.EmBusinessError;
import com.chinasoft.employee.service.UserService;
import com.chinasoft.employee.service.model.UserModel;
import com.chinasoft.employee.util.UUIDPrimaryKeyUtil;

import lombok.extern.slf4j.Slf4j;
import sun.misc.BASE64Decoder;

@SuppressWarnings("restriction")
@Service
@Slf4j
public class UserServiceImpl implements UserService {

	@Value("${employee.login.url}")
	private String URL;
	
	@Value("${employee.verify.flag}")
	private Boolean FLAG;
	
	@Value("${employee.admin.password}")
	private  String PASSWORD;
	
	@Autowired
	UserDOMapper userDOMapper;
	public static String userId = null;
	
	private static final String DEFAULT_PASSWORD = "123";

	private static final String VERIFY_DATA = "/page";
	private static final String ADMIN = "admin";
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private EmployeeDOExpansionMapper employeeDOExpansionMapper;
	@Override
	public int insertUser(AllEmployeeRequestVO vo) throws BusinessException {
		UserDO record = new UserDO();
		Date currentTime = new Date();
		BeanUtils.copyProperties(vo, record);
		userId = UUIDPrimaryKeyUtil.generation();
		record.setPkId(userId);
		record.setUserName(vo.getEHr());
		record.setPassword(DEFAULT_PASSWORD);
		record.setNickname(vo.getStaffName());
		record.setCreateTime(currentTime);
		record.setUpdateTime(currentTime);
		/* record.setSalt(salt); */
		int result = userDOMapper.insert(record);
		return result;
	}

	@Override
	public int updateUser(AllEmployeeRequestVO vo) throws BusinessException {
		UserDO record = new UserDO();
		Date currentTime = new Date();
		BeanUtils.copyProperties(vo, record);
		record.setUpdateTime(currentTime);
		//record.setPkId(vo.getUserId());
		if (vo.getEHr() != null && !"".equals(vo.getEHr())) {
			record.setUserName(vo.getEHr());
		}
		if (vo.getStaffName() != null && !"".equals(vo.getStaffName())) {
			record.setNickname(vo.getStaffName());
		}
		int result = userDOMapper.updateByPrimaryKeySelective(record);
		return result;
	}

	@Override
	public int updatePwd(UserRequestVO vo) throws BusinessException {
		String userId = vo.getPkId();
		String password = vo.getPassword();
		String newPassword = vo.getNewPassword();
		String confirmPassword = vo.getConfirmPassword();
		UserDO user = userDOMapper.selectByPrimaryKey(userId);
		if (!password.equals(user.getPassword())) {
			throw new BusinessException(EmBusinessError.USER_NOT_EXIT, "原密码输入错误");
		}
		if (!newPassword.equals(confirmPassword)) {
			throw new BusinessException(EmBusinessError.USER_NOT_EXIT, "确认密码与新密码不一致");
		}
		Date currentTime = new Date();
		user.setUpdateTime(currentTime);
		user.setPassword(confirmPassword);
		int result = userDOMapper.updateByPrimaryKey(user);
		return result;
	}

	@Override
	public int batchInsertUsers(List<AllEmployeeRequestVO> vos) throws BusinessException {
		List<UserDO> users = new ArrayList<UserDO>();
		for (AllEmployeeRequestVO vo : vos) {
			UserDO record = new UserDO();
			Date currentTime = new Date();
			BeanUtils.copyProperties(vo, record);
			String pkId = UUIDPrimaryKeyUtil.generation();
			record.setPkId(pkId);
			record.setUserName(vo.getEHr());
			record.setPassword(DEFAULT_PASSWORD);
			record.setNickname(vo.getStaffName());
			record.setCreateTime(currentTime);
			record.setUpdateTime(currentTime);
			//vo.setUserId(pkId);
			users.add(record);
		}
		int result = userDOMapper.batchInsert(users);
		return result;
	}

	@Override
	public Set<UserModel> userLogin(String lob, String passWord) throws BusinessException {
		log.info("UserServiceImpl.userLogin.start");
		Set<UserModel> userModelList = new  HashSet<UserModel>();
		if (!ADMIN.equals(lob)) {
			HttpEntity<MultiValueMap<String, String>> httpEntity = loginInit(lob, passWord);
			ResponseEntity<String> responseEntity = restTemplate.exchange(URL, HttpMethod.POST, httpEntity,
					String.class);
			Boolean status = responseEntity.getHeaders().getLocation().getPath().contains(VERIFY_DATA);

			if (status || FLAG) {
				int suLen = 10 - lob.length();
				String SU = "";
				for (int i = 0; i < suLen; i++) {
					SU += "0";
				}
				List<EmployeeAndUserRoleDO> doE = employeeDOExpansionMapper.queryLoginInfoBylob(SU + lob);
				if (null != doE && doE.size() > 0) {
					for(EmployeeAndUserRoleDO employeeAndUserRoleDO :doE) {
						UserModel userModel = new UserModel();
						BeanUtils.copyProperties(employeeAndUserRoleDO, userModel);
						userModelList.add(userModel);
					}
					log.info("UserServiceImpl.userLogin.end:" + doE.get(0).getEHr());
				}
			} else {
				log.info("UserServiceImpl.userLogin.end:" + "OA系统登录异常！");
				throw new BusinessException(EmBusinessError.OA_LOGIN_ERROR, "OA系统登录异常！");
			}
		} else {
			String decodePassword = "";
			try {
				 decodePassword = new String((new BASE64Decoder()).decodeBuffer(PASSWORD),"UTF-8");
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (passWord.equals(decodePassword)) {
				List<EmployeeAndUserRoleDO> doE = employeeDOExpansionMapper.queryLoginInfoBylob(ADMIN);
				if (null != doE && doE.size() > 0) {
					for(EmployeeAndUserRoleDO employeeAndUserRoleDO :doE) {
						UserModel userModel = new UserModel();
						BeanUtils.copyProperties(employeeAndUserRoleDO, userModel);
						userModelList.add(userModel);
					}
					log.info("UserServiceImpl.userLogin.end:" + doE.get(0).getEHr());
				}
			} else {
				log.info("UserServiceImpl.userLogin.end:" + "用户名密码错误!");
				throw new BusinessException(EmBusinessError.USER_PASSWORD_ERROR, "用户名密码错误!");
			}
		}
		return userModelList;
	}
	
	private HttpEntity<MultiValueMap<String, String>> loginInit(String userName, String passWord) {
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		map.add("userid", userName);
		map.add("linkpage", "");
		map.add("userName", userName);
		map.add("j_username", userName);
		map.add("password", passWord);
		map.add("j_password", passWord);
		HttpHeaders header = new HttpHeaders();
		// 需求需要传参为form-data格式
		header.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(map, header);
		return httpEntity;
	}
	
	@Override
	public int batchUpdateUser(List<AllEmployeeRequestVO> vos) throws BusinessException {
		
		Integer userInt = userDOMapper.batchUpdateUser(vos);
		
		return userInt;
	}
}

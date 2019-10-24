package com.chinasoft.employee.controller;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.util.StringUtils;
import com.chinasoft.employee.controller.vo.request.LoginRequestVO;
import com.chinasoft.employee.controller.vo.response.LoginResponseVO;
import com.chinasoft.employee.exception.BusinessException;
import com.chinasoft.employee.response.BaseResponse;
import com.chinasoft.employee.service.UserService;
import com.chinasoft.employee.service.model.UserModel;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
/**
 *  登录接口
 * @author wang
 *
 */
@RestController
@Slf4j
@RequestMapping(value = "/user")
@Api(value = "Login --- 接口信息")
public class LogInController {
    
    @Autowired
    private UserService userService;

    @ResponseBody
    @PostMapping("/login")
    @ApiOperation(value = "用户登录", notes = "查询用户登录的账户密码是否正确")
	public BaseResponse userLogin(@RequestBody @Valid LoginRequestVO request) throws BusinessException {
		log.info("LogInController.userLogin.Request[{}]", request.getLob());
		String userType = "";
		String csdeptId = "";
		Set<UserModel> serviceResponse = userService.userLogin(request.getLob(), request.getPassword());
		
		log.info("LogInController.userLogin.Response[{}]", serviceResponse.toString());
		LoginResponseVO loginResponseVO = new LoginResponseVO();
		
		if (null != serviceResponse && serviceResponse.size() > 0) {
			
			for (UserModel UserModel : serviceResponse) {
				userType += UserModel.getUserType() + ",";
				csdeptId += UserModel.getCsdeptId() + ",";
				loginResponseVO.setUserName(UserModel.getStaffName());
				loginResponseVO.setEHr(UserModel.getEHr());
				loginResponseVO.setEmail(UserModel.getEmail());
			}
			if (!StringUtils.isEmpty(userType)) {
				loginResponseVO.setUserType(userType.substring(0, userType.length() - 1));
			}
			if (!StringUtils.isEmpty(csdeptId)) {
				loginResponseVO.setDeptId(csdeptId.substring(0, csdeptId.length() - 1));
			}
		}
		log.info("LogInController.userLogin.Response[{}]", loginResponseVO.toString());
		return BaseResponse.getInstence().createBySuccessMessage(loginResponseVO);
	}

}

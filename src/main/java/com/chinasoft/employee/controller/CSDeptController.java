package com.chinasoft.employee.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chinasoft.employee.controller.vo.request.UserRoleRequestVO;
import com.chinasoft.employee.exception.BusinessException;
import com.chinasoft.employee.response.BaseResponse;
import com.chinasoft.employee.service.CSDeptService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "cSDept")
@Api(value = "部门相关操作")

public class CSDeptController {
	
	@Autowired
	private CSDeptService cSDeptService;
	
	@ResponseBody
	@GetMapping("/allDept")
	@ApiOperation(value = "获取级联部门")
	
	public BaseResponse getAllDept() throws BusinessException{
		
		return BaseResponse.getInstence().createBySuccessMessage(cSDeptService.getAllCSDept(null));
		
	}

	@ResponseBody
	@GetMapping("/allDeptByLoginUser")
	@ApiOperation(value = "根据登录用户类型及部门获取所属级联部门")

	public BaseResponse getAllDeptByLoginUser(@Valid UserRoleRequestVO userRoleRequestVO) throws BusinessException{

		return BaseResponse.getInstence().createBySuccessMessage(cSDeptService.getAllDeptByLoginUser(userRoleRequestVO));

	}
	
	@ResponseBody
	@GetMapping("/hsbcDept")
	@ApiOperation(value = "汇丰线相应的1/2/3级部门信息")
	
	public BaseResponse getHsbcDept() throws BusinessException{
		
		return BaseResponse.getInstence().createBySuccessMessage(cSDeptService.getHsbcDept());
	}
	@ResponseBody
	@GetMapping("/hsbcDeptDiff")
	@ApiOperation(value = "汇丰线相应的1/2/3级部门信息")
	
	public BaseResponse getDeptDiff() throws BusinessException{
		
		return BaseResponse.getInstence().createBySuccessMessage(cSDeptService.getHsbcDeptDiff());
	}

}

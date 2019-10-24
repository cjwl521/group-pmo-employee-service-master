package com.chinasoft.employee.controller;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chinasoft.employee.controller.vo.request.UserDeptAndTypeRequestVO;
import com.chinasoft.employee.controller.vo.request.UserRequestVO;
import com.chinasoft.employee.controller.vo.request.UserRoleRequestVO;
import com.chinasoft.employee.exception.BusinessException;
import com.chinasoft.employee.exception.EmBusinessError;
import com.chinasoft.employee.response.BaseResponse;
import com.chinasoft.employee.service.UserRoleService;
import com.chinasoft.employee.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value ="user")
@Slf4j
@Api(value= "用户的相关操作")
public class UserController {
	
	@Autowired
	UserService userService;
	@Autowired
	UserRoleService userRoleService;
	
	/**
	 * 修改口令
	 * @return
	 * @throws BusinessException
	 */
	@ResponseBody
	@PutMapping("/pwd")
	@ApiOperation(value = "修改口令")
	public BaseResponse changePwd(@RequestBody UserRequestVO vo) throws BusinessException{
        if(vo == null || vo.getPassword() == null) {
        	throw new BusinessException(EmBusinessError.UNKNOW_ERROR,"原密码不能为空");
        }
		log.info("UserController.changePwd.Request[{}]",vo.toString());
		int result = userService.updatePwd(vo);
		if(result == 1) {
			return BaseResponse.getInstence().createBySuccessMessage("口令修改成功");
		}else {
			return BaseResponse.getInstence().createBySuccessMessage("口令修改失败");
		}
		
	}
	/**
	 * 新增人员角色
	 * @return
	 * @throws BusinessException
	 */
	@ResponseBody
	@PostMapping("/role")
	@ApiOperation(value = "新增人员角色")
	public BaseResponse insertUserRole(@RequestBody UserDeptAndTypeRequestVO vo) throws BusinessException {
		if (vo == null || vo.getDeptId() == null) {
			throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "uerRole not be null");
		}
		int result = userRoleService.insertUser(vo);
		if (result > 0) {
			return BaseResponse.getInstence().createBySuccessMessage("新增成功！");
		} else {
			log.info("UserController.updateUserRole.Request[{}]", vo.toString());
			throw new BusinessException(EmBusinessError.UNKNOW_ERROR, "新增失败！");
		}

	}
	/**
	 * 修改人员角色
	 * @return
	 * @throws BusinessException
	 */
	@ResponseBody
	@PutMapping("/role")
	@ApiOperation(value = "修改人员角色")
	public BaseResponse updateUserRole(@RequestBody UserRoleRequestVO vo) throws BusinessException{
		if(vo == null || vo.getPkId() == null) {
			throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,"pkId not be null");
		}
		log.info("UserController.updateUserRole.Request[{}]",vo.toString());
		//待实现
		throw new BusinessException(EmBusinessError.UNKNOW_ERROR,"未实现"); 
		
	}	
	/**
	 * 删除人员角色
	 * @return
	 * @throws BusinessException
	 */
	@ResponseBody
	@DeleteMapping("/role")
	@ApiOperation(value = "删除人员角色")
	public BaseResponse deleteUserRole(@RequestBody @NotNull String pkId) throws BusinessException{
		
		log.info("UserController.deleteUserRole pkId=[{}]",pkId);
		//待实现--逻辑删除
		throw new BusinessException(EmBusinessError.UNKNOW_ERROR,"未实现"); 
		
	}
	
}

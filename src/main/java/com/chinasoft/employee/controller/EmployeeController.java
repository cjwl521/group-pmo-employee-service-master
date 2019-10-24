package com.chinasoft.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.util.StringUtils;
import com.chinasoft.employee.controller.vo.request.AllEmployeeRequestVO;
import com.chinasoft.employee.controller.vo.request.SearchStaffRequestVO;
import com.chinasoft.employee.controller.vo.response.EmployeeAndHsbcDetailResponseVO;
import com.chinasoft.employee.exception.BusinessException;
import com.chinasoft.employee.exception.EmBusinessError;
import com.chinasoft.employee.response.BaseResponse;
import com.chinasoft.employee.service.EmployeeService;
import com.chinasoft.employee.util.PrdPageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping(value ="employee")
@Slf4j
@Api(value= "员工的相关操作")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	/**
	 * 新增人员
	 * @return
	 * @throws BusinessException
	 */
	@ResponseBody
	@PostMapping("/basic")
	@ApiOperation(value = "新增员工基础信息")
	public BaseResponse insertEmployee(@RequestBody AllEmployeeRequestVO vo) throws BusinessException{
		if(vo == null) {
			throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,"employee not be null");
		}
		log.info("EmployeeController.insertEmployee.Request[{}]",vo.toString());
    	Integer result = employeeService.insertEmployee(vo);
		if(result == 1) {
			return BaseResponse.getInstence().createBySuccess("员工信息添加成功", result);
		}else{
			return BaseResponse.getInstence().createByErrorMessage("员工信息添加失败");
		}
		
	}
	
	/**
	 * 修改员工信息
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	@ResponseBody
	@PatchMapping("/basic")
	@ApiOperation(value = "修改员工信息")
	public BaseResponse updateEmployee(@RequestBody AllEmployeeRequestVO vo) throws BusinessException{
		
		if(vo == null || vo.getPkId() == null ) {
			throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,"pkId not be null");
		}
		log.info("EmployeeController.updateEmployee.Request[{}]",vo.toString());
		Integer result = employeeService.updateByEmployeeId(vo);
		if(result == 1) {
			return BaseResponse.getInstence().createBySuccess("员工信息更新成功",result);
		}else {
			return BaseResponse.getInstence().createByErrorMessage("员工信息更新失败");
		}
		
	}
	/**
	 * 获取人员详细信息
	 * @return
	 * @throws BusinessException
	 */
	@ResponseBody
	@GetMapping("/basic")
	@ApiOperation(value = "查询RM/交付部经理/管理员能看到的所有员工", notes = "分页")
	public BaseResponse getEmployeeDetails(
			@RequestParam(value = "userId", required = false) String userId,
			@RequestParam(value = "userType", required = false) Integer userType,
			@RequestParam(value = "csdeptId", required = false ) Integer csdeptId,
			@RequestParam(value = "page", required = true, defaultValue = "1") Integer page,
			@RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize) throws BusinessException {
		log.info("EmployeeController.getEmployeeDetails");
		if(null == userType) {
			throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,"userType can not be null");
		}
		if(pageSize==0) {
			pageSize = 10;
		}
		PrdPageInfo<EmployeeAndHsbcDetailResponseVO> serviceRes  = employeeService.getEmployeeDetails(userId,userType,csdeptId,page,pageSize);
        
        return BaseResponse.getInstence().createBySuccessMessage(serviceRes);
	}
	/**
	 * 批量新增人员
	 * @return
	 * @throws BusinessException
	 */
	@ResponseBody
	@PostMapping("/batch")
	@ApiOperation(value = "批量新增员工基础信息")
	public BaseResponse batchInsertEmployee(@RequestBody List<AllEmployeeRequestVO> vos) throws BusinessException{
		if(vos == null || vos.isEmpty()) {
			throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,"employee not be null");
		}
		validateData(vos);
		Integer result = employeeService.batchInsertEmployees(vos);
		if(result == 1) {
			return BaseResponse.getInstence().createBySuccess("批量新增员工成功", result);
		}else{
			return BaseResponse.getInstence().createByErrorMessage("批量新增员工失败");
		}		
	}
	private void validateData(List<AllEmployeeRequestVO> vos) throws BusinessException {
		for(AllEmployeeRequestVO vo : vos) {
			checkRequired(vo.getEHr(), "E-HR账号必输");
			checkRequired(vo.getLob(), "LOB工号必输");
			checkRequired(vo.getStaffName(), "员工姓名必输");
			checkRequired(vo.getRmUserId(), "所属RM必输");
		}
		
	}
	
	private void checkRequired(String value, String errorMsg) throws BusinessException {
		if(StringUtils.isEmpty(value)) {
			throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,errorMsg);
		}
	}

	/**
	 * 获取人员列表
	 * String userId   人员Id
	 * String keyWords 姓名/EHR
	 * String skill    技能
	 * @throws BusinessExceptionString userId,String keyWords, String skill
	 */
	@ResponseBody
	@GetMapping("/list")
	@ApiOperation(value = "获取人员列表")
	public BaseResponse getEmployees(@RequestBody SearchStaffRequestVO vo) throws BusinessException{
		if(vo == null || vo.getUserId() == null) {
			throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,"userId not be null");
		}
		//待实现
		throw new BusinessException(EmBusinessError.UNKNOW_ERROR,"未实现");		
	}
	/**
	 * 批量新增人员
	 * @return
	 * @throws BusinessException
	 */
	@ResponseBody
	@PatchMapping("/batch")
	@ApiOperation(value = "批量修改员工基础信息")
	public BaseResponse batchUpdateEmployee(@RequestBody List<AllEmployeeRequestVO> vos) throws BusinessException{
		if(vos == null || vos.isEmpty()) {
			throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,"employee not be null");
		}
		validateData(vos);
		Integer result = employeeService.batchUpdateEmployees(vos);
		if(result !=0) {
			return BaseResponse.getInstence().createBySuccess("批量修改"+result+"条数据", result);
		}else{
			return BaseResponse.getInstence().createByErrorMessage("批量修改员工失败");
		}		
	}
}

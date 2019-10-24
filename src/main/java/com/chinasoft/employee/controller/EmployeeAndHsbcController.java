package com.chinasoft.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.util.StringUtils;
import com.chinasoft.employee.controller.vo.response.EmployeeAndHsbcDetailResponseVO;
import com.chinasoft.employee.exception.BusinessException;
import com.chinasoft.employee.exception.EmBusinessError;
import com.chinasoft.employee.response.BaseResponse;
import com.chinasoft.employee.service.EmployeeQueryService;
import com.chinasoft.employee.util.PrdPageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(value = "pool")
@Api(value = "/员工信息查询")
public class EmployeeAndHsbcController {
	
	@Autowired
	EmployeeQueryService employeeQueryService;
	
	@ResponseBody
	@GetMapping("/staffs")
	@ApiOperation(value = "模糊查询,通过 taffName或 ehr字段进行模糊查询,通过员工状态,所属部门进行条件查询")
	public BaseResponse queryByStaffNameOrEhr(
			@RequestParam(value = "staffNameOrEhr", required = false) String staffNameOrEhr,
			@RequestParam(value = "resourceStatus", required = false) Integer resourceStatus,
			@RequestParam(value = "filterCsdeptId", required = false ) Integer filterCsdeptId,
			@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
			@RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize,
			@RequestParam(value = "userId", required = false) String userId,
			@RequestParam(value = "userType", required = false) Integer userType,
			@RequestParam(value = "csdeptId", required = false) Integer csdeptId) throws BusinessException {
		log.info("EmployeeAndHsbcController.queryByStaffNameOrEhr");
		// 1. 初始化分页参数, 2. 查询结果, 3. 将结果放入PageInfo 对象，进行分页参数生成并且将数据合成,// 4.返回
		PrdPageInfo<EmployeeAndHsbcDetailResponseVO> pageInfo  = employeeQueryService.queryByStaffNameOrEhr(
				staffNameOrEhr,resourceStatus,filterCsdeptId,page,pageSize,userId,userType,csdeptId);
		
		return BaseResponse.getInstence().createBySuccess("查询成功", pageInfo);
	}
	
	@ResponseBody
	@GetMapping("/poolStaffDetail/{pkId}/{userId}/{isName}")
    @ApiOperation(value = "根据表的pkId查询当前员工详情")
	public BaseResponse queryStaffDetail(
			@PathVariable(name = "pkId") String pkId,
			@PathVariable(name = "userId") String userId,
			@PathVariable(name = "isName") Boolean isName
			) throws BusinessException {
		if(StringUtils.isEmpty(pkId)) {
			throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,"pkId can not be null");
		}
		log.info("EmployeeAndHsbcController.queryEmployeeDetailByPkId.Request pkId: [{}]",pkId);
		Object serviceResponse = null;
		if(isName) {
			serviceResponse = employeeQueryService.queryEmployeeDetailByPkIdToName(pkId,userId);
		}else {
			serviceResponse = employeeQueryService.queryEmployeeDetailByPkId(pkId,userId);
		}
        log.info("EmployeeAndHsbcController.queryStaffDetail.Response[{}]", serviceResponse.toString());
        return BaseResponse.getInstence().createBySuccessMessage(serviceResponse);
	}

}

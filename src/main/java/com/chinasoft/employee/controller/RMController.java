package com.chinasoft.employee.controller;

import javax.validation.Valid;

import com.chinasoft.employee.controller.vo.request.UserRoleRequestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chinasoft.employee.controller.vo.request.RMDisplayUserRequestVO;
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
@RequestMapping(value = "/RM")
@Api(value = "/RM --- 接口信息")
public class RMController {
	@Autowired
	private EmployeeQueryService employeeQueryService;
	
    @ResponseBody
    @GetMapping("/allRm")
	@ApiOperation(value = "查询所有rm信息")
    public BaseResponse getAllRm() throws BusinessException {
    	return BaseResponse.getInstence().createBySuccessMessage(employeeQueryService.findRMAllInfo());
    }

    @ResponseBody
    @GetMapping("/allRmByLoginUser")
    @ApiOperation(value = "根据登录用户类型及部门查询所属rm信息")
    public BaseResponse getAllRmByLoginUser(@Valid UserRoleRequestVO userRoleRequestVO) throws BusinessException {
        return BaseResponse.getInstence().createBySuccessMessage(employeeQueryService.findRMAllInfoByLoginUser(userRoleRequestVO));
    }
	
    @ResponseBody
    @GetMapping("/employee")
    @ApiOperation(value = "查询RM/交付部经理/管理员能看到的所有员工", notes = "分页")
	public BaseResponse getOrFilterAllEmployeeByRM(@Valid RMDisplayUserRequestVO requestVO) throws BusinessException {
		log.info("RMController.seachAllUserByRM.Request[{}]", requestVO.toString());
        if(null == requestVO.getUserType()) {
        	throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,"userType can not be null");
        }else {
        	if (requestVO.getPageSize() == 0) {
                requestVO.setPageSize(10);
            }
            PrdPageInfo<EmployeeAndHsbcDetailResponseVO> serviceRes = employeeQueryService.getOrFilterAllEmployeeByRM(requestVO);
            return BaseResponse.getInstence().createBySuccessMessage(serviceRes);
        }
	}
}

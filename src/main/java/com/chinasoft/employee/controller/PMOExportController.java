package com.chinasoft.employee.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chinasoft.employee.exception.BusinessException;
import com.chinasoft.employee.service.PMOEmployeeExportService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "employee")
@Api(value = "/pmo员工数据导出--接口信息")
public class PMOExportController {
	
	@Autowired
	private PMOEmployeeExportService pmoEmployeeExportService;
	
	@GetMapping("/export")
	@ApiOperation(value = "按员工信息/所属rm/交付部/员工状态导出Excel")
	public void benchPoolExport(HttpServletResponse response,
			@RequestParam(value = "staffNameOrEhr", required = false) String staffNameOrEhr,
			@RequestParam(value = "filterCsdeptId", required = false) Integer filterCsdeptId,
			@RequestParam(value = "resourceStatus", required = false) List<Integer> resourceStatusList,
			@RequestParam(value = "rmUserId", required =  false) String rmUserId,
			@RequestParam(value = "engagementType", required = false) Integer engagementType,
			@RequestParam(value = "csdeptId", required = false) String csdeptId,
			@RequestParam(value = "userType", required = false) String userType,
			@RequestParam(value = "eHr", required = false) String eHr
			) throws BusinessException {
		pmoEmployeeExportService.pmoEmployeeDataExport(response, staffNameOrEhr, filterCsdeptId, resourceStatusList,
				rmUserId, engagementType, csdeptId, userType, eHr);
	}

}

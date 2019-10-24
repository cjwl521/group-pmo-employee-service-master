package com.chinasoft.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chinasoft.employee.exception.BusinessException;
import com.chinasoft.employee.response.BaseResponse;
import com.chinasoft.employee.service.ImportExcelService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "excel")
@Api(value = "/pmo修改导出模板--接口信息")
public class PMOImportController {

	@Autowired
	private ImportExcelService importExcelService;

	@RequestMapping(value = "template")
	@PatchMapping
	public BaseResponse updateExcelModel() throws BusinessException {
		boolean result = importExcelService.updateExcelRules();
		if (result) {
			return BaseResponse.getInstence().createBySuccess("Excel模板修改成功", result);
		} else {
			return BaseResponse.getInstence().createByErrorMessage("Excel模板修改失败");
		}
	}
}

package com.chinasoft.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chinasoft.employee.exception.BusinessException;
import com.chinasoft.employee.response.BaseResponse;
import com.chinasoft.employee.service.DictionarySevice;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/dictionary")
@Api(value = "dictionary --- 数据字典信息查询")
public class DictionaryContorller {
	
	@Autowired
	private DictionarySevice dictionarySevice;
	@ResponseBody
	@GetMapping(value="/params")
	@ApiOperation(value = "数据字典查询")
	public BaseResponse dictionaryView() throws BusinessException {
		
		return BaseResponse.getInstence().createBySuccessMessage(dictionarySevice.getDictionary(0,null));
	}

}

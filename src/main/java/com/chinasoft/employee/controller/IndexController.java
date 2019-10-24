package com.chinasoft.employee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * for hc
 *
 */
@Controller
@Slf4j
@Api("swaggerDemoController相关的api")
public class IndexController {

	/**
	 * for hc
	 * 
	 * @return It works
	 */
	@RequestMapping("/")
	@ResponseBody
	public String index() {
		return "It works";
	}

	@ApiOperation(value = "根据code返回code用来测试", notes = "返回code")
	@ApiImplicitParam(name = "code", value = "传入的code", paramType = "param", required = true, dataType = "String")
	@GetMapping("/getcode")
	public String getCode(@RequestParam String code) {
		log.info("The code is ", code);
		return code;
	}
}

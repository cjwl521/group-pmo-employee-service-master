package com.chinasoft.employee.common;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.MyBatisSystemException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinasoft.employee.exception.BusinessException;
import com.chinasoft.employee.exception.EmBusinessError;
import com.chinasoft.employee.response.BaseResponse;
@ControllerAdvice
public class ExceptionHandleConfig {

	Logger logger = LoggerFactory.getLogger(ExceptionHandleConfig.class);
	
	@ExceptionHandler(value = { BusinessException.class })
    @ResponseBody
	public BaseResponse handleIOException(BusinessException ex, HttpServletRequest request) throws Exception {
	    BaseResponse business = BaseResponse.getInstence().createByErrorMessage(ex.getErrCode()+"", ex.getErrMsg());
		return business;
	}
	@ExceptionHandler(value = { MyBatisSystemException.class })
	@ResponseBody
	public BaseResponse handleMyBatisSystemException(BusinessException ex, HttpServletRequest request) throws Exception {
	    String message = "Forwarding to error page from request "
                + getDescription(request) + " due to exception [" + ex.getMessage()
                + "]";
       logger.info(message, ex);
		BaseResponse business = BaseResponse.getInstence().createByErrorMessage(String.valueOf(EmBusinessError.DB_IMPORT_ERROR.getErrCode()),EmBusinessError.DB_IMPORT_ERROR.getErrMsg());
		return business;
	}

	@ExceptionHandler(value = { Exception.class })
	@ResponseBody
	public BaseResponse handleIOException(Exception ex, HttpServletRequest request)
			throws Exception {
	    String message = "Forwarding to error page from request "
                + getDescription(request) + " due to exception [" + ex.getMessage()
                + "]";
       logger.error(message, ex);
	   BaseResponse unknowException = BaseResponse.getInstence().createByErrorMessage(ex.getClass().toString(),BaseResponse.UNKNOWERRORCODE, EmBusinessError.UNKNOW_ERROR.getErrMsg());
       return unknowException;	
	}
	protected String getDescription(HttpServletRequest request) {
        String pathInfo = (request.getPathInfo() != null) ? request.getPathInfo() : "";
        return "[" + request.getServletPath() + pathInfo + "]";
    }
	

}

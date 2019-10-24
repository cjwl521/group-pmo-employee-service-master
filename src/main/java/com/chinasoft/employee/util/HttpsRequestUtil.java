package com.chinasoft.employee.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.chinasoft.employee.exception.BusinessRuntimeException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Http request service
 * @author jarries
 *
 */
@Component
public class HttpsRequestUtil {

	@Autowired
	private RestTemplate restTemplate;

	/**
	 * 执行HTTP Get Request请求
	 * 
	 * @param url
	 *            request的url
	 * @param clazz
	 *            需要响应的类
	 * @param <T>
	 *            泛型类
	 * @return T 返回类型
	 */
	public <T> T httpsGetRequest(String url, Class<T> clazz) {
		T obj = null;
		long startHttpTime = System.currentTimeMillis();
		LoggerUtil.logInfoMethod("Start send http get health request, url is:{}", url);

		try {
			obj = this.restTemplate.getForEntity(url, clazz).getBody();
		} catch (HttpServerErrorException e) {
			try {
				obj = new ObjectMapper().readValue(e.getResponseBodyAsString(), clazz);
			} catch (Exception e1) {
				LoggerUtil.logErrorMethod(e.getMessage(), e1);
				throw new BusinessRuntimeException(e1.getMessage(), e1);
			}
		} catch (ResourceAccessException e2) {
			throw e2;
		} catch (Exception e) {
			throw new BusinessRuntimeException(e.getMessage(), e);
		}
		LoggerUtil.logInfoMethod("httpGetRequest spend time is: {}ms",
				String.valueOf(System.currentTimeMillis() - startHttpTime));
		return obj;
	}
	
	/**
	 * 执行HTTP Post Request请求
	 * 
	 * @param url
	 *            request的url
	 * @param clazz
	 *            需要响应的类
	 * @param <T>
	 *            泛型类
	 * @return T 返回类型
	 */
	public <T> T httpsPostRequest(String url, Object body, Class<T> clazz) {
		T obj = null;
		long startHttpTime = System.currentTimeMillis();
		LoggerUtil.logInfoMethod("Start send http get health request, url is:{}", url);

		try {
			obj = this.restTemplate.postForObject(url, body, clazz);
		} catch (HttpServerErrorException e) {
			try {
				obj = new ObjectMapper().readValue(e.getResponseBodyAsString(), clazz);
			} catch (Exception e1) {
				LoggerUtil.logErrorMethod(e.getMessage(), e1);
				throw new BusinessRuntimeException(e1.getMessage(), e1);
			}
		} catch (ResourceAccessException e2) {
			throw e2;
		} catch (Exception e) {
			throw new BusinessRuntimeException(e.getMessage(), e);
		}
		LoggerUtil.logInfoMethod("httpGetRequest spend time is: {}ms",
				String.valueOf(System.currentTimeMillis() - startHttpTime));
		return obj;
	}
}

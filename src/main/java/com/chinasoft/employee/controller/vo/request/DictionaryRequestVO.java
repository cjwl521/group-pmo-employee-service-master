package com.chinasoft.employee.controller.vo.request;

import lombok.Data;


/**
 * Dictionary Request参数集合
 * @author jarries
 *
 */
@Data
public class DictionaryRequestVO {
    
	private String typeCode;//将要获取的参数类型
	
	private String typeName;//将要获取的参数类型名称
	
}

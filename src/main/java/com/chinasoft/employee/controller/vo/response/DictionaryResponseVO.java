package com.chinasoft.employee.controller.vo.response;

import lombok.Data;

/**
 * 将要返回的Dictionary信息
 * @author jarries
 *
 */
@Data
public class DictionaryResponseVO {
	
    private Integer typeCode;//返回参类型编码

    private String typeName;//返回参数类型名称
	
	private Integer paramCode;//返回参数编码
	
	private String paramName;//返回参数名称
	
	private Integer relatedCode;//返回的相关参数编码
	
	private String relatedName;//返回的相关参数名称
	
}

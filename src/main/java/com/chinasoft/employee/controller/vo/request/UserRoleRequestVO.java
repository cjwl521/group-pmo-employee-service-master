package com.chinasoft.employee.controller.vo.request;


import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserRoleRequestVO {

	
	private String pkId;

    private String employeeId;

    private  String userName;

    private String userType;

    private String csdeptId;

    private Integer buId;

    private Integer blId;
}

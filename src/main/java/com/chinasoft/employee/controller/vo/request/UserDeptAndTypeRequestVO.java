package com.chinasoft.employee.controller.vo.request;


import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserDeptAndTypeRequestVO {

	
    private String lob;

    private String userType;

    private String deptId;

}

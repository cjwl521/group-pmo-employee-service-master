package com.chinasoft.employee.dao.entity;

import lombok.Data;
import lombok.ToString;
/**
 * 用户登录接口返回
 * @author wang
 *
 */
@Data
@ToString
public class EmployeeAndUserRoleDO {
	/**
	 * 用户LOB
	 */
	private String lob;
    /**
     * 用户EHR
     */
    private String eHr;
    /**
     * 用户姓名
     */
    private String staffName;
    /**
     * 用户组别
     */
    private String userType;
    /**
     * 用户部门编号
     */
    private String csdeptId;
    /**
     * 用户邮箱
     */
    private String email;
}

package com.chinasoft.employee.controller.vo.response;

import lombok.Data;
import lombok.ToString;
/**
 * 用户登录接口返回
 * @author wang
 *
 */
@Data
@ToString
public class LoginResponseVO {
    /**
     * 用户EHR
     */
    private String eHr;
    /**
     * 用户姓名
     */
    private String userName;
    /**
     * 用户组别
     */
    private String userType;
    /**
     * 用户部门编号
     */
    private String deptId;
    /**
     * 用户邮箱
     */
    private String email;
}

package com.chinasoft.employee.service.model;

import lombok.Data;
/**
 * 用户登录信息返回
 * @author wang
 *
 */
@Data
public class UserModel {
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

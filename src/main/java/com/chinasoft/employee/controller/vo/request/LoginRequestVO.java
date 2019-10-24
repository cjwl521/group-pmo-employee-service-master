package com.chinasoft.employee.controller.vo.request;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.ToString;

/**
 * 登录接口入参
 * @author wang
 *
 */
@Data
@ToString
public class LoginRequestVO {
    
    @NotNull
    private String lob; //用户名
    @NotNull
    private String password; //密码
}

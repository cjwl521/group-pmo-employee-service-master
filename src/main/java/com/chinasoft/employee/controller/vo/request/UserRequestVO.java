package com.chinasoft.employee.controller.vo.request;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserRequestVO {
	@NotNull
	private String pkId;
	@NotNull
	private String password;
	@NotNull
	private String newPassword;
	@NotNull
	private String confirmPassword;
}

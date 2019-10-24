package com.chinasoft.employee.controller.vo.request;


import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.ToString;

@Data
@ToString

public class SearchStaffRequestVO {

	@NotNull
	private String userId; //查询人userId
	private String keyWords;
	private String skill;	
}

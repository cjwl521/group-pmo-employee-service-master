package com.chinasoft.employee.common;

public class ErrorBody {

	private String errorCode;
	private String description;

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return "ErrorBody [errorCode=" + errorCode + ", description=" + description + "]";
	}
	
	

}
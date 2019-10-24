package com.chinasoft.employee.common;

import java.util.List;

public class HubResponseBean {

	private int status;
	private Object responseBody;

	private List<ErrorBody> errorBody;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Object getResponseBody() {
		return responseBody;
	}

	public void setResponseBody(Object responseBody) {
		this.responseBody = responseBody;
	}

	public List<ErrorBody> getErrorBody() {
		return errorBody;
	}

	public void setErrorBody(List<ErrorBody> errorBody) {
		this.errorBody = errorBody;
	}

	@Override
	public String toString() {
		return "HubResponseBean : status=" + status + ", responseBody=" + responseBody.toString() + ", errorBody="
				+ errorBody.toString();
	}

}

package com.chinasoft.employee.service.model;

public class RmInfoModel {

    private String rmUserId;
    
    private String employeeId;
    
    private String staffName;

	public String getRmUserId() {
		return rmUserId;
	}

	public void setRmUserId(String rmUserId) {
		this.rmUserId = rmUserId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	@Override
	public String toString() {
		return "RmInfoModel [rmUserId=" + rmUserId + ", employeeId=" + employeeId + ", staffName=" + staffName
				+ ", getRmUserId()=" + getRmUserId() + ", getEmployeeId()=" + getEmployeeId() + ", getStaffName()="
				+ getStaffName() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
}

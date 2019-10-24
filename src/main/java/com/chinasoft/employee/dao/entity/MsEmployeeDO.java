package com.chinasoft.employee.dao.entity;

public class MsEmployeeDO {
    private String pkId;

    private String employeeId;

    private Integer msLevel;

    public String getPkId() {
        return pkId;
    }

    public void setPkId(String pkId) {
        this.pkId = pkId == null ? null : pkId.trim();
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId == null ? null : employeeId.trim();
    }

    public Integer getMsLevel() {
        return msLevel;
    }

    public void setMsLevel(Integer msLevel) {
        this.msLevel = msLevel;
    }
}
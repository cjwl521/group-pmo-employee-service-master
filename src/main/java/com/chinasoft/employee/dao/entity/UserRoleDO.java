package com.chinasoft.employee.dao.entity;

public class UserRoleDO {
    private String pkId;

    private String employeeId;

    private Integer userType;

    private Integer csdeptId;

    private Boolean deleted;

    private Boolean multipleRoles;

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

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getCsdeptId() {
        return csdeptId;
    }

    public void setCsdeptId(Integer csdeptId) {
        this.csdeptId = csdeptId;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Boolean getMultipleRoles() {
        return multipleRoles;
    }

    public void setMultipleRoles(Boolean multipleRoles) {
        this.multipleRoles = multipleRoles;
    }
}
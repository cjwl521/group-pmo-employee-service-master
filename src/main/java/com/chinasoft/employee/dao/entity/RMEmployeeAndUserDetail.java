package com.chinasoft.employee.dao.entity;

import java.util.Date;

public class RMEmployeeAndUserDetail {
    private String employeeId;
    /**
    * 
    */
    private String staffName;

    private String staffRegion;

    private String eHr;

    private String skill;

    private String skillLevel;

//    private String subdeptName;

    private String lob;

    private Date entryDate;

    private String csdeptId;
    
    private String csSubdeptId;
    
    private String rmUserId;
    

    public String getRmUserId() {
        return rmUserId;
    }

    public void setRmUserId(String rmUserId) {
        this.rmUserId = rmUserId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getStaffName() {
        return staffName;
    }

    public String getStaffRegion() {
        return staffRegion;
    }

    public String geteHr() {
        return eHr;
    }

    public String getSkill() {
        return skill;
    }

    public String getSkillLevel() {
        return skillLevel;
    }

    public String getLob() {
        return lob;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public String getCsdeptId() {
        return csdeptId;
    }

    public String getCsSubdeptId() {
        return csSubdeptId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public void setStaffRegion(String staffRegion) {
        this.staffRegion = staffRegion;
    }

    public void seteHr(String eHr) {
        this.eHr = eHr;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public void setSkillLevel(String skillLevel) {
        this.skillLevel = skillLevel;
    }

    public void setLob(String lob) {
        this.lob = lob;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public void setCsdeptId(String csdeptId) {
        this.csdeptId = csdeptId;
    }

    public void setCsSubdeptId(String csSubdeptId) {
        this.csSubdeptId = csSubdeptId;
    }
    
    
}

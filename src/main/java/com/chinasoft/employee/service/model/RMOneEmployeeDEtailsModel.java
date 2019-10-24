package com.chinasoft.employee.service.model;

import java.util.Date;
/**
 * 员工信息
 * @author wang
 *
 */
public class RMOneEmployeeDEtailsModel {
    
    /**
     * 员工编号
     */
    private String employeeId;
    /**
    * 员工姓名
    */
    private String staffName;
    /**
     * 工作地区
     */
    private String staffRegion;
    /**
     * EHR
     */
    private String eHr;
    /**
     * 技能
     */
    private String skill;
    /**
     * 技能级别
     */
    private String skillLevel;
    /**
     * 部门信息
     */
    private String subdeptName;
    /**
     * LOB
     */
    private String lob;
    /**
     * 创建日期
     */
    private Date entryDate;
    /**
     * rm 姓名
     */
    private String rmName;
    /**
     * 交付部经理
     */
    private String subdeptManager;
    
    
    
    public String getSubdeptManager() {
        return subdeptManager;
    }

    public void setSubdeptManager(String subdeptManager) {
        this.subdeptManager = subdeptManager;
    }

    private String latestPerformance;
    
    private String beforeLatestPerformance;

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

   
    public String getLob() {
        return lob;
    }

    public Date getEntryDate() {
        return entryDate;
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

   
    public void setLob(String lob) {
        this.lob = lob;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    
    
    public String getSubdeptName() {
        return subdeptName;
    }

    public void setSubdeptName(String subdeptName) {
        this.subdeptName = subdeptName;
    }

    

    public String getLatestPerformance() {
        return latestPerformance;
    }

    public String getBeforeLatestPerformance() {
        return beforeLatestPerformance;
    }

    public void setLatestPerformance(String latestPerformance) {
        this.latestPerformance = latestPerformance;
    }

    public void setBeforeLatestPerformance(String beforeLatestPerformance) {
        this.beforeLatestPerformance = beforeLatestPerformance;
    }

    public String getSkillLevel() {
        return skillLevel;
    }

    public String getRmName() {
        return rmName;
    }

    public void setSkillLevel(String skillLevel) {
        this.skillLevel = skillLevel;
    }

    public void setRmName(String rmName) {
        this.rmName = rmName;
    }

    @Override
    public String toString() {
        return "RMOneEmployeeDEtailsModel [employeeId=" + employeeId + ", staffName=" + staffName + ", staffRegion="
                + staffRegion + ", eHr=" + eHr + ", skill=" + skill + ", skillLevel=" + skillLevel + ", subdeptName="
                + subdeptName + ", lob=" + lob + ", entryDate=" + entryDate + ", rmName=" + rmName
                + ", latestPerformance=" + latestPerformance + ", beforeLatestPerformance=" + beforeLatestPerformance
                + "]";
    }
    
    

}

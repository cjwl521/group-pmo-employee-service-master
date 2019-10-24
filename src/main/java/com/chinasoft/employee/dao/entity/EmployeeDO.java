package com.chinasoft.employee.dao.entity;

import java.math.BigDecimal;
import java.util.Date;

public class EmployeeDO {
    private String pkId;

    private String eHr;

    private String lob;

    private String staffName;

    private String rmUserId;

    private Integer staffRegion;

    private Integer staffLocation;

    private Integer role;

    private Integer skill;

    private Integer engagementType;

    private Integer billRateType;

    private Integer billCurrency;

    private BigDecimal billRate;

    private Integer employeeType;

    private Integer resourceStatus;

    private Date graduationDate;

    private Date entryDate;

    private String email;

    private String csiProNumber;

    private Date csiProStartdate;

    private String csiProName;

    private BigDecimal itindustryWorkYear;

    private Date terminationDate;

    private String reasonForTermination;

    private Date createTime;

    private Date updateTime;

    private String backbone;

    private Integer assessed;

    public String getPkId() {
        return pkId;
    }

    public void setPkId(String pkId) {
        this.pkId = pkId == null ? null : pkId.trim();
    }

    public String geteHr() {
        return eHr;
    }

    public void seteHr(String eHr) {
        this.eHr = eHr == null ? null : eHr.trim();
    }

    public String getLob() {
        return lob;
    }

    public void setLob(String lob) {
        this.lob = lob == null ? null : lob.trim();
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName == null ? null : staffName.trim();
    }

    public String getRmUserId() {
        return rmUserId;
    }

    public void setRmUserId(String rmUserId) {
        this.rmUserId = rmUserId == null ? null : rmUserId.trim();
    }

    public Integer getStaffRegion() {
        return staffRegion;
    }

    public void setStaffRegion(Integer staffRegion) {
        this.staffRegion = staffRegion;
    }

    public Integer getStaffLocation() {
        return staffLocation;
    }

    public void setStaffLocation(Integer staffLocation) {
        this.staffLocation = staffLocation;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Integer getSkill() {
        return skill;
    }

    public void setSkill(Integer skill) {
        this.skill = skill;
    }

    public Integer getEngagementType() {
        return engagementType;
    }

    public void setEngagementType(Integer engagementType) {
        this.engagementType = engagementType;
    }

    public Integer getBillRateType() {
        return billRateType;
    }

    public void setBillRateType(Integer billRateType) {
        this.billRateType = billRateType;
    }

    public Integer getBillCurrency() {
        return billCurrency;
    }

    public void setBillCurrency(Integer billCurrency) {
        this.billCurrency = billCurrency;
    }

    public BigDecimal getBillRate() {
        return billRate;
    }

    public void setBillRate(BigDecimal billRate) {
        this.billRate = billRate;
    }

    public Integer getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(Integer employeeType) {
        this.employeeType = employeeType;
    }

    public Integer getResourceStatus() {
        return resourceStatus;
    }

    public void setResourceStatus(Integer resourceStatus) {
        this.resourceStatus = resourceStatus;
    }

    public Date getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(Date graduationDate) {
        this.graduationDate = graduationDate;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getCsiProNumber() {
        return csiProNumber;
    }

    public void setCsiProNumber(String csiProNumber) {
        this.csiProNumber = csiProNumber == null ? null : csiProNumber.trim();
    }

    public Date getCsiProStartdate() {
        return csiProStartdate;
    }

    public void setCsiProStartdate(Date csiProStartdate) {
        this.csiProStartdate = csiProStartdate;
    }

    public String getCsiProName() {
        return csiProName;
    }

    public void setCsiProName(String csiProName) {
        this.csiProName = csiProName == null ? null : csiProName.trim();
    }

    public BigDecimal getItindustryWorkYear() {
        return itindustryWorkYear;
    }

    public void setItindustryWorkYear(BigDecimal itindustryWorkYear) {
        this.itindustryWorkYear = itindustryWorkYear;
    }

    public Date getTerminationDate() {
        return terminationDate;
    }

    public void setTerminationDate(Date terminationDate) {
        this.terminationDate = terminationDate;
    }

    public String getReasonForTermination() {
        return reasonForTermination;
    }

    public void setReasonForTermination(String reasonForTermination) {
        this.reasonForTermination = reasonForTermination == null ? null : reasonForTermination.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getBackbone() {
        return backbone;
    }

    public void setBackbone(String backbone) {
        this.backbone = backbone == null ? null : backbone.trim();
    }

    public Integer getAssessed() {
        return assessed;
    }

    public void setAssessed(Integer assessed) {
        this.assessed = assessed;
    }
}
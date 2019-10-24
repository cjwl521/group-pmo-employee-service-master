package com.chinasoft.employee.dao.entity;

import java.util.Date;

public class HsbcEmployeeDO {
    private String pkId;

    private String employeeId;

    private String hsbcStaffId;

    private String ln;

    private Integer locationType;

    private Integer onshoreOrOffshore;

    private Integer gbGf;

    private Integer hsbcSubdeptId;

    private Integer hsbcThridDeptId;

    private String hsbcManager;

    private String sow;

    private Date sowExpiredDate;

    private Date hsbcDoj;

    private String hsbcPod;

    private Boolean podtl;

    private Integer tlType;

    private String hsbcProjectName;

    private String staffCategory;

    private Date mentionLwd;

    private Integer msaRole;

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

    public String getHsbcStaffId() {
        return hsbcStaffId;
    }

    public void setHsbcStaffId(String hsbcStaffId) {
        this.hsbcStaffId = hsbcStaffId == null ? null : hsbcStaffId.trim();
    }

    public String getLn() {
        return ln;
    }

    public void setLn(String ln) {
        this.ln = ln == null ? null : ln.trim();
    }

    public Integer getLocationType() {
        return locationType;
    }

    public void setLocationType(Integer locationType) {
        this.locationType = locationType;
    }

    public Integer getOnshoreOrOffshore() {
        return onshoreOrOffshore;
    }

    public void setOnshoreOrOffshore(Integer onshoreOrOffshore) {
        this.onshoreOrOffshore = onshoreOrOffshore;
    }

    public Integer getGbGf() {
        return gbGf;
    }

    public void setGbGf(Integer gbGf) {
        this.gbGf = gbGf;
    }

    public Integer getHsbcSubdeptId() {
        return hsbcSubdeptId;
    }

    public void setHsbcSubdeptId(Integer hsbcSubdeptId) {
        this.hsbcSubdeptId = hsbcSubdeptId;
    }

    public Integer getHsbcThridDeptId() {
        return hsbcThridDeptId;
    }

    public void setHsbcThridDeptId(Integer hsbcThridDeptId) {
        this.hsbcThridDeptId = hsbcThridDeptId;
    }

    public String getHsbcManager() {
        return hsbcManager;
    }

    public void setHsbcManager(String hsbcManager) {
        this.hsbcManager = hsbcManager == null ? null : hsbcManager.trim();
    }

    public String getSow() {
        return sow;
    }

    public void setSow(String sow) {
        this.sow = sow == null ? null : sow.trim();
    }

    public Date getSowExpiredDate() {
        return sowExpiredDate;
    }

    public void setSowExpiredDate(Date sowExpiredDate) {
        this.sowExpiredDate = sowExpiredDate;
    }

    public Date getHsbcDoj() {
        return hsbcDoj;
    }

    public void setHsbcDoj(Date hsbcDoj) {
        this.hsbcDoj = hsbcDoj;
    }

    public String getHsbcPod() {
        return hsbcPod;
    }

    public void setHsbcPod(String hsbcPod) {
        this.hsbcPod = hsbcPod == null ? null : hsbcPod.trim();
    }

    public Boolean getPodtl() {
        return podtl;
    }

    public void setPodtl(Boolean podtl) {
        this.podtl = podtl;
    }

    public Integer getTlType() {
        return tlType;
    }

    public void setTlType(Integer tlType) {
        this.tlType = tlType;
    }

    public String getHsbcProjectName() {
        return hsbcProjectName;
    }

    public void setHsbcProjectName(String hsbcProjectName) {
        this.hsbcProjectName = hsbcProjectName == null ? null : hsbcProjectName.trim();
    }

    public String getStaffCategory() {
        return staffCategory;
    }

    public void setStaffCategory(String staffCategory) {
        this.staffCategory = staffCategory == null ? null : staffCategory.trim();
    }

    public Date getMentionLwd() {
        return mentionLwd;
    }

    public void setMentionLwd(Date mentionLwd) {
        this.mentionLwd = mentionLwd;
    }

    public Integer getMsaRole() {
        return msaRole;
    }

    public void setMsaRole(Integer msaRole) {
        this.msaRole = msaRole;
    }
}
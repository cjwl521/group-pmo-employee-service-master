package com.chinasoft.employee.dao.entity;

public class CSDeptDO {
    private Integer pkId;

    private String csDeptName;

    private Integer parentId;

    public Integer getPkId() {
        return pkId;
    }

    public void setPkId(Integer pkId) {
        this.pkId = pkId;
    }

    public String getCsDeptName() {
        return csDeptName;
    }

    public void setCsDeptName(String csDeptName) {
        this.csDeptName = csDeptName == null ? null : csDeptName.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}
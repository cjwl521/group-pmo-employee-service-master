package com.chinasoft.employee.dao.entity;

public class DictionaryDO {
    private String pkId;

    private Integer typeCode;

    private String typeName;

    private Integer paramCode;

    private String paramName;

    private Integer relatedCode;

    private String relatedName;

    private Integer status;

    private String parentId;

    public String getPkId() {
        return pkId;
    }

    public void setPkId(String pkId) {
        this.pkId = pkId == null ? null : pkId.trim();
    }

    public Integer getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(Integer typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public Integer getParamCode() {
        return paramCode;
    }

    public void setParamCode(Integer paramCode) {
        this.paramCode = paramCode;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName == null ? null : paramName.trim();
    }

    public Integer getRelatedCode() {
        return relatedCode;
    }

    public void setRelatedCode(Integer relatedCode) {
        this.relatedCode = relatedCode;
    }

    public String getRelatedName() {
        return relatedName;
    }

    public void setRelatedName(String relatedName) {
        this.relatedName = relatedName == null ? null : relatedName.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }
}
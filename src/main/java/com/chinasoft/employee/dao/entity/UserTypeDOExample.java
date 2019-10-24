package com.chinasoft.employee.dao.entity;

import java.util.ArrayList;
import java.util.List;

public class UserTypeDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserTypeDOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andPkIdIsNull() {
            addCriterion("PK_ID is null");
            return (Criteria) this;
        }

        public Criteria andPkIdIsNotNull() {
            addCriterion("PK_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPkIdEqualTo(String value) {
            addCriterion("PK_ID =", value, "pkId");
            return (Criteria) this;
        }

        public Criteria andPkIdNotEqualTo(String value) {
            addCriterion("PK_ID <>", value, "pkId");
            return (Criteria) this;
        }

        public Criteria andPkIdGreaterThan(String value) {
            addCriterion("PK_ID >", value, "pkId");
            return (Criteria) this;
        }

        public Criteria andPkIdGreaterThanOrEqualTo(String value) {
            addCriterion("PK_ID >=", value, "pkId");
            return (Criteria) this;
        }

        public Criteria andPkIdLessThan(String value) {
            addCriterion("PK_ID <", value, "pkId");
            return (Criteria) this;
        }

        public Criteria andPkIdLessThanOrEqualTo(String value) {
            addCriterion("PK_ID <=", value, "pkId");
            return (Criteria) this;
        }

        public Criteria andPkIdLike(String value) {
            addCriterion("PK_ID like", value, "pkId");
            return (Criteria) this;
        }

        public Criteria andPkIdNotLike(String value) {
            addCriterion("PK_ID not like", value, "pkId");
            return (Criteria) this;
        }

        public Criteria andPkIdIn(List<String> values) {
            addCriterion("PK_ID in", values, "pkId");
            return (Criteria) this;
        }

        public Criteria andPkIdNotIn(List<String> values) {
            addCriterion("PK_ID not in", values, "pkId");
            return (Criteria) this;
        }

        public Criteria andPkIdBetween(String value1, String value2) {
            addCriterion("PK_ID between", value1, value2, "pkId");
            return (Criteria) this;
        }

        public Criteria andPkIdNotBetween(String value1, String value2) {
            addCriterion("PK_ID not between", value1, value2, "pkId");
            return (Criteria) this;
        }

        public Criteria andUserTypeCodeIsNull() {
            addCriterion("USER_TYPE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andUserTypeCodeIsNotNull() {
            addCriterion("USER_TYPE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andUserTypeCodeEqualTo(Integer value) {
            addCriterion("USER_TYPE_CODE =", value, "userTypeCode");
            return (Criteria) this;
        }

        public Criteria andUserTypeCodeNotEqualTo(Integer value) {
            addCriterion("USER_TYPE_CODE <>", value, "userTypeCode");
            return (Criteria) this;
        }

        public Criteria andUserTypeCodeGreaterThan(Integer value) {
            addCriterion("USER_TYPE_CODE >", value, "userTypeCode");
            return (Criteria) this;
        }

        public Criteria andUserTypeCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("USER_TYPE_CODE >=", value, "userTypeCode");
            return (Criteria) this;
        }

        public Criteria andUserTypeCodeLessThan(Integer value) {
            addCriterion("USER_TYPE_CODE <", value, "userTypeCode");
            return (Criteria) this;
        }

        public Criteria andUserTypeCodeLessThanOrEqualTo(Integer value) {
            addCriterion("USER_TYPE_CODE <=", value, "userTypeCode");
            return (Criteria) this;
        }

        public Criteria andUserTypeCodeIn(List<Integer> values) {
            addCriterion("USER_TYPE_CODE in", values, "userTypeCode");
            return (Criteria) this;
        }

        public Criteria andUserTypeCodeNotIn(List<Integer> values) {
            addCriterion("USER_TYPE_CODE not in", values, "userTypeCode");
            return (Criteria) this;
        }

        public Criteria andUserTypeCodeBetween(Integer value1, Integer value2) {
            addCriterion("USER_TYPE_CODE between", value1, value2, "userTypeCode");
            return (Criteria) this;
        }

        public Criteria andUserTypeCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("USER_TYPE_CODE not between", value1, value2, "userTypeCode");
            return (Criteria) this;
        }

        public Criteria andUserTypeNameIsNull() {
            addCriterion("USER_TYPE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andUserTypeNameIsNotNull() {
            addCriterion("USER_TYPE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andUserTypeNameEqualTo(String value) {
            addCriterion("USER_TYPE_NAME =", value, "userTypeName");
            return (Criteria) this;
        }

        public Criteria andUserTypeNameNotEqualTo(String value) {
            addCriterion("USER_TYPE_NAME <>", value, "userTypeName");
            return (Criteria) this;
        }

        public Criteria andUserTypeNameGreaterThan(String value) {
            addCriterion("USER_TYPE_NAME >", value, "userTypeName");
            return (Criteria) this;
        }

        public Criteria andUserTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("USER_TYPE_NAME >=", value, "userTypeName");
            return (Criteria) this;
        }

        public Criteria andUserTypeNameLessThan(String value) {
            addCriterion("USER_TYPE_NAME <", value, "userTypeName");
            return (Criteria) this;
        }

        public Criteria andUserTypeNameLessThanOrEqualTo(String value) {
            addCriterion("USER_TYPE_NAME <=", value, "userTypeName");
            return (Criteria) this;
        }

        public Criteria andUserTypeNameLike(String value) {
            addCriterion("USER_TYPE_NAME like", value, "userTypeName");
            return (Criteria) this;
        }

        public Criteria andUserTypeNameNotLike(String value) {
            addCriterion("USER_TYPE_NAME not like", value, "userTypeName");
            return (Criteria) this;
        }

        public Criteria andUserTypeNameIn(List<String> values) {
            addCriterion("USER_TYPE_NAME in", values, "userTypeName");
            return (Criteria) this;
        }

        public Criteria andUserTypeNameNotIn(List<String> values) {
            addCriterion("USER_TYPE_NAME not in", values, "userTypeName");
            return (Criteria) this;
        }

        public Criteria andUserTypeNameBetween(String value1, String value2) {
            addCriterion("USER_TYPE_NAME between", value1, value2, "userTypeName");
            return (Criteria) this;
        }

        public Criteria andUserTypeNameNotBetween(String value1, String value2) {
            addCriterion("USER_TYPE_NAME not between", value1, value2, "userTypeName");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
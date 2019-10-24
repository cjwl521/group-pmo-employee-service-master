package com.chinasoft.employee.dao.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class HsbcEmployeeDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HsbcEmployeeDOExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andEmployeeIdIsNull() {
            addCriterion("EMPLOYEE_ID is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdIsNotNull() {
            addCriterion("EMPLOYEE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdEqualTo(String value) {
            addCriterion("EMPLOYEE_ID =", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdNotEqualTo(String value) {
            addCriterion("EMPLOYEE_ID <>", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdGreaterThan(String value) {
            addCriterion("EMPLOYEE_ID >", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdGreaterThanOrEqualTo(String value) {
            addCriterion("EMPLOYEE_ID >=", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdLessThan(String value) {
            addCriterion("EMPLOYEE_ID <", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdLessThanOrEqualTo(String value) {
            addCriterion("EMPLOYEE_ID <=", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdLike(String value) {
            addCriterion("EMPLOYEE_ID like", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdNotLike(String value) {
            addCriterion("EMPLOYEE_ID not like", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdIn(List<String> values) {
            addCriterion("EMPLOYEE_ID in", values, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdNotIn(List<String> values) {
            addCriterion("EMPLOYEE_ID not in", values, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdBetween(String value1, String value2) {
            addCriterion("EMPLOYEE_ID between", value1, value2, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdNotBetween(String value1, String value2) {
            addCriterion("EMPLOYEE_ID not between", value1, value2, "employeeId");
            return (Criteria) this;
        }

        public Criteria andHsbcStaffIdIsNull() {
            addCriterion("HSBC_STAFF_ID is null");
            return (Criteria) this;
        }

        public Criteria andHsbcStaffIdIsNotNull() {
            addCriterion("HSBC_STAFF_ID is not null");
            return (Criteria) this;
        }

        public Criteria andHsbcStaffIdEqualTo(String value) {
            addCriterion("HSBC_STAFF_ID =", value, "hsbcStaffId");
            return (Criteria) this;
        }

        public Criteria andHsbcStaffIdNotEqualTo(String value) {
            addCriterion("HSBC_STAFF_ID <>", value, "hsbcStaffId");
            return (Criteria) this;
        }

        public Criteria andHsbcStaffIdGreaterThan(String value) {
            addCriterion("HSBC_STAFF_ID >", value, "hsbcStaffId");
            return (Criteria) this;
        }

        public Criteria andHsbcStaffIdGreaterThanOrEqualTo(String value) {
            addCriterion("HSBC_STAFF_ID >=", value, "hsbcStaffId");
            return (Criteria) this;
        }

        public Criteria andHsbcStaffIdLessThan(String value) {
            addCriterion("HSBC_STAFF_ID <", value, "hsbcStaffId");
            return (Criteria) this;
        }

        public Criteria andHsbcStaffIdLessThanOrEqualTo(String value) {
            addCriterion("HSBC_STAFF_ID <=", value, "hsbcStaffId");
            return (Criteria) this;
        }

        public Criteria andHsbcStaffIdLike(String value) {
            addCriterion("HSBC_STAFF_ID like", value, "hsbcStaffId");
            return (Criteria) this;
        }

        public Criteria andHsbcStaffIdNotLike(String value) {
            addCriterion("HSBC_STAFF_ID not like", value, "hsbcStaffId");
            return (Criteria) this;
        }

        public Criteria andHsbcStaffIdIn(List<String> values) {
            addCriterion("HSBC_STAFF_ID in", values, "hsbcStaffId");
            return (Criteria) this;
        }

        public Criteria andHsbcStaffIdNotIn(List<String> values) {
            addCriterion("HSBC_STAFF_ID not in", values, "hsbcStaffId");
            return (Criteria) this;
        }

        public Criteria andHsbcStaffIdBetween(String value1, String value2) {
            addCriterion("HSBC_STAFF_ID between", value1, value2, "hsbcStaffId");
            return (Criteria) this;
        }

        public Criteria andHsbcStaffIdNotBetween(String value1, String value2) {
            addCriterion("HSBC_STAFF_ID not between", value1, value2, "hsbcStaffId");
            return (Criteria) this;
        }

        public Criteria andLnIsNull() {
            addCriterion("LN is null");
            return (Criteria) this;
        }

        public Criteria andLnIsNotNull() {
            addCriterion("LN is not null");
            return (Criteria) this;
        }

        public Criteria andLnEqualTo(String value) {
            addCriterion("LN =", value, "ln");
            return (Criteria) this;
        }

        public Criteria andLnNotEqualTo(String value) {
            addCriterion("LN <>", value, "ln");
            return (Criteria) this;
        }

        public Criteria andLnGreaterThan(String value) {
            addCriterion("LN >", value, "ln");
            return (Criteria) this;
        }

        public Criteria andLnGreaterThanOrEqualTo(String value) {
            addCriterion("LN >=", value, "ln");
            return (Criteria) this;
        }

        public Criteria andLnLessThan(String value) {
            addCriterion("LN <", value, "ln");
            return (Criteria) this;
        }

        public Criteria andLnLessThanOrEqualTo(String value) {
            addCriterion("LN <=", value, "ln");
            return (Criteria) this;
        }

        public Criteria andLnLike(String value) {
            addCriterion("LN like", value, "ln");
            return (Criteria) this;
        }

        public Criteria andLnNotLike(String value) {
            addCriterion("LN not like", value, "ln");
            return (Criteria) this;
        }

        public Criteria andLnIn(List<String> values) {
            addCriterion("LN in", values, "ln");
            return (Criteria) this;
        }

        public Criteria andLnNotIn(List<String> values) {
            addCriterion("LN not in", values, "ln");
            return (Criteria) this;
        }

        public Criteria andLnBetween(String value1, String value2) {
            addCriterion("LN between", value1, value2, "ln");
            return (Criteria) this;
        }

        public Criteria andLnNotBetween(String value1, String value2) {
            addCriterion("LN not between", value1, value2, "ln");
            return (Criteria) this;
        }

        public Criteria andLocationTypeIsNull() {
            addCriterion("LOCATION_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andLocationTypeIsNotNull() {
            addCriterion("LOCATION_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andLocationTypeEqualTo(Integer value) {
            addCriterion("LOCATION_TYPE =", value, "locationType");
            return (Criteria) this;
        }

        public Criteria andLocationTypeNotEqualTo(Integer value) {
            addCriterion("LOCATION_TYPE <>", value, "locationType");
            return (Criteria) this;
        }

        public Criteria andLocationTypeGreaterThan(Integer value) {
            addCriterion("LOCATION_TYPE >", value, "locationType");
            return (Criteria) this;
        }

        public Criteria andLocationTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("LOCATION_TYPE >=", value, "locationType");
            return (Criteria) this;
        }

        public Criteria andLocationTypeLessThan(Integer value) {
            addCriterion("LOCATION_TYPE <", value, "locationType");
            return (Criteria) this;
        }

        public Criteria andLocationTypeLessThanOrEqualTo(Integer value) {
            addCriterion("LOCATION_TYPE <=", value, "locationType");
            return (Criteria) this;
        }

        public Criteria andLocationTypeIn(List<Integer> values) {
            addCriterion("LOCATION_TYPE in", values, "locationType");
            return (Criteria) this;
        }

        public Criteria andLocationTypeNotIn(List<Integer> values) {
            addCriterion("LOCATION_TYPE not in", values, "locationType");
            return (Criteria) this;
        }

        public Criteria andLocationTypeBetween(Integer value1, Integer value2) {
            addCriterion("LOCATION_TYPE between", value1, value2, "locationType");
            return (Criteria) this;
        }

        public Criteria andLocationTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("LOCATION_TYPE not between", value1, value2, "locationType");
            return (Criteria) this;
        }

        public Criteria andOnshoreOrOffshoreIsNull() {
            addCriterion("ONSHORE_OR_OFFSHORE is null");
            return (Criteria) this;
        }

        public Criteria andOnshoreOrOffshoreIsNotNull() {
            addCriterion("ONSHORE_OR_OFFSHORE is not null");
            return (Criteria) this;
        }

        public Criteria andOnshoreOrOffshoreEqualTo(Integer value) {
            addCriterion("ONSHORE_OR_OFFSHORE =", value, "onshoreOrOffshore");
            return (Criteria) this;
        }

        public Criteria andOnshoreOrOffshoreNotEqualTo(Integer value) {
            addCriterion("ONSHORE_OR_OFFSHORE <>", value, "onshoreOrOffshore");
            return (Criteria) this;
        }

        public Criteria andOnshoreOrOffshoreGreaterThan(Integer value) {
            addCriterion("ONSHORE_OR_OFFSHORE >", value, "onshoreOrOffshore");
            return (Criteria) this;
        }

        public Criteria andOnshoreOrOffshoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("ONSHORE_OR_OFFSHORE >=", value, "onshoreOrOffshore");
            return (Criteria) this;
        }

        public Criteria andOnshoreOrOffshoreLessThan(Integer value) {
            addCriterion("ONSHORE_OR_OFFSHORE <", value, "onshoreOrOffshore");
            return (Criteria) this;
        }

        public Criteria andOnshoreOrOffshoreLessThanOrEqualTo(Integer value) {
            addCriterion("ONSHORE_OR_OFFSHORE <=", value, "onshoreOrOffshore");
            return (Criteria) this;
        }

        public Criteria andOnshoreOrOffshoreIn(List<Integer> values) {
            addCriterion("ONSHORE_OR_OFFSHORE in", values, "onshoreOrOffshore");
            return (Criteria) this;
        }

        public Criteria andOnshoreOrOffshoreNotIn(List<Integer> values) {
            addCriterion("ONSHORE_OR_OFFSHORE not in", values, "onshoreOrOffshore");
            return (Criteria) this;
        }

        public Criteria andOnshoreOrOffshoreBetween(Integer value1, Integer value2) {
            addCriterion("ONSHORE_OR_OFFSHORE between", value1, value2, "onshoreOrOffshore");
            return (Criteria) this;
        }

        public Criteria andOnshoreOrOffshoreNotBetween(Integer value1, Integer value2) {
            addCriterion("ONSHORE_OR_OFFSHORE not between", value1, value2, "onshoreOrOffshore");
            return (Criteria) this;
        }

        public Criteria andGbGfIsNull() {
            addCriterion("GB_GF is null");
            return (Criteria) this;
        }

        public Criteria andGbGfIsNotNull() {
            addCriterion("GB_GF is not null");
            return (Criteria) this;
        }

        public Criteria andGbGfEqualTo(Integer value) {
            addCriterion("GB_GF =", value, "gbGf");
            return (Criteria) this;
        }

        public Criteria andGbGfNotEqualTo(Integer value) {
            addCriterion("GB_GF <>", value, "gbGf");
            return (Criteria) this;
        }

        public Criteria andGbGfGreaterThan(Integer value) {
            addCriterion("GB_GF >", value, "gbGf");
            return (Criteria) this;
        }

        public Criteria andGbGfGreaterThanOrEqualTo(Integer value) {
            addCriterion("GB_GF >=", value, "gbGf");
            return (Criteria) this;
        }

        public Criteria andGbGfLessThan(Integer value) {
            addCriterion("GB_GF <", value, "gbGf");
            return (Criteria) this;
        }

        public Criteria andGbGfLessThanOrEqualTo(Integer value) {
            addCriterion("GB_GF <=", value, "gbGf");
            return (Criteria) this;
        }

        public Criteria andGbGfIn(List<Integer> values) {
            addCriterion("GB_GF in", values, "gbGf");
            return (Criteria) this;
        }

        public Criteria andGbGfNotIn(List<Integer> values) {
            addCriterion("GB_GF not in", values, "gbGf");
            return (Criteria) this;
        }

        public Criteria andGbGfBetween(Integer value1, Integer value2) {
            addCriterion("GB_GF between", value1, value2, "gbGf");
            return (Criteria) this;
        }

        public Criteria andGbGfNotBetween(Integer value1, Integer value2) {
            addCriterion("GB_GF not between", value1, value2, "gbGf");
            return (Criteria) this;
        }

        public Criteria andHsbcSubdeptIdIsNull() {
            addCriterion("HSBC_SUBDEPT_ID is null");
            return (Criteria) this;
        }

        public Criteria andHsbcSubdeptIdIsNotNull() {
            addCriterion("HSBC_SUBDEPT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andHsbcSubdeptIdEqualTo(Integer value) {
            addCriterion("HSBC_SUBDEPT_ID =", value, "hsbcSubdeptId");
            return (Criteria) this;
        }

        public Criteria andHsbcSubdeptIdNotEqualTo(Integer value) {
            addCriterion("HSBC_SUBDEPT_ID <>", value, "hsbcSubdeptId");
            return (Criteria) this;
        }

        public Criteria andHsbcSubdeptIdGreaterThan(Integer value) {
            addCriterion("HSBC_SUBDEPT_ID >", value, "hsbcSubdeptId");
            return (Criteria) this;
        }

        public Criteria andHsbcSubdeptIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("HSBC_SUBDEPT_ID >=", value, "hsbcSubdeptId");
            return (Criteria) this;
        }

        public Criteria andHsbcSubdeptIdLessThan(Integer value) {
            addCriterion("HSBC_SUBDEPT_ID <", value, "hsbcSubdeptId");
            return (Criteria) this;
        }

        public Criteria andHsbcSubdeptIdLessThanOrEqualTo(Integer value) {
            addCriterion("HSBC_SUBDEPT_ID <=", value, "hsbcSubdeptId");
            return (Criteria) this;
        }

        public Criteria andHsbcSubdeptIdIn(List<Integer> values) {
            addCriterion("HSBC_SUBDEPT_ID in", values, "hsbcSubdeptId");
            return (Criteria) this;
        }

        public Criteria andHsbcSubdeptIdNotIn(List<Integer> values) {
            addCriterion("HSBC_SUBDEPT_ID not in", values, "hsbcSubdeptId");
            return (Criteria) this;
        }

        public Criteria andHsbcSubdeptIdBetween(Integer value1, Integer value2) {
            addCriterion("HSBC_SUBDEPT_ID between", value1, value2, "hsbcSubdeptId");
            return (Criteria) this;
        }

        public Criteria andHsbcSubdeptIdNotBetween(Integer value1, Integer value2) {
            addCriterion("HSBC_SUBDEPT_ID not between", value1, value2, "hsbcSubdeptId");
            return (Criteria) this;
        }

        public Criteria andHsbcThridDeptIdIsNull() {
            addCriterion("HSBC_THRID_DEPT_ID is null");
            return (Criteria) this;
        }

        public Criteria andHsbcThridDeptIdIsNotNull() {
            addCriterion("HSBC_THRID_DEPT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andHsbcThridDeptIdEqualTo(Integer value) {
            addCriterion("HSBC_THRID_DEPT_ID =", value, "hsbcThridDeptId");
            return (Criteria) this;
        }

        public Criteria andHsbcThridDeptIdNotEqualTo(Integer value) {
            addCriterion("HSBC_THRID_DEPT_ID <>", value, "hsbcThridDeptId");
            return (Criteria) this;
        }

        public Criteria andHsbcThridDeptIdGreaterThan(Integer value) {
            addCriterion("HSBC_THRID_DEPT_ID >", value, "hsbcThridDeptId");
            return (Criteria) this;
        }

        public Criteria andHsbcThridDeptIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("HSBC_THRID_DEPT_ID >=", value, "hsbcThridDeptId");
            return (Criteria) this;
        }

        public Criteria andHsbcThridDeptIdLessThan(Integer value) {
            addCriterion("HSBC_THRID_DEPT_ID <", value, "hsbcThridDeptId");
            return (Criteria) this;
        }

        public Criteria andHsbcThridDeptIdLessThanOrEqualTo(Integer value) {
            addCriterion("HSBC_THRID_DEPT_ID <=", value, "hsbcThridDeptId");
            return (Criteria) this;
        }

        public Criteria andHsbcThridDeptIdIn(List<Integer> values) {
            addCriterion("HSBC_THRID_DEPT_ID in", values, "hsbcThridDeptId");
            return (Criteria) this;
        }

        public Criteria andHsbcThridDeptIdNotIn(List<Integer> values) {
            addCriterion("HSBC_THRID_DEPT_ID not in", values, "hsbcThridDeptId");
            return (Criteria) this;
        }

        public Criteria andHsbcThridDeptIdBetween(Integer value1, Integer value2) {
            addCriterion("HSBC_THRID_DEPT_ID between", value1, value2, "hsbcThridDeptId");
            return (Criteria) this;
        }

        public Criteria andHsbcThridDeptIdNotBetween(Integer value1, Integer value2) {
            addCriterion("HSBC_THRID_DEPT_ID not between", value1, value2, "hsbcThridDeptId");
            return (Criteria) this;
        }

        public Criteria andHsbcManagerIsNull() {
            addCriterion("HSBC_MANAGER is null");
            return (Criteria) this;
        }

        public Criteria andHsbcManagerIsNotNull() {
            addCriterion("HSBC_MANAGER is not null");
            return (Criteria) this;
        }

        public Criteria andHsbcManagerEqualTo(String value) {
            addCriterion("HSBC_MANAGER =", value, "hsbcManager");
            return (Criteria) this;
        }

        public Criteria andHsbcManagerNotEqualTo(String value) {
            addCriterion("HSBC_MANAGER <>", value, "hsbcManager");
            return (Criteria) this;
        }

        public Criteria andHsbcManagerGreaterThan(String value) {
            addCriterion("HSBC_MANAGER >", value, "hsbcManager");
            return (Criteria) this;
        }

        public Criteria andHsbcManagerGreaterThanOrEqualTo(String value) {
            addCriterion("HSBC_MANAGER >=", value, "hsbcManager");
            return (Criteria) this;
        }

        public Criteria andHsbcManagerLessThan(String value) {
            addCriterion("HSBC_MANAGER <", value, "hsbcManager");
            return (Criteria) this;
        }

        public Criteria andHsbcManagerLessThanOrEqualTo(String value) {
            addCriterion("HSBC_MANAGER <=", value, "hsbcManager");
            return (Criteria) this;
        }

        public Criteria andHsbcManagerLike(String value) {
            addCriterion("HSBC_MANAGER like", value, "hsbcManager");
            return (Criteria) this;
        }

        public Criteria andHsbcManagerNotLike(String value) {
            addCriterion("HSBC_MANAGER not like", value, "hsbcManager");
            return (Criteria) this;
        }

        public Criteria andHsbcManagerIn(List<String> values) {
            addCriterion("HSBC_MANAGER in", values, "hsbcManager");
            return (Criteria) this;
        }

        public Criteria andHsbcManagerNotIn(List<String> values) {
            addCriterion("HSBC_MANAGER not in", values, "hsbcManager");
            return (Criteria) this;
        }

        public Criteria andHsbcManagerBetween(String value1, String value2) {
            addCriterion("HSBC_MANAGER between", value1, value2, "hsbcManager");
            return (Criteria) this;
        }

        public Criteria andHsbcManagerNotBetween(String value1, String value2) {
            addCriterion("HSBC_MANAGER not between", value1, value2, "hsbcManager");
            return (Criteria) this;
        }

        public Criteria andSowIsNull() {
            addCriterion("SOW is null");
            return (Criteria) this;
        }

        public Criteria andSowIsNotNull() {
            addCriterion("SOW is not null");
            return (Criteria) this;
        }

        public Criteria andSowEqualTo(String value) {
            addCriterion("SOW =", value, "sow");
            return (Criteria) this;
        }

        public Criteria andSowNotEqualTo(String value) {
            addCriterion("SOW <>", value, "sow");
            return (Criteria) this;
        }

        public Criteria andSowGreaterThan(String value) {
            addCriterion("SOW >", value, "sow");
            return (Criteria) this;
        }

        public Criteria andSowGreaterThanOrEqualTo(String value) {
            addCriterion("SOW >=", value, "sow");
            return (Criteria) this;
        }

        public Criteria andSowLessThan(String value) {
            addCriterion("SOW <", value, "sow");
            return (Criteria) this;
        }

        public Criteria andSowLessThanOrEqualTo(String value) {
            addCriterion("SOW <=", value, "sow");
            return (Criteria) this;
        }

        public Criteria andSowLike(String value) {
            addCriterion("SOW like", value, "sow");
            return (Criteria) this;
        }

        public Criteria andSowNotLike(String value) {
            addCriterion("SOW not like", value, "sow");
            return (Criteria) this;
        }

        public Criteria andSowIn(List<String> values) {
            addCriterion("SOW in", values, "sow");
            return (Criteria) this;
        }

        public Criteria andSowNotIn(List<String> values) {
            addCriterion("SOW not in", values, "sow");
            return (Criteria) this;
        }

        public Criteria andSowBetween(String value1, String value2) {
            addCriterion("SOW between", value1, value2, "sow");
            return (Criteria) this;
        }

        public Criteria andSowNotBetween(String value1, String value2) {
            addCriterion("SOW not between", value1, value2, "sow");
            return (Criteria) this;
        }

        public Criteria andSowExpiredDateIsNull() {
            addCriterion("SOW_EXPIRED_DATE is null");
            return (Criteria) this;
        }

        public Criteria andSowExpiredDateIsNotNull() {
            addCriterion("SOW_EXPIRED_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andSowExpiredDateEqualTo(Date value) {
            addCriterionForJDBCDate("SOW_EXPIRED_DATE =", value, "sowExpiredDate");
            return (Criteria) this;
        }

        public Criteria andSowExpiredDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("SOW_EXPIRED_DATE <>", value, "sowExpiredDate");
            return (Criteria) this;
        }

        public Criteria andSowExpiredDateGreaterThan(Date value) {
            addCriterionForJDBCDate("SOW_EXPIRED_DATE >", value, "sowExpiredDate");
            return (Criteria) this;
        }

        public Criteria andSowExpiredDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("SOW_EXPIRED_DATE >=", value, "sowExpiredDate");
            return (Criteria) this;
        }

        public Criteria andSowExpiredDateLessThan(Date value) {
            addCriterionForJDBCDate("SOW_EXPIRED_DATE <", value, "sowExpiredDate");
            return (Criteria) this;
        }

        public Criteria andSowExpiredDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("SOW_EXPIRED_DATE <=", value, "sowExpiredDate");
            return (Criteria) this;
        }

        public Criteria andSowExpiredDateIn(List<Date> values) {
            addCriterionForJDBCDate("SOW_EXPIRED_DATE in", values, "sowExpiredDate");
            return (Criteria) this;
        }

        public Criteria andSowExpiredDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("SOW_EXPIRED_DATE not in", values, "sowExpiredDate");
            return (Criteria) this;
        }

        public Criteria andSowExpiredDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("SOW_EXPIRED_DATE between", value1, value2, "sowExpiredDate");
            return (Criteria) this;
        }

        public Criteria andSowExpiredDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("SOW_EXPIRED_DATE not between", value1, value2, "sowExpiredDate");
            return (Criteria) this;
        }

        public Criteria andHsbcDojIsNull() {
            addCriterion("HSBC_DOJ is null");
            return (Criteria) this;
        }

        public Criteria andHsbcDojIsNotNull() {
            addCriterion("HSBC_DOJ is not null");
            return (Criteria) this;
        }

        public Criteria andHsbcDojEqualTo(Date value) {
            addCriterionForJDBCDate("HSBC_DOJ =", value, "hsbcDoj");
            return (Criteria) this;
        }

        public Criteria andHsbcDojNotEqualTo(Date value) {
            addCriterionForJDBCDate("HSBC_DOJ <>", value, "hsbcDoj");
            return (Criteria) this;
        }

        public Criteria andHsbcDojGreaterThan(Date value) {
            addCriterionForJDBCDate("HSBC_DOJ >", value, "hsbcDoj");
            return (Criteria) this;
        }

        public Criteria andHsbcDojGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("HSBC_DOJ >=", value, "hsbcDoj");
            return (Criteria) this;
        }

        public Criteria andHsbcDojLessThan(Date value) {
            addCriterionForJDBCDate("HSBC_DOJ <", value, "hsbcDoj");
            return (Criteria) this;
        }

        public Criteria andHsbcDojLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("HSBC_DOJ <=", value, "hsbcDoj");
            return (Criteria) this;
        }

        public Criteria andHsbcDojIn(List<Date> values) {
            addCriterionForJDBCDate("HSBC_DOJ in", values, "hsbcDoj");
            return (Criteria) this;
        }

        public Criteria andHsbcDojNotIn(List<Date> values) {
            addCriterionForJDBCDate("HSBC_DOJ not in", values, "hsbcDoj");
            return (Criteria) this;
        }

        public Criteria andHsbcDojBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("HSBC_DOJ between", value1, value2, "hsbcDoj");
            return (Criteria) this;
        }

        public Criteria andHsbcDojNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("HSBC_DOJ not between", value1, value2, "hsbcDoj");
            return (Criteria) this;
        }

        public Criteria andHsbcPodIsNull() {
            addCriterion("HSBC_POD is null");
            return (Criteria) this;
        }

        public Criteria andHsbcPodIsNotNull() {
            addCriterion("HSBC_POD is not null");
            return (Criteria) this;
        }

        public Criteria andHsbcPodEqualTo(String value) {
            addCriterion("HSBC_POD =", value, "hsbcPod");
            return (Criteria) this;
        }

        public Criteria andHsbcPodNotEqualTo(String value) {
            addCriterion("HSBC_POD <>", value, "hsbcPod");
            return (Criteria) this;
        }

        public Criteria andHsbcPodGreaterThan(String value) {
            addCriterion("HSBC_POD >", value, "hsbcPod");
            return (Criteria) this;
        }

        public Criteria andHsbcPodGreaterThanOrEqualTo(String value) {
            addCriterion("HSBC_POD >=", value, "hsbcPod");
            return (Criteria) this;
        }

        public Criteria andHsbcPodLessThan(String value) {
            addCriterion("HSBC_POD <", value, "hsbcPod");
            return (Criteria) this;
        }

        public Criteria andHsbcPodLessThanOrEqualTo(String value) {
            addCriterion("HSBC_POD <=", value, "hsbcPod");
            return (Criteria) this;
        }

        public Criteria andHsbcPodLike(String value) {
            addCriterion("HSBC_POD like", value, "hsbcPod");
            return (Criteria) this;
        }

        public Criteria andHsbcPodNotLike(String value) {
            addCriterion("HSBC_POD not like", value, "hsbcPod");
            return (Criteria) this;
        }

        public Criteria andHsbcPodIn(List<String> values) {
            addCriterion("HSBC_POD in", values, "hsbcPod");
            return (Criteria) this;
        }

        public Criteria andHsbcPodNotIn(List<String> values) {
            addCriterion("HSBC_POD not in", values, "hsbcPod");
            return (Criteria) this;
        }

        public Criteria andHsbcPodBetween(String value1, String value2) {
            addCriterion("HSBC_POD between", value1, value2, "hsbcPod");
            return (Criteria) this;
        }

        public Criteria andHsbcPodNotBetween(String value1, String value2) {
            addCriterion("HSBC_POD not between", value1, value2, "hsbcPod");
            return (Criteria) this;
        }

        public Criteria andPodtlIsNull() {
            addCriterion("PODTL is null");
            return (Criteria) this;
        }

        public Criteria andPodtlIsNotNull() {
            addCriterion("PODTL is not null");
            return (Criteria) this;
        }

        public Criteria andPodtlEqualTo(Boolean value) {
            addCriterion("PODTL =", value, "podtl");
            return (Criteria) this;
        }

        public Criteria andPodtlNotEqualTo(Boolean value) {
            addCriterion("PODTL <>", value, "podtl");
            return (Criteria) this;
        }

        public Criteria andPodtlGreaterThan(Boolean value) {
            addCriterion("PODTL >", value, "podtl");
            return (Criteria) this;
        }

        public Criteria andPodtlGreaterThanOrEqualTo(Boolean value) {
            addCriterion("PODTL >=", value, "podtl");
            return (Criteria) this;
        }

        public Criteria andPodtlLessThan(Boolean value) {
            addCriterion("PODTL <", value, "podtl");
            return (Criteria) this;
        }

        public Criteria andPodtlLessThanOrEqualTo(Boolean value) {
            addCriterion("PODTL <=", value, "podtl");
            return (Criteria) this;
        }

        public Criteria andPodtlIn(List<Boolean> values) {
            addCriterion("PODTL in", values, "podtl");
            return (Criteria) this;
        }

        public Criteria andPodtlNotIn(List<Boolean> values) {
            addCriterion("PODTL not in", values, "podtl");
            return (Criteria) this;
        }

        public Criteria andPodtlBetween(Boolean value1, Boolean value2) {
            addCriterion("PODTL between", value1, value2, "podtl");
            return (Criteria) this;
        }

        public Criteria andPodtlNotBetween(Boolean value1, Boolean value2) {
            addCriterion("PODTL not between", value1, value2, "podtl");
            return (Criteria) this;
        }

        public Criteria andTlTypeIsNull() {
            addCriterion("TL_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTlTypeIsNotNull() {
            addCriterion("TL_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTlTypeEqualTo(Integer value) {
            addCriterion("TL_TYPE =", value, "tlType");
            return (Criteria) this;
        }

        public Criteria andTlTypeNotEqualTo(Integer value) {
            addCriterion("TL_TYPE <>", value, "tlType");
            return (Criteria) this;
        }

        public Criteria andTlTypeGreaterThan(Integer value) {
            addCriterion("TL_TYPE >", value, "tlType");
            return (Criteria) this;
        }

        public Criteria andTlTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("TL_TYPE >=", value, "tlType");
            return (Criteria) this;
        }

        public Criteria andTlTypeLessThan(Integer value) {
            addCriterion("TL_TYPE <", value, "tlType");
            return (Criteria) this;
        }

        public Criteria andTlTypeLessThanOrEqualTo(Integer value) {
            addCriterion("TL_TYPE <=", value, "tlType");
            return (Criteria) this;
        }

        public Criteria andTlTypeIn(List<Integer> values) {
            addCriterion("TL_TYPE in", values, "tlType");
            return (Criteria) this;
        }

        public Criteria andTlTypeNotIn(List<Integer> values) {
            addCriterion("TL_TYPE not in", values, "tlType");
            return (Criteria) this;
        }

        public Criteria andTlTypeBetween(Integer value1, Integer value2) {
            addCriterion("TL_TYPE between", value1, value2, "tlType");
            return (Criteria) this;
        }

        public Criteria andTlTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("TL_TYPE not between", value1, value2, "tlType");
            return (Criteria) this;
        }

        public Criteria andHsbcProjectNameIsNull() {
            addCriterion("HSBC_PROJECT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andHsbcProjectNameIsNotNull() {
            addCriterion("HSBC_PROJECT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andHsbcProjectNameEqualTo(String value) {
            addCriterion("HSBC_PROJECT_NAME =", value, "hsbcProjectName");
            return (Criteria) this;
        }

        public Criteria andHsbcProjectNameNotEqualTo(String value) {
            addCriterion("HSBC_PROJECT_NAME <>", value, "hsbcProjectName");
            return (Criteria) this;
        }

        public Criteria andHsbcProjectNameGreaterThan(String value) {
            addCriterion("HSBC_PROJECT_NAME >", value, "hsbcProjectName");
            return (Criteria) this;
        }

        public Criteria andHsbcProjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("HSBC_PROJECT_NAME >=", value, "hsbcProjectName");
            return (Criteria) this;
        }

        public Criteria andHsbcProjectNameLessThan(String value) {
            addCriterion("HSBC_PROJECT_NAME <", value, "hsbcProjectName");
            return (Criteria) this;
        }

        public Criteria andHsbcProjectNameLessThanOrEqualTo(String value) {
            addCriterion("HSBC_PROJECT_NAME <=", value, "hsbcProjectName");
            return (Criteria) this;
        }

        public Criteria andHsbcProjectNameLike(String value) {
            addCriterion("HSBC_PROJECT_NAME like", value, "hsbcProjectName");
            return (Criteria) this;
        }

        public Criteria andHsbcProjectNameNotLike(String value) {
            addCriterion("HSBC_PROJECT_NAME not like", value, "hsbcProjectName");
            return (Criteria) this;
        }

        public Criteria andHsbcProjectNameIn(List<String> values) {
            addCriterion("HSBC_PROJECT_NAME in", values, "hsbcProjectName");
            return (Criteria) this;
        }

        public Criteria andHsbcProjectNameNotIn(List<String> values) {
            addCriterion("HSBC_PROJECT_NAME not in", values, "hsbcProjectName");
            return (Criteria) this;
        }

        public Criteria andHsbcProjectNameBetween(String value1, String value2) {
            addCriterion("HSBC_PROJECT_NAME between", value1, value2, "hsbcProjectName");
            return (Criteria) this;
        }

        public Criteria andHsbcProjectNameNotBetween(String value1, String value2) {
            addCriterion("HSBC_PROJECT_NAME not between", value1, value2, "hsbcProjectName");
            return (Criteria) this;
        }

        public Criteria andStaffCategoryIsNull() {
            addCriterion("STAFF_CATEGORY is null");
            return (Criteria) this;
        }

        public Criteria andStaffCategoryIsNotNull() {
            addCriterion("STAFF_CATEGORY is not null");
            return (Criteria) this;
        }

        public Criteria andStaffCategoryEqualTo(String value) {
            addCriterion("STAFF_CATEGORY =", value, "staffCategory");
            return (Criteria) this;
        }

        public Criteria andStaffCategoryNotEqualTo(String value) {
            addCriterion("STAFF_CATEGORY <>", value, "staffCategory");
            return (Criteria) this;
        }

        public Criteria andStaffCategoryGreaterThan(String value) {
            addCriterion("STAFF_CATEGORY >", value, "staffCategory");
            return (Criteria) this;
        }

        public Criteria andStaffCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("STAFF_CATEGORY >=", value, "staffCategory");
            return (Criteria) this;
        }

        public Criteria andStaffCategoryLessThan(String value) {
            addCriterion("STAFF_CATEGORY <", value, "staffCategory");
            return (Criteria) this;
        }

        public Criteria andStaffCategoryLessThanOrEqualTo(String value) {
            addCriterion("STAFF_CATEGORY <=", value, "staffCategory");
            return (Criteria) this;
        }

        public Criteria andStaffCategoryLike(String value) {
            addCriterion("STAFF_CATEGORY like", value, "staffCategory");
            return (Criteria) this;
        }

        public Criteria andStaffCategoryNotLike(String value) {
            addCriterion("STAFF_CATEGORY not like", value, "staffCategory");
            return (Criteria) this;
        }

        public Criteria andStaffCategoryIn(List<String> values) {
            addCriterion("STAFF_CATEGORY in", values, "staffCategory");
            return (Criteria) this;
        }

        public Criteria andStaffCategoryNotIn(List<String> values) {
            addCriterion("STAFF_CATEGORY not in", values, "staffCategory");
            return (Criteria) this;
        }

        public Criteria andStaffCategoryBetween(String value1, String value2) {
            addCriterion("STAFF_CATEGORY between", value1, value2, "staffCategory");
            return (Criteria) this;
        }

        public Criteria andStaffCategoryNotBetween(String value1, String value2) {
            addCriterion("STAFF_CATEGORY not between", value1, value2, "staffCategory");
            return (Criteria) this;
        }

        public Criteria andMentionLwdIsNull() {
            addCriterion("MENTION_LWD is null");
            return (Criteria) this;
        }

        public Criteria andMentionLwdIsNotNull() {
            addCriterion("MENTION_LWD is not null");
            return (Criteria) this;
        }

        public Criteria andMentionLwdEqualTo(Date value) {
            addCriterionForJDBCDate("MENTION_LWD =", value, "mentionLwd");
            return (Criteria) this;
        }

        public Criteria andMentionLwdNotEqualTo(Date value) {
            addCriterionForJDBCDate("MENTION_LWD <>", value, "mentionLwd");
            return (Criteria) this;
        }

        public Criteria andMentionLwdGreaterThan(Date value) {
            addCriterionForJDBCDate("MENTION_LWD >", value, "mentionLwd");
            return (Criteria) this;
        }

        public Criteria andMentionLwdGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("MENTION_LWD >=", value, "mentionLwd");
            return (Criteria) this;
        }

        public Criteria andMentionLwdLessThan(Date value) {
            addCriterionForJDBCDate("MENTION_LWD <", value, "mentionLwd");
            return (Criteria) this;
        }

        public Criteria andMentionLwdLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("MENTION_LWD <=", value, "mentionLwd");
            return (Criteria) this;
        }

        public Criteria andMentionLwdIn(List<Date> values) {
            addCriterionForJDBCDate("MENTION_LWD in", values, "mentionLwd");
            return (Criteria) this;
        }

        public Criteria andMentionLwdNotIn(List<Date> values) {
            addCriterionForJDBCDate("MENTION_LWD not in", values, "mentionLwd");
            return (Criteria) this;
        }

        public Criteria andMentionLwdBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("MENTION_LWD between", value1, value2, "mentionLwd");
            return (Criteria) this;
        }

        public Criteria andMentionLwdNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("MENTION_LWD not between", value1, value2, "mentionLwd");
            return (Criteria) this;
        }

        public Criteria andMsaRoleIsNull() {
            addCriterion("MSA_ROLE is null");
            return (Criteria) this;
        }

        public Criteria andMsaRoleIsNotNull() {
            addCriterion("MSA_ROLE is not null");
            return (Criteria) this;
        }

        public Criteria andMsaRoleEqualTo(Integer value) {
            addCriterion("MSA_ROLE =", value, "msaRole");
            return (Criteria) this;
        }

        public Criteria andMsaRoleNotEqualTo(Integer value) {
            addCriterion("MSA_ROLE <>", value, "msaRole");
            return (Criteria) this;
        }

        public Criteria andMsaRoleGreaterThan(Integer value) {
            addCriterion("MSA_ROLE >", value, "msaRole");
            return (Criteria) this;
        }

        public Criteria andMsaRoleGreaterThanOrEqualTo(Integer value) {
            addCriterion("MSA_ROLE >=", value, "msaRole");
            return (Criteria) this;
        }

        public Criteria andMsaRoleLessThan(Integer value) {
            addCriterion("MSA_ROLE <", value, "msaRole");
            return (Criteria) this;
        }

        public Criteria andMsaRoleLessThanOrEqualTo(Integer value) {
            addCriterion("MSA_ROLE <=", value, "msaRole");
            return (Criteria) this;
        }

        public Criteria andMsaRoleIn(List<Integer> values) {
            addCriterion("MSA_ROLE in", values, "msaRole");
            return (Criteria) this;
        }

        public Criteria andMsaRoleNotIn(List<Integer> values) {
            addCriterion("MSA_ROLE not in", values, "msaRole");
            return (Criteria) this;
        }

        public Criteria andMsaRoleBetween(Integer value1, Integer value2) {
            addCriterion("MSA_ROLE between", value1, value2, "msaRole");
            return (Criteria) this;
        }

        public Criteria andMsaRoleNotBetween(Integer value1, Integer value2) {
            addCriterion("MSA_ROLE not between", value1, value2, "msaRole");
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
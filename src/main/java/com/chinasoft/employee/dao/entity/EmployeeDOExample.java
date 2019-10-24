package com.chinasoft.employee.dao.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class EmployeeDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EmployeeDOExample() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("USER_ID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("USER_ID <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("USER_ID >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("USER_ID >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("USER_ID <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("USER_ID <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("USER_ID like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("USER_ID not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("USER_ID in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("USER_ID not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("USER_ID between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("USER_ID not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andEHrIsNull() {
            addCriterion("E_HR is null");
            return (Criteria) this;
        }

        public Criteria andEHrIsNotNull() {
            addCriterion("E_HR is not null");
            return (Criteria) this;
        }

        public Criteria andEHrEqualTo(String value) {
            addCriterion("E_HR =", value, "eHr");
            return (Criteria) this;
        }

        public Criteria andEHrNotEqualTo(String value) {
            addCriterion("E_HR <>", value, "eHr");
            return (Criteria) this;
        }

        public Criteria andEHrGreaterThan(String value) {
            addCriterion("E_HR >", value, "eHr");
            return (Criteria) this;
        }

        public Criteria andEHrGreaterThanOrEqualTo(String value) {
            addCriterion("E_HR >=", value, "eHr");
            return (Criteria) this;
        }

        public Criteria andEHrLessThan(String value) {
            addCriterion("E_HR <", value, "eHr");
            return (Criteria) this;
        }

        public Criteria andEHrLessThanOrEqualTo(String value) {
            addCriterion("E_HR <=", value, "eHr");
            return (Criteria) this;
        }

        public Criteria andEHrLike(String value) {
            addCriterion("E_HR like", value, "eHr");
            return (Criteria) this;
        }

        public Criteria andEHrNotLike(String value) {
            addCriterion("E_HR not like", value, "eHr");
            return (Criteria) this;
        }

        public Criteria andEHrIn(List<String> values) {
            addCriterion("E_HR in", values, "eHr");
            return (Criteria) this;
        }

        public Criteria andEHrNotIn(List<String> values) {
            addCriterion("E_HR not in", values, "eHr");
            return (Criteria) this;
        }

        public Criteria andEHrBetween(String value1, String value2) {
            addCriterion("E_HR between", value1, value2, "eHr");
            return (Criteria) this;
        }

        public Criteria andEHrNotBetween(String value1, String value2) {
            addCriterion("E_HR not between", value1, value2, "eHr");
            return (Criteria) this;
        }

        public Criteria andLobIsNull() {
            addCriterion("LOB is null");
            return (Criteria) this;
        }

        public Criteria andLobIsNotNull() {
            addCriterion("LOB is not null");
            return (Criteria) this;
        }

        public Criteria andLobEqualTo(String value) {
            addCriterion("LOB =", value, "lob");
            return (Criteria) this;
        }

        public Criteria andLobNotEqualTo(String value) {
            addCriterion("LOB <>", value, "lob");
            return (Criteria) this;
        }

        public Criteria andLobGreaterThan(String value) {
            addCriterion("LOB >", value, "lob");
            return (Criteria) this;
        }

        public Criteria andLobGreaterThanOrEqualTo(String value) {
            addCriterion("LOB >=", value, "lob");
            return (Criteria) this;
        }

        public Criteria andLobLessThan(String value) {
            addCriterion("LOB <", value, "lob");
            return (Criteria) this;
        }

        public Criteria andLobLessThanOrEqualTo(String value) {
            addCriterion("LOB <=", value, "lob");
            return (Criteria) this;
        }

        public Criteria andLobLike(String value) {
            addCriterion("LOB like", value, "lob");
            return (Criteria) this;
        }

        public Criteria andLobNotLike(String value) {
            addCriterion("LOB not like", value, "lob");
            return (Criteria) this;
        }

        public Criteria andLobIn(List<String> values) {
            addCriterion("LOB in", values, "lob");
            return (Criteria) this;
        }

        public Criteria andLobNotIn(List<String> values) {
            addCriterion("LOB not in", values, "lob");
            return (Criteria) this;
        }

        public Criteria andLobBetween(String value1, String value2) {
            addCriterion("LOB between", value1, value2, "lob");
            return (Criteria) this;
        }

        public Criteria andLobNotBetween(String value1, String value2) {
            addCriterion("LOB not between", value1, value2, "lob");
            return (Criteria) this;
        }

        public Criteria andStaffNameIsNull() {
            addCriterion("STAFF_NAME is null");
            return (Criteria) this;
        }

        public Criteria andStaffNameIsNotNull() {
            addCriterion("STAFF_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andStaffNameEqualTo(String value) {
            addCriterion("STAFF_NAME =", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameNotEqualTo(String value) {
            addCriterion("STAFF_NAME <>", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameGreaterThan(String value) {
            addCriterion("STAFF_NAME >", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameGreaterThanOrEqualTo(String value) {
            addCriterion("STAFF_NAME >=", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameLessThan(String value) {
            addCriterion("STAFF_NAME <", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameLessThanOrEqualTo(String value) {
            addCriterion("STAFF_NAME <=", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameLike(String value) {
            addCriterion("STAFF_NAME like", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameNotLike(String value) {
            addCriterion("STAFF_NAME not like", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameIn(List<String> values) {
            addCriterion("STAFF_NAME in", values, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameNotIn(List<String> values) {
            addCriterion("STAFF_NAME not in", values, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameBetween(String value1, String value2) {
            addCriterion("STAFF_NAME between", value1, value2, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameNotBetween(String value1, String value2) {
            addCriterion("STAFF_NAME not between", value1, value2, "staffName");
            return (Criteria) this;
        }

        public Criteria andRmUserIdIsNull() {
            addCriterion("RM_USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andRmUserIdIsNotNull() {
            addCriterion("RM_USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRmUserIdEqualTo(String value) {
            addCriterion("RM_USER_ID =", value, "rmUserId");
            return (Criteria) this;
        }

        public Criteria andRmUserIdNotEqualTo(String value) {
            addCriterion("RM_USER_ID <>", value, "rmUserId");
            return (Criteria) this;
        }

        public Criteria andRmUserIdGreaterThan(String value) {
            addCriterion("RM_USER_ID >", value, "rmUserId");
            return (Criteria) this;
        }

        public Criteria andRmUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("RM_USER_ID >=", value, "rmUserId");
            return (Criteria) this;
        }

        public Criteria andRmUserIdLessThan(String value) {
            addCriterion("RM_USER_ID <", value, "rmUserId");
            return (Criteria) this;
        }

        public Criteria andRmUserIdLessThanOrEqualTo(String value) {
            addCriterion("RM_USER_ID <=", value, "rmUserId");
            return (Criteria) this;
        }

        public Criteria andRmUserIdLike(String value) {
            addCriterion("RM_USER_ID like", value, "rmUserId");
            return (Criteria) this;
        }

        public Criteria andRmUserIdNotLike(String value) {
            addCriterion("RM_USER_ID not like", value, "rmUserId");
            return (Criteria) this;
        }

        public Criteria andRmUserIdIn(List<String> values) {
            addCriterion("RM_USER_ID in", values, "rmUserId");
            return (Criteria) this;
        }

        public Criteria andRmUserIdNotIn(List<String> values) {
            addCriterion("RM_USER_ID not in", values, "rmUserId");
            return (Criteria) this;
        }

        public Criteria andRmUserIdBetween(String value1, String value2) {
            addCriterion("RM_USER_ID between", value1, value2, "rmUserId");
            return (Criteria) this;
        }

        public Criteria andRmUserIdNotBetween(String value1, String value2) {
            addCriterion("RM_USER_ID not between", value1, value2, "rmUserId");
            return (Criteria) this;
        }

        public Criteria andStaffRegionIsNull() {
            addCriterion("STAFF_REGION is null");
            return (Criteria) this;
        }

        public Criteria andStaffRegionIsNotNull() {
            addCriterion("STAFF_REGION is not null");
            return (Criteria) this;
        }

        public Criteria andStaffRegionEqualTo(Integer value) {
            addCriterion("STAFF_REGION =", value, "staffRegion");
            return (Criteria) this;
        }

        public Criteria andStaffRegionNotEqualTo(Integer value) {
            addCriterion("STAFF_REGION <>", value, "staffRegion");
            return (Criteria) this;
        }

        public Criteria andStaffRegionGreaterThan(Integer value) {
            addCriterion("STAFF_REGION >", value, "staffRegion");
            return (Criteria) this;
        }

        public Criteria andStaffRegionGreaterThanOrEqualTo(Integer value) {
            addCriterion("STAFF_REGION >=", value, "staffRegion");
            return (Criteria) this;
        }

        public Criteria andStaffRegionLessThan(Integer value) {
            addCriterion("STAFF_REGION <", value, "staffRegion");
            return (Criteria) this;
        }

        public Criteria andStaffRegionLessThanOrEqualTo(Integer value) {
            addCriterion("STAFF_REGION <=", value, "staffRegion");
            return (Criteria) this;
        }

        public Criteria andStaffRegionIn(List<Integer> values) {
            addCriterion("STAFF_REGION in", values, "staffRegion");
            return (Criteria) this;
        }

        public Criteria andStaffRegionNotIn(List<Integer> values) {
            addCriterion("STAFF_REGION not in", values, "staffRegion");
            return (Criteria) this;
        }

        public Criteria andStaffRegionBetween(Integer value1, Integer value2) {
            addCriterion("STAFF_REGION between", value1, value2, "staffRegion");
            return (Criteria) this;
        }

        public Criteria andStaffRegionNotBetween(Integer value1, Integer value2) {
            addCriterion("STAFF_REGION not between", value1, value2, "staffRegion");
            return (Criteria) this;
        }

        public Criteria andStaffLocationIsNull() {
            addCriterion("STAFF_LOCATION is null");
            return (Criteria) this;
        }

        public Criteria andStaffLocationIsNotNull() {
            addCriterion("STAFF_LOCATION is not null");
            return (Criteria) this;
        }

        public Criteria andStaffLocationEqualTo(Integer value) {
            addCriterion("STAFF_LOCATION =", value, "staffLocation");
            return (Criteria) this;
        }

        public Criteria andStaffLocationNotEqualTo(Integer value) {
            addCriterion("STAFF_LOCATION <>", value, "staffLocation");
            return (Criteria) this;
        }

        public Criteria andStaffLocationGreaterThan(Integer value) {
            addCriterion("STAFF_LOCATION >", value, "staffLocation");
            return (Criteria) this;
        }

        public Criteria andStaffLocationGreaterThanOrEqualTo(Integer value) {
            addCriterion("STAFF_LOCATION >=", value, "staffLocation");
            return (Criteria) this;
        }

        public Criteria andStaffLocationLessThan(Integer value) {
            addCriterion("STAFF_LOCATION <", value, "staffLocation");
            return (Criteria) this;
        }

        public Criteria andStaffLocationLessThanOrEqualTo(Integer value) {
            addCriterion("STAFF_LOCATION <=", value, "staffLocation");
            return (Criteria) this;
        }

        public Criteria andStaffLocationIn(List<Integer> values) {
            addCriterion("STAFF_LOCATION in", values, "staffLocation");
            return (Criteria) this;
        }

        public Criteria andStaffLocationNotIn(List<Integer> values) {
            addCriterion("STAFF_LOCATION not in", values, "staffLocation");
            return (Criteria) this;
        }

        public Criteria andStaffLocationBetween(Integer value1, Integer value2) {
            addCriterion("STAFF_LOCATION between", value1, value2, "staffLocation");
            return (Criteria) this;
        }

        public Criteria andStaffLocationNotBetween(Integer value1, Integer value2) {
            addCriterion("STAFF_LOCATION not between", value1, value2, "staffLocation");
            return (Criteria) this;
        }

        public Criteria andRoleIsNull() {
            addCriterion("ROLE is null");
            return (Criteria) this;
        }

        public Criteria andRoleIsNotNull() {
            addCriterion("ROLE is not null");
            return (Criteria) this;
        }

        public Criteria andRoleEqualTo(Integer value) {
            addCriterion("ROLE =", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotEqualTo(Integer value) {
            addCriterion("ROLE <>", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleGreaterThan(Integer value) {
            addCriterion("ROLE >", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleGreaterThanOrEqualTo(Integer value) {
            addCriterion("ROLE >=", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleLessThan(Integer value) {
            addCriterion("ROLE <", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleLessThanOrEqualTo(Integer value) {
            addCriterion("ROLE <=", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleIn(List<Integer> values) {
            addCriterion("ROLE in", values, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotIn(List<Integer> values) {
            addCriterion("ROLE not in", values, "role");
            return (Criteria) this;
        }

        public Criteria andRoleBetween(Integer value1, Integer value2) {
            addCriterion("ROLE between", value1, value2, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotBetween(Integer value1, Integer value2) {
            addCriterion("ROLE not between", value1, value2, "role");
            return (Criteria) this;
        }

        public Criteria andSkillIsNull() {
            addCriterion("SKILL is null");
            return (Criteria) this;
        }

        public Criteria andSkillIsNotNull() {
            addCriterion("SKILL is not null");
            return (Criteria) this;
        }

        public Criteria andSkillEqualTo(Integer value) {
            addCriterion("SKILL =", value, "skill");
            return (Criteria) this;
        }

        public Criteria andSkillNotEqualTo(Integer value) {
            addCriterion("SKILL <>", value, "skill");
            return (Criteria) this;
        }

        public Criteria andSkillGreaterThan(Integer value) {
            addCriterion("SKILL >", value, "skill");
            return (Criteria) this;
        }

        public Criteria andSkillGreaterThanOrEqualTo(Integer value) {
            addCriterion("SKILL >=", value, "skill");
            return (Criteria) this;
        }

        public Criteria andSkillLessThan(Integer value) {
            addCriterion("SKILL <", value, "skill");
            return (Criteria) this;
        }

        public Criteria andSkillLessThanOrEqualTo(Integer value) {
            addCriterion("SKILL <=", value, "skill");
            return (Criteria) this;
        }

        public Criteria andSkillIn(List<Integer> values) {
            addCriterion("SKILL in", values, "skill");
            return (Criteria) this;
        }

        public Criteria andSkillNotIn(List<Integer> values) {
            addCriterion("SKILL not in", values, "skill");
            return (Criteria) this;
        }

        public Criteria andSkillBetween(Integer value1, Integer value2) {
            addCriterion("SKILL between", value1, value2, "skill");
            return (Criteria) this;
        }

        public Criteria andSkillNotBetween(Integer value1, Integer value2) {
            addCriterion("SKILL not between", value1, value2, "skill");
            return (Criteria) this;
        }

        public Criteria andEngagementTypeIsNull() {
            addCriterion("ENGAGEMENT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andEngagementTypeIsNotNull() {
            addCriterion("ENGAGEMENT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andEngagementTypeEqualTo(Integer value) {
            addCriterion("ENGAGEMENT_TYPE =", value, "engagementType");
            return (Criteria) this;
        }

        public Criteria andEngagementTypeNotEqualTo(Integer value) {
            addCriterion("ENGAGEMENT_TYPE <>", value, "engagementType");
            return (Criteria) this;
        }

        public Criteria andEngagementTypeGreaterThan(Integer value) {
            addCriterion("ENGAGEMENT_TYPE >", value, "engagementType");
            return (Criteria) this;
        }

        public Criteria andEngagementTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("ENGAGEMENT_TYPE >=", value, "engagementType");
            return (Criteria) this;
        }

        public Criteria andEngagementTypeLessThan(Integer value) {
            addCriterion("ENGAGEMENT_TYPE <", value, "engagementType");
            return (Criteria) this;
        }

        public Criteria andEngagementTypeLessThanOrEqualTo(Integer value) {
            addCriterion("ENGAGEMENT_TYPE <=", value, "engagementType");
            return (Criteria) this;
        }

        public Criteria andEngagementTypeIn(List<Integer> values) {
            addCriterion("ENGAGEMENT_TYPE in", values, "engagementType");
            return (Criteria) this;
        }

        public Criteria andEngagementTypeNotIn(List<Integer> values) {
            addCriterion("ENGAGEMENT_TYPE not in", values, "engagementType");
            return (Criteria) this;
        }

        public Criteria andEngagementTypeBetween(Integer value1, Integer value2) {
            addCriterion("ENGAGEMENT_TYPE between", value1, value2, "engagementType");
            return (Criteria) this;
        }

        public Criteria andEngagementTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("ENGAGEMENT_TYPE not between", value1, value2, "engagementType");
            return (Criteria) this;
        }

        public Criteria andBillRateTypeIsNull() {
            addCriterion("BILL_RATE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andBillRateTypeIsNotNull() {
            addCriterion("BILL_RATE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andBillRateTypeEqualTo(Integer value) {
            addCriterion("BILL_RATE_TYPE =", value, "billRateType");
            return (Criteria) this;
        }

        public Criteria andBillRateTypeNotEqualTo(Integer value) {
            addCriterion("BILL_RATE_TYPE <>", value, "billRateType");
            return (Criteria) this;
        }

        public Criteria andBillRateTypeGreaterThan(Integer value) {
            addCriterion("BILL_RATE_TYPE >", value, "billRateType");
            return (Criteria) this;
        }

        public Criteria andBillRateTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("BILL_RATE_TYPE >=", value, "billRateType");
            return (Criteria) this;
        }

        public Criteria andBillRateTypeLessThan(Integer value) {
            addCriterion("BILL_RATE_TYPE <", value, "billRateType");
            return (Criteria) this;
        }

        public Criteria andBillRateTypeLessThanOrEqualTo(Integer value) {
            addCriterion("BILL_RATE_TYPE <=", value, "billRateType");
            return (Criteria) this;
        }

        public Criteria andBillRateTypeIn(List<Integer> values) {
            addCriterion("BILL_RATE_TYPE in", values, "billRateType");
            return (Criteria) this;
        }

        public Criteria andBillRateTypeNotIn(List<Integer> values) {
            addCriterion("BILL_RATE_TYPE not in", values, "billRateType");
            return (Criteria) this;
        }

        public Criteria andBillRateTypeBetween(Integer value1, Integer value2) {
            addCriterion("BILL_RATE_TYPE between", value1, value2, "billRateType");
            return (Criteria) this;
        }

        public Criteria andBillRateTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("BILL_RATE_TYPE not between", value1, value2, "billRateType");
            return (Criteria) this;
        }

        public Criteria andBillCurrencyIsNull() {
            addCriterion("BILL_CURRENCY is null");
            return (Criteria) this;
        }

        public Criteria andBillCurrencyIsNotNull() {
            addCriterion("BILL_CURRENCY is not null");
            return (Criteria) this;
        }

        public Criteria andBillCurrencyEqualTo(Integer value) {
            addCriterion("BILL_CURRENCY =", value, "billCurrency");
            return (Criteria) this;
        }

        public Criteria andBillCurrencyNotEqualTo(Integer value) {
            addCriterion("BILL_CURRENCY <>", value, "billCurrency");
            return (Criteria) this;
        }

        public Criteria andBillCurrencyGreaterThan(Integer value) {
            addCriterion("BILL_CURRENCY >", value, "billCurrency");
            return (Criteria) this;
        }

        public Criteria andBillCurrencyGreaterThanOrEqualTo(Integer value) {
            addCriterion("BILL_CURRENCY >=", value, "billCurrency");
            return (Criteria) this;
        }

        public Criteria andBillCurrencyLessThan(Integer value) {
            addCriterion("BILL_CURRENCY <", value, "billCurrency");
            return (Criteria) this;
        }

        public Criteria andBillCurrencyLessThanOrEqualTo(Integer value) {
            addCriterion("BILL_CURRENCY <=", value, "billCurrency");
            return (Criteria) this;
        }

        public Criteria andBillCurrencyIn(List<Integer> values) {
            addCriterion("BILL_CURRENCY in", values, "billCurrency");
            return (Criteria) this;
        }

        public Criteria andBillCurrencyNotIn(List<Integer> values) {
            addCriterion("BILL_CURRENCY not in", values, "billCurrency");
            return (Criteria) this;
        }

        public Criteria andBillCurrencyBetween(Integer value1, Integer value2) {
            addCriterion("BILL_CURRENCY between", value1, value2, "billCurrency");
            return (Criteria) this;
        }

        public Criteria andBillCurrencyNotBetween(Integer value1, Integer value2) {
            addCriterion("BILL_CURRENCY not between", value1, value2, "billCurrency");
            return (Criteria) this;
        }

        public Criteria andBillRateIsNull() {
            addCriterion("BILL_RATE is null");
            return (Criteria) this;
        }

        public Criteria andBillRateIsNotNull() {
            addCriterion("BILL_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andBillRateEqualTo(BigDecimal value) {
            addCriterion("BILL_RATE =", value, "billRate");
            return (Criteria) this;
        }

        public Criteria andBillRateNotEqualTo(BigDecimal value) {
            addCriterion("BILL_RATE <>", value, "billRate");
            return (Criteria) this;
        }

        public Criteria andBillRateGreaterThan(BigDecimal value) {
            addCriterion("BILL_RATE >", value, "billRate");
            return (Criteria) this;
        }

        public Criteria andBillRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BILL_RATE >=", value, "billRate");
            return (Criteria) this;
        }

        public Criteria andBillRateLessThan(BigDecimal value) {
            addCriterion("BILL_RATE <", value, "billRate");
            return (Criteria) this;
        }

        public Criteria andBillRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BILL_RATE <=", value, "billRate");
            return (Criteria) this;
        }

        public Criteria andBillRateIn(List<BigDecimal> values) {
            addCriterion("BILL_RATE in", values, "billRate");
            return (Criteria) this;
        }

        public Criteria andBillRateNotIn(List<BigDecimal> values) {
            addCriterion("BILL_RATE not in", values, "billRate");
            return (Criteria) this;
        }

        public Criteria andBillRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BILL_RATE between", value1, value2, "billRate");
            return (Criteria) this;
        }

        public Criteria andBillRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BILL_RATE not between", value1, value2, "billRate");
            return (Criteria) this;
        }

        public Criteria andEmployeeTypeIsNull() {
            addCriterion("EMPLOYEE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeTypeIsNotNull() {
            addCriterion("EMPLOYEE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeTypeEqualTo(Integer value) {
            addCriterion("EMPLOYEE_TYPE =", value, "employeeType");
            return (Criteria) this;
        }

        public Criteria andEmployeeTypeNotEqualTo(Integer value) {
            addCriterion("EMPLOYEE_TYPE <>", value, "employeeType");
            return (Criteria) this;
        }

        public Criteria andEmployeeTypeGreaterThan(Integer value) {
            addCriterion("EMPLOYEE_TYPE >", value, "employeeType");
            return (Criteria) this;
        }

        public Criteria andEmployeeTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("EMPLOYEE_TYPE >=", value, "employeeType");
            return (Criteria) this;
        }

        public Criteria andEmployeeTypeLessThan(Integer value) {
            addCriterion("EMPLOYEE_TYPE <", value, "employeeType");
            return (Criteria) this;
        }

        public Criteria andEmployeeTypeLessThanOrEqualTo(Integer value) {
            addCriterion("EMPLOYEE_TYPE <=", value, "employeeType");
            return (Criteria) this;
        }

        public Criteria andEmployeeTypeIn(List<Integer> values) {
            addCriterion("EMPLOYEE_TYPE in", values, "employeeType");
            return (Criteria) this;
        }

        public Criteria andEmployeeTypeNotIn(List<Integer> values) {
            addCriterion("EMPLOYEE_TYPE not in", values, "employeeType");
            return (Criteria) this;
        }

        public Criteria andEmployeeTypeBetween(Integer value1, Integer value2) {
            addCriterion("EMPLOYEE_TYPE between", value1, value2, "employeeType");
            return (Criteria) this;
        }

        public Criteria andEmployeeTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("EMPLOYEE_TYPE not between", value1, value2, "employeeType");
            return (Criteria) this;
        }

        public Criteria andResourceStatusIsNull() {
            addCriterion("RESOURCE_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andResourceStatusIsNotNull() {
            addCriterion("RESOURCE_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andResourceStatusEqualTo(Integer value) {
            addCriterion("RESOURCE_STATUS =", value, "resourceStatus");
            return (Criteria) this;
        }

        public Criteria andResourceStatusNotEqualTo(Integer value) {
            addCriterion("RESOURCE_STATUS <>", value, "resourceStatus");
            return (Criteria) this;
        }

        public Criteria andResourceStatusGreaterThan(Integer value) {
            addCriterion("RESOURCE_STATUS >", value, "resourceStatus");
            return (Criteria) this;
        }

        public Criteria andResourceStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("RESOURCE_STATUS >=", value, "resourceStatus");
            return (Criteria) this;
        }

        public Criteria andResourceStatusLessThan(Integer value) {
            addCriterion("RESOURCE_STATUS <", value, "resourceStatus");
            return (Criteria) this;
        }

        public Criteria andResourceStatusLessThanOrEqualTo(Integer value) {
            addCriterion("RESOURCE_STATUS <=", value, "resourceStatus");
            return (Criteria) this;
        }

        public Criteria andResourceStatusIn(List<Integer> values) {
            addCriterion("RESOURCE_STATUS in", values, "resourceStatus");
            return (Criteria) this;
        }

        public Criteria andResourceStatusNotIn(List<Integer> values) {
            addCriterion("RESOURCE_STATUS not in", values, "resourceStatus");
            return (Criteria) this;
        }

        public Criteria andResourceStatusBetween(Integer value1, Integer value2) {
            addCriterion("RESOURCE_STATUS between", value1, value2, "resourceStatus");
            return (Criteria) this;
        }

        public Criteria andResourceStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("RESOURCE_STATUS not between", value1, value2, "resourceStatus");
            return (Criteria) this;
        }

        public Criteria andGraduationDateIsNull() {
            addCriterion("GRADUATION_DATE is null");
            return (Criteria) this;
        }

        public Criteria andGraduationDateIsNotNull() {
            addCriterion("GRADUATION_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andGraduationDateEqualTo(Date value) {
            addCriterionForJDBCDate("GRADUATION_DATE =", value, "graduationDate");
            return (Criteria) this;
        }

        public Criteria andGraduationDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("GRADUATION_DATE <>", value, "graduationDate");
            return (Criteria) this;
        }

        public Criteria andGraduationDateGreaterThan(Date value) {
            addCriterionForJDBCDate("GRADUATION_DATE >", value, "graduationDate");
            return (Criteria) this;
        }

        public Criteria andGraduationDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("GRADUATION_DATE >=", value, "graduationDate");
            return (Criteria) this;
        }

        public Criteria andGraduationDateLessThan(Date value) {
            addCriterionForJDBCDate("GRADUATION_DATE <", value, "graduationDate");
            return (Criteria) this;
        }

        public Criteria andGraduationDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("GRADUATION_DATE <=", value, "graduationDate");
            return (Criteria) this;
        }

        public Criteria andGraduationDateIn(List<Date> values) {
            addCriterionForJDBCDate("GRADUATION_DATE in", values, "graduationDate");
            return (Criteria) this;
        }

        public Criteria andGraduationDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("GRADUATION_DATE not in", values, "graduationDate");
            return (Criteria) this;
        }

        public Criteria andGraduationDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("GRADUATION_DATE between", value1, value2, "graduationDate");
            return (Criteria) this;
        }

        public Criteria andGraduationDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("GRADUATION_DATE not between", value1, value2, "graduationDate");
            return (Criteria) this;
        }

        public Criteria andEntryDateIsNull() {
            addCriterion("ENTRY_DATE is null");
            return (Criteria) this;
        }

        public Criteria andEntryDateIsNotNull() {
            addCriterion("ENTRY_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andEntryDateEqualTo(Date value) {
            addCriterionForJDBCDate("ENTRY_DATE =", value, "entryDate");
            return (Criteria) this;
        }

        public Criteria andEntryDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("ENTRY_DATE <>", value, "entryDate");
            return (Criteria) this;
        }

        public Criteria andEntryDateGreaterThan(Date value) {
            addCriterionForJDBCDate("ENTRY_DATE >", value, "entryDate");
            return (Criteria) this;
        }

        public Criteria andEntryDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ENTRY_DATE >=", value, "entryDate");
            return (Criteria) this;
        }

        public Criteria andEntryDateLessThan(Date value) {
            addCriterionForJDBCDate("ENTRY_DATE <", value, "entryDate");
            return (Criteria) this;
        }

        public Criteria andEntryDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ENTRY_DATE <=", value, "entryDate");
            return (Criteria) this;
        }

        public Criteria andEntryDateIn(List<Date> values) {
            addCriterionForJDBCDate("ENTRY_DATE in", values, "entryDate");
            return (Criteria) this;
        }

        public Criteria andEntryDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("ENTRY_DATE not in", values, "entryDate");
            return (Criteria) this;
        }

        public Criteria andEntryDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ENTRY_DATE between", value1, value2, "entryDate");
            return (Criteria) this;
        }

        public Criteria andEntryDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ENTRY_DATE not between", value1, value2, "entryDate");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("Email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("Email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("Email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("Email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("Email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("Email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("Email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("Email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("Email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("Email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("Email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("Email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("Email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("Email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andCsiProNumberIsNull() {
            addCriterion("CSI_PRO_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andCsiProNumberIsNotNull() {
            addCriterion("CSI_PRO_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andCsiProNumberEqualTo(String value) {
            addCriterion("CSI_PRO_NUMBER =", value, "csiProNumber");
            return (Criteria) this;
        }

        public Criteria andCsiProNumberNotEqualTo(String value) {
            addCriterion("CSI_PRO_NUMBER <>", value, "csiProNumber");
            return (Criteria) this;
        }

        public Criteria andCsiProNumberGreaterThan(String value) {
            addCriterion("CSI_PRO_NUMBER >", value, "csiProNumber");
            return (Criteria) this;
        }

        public Criteria andCsiProNumberGreaterThanOrEqualTo(String value) {
            addCriterion("CSI_PRO_NUMBER >=", value, "csiProNumber");
            return (Criteria) this;
        }

        public Criteria andCsiProNumberLessThan(String value) {
            addCriterion("CSI_PRO_NUMBER <", value, "csiProNumber");
            return (Criteria) this;
        }

        public Criteria andCsiProNumberLessThanOrEqualTo(String value) {
            addCriterion("CSI_PRO_NUMBER <=", value, "csiProNumber");
            return (Criteria) this;
        }

        public Criteria andCsiProNumberLike(String value) {
            addCriterion("CSI_PRO_NUMBER like", value, "csiProNumber");
            return (Criteria) this;
        }

        public Criteria andCsiProNumberNotLike(String value) {
            addCriterion("CSI_PRO_NUMBER not like", value, "csiProNumber");
            return (Criteria) this;
        }

        public Criteria andCsiProNumberIn(List<String> values) {
            addCriterion("CSI_PRO_NUMBER in", values, "csiProNumber");
            return (Criteria) this;
        }

        public Criteria andCsiProNumberNotIn(List<String> values) {
            addCriterion("CSI_PRO_NUMBER not in", values, "csiProNumber");
            return (Criteria) this;
        }

        public Criteria andCsiProNumberBetween(String value1, String value2) {
            addCriterion("CSI_PRO_NUMBER between", value1, value2, "csiProNumber");
            return (Criteria) this;
        }

        public Criteria andCsiProNumberNotBetween(String value1, String value2) {
            addCriterion("CSI_PRO_NUMBER not between", value1, value2, "csiProNumber");
            return (Criteria) this;
        }

        public Criteria andCsiProStartdateIsNull() {
            addCriterion("CSI_PRO_STARTDATE is null");
            return (Criteria) this;
        }

        public Criteria andCsiProStartdateIsNotNull() {
            addCriterion("CSI_PRO_STARTDATE is not null");
            return (Criteria) this;
        }

        public Criteria andCsiProStartdateEqualTo(Date value) {
            addCriterionForJDBCDate("CSI_PRO_STARTDATE =", value, "csiProStartdate");
            return (Criteria) this;
        }

        public Criteria andCsiProStartdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("CSI_PRO_STARTDATE <>", value, "csiProStartdate");
            return (Criteria) this;
        }

        public Criteria andCsiProStartdateGreaterThan(Date value) {
            addCriterionForJDBCDate("CSI_PRO_STARTDATE >", value, "csiProStartdate");
            return (Criteria) this;
        }

        public Criteria andCsiProStartdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CSI_PRO_STARTDATE >=", value, "csiProStartdate");
            return (Criteria) this;
        }

        public Criteria andCsiProStartdateLessThan(Date value) {
            addCriterionForJDBCDate("CSI_PRO_STARTDATE <", value, "csiProStartdate");
            return (Criteria) this;
        }

        public Criteria andCsiProStartdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CSI_PRO_STARTDATE <=", value, "csiProStartdate");
            return (Criteria) this;
        }

        public Criteria andCsiProStartdateIn(List<Date> values) {
            addCriterionForJDBCDate("CSI_PRO_STARTDATE in", values, "csiProStartdate");
            return (Criteria) this;
        }

        public Criteria andCsiProStartdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("CSI_PRO_STARTDATE not in", values, "csiProStartdate");
            return (Criteria) this;
        }

        public Criteria andCsiProStartdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CSI_PRO_STARTDATE between", value1, value2, "csiProStartdate");
            return (Criteria) this;
        }

        public Criteria andCsiProStartdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CSI_PRO_STARTDATE not between", value1, value2, "csiProStartdate");
            return (Criteria) this;
        }

        public Criteria andCsiProNameIsNull() {
            addCriterion("CSI_PRO_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCsiProNameIsNotNull() {
            addCriterion("CSI_PRO_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCsiProNameEqualTo(String value) {
            addCriterion("CSI_PRO_NAME =", value, "csiProName");
            return (Criteria) this;
        }

        public Criteria andCsiProNameNotEqualTo(String value) {
            addCriterion("CSI_PRO_NAME <>", value, "csiProName");
            return (Criteria) this;
        }

        public Criteria andCsiProNameGreaterThan(String value) {
            addCriterion("CSI_PRO_NAME >", value, "csiProName");
            return (Criteria) this;
        }

        public Criteria andCsiProNameGreaterThanOrEqualTo(String value) {
            addCriterion("CSI_PRO_NAME >=", value, "csiProName");
            return (Criteria) this;
        }

        public Criteria andCsiProNameLessThan(String value) {
            addCriterion("CSI_PRO_NAME <", value, "csiProName");
            return (Criteria) this;
        }

        public Criteria andCsiProNameLessThanOrEqualTo(String value) {
            addCriterion("CSI_PRO_NAME <=", value, "csiProName");
            return (Criteria) this;
        }

        public Criteria andCsiProNameLike(String value) {
            addCriterion("CSI_PRO_NAME like", value, "csiProName");
            return (Criteria) this;
        }

        public Criteria andCsiProNameNotLike(String value) {
            addCriterion("CSI_PRO_NAME not like", value, "csiProName");
            return (Criteria) this;
        }

        public Criteria andCsiProNameIn(List<String> values) {
            addCriterion("CSI_PRO_NAME in", values, "csiProName");
            return (Criteria) this;
        }

        public Criteria andCsiProNameNotIn(List<String> values) {
            addCriterion("CSI_PRO_NAME not in", values, "csiProName");
            return (Criteria) this;
        }

        public Criteria andCsiProNameBetween(String value1, String value2) {
            addCriterion("CSI_PRO_NAME between", value1, value2, "csiProName");
            return (Criteria) this;
        }

        public Criteria andCsiProNameNotBetween(String value1, String value2) {
            addCriterion("CSI_PRO_NAME not between", value1, value2, "csiProName");
            return (Criteria) this;
        }

        public Criteria andItindustryWorkYearIsNull() {
            addCriterion("ITINDUSTRY_WORK_YEAR is null");
            return (Criteria) this;
        }

        public Criteria andItindustryWorkYearIsNotNull() {
            addCriterion("ITINDUSTRY_WORK_YEAR is not null");
            return (Criteria) this;
        }

        public Criteria andItindustryWorkYearEqualTo(BigDecimal value) {
            addCriterion("ITINDUSTRY_WORK_YEAR =", value, "itindustryWorkYear");
            return (Criteria) this;
        }

        public Criteria andItindustryWorkYearNotEqualTo(BigDecimal value) {
            addCriterion("ITINDUSTRY_WORK_YEAR <>", value, "itindustryWorkYear");
            return (Criteria) this;
        }

        public Criteria andItindustryWorkYearGreaterThan(BigDecimal value) {
            addCriterion("ITINDUSTRY_WORK_YEAR >", value, "itindustryWorkYear");
            return (Criteria) this;
        }

        public Criteria andItindustryWorkYearGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ITINDUSTRY_WORK_YEAR >=", value, "itindustryWorkYear");
            return (Criteria) this;
        }

        public Criteria andItindustryWorkYearLessThan(BigDecimal value) {
            addCriterion("ITINDUSTRY_WORK_YEAR <", value, "itindustryWorkYear");
            return (Criteria) this;
        }

        public Criteria andItindustryWorkYearLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ITINDUSTRY_WORK_YEAR <=", value, "itindustryWorkYear");
            return (Criteria) this;
        }

        public Criteria andItindustryWorkYearIn(List<BigDecimal> values) {
            addCriterion("ITINDUSTRY_WORK_YEAR in", values, "itindustryWorkYear");
            return (Criteria) this;
        }

        public Criteria andItindustryWorkYearNotIn(List<BigDecimal> values) {
            addCriterion("ITINDUSTRY_WORK_YEAR not in", values, "itindustryWorkYear");
            return (Criteria) this;
        }

        public Criteria andItindustryWorkYearBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ITINDUSTRY_WORK_YEAR between", value1, value2, "itindustryWorkYear");
            return (Criteria) this;
        }

        public Criteria andItindustryWorkYearNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ITINDUSTRY_WORK_YEAR not between", value1, value2, "itindustryWorkYear");
            return (Criteria) this;
        }

        public Criteria andTerminationDateIsNull() {
            addCriterion("TERMINATION_DATE is null");
            return (Criteria) this;
        }

        public Criteria andTerminationDateIsNotNull() {
            addCriterion("TERMINATION_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andTerminationDateEqualTo(Date value) {
            addCriterionForJDBCDate("TERMINATION_DATE =", value, "terminationDate");
            return (Criteria) this;
        }

        public Criteria andTerminationDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("TERMINATION_DATE <>", value, "terminationDate");
            return (Criteria) this;
        }

        public Criteria andTerminationDateGreaterThan(Date value) {
            addCriterionForJDBCDate("TERMINATION_DATE >", value, "terminationDate");
            return (Criteria) this;
        }

        public Criteria andTerminationDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("TERMINATION_DATE >=", value, "terminationDate");
            return (Criteria) this;
        }

        public Criteria andTerminationDateLessThan(Date value) {
            addCriterionForJDBCDate("TERMINATION_DATE <", value, "terminationDate");
            return (Criteria) this;
        }

        public Criteria andTerminationDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("TERMINATION_DATE <=", value, "terminationDate");
            return (Criteria) this;
        }

        public Criteria andTerminationDateIn(List<Date> values) {
            addCriterionForJDBCDate("TERMINATION_DATE in", values, "terminationDate");
            return (Criteria) this;
        }

        public Criteria andTerminationDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("TERMINATION_DATE not in", values, "terminationDate");
            return (Criteria) this;
        }

        public Criteria andTerminationDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("TERMINATION_DATE between", value1, value2, "terminationDate");
            return (Criteria) this;
        }

        public Criteria andTerminationDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("TERMINATION_DATE not between", value1, value2, "terminationDate");
            return (Criteria) this;
        }

        public Criteria andReasonForTerminationIsNull() {
            addCriterion("REASON_FOR_TERMINATION is null");
            return (Criteria) this;
        }

        public Criteria andReasonForTerminationIsNotNull() {
            addCriterion("REASON_FOR_TERMINATION is not null");
            return (Criteria) this;
        }

        public Criteria andReasonForTerminationEqualTo(String value) {
            addCriterion("REASON_FOR_TERMINATION =", value, "reasonForTermination");
            return (Criteria) this;
        }

        public Criteria andReasonForTerminationNotEqualTo(String value) {
            addCriterion("REASON_FOR_TERMINATION <>", value, "reasonForTermination");
            return (Criteria) this;
        }

        public Criteria andReasonForTerminationGreaterThan(String value) {
            addCriterion("REASON_FOR_TERMINATION >", value, "reasonForTermination");
            return (Criteria) this;
        }

        public Criteria andReasonForTerminationGreaterThanOrEqualTo(String value) {
            addCriterion("REASON_FOR_TERMINATION >=", value, "reasonForTermination");
            return (Criteria) this;
        }

        public Criteria andReasonForTerminationLessThan(String value) {
            addCriterion("REASON_FOR_TERMINATION <", value, "reasonForTermination");
            return (Criteria) this;
        }

        public Criteria andReasonForTerminationLessThanOrEqualTo(String value) {
            addCriterion("REASON_FOR_TERMINATION <=", value, "reasonForTermination");
            return (Criteria) this;
        }

        public Criteria andReasonForTerminationLike(String value) {
            addCriterion("REASON_FOR_TERMINATION like", value, "reasonForTermination");
            return (Criteria) this;
        }

        public Criteria andReasonForTerminationNotLike(String value) {
            addCriterion("REASON_FOR_TERMINATION not like", value, "reasonForTermination");
            return (Criteria) this;
        }

        public Criteria andReasonForTerminationIn(List<String> values) {
            addCriterion("REASON_FOR_TERMINATION in", values, "reasonForTermination");
            return (Criteria) this;
        }

        public Criteria andReasonForTerminationNotIn(List<String> values) {
            addCriterion("REASON_FOR_TERMINATION not in", values, "reasonForTermination");
            return (Criteria) this;
        }

        public Criteria andReasonForTerminationBetween(String value1, String value2) {
            addCriterion("REASON_FOR_TERMINATION between", value1, value2, "reasonForTermination");
            return (Criteria) this;
        }

        public Criteria andReasonForTerminationNotBetween(String value1, String value2) {
            addCriterion("REASON_FOR_TERMINATION not between", value1, value2, "reasonForTermination");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andBackboneIsNull() {
            addCriterion("BACKBONE is null");
            return (Criteria) this;
        }

        public Criteria andBackboneIsNotNull() {
            addCriterion("BACKBONE is not null");
            return (Criteria) this;
        }

        public Criteria andBackboneEqualTo(String value) {
            addCriterion("BACKBONE =", value, "backbone");
            return (Criteria) this;
        }

        public Criteria andBackboneNotEqualTo(String value) {
            addCriterion("BACKBONE <>", value, "backbone");
            return (Criteria) this;
        }

        public Criteria andBackboneGreaterThan(String value) {
            addCriterion("BACKBONE >", value, "backbone");
            return (Criteria) this;
        }

        public Criteria andBackboneGreaterThanOrEqualTo(String value) {
            addCriterion("BACKBONE >=", value, "backbone");
            return (Criteria) this;
        }

        public Criteria andBackboneLessThan(String value) {
            addCriterion("BACKBONE <", value, "backbone");
            return (Criteria) this;
        }

        public Criteria andBackboneLessThanOrEqualTo(String value) {
            addCriterion("BACKBONE <=", value, "backbone");
            return (Criteria) this;
        }

        public Criteria andBackboneLike(String value) {
            addCriterion("BACKBONE like", value, "backbone");
            return (Criteria) this;
        }

        public Criteria andBackboneNotLike(String value) {
            addCriterion("BACKBONE not like", value, "backbone");
            return (Criteria) this;
        }

        public Criteria andBackboneIn(List<String> values) {
            addCriterion("BACKBONE in", values, "backbone");
            return (Criteria) this;
        }

        public Criteria andBackboneNotIn(List<String> values) {
            addCriterion("BACKBONE not in", values, "backbone");
            return (Criteria) this;
        }

        public Criteria andBackboneBetween(String value1, String value2) {
            addCriterion("BACKBONE between", value1, value2, "backbone");
            return (Criteria) this;
        }

        public Criteria andBackboneNotBetween(String value1, String value2) {
            addCriterion("BACKBONE not between", value1, value2, "backbone");
            return (Criteria) this;
        }

        public Criteria andAssessedIsNull() {
            addCriterion("ASSESSED is null");
            return (Criteria) this;
        }

        public Criteria andAssessedIsNotNull() {
            addCriterion("ASSESSED is not null");
            return (Criteria) this;
        }

        public Criteria andAssessedEqualTo(Integer value) {
            addCriterion("ASSESSED =", value, "assessed");
            return (Criteria) this;
        }

        public Criteria andAssessedNotEqualTo(Integer value) {
            addCriterion("ASSESSED <>", value, "assessed");
            return (Criteria) this;
        }

        public Criteria andAssessedGreaterThan(Integer value) {
            addCriterion("ASSESSED >", value, "assessed");
            return (Criteria) this;
        }

        public Criteria andAssessedGreaterThanOrEqualTo(Integer value) {
            addCriterion("ASSESSED >=", value, "assessed");
            return (Criteria) this;
        }

        public Criteria andAssessedLessThan(Integer value) {
            addCriterion("ASSESSED <", value, "assessed");
            return (Criteria) this;
        }

        public Criteria andAssessedLessThanOrEqualTo(Integer value) {
            addCriterion("ASSESSED <=", value, "assessed");
            return (Criteria) this;
        }

        public Criteria andAssessedIn(List<Integer> values) {
            addCriterion("ASSESSED in", values, "assessed");
            return (Criteria) this;
        }

        public Criteria andAssessedNotIn(List<Integer> values) {
            addCriterion("ASSESSED not in", values, "assessed");
            return (Criteria) this;
        }

        public Criteria andAssessedBetween(Integer value1, Integer value2) {
            addCriterion("ASSESSED between", value1, value2, "assessed");
            return (Criteria) this;
        }

        public Criteria andAssessedNotBetween(Integer value1, Integer value2) {
            addCriterion("ASSESSED not between", value1, value2, "assessed");
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
package com.woniu.jiapei.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShareholderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShareholderExample() {
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

        public Criteria andUserinfoIdIsNull() {
            addCriterion("userinfo_id is null");
            return (Criteria) this;
        }

        public Criteria andUserinfoIdIsNotNull() {
            addCriterion("userinfo_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserinfoIdEqualTo(Integer value) {
            addCriterion("userinfo_id =", value, "userinfoId");
            return (Criteria) this;
        }

        public Criteria andUserinfoIdNotEqualTo(Integer value) {
            addCriterion("userinfo_id <>", value, "userinfoId");
            return (Criteria) this;
        }

        public Criteria andUserinfoIdGreaterThan(Integer value) {
            addCriterion("userinfo_id >", value, "userinfoId");
            return (Criteria) this;
        }

        public Criteria andUserinfoIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("userinfo_id >=", value, "userinfoId");
            return (Criteria) this;
        }

        public Criteria andUserinfoIdLessThan(Integer value) {
            addCriterion("userinfo_id <", value, "userinfoId");
            return (Criteria) this;
        }

        public Criteria andUserinfoIdLessThanOrEqualTo(Integer value) {
            addCriterion("userinfo_id <=", value, "userinfoId");
            return (Criteria) this;
        }

        public Criteria andUserinfoIdIn(List<Integer> values) {
            addCriterion("userinfo_id in", values, "userinfoId");
            return (Criteria) this;
        }

        public Criteria andUserinfoIdNotIn(List<Integer> values) {
            addCriterion("userinfo_id not in", values, "userinfoId");
            return (Criteria) this;
        }

        public Criteria andUserinfoIdBetween(Integer value1, Integer value2) {
            addCriterion("userinfo_id between", value1, value2, "userinfoId");
            return (Criteria) this;
        }

        public Criteria andUserinfoIdNotBetween(Integer value1, Integer value2) {
            addCriterion("userinfo_id not between", value1, value2, "userinfoId");
            return (Criteria) this;
        }

        public Criteria andShareholderRevenueshareIsNull() {
            addCriterion("shareholder_revenueshare is null");
            return (Criteria) this;
        }

        public Criteria andShareholderRevenueshareIsNotNull() {
            addCriterion("shareholder_revenueshare is not null");
            return (Criteria) this;
        }

        public Criteria andShareholderRevenueshareEqualTo(Integer value) {
            addCriterion("shareholder_revenueshare =", value, "shareholderRevenueshare");
            return (Criteria) this;
        }

        public Criteria andShareholderRevenueshareNotEqualTo(Integer value) {
            addCriterion("shareholder_revenueshare <>", value, "shareholderRevenueshare");
            return (Criteria) this;
        }

        public Criteria andShareholderRevenueshareGreaterThan(Integer value) {
            addCriterion("shareholder_revenueshare >", value, "shareholderRevenueshare");
            return (Criteria) this;
        }

        public Criteria andShareholderRevenueshareGreaterThanOrEqualTo(Integer value) {
            addCriterion("shareholder_revenueshare >=", value, "shareholderRevenueshare");
            return (Criteria) this;
        }

        public Criteria andShareholderRevenueshareLessThan(Integer value) {
            addCriterion("shareholder_revenueshare <", value, "shareholderRevenueshare");
            return (Criteria) this;
        }

        public Criteria andShareholderRevenueshareLessThanOrEqualTo(Integer value) {
            addCriterion("shareholder_revenueshare <=", value, "shareholderRevenueshare");
            return (Criteria) this;
        }

        public Criteria andShareholderRevenueshareIn(List<Integer> values) {
            addCriterion("shareholder_revenueshare in", values, "shareholderRevenueshare");
            return (Criteria) this;
        }

        public Criteria andShareholderRevenueshareNotIn(List<Integer> values) {
            addCriterion("shareholder_revenueshare not in", values, "shareholderRevenueshare");
            return (Criteria) this;
        }

        public Criteria andShareholderRevenueshareBetween(Integer value1, Integer value2) {
            addCriterion("shareholder_revenueshare between", value1, value2, "shareholderRevenueshare");
            return (Criteria) this;
        }

        public Criteria andShareholderRevenueshareNotBetween(Integer value1, Integer value2) {
            addCriterion("shareholder_revenueshare not between", value1, value2, "shareholderRevenueshare");
            return (Criteria) this;
        }

        public Criteria andShareholderTimeIsNull() {
            addCriterion("shareholder_time is null");
            return (Criteria) this;
        }

        public Criteria andShareholderTimeIsNotNull() {
            addCriterion("shareholder_time is not null");
            return (Criteria) this;
        }

        public Criteria andShareholderTimeEqualTo(Date value) {
            addCriterion("shareholder_time =", value, "shareholderTime");
            return (Criteria) this;
        }

        public Criteria andShareholderTimeNotEqualTo(Date value) {
            addCriterion("shareholder_time <>", value, "shareholderTime");
            return (Criteria) this;
        }

        public Criteria andShareholderTimeGreaterThan(Date value) {
            addCriterion("shareholder_time >", value, "shareholderTime");
            return (Criteria) this;
        }

        public Criteria andShareholderTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("shareholder_time >=", value, "shareholderTime");
            return (Criteria) this;
        }

        public Criteria andShareholderTimeLessThan(Date value) {
            addCriterion("shareholder_time <", value, "shareholderTime");
            return (Criteria) this;
        }

        public Criteria andShareholderTimeLessThanOrEqualTo(Date value) {
            addCriterion("shareholder_time <=", value, "shareholderTime");
            return (Criteria) this;
        }

        public Criteria andShareholderTimeIn(List<Date> values) {
            addCriterion("shareholder_time in", values, "shareholderTime");
            return (Criteria) this;
        }

        public Criteria andShareholderTimeNotIn(List<Date> values) {
            addCriterion("shareholder_time not in", values, "shareholderTime");
            return (Criteria) this;
        }

        public Criteria andShareholderTimeBetween(Date value1, Date value2) {
            addCriterion("shareholder_time between", value1, value2, "shareholderTime");
            return (Criteria) this;
        }

        public Criteria andShareholderTimeNotBetween(Date value1, Date value2) {
            addCriterion("shareholder_time not between", value1, value2, "shareholderTime");
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
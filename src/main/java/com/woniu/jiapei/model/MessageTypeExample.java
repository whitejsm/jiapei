package com.woniu.jiapei.model;

import java.util.ArrayList;
import java.util.List;

public class MessageTypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MessageTypeExample() {
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

        public Criteria andMessageTypeIdIsNull() {
            addCriterion("message_type_id is null");
            return (Criteria) this;
        }

        public Criteria andMessageTypeIdIsNotNull() {
            addCriterion("message_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andMessageTypeIdEqualTo(Integer value) {
            addCriterion("message_type_id =", value, "messageTypeId");
            return (Criteria) this;
        }

        public Criteria andMessageTypeIdNotEqualTo(Integer value) {
            addCriterion("message_type_id <>", value, "messageTypeId");
            return (Criteria) this;
        }

        public Criteria andMessageTypeIdGreaterThan(Integer value) {
            addCriterion("message_type_id >", value, "messageTypeId");
            return (Criteria) this;
        }

        public Criteria andMessageTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("message_type_id >=", value, "messageTypeId");
            return (Criteria) this;
        }

        public Criteria andMessageTypeIdLessThan(Integer value) {
            addCriterion("message_type_id <", value, "messageTypeId");
            return (Criteria) this;
        }

        public Criteria andMessageTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("message_type_id <=", value, "messageTypeId");
            return (Criteria) this;
        }

        public Criteria andMessageTypeIdIn(List<Integer> values) {
            addCriterion("message_type_id in", values, "messageTypeId");
            return (Criteria) this;
        }

        public Criteria andMessageTypeIdNotIn(List<Integer> values) {
            addCriterion("message_type_id not in", values, "messageTypeId");
            return (Criteria) this;
        }

        public Criteria andMessageTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("message_type_id between", value1, value2, "messageTypeId");
            return (Criteria) this;
        }

        public Criteria andMessageTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("message_type_id not between", value1, value2, "messageTypeId");
            return (Criteria) this;
        }

        public Criteria andMessageTypeNameIsNull() {
            addCriterion("message_type_name is null");
            return (Criteria) this;
        }

        public Criteria andMessageTypeNameIsNotNull() {
            addCriterion("message_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andMessageTypeNameEqualTo(String value) {
            addCriterion("message_type_name =", value, "messageTypeName");
            return (Criteria) this;
        }

        public Criteria andMessageTypeNameNotEqualTo(String value) {
            addCriterion("message_type_name <>", value, "messageTypeName");
            return (Criteria) this;
        }

        public Criteria andMessageTypeNameGreaterThan(String value) {
            addCriterion("message_type_name >", value, "messageTypeName");
            return (Criteria) this;
        }

        public Criteria andMessageTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("message_type_name >=", value, "messageTypeName");
            return (Criteria) this;
        }

        public Criteria andMessageTypeNameLessThan(String value) {
            addCriterion("message_type_name <", value, "messageTypeName");
            return (Criteria) this;
        }

        public Criteria andMessageTypeNameLessThanOrEqualTo(String value) {
            addCriterion("message_type_name <=", value, "messageTypeName");
            return (Criteria) this;
        }

        public Criteria andMessageTypeNameLike(String value) {
            addCriterion("message_type_name like", value, "messageTypeName");
            return (Criteria) this;
        }

        public Criteria andMessageTypeNameNotLike(String value) {
            addCriterion("message_type_name not like", value, "messageTypeName");
            return (Criteria) this;
        }

        public Criteria andMessageTypeNameIn(List<String> values) {
            addCriterion("message_type_name in", values, "messageTypeName");
            return (Criteria) this;
        }

        public Criteria andMessageTypeNameNotIn(List<String> values) {
            addCriterion("message_type_name not in", values, "messageTypeName");
            return (Criteria) this;
        }

        public Criteria andMessageTypeNameBetween(String value1, String value2) {
            addCriterion("message_type_name between", value1, value2, "messageTypeName");
            return (Criteria) this;
        }

        public Criteria andMessageTypeNameNotBetween(String value1, String value2) {
            addCriterion("message_type_name not between", value1, value2, "messageTypeName");
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
package com.woniu.jiapei.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MessageExample() {
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

        public Criteria andMessageIdIsNull() {
            addCriterion("message_id is null");
            return (Criteria) this;
        }

        public Criteria andMessageIdIsNotNull() {
            addCriterion("message_id is not null");
            return (Criteria) this;
        }

        public Criteria andMessageIdEqualTo(String value) {
            addCriterion("message_id =", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdNotEqualTo(String value) {
            addCriterion("message_id <>", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdGreaterThan(String value) {
            addCriterion("message_id >", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdGreaterThanOrEqualTo(String value) {
            addCriterion("message_id >=", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdLessThan(String value) {
            addCriterion("message_id <", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdLessThanOrEqualTo(String value) {
            addCriterion("message_id <=", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdLike(String value) {
            addCriterion("message_id like", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdNotLike(String value) {
            addCriterion("message_id not like", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdIn(List<String> values) {
            addCriterion("message_id in", values, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdNotIn(List<String> values) {
            addCriterion("message_id not in", values, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdBetween(String value1, String value2) {
            addCriterion("message_id between", value1, value2, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdNotBetween(String value1, String value2) {
            addCriterion("message_id not between", value1, value2, "messageId");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNull() {
            addCriterion("role_id is null");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNotNull() {
            addCriterion("role_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoleIdEqualTo(Integer value) {
            addCriterion("role_id =", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotEqualTo(Integer value) {
            addCriterion("role_id <>", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThan(Integer value) {
            addCriterion("role_id >", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("role_id >=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThan(Integer value) {
            addCriterion("role_id <", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThanOrEqualTo(Integer value) {
            addCriterion("role_id <=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdIn(List<Integer> values) {
            addCriterion("role_id in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotIn(List<Integer> values) {
            addCriterion("role_id not in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdBetween(Integer value1, Integer value2) {
            addCriterion("role_id between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("role_id not between", value1, value2, "roleId");
            return (Criteria) this;
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

        public Criteria andMessageDetailIdIsNull() {
            addCriterion("message_detail_id is null");
            return (Criteria) this;
        }

        public Criteria andMessageDetailIdIsNotNull() {
            addCriterion("message_detail_id is not null");
            return (Criteria) this;
        }

        public Criteria andMessageDetailIdEqualTo(Integer value) {
            addCriterion("message_detail_id =", value, "messageDetailId");
            return (Criteria) this;
        }

        public Criteria andMessageDetailIdNotEqualTo(Integer value) {
            addCriterion("message_detail_id <>", value, "messageDetailId");
            return (Criteria) this;
        }

        public Criteria andMessageDetailIdGreaterThan(Integer value) {
            addCriterion("message_detail_id >", value, "messageDetailId");
            return (Criteria) this;
        }

        public Criteria andMessageDetailIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("message_detail_id >=", value, "messageDetailId");
            return (Criteria) this;
        }

        public Criteria andMessageDetailIdLessThan(Integer value) {
            addCriterion("message_detail_id <", value, "messageDetailId");
            return (Criteria) this;
        }

        public Criteria andMessageDetailIdLessThanOrEqualTo(Integer value) {
            addCriterion("message_detail_id <=", value, "messageDetailId");
            return (Criteria) this;
        }

        public Criteria andMessageDetailIdIn(List<Integer> values) {
            addCriterion("message_detail_id in", values, "messageDetailId");
            return (Criteria) this;
        }

        public Criteria andMessageDetailIdNotIn(List<Integer> values) {
            addCriterion("message_detail_id not in", values, "messageDetailId");
            return (Criteria) this;
        }

        public Criteria andMessageDetailIdBetween(Integer value1, Integer value2) {
            addCriterion("message_detail_id between", value1, value2, "messageDetailId");
            return (Criteria) this;
        }

        public Criteria andMessageDetailIdNotBetween(Integer value1, Integer value2) {
            addCriterion("message_detail_id not between", value1, value2, "messageDetailId");
            return (Criteria) this;
        }

        public Criteria andMessageWayIsNull() {
            addCriterion("message_way is null");
            return (Criteria) this;
        }

        public Criteria andMessageWayIsNotNull() {
            addCriterion("message_way is not null");
            return (Criteria) this;
        }

        public Criteria andMessageWayEqualTo(String value) {
            addCriterion("message_way =", value, "messageWay");
            return (Criteria) this;
        }

        public Criteria andMessageWayNotEqualTo(String value) {
            addCriterion("message_way <>", value, "messageWay");
            return (Criteria) this;
        }

        public Criteria andMessageWayGreaterThan(String value) {
            addCriterion("message_way >", value, "messageWay");
            return (Criteria) this;
        }

        public Criteria andMessageWayGreaterThanOrEqualTo(String value) {
            addCriterion("message_way >=", value, "messageWay");
            return (Criteria) this;
        }

        public Criteria andMessageWayLessThan(String value) {
            addCriterion("message_way <", value, "messageWay");
            return (Criteria) this;
        }

        public Criteria andMessageWayLessThanOrEqualTo(String value) {
            addCriterion("message_way <=", value, "messageWay");
            return (Criteria) this;
        }

        public Criteria andMessageWayLike(String value) {
            addCriterion("message_way like", value, "messageWay");
            return (Criteria) this;
        }

        public Criteria andMessageWayNotLike(String value) {
            addCriterion("message_way not like", value, "messageWay");
            return (Criteria) this;
        }

        public Criteria andMessageWayIn(List<String> values) {
            addCriterion("message_way in", values, "messageWay");
            return (Criteria) this;
        }

        public Criteria andMessageWayNotIn(List<String> values) {
            addCriterion("message_way not in", values, "messageWay");
            return (Criteria) this;
        }

        public Criteria andMessageWayBetween(String value1, String value2) {
            addCriterion("message_way between", value1, value2, "messageWay");
            return (Criteria) this;
        }

        public Criteria andMessageWayNotBetween(String value1, String value2) {
            addCriterion("message_way not between", value1, value2, "messageWay");
            return (Criteria) this;
        }

        public Criteria andMessageConditionIsNull() {
            addCriterion("message_condition is null");
            return (Criteria) this;
        }

        public Criteria andMessageConditionIsNotNull() {
            addCriterion("message_condition is not null");
            return (Criteria) this;
        }

        public Criteria andMessageConditionEqualTo(String value) {
            addCriterion("message_condition =", value, "messageCondition");
            return (Criteria) this;
        }

        public Criteria andMessageConditionNotEqualTo(String value) {
            addCriterion("message_condition <>", value, "messageCondition");
            return (Criteria) this;
        }

        public Criteria andMessageConditionGreaterThan(String value) {
            addCriterion("message_condition >", value, "messageCondition");
            return (Criteria) this;
        }

        public Criteria andMessageConditionGreaterThanOrEqualTo(String value) {
            addCriterion("message_condition >=", value, "messageCondition");
            return (Criteria) this;
        }

        public Criteria andMessageConditionLessThan(String value) {
            addCriterion("message_condition <", value, "messageCondition");
            return (Criteria) this;
        }

        public Criteria andMessageConditionLessThanOrEqualTo(String value) {
            addCriterion("message_condition <=", value, "messageCondition");
            return (Criteria) this;
        }

        public Criteria andMessageConditionLike(String value) {
            addCriterion("message_condition like", value, "messageCondition");
            return (Criteria) this;
        }

        public Criteria andMessageConditionNotLike(String value) {
            addCriterion("message_condition not like", value, "messageCondition");
            return (Criteria) this;
        }

        public Criteria andMessageConditionIn(List<String> values) {
            addCriterion("message_condition in", values, "messageCondition");
            return (Criteria) this;
        }

        public Criteria andMessageConditionNotIn(List<String> values) {
            addCriterion("message_condition not in", values, "messageCondition");
            return (Criteria) this;
        }

        public Criteria andMessageConditionBetween(String value1, String value2) {
            addCriterion("message_condition between", value1, value2, "messageCondition");
            return (Criteria) this;
        }

        public Criteria andMessageConditionNotBetween(String value1, String value2) {
            addCriterion("message_condition not between", value1, value2, "messageCondition");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
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
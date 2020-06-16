package com.woniu.jiapei.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessageListExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MessageListExample() {
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

        public Criteria andMessageListIdIsNull() {
            addCriterion("message_list_id is null");
            return (Criteria) this;
        }

        public Criteria andMessageListIdIsNotNull() {
            addCriterion("message_list_id is not null");
            return (Criteria) this;
        }

        public Criteria andMessageListIdEqualTo(Integer value) {
            addCriterion("message_list_id =", value, "messageListId");
            return (Criteria) this;
        }

        public Criteria andMessageListIdNotEqualTo(Integer value) {
            addCriterion("message_list_id <>", value, "messageListId");
            return (Criteria) this;
        }

        public Criteria andMessageListIdGreaterThan(Integer value) {
            addCriterion("message_list_id >", value, "messageListId");
            return (Criteria) this;
        }

        public Criteria andMessageListIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("message_list_id >=", value, "messageListId");
            return (Criteria) this;
        }

        public Criteria andMessageListIdLessThan(Integer value) {
            addCriterion("message_list_id <", value, "messageListId");
            return (Criteria) this;
        }

        public Criteria andMessageListIdLessThanOrEqualTo(Integer value) {
            addCriterion("message_list_id <=", value, "messageListId");
            return (Criteria) this;
        }

        public Criteria andMessageListIdIn(List<Integer> values) {
            addCriterion("message_list_id in", values, "messageListId");
            return (Criteria) this;
        }

        public Criteria andMessageListIdNotIn(List<Integer> values) {
            addCriterion("message_list_id not in", values, "messageListId");
            return (Criteria) this;
        }

        public Criteria andMessageListIdBetween(Integer value1, Integer value2) {
            addCriterion("message_list_id between", value1, value2, "messageListId");
            return (Criteria) this;
        }

        public Criteria andMessageListIdNotBetween(Integer value1, Integer value2) {
            addCriterion("message_list_id not between", value1, value2, "messageListId");
            return (Criteria) this;
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

        public Criteria andMessageSendtimeIsNull() {
            addCriterion("message_sendtime is null");
            return (Criteria) this;
        }

        public Criteria andMessageSendtimeIsNotNull() {
            addCriterion("message_sendtime is not null");
            return (Criteria) this;
        }

        public Criteria andMessageSendtimeEqualTo(Date value) {
            addCriterion("message_sendtime =", value, "messageSendtime");
            return (Criteria) this;
        }

        public Criteria andMessageSendtimeNotEqualTo(Date value) {
            addCriterion("message_sendtime <>", value, "messageSendtime");
            return (Criteria) this;
        }

        public Criteria andMessageSendtimeGreaterThan(Date value) {
            addCriterion("message_sendtime >", value, "messageSendtime");
            return (Criteria) this;
        }

        public Criteria andMessageSendtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("message_sendtime >=", value, "messageSendtime");
            return (Criteria) this;
        }

        public Criteria andMessageSendtimeLessThan(Date value) {
            addCriterion("message_sendtime <", value, "messageSendtime");
            return (Criteria) this;
        }

        public Criteria andMessageSendtimeLessThanOrEqualTo(Date value) {
            addCriterion("message_sendtime <=", value, "messageSendtime");
            return (Criteria) this;
        }

        public Criteria andMessageSendtimeIn(List<Date> values) {
            addCriterion("message_sendtime in", values, "messageSendtime");
            return (Criteria) this;
        }

        public Criteria andMessageSendtimeNotIn(List<Date> values) {
            addCriterion("message_sendtime not in", values, "messageSendtime");
            return (Criteria) this;
        }

        public Criteria andMessageSendtimeBetween(Date value1, Date value2) {
            addCriterion("message_sendtime between", value1, value2, "messageSendtime");
            return (Criteria) this;
        }

        public Criteria andMessageSendtimeNotBetween(Date value1, Date value2) {
            addCriterion("message_sendtime not between", value1, value2, "messageSendtime");
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
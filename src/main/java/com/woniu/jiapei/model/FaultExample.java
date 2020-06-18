package com.woniu.jiapei.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FaultExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FaultExample() {
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

        public Criteria andFaultIdIsNull() {
            addCriterion("fault_id is null");
            return (Criteria) this;
        }

        public Criteria andFaultIdIsNotNull() {
            addCriterion("fault_id is not null");
            return (Criteria) this;
        }

        public Criteria andFaultIdEqualTo(Integer value) {
            addCriterion("fault_id =", value, "faultId");
            return (Criteria) this;
        }

        public Criteria andFaultIdNotEqualTo(Integer value) {
            addCriterion("fault_id <>", value, "faultId");
            return (Criteria) this;
        }

        public Criteria andFaultIdGreaterThan(Integer value) {
            addCriterion("fault_id >", value, "faultId");
            return (Criteria) this;
        }

        public Criteria andFaultIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("fault_id >=", value, "faultId");
            return (Criteria) this;
        }

        public Criteria andFaultIdLessThan(Integer value) {
            addCriterion("fault_id <", value, "faultId");
            return (Criteria) this;
        }

        public Criteria andFaultIdLessThanOrEqualTo(Integer value) {
            addCriterion("fault_id <=", value, "faultId");
            return (Criteria) this;
        }

        public Criteria andFaultIdIn(List<Integer> values) {
            addCriterion("fault_id in", values, "faultId");
            return (Criteria) this;
        }

        public Criteria andFaultIdNotIn(List<Integer> values) {
            addCriterion("fault_id not in", values, "faultId");
            return (Criteria) this;
        }

        public Criteria andFaultIdBetween(Integer value1, Integer value2) {
            addCriterion("fault_id between", value1, value2, "faultId");
            return (Criteria) this;
        }

        public Criteria andFaultIdNotBetween(Integer value1, Integer value2) {
            addCriterion("fault_id not between", value1, value2, "faultId");
            return (Criteria) this;
        }

        public Criteria andContactorIdIsNull() {
            addCriterion("contactor_id is null");
            return (Criteria) this;
        }

        public Criteria andContactorIdIsNotNull() {
            addCriterion("contactor_id is not null");
            return (Criteria) this;
        }

        public Criteria andContactorIdEqualTo(Integer value) {
            addCriterion("contactor_id =", value, "contactorId");
            return (Criteria) this;
        }

        public Criteria andContactorIdNotEqualTo(Integer value) {
            addCriterion("contactor_id <>", value, "contactorId");
            return (Criteria) this;
        }

        public Criteria andContactorIdGreaterThan(Integer value) {
            addCriterion("contactor_id >", value, "contactorId");
            return (Criteria) this;
        }

        public Criteria andContactorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("contactor_id >=", value, "contactorId");
            return (Criteria) this;
        }

        public Criteria andContactorIdLessThan(Integer value) {
            addCriterion("contactor_id <", value, "contactorId");
            return (Criteria) this;
        }

        public Criteria andContactorIdLessThanOrEqualTo(Integer value) {
            addCriterion("contactor_id <=", value, "contactorId");
            return (Criteria) this;
        }

        public Criteria andContactorIdIn(List<Integer> values) {
            addCriterion("contactor_id in", values, "contactorId");
            return (Criteria) this;
        }

        public Criteria andContactorIdNotIn(List<Integer> values) {
            addCriterion("contactor_id not in", values, "contactorId");
            return (Criteria) this;
        }

        public Criteria andContactorIdBetween(Integer value1, Integer value2) {
            addCriterion("contactor_id between", value1, value2, "contactorId");
            return (Criteria) this;
        }

        public Criteria andContactorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("contactor_id not between", value1, value2, "contactorId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIsNull() {
            addCriterion("customer_id is null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIsNotNull() {
            addCriterion("customer_id is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdEqualTo(Integer value) {
            addCriterion("customer_id =", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotEqualTo(Integer value) {
            addCriterion("customer_id <>", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThan(Integer value) {
            addCriterion("customer_id >", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("customer_id >=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThan(Integer value) {
            addCriterion("customer_id <", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThanOrEqualTo(Integer value) {
            addCriterion("customer_id <=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIn(List<Integer> values) {
            addCriterion("customer_id in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotIn(List<Integer> values) {
            addCriterion("customer_id not in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdBetween(Integer value1, Integer value2) {
            addCriterion("customer_id between", value1, value2, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("customer_id not between", value1, value2, "customerId");
            return (Criteria) this;
        }

        public Criteria andBedIdIsNull() {
            addCriterion("bed_id is null");
            return (Criteria) this;
        }

        public Criteria andBedIdIsNotNull() {
            addCriterion("bed_id is not null");
            return (Criteria) this;
        }

        public Criteria andBedIdEqualTo(String value) {
            addCriterion("bed_id =", value, "bedId");
            return (Criteria) this;
        }

        public Criteria andBedIdNotEqualTo(String value) {
            addCriterion("bed_id <>", value, "bedId");
            return (Criteria) this;
        }

        public Criteria andBedIdGreaterThan(String value) {
            addCriterion("bed_id >", value, "bedId");
            return (Criteria) this;
        }

        public Criteria andBedIdGreaterThanOrEqualTo(String value) {
            addCriterion("bed_id >=", value, "bedId");
            return (Criteria) this;
        }

        public Criteria andBedIdLessThan(String value) {
            addCriterion("bed_id <", value, "bedId");
            return (Criteria) this;
        }

        public Criteria andBedIdLessThanOrEqualTo(String value) {
            addCriterion("bed_id <=", value, "bedId");
            return (Criteria) this;
        }

        public Criteria andBedIdLike(String value) {
            addCriterion("bed_id like", value, "bedId");
            return (Criteria) this;
        }

        public Criteria andBedIdNotLike(String value) {
            addCriterion("bed_id not like", value, "bedId");
            return (Criteria) this;
        }

        public Criteria andBedIdIn(List<String> values) {
            addCriterion("bed_id in", values, "bedId");
            return (Criteria) this;
        }

        public Criteria andBedIdNotIn(List<String> values) {
            addCriterion("bed_id not in", values, "bedId");
            return (Criteria) this;
        }

        public Criteria andBedIdBetween(String value1, String value2) {
            addCriterion("bed_id between", value1, value2, "bedId");
            return (Criteria) this;
        }

        public Criteria andBedIdNotBetween(String value1, String value2) {
            addCriterion("bed_id not between", value1, value2, "bedId");
            return (Criteria) this;
        }

        public Criteria andFaultTitleIsNull() {
            addCriterion("fault_title is null");
            return (Criteria) this;
        }

        public Criteria andFaultTitleIsNotNull() {
            addCriterion("fault_title is not null");
            return (Criteria) this;
        }

        public Criteria andFaultTitleEqualTo(String value) {
            addCriterion("fault_title =", value, "faultTitle");
            return (Criteria) this;
        }

        public Criteria andFaultTitleNotEqualTo(String value) {
            addCriterion("fault_title <>", value, "faultTitle");
            return (Criteria) this;
        }

        public Criteria andFaultTitleGreaterThan(String value) {
            addCriterion("fault_title >", value, "faultTitle");
            return (Criteria) this;
        }

        public Criteria andFaultTitleGreaterThanOrEqualTo(String value) {
            addCriterion("fault_title >=", value, "faultTitle");
            return (Criteria) this;
        }

        public Criteria andFaultTitleLessThan(String value) {
            addCriterion("fault_title <", value, "faultTitle");
            return (Criteria) this;
        }

        public Criteria andFaultTitleLessThanOrEqualTo(String value) {
            addCriterion("fault_title <=", value, "faultTitle");
            return (Criteria) this;
        }

        public Criteria andFaultTitleLike(String value) {
            addCriterion("fault_title like", value, "faultTitle");
            return (Criteria) this;
        }

        public Criteria andFaultTitleNotLike(String value) {
            addCriterion("fault_title not like", value, "faultTitle");
            return (Criteria) this;
        }

        public Criteria andFaultTitleIn(List<String> values) {
            addCriterion("fault_title in", values, "faultTitle");
            return (Criteria) this;
        }

        public Criteria andFaultTitleNotIn(List<String> values) {
            addCriterion("fault_title not in", values, "faultTitle");
            return (Criteria) this;
        }

        public Criteria andFaultTitleBetween(String value1, String value2) {
            addCriterion("fault_title between", value1, value2, "faultTitle");
            return (Criteria) this;
        }

        public Criteria andFaultTitleNotBetween(String value1, String value2) {
            addCriterion("fault_title not between", value1, value2, "faultTitle");
            return (Criteria) this;
        }

        public Criteria andFaultTypeIsNull() {
            addCriterion("fault_type is null");
            return (Criteria) this;
        }

        public Criteria andFaultTypeIsNotNull() {
            addCriterion("fault_type is not null");
            return (Criteria) this;
        }

        public Criteria andFaultTypeEqualTo(String value) {
            addCriterion("fault_type =", value, "faultType");
            return (Criteria) this;
        }

        public Criteria andFaultTypeNotEqualTo(String value) {
            addCriterion("fault_type <>", value, "faultType");
            return (Criteria) this;
        }

        public Criteria andFaultTypeGreaterThan(String value) {
            addCriterion("fault_type >", value, "faultType");
            return (Criteria) this;
        }

        public Criteria andFaultTypeGreaterThanOrEqualTo(String value) {
            addCriterion("fault_type >=", value, "faultType");
            return (Criteria) this;
        }

        public Criteria andFaultTypeLessThan(String value) {
            addCriterion("fault_type <", value, "faultType");
            return (Criteria) this;
        }

        public Criteria andFaultTypeLessThanOrEqualTo(String value) {
            addCriterion("fault_type <=", value, "faultType");
            return (Criteria) this;
        }

        public Criteria andFaultTypeLike(String value) {
            addCriterion("fault_type like", value, "faultType");
            return (Criteria) this;
        }

        public Criteria andFaultTypeNotLike(String value) {
            addCriterion("fault_type not like", value, "faultType");
            return (Criteria) this;
        }

        public Criteria andFaultTypeIn(List<String> values) {
            addCriterion("fault_type in", values, "faultType");
            return (Criteria) this;
        }

        public Criteria andFaultTypeNotIn(List<String> values) {
            addCriterion("fault_type not in", values, "faultType");
            return (Criteria) this;
        }

        public Criteria andFaultTypeBetween(String value1, String value2) {
            addCriterion("fault_type between", value1, value2, "faultType");
            return (Criteria) this;
        }

        public Criteria andFaultTypeNotBetween(String value1, String value2) {
            addCriterion("fault_type not between", value1, value2, "faultType");
            return (Criteria) this;
        }

        public Criteria andFaultStatusIsNull() {
            addCriterion("fault_status is null");
            return (Criteria) this;
        }

        public Criteria andFaultStatusIsNotNull() {
            addCriterion("fault_status is not null");
            return (Criteria) this;
        }

        public Criteria andFaultStatusEqualTo(String value) {
            addCriterion("fault_status =", value, "faultStatus");
            return (Criteria) this;
        }

        public Criteria andFaultStatusNotEqualTo(String value) {
            addCriterion("fault_status <>", value, "faultStatus");
            return (Criteria) this;
        }

        public Criteria andFaultStatusGreaterThan(String value) {
            addCriterion("fault_status >", value, "faultStatus");
            return (Criteria) this;
        }

        public Criteria andFaultStatusGreaterThanOrEqualTo(String value) {
            addCriterion("fault_status >=", value, "faultStatus");
            return (Criteria) this;
        }

        public Criteria andFaultStatusLessThan(String value) {
            addCriterion("fault_status <", value, "faultStatus");
            return (Criteria) this;
        }

        public Criteria andFaultStatusLessThanOrEqualTo(String value) {
            addCriterion("fault_status <=", value, "faultStatus");
            return (Criteria) this;
        }

        public Criteria andFaultStatusLike(String value) {
            addCriterion("fault_status like", value, "faultStatus");
            return (Criteria) this;
        }

        public Criteria andFaultStatusNotLike(String value) {
            addCriterion("fault_status not like", value, "faultStatus");
            return (Criteria) this;
        }

        public Criteria andFaultStatusIn(List<String> values) {
            addCriterion("fault_status in", values, "faultStatus");
            return (Criteria) this;
        }

        public Criteria andFaultStatusNotIn(List<String> values) {
            addCriterion("fault_status not in", values, "faultStatus");
            return (Criteria) this;
        }

        public Criteria andFaultStatusBetween(String value1, String value2) {
            addCriterion("fault_status between", value1, value2, "faultStatus");
            return (Criteria) this;
        }

        public Criteria andFaultStatusNotBetween(String value1, String value2) {
            addCriterion("fault_status not between", value1, value2, "faultStatus");
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
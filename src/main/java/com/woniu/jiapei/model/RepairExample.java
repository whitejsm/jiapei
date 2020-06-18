package com.woniu.jiapei.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RepairExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RepairExample() {
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

        public Criteria andRepairIdIsNull() {
            addCriterion("repair_id is null");
            return (Criteria) this;
        }

        public Criteria andRepairIdIsNotNull() {
            addCriterion("repair_id is not null");
            return (Criteria) this;
        }

        public Criteria andRepairIdEqualTo(String value) {
            addCriterion("repair_id =", value, "repairId");
            return (Criteria) this;
        }

        public Criteria andRepairIdNotEqualTo(String value) {
            addCriterion("repair_id <>", value, "repairId");
            return (Criteria) this;
        }

        public Criteria andRepairIdGreaterThan(String value) {
            addCriterion("repair_id >", value, "repairId");
            return (Criteria) this;
        }

        public Criteria andRepairIdGreaterThanOrEqualTo(String value) {
            addCriterion("repair_id >=", value, "repairId");
            return (Criteria) this;
        }

        public Criteria andRepairIdLessThan(String value) {
            addCriterion("repair_id <", value, "repairId");
            return (Criteria) this;
        }

        public Criteria andRepairIdLessThanOrEqualTo(String value) {
            addCriterion("repair_id <=", value, "repairId");
            return (Criteria) this;
        }

        public Criteria andRepairIdLike(String value) {
            addCriterion("repair_id like", value, "repairId");
            return (Criteria) this;
        }

        public Criteria andRepairIdNotLike(String value) {
            addCriterion("repair_id not like", value, "repairId");
            return (Criteria) this;
        }

        public Criteria andRepairIdIn(List<String> values) {
            addCriterion("repair_id in", values, "repairId");
            return (Criteria) this;
        }

        public Criteria andRepairIdNotIn(List<String> values) {
            addCriterion("repair_id not in", values, "repairId");
            return (Criteria) this;
        }

        public Criteria andRepairIdBetween(String value1, String value2) {
            addCriterion("repair_id between", value1, value2, "repairId");
            return (Criteria) this;
        }

        public Criteria andRepairIdNotBetween(String value1, String value2) {
            addCriterion("repair_id not between", value1, value2, "repairId");
            return (Criteria) this;
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

        public Criteria andRepairResultIsNull() {
            addCriterion("repair_result is null");
            return (Criteria) this;
        }

        public Criteria andRepairResultIsNotNull() {
            addCriterion("repair_result is not null");
            return (Criteria) this;
        }

        public Criteria andRepairResultEqualTo(String value) {
            addCriterion("repair_result =", value, "repairResult");
            return (Criteria) this;
        }

        public Criteria andRepairResultNotEqualTo(String value) {
            addCriterion("repair_result <>", value, "repairResult");
            return (Criteria) this;
        }

        public Criteria andRepairResultGreaterThan(String value) {
            addCriterion("repair_result >", value, "repairResult");
            return (Criteria) this;
        }

        public Criteria andRepairResultGreaterThanOrEqualTo(String value) {
            addCriterion("repair_result >=", value, "repairResult");
            return (Criteria) this;
        }

        public Criteria andRepairResultLessThan(String value) {
            addCriterion("repair_result <", value, "repairResult");
            return (Criteria) this;
        }

        public Criteria andRepairResultLessThanOrEqualTo(String value) {
            addCriterion("repair_result <=", value, "repairResult");
            return (Criteria) this;
        }

        public Criteria andRepairResultLike(String value) {
            addCriterion("repair_result like", value, "repairResult");
            return (Criteria) this;
        }

        public Criteria andRepairResultNotLike(String value) {
            addCriterion("repair_result not like", value, "repairResult");
            return (Criteria) this;
        }

        public Criteria andRepairResultIn(List<String> values) {
            addCriterion("repair_result in", values, "repairResult");
            return (Criteria) this;
        }

        public Criteria andRepairResultNotIn(List<String> values) {
            addCriterion("repair_result not in", values, "repairResult");
            return (Criteria) this;
        }

        public Criteria andRepairResultBetween(String value1, String value2) {
            addCriterion("repair_result between", value1, value2, "repairResult");
            return (Criteria) this;
        }

        public Criteria andRepairResultNotBetween(String value1, String value2) {
            addCriterion("repair_result not between", value1, value2, "repairResult");
            return (Criteria) this;
        }

        public Criteria andRepairStatusIsNull() {
            addCriterion("repair_status is null");
            return (Criteria) this;
        }

        public Criteria andRepairStatusIsNotNull() {
            addCriterion("repair_status is not null");
            return (Criteria) this;
        }

        public Criteria andRepairStatusEqualTo(String value) {
            addCriterion("repair_status =", value, "repairStatus");
            return (Criteria) this;
        }

        public Criteria andRepairStatusNotEqualTo(String value) {
            addCriterion("repair_status <>", value, "repairStatus");
            return (Criteria) this;
        }

        public Criteria andRepairStatusGreaterThan(String value) {
            addCriterion("repair_status >", value, "repairStatus");
            return (Criteria) this;
        }

        public Criteria andRepairStatusGreaterThanOrEqualTo(String value) {
            addCriterion("repair_status >=", value, "repairStatus");
            return (Criteria) this;
        }

        public Criteria andRepairStatusLessThan(String value) {
            addCriterion("repair_status <", value, "repairStatus");
            return (Criteria) this;
        }

        public Criteria andRepairStatusLessThanOrEqualTo(String value) {
            addCriterion("repair_status <=", value, "repairStatus");
            return (Criteria) this;
        }

        public Criteria andRepairStatusLike(String value) {
            addCriterion("repair_status like", value, "repairStatus");
            return (Criteria) this;
        }

        public Criteria andRepairStatusNotLike(String value) {
            addCriterion("repair_status not like", value, "repairStatus");
            return (Criteria) this;
        }

        public Criteria andRepairStatusIn(List<String> values) {
            addCriterion("repair_status in", values, "repairStatus");
            return (Criteria) this;
        }

        public Criteria andRepairStatusNotIn(List<String> values) {
            addCriterion("repair_status not in", values, "repairStatus");
            return (Criteria) this;
        }

        public Criteria andRepairStatusBetween(String value1, String value2) {
            addCriterion("repair_status between", value1, value2, "repairStatus");
            return (Criteria) this;
        }

        public Criteria andRepairStatusNotBetween(String value1, String value2) {
            addCriterion("repair_status not between", value1, value2, "repairStatus");
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

        public Criteria andRepairmanIdIsNull() {
            addCriterion("repairman_id is null");
            return (Criteria) this;
        }

        public Criteria andRepairmanIdIsNotNull() {
            addCriterion("repairman_id is not null");
            return (Criteria) this;
        }

        public Criteria andRepairmanIdEqualTo(Integer value) {
            addCriterion("repairman_id =", value, "repairmanId");
            return (Criteria) this;
        }

        public Criteria andRepairmanIdNotEqualTo(Integer value) {
            addCriterion("repairman_id <>", value, "repairmanId");
            return (Criteria) this;
        }

        public Criteria andRepairmanIdGreaterThan(Integer value) {
            addCriterion("repairman_id >", value, "repairmanId");
            return (Criteria) this;
        }

        public Criteria andRepairmanIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("repairman_id >=", value, "repairmanId");
            return (Criteria) this;
        }

        public Criteria andRepairmanIdLessThan(Integer value) {
            addCriterion("repairman_id <", value, "repairmanId");
            return (Criteria) this;
        }

        public Criteria andRepairmanIdLessThanOrEqualTo(Integer value) {
            addCriterion("repairman_id <=", value, "repairmanId");
            return (Criteria) this;
        }

        public Criteria andRepairmanIdIn(List<Integer> values) {
            addCriterion("repairman_id in", values, "repairmanId");
            return (Criteria) this;
        }

        public Criteria andRepairmanIdNotIn(List<Integer> values) {
            addCriterion("repairman_id not in", values, "repairmanId");
            return (Criteria) this;
        }

        public Criteria andRepairmanIdBetween(Integer value1, Integer value2) {
            addCriterion("repairman_id between", value1, value2, "repairmanId");
            return (Criteria) this;
        }

        public Criteria andRepairmanIdNotBetween(Integer value1, Integer value2) {
            addCriterion("repairman_id not between", value1, value2, "repairmanId");
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
package com.demo.mbg.model;

import java.util.ArrayList;
import java.util.List;

public class PmsChargeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PmsChargeExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCabinetIdIsNull() {
            addCriterion("cabinet_id is null");
            return (Criteria) this;
        }

        public Criteria andCabinetIdIsNotNull() {
            addCriterion("cabinet_id is not null");
            return (Criteria) this;
        }

        public Criteria andCabinetIdEqualTo(Integer value) {
            addCriterion("cabinet_id =", value, "cabinetId");
            return (Criteria) this;
        }

        public Criteria andCabinetIdNotEqualTo(Integer value) {
            addCriterion("cabinet_id <>", value, "cabinetId");
            return (Criteria) this;
        }

        public Criteria andCabinetIdGreaterThan(Integer value) {
            addCriterion("cabinet_id >", value, "cabinetId");
            return (Criteria) this;
        }

        public Criteria andCabinetIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cabinet_id >=", value, "cabinetId");
            return (Criteria) this;
        }

        public Criteria andCabinetIdLessThan(Integer value) {
            addCriterion("cabinet_id <", value, "cabinetId");
            return (Criteria) this;
        }

        public Criteria andCabinetIdLessThanOrEqualTo(Integer value) {
            addCriterion("cabinet_id <=", value, "cabinetId");
            return (Criteria) this;
        }

        public Criteria andCabinetIdIn(List<Integer> values) {
            addCriterion("cabinet_id in", values, "cabinetId");
            return (Criteria) this;
        }

        public Criteria andCabinetIdNotIn(List<Integer> values) {
            addCriterion("cabinet_id not in", values, "cabinetId");
            return (Criteria) this;
        }

        public Criteria andCabinetIdBetween(Integer value1, Integer value2) {
            addCriterion("cabinet_id between", value1, value2, "cabinetId");
            return (Criteria) this;
        }

        public Criteria andCabinetIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cabinet_id not between", value1, value2, "cabinetId");
            return (Criteria) this;
        }

        public Criteria andPowerLevelIsNull() {
            addCriterion("power_level is null");
            return (Criteria) this;
        }

        public Criteria andPowerLevelIsNotNull() {
            addCriterion("power_level is not null");
            return (Criteria) this;
        }

        public Criteria andPowerLevelEqualTo(Integer value) {
            addCriterion("power_level =", value, "powerLevel");
            return (Criteria) this;
        }

        public Criteria andPowerLevelNotEqualTo(Integer value) {
            addCriterion("power_level <>", value, "powerLevel");
            return (Criteria) this;
        }

        public Criteria andPowerLevelGreaterThan(Integer value) {
            addCriterion("power_level >", value, "powerLevel");
            return (Criteria) this;
        }

        public Criteria andPowerLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("power_level >=", value, "powerLevel");
            return (Criteria) this;
        }

        public Criteria andPowerLevelLessThan(Integer value) {
            addCriterion("power_level <", value, "powerLevel");
            return (Criteria) this;
        }

        public Criteria andPowerLevelLessThanOrEqualTo(Integer value) {
            addCriterion("power_level <=", value, "powerLevel");
            return (Criteria) this;
        }

        public Criteria andPowerLevelIn(List<Integer> values) {
            addCriterion("power_level in", values, "powerLevel");
            return (Criteria) this;
        }

        public Criteria andPowerLevelNotIn(List<Integer> values) {
            addCriterion("power_level not in", values, "powerLevel");
            return (Criteria) this;
        }

        public Criteria andPowerLevelBetween(Integer value1, Integer value2) {
            addCriterion("power_level between", value1, value2, "powerLevel");
            return (Criteria) this;
        }

        public Criteria andPowerLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("power_level not between", value1, value2, "powerLevel");
            return (Criteria) this;
        }

        public Criteria andBorrowStatusIsNull() {
            addCriterion("borrow_status is null");
            return (Criteria) this;
        }

        public Criteria andBorrowStatusIsNotNull() {
            addCriterion("borrow_status is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowStatusEqualTo(String value) {
            addCriterion("borrow_status =", value, "borrowStatus");
            return (Criteria) this;
        }

        public Criteria andBorrowStatusNotEqualTo(String value) {
            addCriterion("borrow_status <>", value, "borrowStatus");
            return (Criteria) this;
        }

        public Criteria andBorrowStatusGreaterThan(String value) {
            addCriterion("borrow_status >", value, "borrowStatus");
            return (Criteria) this;
        }

        public Criteria andBorrowStatusGreaterThanOrEqualTo(String value) {
            addCriterion("borrow_status >=", value, "borrowStatus");
            return (Criteria) this;
        }

        public Criteria andBorrowStatusLessThan(String value) {
            addCriterion("borrow_status <", value, "borrowStatus");
            return (Criteria) this;
        }

        public Criteria andBorrowStatusLessThanOrEqualTo(String value) {
            addCriterion("borrow_status <=", value, "borrowStatus");
            return (Criteria) this;
        }

        public Criteria andBorrowStatusLike(String value) {
            addCriterion("borrow_status like", value, "borrowStatus");
            return (Criteria) this;
        }

        public Criteria andBorrowStatusNotLike(String value) {
            addCriterion("borrow_status not like", value, "borrowStatus");
            return (Criteria) this;
        }

        public Criteria andBorrowStatusIn(List<String> values) {
            addCriterion("borrow_status in", values, "borrowStatus");
            return (Criteria) this;
        }

        public Criteria andBorrowStatusNotIn(List<String> values) {
            addCriterion("borrow_status not in", values, "borrowStatus");
            return (Criteria) this;
        }

        public Criteria andBorrowStatusBetween(String value1, String value2) {
            addCriterion("borrow_status between", value1, value2, "borrowStatus");
            return (Criteria) this;
        }

        public Criteria andBorrowStatusNotBetween(String value1, String value2) {
            addCriterion("borrow_status not between", value1, value2, "borrowStatus");
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
package com.demo.mbg.model;

import java.util.ArrayList;
import java.util.List;

public class OmsPriceListExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OmsPriceListExample() {
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

        public Criteria andMinTimeSecondsIsNull() {
            addCriterion("min_time_seconds is null");
            return (Criteria) this;
        }

        public Criteria andMinTimeSecondsIsNotNull() {
            addCriterion("min_time_seconds is not null");
            return (Criteria) this;
        }

        public Criteria andMinTimeSecondsEqualTo(Long value) {
            addCriterion("min_time_seconds =", value, "minTimeSeconds");
            return (Criteria) this;
        }

        public Criteria andMinTimeSecondsNotEqualTo(Long value) {
            addCriterion("min_time_seconds <>", value, "minTimeSeconds");
            return (Criteria) this;
        }

        public Criteria andMinTimeSecondsGreaterThan(Long value) {
            addCriterion("min_time_seconds >", value, "minTimeSeconds");
            return (Criteria) this;
        }

        public Criteria andMinTimeSecondsGreaterThanOrEqualTo(Long value) {
            addCriterion("min_time_seconds >=", value, "minTimeSeconds");
            return (Criteria) this;
        }

        public Criteria andMinTimeSecondsLessThan(Long value) {
            addCriterion("min_time_seconds <", value, "minTimeSeconds");
            return (Criteria) this;
        }

        public Criteria andMinTimeSecondsLessThanOrEqualTo(Long value) {
            addCriterion("min_time_seconds <=", value, "minTimeSeconds");
            return (Criteria) this;
        }

        public Criteria andMinTimeSecondsIn(List<Long> values) {
            addCriterion("min_time_seconds in", values, "minTimeSeconds");
            return (Criteria) this;
        }

        public Criteria andMinTimeSecondsNotIn(List<Long> values) {
            addCriterion("min_time_seconds not in", values, "minTimeSeconds");
            return (Criteria) this;
        }

        public Criteria andMinTimeSecondsBetween(Long value1, Long value2) {
            addCriterion("min_time_seconds between", value1, value2, "minTimeSeconds");
            return (Criteria) this;
        }

        public Criteria andMinTimeSecondsNotBetween(Long value1, Long value2) {
            addCriterion("min_time_seconds not between", value1, value2, "minTimeSeconds");
            return (Criteria) this;
        }

        public Criteria andMaxTimeSecondsIsNull() {
            addCriterion("max_time_seconds is null");
            return (Criteria) this;
        }

        public Criteria andMaxTimeSecondsIsNotNull() {
            addCriterion("max_time_seconds is not null");
            return (Criteria) this;
        }

        public Criteria andMaxTimeSecondsEqualTo(Long value) {
            addCriterion("max_time_seconds =", value, "maxTimeSeconds");
            return (Criteria) this;
        }

        public Criteria andMaxTimeSecondsNotEqualTo(Long value) {
            addCriterion("max_time_seconds <>", value, "maxTimeSeconds");
            return (Criteria) this;
        }

        public Criteria andMaxTimeSecondsGreaterThan(Long value) {
            addCriterion("max_time_seconds >", value, "maxTimeSeconds");
            return (Criteria) this;
        }

        public Criteria andMaxTimeSecondsGreaterThanOrEqualTo(Long value) {
            addCriterion("max_time_seconds >=", value, "maxTimeSeconds");
            return (Criteria) this;
        }

        public Criteria andMaxTimeSecondsLessThan(Long value) {
            addCriterion("max_time_seconds <", value, "maxTimeSeconds");
            return (Criteria) this;
        }

        public Criteria andMaxTimeSecondsLessThanOrEqualTo(Long value) {
            addCriterion("max_time_seconds <=", value, "maxTimeSeconds");
            return (Criteria) this;
        }

        public Criteria andMaxTimeSecondsIn(List<Long> values) {
            addCriterion("max_time_seconds in", values, "maxTimeSeconds");
            return (Criteria) this;
        }

        public Criteria andMaxTimeSecondsNotIn(List<Long> values) {
            addCriterion("max_time_seconds not in", values, "maxTimeSeconds");
            return (Criteria) this;
        }

        public Criteria andMaxTimeSecondsBetween(Long value1, Long value2) {
            addCriterion("max_time_seconds between", value1, value2, "maxTimeSeconds");
            return (Criteria) this;
        }

        public Criteria andMaxTimeSecondsNotBetween(Long value1, Long value2) {
            addCriterion("max_time_seconds not between", value1, value2, "maxTimeSeconds");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Double value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Double value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Double value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Double value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Double value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Double> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Double> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Double value1, Double value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Double value1, Double value2) {
            addCriterion("price not between", value1, value2, "price");
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
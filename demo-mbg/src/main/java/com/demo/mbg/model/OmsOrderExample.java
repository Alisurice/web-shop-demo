package com.demo.mbg.model;

import java.util.ArrayList;
import java.util.List;

public class OmsOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OmsOrderExample() {
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

        public Criteria andGuestIdIsNull() {
            addCriterion("guest_id is null");
            return (Criteria) this;
        }

        public Criteria andGuestIdIsNotNull() {
            addCriterion("guest_id is not null");
            return (Criteria) this;
        }

        public Criteria andGuestIdEqualTo(Integer value) {
            addCriterion("guest_id =", value, "guestId");
            return (Criteria) this;
        }

        public Criteria andGuestIdNotEqualTo(Integer value) {
            addCriterion("guest_id <>", value, "guestId");
            return (Criteria) this;
        }

        public Criteria andGuestIdGreaterThan(Integer value) {
            addCriterion("guest_id >", value, "guestId");
            return (Criteria) this;
        }

        public Criteria andGuestIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("guest_id >=", value, "guestId");
            return (Criteria) this;
        }

        public Criteria andGuestIdLessThan(Integer value) {
            addCriterion("guest_id <", value, "guestId");
            return (Criteria) this;
        }

        public Criteria andGuestIdLessThanOrEqualTo(Integer value) {
            addCriterion("guest_id <=", value, "guestId");
            return (Criteria) this;
        }

        public Criteria andGuestIdIn(List<Integer> values) {
            addCriterion("guest_id in", values, "guestId");
            return (Criteria) this;
        }

        public Criteria andGuestIdNotIn(List<Integer> values) {
            addCriterion("guest_id not in", values, "guestId");
            return (Criteria) this;
        }

        public Criteria andGuestIdBetween(Integer value1, Integer value2) {
            addCriterion("guest_id between", value1, value2, "guestId");
            return (Criteria) this;
        }

        public Criteria andGuestIdNotBetween(Integer value1, Integer value2) {
            addCriterion("guest_id not between", value1, value2, "guestId");
            return (Criteria) this;
        }

        public Criteria andChargeIdIsNull() {
            addCriterion("charge_id is null");
            return (Criteria) this;
        }

        public Criteria andChargeIdIsNotNull() {
            addCriterion("charge_id is not null");
            return (Criteria) this;
        }

        public Criteria andChargeIdEqualTo(Integer value) {
            addCriterion("charge_id =", value, "chargeId");
            return (Criteria) this;
        }

        public Criteria andChargeIdNotEqualTo(Integer value) {
            addCriterion("charge_id <>", value, "chargeId");
            return (Criteria) this;
        }

        public Criteria andChargeIdGreaterThan(Integer value) {
            addCriterion("charge_id >", value, "chargeId");
            return (Criteria) this;
        }

        public Criteria andChargeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("charge_id >=", value, "chargeId");
            return (Criteria) this;
        }

        public Criteria andChargeIdLessThan(Integer value) {
            addCriterion("charge_id <", value, "chargeId");
            return (Criteria) this;
        }

        public Criteria andChargeIdLessThanOrEqualTo(Integer value) {
            addCriterion("charge_id <=", value, "chargeId");
            return (Criteria) this;
        }

        public Criteria andChargeIdIn(List<Integer> values) {
            addCriterion("charge_id in", values, "chargeId");
            return (Criteria) this;
        }

        public Criteria andChargeIdNotIn(List<Integer> values) {
            addCriterion("charge_id not in", values, "chargeId");
            return (Criteria) this;
        }

        public Criteria andChargeIdBetween(Integer value1, Integer value2) {
            addCriterion("charge_id between", value1, value2, "chargeId");
            return (Criteria) this;
        }

        public Criteria andChargeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("charge_id not between", value1, value2, "chargeId");
            return (Criteria) this;
        }

        public Criteria andBorrowCabinetIdIsNull() {
            addCriterion("borrow_cabinet_id is null");
            return (Criteria) this;
        }

        public Criteria andBorrowCabinetIdIsNotNull() {
            addCriterion("borrow_cabinet_id is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowCabinetIdEqualTo(Integer value) {
            addCriterion("borrow_cabinet_id =", value, "borrowCabinetId");
            return (Criteria) this;
        }

        public Criteria andBorrowCabinetIdNotEqualTo(Integer value) {
            addCriterion("borrow_cabinet_id <>", value, "borrowCabinetId");
            return (Criteria) this;
        }

        public Criteria andBorrowCabinetIdGreaterThan(Integer value) {
            addCriterion("borrow_cabinet_id >", value, "borrowCabinetId");
            return (Criteria) this;
        }

        public Criteria andBorrowCabinetIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("borrow_cabinet_id >=", value, "borrowCabinetId");
            return (Criteria) this;
        }

        public Criteria andBorrowCabinetIdLessThan(Integer value) {
            addCriterion("borrow_cabinet_id <", value, "borrowCabinetId");
            return (Criteria) this;
        }

        public Criteria andBorrowCabinetIdLessThanOrEqualTo(Integer value) {
            addCriterion("borrow_cabinet_id <=", value, "borrowCabinetId");
            return (Criteria) this;
        }

        public Criteria andBorrowCabinetIdIn(List<Integer> values) {
            addCriterion("borrow_cabinet_id in", values, "borrowCabinetId");
            return (Criteria) this;
        }

        public Criteria andBorrowCabinetIdNotIn(List<Integer> values) {
            addCriterion("borrow_cabinet_id not in", values, "borrowCabinetId");
            return (Criteria) this;
        }

        public Criteria andBorrowCabinetIdBetween(Integer value1, Integer value2) {
            addCriterion("borrow_cabinet_id between", value1, value2, "borrowCabinetId");
            return (Criteria) this;
        }

        public Criteria andBorrowCabinetIdNotBetween(Integer value1, Integer value2) {
            addCriterion("borrow_cabinet_id not between", value1, value2, "borrowCabinetId");
            return (Criteria) this;
        }

        public Criteria andReturnCabinetIdIsNull() {
            addCriterion("return_cabinet_id is null");
            return (Criteria) this;
        }

        public Criteria andReturnCabinetIdIsNotNull() {
            addCriterion("return_cabinet_id is not null");
            return (Criteria) this;
        }

        public Criteria andReturnCabinetIdEqualTo(Integer value) {
            addCriterion("return_cabinet_id =", value, "returnCabinetId");
            return (Criteria) this;
        }

        public Criteria andReturnCabinetIdNotEqualTo(Integer value) {
            addCriterion("return_cabinet_id <>", value, "returnCabinetId");
            return (Criteria) this;
        }

        public Criteria andReturnCabinetIdGreaterThan(Integer value) {
            addCriterion("return_cabinet_id >", value, "returnCabinetId");
            return (Criteria) this;
        }

        public Criteria andReturnCabinetIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("return_cabinet_id >=", value, "returnCabinetId");
            return (Criteria) this;
        }

        public Criteria andReturnCabinetIdLessThan(Integer value) {
            addCriterion("return_cabinet_id <", value, "returnCabinetId");
            return (Criteria) this;
        }

        public Criteria andReturnCabinetIdLessThanOrEqualTo(Integer value) {
            addCriterion("return_cabinet_id <=", value, "returnCabinetId");
            return (Criteria) this;
        }

        public Criteria andReturnCabinetIdIn(List<Integer> values) {
            addCriterion("return_cabinet_id in", values, "returnCabinetId");
            return (Criteria) this;
        }

        public Criteria andReturnCabinetIdNotIn(List<Integer> values) {
            addCriterion("return_cabinet_id not in", values, "returnCabinetId");
            return (Criteria) this;
        }

        public Criteria andReturnCabinetIdBetween(Integer value1, Integer value2) {
            addCriterion("return_cabinet_id between", value1, value2, "returnCabinetId");
            return (Criteria) this;
        }

        public Criteria andReturnCabinetIdNotBetween(Integer value1, Integer value2) {
            addCriterion("return_cabinet_id not between", value1, value2, "returnCabinetId");
            return (Criteria) this;
        }

        public Criteria andBorrowTimeSecondsIsNull() {
            addCriterion("borrow_time_seconds is null");
            return (Criteria) this;
        }

        public Criteria andBorrowTimeSecondsIsNotNull() {
            addCriterion("borrow_time_seconds is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowTimeSecondsEqualTo(Long value) {
            addCriterion("borrow_time_seconds =", value, "borrowTimeSeconds");
            return (Criteria) this;
        }

        public Criteria andBorrowTimeSecondsNotEqualTo(Long value) {
            addCriterion("borrow_time_seconds <>", value, "borrowTimeSeconds");
            return (Criteria) this;
        }

        public Criteria andBorrowTimeSecondsGreaterThan(Long value) {
            addCriterion("borrow_time_seconds >", value, "borrowTimeSeconds");
            return (Criteria) this;
        }

        public Criteria andBorrowTimeSecondsGreaterThanOrEqualTo(Long value) {
            addCriterion("borrow_time_seconds >=", value, "borrowTimeSeconds");
            return (Criteria) this;
        }

        public Criteria andBorrowTimeSecondsLessThan(Long value) {
            addCriterion("borrow_time_seconds <", value, "borrowTimeSeconds");
            return (Criteria) this;
        }

        public Criteria andBorrowTimeSecondsLessThanOrEqualTo(Long value) {
            addCriterion("borrow_time_seconds <=", value, "borrowTimeSeconds");
            return (Criteria) this;
        }

        public Criteria andBorrowTimeSecondsIn(List<Long> values) {
            addCriterion("borrow_time_seconds in", values, "borrowTimeSeconds");
            return (Criteria) this;
        }

        public Criteria andBorrowTimeSecondsNotIn(List<Long> values) {
            addCriterion("borrow_time_seconds not in", values, "borrowTimeSeconds");
            return (Criteria) this;
        }

        public Criteria andBorrowTimeSecondsBetween(Long value1, Long value2) {
            addCriterion("borrow_time_seconds between", value1, value2, "borrowTimeSeconds");
            return (Criteria) this;
        }

        public Criteria andBorrowTimeSecondsNotBetween(Long value1, Long value2) {
            addCriterion("borrow_time_seconds not between", value1, value2, "borrowTimeSeconds");
            return (Criteria) this;
        }

        public Criteria andReturnTimeSecondsIsNull() {
            addCriterion("return_time_seconds is null");
            return (Criteria) this;
        }

        public Criteria andReturnTimeSecondsIsNotNull() {
            addCriterion("return_time_seconds is not null");
            return (Criteria) this;
        }

        public Criteria andReturnTimeSecondsEqualTo(Long value) {
            addCriterion("return_time_seconds =", value, "returnTimeSeconds");
            return (Criteria) this;
        }

        public Criteria andReturnTimeSecondsNotEqualTo(Long value) {
            addCriterion("return_time_seconds <>", value, "returnTimeSeconds");
            return (Criteria) this;
        }

        public Criteria andReturnTimeSecondsGreaterThan(Long value) {
            addCriterion("return_time_seconds >", value, "returnTimeSeconds");
            return (Criteria) this;
        }

        public Criteria andReturnTimeSecondsGreaterThanOrEqualTo(Long value) {
            addCriterion("return_time_seconds >=", value, "returnTimeSeconds");
            return (Criteria) this;
        }

        public Criteria andReturnTimeSecondsLessThan(Long value) {
            addCriterion("return_time_seconds <", value, "returnTimeSeconds");
            return (Criteria) this;
        }

        public Criteria andReturnTimeSecondsLessThanOrEqualTo(Long value) {
            addCriterion("return_time_seconds <=", value, "returnTimeSeconds");
            return (Criteria) this;
        }

        public Criteria andReturnTimeSecondsIn(List<Long> values) {
            addCriterion("return_time_seconds in", values, "returnTimeSeconds");
            return (Criteria) this;
        }

        public Criteria andReturnTimeSecondsNotIn(List<Long> values) {
            addCriterion("return_time_seconds not in", values, "returnTimeSeconds");
            return (Criteria) this;
        }

        public Criteria andReturnTimeSecondsBetween(Long value1, Long value2) {
            addCriterion("return_time_seconds between", value1, value2, "returnTimeSeconds");
            return (Criteria) this;
        }

        public Criteria andReturnTimeSecondsNotBetween(Long value1, Long value2) {
            addCriterion("return_time_seconds not between", value1, value2, "returnTimeSeconds");
            return (Criteria) this;
        }

        public Criteria andMBillIsNull() {
            addCriterion("m_bill is null");
            return (Criteria) this;
        }

        public Criteria andMBillIsNotNull() {
            addCriterion("m_bill is not null");
            return (Criteria) this;
        }

        public Criteria andMBillEqualTo(Double value) {
            addCriterion("m_bill =", value, "mBill");
            return (Criteria) this;
        }

        public Criteria andMBillNotEqualTo(Double value) {
            addCriterion("m_bill <>", value, "mBill");
            return (Criteria) this;
        }

        public Criteria andMBillGreaterThan(Double value) {
            addCriterion("m_bill >", value, "mBill");
            return (Criteria) this;
        }

        public Criteria andMBillGreaterThanOrEqualTo(Double value) {
            addCriterion("m_bill >=", value, "mBill");
            return (Criteria) this;
        }

        public Criteria andMBillLessThan(Double value) {
            addCriterion("m_bill <", value, "mBill");
            return (Criteria) this;
        }

        public Criteria andMBillLessThanOrEqualTo(Double value) {
            addCriterion("m_bill <=", value, "mBill");
            return (Criteria) this;
        }

        public Criteria andMBillIn(List<Double> values) {
            addCriterion("m_bill in", values, "mBill");
            return (Criteria) this;
        }

        public Criteria andMBillNotIn(List<Double> values) {
            addCriterion("m_bill not in", values, "mBill");
            return (Criteria) this;
        }

        public Criteria andMBillBetween(Double value1, Double value2) {
            addCriterion("m_bill between", value1, value2, "mBill");
            return (Criteria) this;
        }

        public Criteria andMBillNotBetween(Double value1, Double value2) {
            addCriterion("m_bill not between", value1, value2, "mBill");
            return (Criteria) this;
        }

        public Criteria andMPrepaymentIsNull() {
            addCriterion("m_prepayment is null");
            return (Criteria) this;
        }

        public Criteria andMPrepaymentIsNotNull() {
            addCriterion("m_prepayment is not null");
            return (Criteria) this;
        }

        public Criteria andMPrepaymentEqualTo(Double value) {
            addCriterion("m_prepayment =", value, "mPrepayment");
            return (Criteria) this;
        }

        public Criteria andMPrepaymentNotEqualTo(Double value) {
            addCriterion("m_prepayment <>", value, "mPrepayment");
            return (Criteria) this;
        }

        public Criteria andMPrepaymentGreaterThan(Double value) {
            addCriterion("m_prepayment >", value, "mPrepayment");
            return (Criteria) this;
        }

        public Criteria andMPrepaymentGreaterThanOrEqualTo(Double value) {
            addCriterion("m_prepayment >=", value, "mPrepayment");
            return (Criteria) this;
        }

        public Criteria andMPrepaymentLessThan(Double value) {
            addCriterion("m_prepayment <", value, "mPrepayment");
            return (Criteria) this;
        }

        public Criteria andMPrepaymentLessThanOrEqualTo(Double value) {
            addCriterion("m_prepayment <=", value, "mPrepayment");
            return (Criteria) this;
        }

        public Criteria andMPrepaymentIn(List<Double> values) {
            addCriterion("m_prepayment in", values, "mPrepayment");
            return (Criteria) this;
        }

        public Criteria andMPrepaymentNotIn(List<Double> values) {
            addCriterion("m_prepayment not in", values, "mPrepayment");
            return (Criteria) this;
        }

        public Criteria andMPrepaymentBetween(Double value1, Double value2) {
            addCriterion("m_prepayment between", value1, value2, "mPrepayment");
            return (Criteria) this;
        }

        public Criteria andMPrepaymentNotBetween(Double value1, Double value2) {
            addCriterion("m_prepayment not between", value1, value2, "mPrepayment");
            return (Criteria) this;
        }

        public Criteria andMBalanceIsNull() {
            addCriterion("m_balance is null");
            return (Criteria) this;
        }

        public Criteria andMBalanceIsNotNull() {
            addCriterion("m_balance is not null");
            return (Criteria) this;
        }

        public Criteria andMBalanceEqualTo(Double value) {
            addCriterion("m_balance =", value, "mBalance");
            return (Criteria) this;
        }

        public Criteria andMBalanceNotEqualTo(Double value) {
            addCriterion("m_balance <>", value, "mBalance");
            return (Criteria) this;
        }

        public Criteria andMBalanceGreaterThan(Double value) {
            addCriterion("m_balance >", value, "mBalance");
            return (Criteria) this;
        }

        public Criteria andMBalanceGreaterThanOrEqualTo(Double value) {
            addCriterion("m_balance >=", value, "mBalance");
            return (Criteria) this;
        }

        public Criteria andMBalanceLessThan(Double value) {
            addCriterion("m_balance <", value, "mBalance");
            return (Criteria) this;
        }

        public Criteria andMBalanceLessThanOrEqualTo(Double value) {
            addCriterion("m_balance <=", value, "mBalance");
            return (Criteria) this;
        }

        public Criteria andMBalanceIn(List<Double> values) {
            addCriterion("m_balance in", values, "mBalance");
            return (Criteria) this;
        }

        public Criteria andMBalanceNotIn(List<Double> values) {
            addCriterion("m_balance not in", values, "mBalance");
            return (Criteria) this;
        }

        public Criteria andMBalanceBetween(Double value1, Double value2) {
            addCriterion("m_balance between", value1, value2, "mBalance");
            return (Criteria) this;
        }

        public Criteria andMBalanceNotBetween(Double value1, Double value2) {
            addCriterion("m_balance not between", value1, value2, "mBalance");
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
package com.demo.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class OmsOrder implements Serializable {
    private Integer id;

    private Integer guestId;

    private Integer chargeId;

    private Integer borrowCabinetId;

    private Integer returnCabinetId;

    private Long borrowTimeSeconds;

    private Long returnTimeSeconds;

    private Double mBill;

    private Double mPrepayment;

    private Double mBalance;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGuestId() {
        return guestId;
    }

    public void setGuestId(Integer guestId) {
        this.guestId = guestId;
    }

    public Integer getChargeId() {
        return chargeId;
    }

    public void setChargeId(Integer chargeId) {
        this.chargeId = chargeId;
    }

    public Integer getBorrowCabinetId() {
        return borrowCabinetId;
    }

    public void setBorrowCabinetId(Integer borrowCabinetId) {
        this.borrowCabinetId = borrowCabinetId;
    }

    public Integer getReturnCabinetId() {
        return returnCabinetId;
    }

    public void setReturnCabinetId(Integer returnCabinetId) {
        this.returnCabinetId = returnCabinetId;
    }

    public Long getBorrowTimeSeconds() {
        return borrowTimeSeconds;
    }

    public void setBorrowTimeSeconds(Long borrowTimeSeconds) {
        this.borrowTimeSeconds = borrowTimeSeconds;
    }

    public Long getReturnTimeSeconds() {
        return returnTimeSeconds;
    }

    public void setReturnTimeSeconds(Long returnTimeSeconds) {
        this.returnTimeSeconds = returnTimeSeconds;
    }

    public Double getmBill() {
        return mBill;
    }

    public void setmBill(Double mBill) {
        this.mBill = mBill;
    }

    public Double getmPrepayment() {
        return mPrepayment;
    }

    public void setmPrepayment(Double mPrepayment) {
        this.mPrepayment = mPrepayment;
    }

    public Double getmBalance() {
        return mBalance;
    }

    public void setmBalance(Double mBalance) {
        this.mBalance = mBalance;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", guestId=").append(guestId);
        sb.append(", chargeId=").append(chargeId);
        sb.append(", borrowCabinetId=").append(borrowCabinetId);
        sb.append(", returnCabinetId=").append(returnCabinetId);
        sb.append(", borrowTimeSeconds=").append(borrowTimeSeconds);
        sb.append(", returnTimeSeconds=").append(returnTimeSeconds);
        sb.append(", mBill=").append(mBill);
        sb.append(", mPrepayment=").append(mPrepayment);
        sb.append(", mBalance=").append(mBalance);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
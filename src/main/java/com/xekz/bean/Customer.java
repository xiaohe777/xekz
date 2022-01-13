package com.xekz.bean;

public class Customer {
    private Integer customerId;

    private String customerRealname;

    private String customerTel;

    private String customerIdno;

    private Integer userId;

    private Integer isValid;

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerRealname='" + customerRealname + '\'' +
                ", customerTel='" + customerTel + '\'' +
                ", customerIdno='" + customerIdno + '\'' +
                ", userId=" + userId +
                ", isValid=" + isValid +
                '}';
    }

    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerRealname() {
        return customerRealname;
    }

    public void setCustomerRealname(String customerRealname) {
        this.customerRealname = customerRealname == null ? null : customerRealname.trim();
    }

    public String getCustomerTel() {
        return customerTel;
    }

    public void setCustomerTel(String customerTel) {
        this.customerTel = customerTel == null ? null : customerTel.trim();
    }

    public String getCustomerIdno() {
        return customerIdno;
    }

    public void setCustomerIdno(String customerIdno) {
        this.customerIdno = customerIdno == null ? null : customerIdno.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
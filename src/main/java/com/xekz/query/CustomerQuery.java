package com.xekz.query;

import com.xekz.base.BaseQuery;

public class CustomerQuery extends BaseQuery {
    private String customerRealname;
    private String customerIdno;
    private String customerTel;
    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCustomerRealname() {
        return customerRealname;
    }

    public void setCustomerRealname(String customerRealname) {
        this.customerRealname = customerRealname;
    }

    public String getCustomerIdno() {
        return customerIdno;
    }

    public void setCustomerIdno(String customerIdno) {
        this.customerIdno = customerIdno;
    }

    public String getCustomerTel() {
        return customerTel;
    }

    public void setCustomerTel(String customerTel) {
        this.customerTel = customerTel;
    }
}

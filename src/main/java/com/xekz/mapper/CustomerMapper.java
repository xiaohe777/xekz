package com.xekz.mapper;

import com.xekz.base.BaseMapper;
import com.xekz.bean.Customer;

public interface CustomerMapper extends BaseMapper<Customer,Integer> {
    String selectByParam(Customer customer);
    Customer selectByParam1(Customer customer);

}
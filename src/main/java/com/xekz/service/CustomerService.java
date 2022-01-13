package com.xekz.service;

import com.xekz.base.BaseService;
import com.xekz.bean.Customer;
import com.xekz.bean.Room;
import com.xekz.mapper.CustomerMapper;
import com.xekz.mapper.OrderMapper;
import com.xekz.utils.AssertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService extends BaseService<Customer,Integer> {
    @Autowired(required = false)
    private CustomerMapper customerMapper;
    @Autowired(required = false)
    private OrderMapper orderMapper;


    @Transactional(propagation = Propagation.REQUIRED)
    public void updateCustomer (Customer customer) {
        // 1.参数校验
        // 通过id查询记录
        Customer temp = customerMapper.selectByPrimaryKey(customer.getCustomerId());
        // 判断是否为空
        AssertUtil.isTrue(null == temp, "待更新记录不存在！");
        // 校验基础参数

        AssertUtil.isTrue(customerMapper.updateByPrimaryKeySelective(customer) < 1, "联系人信息修改失败！");
    }

    public Customer selectByParam(Customer customer) {
        return customerMapper.selectByParam1(customer);
    }

    public Room selectByRoomId(Integer roomId) {
        return orderMapper.selectByRoomId(roomId);
    }
}

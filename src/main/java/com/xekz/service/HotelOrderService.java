package com.xekz.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xekz.base.BaseService;
import com.xekz.bean.Order;
import com.xekz.bean.Room;
import com.xekz.mapper.OrderMapper;
import com.xekz.query.OrderQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class HotelOrderService extends BaseService<Room,Integer>{


    @Autowired(required = false)
    private OrderMapper orderMapper;

    public Map<String,Object> findOrder(){
        Map<String,Object> map = new HashMap<>();
        map.put("data",orderMapper.selectOrder());
        return map;
    }

    public Map<String,Object> findRoomByDate(OrderQuery orderQuery) {
        Map<String,Object> map = new HashMap<>();
//        List<Order> list = new ArrayList<>();
        PageHelper.startPage(orderQuery.getPage(),orderQuery.getLimit());

        PageInfo<Room> pageInfo = new PageInfo<>(orderMapper.selectRoomByDate(orderQuery));
        map.put("code",0);
        map.put("msg","success");
        map.put("count",pageInfo.getTotal());
        map.put("data",pageInfo.getList());
        return map;
    }

    public Map<String,Object> selectOrderByUserId(Integer userId) {
        Map<String,Object> map = new HashMap<>();

        PageInfo<Object> pageInfo = new PageInfo<Object>(orderMapper.selectOrderByUserId(userId));
        System.out.println(orderMapper.selectOrderByUserId(userId));
        map.put("code",0);
        map.put("msg","success");
        map.put("count",pageInfo.getTotal());
        map.put("data",pageInfo.getList());
        return map;
    }

    public void insertOrder(Order order) {
        orderMapper.insertSelective(order);
    }
}

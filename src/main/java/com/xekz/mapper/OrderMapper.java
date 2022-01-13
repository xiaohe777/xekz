package com.xekz.mapper;

import com.xekz.base.BaseMapper;
import com.xekz.bean.Order;
import com.xekz.bean.Room;
import com.xekz.query.OrderQuery;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

public interface OrderMapper extends BaseMapper<Order,Integer> {

    @MapKey("")
    Map<String,Object> selectOrder();


    List<Room> selectRoomByDate(OrderQuery orderQuery);

    List<Object> selectCusByUserId(Integer userId);

    List<Object> selectOrderByUserId(Integer userId);

    Room selectByRoomId(Integer roomId);
}
package com.xekz.controller;

import com.xekz.base.BaseController;
import com.xekz.base.ResultInfo;
import com.xekz.bean.Customer;
import com.xekz.bean.Order;
import com.xekz.bean.Room;
import com.xekz.query.OrderQuery;
import com.xekz.service.CustomerService;
import com.xekz.service.HotelOrderService;
import com.xekz.utils.LoginUserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("order")
public class HotelOrderController extends BaseController {

    @Autowired
    private HotelOrderService hotelOrderService;
    @Autowired
    private CustomerService customerService;

    @RequestMapping("list")
    @ResponseBody
    public Map<String,Object> findOrder(){
        return hotelOrderService.findOrder();
    }

    @RequestMapping("all")
    public String findAllOrder(){
        return "user/room";
    }
    @RequestMapping("user")
    public String findAllOrderByUser(){
        return "user/ordermsg";
    }

    @RequestMapping("insert")
    @ResponseBody
    public ResultInfo insertOrder(HttpServletRequest request, Customer customer,Date entryDate,Integer roomId){
        // 获取用户ID
        Integer userId = LoginUserUtil.releaseUserIdFromCookie(request);
        // 获取用户-顾客的真实姓名
        customer.setUserId(1);
        Customer customer1 = customerService.selectByParam(customer);
        Room room = new Room();
        room.setRoomId(roomId);
        room=customerService.selectByRoomId(roomId);


        Order order = new Order();
        order.setOrderDate(new Date());
        order.setOrderTel(customer1.getCustomerTel());
        order.setRoomId(roomId);
        order.setEntryDate(entryDate);
        order.setUserId(userId);
        order.setOrderPrice(room.getRoomPrice());
        order.setRoomType(room.getRoomType());
        hotelOrderService.insertOrder(order);
        return success("预定成功！");
    }
    /**
     * 根据入住日期查询空房间Id
     * @return
     */
    @RequestMapping("room")
    @ResponseBody
    public Map<String, Object> findRoomByDate(OrderQuery orderQuery){
        System.out.println(orderQuery.getEntryDate());
        return hotelOrderService.findRoomByDate(orderQuery);
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping("index")
    public String index(){
        return "user/order";
    }

    @RequestMapping("hotelOrder")
    public String addOrUpdateSaleChancePage() {
        return "user/chance";
    }

    @RequestMapping("clist")
    @ResponseBody
    public Map<String,Object> findOrder(HttpServletRequest request,Customer customer){
        // 如果id不为空，表示是修改操作，修改操作需要查询被修改的数据
        Integer userId = LoginUserUtil.releaseUserIdFromCookie(request);
        customer.setUserId(userId);
        // 将数据存到作用域中
        System.out.println(hotelOrderService.selectOrderByUserId(userId));
        return hotelOrderService.selectOrderByUserId(userId);
    }


}

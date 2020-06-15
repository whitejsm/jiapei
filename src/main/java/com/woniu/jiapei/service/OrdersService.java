package com.woniu.jiapei.service;

import com.woniu.jiapei.condition.OrderCondition;
import com.woniu.jiapei.model.Customer;
import com.woniu.jiapei.model.Orders;
import com.woniu.jiapei.tools.PageBean;

import java.util.List;

/**
 * @author 周元皓丶
 */
public interface OrdersService {
    List<Orders> selectByCustomerId(int customerId);

    Integer countCustomerOrders(int customerId);

    List<Orders> getAllOrders();

    List<Orders> getOrdersByCondition(PageBean pageBean, OrderCondition orderCondition);

    List<Orders> getOrdersByCondition(OrderCondition orderCondition);

    void insertOrders(List<Orders> list);

    List<Orders> downOrdersByCid(Integer customerId);
}

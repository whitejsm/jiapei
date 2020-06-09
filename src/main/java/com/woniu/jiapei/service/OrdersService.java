package com.woniu.jiapei.service;

import com.woniu.jiapei.model.Orders;

import java.util.List;

/**
 * @author 周元皓丶
 */
public interface OrdersService {
    List<Orders> selectByCustomerId(int customerId);

    Integer countCustomerOrders(int customerId);
}

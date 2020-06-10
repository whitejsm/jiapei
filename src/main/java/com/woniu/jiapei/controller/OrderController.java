/**
 * order controller
 * @since 2020/06/09
 * @Author ytmzz
 */
package com.woniu.jiapei.controller;

import com.woniu.jiapei.condition.OrderCondition;
import com.woniu.jiapei.model.Orders;
import com.woniu.jiapei.service.OrdersService;
import com.woniu.jiapei.tools.PageBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class OrderController {
    @Resource
    private OrdersService ordersServiceImpl;

    @GetMapping("/getAllOrders")
    public Map<String, Object> getAllOrders() {
        Map<String, Object> map = new HashMap<>();

        try {
            List<Orders> ordersList = ordersServiceImpl.getAllOrders();
            map.put("ordersList", ordersList);
            map.put("result", "ok");
        } catch(Exception e) {
            map.put("result", "error");
        }

        return map;
    }

    @GetMapping("/getOrdersByCondition")
    public Map<String, Object> getOrdersByCondition(PageBean pageBean, OrderCondition orderCondition) {
        Map<String, Object> map = new HashMap<>();
        System.out.println(orderCondition);
        System.out.println(pageBean);
        try {
            List<Orders> ordersList = ordersServiceImpl.getOrdersByCondition(pageBean, orderCondition);
            map.put("ordersList", ordersList);
            map.put("pageBean", pageBean);
            map.put("result", "ok");
        } catch(Exception e) {
            e.printStackTrace();
            map.put("result", "error");
        }

        return map;
    }
}

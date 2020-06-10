package com.woniu.jiapei.controller;


import com.woniu.jiapei.condition.CustomerCondition;
import com.woniu.jiapei.model.Customer;
import com.woniu.jiapei.model.Orders;
import com.woniu.jiapei.service.CustomerService;
import com.woniu.jiapei.service.OrdersService;
import com.woniu.jiapei.tools.PageBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 周元皓丶
 * 普通用户管理控制器
 */
@RestController
public class CustomerController {
    @Resource
    CustomerService customerServiceImpl;

    @Resource
    OrdersService ordersServiceImpl;

    @GetMapping("/getAllCustomer")
    public Map<String,Object> getAllCustomer(PageBean pageBean, CustomerCondition customerCondition) throws ParseException {
        System.out.println(customerCondition);
        Map<String,Object> map=new HashMap<String,Object>();
        List<Customer> list=customerServiceImpl.findAll(pageBean,customerCondition);
        Integer countCustomer=customerServiceImpl.countCustomer();
        map.put("pageBean",pageBean);
        map.put("customerList",list);
        map.put("countCustomer",countCustomer);
        return map;
    }
    @GetMapping("/getAllCustomerSelect")
    public Map<String,Object> getAllCustomerSelect(PageBean pageBean, CustomerCondition customerCondition) throws ParseException {
        System.out.println(customerCondition.getEndTime());
        System.out.println(customerCondition);
        Map<String,Object> map=new HashMap<String,Object>();
        List<Customer> list=customerServiceImpl.findAll(pageBean,customerCondition);
        Integer countCustomer=customerServiceImpl.countCustomer();
        map.put("pageBean",pageBean);
        map.put("customerList",list);
        map.put("countCustomer",countCustomer);
        return map;
    }

    @GetMapping("/findCustomerOrder")
    public Map<String,Object> findCustomerOrder(int customerId) {
        Map<String,Object> map=new HashMap<String,Object>();
        List<Orders> list=ordersServiceImpl.selectByCustomerId(customerId);
        Integer countOrders=ordersServiceImpl.countCustomerOrders(customerId);
        map.put("ordersList",list);
        map.put("countOrders",countOrders);
        return map;
    }

    @PostMapping("/updateCustomer")
    public void updateCustomer(Customer customer){
        customerServiceImpl.updateOne(customer);
    }
}

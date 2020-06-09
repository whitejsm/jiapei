package com.woniu.jiapei.controller;


import com.woniu.jiapei.model.Customer;
import com.woniu.jiapei.service.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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

    @GetMapping("/getAllCustomer")
    public Map<String,Object> getAllCustomer(){
        Map<String,Object> map=new HashMap<String,Object>();
        List<Customer> list=customerServiceImpl.findAll();
        map.put("customerList",list);
        return map;
    }
}

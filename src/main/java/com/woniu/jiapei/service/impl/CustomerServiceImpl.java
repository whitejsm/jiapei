package com.woniu.jiapei.service.impl;

import com.woniu.jiapei.mapper.CustomerMapper;
import com.woniu.jiapei.mapper.OrdersMapper;
import com.woniu.jiapei.model.Customer;
import com.woniu.jiapei.service.CustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 周元皓丶
 * 普通用户业务实现类
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Resource
    CustomerMapper customerMapper;

    @Resource
    OrdersMapper ordersMapper;

    @Override
    public List<Customer> findAll() {
        List<Customer> list=customerMapper.selectByExample(null);
        for (Customer customer : list) {
             customer.setOrderCount(ordersMapper.countById(customer.getCustomerId()));
             customer.setSumMoney(ordersMapper.countMoneyById(customer.getCustomerId()));
        }
        return list;
    }

    @Override
    public Integer countCustomer() {
        return customerMapper.countCustomer();
    }

    @Override
    public void updateOne(Customer customer) {
        customerMapper.updateByPrimaryKeySelective(customer);
    }
}

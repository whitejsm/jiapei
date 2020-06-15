package com.woniu.jiapei.service;

import com.woniu.jiapei.condition.CustomerCondition;
import com.woniu.jiapei.model.Customer;
import com.woniu.jiapei.tools.PageBean;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll(PageBean pageBean, CustomerCondition customerCondition);

    Integer countCustomer();

    void updateOne(Customer customer);

    List<Customer> downByCondition(CustomerCondition customerCondition);
}

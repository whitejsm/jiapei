package com.woniu.jiapei.service;

import com.woniu.jiapei.model.Customer;
import com.woniu.jiapei.tools.PageBean;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll(PageBean pageBean);

    Integer countCustomer();

    void updateOne(Customer customer);
}

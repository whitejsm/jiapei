package com.woniu.jiapei.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.jiapei.condition.CustomerCondition;
import com.woniu.jiapei.mapper.CustomerMapper;
import com.woniu.jiapei.mapper.OrdersMapper;
import com.woniu.jiapei.model.Customer;
import com.woniu.jiapei.service.CustomerService;
import com.woniu.jiapei.tools.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    public List<Customer> findAll(PageBean pageBean, CustomerCondition customerCondition) {
        PageHelper.startPage(pageBean.getPageNum(),pageBean.getPageSize());
        List<Customer> list=customerMapper.getCusetomerByCondition(customerCondition);
        for (Customer customer : list) {
             customer.setOrderCount(ordersMapper.countById(customer.getCustomerId()));
             customer.setSumMoney(ordersMapper.countMoneyById(customer.getCustomerId()));
        }
        PageInfo<Customer> pageInfo = new PageInfo<Customer>(list);
        pageBean.setPages(pageInfo.getPages());
        pageBean.setTotal((int) pageInfo.getTotal());
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


    @Override
    public List<Customer> downByCondition(CustomerCondition customerCondition) {
        return customerMapper.downByCondition(customerCondition);
    }
}

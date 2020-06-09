package com.woniu.jiapei.service.impl;

import com.woniu.jiapei.mapper.CustomerMapper;
import com.woniu.jiapei.model.Customer;
import com.woniu.jiapei.service.CustomerService;
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

    @Override
    public List<Customer> findAll() {
        return customerMapper.selectByExample(null);
    }
}

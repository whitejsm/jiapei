package com.woniu.jiapei.service;

import com.woniu.jiapei.condition.AccountingCondition;
import com.woniu.jiapei.model.Customer;
import com.woniu.jiapei.model.UserInfo;
import com.woniu.jiapei.tools.PageBean;

import java.util.List;

public interface UserInfoService {
    public UserInfo findByName(String username);

    List<Customer> findAllAccounting(PageBean pageBean, AccountingCondition accountingCondition);

    Integer countAccounting();
}

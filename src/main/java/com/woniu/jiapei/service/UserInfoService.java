package com.woniu.jiapei.service;

import com.woniu.jiapei.condition.AccountingCondition;
import com.woniu.jiapei.model.Customer;
import com.woniu.jiapei.model.Role;
import com.woniu.jiapei.model.UserInfo;
import com.woniu.jiapei.tools.PageBean;

import java.util.List;

public interface UserInfoService {
    public UserInfo findByName(String username);

    List<UserInfo> findAllAccounting(PageBean pageBean, AccountingCondition accountingCondition);

    Integer countAccounting();

    void addAccounting(UserInfo userInfo);

    void updateAccounting(UserInfo userInfo);

    List<UserInfo> findAllRepairman(PageBean pageBean, AccountingCondition accountingCondition);

    Integer countRepairman();

    void addRepairman(UserInfo userInfo);

    void updateRepairman(UserInfo userInfo);

    Role findRoleByUserId(Integer userinfoId);

    List<UserInfo> getDistributor(Integer userId);
}

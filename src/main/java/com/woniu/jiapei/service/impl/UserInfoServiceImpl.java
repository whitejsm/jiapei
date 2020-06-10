package com.woniu.jiapei.service.impl;

import com.woniu.jiapei.condition.AccountingCondition;
import com.woniu.jiapei.mapper.UserInfoMapper;
import com.woniu.jiapei.model.Customer;
import com.woniu.jiapei.model.UserInfo;
import com.woniu.jiapei.service.UserInfoService;
import com.woniu.jiapei.tools.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    UserInfoMapper userInfoMapper;


    /*
    根据登录用户名，查询用户是否存在，实现登录
     */
    @Override
    public UserInfo findByName(String username) {
        return userInfoMapper.findByName(username);
    }

    /**
     * 获取所有会计信息
     * @param pageBean
     * @param accountingCondition
     * @return
     */
    @Override
    public List<Customer> findAllAccounting(PageBean pageBean, AccountingCondition accountingCondition) {
        return null;
    }

    /**
     * 获取会计总人数
     * @return
     */
    @Override
    public Integer countAccounting() {
        return userInfoMapper.countAccounting();
    }
}

package com.woniu.jiapei.service.impl;

import com.woniu.jiapei.mapper.UserInfoMapper;
import com.woniu.jiapei.model.UserInfo;
import com.woniu.jiapei.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;



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
}

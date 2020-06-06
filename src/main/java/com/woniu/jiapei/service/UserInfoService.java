package com.woniu.jiapei.service;

import com.woniu.jiapei.model.UserInfo;

public interface UserInfoService {
    public UserInfo findByName(String username);
}

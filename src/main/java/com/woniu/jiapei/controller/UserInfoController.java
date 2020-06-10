package com.woniu.jiapei.controller;


import com.woniu.jiapei.service.UserInfoService;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 周元皓丶
 * 后台用户信息管理
 */
@RestController
public class UserInfoController {
    @Resource
    UserInfoService userInfoServiceImpl;



}

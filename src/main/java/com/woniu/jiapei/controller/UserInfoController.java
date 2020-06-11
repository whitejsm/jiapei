package com.woniu.jiapei.controller;


import com.woniu.jiapei.condition.AccountingCondition;
import com.woniu.jiapei.condition.CustomerCondition;
import com.woniu.jiapei.model.Customer;
import com.woniu.jiapei.model.UserInfo;
import com.woniu.jiapei.service.UserInfoService;
import com.woniu.jiapei.tools.PageBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 周元皓丶
 * 后台用户信息管理
 */
@RestController
public class UserInfoController {
    @Resource
    UserInfoService userInfoServiceImpl;


    /**
     * 获取会计列表
     */
    @GetMapping("/getAllAccounting")
    public Map<String,Object> getAllAccounting(PageBean pageBean, AccountingCondition accountingCondition) throws ParseException {
        System.out.println(accountingCondition);
        Map<String,Object> map=new HashMap<String,Object>();
        List<UserInfo> list=userInfoServiceImpl.findAllAccounting(pageBean,accountingCondition);
        Integer countAccounting=userInfoServiceImpl.countAccounting();
        map.put("pageBean",pageBean);
        map.put("accountingList",list);
        map.put("countAccounting",countAccounting);
        return map;
    }

    /**
     * 添加一个会计
     * @param userInfo
     */
    @PostMapping("addAccounting")
    public void addAccounting(UserInfo userInfo){
        userInfoServiceImpl.addAccounting(userInfo);
    }

    /**
     * 编辑会计信息
     */
    @PostMapping("updateAccounting")
    public void updateAccounting(UserInfo userInfo){
        userInfoServiceImpl.updateAccounting(userInfo);
    }

    /**
     * 获取维修人员列表
     */
    @GetMapping("/getAllRepairman")
    public Map<String,Object> getAllRepairman(PageBean pageBean, AccountingCondition accountingCondition) throws ParseException {
        Map<String,Object> map=new HashMap<String,Object>();
        List<UserInfo> list=userInfoServiceImpl.findAllRepairman(pageBean,accountingCondition);
        Integer countRepairman=userInfoServiceImpl.countRepairman();
        map.put("pageBean",pageBean);
        map.put("repairmanList",list);
        map.put("countRepairman",countRepairman);
        return map;
    }

    /**
     * 添加一个维修人员
     * @param userInfo
     */
    @PostMapping("addRepairman")
    public void addRepairman(UserInfo userInfo){
        userInfoServiceImpl.addRepairman(userInfo);
    }

    /**
     * 编辑维修人员信息
     */
    @PostMapping("updateRepairman")
    public void updateRepairman(UserInfo userInfo){
        userInfoServiceImpl.updateRepairman(userInfo);
    }

}

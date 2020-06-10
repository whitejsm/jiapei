package com.woniu.jiapei.controller;


import com.woniu.jiapei.condition.AccountingCondition;
import com.woniu.jiapei.condition.CustomerCondition;
import com.woniu.jiapei.model.Customer;
import com.woniu.jiapei.service.UserInfoService;
import com.woniu.jiapei.tools.PageBean;
import org.springframework.web.bind.annotation.GetMapping;
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
        List<Customer> list=userInfoServiceImpl.findAllAccounting(pageBean,accountingCondition);
        Integer countAccounting=userInfoServiceImpl.countAccounting();
        map.put("pageBean",pageBean);
        map.put("accountingList",list);
        map.put("countAccounting",countAccounting);
        return map;
    }


}

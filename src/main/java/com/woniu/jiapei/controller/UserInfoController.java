package com.woniu.jiapei.controller;


import com.woniu.jiapei.condition.AccountingCondition;
import com.woniu.jiapei.condition.CustomerCondition;
import com.woniu.jiapei.condition.MedicalCondition;
import com.woniu.jiapei.condition.ShareholderCondition;
import com.woniu.jiapei.model.Customer;
import com.woniu.jiapei.model.Hospital;
import com.woniu.jiapei.model.Shareholder;
import com.woniu.jiapei.model.UserInfo;
import com.woniu.jiapei.service.UserInfoService;
import com.woniu.jiapei.tools.PageBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
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
    /**
     * 获取医院科室对接人员列表
     */
    @GetMapping("/getAllMedical")
    public Map<String,Object> getAllMedical(PageBean pageBean, MedicalCondition medicalCondition) throws ParseException {
        Map<String,Object> map=new HashMap<String,Object>();
        List<UserInfo> list=userInfoServiceImpl.findAllMedical(pageBean,medicalCondition);
        Integer countMedical=userInfoServiceImpl.countMedical();
        map.put("pageBean",pageBean);
        map.put("medicalList",list);
        map.put("countMedical",countMedical);
        return map;
    }
    /**
     * 添加一个医院科室对接人
     * @param userInfo
     */
    @PostMapping("addMedical")
    public void addMedical(UserInfo userInfo,int level){
        userInfoServiceImpl.addMedical(userInfo,level);
    }

    /**
     * 编辑维修人员信息
     */
    @PostMapping("updateMedical")
    public void updateMedical(UserInfo userInfo,Boolean level){
        System.out.println(level);
        userInfoServiceImpl.updateMedical(userInfo,level);
    }

    @GetMapping("/getAllShareholder")
    public Map<String,Object> getAllShareholder(PageBean pageBean, ShareholderCondition shareholderCondition) throws ParseException {
        Map<String,Object> map=new HashMap<String,Object>();
        List<UserInfo> list=userInfoServiceImpl.findAllShareholder(pageBean,shareholderCondition);
        Integer countShareholder=userInfoServiceImpl.countShareholder();
        map.put("pageBean",pageBean);
        map.put("shareholderList",list);
        map.put("countShareholder",countShareholder);
        return map;
    }

    /**
     * 添加一个股东或分销商
     * @param userInfo
     */
    @PostMapping("addShareholder")
    public void addShareholder(UserInfo userInfo, int level, Shareholder shareholder){

        userInfoServiceImpl.addShareholder(userInfo,level,shareholder);
    }

    /**
     * 编辑股东分销商信息
     */
    @PostMapping("updateShareholder")
    public void updateShareholder(UserInfo userInfo,Boolean level,Shareholder shareholder){
        System.out.println(level);
        userInfoServiceImpl.updateShareholder(userInfo,level,shareholder);
    }


    /**
     * 根据id查找分销商负责的医院
     * @param userinfoId
     * @return
     * @throws ParseException
     */
    @PostMapping("/showInvestment")
    public Map<String,Object> showInvestment(int userinfoId) throws ParseException {
        Map<String,Object> map=new HashMap<String,Object>();
        List<Hospital> list=userInfoServiceImpl.findAllInvestment(userinfoId);
        Integer countHospital=userInfoServiceImpl.countInvestment(userinfoId);
        map.put("hospitalList",list);
        map.put("countHospital",countHospital);
        return map;
    }

}

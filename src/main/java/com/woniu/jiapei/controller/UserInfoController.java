package com.woniu.jiapei.controller;


import com.woniu.jiapei.condition.AccountingCondition;
import com.woniu.jiapei.condition.CustomerCondition;
import com.woniu.jiapei.condition.MedicalCondition;
import com.woniu.jiapei.condition.ShareholderCondition;
import com.woniu.jiapei.model.*;
import com.woniu.jiapei.service.UserInfoService;
import com.woniu.jiapei.tools.DataFileUtil;
import com.woniu.jiapei.tools.PageBean;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
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

    @GetMapping("/downloadAccount")
    public void downloadAccount(AccountingCondition accountingCondition, HttpServletResponse response) throws IOException {
        List<UserInfo> accountList = userInfoServiceImpl.downloadAccount(accountingCondition);
        // 生成文件
        XSSFWorkbook workBook = DataFileUtil.createScoreFile(UserInfo.class, accountList);

        String filename = "accountReport.xlsx";

        //设置文件下载头
        response.setHeader("content-disposition", "attachment;filename=" + filename);
        response.setContentType("application/vnd.ms-excel");
        // 不要使用ajax跳转到这个链接，否则会抛出管道中断错误
        OutputStream out = response.getOutputStream();
        workBook.write(out);
        out.flush();
        out.close();
    }

    @GetMapping("/downloadRepairman")
    public void downloadRepairman(AccountingCondition accountingCondition, HttpServletResponse response) throws IOException {
        List<UserInfo> repairmanList = userInfoServiceImpl.downloadRepairman(accountingCondition);
        // 生成文件
        XSSFWorkbook workBook = DataFileUtil.createScoreFile(UserInfo.class, repairmanList);

        String filename = "repairmanReport.xlsx";

        //设置文件下载头
        response.setHeader("content-disposition", "attachment;filename=" + filename);
        response.setContentType("application/vnd.ms-excel");
        // 不要使用ajax跳转到这个链接，否则会抛出管道中断错误
        OutputStream out = response.getOutputStream();
        workBook.write(out);
        out.flush();
        out.close();
    }
    @GetMapping("/downloadShareholder")
    public void downloadShareholder(ShareholderCondition shareholderCondition, HttpServletResponse response) throws IOException {
        List<UserInfo> shareholderList = userInfoServiceImpl.downloadShareholder(shareholderCondition);
        // 生成文件
        XSSFWorkbook workBook = DataFileUtil.createScoreFile(UserInfo.class, shareholderList);

        String filename = "shareholderReport.xlsx";

        //设置文件下载头
        response.setHeader("content-disposition", "attachment;filename=" + filename);
        response.setContentType("application/vnd.ms-excel");
        // 不要使用ajax跳转到这个链接，否则会抛出管道中断错误
        OutputStream out = response.getOutputStream();
        workBook.write(out);
        out.flush();
        out.close();
    }

    @GetMapping("/downloadHospitalers")
    public void downloadHospitalers(MedicalCondition medicalCondition, HttpServletResponse response) throws IOException {
        List<UserInfo> medicalList = userInfoServiceImpl.downloadMedicalList(medicalCondition);
        // 生成文件
        XSSFWorkbook workBook = DataFileUtil.createScoreFile(UserInfo.class, medicalList);

        String filename = "medicalReport.xlsx";

        //设置文件下载头
        response.setHeader("content-disposition", "attachment;filename=" + filename);
        response.setContentType("application/vnd.ms-excel");
        // 不要使用ajax跳转到这个链接，否则会抛出管道中断错误
        OutputStream out = response.getOutputStream();
        workBook.write(out);
        out.flush();
        out.close();
    }
//    /**
//     * 当登陆角色为经销商时获取二级分销商
//     */
//    @GetMapping("/getDistributor")
//    public Map<String, Object> getDistributor(HttpSession session) {
//        Map<String, Object> map = new HashMap<>();
//        try {
//            Integer userId = (Integer) session.getAttribute("userId");
//            List<UserInfo> distributorList = userInfoServiceImpl.getDistributor(userId);
//            map.put("distributorList", distributorList);
//            map.put("result", "success");
//        } catch (Exception e) {
//            e.printStackTrace();
//            map.put("result", "error");
//        }
//        return map;
//    }


    @PostMapping("/resetPassword")
    public void resetPassword(UserInfo userInfo){
        userInfoServiceImpl.resetPassword(userInfo);
    }
}

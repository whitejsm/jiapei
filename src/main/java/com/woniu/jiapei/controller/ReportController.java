package com.woniu.jiapei.controller;

import com.woniu.jiapei.condition.OrderCondition;
import com.woniu.jiapei.condition.ReportCondition;
import com.woniu.jiapei.model.*;
import com.woniu.jiapei.service.ReportService;
import com.woniu.jiapei.tools.DataFileUtil;
import com.woniu.jiapei.tools.PageBean;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ReportController {
    @Resource
    private ReportService reportServiceImpl;

    @GetMapping("/getSaleReport")
    public Map<String, Object> getSaleReport(HttpSession session, PageBean pageBean, ReportCondition condition) {
        condition.switchTime();
        System.out.println(condition);
        Map<String, Object> map = new HashMap<>();

        try {
            Integer roleId = (Integer) session.getAttribute("roleId");
            Integer userId = (Integer) session.getAttribute("userId");
            condition.setRoleId(roleId);
            condition.setUserId(userId);
            List<SaleReport> saleReportList = reportServiceImpl.findSaleReportByCondition(pageBean, condition);

            map.put("bedCount", reportServiceImpl.getBedCountByCondition(condition));
            map.put("leaseCount", reportServiceImpl.getLeaseCountByCondition(condition));
            map.put("saleReportList", saleReportList);
            map.put("pageBean", pageBean);
            map.put("result", "success");
        } catch(Exception e) {
            e.printStackTrace();
            map.put("result", "error");
        }

        return map;
    }

    @GetMapping("/getSaleInitData")
    public Map<String, Object> getSaleInitData(HttpSession session) {
        Map<String, Object> map = new HashMap<>();

        try {
            Integer roleId = (Integer) session.getAttribute("roleId");
            Integer userId = (Integer) session.getAttribute("userId");
            map = reportServiceImpl.getSaleInitData(userId, roleId);
            map.put("result", "success");
        } catch(Exception e) {
            e.printStackTrace();
            map.put("result", "error");
        }

        return map;
    }

    @GetMapping("/downloadSaleReportFile")
    public void downloadSaleReportFile(ReportCondition condition, HttpServletResponse response, HttpSession session) throws IOException {
        condition.switchTime();
        System.out.println(condition);

        Integer roleId = (Integer) session.getAttribute("roleId");
        Integer userId = (Integer) session.getAttribute("userId");
        condition.setRoleId(roleId);
        condition.setUserId(userId);
        List<SaleReport> saleReportList = reportServiceImpl.findAllSaleReportByCondition(condition);

        // 生成文件
        List<String> list = new ArrayList<>();
        if(roleId == 6) {
            list.add("rentCount");
            list.add("hospitalName");
            list.add("distributorName");
        } else if(roleId == 5) {
            list.add("rentCount");
            list.add("distributorName");
        } else if(roleId == 7) {
            list.add("rentCount");
        }

        XSSFWorkbook workBook = DataFileUtil.createScoreFile(SaleReport.class, saleReportList, list);
//        XSSFWorkbook workBook = DataFileUtil.createScoreFile(Examination.class, examinationMapper.findAll());

        String filename = "saleReport.xlsx";

        //设置文件下载头
        response.setHeader("content-disposition", "attachment;filename=" + filename);
        //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
//        response.setContentType("multipart/form-data");
        response.setContentType("application/vnd.ms-excel");
        //BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
        // 不要使用ajax跳转到这个链接，否则会抛出管道中断错误
        OutputStream out = response.getOutputStream();
        workBook.write(out);
        out.flush();
        out.close();
    }
}

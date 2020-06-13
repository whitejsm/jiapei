package com.woniu.jiapei.controller;

import com.woniu.jiapei.condition.ReportCondition;
import com.woniu.jiapei.model.SaleReport;
import com.woniu.jiapei.service.ReportService;
import com.woniu.jiapei.tools.PageBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ReportController {
    @Resource
    private ReportService reportServiceImpl;

    @GetMapping("/getSaleReport")
    public Map<String, Object> getSaleReport(PageBean pageBean, ReportCondition condition) {
        System.out.println(pageBean);
        System.out.println(condition);

        System.out.println(condition.getSelectType() == null);
        Map<String, Object> map = new HashMap<>();

        try {
            List<SaleReport> saleReportList = reportServiceImpl.findSaleReportByCondition(pageBean, condition);
            map.put("saleReportList", saleReportList);
            map.put("pageBean", pageBean);
            map.put("result", "success");
        } catch(Exception e) {
            e.printStackTrace();
            map.put("result", "error");
        }

        return map;
    }
}

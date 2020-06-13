package com.woniu.jiapei.service;

import com.woniu.jiapei.condition.ReportCondition;
import com.woniu.jiapei.model.SaleReport;
import com.woniu.jiapei.tools.PageBean;

import java.util.List;

public interface ReportService {

    List<SaleReport> findSaleReportByCondition(PageBean pageBean, ReportCondition condition);
}

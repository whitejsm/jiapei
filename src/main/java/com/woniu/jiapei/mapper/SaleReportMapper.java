package com.woniu.jiapei.mapper;

import com.woniu.jiapei.condition.ReportCondition;
import com.woniu.jiapei.model.SaleReport;

import java.util.List;

public interface SaleReportMapper {
    List<SaleReport> findSaleReportByCondition(ReportCondition condition);
}

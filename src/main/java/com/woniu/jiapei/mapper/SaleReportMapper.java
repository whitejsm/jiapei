package com.woniu.jiapei.mapper;

import com.woniu.jiapei.condition.ReportCondition;
import com.woniu.jiapei.model.SaleReport;

import java.util.List;

public interface SaleReportMapper {
    List<SaleReport> findSaleReportByCondition(ReportCondition condition);

    List<SaleReport> findSaleReportByConditionWithYear(ReportCondition condition);

    List<SaleReport> findSaleReportByConditionWithMonth(ReportCondition condition);

    List<SaleReport> findSaleReportByConditionWithDay(ReportCondition condition);

    Integer getBedCount(ReportCondition condition);

    Integer getLeaseCount(ReportCondition condition);
}

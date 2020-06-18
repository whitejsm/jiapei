package com.woniu.jiapei.mapper;

import com.woniu.jiapei.condition.ReportCondition;
import com.woniu.jiapei.model.SimpleReport;

import java.util.List;

public interface SimpleReportMapper {

    List<SimpleReport> findSimpleReportByConditionWithYear(ReportCondition condition);

    List<SimpleReport> findSimpleReportByConditionWithMonth(ReportCondition condition);

    List<SimpleReport> findSimpleReportByConditionWithDay(ReportCondition condition);

    List<SimpleReport> findSimpleReportByCondition(ReportCondition condition);
}

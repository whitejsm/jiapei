package com.woniu.jiapei.service;

import com.woniu.jiapei.condition.ReportCondition;
import com.woniu.jiapei.condition.VisibleReportOccupancyCondition;
import com.woniu.jiapei.model.SaleReport;
import com.woniu.jiapei.model.SimpleReport;
import com.woniu.jiapei.tools.PageBean;
import com.woniu.jiapei.vo.DistributionDataVo;
import com.woniu.jiapei.vo.OccupancyDataVo;

import java.util.List;
import java.util.Map;

public interface ReportService {

    List<SaleReport> findSaleReportByCondition(PageBean pageBean, ReportCondition condition);

    OccupancyDataVo getOccupancyDataByCondition(VisibleReportOccupancyCondition condition);

    DistributionDataVo getDistributionByProvinceId(Integer provinceId);

    Map<String, Object> getSaleInitData(Integer userId, Integer roleId) throws Exception;

    Object getBedCountByCondition(ReportCondition condition);

    Object getLeaseCountByCondition(ReportCondition condition);

    List<SaleReport> findAllSaleReportByCondition(ReportCondition condition);

    List<SimpleReport> findSimpleReportByCondition(PageBean pageBean, ReportCondition condition);

    List<SimpleReport> findAllSimpleReportByCondition(ReportCondition condition);
}

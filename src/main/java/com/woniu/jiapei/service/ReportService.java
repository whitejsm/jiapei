package com.woniu.jiapei.service;

import com.woniu.jiapei.condition.ReportCondition;
import com.woniu.jiapei.condition.VisibleReportOccupancyCondition;
import com.woniu.jiapei.model.SaleReport;
import com.woniu.jiapei.tools.PageBean;
import com.woniu.jiapei.vo.DistributionDataVo;
import com.woniu.jiapei.vo.OccupancyDataVo;

import java.util.List;

public interface ReportService {

    List<SaleReport> findSaleReportByCondition(PageBean pageBean, ReportCondition condition);

    OccupancyDataVo getOccupancyDataByCondition(VisibleReportOccupancyCondition condition);

    DistributionDataVo getDistributionByProvinceId(Integer provinceId);
}

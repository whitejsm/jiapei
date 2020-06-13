package com.woniu.jiapei.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.jiapei.condition.ReportCondition;
import com.woniu.jiapei.mapper.SaleReportMapper;
import com.woniu.jiapei.model.SaleReport;
import com.woniu.jiapei.service.ReportService;
import com.woniu.jiapei.tools.PageBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class ReportServiceImpl implements ReportService {
    @Resource
    private SaleReportMapper saleReportMapper;

    @Override
    public List<SaleReport> findSaleReportByCondition(PageBean pageBean, ReportCondition condition) {
        PageHelper.startPage(pageBean.getPageNum(), pageBean.getPageSize());
        List<SaleReport> saleReportList = saleReportMapper.findSaleReportByCondition(condition);
        PageInfo<SaleReport> pageInfo = new PageInfo<>(saleReportList);
        pageBean.setTotal((int)pageInfo.getTotal());
        pageBean.setPages(pageInfo.getPages());

        return saleReportList;
    }
}

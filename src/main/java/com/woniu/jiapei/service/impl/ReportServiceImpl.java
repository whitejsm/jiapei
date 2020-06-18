package com.woniu.jiapei.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.jiapei.condition.ReportCondition;
import com.woniu.jiapei.condition.VisibleReportOccupancyCondition;
import com.woniu.jiapei.mapper.*;
import com.woniu.jiapei.model.*;
import com.woniu.jiapei.service.ReportService;
import com.woniu.jiapei.tools.PageBean;
import com.woniu.jiapei.tools.TimeType;
import com.woniu.jiapei.vo.DistributionDataVo;
import com.woniu.jiapei.vo.OccupancyDataVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ReportServiceImpl implements ReportService {
    @Resource
    private SaleReportMapper saleReportMapper;
    @Resource
    private OrdersMapper ordersMapper;
    @Resource
    private BedMapper bedMapper;
    @Resource
    private HospitalMapper hospitalMapper;
    @Resource
    private DepartmentMapper departmentMapper;
    @Resource
    private UserInfoMapper userInfoMapper;
    @Resource
    private SimpleReportMapper simpleReportMapper;

    @Override
    public List<SaleReport> findSaleReportByCondition(PageBean pageBean, ReportCondition condition) {
        PageHelper.startPage(pageBean.getPageNum(), pageBean.getPageSize());
        List<SaleReport> saleReportList = null;
        if(condition.getSelectType() == TimeType.YEAR) {
            saleReportList = saleReportMapper.findSaleReportByConditionWithYear(condition);
        } else if(condition.getSelectType() == TimeType.MONTH) {
            saleReportList = saleReportMapper.findSaleReportByConditionWithMonth(condition);
        } else if(condition.getSelectType() == TimeType.DAY) {
            saleReportList = saleReportMapper.findSaleReportByConditionWithDay(condition);
        } else {
            // null
            saleReportList = saleReportMapper.findSaleReportByConditionWithDay(condition);
        }
        PageInfo<SaleReport> pageInfo = new PageInfo<>(saleReportList);
        pageBean.setTotal((int)pageInfo.getTotal());
        pageBean.setPages(pageInfo.getPages());

        return saleReportList;
    }

    @Override
    public List<SaleReport> findAllSaleReportByCondition(ReportCondition condition) {
        List<SaleReport> saleReportList = null;
        if(condition.getSelectType() == TimeType.YEAR) {
            saleReportList = saleReportMapper.findSaleReportByConditionWithYear(condition);
        } else if(condition.getSelectType() == TimeType.MONTH) {
            saleReportList = saleReportMapper.findSaleReportByConditionWithMonth(condition);
        } else if(condition.getSelectType() == TimeType.DAY) {
            saleReportList = saleReportMapper.findSaleReportByConditionWithDay(condition);
        } else {
            // null
            saleReportList = saleReportMapper.findSaleReportByCondition(condition);
        }

        return saleReportList;
    }

    @Override
    public Object getBedCountByCondition(ReportCondition condition) {
        return saleReportMapper.getBedCount(condition);
    }

    @Override
    public Object getLeaseCountByCondition(ReportCondition condition) {
        return saleReportMapper.getLeaseCount(condition);
    }

    @Override
    public OccupancyDataVo getOccupancyDataByCondition(VisibleReportOccupancyCondition condition) {
        OccupancyDataVo vo = new OccupancyDataVo();
        if(condition.getDate() != null) {
            condition.setDate( new Date(condition.getDate().getTime() + 3600 * 24 * 1000) );
        }
        System.out.println(condition);

        Long millions = condition.getDate().getTime();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        for(long i = 0; i < 15; i++) {
            Date date = new Date(millions - (i+1) * 3600 * 24 * 1000);
            String str = df.format(date);
            vo.getDateList().add(str);
            double occupancy = 0;
//            if(map.get(str) == null || map.get(str) == 0) {
//                vo.getOccupancyList().add(0);
//            } else {
                Integer bedCount = bedMapper.getCountByConditionAndDateStr(condition, str);
                Integer leaseCount = 0;
                if(bedCount != null && bedCount != 0) {
                    leaseCount = ordersMapper.getCountByConditionAndDateStr(condition, str);
                    occupancy = leaseCount * 1.0 / bedCount * 100;
                } else {
                    occupancy = 0;
                }
            vo.getOccupancyList().add((int) occupancy);
//            }
        }

        return vo;
    }

    @Override
    public DistributionDataVo getDistributionByProvinceId(Integer provinceId) {
        List<String> cities = hospitalMapper.getCityListByProvinceId(provinceId);
        List<Integer> countList = hospitalMapper.getCountListByProvinceId(provinceId);

        DistributionDataVo vo = new DistributionDataVo();
        vo.setCityNameList(cities);
        vo.setHospitalCountList(countList);

        return vo;
    }

    @Override
    public Map<String, Object> getSaleInitData(Integer userId, Integer roleId) throws Exception{
        Map<String, Object> map = new HashMap<>();
        List<UserInfo> distributorList = null;
        List<Hospital> hospitalList = null;
        List<Department> departmentList = null;

        if(roleId == 1 || roleId == 3) {
            // 超级管理员、会计，查询所有分销商、医院、科室
            distributorList = userInfoMapper.findAllDistributor();
            hospitalList = hospitalMapper.selectByExample(null);
            departmentList = departmentMapper.selectByExample(null);
        } else if(roleId == 7) {
            // 分销商，查询所有二级分销商，自身对应医院、科室
            distributorList = userInfoMapper.getDistributor(userId);
            hospitalList = hospitalMapper.findHospitalByDistributorId(userId);
            departmentList = departmentMapper.findDepartmentByDistributorId(userId);
        } else if(roleId == 5) {
            // 医院对接人，查询医院所有科室
            departmentList = departmentMapper.findDepartmentByHospitalManId(userId);
        } else if(roleId == 6) {
            // 科室对接人，无需操作
        } else {
            throw new Exception("无权限");
        }
        map.put("distributorList", distributorList);
        map.put("hospitalList", hospitalList);
        map.put("departmentList", departmentList);

        return map;
    }

    // ----------------------------   simpleReport   ------------------------------


    @Override
    public List<SimpleReport> findSimpleReportByCondition(PageBean pageBean, ReportCondition condition) {
        PageHelper.startPage(pageBean.getPageNum(), pageBean.getPageSize());
        List<SimpleReport> simpleReportList = null;
        if(condition.getSelectType() == TimeType.YEAR) {
            simpleReportList = simpleReportMapper.findSimpleReportByConditionWithYear(condition);
        } else if(condition.getSelectType() == TimeType.MONTH) {
            simpleReportList = simpleReportMapper.findSimpleReportByConditionWithMonth(condition);
        } else if(condition.getSelectType() == TimeType.DAY) {
            simpleReportList = simpleReportMapper.findSimpleReportByConditionWithDay(condition);
        } else {
            // null
            simpleReportList = simpleReportMapper.findSimpleReportByCondition(condition);
        }
        PageInfo<SimpleReport> pageInfo = new PageInfo<>(simpleReportList);
        pageBean.setTotal((int)pageInfo.getTotal());
        pageBean.setPages(pageInfo.getPages());

        return simpleReportList;
    }

    @Override
    public List<SimpleReport> findAllSimpleReportByCondition(ReportCondition condition) {
        List<SimpleReport> simpleReportList = null;
        if(condition.getSelectType() == TimeType.YEAR) {
            simpleReportList = simpleReportMapper.findSimpleReportByConditionWithYear(condition);
        } else if(condition.getSelectType() == TimeType.MONTH) {
            simpleReportList = simpleReportMapper.findSimpleReportByConditionWithMonth(condition);
        } else if(condition.getSelectType() == TimeType.DAY) {
            simpleReportList = simpleReportMapper.findSimpleReportByConditionWithDay(condition);
        } else {
            // null
            simpleReportList = simpleReportMapper.findSimpleReportByCondition(condition);
        }

        return simpleReportList;
    }
}

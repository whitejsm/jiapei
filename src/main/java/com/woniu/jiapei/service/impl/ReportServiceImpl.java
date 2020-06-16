package com.woniu.jiapei.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.jiapei.condition.ReportCondition;
import com.woniu.jiapei.condition.VisibleReportOccupancyCondition;
import com.woniu.jiapei.mapper.*;
import com.woniu.jiapei.model.Department;
import com.woniu.jiapei.model.Hospital;
import com.woniu.jiapei.model.SaleReport;
import com.woniu.jiapei.model.UserInfo;
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
    private UserInfoServiceImpl userInfoServiceImpl;

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
            saleReportList = saleReportMapper.findSaleReportByConditionWithDay(condition);
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
        System.out.println(condition.getDate());
        List<Integer> countList = bedMapper.getCountByCondition(condition);
        System.out.println(countList);
        List<String> dateList = bedMapper.getDateListByCondition(condition);
        System.out.println(dateList);
//        vo.setDateList(dateList);

        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < dateList.size(); i++) {
            map.put(dateList.get(i), countList.get(i));
        }

        // 得到的非前15天，而是有数据的前15条
//        for(int index = 0; index < dateList.size(); index++) {
//            double occupancy = 0;
//            if(countList.get(index) != 0) {
//                Integer count = ordersMapper.getCountByConditionAndDateStr(condition, dateList.get(index));
//                System.out.println(count);
//                occupancy = count * 1.0 / countList.get(index) * 100;
//            }
//            vo.getOccupancyList().add(occupancy);
//        }
        Long millions = condition.getDate().getTime();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        for(long i = 0; i < 15; i++) {
            Date date = new Date(millions - (i+1) * 3600 * 24 * 1000);
            String str = df.format(date);
            vo.getDateList().add(str);
            double occupancy = 0;
            if(map.get(str) == null || map.get(str) == 0) {
                vo.getOccupancyList().add(0);
            } else {
                Integer count = ordersMapper.getCountByConditionAndDateStr(condition, str);
                occupancy = count * 1.0 / map.get(str) * 100;
                vo.getOccupancyList().add((int)occupancy);
            }
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
            distributorList = userInfoServiceImpl.getDistributor(userId);
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
}

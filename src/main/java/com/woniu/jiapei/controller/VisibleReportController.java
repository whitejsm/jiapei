/**
 * 可视化图表数据
 * @author ytmzz
 * @since 2020/06/15
 */
package com.woniu.jiapei.controller;

import com.woniu.jiapei.condition.VisibleReportOccupancyCondition;
import com.woniu.jiapei.condition.VisibleReportRentCondition;
import com.woniu.jiapei.service.HospitalService;
import com.woniu.jiapei.service.ReportService;
import com.woniu.jiapei.vo.DistributionDataVo;
import com.woniu.jiapei.vo.OccupancyDataVo;
import com.woniu.jiapei.vo.RentDataVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
public class VisibleReportController {
    @Resource
    private HospitalService hospitalServiceImpl;
    @Resource
    private ReportService reportServiceImpl;

    @GetMapping("/getRent")
    public Map<String, Object> getRent(VisibleReportRentCondition condition) {
        Map<String, Object> map = new HashMap<>();

        try {
            RentDataVo rentDataVo = hospitalServiceImpl.getRentDataByCondition(condition);
            map.put("rentDataVo", rentDataVo);
            map.put("result", "success");
        } catch(Exception e) {
            e.printStackTrace();
            map.put("result", "error");
        }

        return map;
    }

    @GetMapping("/getOccupancy")
    public Map<String, Object> getOccupancy(VisibleReportOccupancyCondition condition) {
        Map<String, Object> map = new HashMap<>();

        try {
            OccupancyDataVo occupancyDataVo = reportServiceImpl.getOccupancyDataByCondition(condition);
            map.put("occupancyDataVo", occupancyDataVo);
            map.put("result", "success");
        } catch(Exception e) {
            e.printStackTrace();
            map.put("result", "error");
        }

        return map;
    }

    @GetMapping("/getDistribution")
    public Map<String, Object> getDistribution(Integer provinceId) {
        Map<String, Object> map = new HashMap<>();

        try {
            DistributionDataVo distributionDataVo = reportServiceImpl.getDistributionByProvinceId(provinceId);
            map.put("distributionDataVo", distributionDataVo);
            map.put("result", "success");
        } catch(Exception e) {
            e.printStackTrace();
            map.put("result", "error");
        }

        return map;
    }
}

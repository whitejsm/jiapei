/**
 * Hospital操作接口
 * @since 2020/06/10
 * @author ytmzz
 */
package com.woniu.jiapei.service;

import com.woniu.jiapei.condition.VisibleReportOccupancyCondition;
import com.woniu.jiapei.condition.VisibleReportRentCondition;
import com.woniu.jiapei.model.Hospital;
import com.woniu.jiapei.vo.OccupancyDataVo;
import com.woniu.jiapei.vo.RentDataVo;

import java.util.List;

public interface HospitalService {
    List<Hospital> getAllHospital();

    List<Hospital> getDistributorHospital(Integer distributorId);

    RentDataVo getRentDataByCondition(VisibleReportRentCondition condition);

    List<Hospital> getHospitalByContactorId(Integer contactorId);

    List<Hospital> getHospitalByDepartorId(Integer departorId);
}

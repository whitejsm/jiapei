package com.woniu.jiapei.service;

import com.woniu.jiapei.condition.VisibleReportOccupancyCondition;
import com.woniu.jiapei.condition.VisibleReportRentCondition;
import com.woniu.jiapei.model.*;
import com.woniu.jiapei.vo.OccupancyDataVo;
import com.woniu.jiapei.vo.RentDataVo;

import java.util.HashMap;
import java.util.List;

/**
 * update:ssh
 * time:2020-6-8
 *
 */
public interface HospitalService {
    List<Hospital> getAllHospital();

    List<Hospital> getDistributorHospital(Integer distributorId);

    RentDataVo getRentDataByCondition(VisibleReportRentCondition condition);

    List<Hospital> getHospitalByContactorId(Integer contactorId);

    List<Zone> findZones(int cityId);

    HashMap<String, Object> findBySearch(HospitalSearch hospitalSearch, Integer currentPage);

    List<UserInfo> findPersons(String name);

    void insert(Hospital hospital);

    Hospital findByPrimaryKey(int hospitalId);


    void update(Hospital hospital);
    List<Hospital> getHospitalByDepartorId(Integer departorId);

    List<UserInfo> findDistributor();

    List<Province> findProvinces();

    Boolean delete(int id);

    List<City> findCities(int provinceId);
}

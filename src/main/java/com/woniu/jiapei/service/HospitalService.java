package com.woniu.jiapei.service;

import com.woniu.jiapei.model.*;

import java.util.HashMap;
import java.util.List;

/**
 * update:ssh
 * time:2020-6-8
 *
 */
public interface HospitalService {
    List<Hospital> findByAll();

    Boolean delete(int id);

    List<UserInfo> findDistributor();

    List<Province> findProvinces();

    List<City> findCities(int provinceId);

    List<Zone> findZones(int cityId);

    HashMap<String, Object> findBySearch(HospitalSearch hospitalSearch, Integer currentPage);

    List<UserInfo> findPersons(String name);

    void insert(Hospital hospital);

    Hospital findByPrimaryKey(int hospitalId);

    List<Hospital> getAllHospital();

    void update(Hospital hospital);
}

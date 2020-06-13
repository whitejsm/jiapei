/**
 * Hospital操作接口
 * @since 2020/06/10
 * @author ytmzz
 */
package com.woniu.jiapei.service;

import com.woniu.jiapei.model.Hospital;

import java.util.List;

public interface HospitalService {
    List<Hospital> getAllHospital();

    List<Hospital> getDistributorHospital(Integer distributorId);
}

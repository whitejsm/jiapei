/**
 * HospitalService实现类
 * @since 2020/06/10
 * @author ytmzz
 */
package com.woniu.jiapei.service.impl;

import com.woniu.jiapei.condition.VisibleReportRentCondition;
import com.woniu.jiapei.mapper.HospitalMapper;
import com.woniu.jiapei.model.Hospital;
import com.woniu.jiapei.service.HospitalService;
import com.woniu.jiapei.vo.RentDataVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional
@Service
public class HospitalServiceImpl implements HospitalService {
    @Resource
    private HospitalMapper hospitalMapper;

    @Override
    public List<Hospital> getAllHospital() {
        return hospitalMapper.selectByExample(null);
    }

    @Override
    public List<Hospital> getDistributorHospital(Integer distributorId) {
        return hospitalMapper.selectByDistributorId(distributorId);
    }

    @Override
    public RentDataVo getRentDataByCondition(VisibleReportRentCondition condition) {
        List<Hospital> hospitalList = hospitalMapper.selectByVisibleCondition(condition);
        RentDataVo vo = new RentDataVo();

        for (Hospital hospital : hospitalList) {
            vo.getHospitalNameList().add(hospital.getHospitalname());
            vo.getRentList().add(hospital.getRent());
        }

        return vo;
    }

    @Override
    public List<Hospital> getHospitalByContactorId(Integer contactorId) {
        return hospitalMapper.selectByContactorId(contactorId);
    }

    @Override
    public List<Hospital> getHospitalByDepartorId(Integer departorId) {
        return hospitalMapper.selectByDepartorId(departorId);
    }
}

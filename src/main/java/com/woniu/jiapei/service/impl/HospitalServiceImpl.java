package com.woniu.jiapei.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.jiapei.mapper.*;
import com.woniu.jiapei.model.*;
import com.woniu.jiapei.condition.VisibleReportRentCondition;
import com.woniu.jiapei.mapper.HospitalMapper;
import com.woniu.jiapei.model.Hospital;
import com.woniu.jiapei.service.HospitalService;
import com.woniu.jiapei.vo.RentDataVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Transactional
@Service
public class HospitalServiceImpl implements HospitalService {
    @Resource
    HospitalMapper hospitalMapper;
    @Resource
    UserInfoMapper userInfoMapper;
    @Resource
    ProvinceMapper provinceMapper;
    @Resource
    CityMapper cityMapper;
    @Resource
    ZoneMapper zoneMapper;

    @Override
    public List<Hospital> getAllHospital() {
        return hospitalMapper.selectByExample(null);
    }

    @Override
    public Boolean delete(int id) {
        Hospital hospital = new Hospital();
        hospital.setHospitalId(id);
        hospital.setIsdelete(false);
        int i = hospitalMapper.updateByPrimaryKeySelective(hospital);
        return i==0?false:true;
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
    public List<City> findCities(int provinceId) {
        return cityMapper.findCityByProvinceId(provinceId);
    }

    @Override
    public HashMap<String, Object> searchOwn(Integer userId, Integer currentPage) {
        PageHelper.startPage(currentPage, 15);
        HospitalExample example = new HospitalExample();
        HospitalExample.Criteria criteria = example.createCriteria();
        criteria.andIsdeleteEqualTo(true);
        criteria.andContactorIdEqualTo(userId);
        List<Hospital> list = hospitalMapper.selectByExample(example);
        PageInfo<Hospital> info = new PageInfo<>(list);
        HashMap<String, Object> map = new HashMap<>();
        map.put("list", list);
        map.put("info", info);

        return map;



    }

    @Override
    public List<Zone> findZones(int cityId) {
        return zoneMapper.findZoneByCityId(cityId);
    }

    @Override
    public HashMap<String, Object> findBySearch(HospitalSearch hospitalSearch, Integer currentPage) {
        HospitalExample example = new HospitalExample();
        HospitalExample.Criteria criteria = example.createCriteria();
        criteria.andIsdeleteEqualTo(true);
        if (hospitalSearch.getName() != null && !"".equals(hospitalSearch.getName())) {
            criteria.andHospitalnameLike(hospitalSearch.getName());
        }
        if (hospitalSearch.getDistributor() != null) {
            criteria.andDistributorIdEqualTo(hospitalSearch.getDistributor());
        }
        if (hospitalSearch.getShare() != null && !"".equals(hospitalSearch.getShare())) {
            criteria.andRevenueshareBetween(hospitalSearch.getIntegershare()[0], hospitalSearch.getIntegershare()[1]);
        }
        if (hospitalSearch.getZone() != null) {
            criteria.andZoneIdEqualTo(hospitalSearch.getZone());
        } else if (hospitalSearch.getCity() != null) {
            criteria.andCityIdEqualTo(hospitalSearch.getCity());
        } else if (hospitalSearch.getProvince() != null) {
            criteria.andProvinceIdEqualTo(hospitalSearch.getProvince());
        }
        if (hospitalSearch.getValue1() != null && hospitalSearch.getValue2() != null && hospitalSearch.getValue1() != 0l && hospitalSearch.getValue2() != 0l && hospitalSearch.getValue2() >= hospitalSearch.getValue1()) {

            criteria.andCreateTimeBetween(hospitalSearch.getDate1(), hospitalSearch.getDate2());
        }
        PageHelper.startPage(currentPage, 15);
        System.out.println("11111111111");
        List<Hospital> list = hospitalMapper.selectByExample(example);
        PageInfo<Hospital> info = new PageInfo<>(list);
        HashMap<String, Object> map = new HashMap<>();
        map.put("list", list);
        map.put("info", info);

        return map;
    }

    @Override
    public List<UserInfo> findPersons(String name) {


            return userInfoMapper.findByRoleName(name);



    }

    @Override
    public void insert(Hospital hospital) {
        hospital.setCreateTime(new Date());
        hospital.setIsdelete(false);
        hospitalMapper.insertSelective(hospital);
    }

    @Override
    public Hospital findByPrimaryKey(int hospitalId) {
        return hospitalMapper.selectByPrimaryKey(hospitalId);
    }



    @Override
    public void update(Hospital hospital) {
        hospitalMapper.updateByPrimaryKeySelective(hospital);
    }

    @Override
    public List<Province> findProvinces() {
        return provinceMapper.selectByExample(null);
    }

    @Override
    public List<UserInfo> findDistributor() {
        return userInfoMapper.findDistributor();
    }


    @Override
    public List<Hospital> getHospitalByDepartorId(Integer departorId) {
        return hospitalMapper.selectByDepartorId(departorId);
    }
}

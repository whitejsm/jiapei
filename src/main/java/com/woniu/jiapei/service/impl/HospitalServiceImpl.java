package com.woniu.jiapei.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.jiapei.mapper.*;
import com.woniu.jiapei.model.*;
import com.woniu.jiapei.service.HospitalService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

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
    public Boolean delete(int id) {
        Hospital hospital = new Hospital();
        hospital.setHospitalId(id);
        hospital.setIsdelete(true);
        int i = hospitalMapper.updateByPrimaryKeySelective(hospital);
        return i==0?false:true;
    }

    @Override
    public List<City> findCities(int provinceId) {
        return cityMapper.findByProvinceId(provinceId);
    }

    @Override
    public List<Zone> findZones(int cityId) {
        return zoneMapper.findByCityId(cityId);
    }

    @Override
    public HashMap<String, Object> findBySearch(HospitalSearch hospitalSearch, Integer currentPage) {
        HospitalExample example = new HospitalExample();
        HospitalExample.Criteria criteria = example.createCriteria();
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
        List<Hospital> list = hospitalMapper.selectByExample(example);
        PageInfo<Hospital> info = new PageInfo<>(list);
        HashMap<String, Object> map = new HashMap<>();
        map.put("list", list);
        map.put("info", info);

        return map;
    }

    @Override
    public List<UserInfo> findPersons(String name) {

        if ("一级分销商".equals(name)) {
            return userInfoMapper.findByRoleNameDistributor1(name);
        } else if ("二级分销商".equals(name)) {
            return userInfoMapper.findByRoleNameDistributor2(name);
        } else {
            return userInfoMapper.findByRoleName(name);
        }


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
    public List<Hospital> findByAll() {
        List<Hospital> list = hospitalMapper.findAll();
        return list;
    }
}

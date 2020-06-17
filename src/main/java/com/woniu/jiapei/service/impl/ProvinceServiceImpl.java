package com.woniu.jiapei.service.impl;

import com.woniu.jiapei.mapper.ProvinceHospitalDataMapper;
import com.woniu.jiapei.mapper.ProvinceMapper;
import com.woniu.jiapei.model.Province;
import com.woniu.jiapei.service.ProvinceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class ProvinceServiceImpl implements ProvinceService {
    @Resource
    private ProvinceMapper provinceMapper;
    @Resource
    private ProvinceHospitalDataMapper provinceHospitalDataMapper;

    @Override
    public List<Province> getProvinceList() {
        return provinceMapper.findProvince();
    }

    @Override
    public List<Integer> getProvinceValueList() {
        return provinceHospitalDataMapper.getProvinceValueList();
    }
}

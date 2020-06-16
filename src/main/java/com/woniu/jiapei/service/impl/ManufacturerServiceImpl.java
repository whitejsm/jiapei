package com.woniu.jiapei.service.impl;

import com.woniu.jiapei.mapper.ManufacturerMapper;
import com.woniu.jiapei.model.Manufacturer;
import com.woniu.jiapei.service.ManufacturerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {
    @Resource
    private ManufacturerMapper manufacturerMapper;

    @Override
    public Manufacturer findById(Integer manufacturerId) {
        return manufacturerMapper.selectByPrimaryKey(manufacturerId);
    }

    @Override
    public List<Manufacturer> findAll() {
        return manufacturerMapper.selectByExample(null);
    }
}

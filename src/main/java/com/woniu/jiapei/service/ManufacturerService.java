package com.woniu.jiapei.service;

import com.woniu.jiapei.model.Manufacturer;

import java.util.List;

public interface ManufacturerService {
    Manufacturer findById(Integer manufacturerId);

    List<Manufacturer> findAll();
}

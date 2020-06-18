package com.woniu.jiapei.model;

import java.io.Serializable;
import java.util.List;

public class Province implements Serializable {
    private Integer provinceId;

    private String provinceName;

    private List<City> cities;

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    @Override
    public String toString() {
        return "Province{" +
                "provinceId=" + provinceId +
                ", provinceName='" + provinceName + '\'' +
                ", cities=" + cities +
                '}';
    }
}
package com.woniu.jiapei.model;

import java.io.Serializable;
import java.util.List;

public class City implements Serializable {
    private Integer cityId;

    private Integer provinceId;

    private String cityName;

    private List<Zone> zones;

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public List<Zone> getZones() {
        return zones;
    }

    public void setZones(List<Zone> zones) {
        this.zones = zones;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityId=" + cityId +
                ", provinceId=" + provinceId +
                ", cityName='" + cityName + '\'' +
                ", zones=" + zones +
                '}';
    }
}
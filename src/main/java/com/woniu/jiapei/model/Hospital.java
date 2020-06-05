package com.woniu.jiapei.model;

import java.util.Date;

public class Hospital {
    private Integer hospitalId;

    private String hospitalname;

    private String bankcard;

    private Long rent;

    private Integer revenueshare;

    private Date createTime;

    private Integer distributorId;

    private Integer contactorId;

    private Integer provinceId;

    private Integer cityId;

    private Integer zoneId;

    public Integer getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getHospitalname() {
        return hospitalname;
    }

    public void setHospitalname(String hospitalname) {
        this.hospitalname = hospitalname;
    }

    public String getBankcard() {
        return bankcard;
    }

    public void setBankcard(String bankcard) {
        this.bankcard = bankcard;
    }

    public Long getRent() {
        return rent;
    }

    public void setRent(Long rent) {
        this.rent = rent;
    }

    public Integer getRevenueshare() {
        return revenueshare;
    }

    public void setRevenueshare(Integer revenueshare) {
        this.revenueshare = revenueshare;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getDistributorId() {
        return distributorId;
    }

    public void setDistributorId(Integer distributorId) {
        this.distributorId = distributorId;
    }

    public Integer getContactorId() {
        return contactorId;
    }

    public void setContactorId(Integer contactorId) {
        this.contactorId = contactorId;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getZoneId() {
        return zoneId;
    }

    public void setZoneId(Integer zoneId) {
        this.zoneId = zoneId;
    }
}
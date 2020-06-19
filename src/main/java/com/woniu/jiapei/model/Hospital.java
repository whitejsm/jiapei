package com.woniu.jiapei.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
@Data
public class Hospital implements Serializable {
    private UserInfo distributor;
    private UserInfo contactor;
    private List<Department> departments;
    private List<Department> departmentList;
    //

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }
    private UserInfo userInfo;

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public UserInfo getDistributor() {
        return distributor;
    }

    public void setDistributor(UserInfo distributor) {
        this.distributor = distributor;
    }

    public UserInfo getContactor() {
        return contactor;
    }

    public void setContactor(UserInfo contactor) {
        this.contactor = contactor;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    private Integer hospitalId;

    private String hospitalname;

    private Long value1;

    public Long getValue1() {
        return createTime==null?null:createTime.getTime();
    }

    public void setValue1(Long value1) {
        this.value1 = value1;
    }

    private String bankcard;

    private Long rent;

    private Integer revenueshare;

    private Date createTime;

    private Integer distributorId;

    private Integer contactorId;

    private Integer provinceId;
    private Province province;

    private Integer cityId;

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    private City city;

    private Integer zoneId;
    private Zone zone;

    private Boolean isdelete;



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

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }


    }


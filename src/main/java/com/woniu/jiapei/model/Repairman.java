package com.woniu.jiapei.model;

import java.io.Serializable;

public class Repairman implements Serializable {
    private Integer repairmanId;
    private UserInfo man;

    public UserInfo getMan() {
        return man;
    }

    public void setMan(UserInfo man) {
        this.man = man;
    }

    private Integer hospitalId;

    private Integer departmentId;

    private String hospitalname;

    private String departmentname;

    public Integer getRepairmanId() {
        return repairmanId;
    }

    public void setRepairmanId(Integer repairmanId) {
        this.repairmanId = repairmanId;
    }

    public Integer getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getHospitalname() {
        return hospitalname;
    }

    public void setHospitalname(String hospitalname) {
        this.hospitalname = hospitalname;
    }

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname;
    }
}

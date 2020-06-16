package com.woniu.jiapei.model;

import java.util.Date;
import java.util.List;

public class Department {
    private List<Bed> bedList;
    private Integer hospitalId;
    private Hospital hospital;

    public List<Bed> getBedList() {
        return bedList;
    }

    public void setBedList(List<Bed> bedList) {
        this.bedList = bedList;
    }

    private Integer departmentId;

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    private Integer departorId;

    private String departmentname;

    private Date createTime;

    private Integer revenueshare;

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
    }

    public Integer getDepartorId() {
        return departorId;
    }

    public void setDepartorId(Integer departorId) {
        this.departorId = departorId;
    }

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getRevenueshare() {
        return revenueshare;
    }

    public void setRevenueshare(Integer revenueshare) {
        this.revenueshare = revenueshare;
    }
}
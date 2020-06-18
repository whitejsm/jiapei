package com.woniu.jiapei.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Department {


    private Integer departmentId;

    private Integer hospitalId;
    private Hospital hospital;



    private Integer departorId;
    private UserInfo departor;
    private List<Bed> bedList;
    private Repairman repairman;

    private Long value1;

    public Long getValue1() {
        return createTime==null?null:createTime.getTime();
    }

    public void setValue1(Long value1) {
        this.value1 = value1;
    }

    private String departmentname;

    private Date createTime;

    private Integer revenueshare;

    private Boolean isdelete;

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public UserInfo getDepartor() {
        return departor;
    }

    public void setDepartor(UserInfo departor) {
        this.departor = departor;
    }

    public List<Bed> getBedList() {
        return bedList;
    }

    public void setBedList(List<Bed> bedList) {
        this.bedList = bedList;
    }

    public Repairman getRepairman() {
        return repairman;
    }

    public void setRepairman(Repairman repairman) {
        this.repairman = repairman;
    }

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

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }
}

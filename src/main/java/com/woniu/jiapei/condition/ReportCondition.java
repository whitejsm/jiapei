package com.woniu.jiapei.condition;

import com.woniu.jiapei.tools.TimeType;

public class ReportCondition {
    private Integer distributorId;
    private Integer departmentId;
    private Integer hospitalId;
    private TimeType selectType;
    private Integer year;
    private Integer month;

    public Integer getDistributorId() {
        return distributorId;
    }

    public void setDistributorId(Integer distributorId) {
        this.distributorId = distributorId;
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

    public TimeType getSelectType() {
        return selectType;
    }

    public void setSelectType(TimeType selectType) {
        this.selectType = selectType;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return "ReportCondition{" +
                "distributorId=" + distributorId +
                ", departmentId=" + departmentId +
                ", hospitalId=" + hospitalId +
                ", selectType='" + selectType + '\'' +
                ", year=" + year +
                ", month=" + month +
                '}';
    }
}

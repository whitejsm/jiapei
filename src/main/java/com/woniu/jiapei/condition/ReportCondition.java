package com.woniu.jiapei.condition;

import com.woniu.jiapei.tools.TimeType;

import java.sql.Time;
import java.util.Date;

public class ReportCondition {
    private Integer distributorId;
    private Integer departmentId;
    private Integer hospitalId;
    private TimeType selectType;
    // 月选择的年
    private String year;
    // 日选择的月
    private String month;

    private Integer roleId;
    private Integer userId;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
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

    public void switchTime() {
        if(selectType == TimeType.YEAR) {
            // 实际就是按年向前查询统计，故未使用
//            year = String.valueOf(new Date().getYear());
        } else if(selectType == TimeType.MONTH) {
            // 2020-12-31T16:00:00.000Z
            // elementui的月时间选择器传递的是上一年末最后一秒，故+1
            year = String.valueOf((Integer.valueOf(year.substring(0, 4)) + 1));
        } else if(selectType == TimeType.DAY) {
            // TimeType.DAY 2020/03
            year = month.substring(0, 4);
            month = Integer.valueOf(month.substring(5, 7)).toString();
        }
        // selectType == null
    }
}

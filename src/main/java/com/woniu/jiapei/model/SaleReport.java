package com.woniu.jiapei.model;

import java.util.Date;

public class SaleReport {
    private Date orderDate;
    private String distributorName;
    private String hospitalName;
    private String departmentName;
    private Integer bedCount;
    // 租赁次数
    private Integer leaseCount;
    // 租金总数
    private Integer rentCount;

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getDistributorName() {
        return distributorName;
    }

    public void setDistributorName(String distributorName) {
        this.distributorName = distributorName;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Integer getBedCount() {
        return bedCount;
    }

    public void setBedCount(Integer bedCount) {
        this.bedCount = bedCount;
    }

    public Integer getLeaseCount() {
        return leaseCount;
    }

    public void setLeaseCount(Integer leaseCount) {
        this.leaseCount = leaseCount;
    }

    public Integer getRentCount() {
        return rentCount;
    }

    public void setRentCount(Integer rentCount) {
        this.rentCount = rentCount;
    }

    @Override
    public String toString() {
        return "SaleReport{" +
                "orderDate=" + orderDate +
                ", distributorName='" + distributorName + '\'' +
                ", hospitalName='" + hospitalName + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", bedCount=" + bedCount +
                ", leaseCount=" + leaseCount +
                ", rentCount=" + rentCount +
                '}';
    }
}

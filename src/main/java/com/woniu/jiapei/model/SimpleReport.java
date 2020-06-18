package com.woniu.jiapei.model;

public class SimpleReport {
    private String orderDate;
    private Integer bedCount;
    private Integer leaseCount;
    private Integer rentCount;

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
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
        return "SimpleReport{" +
                "orderDate='" + orderDate + '\'' +
                ", bedCount=" + bedCount +
                ", leaseCount=" + leaseCount +
                ", rentCount=" + rentCount +
                '}';
    }
}

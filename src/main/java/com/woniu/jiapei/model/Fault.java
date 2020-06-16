package com.woniu.jiapei.model;

import lombok.Data;

import java.util.Date;
@Data
public class Fault {
    private Bed bed;
    private Repair repair;
    private UserInfo userInfo;
    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    private Customer customer;

    public Bed getBed() {
        return bed;
    }

    public void setBed(Bed bed) {
        this.bed = bed;
    }

    public Repair getRepair() {
        return repair;
    }

    public void setRepair(Repair repair) {
        this.repair = repair;
    }

    private Integer faultId;

    private Integer contactorId;

    private Integer customerId;

    private String bedId;

    private String faultTitle;

    private String faultType;

    private String faultStatus;

    private Date createTime;

    private String faultDetails;

    public Integer getFaultId() {
        return faultId;
    }

    public void setFaultId(Integer faultId) {
        this.faultId = faultId;
    }

    public Integer getContactorId() {
        return contactorId;
    }

    public void setContactorId(Integer contactorId) {
        this.contactorId = contactorId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getBedId() {
        return bedId;
    }

    public void setBedId(String bedId) {
        this.bedId = bedId;
    }

    public String getFaultTitle() {
        return faultTitle;
    }

    public void setFaultTitle(String faultTitle) {
        this.faultTitle = faultTitle;
    }

    public String getFaultType() {
        return faultType;
    }

    public void setFaultType(String faultType) {
        this.faultType = faultType;
    }

    public String getFaultStatus() {
        return faultStatus;
    }

    public void setFaultStatus(String faultStatus) {
        this.faultStatus = faultStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getFaultDetails() {
        return faultDetails;
    }

    public void setFaultDetails(String faultDetails) {
        this.faultDetails = faultDetails;
    }
}
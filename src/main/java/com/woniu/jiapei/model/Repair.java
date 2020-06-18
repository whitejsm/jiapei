package com.woniu.jiapei.model;

import java.io.Serializable;
import java.util.Date;

public class Repair implements Serializable {
    private Fault fault;

    public Fault getFault() {
        return fault;
    }

    public void setFault(Fault fault) {
        this.fault = fault;
    }

    private UserInfo userInfo;

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    private String repairId;

    private Integer faultId;

    private String repairResult;

    private String repairStatus;

    private Date createTime;

    private Integer repairmanId;

    private String repairInstructions;

    public String getRepairId() {
        return repairId;
    }

    public void setRepairId(String repairId) {
        this.repairId = repairId;
    }

    public Integer getFaultId() {
        return faultId;
    }

    public void setFaultId(Integer faultId) {
        this.faultId = faultId;
    }

    public String getRepairResult() {
        return repairResult;
    }

    public void setRepairResult(String repairResult) {
        this.repairResult = repairResult;
    }

    public String getRepairStatus() {
        return repairStatus;
    }

    public void setRepairStatus(String repairStatus) {
        this.repairStatus = repairStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getRepairmanId() {
        return repairmanId;
    }

    public void setRepairmanId(Integer repairmanId) {
        this.repairmanId = repairmanId;
    }

    public String getRepairInstructions() {
        return repairInstructions;
    }

    public void setRepairInstructions(String repairInstructions) {
        this.repairInstructions = repairInstructions;
    }
}
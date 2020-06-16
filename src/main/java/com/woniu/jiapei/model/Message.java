package com.woniu.jiapei.model;

import java.util.Date;

public class Message {
    private String messageId;

    private Integer roleId;

    private Integer messageTypeId;

    private Integer messageDetailId;

    private String messageWay;

    private String messageCondition;

    private Date createTime;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getMessageTypeId() {
        return messageTypeId;
    }

    public void setMessageTypeId(Integer messageTypeId) {
        this.messageTypeId = messageTypeId;
    }

    public Integer getMessageDetailId() {
        return messageDetailId;
    }

    public void setMessageDetailId(Integer messageDetailId) {
        this.messageDetailId = messageDetailId;
    }

    public String getMessageWay() {
        return messageWay;
    }

    public void setMessageWay(String messageWay) {
        this.messageWay = messageWay;
    }

    public String getMessageCondition() {
        return messageCondition;
    }

    public void setMessageCondition(String messageCondition) {
        this.messageCondition = messageCondition;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
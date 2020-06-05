package com.woniu.jiapei.model;

import java.util.Date;

public class MessageList {
    private Integer messageListId;

    private String messageId;

    private Date messageSendtime;

    private String messageContent;

    public Integer getMessageListId() {
        return messageListId;
    }

    public void setMessageListId(Integer messageListId) {
        this.messageListId = messageListId;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public Date getMessageSendtime() {
        return messageSendtime;
    }

    public void setMessageSendtime(Date messageSendtime) {
        this.messageSendtime = messageSendtime;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }
}
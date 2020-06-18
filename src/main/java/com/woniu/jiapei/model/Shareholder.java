package com.woniu.jiapei.model;

import java.io.Serializable;
import java.util.Date;

public class Shareholder implements Serializable {
    private Integer userinfoId;

    private Integer shareholderRevenueshare;

    private Date shareholderTime;

    private String shareholderBankcard;

    private Long shareholderMoeny;

    public Integer getUserinfoId() {
        return userinfoId;
    }

    public void setUserinfoId(Integer userinfoId) {
        this.userinfoId = userinfoId;
    }

    public Integer getShareholderRevenueshare() {
        return shareholderRevenueshare;
    }

    public void setShareholderRevenueshare(Integer shareholderRevenueshare) {
        this.shareholderRevenueshare = shareholderRevenueshare;
    }

    public Date getShareholderTime() {
        return shareholderTime;
    }

    public void setShareholderTime(Date shareholderTime) {
        this.shareholderTime = shareholderTime;
    }

    public String getShareholderBankcard() {
        return shareholderBankcard;
    }

    public void setShareholderBankcard(String shareholderBankcard) {
        this.shareholderBankcard = shareholderBankcard;
    }

    public Long getShareholderMoeny() {
        return shareholderMoeny;
    }

    public void setShareholderMoeny(Long shareholderMoeny) {
        this.shareholderMoeny = shareholderMoeny;
    }
}
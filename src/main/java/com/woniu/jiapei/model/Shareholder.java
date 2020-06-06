package com.woniu.jiapei.model;

import java.util.Date;

public class Shareholder {
    private Integer userinfoId;

    private Integer shareholderRevenueshare;

    private Date shareholderTime;

    private String shareholderBankcard;

    private Long shareholderMoney;

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

    public Long getShareholderMoney() {
        return shareholderMoney;
    }

    public void setShareholderMoney(Long shareholderMoney) {
        this.shareholderMoney = shareholderMoney;
    }
}
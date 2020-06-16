package com.woniu.jiapei.model;

import java.util.Date;

public class UserLoginInfo {
    private Integer userinfoId;

    private String loginIp;

    private Integer count;

    private Date lougouTime;

    public Integer getUserinfoId() {
        return userinfoId;
    }

    public void setUserinfoId(Integer userinfoId) {
        this.userinfoId = userinfoId;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getLougouTime() {
        return lougouTime;
    }

    public void setLougouTime(Date lougouTime) {
        this.lougouTime = lougouTime;
    }
}
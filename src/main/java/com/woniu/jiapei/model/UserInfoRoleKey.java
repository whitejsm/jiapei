package com.woniu.jiapei.model;

import java.io.Serializable;

public class UserInfoRoleKey implements Serializable {
    private Integer userinfoId;

    private Integer roleId;

    public Integer getUserinfoId() {
        return userinfoId;
    }

    public void setUserinfoId(Integer userinfoId) {
        this.userinfoId = userinfoId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
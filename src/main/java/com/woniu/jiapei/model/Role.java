package com.woniu.jiapei.model;

import java.io.Serializable;

public class Role implements Serializable {
    private Integer roleId;

    private String rolename;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}
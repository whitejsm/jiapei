package com.woniu.jiapei.model;

import java.io.Serializable;

public class RolePermission extends RolePermissionKey implements Serializable {
    private String rule;

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }
}
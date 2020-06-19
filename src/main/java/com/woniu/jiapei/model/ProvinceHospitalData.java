/**
 * 显示地图数据（省医院数）
 */
package com.woniu.jiapei.model;

import java.io.Serializable;

public class ProvinceHospitalData implements Serializable {
    private String name;
    private Integer value;
    private Integer areaCode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(Integer areaCode) {
        this.areaCode = areaCode;
    }

    @Override
    public String toString() {
        return "ProvinceHospitalData{" +
                "name='" + name + '\'' +
                ", value=" + value +
                ", areaCode='" + areaCode + '\'' +
                '}';
    }
}

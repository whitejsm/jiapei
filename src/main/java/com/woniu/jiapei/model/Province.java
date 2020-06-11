package com.woniu.jiapei.model;

import lombok.Data;
import org.hibernate.validator.constraints.URL;

import java.util.List;
@Data
public class Province {
    private List<City> cities;



    private Integer provinceId;

    private String provinceName;

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }
}

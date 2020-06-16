package com.woniu.jiapei.model;

import lombok.Data;

import java.util.Date;

@Data
public class HospitalSearch {
    private String name;//医院名称
    private Integer distributor;//经销商名称
    private Long value1;//开始时间
    private Long value2;//结束时间
    private String share;//收益分成
    private Integer province;//省
    private Integer city;//市
    private Integer zone;//区
    private Date date1;
    private Date date2;


    public Integer[] getIntegershare() {
        String[] shares = share.split("-");
        Integer[] shareInt = new Integer[2];
        shareInt[0] = Integer.parseInt(shares[0]);
        shareInt[1] = Integer.parseInt(shares[1]);
        return shareInt;
    }
}

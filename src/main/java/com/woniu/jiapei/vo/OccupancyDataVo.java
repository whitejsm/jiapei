package com.woniu.jiapei.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OccupancyDataVo {
    private List<Integer> occupancyList = new ArrayList<>();
    private List<String> dateList = new ArrayList<>();
}

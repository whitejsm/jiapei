package com.woniu.jiapei.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DistributionDataVo {
    private List<Integer> hospitalCountList = new ArrayList<>();
    private List<String> cityNameList = new ArrayList<>();
}

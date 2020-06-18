package com.woniu.jiapei.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RentDataVo {
    private List<Long> rentList = new ArrayList<>();
    private List<String> hospitalNameList = new ArrayList<>();
}

package com.woniu.jiapei.condition;

import lombok.Data;

import java.util.Date;

@Data
public class VisibleReportOccupancyCondition {
    private Integer hospitalId;
    private Integer departmentId;
    private Date date;
}

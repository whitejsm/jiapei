package com.woniu.jiapei.condition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BedCondition {
    private String bedId;
    private Integer hospitalId;
    private Integer departmentId;
    private Integer power;
    private String status;
    private Date beginTime;
    private Date endTime;
}

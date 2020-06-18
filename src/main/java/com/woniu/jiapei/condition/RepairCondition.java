package com.woniu.jiapei.condition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RepairCondition {
    private String repairId;
    private Integer hospitalId;
    private Integer departmentId;
    private Integer repairmanId;
    private String repairStatus;
    private Date beginTime;
    private Date endTime;
    private Integer roleId;
    private Integer userInfoId;
}

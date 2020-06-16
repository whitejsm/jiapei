package com.woniu.jiapei.condition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FaultCondition {
    private Integer faultId;
    private Integer hospitalId;
    private Integer departmentId;
    private String faultType;
    private String faultStatus;
    private String repaitStatus;
    private String faultSource;
    private Date beginTime;
    private Date endTime;

}

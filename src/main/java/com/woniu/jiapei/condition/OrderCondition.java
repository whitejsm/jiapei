package com.woniu.jiapei.condition;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderCondition {
    private String ordersId;
    private Integer hospitalId;
    private Integer departmentId;
    private String ordersStatus;
    private Date createTime;
    private Date endTime;
}

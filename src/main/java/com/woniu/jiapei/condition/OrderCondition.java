package com.woniu.jiapei.condition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderCondition {
    private String ordersId;
    private Integer hospitalId;
    private Integer DepartmentId;
    private String ordersStatus;
    private Date createTime;
    private Date endTime;
}

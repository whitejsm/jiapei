package com.woniu.jiapei.condition;

import lombok.Data;

import java.util.Date;

/**
 * ssh
 * 部门查询条件
 */
@Data
public class DepartmentCondition {
    private String name;
    private String hospitalname;
    private Integer hospitalId;
    private Long value1;
    private Long value2;
    private Date date1;
    private Date date2;

}

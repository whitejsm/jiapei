package com.woniu.jiapei.condition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 周元皓丶
 * 检索条件
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerCondition {
     private String phonenumber;
     private Boolean gender;
     private Boolean isuse;
     private Date startTime;
     private Date endTime;
}

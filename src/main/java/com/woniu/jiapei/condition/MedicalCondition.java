package com.woniu.jiapei.condition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicalCondition {
        private String phonenumber;
        private Boolean role;
        private Date startTime;
        private Date endTime;
}

package com.woniu.jiapei.tools;

import com.woniu.jiapei.model.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Msg {
    private String msg;
    private Boolean result;
    private Bed bed;
    private List<Bed> bedList;
    private PageBean pageBean;
    private List<Hospital> hospitalList;
    private List<Department> departmentList;
    private List<Manufacturer> manufacturerList;

    private List<Fault> faultList;
    private Fault fault;

    private List<Repair> repairList;
}

package com.woniu.jiapei.service;

import com.woniu.jiapei.condition.RepairCondition;
import com.woniu.jiapei.model.Repair;
import com.woniu.jiapei.tools.PageBean;

public interface RepairService {
    void save(Repair repair);

    void update(Repair repair);

    void delRepairByFaultId(Integer faultId);

    void findAll(RepairCondition repairCondition, PageBean pageBean);
}

package com.woniu.jiapei.service;

import com.woniu.jiapei.condition.RepairCondition;
import com.woniu.jiapei.model.Repair;
import com.woniu.jiapei.tools.PageBean;

import java.util.List;

public interface RepairService {
    void save(Repair repair);

    void update(Repair repair);

    void delRepairByFaultId(Integer faultId);

    List<Repair> findAll(RepairCondition repairCondition, PageBean pageBean);

    void delRepairByRepairId(String repairId);

    List<Repair> getRepairsByCondition(RepairCondition repairCondition);
}

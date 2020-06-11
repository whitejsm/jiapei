package com.woniu.jiapei.service;

import com.woniu.jiapei.condition.FaultCondition;
import com.woniu.jiapei.model.Fault;
import com.woniu.jiapei.tools.PageBean;

import java.util.List;

/**
 * 售后管理--故障模块接口
 */
public interface FaultService {
    List<Fault> findAll(FaultCondition faultCondition,PageBean pageBean);
    Fault findByFaultId(Integer faultId);
    void save(Fault fault);
    void update(Fault fault);
}

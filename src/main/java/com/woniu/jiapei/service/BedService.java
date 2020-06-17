package com.woniu.jiapei.service;

import com.woniu.jiapei.condition.BedCondition;
import com.woniu.jiapei.model.Bed;
import com.woniu.jiapei.model.Message;
import com.woniu.jiapei.tools.PageBean;

import java.util.List;

/**
 * 床位管理的接口
 */
public interface BedService {
    List<Bed> findAll(PageBean pageBean);
    Bed findById(String bedId);
    List<Bed> findByExample(BedCondition bedCondition, PageBean pageBean);
    void update(Bed bed);
    void save(Bed bed);

    List<Bed> getBedsByCondition(BedCondition bedCondition);

    List<Bed> findByDepartmentId(Integer departmentId);

    Integer getBedCount();
}

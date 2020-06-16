package com.woniu.jiapei.service.impl;

import com.woniu.jiapei.condition.RepairCondition;
import com.woniu.jiapei.mapper.RepairMapper;
import com.woniu.jiapei.model.Repair;
import com.woniu.jiapei.model.RepairExample;
import com.woniu.jiapei.service.RepairService;
import com.woniu.jiapei.tools.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RepairServiceImpl implements RepairService {
    @Resource
    private RepairMapper repairMapper;

    @Override
    public void save(Repair repair) {
        repairMapper.insertSelective(repair);
    }

    @Override
    public void update(Repair repair) {
        repairMapper.updateByPrimaryKeySelective(repair);
    }

    @Override
    public void delRepairByFaultId(Integer faultId) {
        RepairExample example = new RepairExample();
        RepairExample.Criteria criteria = example.createCriteria();
        criteria.andFaultIdEqualTo(faultId);
        List<Repair> repairList = repairMapper.selectByExample(example);
        for (Repair repair : repairList) {
            repair.setRepairStatus("已删除");
            repairMapper.updateByPrimaryKeySelective(repair);
        }
    }

    @Override
    public void findAll(RepairCondition repairCondition, PageBean pageBean) {

    }
}

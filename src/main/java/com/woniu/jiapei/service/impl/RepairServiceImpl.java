package com.woniu.jiapei.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.jiapei.condition.RepairCondition;
import com.woniu.jiapei.mapper.RepairMapper;
import com.woniu.jiapei.model.Repair;
import com.woniu.jiapei.model.RepairExample;
import com.woniu.jiapei.service.RepairService;
import com.woniu.jiapei.tools.PageBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
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
    public List<Repair> findAll(RepairCondition repairCondition, PageBean pageBean) {
        PageHelper.startPage(pageBean.getPageNum(),pageBean.getPageSize());
        List<Repair> repairList = repairMapper.findAll(repairCondition);
        PageInfo pageInfo = new PageInfo(repairList);
        pageBean.setPages(pageInfo.getPages());
        pageBean.setTotal((int) pageInfo.getTotal());
        return repairList;
    }

    @Override
    public void delRepairByRepairId(String repairId) {
        Repair repair = new Repair();
        repair.setRepairId(repairId);
        repair.setRepairStatus("已删除");
        repairMapper.updateByPrimaryKeySelective(repair);
    }

    @Override
    public List<Repair> getRepairsByCondition(RepairCondition repairCondition) {
        return repairMapper.findAll(repairCondition);
    }
}

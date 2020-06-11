package com.woniu.jiapei.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.jiapei.condition.FaultCondition;
import com.woniu.jiapei.mapper.FaultMapper;
import com.woniu.jiapei.model.Fault;
import com.woniu.jiapei.service.FaultService;
import com.woniu.jiapei.tools.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 售后管理--故障模块服务层实现类
 */
@Service
public class FaultServiceImpl implements FaultService {
    @Resource
    private FaultMapper faultMapper;

    @Override
    public List<Fault> findAll(FaultCondition faultCondition,PageBean pageBean) {
        PageHelper.startPage(pageBean.getPageNum(),pageBean.getPageSize());
        List<Fault> faultList = faultMapper.findAll(faultCondition);
        PageInfo pageInfo = new PageInfo(faultList);
        pageBean.setPages(pageInfo.getPages());
        pageBean.setTotal((int) pageInfo.getTotal());
        return faultList;
    }

    @Override
    public Fault findByFaultId(Integer faultId) {
        return faultMapper.selectByPrimaryKey(faultId);
    }

    @Override
    public void save(Fault fault) {
        faultMapper.insert(fault);
    }

    @Override
    public void update(Fault fault) {
        faultMapper.updateByPrimaryKeySelective(fault);
    }
}

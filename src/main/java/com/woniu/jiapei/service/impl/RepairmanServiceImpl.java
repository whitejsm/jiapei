package com.woniu.jiapei.service.impl;

import com.woniu.jiapei.mapper.DepartmentMapper;
import com.woniu.jiapei.mapper.FaultMapper;
import com.woniu.jiapei.mapper.HospitalMapper;
import com.woniu.jiapei.mapper.RepairmanMapper;
import com.woniu.jiapei.model.*;
import com.woniu.jiapei.service.RepairmanService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RepairmanServiceImpl implements RepairmanService {
    @Resource
    RepairmanMapper repairmanMapper;
    @Resource
    HospitalMapper hospitalMapper;
    @Resource
    DepartmentMapper departmentMapper;
    @Resource
    FaultMapper faultMapper;
    @Override
    public List<Repairman> findHospital(int userinfoId) {
        RepairmanExample example=new RepairmanExample();
        RepairmanExample.Criteria criteria=example.createCriteria();
        criteria.andRepairmanIdEqualTo(userinfoId);
        List<Repairman> list=repairmanMapper.selectByExample(example);
        return list;
    }

    @Override
    public Integer countHospital(int userinfoId) {
        return repairmanMapper.countHospital(userinfoId);
    }

    @Override
    public void deleteDeptment(int departmentId) {
        RepairmanExample example=new RepairmanExample();
        RepairmanExample.Criteria criteria=example.createCriteria();
        criteria.andDepartmentIdEqualTo(departmentId);
        repairmanMapper.deleteByExample(example);
    }

    @Override
    public List<Hospital> getHospitals() {
        List<Hospital> list=hospitalMapper.selectByExample(null);
        return list;
    }

    @Override
    public List<Department> getDeprtments(int hospitalId) {
        List<Department> list=departmentMapper.getByHospitalId(hospitalId);
        return list;
    }

    @Override
    public void RepairAddDepartment(int hospitalId, int[] departmentId) {
        System.out.println(hospitalId);
        System.out.println(departmentId);
    }

    @Override
    public List<Fault> getRepair(int userinfoId) {
        FaultExample example=new FaultExample();
        FaultExample.Criteria criteria=example.createCriteria();
        criteria.andContactorIdEqualTo(userinfoId);
        List<Fault> list=faultMapper.selectByExample(example);
        return list;
    }

    @Override
    public Integer countRepair(int userinfoId) {
        FaultExample example=new FaultExample();
        FaultExample.Criteria criteria=example.createCriteria();
        criteria.andContactorIdEqualTo(userinfoId);
        return faultMapper.countByExample(example);
    }
}

package com.woniu.jiapei.service.impl;

import com.woniu.jiapei.mapper.DepartmentMapper;
import com.woniu.jiapei.mapper.FaultMapper;
import com.woniu.jiapei.mapper.HospitalMapper;
import com.woniu.jiapei.mapper.RepairManMapper;
import com.woniu.jiapei.model.*;
import com.woniu.jiapei.service.RepairmanService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class RepairmanServiceImpl implements RepairmanService {
    @Resource
    RepairManMapper repairmanMapper;
    @Resource
    HospitalMapper hospitalMapper;
    @Resource
    DepartmentMapper departmentMapper;
    @Resource
    FaultMapper faultMapper;
    @Override
    public List<RepairMan> findHospital(int userinfoId) {
        RepairManExample example=new RepairManExample();
        RepairManExample.Criteria criteria=example.createCriteria();
        criteria.andRepairmanIdEqualTo(userinfoId);
        List<RepairMan> list=repairmanMapper.selectByExample(example);
        return list;
    }

    @Override
    public Integer countHospital(int userinfoId) {
        return repairmanMapper.countHospital(userinfoId);
    }

    @Override
    public void deleteDeptment(int departmentId) {
        RepairManExample example=new RepairManExample();
        RepairManExample.Criteria criteria=example.createCriteria();
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
    public List<Fault> getRepair(int userinfoId) {
        List<Fault> list=faultMapper.findByRepairId(userinfoId);
        return list;
    }

    @Override
    public Integer countRepair(int userinfoId) {
        FaultExample example=new FaultExample();
        FaultExample.Criteria criteria=example.createCriteria();
        criteria.andContactorIdEqualTo(userinfoId);
        return faultMapper.countByExample(example);
    }

    @Override
    public void RepairAddDepartment(int repairManId,String[] department) {
          List<Department> departmentList=new ArrayList<>();
        for (String s : department) {
            Department department1=departmentMapper.selectByPrimaryKey(Integer.parseInt(s));
            departmentList.add(department1);
        }
        for (Department department1 : departmentList) {
            System.out.println("增加维修负责");
            RepairMan repairman=new RepairMan();
            repairman.setRepairmanId(repairManId);
            repairman.setHospitalId(department1.getHospitalId());
            repairman.setDepartmentId(department1.getDepartmentId());
            repairman.setDepartmentname(department1.getDepartmentname());
            repairman.setHospitalname(department1.getHospital().getHospitalname());
            repairmanMapper.insertSelective(repairman);
        }
    }

}

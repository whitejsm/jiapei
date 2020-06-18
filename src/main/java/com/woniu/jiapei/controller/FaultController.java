package com.woniu.jiapei.controller;

import com.woniu.jiapei.condition.FaultCondition;
import com.woniu.jiapei.mapper.DepartmentMapper;
import com.woniu.jiapei.mapper.HospitalMapper;
import com.woniu.jiapei.model.Fault;
import com.woniu.jiapei.model.Hospital;
import com.woniu.jiapei.service.FaultService;
import com.woniu.jiapei.tools.Msg;
import com.woniu.jiapei.tools.PageBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/faults/")
public class FaultController {
    @Resource
    private FaultService faultServiceImpl;
    @Resource
    private HospitalMapper hospitalMapper;
    @Resource
    private DepartmentMapper departmentMapper;

    @GetMapping("findAll")
    public Msg findAll(FaultCondition faultCondition,PageBean pageBean){
        Msg msg = new Msg();
        try{
            System.out.println(faultCondition);
            List<Fault> faultList = faultServiceImpl.findAll(faultCondition,pageBean);
            for (Fault fault : faultList) {
                System.out.println(fault);
            }
            List<Hospital> hospitalList = hospitalMapper.selectByExample(null);
            msg.setHospitalList(hospitalList);
            msg.setResult(true);
            msg.setMsg("数据维护成功");
            msg.setFaultList(faultList);
        }catch(Exception e){
            e.printStackTrace();
            msg.setResult(false);
            msg.setMsg("数据维护失败");
        }
        return msg;
    }

    @GetMapping("findDepartment")
    public Msg findDepartment(Integer hospitalId){
        Msg msg = new Msg();
        if(hospitalId==-1){
            msg.setDepartmentList(null);
            return msg;
        }
        msg.setDepartmentList(departmentMapper.findByHospitalId(hospitalId));
        return msg;
    }
}

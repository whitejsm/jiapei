package com.woniu.jiapei.controller;

import com.woniu.jiapei.condition.BedCondition;
import com.woniu.jiapei.mapper.DepartmentMapper;
import com.woniu.jiapei.mapper.HospitalMapper;
import com.woniu.jiapei.mapper.ManufacturerMapper;
import com.woniu.jiapei.model.*;
import com.woniu.jiapei.service.BedService;
import com.woniu.jiapei.tools.Msg;
import com.woniu.jiapei.tools.PageBean;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * 床位管理的控制器
 */
@RestController
@RequestMapping("/bed/")
public class BedController {
    @Resource
    private BedService bedServiceImpl;
    @Resource
    private HospitalMapper hospitalMapper;
    @Resource
    private DepartmentMapper departmentMapper;
    @Resource
    private ManufacturerMapper manufacturerMapper;

    @GetMapping("findAll")
    public Msg findAll(PageBean pageBean){
        Msg msg = new Msg();
        try{
            List<Bed> bedList = bedServiceImpl.findAll(pageBean);
            msg.setBedList(bedList);
            ///jaaa
            msg.setPageBean(pageBean);
            msg.setMsg("数据维护成功");
            msg.setResult(true);
        }catch(Exception e) {
            msg.setMsg("数据维护失败");
            msg.setResult(false);
            e.printStackTrace();
        }finally {
            return msg;
        }
    }

    @GetMapping("findByExample")
    public Msg findByExample(BedCondition bedCondition, PageBean pageBean){
        Msg msg = new Msg();
        try{
            System.out.println(bedCondition);
            bedCondition.setBeginTime(new Date(bedCondition.getBeginTime().getTime()+1000*3600*13));
            bedCondition.setEndTime(new Date(bedCondition.getEndTime().getTime()+1000*3600*37));
            System.out.println(bedCondition);

            List<Bed> bedList = bedServiceImpl.findByExample(bedCondition,pageBean);
            List<Hospital> hospitalList = hospitalMapper.selectByExample(null);
            List<Manufacturer> manufacturerList = manufacturerMapper.selectByExample(null);

            msg.setManufacturerList(manufacturerList);
            msg.setHospitalList(hospitalList);
            for (Bed bed : bedList) {
                bed.setCreateTime(new Date(bed.getCreateTime().getTime()-1000*3600*13));
            }
            msg.setBedList(bedList);
            msg.setPageBean(pageBean);
            msg.setMsg("数据维护成功");
            msg.setResult(true);
        }catch(Exception e) {
            msg.setMsg("数据维护失败");
            msg.setResult(false);
            e.printStackTrace();
        }finally {
            return msg;
        }
    }

    @GetMapping("findOne")
    public Msg findOne(String bedId){
        System.out.println(bedId);
        Msg msg = new Msg();
        try{
            Bed bed = bedServiceImpl.findById(bedId);
            System.out.println(bed);
            msg.setBed(bed);
            msg.setMsg("数据维护成功");
            msg.setResult(true);
        }catch(Exception e) {
            msg.setMsg("数据维护失败");
            msg.setResult(false);
            e.printStackTrace();
        }finally {
            return msg;
        }
    }

    @GetMapping("disable")
    public Msg disable(String bedId){
        Msg msg = new Msg();
        try{
            Bed bed = new Bed();
            bed.setBedId(bedId);
            bed.setStatus("停用");
            bedServiceImpl.update(bed);
            msg.setMsg("数据维护成功");
            msg.setResult(true);
        }catch(Exception e) {
            msg.setMsg("数据维护失败");
            msg.setResult(false);
            e.printStackTrace();
        }
        return msg;
    }

    @PostMapping("update")
    public Msg update(Bed bed){
        Msg msg = new Msg();
        try{
            System.out.println(bed);
            bedServiceImpl.update(bed);
            msg.setMsg("数据维护成功");
            msg.setResult(true);
        }catch(Exception e) {
            msg.setMsg("数据维护失败");
            msg.setResult(false);
            e.printStackTrace();
        }finally {
            return msg;
        }
    }

    @PostMapping("save")
    public Msg save(Bed bed){
        Msg msg = new Msg();
        try{
            //生成新的bedID
            bed.setBedId(bed.getBedId()+(new Date().getTime()+1000*3600*13)+ (new Random().nextInt(8999)+1000));
            bed.setStatus("空闲");
            bed.setPower(100);
            bed.setCreateTime(new Date(new Date().getTime()+1000*3600*13));
            System.out.println(bed);
            bedServiceImpl.save(bed);
            msg.setMsg("数据维护成功");
            msg.setResult(true);
        }catch(Exception e) {
            msg.setMsg("数据维护失败");
            msg.setResult(false);
            e.printStackTrace();
        }finally {
            return msg;
        }
    }

    @PostMapping("showCheckedBedId")
    public Msg showCheckedBedId(@RequestBody List<String> selectedIDs){
        Msg msg = new Msg();
        try{
            for (String selectedID : selectedIDs) {
                System.out.println(selectedID);
            }
            msg.setMsg("数据维护成功");
            msg.setResult(true);
        }catch(Exception e) {
            msg.setMsg("数据维护失败");
            msg.setResult(false);
            e.printStackTrace();
        }finally {
            return msg;
        }
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

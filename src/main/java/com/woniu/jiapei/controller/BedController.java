package com.woniu.jiapei.controller;

import com.woniu.jiapei.condition.BedCondition;
import com.woniu.jiapei.mapper.HospitalMapper;
import com.woniu.jiapei.model.Bed;
import com.woniu.jiapei.model.Hospital;
import com.woniu.jiapei.model.Message;
import com.woniu.jiapei.service.IBedService;
import com.woniu.jiapei.tools.Msg;
import com.woniu.jiapei.tools.PageBean;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 床位管理的控制器
 */
@RestController
@RequestMapping("/bed/")
public class BedController {
    @Resource
    private IBedService bedServiceImpl;

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
            List<Bed> bedList = bedServiceImpl.findByExample(bedCondition,pageBean);
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
        }finally {
            return msg;
        }
    }

    @PostMapping("update")
    public Msg update(Bed bed){
        Msg msg = new Msg();
        try{
            System.out.println("ddd");
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

    @Resource
    private HospitalMapper hospitalMapper;

    @GetMapping("asd")
    public Hospital asd(){
        return hospitalMapper.findOneWithBed(3);
    }

}

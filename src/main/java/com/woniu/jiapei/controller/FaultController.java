package com.woniu.jiapei.controller;

import com.woniu.jiapei.condition.BedCondition;
import com.woniu.jiapei.condition.FaultCondition;
import com.woniu.jiapei.mapper.DepartmentMapper;
import com.woniu.jiapei.mapper.HospitalMapper;
import com.woniu.jiapei.model.*;
import com.woniu.jiapei.service.BedService;
import com.woniu.jiapei.service.FaultService;
import com.woniu.jiapei.service.RepairService;
import com.woniu.jiapei.service.UserInfoService;
import com.woniu.jiapei.tools.DataFileUtil;
import com.woniu.jiapei.tools.Msg;
import com.woniu.jiapei.tools.PageBean;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/faults/")
public class FaultController {
    @Resource
    private FaultService faultServiceImpl;
    @Resource
    private HospitalMapper hospitalMapper;
    @Resource
    private DepartmentMapper departmentMapper;
    @Resource
    private BedService bedServiceImpl;
    @Resource
    private UserInfoService userInfoServiceImpl;
    @Resource
    private RepairService repairServiceImpl;

    @GetMapping("findAll")
    public Msg findAll(FaultCondition faultCondition, PageBean pageBean, HttpSession session){
        System.out.println(session.getAttribute("userId"));
        System.out.println(session.getAttribute("userName"));
        System.out.println(session.getAttribute("roleId"));
        System.out.println(session.getAttribute("roleName"));

        Msg msg = new Msg();
        try{
            if(faultCondition.getEndTime()!=null)
                faultCondition.setEndTime(new Date(faultCondition.getEndTime().getTime()+1000*3600*24));
            System.out.println(faultCondition);
            List<Fault> faultList = faultServiceImpl.findAll(faultCondition,pageBean);


            List<Hospital> hospitalList = null;
            if(faultCondition.getRoleId()==null){

            }else if(faultCondition.getRoleId()==4){
                hospitalList = hospitalMapper.findByRepairMan(faultCondition.getUserInfoId());
            }else if(faultCondition.getRoleId()==5){
                hospitalList = hospitalMapper.findByHospitalMan(faultCondition.getUserInfoId());
            }else if(faultCondition.getRoleId()==6){
                hospitalList = hospitalMapper.findByDepartmentMan(faultCondition.getUserInfoId());
            }else{
                hospitalList = hospitalMapper.selectByExample(null);
            }

            msg.setHospitalList(hospitalList);
            msg.setPageBean(pageBean);
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
    public Msg findDepartment(BedCondition bedCondition){
        Msg msg = new Msg();
        if(bedCondition.getHospitalId()==-1){
            msg.setDepartmentList(null);
            return msg;
        }
        msg.setDepartmentList(departmentMapper.findByDepartorId(bedCondition));
        return msg;
    }
    //查询床ID
    @GetMapping("findBed")
    public List<Bed> findBed(Integer departmentId){
        return bedServiceImpl.findByDepartmentId(departmentId);
    }
    //查询来源人的信息
    @GetMapping("getAddFaultPerson")
    public List<UserInfo> getAddFaultPerson(FaultCondition faultCondition){
        return userInfoServiceImpl.findByFaultSource(faultCondition);
    }
    //查询用户信息
    @GetMapping("getUserInfo")
    public UserInfo getUserInfo(Integer userinfoId){
        return userInfoServiceImpl.findById(userinfoId);
    }
    //删除一条故障信息（将故障状态设置为已删除）
    @GetMapping("delFaultById")
    public Msg delFaultById(Fault fault){
        Msg msg = new Msg();
        try{
            faultServiceImpl.delFaultById(fault);
            //删除故障同时将维修列表中创建的维修记录的状态也设置为已删除
            repairServiceImpl.delRepairByFaultId(fault.getFaultId());
            msg.setResult(true);
            msg.setMsg("信息维护成功");
        }catch(Exception e){
            e.printStackTrace();
            msg.setResult(false);
            msg.setMsg("信息维护失败");
        }
        return msg;
    }

    @GetMapping("openArk")
    public Msg openArk(String bedId,Integer faultId){
        Msg msg = new Msg();
        try{
            System.out.println("需要开启的床位号为："+bedId);
            System.out.println("对应的故障ID:"+faultId);
            msg.setResult(true);
            msg.setMsg("信息维护成功");
        }catch(Exception e){
            e.printStackTrace();
            msg.setResult(false);
            msg.setMsg("信息维护失败");
        }
        return msg;
    }

    //获取选中的IDS
    @PostMapping("showCheckedFaultId")
    public Msg showCheckedFaultId(@RequestBody List<String> selectedIDs){
        Msg msg = new Msg();
        try{
            for (String selectedID : selectedIDs) {
                System.out.println(selectedID);
            }
            msg.setResult(true);
            msg.setMsg("信息维护成功");
        }catch(Exception e){
            e.printStackTrace();
            msg.setResult(false);
            msg.setMsg("信息维护失败");
        }
        return msg;
    }
    //新增故障信息
    @PostMapping("saveFault")
    public Msg saveFault(Fault fault){
        Msg msg = new Msg();
        try{
            fault.setFaultStatus("待备案");
            fault.setCreateTime(new Date());
            faultServiceImpl.save(fault);

            //创建故障信息的同时创建一条维修记录，但是不填写维修人员、维修信息、维修状态、维修结果
            Repair repair = new Repair();
            Date date = new Date();
            String repairId = "" + (date.getYear()+1700)+(date.getMonth()+1)+date.getDate()+date.getHours()+date.getMinutes()+date.getSeconds()+"wx"+(9000+new Random().nextInt(1000));
            repair.setRepairId(repairId);
            repair.setCreateTime(date);
            repair.setRepairResult("待备案");
            repair.setRepairStatus("待备案");
            repair.setFaultId(fault.getFaultId());
            repairServiceImpl.save(repair);

            msg.setResult(true);
            msg.setMsg("信息维护成功");
        }catch(Exception e){
            e.printStackTrace();
            msg.setResult(false);
            msg.setMsg("信息维护失败");
        }
        return msg;
    }
    //修改故障信息
    @PostMapping("saveFaultUpdate")
    public Msg saveFaultUpdate(Fault fault){
        Msg msg = new Msg();
        try{
            faultServiceImpl.update(fault);
            msg.setResult(true);
            msg.setMsg("信息维护成功");
        }catch(Exception e){
            e.printStackTrace();
            msg.setResult(false);
            msg.setMsg("信息维护失败");
        }
        return msg;
    }

    //备案故障信息
    @PostMapping("putOnRecord")
    public Msg putOnRecord(Fault fault,Repair repair){
        System.out.println(fault);
        System.out.println(repair);
        System.out.println(repair.getRepairmanId());
        Msg msg = new Msg();
        try{
            fault.setFaultStatus("已备案");
            faultServiceImpl.update(fault);
            //备案故障信息的同时更新维修记录状态和备案时间，填写维修人员的ID
            repair.setCreateTime(new Date());
            repair.setRepairInstructions("已进入维修流程，请耐心等待......");
            repair.setRepairResult("待维修");
            repair.setRepairStatus("待维修");
            repairServiceImpl.update(repair);

            msg.setResult(true);
            msg.setMsg("备案成功");
        }catch(Exception e){
            e.printStackTrace();
            msg.setResult(false);
            msg.setMsg("信息维护失败");
        }
        return msg;
    }

    //导出报表
    @GetMapping("downloadFaultFile")
    public void downloadFaultFile(FaultCondition faultCondition, HttpServletResponse response) throws IOException {
        List<Fault> faultList = faultServiceImpl.getFaultsByCondition(faultCondition);
        // 生成文件
        XSSFWorkbook workBook = DataFileUtil.createScoreFile(Fault.class, faultList);
//        XSSFWorkbook workBook = DataFileUtil.createScoreFile(Examination.class, examinationMapper.findAll());

        String filename = "faults.xlsx";

        //设置文件下载头
        response.setHeader("content-disposition", "attachment;filename=" + filename);
        //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
//        response.setContentType("multipart/form-data");
        response.setContentType("application/vnd.ms-excel");
        //BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
        // 不要使用ajax跳转到这个链接，否则会抛出管道中断错误
        OutputStream out = response.getOutputStream();
        workBook.write(out);
        out.flush();
        out.close();
    }
}

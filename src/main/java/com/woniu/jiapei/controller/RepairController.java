package com.woniu.jiapei.controller;

import com.woniu.jiapei.condition.BedCondition;
import com.woniu.jiapei.condition.FaultCondition;
import com.woniu.jiapei.condition.RepairCondition;
import com.woniu.jiapei.mapper.DepartmentMapper;
import com.woniu.jiapei.mapper.HospitalMapper;
import com.woniu.jiapei.model.Fault;
import com.woniu.jiapei.model.Hospital;
import com.woniu.jiapei.model.Repair;
import com.woniu.jiapei.model.UserInfo;
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

@RestController
@RequestMapping("/repair/")
public class RepairController {
    @Resource
    private RepairService repairServiceImpl;
    @Resource
    private HospitalMapper hospitalMapper;
    @Resource
    private DepartmentMapper departmentMapper;
    @Resource
    private UserInfoService userInfoServiceImpl;
    @Resource
    private FaultService faultServiceImpl;
    @RequestMapping("findAll")
    public Msg findAll(RepairCondition repairCondition, PageBean pageBean, HttpSession session){
        Msg msg = new Msg();
        try{
            repairCondition.setRoleId((Integer) session.getAttribute("roleId"));
            repairCondition.setUserInfoId((Integer) session.getAttribute("userId"));

            if(repairCondition.getEndTime()!=null)
                repairCondition.setEndTime(new Date(repairCondition.getEndTime().getTime()+1000*3600*24));

            System.out.println(repairCondition);
            List<Repair> repairList = repairServiceImpl.findAll(repairCondition,pageBean);

            List<Hospital> hospitalList = null;
            if(repairCondition.getRoleId()==null){
                hospitalList = null;
            }else if(repairCondition.getRoleId()==4){
                hospitalList = hospitalMapper.findByRepairMan(repairCondition.getUserInfoId());
            }else if(repairCondition.getRoleId()==5){
                hospitalList = hospitalMapper.findByHospitalMan(repairCondition.getUserInfoId());
            }else if(repairCondition.getRoleId()==6){
                hospitalList = hospitalMapper.findByDepartmentMan(repairCondition.getUserInfoId());
            }else{
                hospitalList = hospitalMapper.selectByExample(null);
            }

            msg.setRepairList(repairList);
            msg.setHospitalList(hospitalList);
            msg.setPageBean(pageBean);
            msg.setMsg("数据维护成功");
            msg.setResult(true);
        }catch(Exception e){
            e.printStackTrace();
            msg.setMsg("数据维护失败");
            msg.setResult(false);
        }
        return msg;
    }

    @GetMapping("findDepartment")
    public Msg findDepartment(BedCondition bedCondition,HttpSession session){
        bedCondition.setRoleId((Integer) session.getAttribute("roleId"));
        bedCondition.setUserInfoId((Integer) session.getAttribute("userId"));
        Msg msg = new Msg();
        if(bedCondition.getHospitalId()==-1){
            msg.setDepartmentList(null);
            return msg;
        }
        msg.setDepartmentList(departmentMapper.findByDepartorId(bedCondition));
        return msg;
    }

    @GetMapping("findRepairman")
    public List<UserInfo> findRepairman(RepairCondition repairCondition,HttpSession session){
        repairCondition.setRoleId((Integer) session.getAttribute("roleId"));
        repairCondition.setUserInfoId((Integer) session.getAttribute("userId"));
        List<UserInfo> repairmanList = userInfoServiceImpl.findRepairman(repairCondition);
        return repairmanList;
    }

    @PostMapping("updateRepair")
    public void updateRepair(Repair repair){
        System.out.println(repair.getRepairStatus());
        repair.setCreateTime(new Date());
        repairServiceImpl.update(repair);

        Fault fault = new Fault();
        fault.setFaultId(repair.getFaultId());
        if("维修中".equals(repair.getRepairStatus())){
            fault.setFaultStatus("修复中");
        }else if("已完成".equals(repair.getRepairStatus())){
            fault.setFaultStatus("已修复");
        }
        faultServiceImpl.update(fault);
    }

    @GetMapping("delRepair")
    public Msg delRepair(String repairId){
        Msg msg = new Msg();
        try{
            repairServiceImpl.delRepairByRepairId(repairId);
            msg.setMsg("数据维护成功");
            msg.setResult(true);
        }catch(Exception e){
            e.printStackTrace();
            msg.setMsg("数据维护失败");
            msg.setResult(false);
        }
        return msg;
    }

    //获取选中的IDS
    @PostMapping("showCheckedRepairId")
    public Msg showCheckedRepairId(@RequestBody List<String> selectedIDs){
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

    //导出报表
    @GetMapping("downloadRepairFile")
    public void downloadRepairFile(RepairCondition repairCondition, HttpServletResponse response) throws IOException {
        List<Repair> repairList = repairServiceImpl.getRepairsByCondition(repairCondition);
        // 生成文件
        XSSFWorkbook workBook = DataFileUtil.createScoreFile(Repair.class, repairList);
//        XSSFWorkbook workBook = DataFileUtil.createScoreFile(Examination.class, examinationMapper.findAll());

        String filename = "repairs.xlsx";

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

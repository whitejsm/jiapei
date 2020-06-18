package com.woniu.jiapei.controller;

import com.woniu.jiapei.JiapeiApplication;
import com.woniu.jiapei.condition.BedCondition;
import com.woniu.jiapei.condition.OrderCondition;
import com.woniu.jiapei.mapper.DepartmentMapper;
import com.woniu.jiapei.mapper.HospitalMapper;
import com.woniu.jiapei.mapper.ManufacturerMapper;
import com.woniu.jiapei.model.*;
import com.woniu.jiapei.service.BedService;
import com.woniu.jiapei.service.ManufacturerService;
import com.woniu.jiapei.tools.DataFileUtil;
import com.woniu.jiapei.tools.Msg;
import com.woniu.jiapei.tools.PageBean;
import com.woniu.jiapei.tools.UploadFile;
import com.woniu.jiapei.tools.impl.BedPrimaryKey;
import com.woniu.jiapei.tools.impl.OrderPrimaryKey;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
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
    private ManufacturerService manufacturerServiceImpl;

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

            if(bedCondition.getEndTime()!=null)
                bedCondition.setEndTime(new Date(bedCondition.getEndTime().getTime()+1000*3600*24));
            System.out.println(bedCondition);

            List<Bed> bedList = bedServiceImpl.findByExample(bedCondition,pageBean);
            List<Manufacturer> manufacturerList = manufacturerServiceImpl.findAll();

            List<Hospital> hospitalList = null;
            if(bedCondition.getRoleId()!=null){
                if(bedCondition.getRoleId()==5){
                    hospitalList = hospitalMapper.findByHospitalMan(bedCondition.getUserInfoId());
                }else if(bedCondition.getRoleId()==6){
                    hospitalList = hospitalMapper.findByDepartmentMan(bedCondition.getUserInfoId());
                }else{
                    hospitalList = hospitalMapper.selectByExample(null);
                }
            }

            msg.setManufacturerList(manufacturerList);
            msg.setHospitalList(hospitalList);
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
            Date date = new Date();
            String bedId = "" + (date.getYear()+1700)+(date.getMonth()+1)+date.getDate()+date.getHours()+date.getMinutes()+date.getSeconds()+"bed"+(9000+new Random().nextInt(1000));
            bed.setBedId(bedId);
            bed.setStatus("空闲");
            bed.setPower(100);
            bed.setCreateTime(new Date());
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
    public Msg findDepartment(BedCondition bedCondition){
        Msg msg = new Msg();
        if(bedCondition.getHospitalId()==-1){
            msg.setDepartmentList(null);
            return msg;
        }
        msg.setDepartmentList(departmentMapper.findByDepartorId(bedCondition));
        return msg;
    }

    @GetMapping("findManufacturerById")
    public Manufacturer findManufacturerById(Integer manufacturerId){
        return manufacturerServiceImpl.findById(manufacturerId);
    }

    //导出报表
    @GetMapping("downloadBedFile")
    public void downloadBedFile(BedCondition bedCondition, HttpServletResponse response) throws IOException {
        System.out.println(bedCondition+"!!!!!!!!!!!!!!!!!!!!!!");
        List<Bed> bedList = bedServiceImpl.getBedsByCondition(bedCondition);
        System.out.println(bedList);
        // 生成文件
        XSSFWorkbook workBook = DataFileUtil.createScoreFile(Bed.class, bedList);
//        XSSFWorkbook workBook = DataFileUtil.createScoreFile(Examination.class, examinationMapper.findAll());

        String filename = "bed.xlsx";

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

    @GetMapping("/downBedTemplate")
    public void down(HttpServletResponse response) throws IOException {
        // 生成文件
        XSSFWorkbook workBook = DataFileUtil.createTemplateXlsxFile(Bed.class);
//        XSSFWorkbook workBook = DataFileUtil.createScoreFile(Examination.class, examinationMapper.findAll());

        String filename = "bedAdd.xlsx";

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

    //上传文件
    @RequestMapping("/uploadBedFile")
    public boolean uploadBedFile(MultipartFile file) {
        String realPath = JiapeiApplication.class.getClassLoader().getResource(".").getPath() + "upload/bed";
        System.out.println(realPath);
        // 文件保存路径
        String path = UploadFile.saveFile(file, realPath);

        boolean flag = false;
        try {
            List<Bed> list = DataFileUtil.getObjectList(Bed.class, path, new BedPrimaryKey(), "bedId");
            System.out.println(list);
            bedServiceImpl.saveBeds(list);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}

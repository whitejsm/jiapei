package com.woniu.jiapei.controller;

import com.woniu.jiapei.model.Department;
import com.woniu.jiapei.model.Fault;
import com.woniu.jiapei.model.Hospital;
import com.woniu.jiapei.model.RepairMan;
import com.woniu.jiapei.service.RepairmanService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 周元皓丶
 */
@RestController
public class RepairmanController {
    @Resource
    RepairmanService repairmanService;
    @GetMapping("showHospital")
    public Map<String,Object> showHospital(int userinfoId) throws ParseException {
        Map<String,Object> map=new HashMap<String,Object>();
        List<RepairMan> list=repairmanService.findHospital(userinfoId);
        Integer countHospital=repairmanService.countHospital(userinfoId);
        map.put("hospitalList",list);
        map.put("countHospital",countHospital);
        return map;
    }

    @PostMapping("deleteDept")
    public void deleteDept(int departmentId){
        repairmanService.deleteDeptment(departmentId);
    }

    @GetMapping("getHospitals")
    public Map<String,Object> getHospitals() throws ParseException {
        Map<String,Object> map=new HashMap<String,Object>();
        List<Hospital> list=repairmanService.getHospitals();
        map.put("allHospital",list);
        return map;
    }

    @PostMapping("getDepartments")
    public Map<String,Object> getDepartments(int hospitalId) throws ParseException {
        Map<String,Object> map=new HashMap<String,Object>();
        List<Department> list=repairmanService.getDeprtments(hospitalId);
        map.put("allDepartment",list);
        return map;
    }

    @PostMapping("repairAddDepartment")
    public void repairAddDepartment(Integer repairManId,String[] department){

        department[0]=department[0].substring(1);
        for(int i=0;i<department.length;i++){
            String a=department[i].substring(5,6);
            department[i]=a;
            System.out.println(department[i]);
        }
        repairmanService.RepairAddDepartment(repairManId,department);

    }

    @GetMapping("getRepair")
    public Map<String,Object> getRepair(int userinfoId) throws ParseException {
        Map<String,Object> map=new HashMap<String,Object>();
        List<Fault> list=repairmanService.getRepair(userinfoId);
        Integer countRepair=repairmanService.countRepair(userinfoId);
        map.put("allRepair",list);
        map.put("countRepair",countRepair);
        return map;
    }
}

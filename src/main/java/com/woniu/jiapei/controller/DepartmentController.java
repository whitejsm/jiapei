package com.woniu.jiapei.controller;

import com.github.pagehelper.PageInfo;
import com.woniu.jiapei.condition.DepartmentCondition;
import com.woniu.jiapei.model.Department;
import com.woniu.jiapei.model.Hospital;
import com.woniu.jiapei.model.PageBean;
import com.woniu.jiapei.model.UserInfo;
import com.woniu.jiapei.service.DepartmentService;
import com.woniu.jiapei.service.HospitalService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Resource
    DepartmentService departmentService;
    @Resource
    HospitalService hospitalService;

    @GetMapping("/findAll")
    public List<Department> findAll() {

        return departmentService.findAll();
    }

    @GetMapping("/findHospitals")
    public List<Hospital> findHospitals() {

        return departmentService.findHospitals();
    }

    @PostMapping("/search")
    public Map<String, Object> search(DepartmentCondition hospitalSearch, Integer currentPage , HttpSession session) {
        if (hospitalSearch.getValue1() != null && hospitalSearch.getValue2() != null) {
            Date date1 = new Date(hospitalSearch.getValue1());
            Date date2 = new Date(hospitalSearch.getValue2());
            hospitalSearch.setDate1(date1);
            hospitalSearch.setDate2(date2);

        }



        if ((Integer)(session.getAttribute("roleId"))==1||(Integer)(session.getAttribute("roleId"))==2) {
            HashMap<String, Object> map = departmentService.findBySearch(hospitalSearch,currentPage);
//        for (Object o : (List)map.get("list")) {
////            System.out.println(o);
//        }
//        System.out.println(map.get("info"));
            PageInfo info = (PageInfo) map.get("info");
            PageBean pb = new PageBean();
            pb.setCurrentPage(info.getPageNum());
            pb.setPages(info.getPages());
            pb.setTotalCount((int) info.getTotal());
//        System.out.println(pb);
            map.put("pb", pb);
            return map;
        } else if ((Integer) (session.getAttribute("roleId")) == 6) {
            HashMap<String, Object> map = departmentService.searchOwn((Integer) (session.getAttribute("userId")), currentPage);
            PageInfo info = (PageInfo) map.get("info");
            PageBean pb = new PageBean();
            pb.setCurrentPage(info.getPageNum());
            pb.setPages(info.getPages());
            pb.setTotalCount((int) info.getTotal());
//        System.out.println(pb);
            map.put("pb", pb);
            return map;
        } else {
            return null;
        }



    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id) {
        return departmentService.delete(id);
//        System.out.println(id);
//        return false;
    }

    @GetMapping("/findInsert")
    public Map<String,Object> findInsert() {
        List<UserInfo> connectors = hospitalService.findPersons("科室对接人");

        List<Hospital> distributor1s = hospitalService.getAllHospital();


        HashMap<String, Object> map = new HashMap<>();
        map.put("connectors", connectors);
        map.put("distributor1s", distributor1s);

        return map;
    }

    @PostMapping("/insertSave")
    public void insertSave(Department department) {
//        System.out.println("增加"+hospital);
        departmentService.insert(department);
    }


    @GetMapping("/{departmentId}")
    public Department showDetail(@PathVariable int departmentId) {
        Department department = departmentService.findByPrimaryKey(departmentId);
        //System.out.println(hospital);
        return department;
    }

    @PostMapping("/updateSave")
    public void updatetsave(Department department) {
//        System.out.println("增加"+hospital);
        System.out.println(department);
        departmentService.update(department);
    }

}

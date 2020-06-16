/**
 * hospital相关操作
 * @since 2020/06/10
 * @auther ytmzz
 */
package com.woniu.jiapei.controller;

import com.github.pagehelper.PageInfo;
import com.woniu.jiapei.model.*;
import com.woniu.jiapei.service.HospitalService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/hospital")
//@CrossOrigin(origins = "*", maxAge = 3600)
public class HospitalController {
    @Resource
    HospitalService hospitalService;
    @Resource
    private HospitalService hospitalServiceImpl;

    @GetMapping("/getAllHospital")
    public Map<String, Object> getAllHospital() {
        Map<String, Object> map = new HashMap<>();

        try {
            List<Hospital> hospitalList = hospitalServiceImpl.getAllHospital();
            map.put("hospitalList", hospitalList);
            map.put("result", "ok");
        } catch(Exception e) {
            e.printStackTrace();
            map.put("result", "error");
        }

        return map;
    }
    @GetMapping("/findAll")
    public List<Hospital> getAll() {
        return hospitalService.findByAll();
    }
    @GetMapping("/findDistributor")
    public List<UserInfo> findDistributor() {

        return hospitalService.findDistributor();
    }

    @GetMapping("/findProvinces")
    public List<Province> findProvinces() {

        return hospitalService.findProvinces();
    }
//    pcz:'',
//    name:'',
//    connector:'',
//    phone:'',
//    rent:'',
//    card:'',
//    share:'',
//    godong:'',
//    distributor1:'',
//    distributor2:'',
//    depcount:'',
//    time:''
    @GetMapping("/{hospitalId}")
    public Hospital showDetail(@PathVariable int hospitalId) {
        Hospital hospital = hospitalService.findByPrimaryKey(hospitalId);
        System.out.println(hospital);
        return hospital;
        }

    @GetMapping("/findInsert")
    public Map<String,Object> findInsert() {
        List<UserInfo> connectors = hospitalService.findPersons("医院对接人");
        List<UserInfo> stockholders = hospitalService.findPersons("股东");
        List<UserInfo> distributor1s = hospitalService.findPersons("一级分销商");
        List<UserInfo> distributor2s = hospitalService.findPersons("二级分销商");

        HashMap<String, Object> map = new HashMap<>();
        map.put("connectors", connectors);
        map.put("stockholders", stockholders);
        map.put("distributor1s", distributor1s);
        map.put("distributor2s", distributor2s);

        return map;
    }

    @GetMapping("/findCities")
    public List<City> findCities(int provinceId) {
        System.out.println(provinceId);
        return hospitalService.findCities(provinceId);
    }

    @GetMapping("/findZones")
    public List<Zone> findZones(int cityId) {
        System.out.println(cityId);
        return hospitalService.findZones(cityId);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id) {
       return hospitalService.delete(id);
//        System.out.println(id);
//        return false;
    }

    @PostMapping("/search")
    public Map<String, Object> search(HospitalSearch hospitalSearch, Integer currentPage) {
        if (hospitalSearch.getValue1() != null && hospitalSearch.getValue2() != null) {
            Date date1 = new Date(hospitalSearch.getValue1());
            Date date2 = new Date(hospitalSearch.getValue2());
            hospitalSearch.setDate1(date1);
            hospitalSearch.setDate2(date2);
        }



        System.out.println(hospitalSearch);
        HashMap<String, Object> map = hospitalService.findBySearch(hospitalSearch,currentPage);
        for (Object o : (List)map.get("list")) {
            System.out.println(o);
        }
        System.out.println(map.get("info"));
        PageInfo info = (PageInfo) map.get("info");
        PageBean pb = new PageBean();
        pb.setCurrentPage(info.getPageNum());
        pb.setPages(info.getPages());
        pb.setTotalCount((int) info.getTotal());
        System.out.println(pb);
        map.put("pb", pb);
        return map;

    }
    @PostMapping("/insertSave")
    public void insertSave(Hospital hospital) {

        hospitalService.insert(hospital);
    }

}

/**
 * hospital相关操作
 * @since 2020/06/10
 * @auther ytmzz
 */
package com.woniu.jiapei.controller;

import com.woniu.jiapei.model.Hospital;
import com.woniu.jiapei.service.HospitalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HospitalController {
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

    @GetMapping("/getDistributorHospital")
    public Map<String, Object> getDistributorHospital(HttpSession session, Integer distributorId) {
        Map<String, Object> map = new HashMap<>();

        try {
            if(distributorId == -1) {
                distributorId = (Integer) session.getAttribute("userId");
            }
            List<Hospital> hospitalList = hospitalServiceImpl.getDistributorHospital(distributorId);
            map.put("hospitalList", hospitalList);
            map.put("result", "success");
        } catch(Exception e) {
            e.printStackTrace();
            map.put("result", "error");
        }

        return map;
    }
}

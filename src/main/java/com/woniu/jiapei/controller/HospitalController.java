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
}

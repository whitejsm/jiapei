package com.woniu.jiapei.controller;

import com.woniu.jiapei.model.Province;
import com.woniu.jiapei.service.ProvinceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AreaController {
    @Resource
    private ProvinceService provinceServiceImpl;

    @GetMapping("/getProvinceList")
    public Map<String, Object> getProvinceList(HttpSession session) {
        Map<String, Object> map = new HashMap<>();

        try {
            List<Province> provinceList = provinceServiceImpl.getProvinceList();
            map.put("provinceList", provinceList);
            map.put("result", "success");
        } catch(Exception e) {
            e.printStackTrace();
            map.put("result", "error");
        }

        return map;
    }
}

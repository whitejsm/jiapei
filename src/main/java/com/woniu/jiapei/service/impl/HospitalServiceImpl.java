/**
 * HospitalService实现类
 * @since 2020/06/10
 * @author ytmzz
 */
package com.woniu.jiapei.service.impl;

import com.woniu.jiapei.mapper.HospitalMapper;
import com.woniu.jiapei.model.Hospital;
import com.woniu.jiapei.service.HospitalService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional
@Service
public class HospitalServiceImpl implements HospitalService {
    @Resource
    private HospitalMapper hospitalMapper;

    @Override
    public List<Hospital> getAllHospital() {
        return hospitalMapper.selectByExample(null);
    }
}

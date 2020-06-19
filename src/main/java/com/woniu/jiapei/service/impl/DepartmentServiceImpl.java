package com.woniu.jiapei.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.jiapei.condition.DepartmentCondition;
import com.woniu.jiapei.mapper.DepartmentMapper;
import com.woniu.jiapei.mapper.HospitalMapper;
import com.woniu.jiapei.model.Department;
import com.woniu.jiapei.model.DepartmentExample;
import com.woniu.jiapei.model.Hospital;
import com.woniu.jiapei.service.DepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Resource
    DepartmentMapper departmentMapper;
    @Resource
    HospitalMapper hospitalMapper;

    @Override
    public List<Department> findAll() {
        return departmentMapper.selectByExample(null);
    }

    @Override
    public HashMap<String, Object> findBySearch(DepartmentCondition hospitalSearch, Integer currentPage) {
        System.out.println(hospitalSearch);
        DepartmentExample example = new DepartmentExample();
        DepartmentExample.Criteria criteria = example.createCriteria();
        criteria.andIsdeleteEqualTo(true);
        if (hospitalSearch.getName() != null && !"".equals(hospitalSearch.getName())) {
            System.out.println(hospitalSearch.getName());
            criteria.andDepartmentnameLike("%"+hospitalSearch.getName()+"%");
        }

        if (hospitalSearch.getHospitalId() != null && !"".equals(hospitalSearch.getHospitalId())) {
            criteria.andHospitalIdEqualTo(hospitalSearch.getHospitalId());
        }

        if (hospitalSearch.getValue1() != null && hospitalSearch.getValue2() != null && hospitalSearch.getValue1() != 0l && hospitalSearch.getValue2() != 0l && hospitalSearch.getValue2() >= hospitalSearch.getValue1()) {

            criteria.andCreateTimeBetween(hospitalSearch.getDate1(), hospitalSearch.getDate2());
        }
        PageHelper.startPage(currentPage, 15);

        List<Department> list = departmentMapper.selectByExample(example);
        System.out.println(list);
        PageInfo<Department> info = new PageInfo<>(list);
        HashMap<String, Object> map = new HashMap<>();
        map.put("list", list);
        map.put("info", info);

        return map;
    }

    @Override
    public List<Hospital> findHospitals() {

        return hospitalMapper.selectByExample(null);
    }

    @Override
    public boolean delete(int id) {
        Department department = new Department();
        department.setDepartmentId(id);
        department.setIsdelete(false);
        System.out.println(department);

        int i = departmentMapper.updateByPrimaryKeySelective(department);
        return i==0?false:true;

    }

    @Override
    public void insert(Department department) {
        department.setCreateTime(new Date());
        department.setIsdelete(true);
        departmentMapper.insertSelective(department);
    }

    @Override
    public Department findByPrimaryKey(int departmentId) {
        return departmentMapper.selectByPrimaryKey(departmentId);
    }

    @Override
    public void update(Department department) {
        departmentMapper.updateByPrimaryKeySelective(department);
    }

    @Override
    public HashMap<String, Object> searchOwn(Integer userId, Integer currentPage) {
        PageHelper.startPage(currentPage, 15);
        DepartmentExample example = new DepartmentExample();
        DepartmentExample.Criteria criteria = example.createCriteria();
        criteria.andIsdeleteEqualTo(true);
        criteria.andDepartorIdEqualTo(userId);
        List<Department> list = departmentMapper.selectByExample(example);
        System.out.println(list);
        PageInfo<Department> info = new PageInfo<>(list);
        HashMap<String, Object> map = new HashMap<>();
        map.put("list", list);
        map.put("info", info);

        return map;

    }
}

package com.woniu.jiapei.service;

import com.woniu.jiapei.condition.DepartmentCondition;
import com.woniu.jiapei.model.Department;
import com.woniu.jiapei.model.Hospital;

import java.util.HashMap;
import java.util.List;

public interface DepartmentService {
    List<Department> findAll();

    HashMap<String, Object> findBySearch(DepartmentCondition hospitalSearch, Integer currentPage);

    List<Hospital> findHospitals();

    boolean delete(int id);

    void insert(Department department);

    Department findByPrimaryKey(int departmentId);

    void update(Department department);
}

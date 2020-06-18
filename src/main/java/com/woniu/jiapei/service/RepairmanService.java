package com.woniu.jiapei.service;

import com.woniu.jiapei.model.Department;
import com.woniu.jiapei.model.Fault;
import com.woniu.jiapei.model.Hospital;
import com.woniu.jiapei.model.Repairman;

import java.util.List;

public interface RepairmanService {
    List<Repairman> findHospital(int userinfoId);

    Integer countHospital(int userinfoId);

    void deleteDeptment(int departmentId);


    List<Hospital> getHospitals();

    List<Department> getDeprtments(int hospitalId);


    List<Fault> getRepair(int userinfoId);

    Integer countRepair(int userinfoId);

    void RepairAddDepartment(int repairManId,String[] department);
}

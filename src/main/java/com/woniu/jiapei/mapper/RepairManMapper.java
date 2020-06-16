package com.woniu.jiapei.mapper;

import java.util.List;

import com.woniu.jiapei.model.Repairman;
import com.woniu.jiapei.model.RepairmanExample;
import org.apache.ibatis.annotations.Param;

public interface RepairmanMapper {
    int countByExample(RepairmanExample example);

    int deleteByExample(RepairmanExample example);

    int insert(Repairman record);

    int insertSelective(Repairman record);

    List<Repairman> selectByExample(RepairmanExample example);

    int updateByExampleSelective(@Param("record") Repairman record, @Param("example") RepairmanExample example);

    int updateByExample(@Param("record") Repairman record, @Param("example") RepairmanExample example);

    Integer countHospital(int userinfoId);
}
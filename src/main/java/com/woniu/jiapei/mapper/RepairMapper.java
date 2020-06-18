package com.woniu.jiapei.mapper;

import com.woniu.jiapei.condition.RepairCondition;
import com.woniu.jiapei.model.Repair;
import com.woniu.jiapei.model.RepairExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RepairMapper {
    Repair findByFaultId(Integer faultId);
    int countByExample(RepairExample example);

    int deleteByExample(RepairExample example);

    int deleteByPrimaryKey(String repairId);

    int insert(Repair record);

    int insertSelective(Repair record);

    List<Repair> selectByExampleWithBLOBs(RepairExample example);

    List<Repair> selectByExample(RepairExample example);

    Repair selectByPrimaryKey(String repairId);

    int updateByExampleSelective(@Param("record") Repair record, @Param("example") RepairExample example);

    int updateByExampleWithBLOBs(@Param("record") Repair record, @Param("example") RepairExample example);

    int updateByExample(@Param("record") Repair record, @Param("example") RepairExample example);

    int updateByPrimaryKeySelective(Repair record);

    int updateByPrimaryKeyWithBLOBs(Repair record);

    int updateByPrimaryKey(Repair record);

    List<Repair> findAll(RepairCondition repairCondition);
}
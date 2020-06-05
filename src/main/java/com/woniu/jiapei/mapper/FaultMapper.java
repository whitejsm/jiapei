package com.woniu.jiapei.mapper;

import com.woniu.jiapei.model.Fault;
import com.woniu.jiapei.model.FaultExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FaultMapper {
    int countByExample(FaultExample example);

    int deleteByExample(FaultExample example);

    int deleteByPrimaryKey(Integer faultId);

    int insert(Fault record);

    int insertSelective(Fault record);

    List<Fault> selectByExampleWithBLOBs(FaultExample example);

    List<Fault> selectByExample(FaultExample example);

    Fault selectByPrimaryKey(Integer faultId);

    int updateByExampleSelective(@Param("record") Fault record, @Param("example") FaultExample example);

    int updateByExampleWithBLOBs(@Param("record") Fault record, @Param("example") FaultExample example);

    int updateByExample(@Param("record") Fault record, @Param("example") FaultExample example);

    int updateByPrimaryKeySelective(Fault record);

    int updateByPrimaryKeyWithBLOBs(Fault record);

    int updateByPrimaryKey(Fault record);
}
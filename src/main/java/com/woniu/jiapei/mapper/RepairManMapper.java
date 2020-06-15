package com.woniu.jiapei.mapper;

import com.woniu.jiapei.model.RepairMan;
import com.woniu.jiapei.model.RepairManExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RepairManMapper {
    int countByExample(RepairManExample example);

    int deleteByExample(RepairManExample example);

    int insert(RepairMan record);

    int insertSelective(RepairMan record);

    List<RepairMan> selectByExample(RepairManExample example);

    int updateByExampleSelective(@Param("record") RepairMan record, @Param("example") RepairManExample example);

    int updateByExample(@Param("record") RepairMan record, @Param("example") RepairManExample example);
}

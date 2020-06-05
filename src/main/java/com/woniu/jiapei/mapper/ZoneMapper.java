package com.woniu.jiapei.mapper;

import com.woniu.jiapei.model.Zone;
import com.woniu.jiapei.model.ZoneExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZoneMapper {
    int countByExample(ZoneExample example);

    int deleteByExample(ZoneExample example);

    int insert(Zone record);

    int insertSelective(Zone record);

    List<Zone> selectByExample(ZoneExample example);

    int updateByExampleSelective(@Param("record") Zone record, @Param("example") ZoneExample example);

    int updateByExample(@Param("record") Zone record, @Param("example") ZoneExample example);
}
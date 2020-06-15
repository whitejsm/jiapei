package com.woniu.jiapei.mapper;

import com.woniu.jiapei.model.Zone;
import com.woniu.jiapei.model.ZoneExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZoneMapper {
    List findByCityId(int cityId);

    int countByExample(ZoneExample example);

    int deleteByExample(ZoneExample example);

    int deleteByPrimaryKey(Integer zoneId);

    int insert(Zone record);

    int insertSelective(Zone record);

    List<Zone> selectByExample(ZoneExample example);

    Zone selectByPrimaryKey(Integer zoneId);

    int updateByExampleSelective(@Param("record") Zone record, @Param("example") ZoneExample example);

    int updateByExample(@Param("record") Zone record, @Param("example") ZoneExample example);

    int updateByPrimaryKeySelective(Zone record);

    int updateByPrimaryKey(Zone record);
}

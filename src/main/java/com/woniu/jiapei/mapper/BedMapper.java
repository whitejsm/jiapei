package com.woniu.jiapei.mapper;

import com.woniu.jiapei.condition.BedCondition;
import com.woniu.jiapei.condition.VisibleReportOccupancyCondition;
import com.woniu.jiapei.model.Bed;
import com.woniu.jiapei.model.BedExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BedMapper {
    List<Bed> findByExample(BedCondition bedCondition);

    int countByExample(BedExample example);

    int deleteByExample(BedExample example);

    int deleteByPrimaryKey(String bedId);

    int insert(Bed record);

    int insertSelective(Bed record);
    List<Bed> findAll();
    List<Bed> selectByExample(BedExample example);

    Bed selectByPrimaryKey(String bedId);

    int updateByExampleSelective(@Param("record") Bed record, @Param("example") BedExample example);

    int updateByExample(@Param("record") Bed record, @Param("example") BedExample example);

    int updateByPrimaryKeySelective(Bed record);

    int updateByPrimaryKey(Bed record);

    Bed findBedById(String bedId);

    List<Integer> getCountByCondition(VisibleReportOccupancyCondition condition);

    List<String> getDateListByCondition(VisibleReportOccupancyCondition condition);
}
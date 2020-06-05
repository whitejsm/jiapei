package com.woniu.jiapei.mapper;

import com.woniu.jiapei.model.OperationModule;
import com.woniu.jiapei.model.OperationModuleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OperationModuleMapper {
    int countByExample(OperationModuleExample example);

    int deleteByExample(OperationModuleExample example);

    int deleteByPrimaryKey(Integer modelId);

    int insert(OperationModule record);

    int insertSelective(OperationModule record);

    List<OperationModule> selectByExample(OperationModuleExample example);

    OperationModule selectByPrimaryKey(Integer modelId);

    int updateByExampleSelective(@Param("record") OperationModule record, @Param("example") OperationModuleExample example);

    int updateByExample(@Param("record") OperationModule record, @Param("example") OperationModuleExample example);

    int updateByPrimaryKeySelective(OperationModule record);

    int updateByPrimaryKey(OperationModule record);
}
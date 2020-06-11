package com.woniu.jiapei.mapper;

import com.woniu.jiapei.model.Hospital;
import com.woniu.jiapei.model.HospitalExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HospitalMapper {
    int countByExample(HospitalExample example);

    int deleteByExample(HospitalExample example);

    int deleteByPrimaryKey(Integer hospitalId);

    int insert(Hospital record);

    int insertSelective(Hospital record);

    List<Hospital> selectByExample(HospitalExample example);

    Hospital selectByPrimaryKey(Integer hospitalId);

    int updateByExampleSelective(@Param("record") Hospital record, @Param("example") HospitalExample example);

    int updateByExample(@Param("record") Hospital record, @Param("example") HospitalExample example);

    int updateByPrimaryKeySelective(Hospital record);

    int updateByPrimaryKey(Hospital record);

    Hospital findOneWithDepartment(Integer hospitalId);
}
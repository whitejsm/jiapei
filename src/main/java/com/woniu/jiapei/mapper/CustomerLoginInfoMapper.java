package com.woniu.jiapei.mapper;

import com.woniu.jiapei.model.CustomerLoginInfo;
import com.woniu.jiapei.model.CustomerLoginInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerLoginInfoMapper {
    int countByExample(CustomerLoginInfoExample example);

    int deleteByExample(CustomerLoginInfoExample example);

    int deleteByPrimaryKey(Integer customerId);

    int insert(CustomerLoginInfo record);

    int insertSelective(CustomerLoginInfo record);

    List<CustomerLoginInfo> selectByExample(CustomerLoginInfoExample example);

    CustomerLoginInfo selectByPrimaryKey(Integer customerId);

    int updateByExampleSelective(@Param("record") CustomerLoginInfo record, @Param("example") CustomerLoginInfoExample example);

    int updateByExample(@Param("record") CustomerLoginInfo record, @Param("example") CustomerLoginInfoExample example);

    int updateByPrimaryKeySelective(CustomerLoginInfo record);

    int updateByPrimaryKey(CustomerLoginInfo record);
}
package com.woniu.jiapei.mapper;

import com.woniu.jiapei.condition.CustomerCondition;
import com.woniu.jiapei.model.Customer;
import com.woniu.jiapei.model.CustomerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerMapper {
    int countByExample(CustomerExample example);

    int deleteByExample(CustomerExample example);

    int deleteByPrimaryKey(Integer customerId);

    int insert(Customer record);

    int insertSelective(Customer record);

    List<Customer> selectByExample(CustomerExample example);

    Customer selectByPrimaryKey(Integer customerId);

    int updateByExampleSelective(@Param("record") Customer record, @Param("example") CustomerExample example);

    int updateByExample(@Param("record") Customer record, @Param("example") CustomerExample example);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);

    Integer countCustomer();

    List<Customer> getCusetomerByCondition(CustomerCondition customerCondition);

    List<Customer> downByCondition(CustomerCondition customerCondition);
}
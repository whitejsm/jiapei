package com.woniu.jiapei.mapper;

import com.woniu.jiapei.model.MessageType;
import com.woniu.jiapei.model.MessageTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MessageTypeMapper {
    int countByExample(MessageTypeExample example);

    int deleteByExample(MessageTypeExample example);

    int deleteByPrimaryKey(Integer messageTypeId);

    int insert(MessageType record);

    int insertSelective(MessageType record);

    List<MessageType> selectByExample(MessageTypeExample example);

    MessageType selectByPrimaryKey(Integer messageTypeId);

    int updateByExampleSelective(@Param("record") MessageType record, @Param("example") MessageTypeExample example);

    int updateByExample(@Param("record") MessageType record, @Param("example") MessageTypeExample example);

    int updateByPrimaryKeySelective(MessageType record);

    int updateByPrimaryKey(MessageType record);
}
package com.woniu.jiapei.mapper;

import com.woniu.jiapei.model.MessageList;
import com.woniu.jiapei.model.MessageListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MessageListMapper {
    int countByExample(MessageListExample example);

    int deleteByExample(MessageListExample example);

    int deleteByPrimaryKey(Integer messageListId);

    int insert(MessageList record);

    int insertSelective(MessageList record);

    List<MessageList> selectByExampleWithBLOBs(MessageListExample example);

    List<MessageList> selectByExample(MessageListExample example);

    MessageList selectByPrimaryKey(Integer messageListId);

    int updateByExampleSelective(@Param("record") MessageList record, @Param("example") MessageListExample example);

    int updateByExampleWithBLOBs(@Param("record") MessageList record, @Param("example") MessageListExample example);

    int updateByExample(@Param("record") MessageList record, @Param("example") MessageListExample example);

    int updateByPrimaryKeySelective(MessageList record);

    int updateByPrimaryKeyWithBLOBs(MessageList record);

    int updateByPrimaryKey(MessageList record);
}
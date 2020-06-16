package com.woniu.jiapei.mapper;

import com.woniu.jiapei.model.MessageDetails;
import com.woniu.jiapei.model.MessageDetailsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MessageDetailsMapper {
    int countByExample(MessageDetailsExample example);

    int deleteByExample(MessageDetailsExample example);

    int deleteByPrimaryKey(Integer messageDetailId);

    int insert(MessageDetails record);

    int insertSelective(MessageDetails record);

    List<MessageDetails> selectByExampleWithBLOBs(MessageDetailsExample example);

    List<MessageDetails> selectByExample(MessageDetailsExample example);

    MessageDetails selectByPrimaryKey(Integer messageDetailId);

    int updateByExampleSelective(@Param("record") MessageDetails record, @Param("example") MessageDetailsExample example);

    int updateByExampleWithBLOBs(@Param("record") MessageDetails record, @Param("example") MessageDetailsExample example);

    int updateByExample(@Param("record") MessageDetails record, @Param("example") MessageDetailsExample example);

    int updateByPrimaryKeySelective(MessageDetails record);

    int updateByPrimaryKeyWithBLOBs(MessageDetails record);
}
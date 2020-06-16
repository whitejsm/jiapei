package com.woniu.jiapei.mapper;

import com.woniu.jiapei.model.Shareholder;
import com.woniu.jiapei.model.ShareholderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShareholderMapper {
    int countByExample(ShareholderExample example);

    int deleteByExample(ShareholderExample example);

    int deleteByPrimaryKey(Integer userinfoId);

    int insert(Shareholder record);

    int insertSelective(Shareholder record);

    List<Shareholder> selectByExample(ShareholderExample example);

    Shareholder selectByPrimaryKey(Integer userinfoId);

    int updateByExampleSelective(@Param("record") Shareholder record, @Param("example") ShareholderExample example);

    int updateByExample(@Param("record") Shareholder record, @Param("example") ShareholderExample example);

    int updateByPrimaryKeySelective(Shareholder record);

    int updateByPrimaryKey(Shareholder record);
}
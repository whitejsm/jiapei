package com.woniu.jiapei.mapper;

import com.woniu.jiapei.model.UserLoginInfo;
import com.woniu.jiapei.model.UserLoginInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserLoginInfoMapper {
    int countByExample(UserLoginInfoExample example);

    int deleteByExample(UserLoginInfoExample example);

    int deleteByPrimaryKey(Integer userinfoId);

    int insert(UserLoginInfo record);

    int insertSelective(UserLoginInfo record);

    List<UserLoginInfo> selectByExample(UserLoginInfoExample example);

    UserLoginInfo selectByPrimaryKey(Integer userinfoId);

    int updateByExampleSelective(@Param("record") UserLoginInfo record, @Param("example") UserLoginInfoExample example);

    int updateByExample(@Param("record") UserLoginInfo record, @Param("example") UserLoginInfoExample example);

    int updateByPrimaryKeySelective(UserLoginInfo record);

    int updateByPrimaryKey(UserLoginInfo record);
}